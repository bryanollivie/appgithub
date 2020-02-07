package com.bryanollivie.examplemodule.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bryanollivie.examplemodule.R
import com.bryanollivie.sdk.data.remote.ApiService
import com.bryanollivie.sdk.data.remote.model.BodyResponse
import com.bryanollivie.sdk.data.remote.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesViewModel : ViewModel() {

    val repositoryLiveData: MutableLiveData<List<Repository>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getRepositories() {
        ApiService.SERVICE.getRepositories().enqueue(object : Callback<BodyResponse> {
            override fun onResponse(call: Call<BodyResponse>, response: Response<BodyResponse>) {
                when {
                    response.isSuccessful -> {
                        val repositories: MutableList<Repository> = mutableListOf()

                        response.body()?.let { response ->
                            repositories.addAll(response.items)
                        }

                        repositoryLiveData.value = repositories
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER, null)
                    }
                    response.code() == 401 -> viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_401)
                    else -> viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_400_generic)
                }
            }

            override fun onFailure(call: Call<BodyResponse>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_500_generic)
            }
        })
    }

    companion object {
        private const val VIEW_FLIPPER = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}
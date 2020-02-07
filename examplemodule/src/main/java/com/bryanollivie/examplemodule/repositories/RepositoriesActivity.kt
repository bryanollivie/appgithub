package com.bryanollivie.examplemodule.repositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bryanollivie.examplemodule.R
import kotlinx.android.synthetic.main.activity_repositories.*

class RepositoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)


        val viewModel: RepositoriesViewModel = ViewModelProviders.of(this).get(RepositoriesViewModel::class.java)

        viewModel.repositoryLiveData.observe(this, Observer {
            it?.let { repositories ->
                with(recyclerRepositories) {
                    layoutManager = LinearLayoutManager(this@RepositoriesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = RepositoryAdapter(repositories) { repository ->
                    }
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                viewFlipperRepository.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageResId ->
                    textViewError.text = getString(errorMessageResId)
                }
            }
        })

        viewModel.getRepositories()

    }
}

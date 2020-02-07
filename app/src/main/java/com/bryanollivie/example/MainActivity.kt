package com.bryanollivie.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bryanollivie.examplemodule.repositories.RepositoriesActivity
import com.bryanollivie.sdk.extensions.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity<RepositoriesActivity>()
    }
}

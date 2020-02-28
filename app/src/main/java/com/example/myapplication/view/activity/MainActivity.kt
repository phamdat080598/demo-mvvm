package com.example.myapplication.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.mvvm.model.Category
import com.example.myapplication.mvvm.viewmodel.CategoryViewModel

class MainActivity : AppCompatActivity() {

    private var category = Category()

    private lateinit var viewModel : CategoryViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        binding.category=category
        binding.lifecycleOwner=this
        observeViewModel()
        viewModel.getCategoryById("18","Bearer CMfqypJoyUxqo6qkF0vI")
    }

    private fun observeViewModel(){
        viewModel.category.observe(this, Observer {
            category.id=it.id
            category.image = it.image
            category.name = it.name
            category.type = it.type
            //category = it
        })
        viewModel.messageResponse.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
}

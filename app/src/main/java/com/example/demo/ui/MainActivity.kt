package com.example.demo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demo.R
import com.example.demo.databinding.ActivityMainBinding
import com.example.demo.repository.HomeRepository
import com.example.demo.ui.viewmodels.HomeViewModelFactory
import com.example.demo.ui.viewmodels.HomeViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(R.layout.activity_main, null)
        binding = ActivityMainBinding.bind(view)
        setContentView(binding.root)
        binding.lifecycleOwner = this


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navHostController = navHostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navHostController)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
//        val homeRepository = HomeRepository()
//        val homeViewModelFactory = HomeViewModelFactory(homeRepository, application)
//        homeViewModel = ViewModelProvider(this,homeViewModelFactory)[HomeViewModel::class.java]


    }
}
package com.example.demo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demo.R
import com.example.demo.adapter.ListProductAdapter
import com.example.demo.api.BaseResponse
import com.example.demo.databinding.FragmentHomeBinding
import com.example.demo.models.ListProductResponse
import com.example.demo.ui.MainActivity


class HomeFragment : Fragment() {
    private  val TAG = "HomeFragment"
    lateinit var binding: FragmentHomeBinding
    lateinit var listProductAdapter: ListProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        
        val homeViewModel = (activity as MainActivity).homeViewModel
        
        homeViewModel.listProductResult.observe(viewLifecycleOwner, Observer {
            when(it){
                is BaseResponse.Success ->{
                    hideLoading()
                    it.data?.let {
                        updateData(it)
                    }
                }
                is  BaseResponse.Error ->{
                    hideLoading()
                }
                is  BaseResponse.Loading ->{
                    showLoading()
                }
            }
        })

    }

    private fun updateData(it: ListProductResponse) {
        it.products.let {
            listProductAdapter.updateData(it)
        }
    }

    private fun initView() {
        listProductAdapter = ListProductAdapter()
        binding.rvListProduct.apply {
            adapter = listProductAdapter
            layoutManager = GridLayoutManager(activity,2)
        }
    }



    private fun showLoading(){
        
    }
    private fun hideLoading(){
        
    }
    
    

}
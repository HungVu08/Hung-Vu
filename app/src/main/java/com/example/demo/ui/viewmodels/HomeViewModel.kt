package com.example.demo.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.api.BaseResponse
import com.example.demo.models.ListProductResponse
import com.example.demo.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel() : ViewModel() {

    var homeRepository: HomeRepository
//
//    val listProductResult: MutableLiveData<BaseResponse<ListProductResponse>> = MutableLiveData()
//    var listProductResponse : ListProductResponse? = null

    init {
        homeRepository = HomeRepository()
        getListProduct()

    }

    fun getListProduct(){
        viewModelScope.launch(Dispatchers.IO) {
//            listProductResult.postValue(BaseResponse.Loading())
//            val res = homeRepository.getListProduct()
//            println(res)

            Log.e("AAA",homeRepository.getListProduct().body().toString())

        }

//           listProductResult.postValue(handlerListProduct(result))
//
//
//        CoroutineScope(Dispatchers.IO).launch {
//
//        }

    }

//    private fun handlerListProduct(response : Response<ListProductResponse>) : BaseResponse<ListProductResponse>{
//       if (response.isSuccessful && response.code() == 200){
//           response.body()?.let {data->
//               listProductResponse = data
//
//               return BaseResponse.Success(data)
//           }
//       }
//        return BaseResponse.Error(null, "load failed")
//    }
}
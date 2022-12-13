package com.example.bauweek9.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bauweek9.data.model.UserModel
import com.example.bauweek9.data.remote.ApiService
import com.example.bauweek9.data.remote.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {
    private lateinit var service: ApiService
    private val _userList = MutableLiveData<List<UserModel>>()
    val userList: LiveData<List<UserModel>>
        get() = _userList

    fun getUserList() = viewModelScope.launch(Dispatchers.IO) {
        service = ApiUtils.getApiService()
        //first choice
        /* service.getAllUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                 val list = response.body()?.results
                 list?.let {
                     _userList.postValue(it)
                 }
             }
             override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                 Log.e("RETROFIT FAIL", t.message.toString())
             }
         })
         */
        //second choice
        try {
            val data = service.getAllUsers()
            data?.let {
                _userList.postValue(it.body()?.results)
            }

        } catch (e: Exception) {
            Log.e("RETROFIT ERROR", e.message.toString())
        }
    }
}
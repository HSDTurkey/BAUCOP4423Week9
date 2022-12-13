package com.example.bauweek9.data.remote

import com.example.bauweek9.util.Constants

class ApiUtils {
    companion object {
         fun getApiService(): ApiService {
            return RetrofitClient.getClient(Constants.BASE_URL).create(ApiService::class.java)
        }
    }
}


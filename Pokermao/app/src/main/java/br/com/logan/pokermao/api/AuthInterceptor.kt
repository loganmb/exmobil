package br.com.logan.pokermao.api

import android.util.Log

class AuthInterceptor : Interceptor{
    override fun intercept(chain : Interceptor.Chain?):Response{
        val requestBuilder = chain!!.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Basic cG9rZWFwaTpwb2tlbW9u")
        val request = requestBuilder.build()
        val response = chain.proceed(request)
        if(response.code() == 401){
            Log.e("MEUAPP", "Error API KEY")
        }
        return response
    }
}
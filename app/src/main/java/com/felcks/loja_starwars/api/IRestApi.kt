package com.felcks.loja_starwars.api

import com.felcks.loja_starwars.model_api.ProdutoDataResponse
import retrofit2.Call
import retrofit2.http.GET

interface IRestApi {

    @GET("products.json")
    fun getListagemObras(): Call<List<ProdutoDataResponse>>
}
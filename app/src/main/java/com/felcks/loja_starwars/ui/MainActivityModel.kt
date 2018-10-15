package com.felcks.loja_starwars.ui

import android.util.Log
import com.felcks.loja_starwars.api.RestApi
import com.felcks.loja_starwars.domain.Produto
import rx.Observable

class MainActivityModel(val presenter: Mvp.Presenter): Mvp.Model {

    val api = RestApi()

    override fun carregarLista(): Observable<List<Produto>> {

        return Observable.create { subscriber ->
            val callResponse = api.carregarItens()
            val response = callResponse.execute()

            if (response.isSuccessful && response.body() != null) {

                val itens: List<Produto> = response.body().map {

                    Produto(it.title ?: "",
                            it.price ?: 0.0,
                            it.seller ?: "",
                            it.thumbnailHd ?: "")
                }

                subscriber.onNext(itens)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}
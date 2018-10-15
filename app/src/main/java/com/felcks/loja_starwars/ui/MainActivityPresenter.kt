package com.felcks.loja_starwars.ui

import com.felcks.loja_starwars.domain.Produto
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.*

class MainActivityPresenter(val view: Mvp.View): Mvp.Presenter {

    private var subscriptions = CompositeSubscription()

    private val model: Mvp.Model by lazy<Mvp.Model>{
        MainActivityModel(this)
    }


    override fun carregarLista() {

        val subscription = model.carregarLista()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { itens ->
                            view.showList(itens)
                        },
                        { e ->

                        }
                )
        subscriptions.add(subscription)
    }
}
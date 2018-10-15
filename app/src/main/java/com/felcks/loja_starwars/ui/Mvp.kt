package com.felcks.loja_starwars.ui

import com.felcks.loja_starwars.domain.Produto
import rx.Observable

interface Mvp {

    interface View {

        fun showList(itens: List<Produto>)
    }

    interface Presenter {

        fun carregarLista()
    }

    interface Model {

        fun carregarLista(): Observable<List<Produto>>
    }
}
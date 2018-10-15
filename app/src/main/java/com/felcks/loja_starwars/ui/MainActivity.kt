package com.felcks.loja_starwars.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.felcks.loja_starwars.R
import com.felcks.loja_starwars.domain.Produto
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Mvp.View {

    private val presenter: Mvp.Presenter by lazy<Mvp.Presenter>{
        MainActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_carregar.setOnClickListener {
            presenter.carregarLista()
        }
    }

    override fun showList(itens: List<Produto>) {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rv.layoutManager = layoutManager
        val adapter  = ProdutoAdapter(this, itens as MutableList<Produto>)
        rv.adapter = adapter
    }
}

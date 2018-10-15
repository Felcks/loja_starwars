package com.felcks.loja_starwars.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.felcks.loja_starwars.R
import com.felcks.loja_starwars.domain.Produto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_produto.view.*
import org.w3c.dom.Text

class ProdutoAdapter(val context: Context,
                     val produtos: MutableList<Produto>): RecyclerView.Adapter<ProdutoAdapter.MyViewHolder>() {


    val mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val produto = produtos[position]

        holder?.itemView?.tv_title.text = produto.nome
        holder?.itemView?.tv_preco.text = produto.preco.toString()
        holder?.itemView?.tv_vendedor.text = produto.vendedor

        Picasso.with(context).load(produto.foto).into(holder?.itemView?.iv_foto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): MyViewHolder {

        val view: View = mLayoutInflater.inflate(R.layout.item_produto, parent, false)
        val mvh = MyViewHolder(view)

        return mvh
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}

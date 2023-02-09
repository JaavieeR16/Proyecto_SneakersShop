package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarcasAdapter (val listado_marcas:List<Marcas>): RecyclerView.Adapter<MarcasAdapter.ViewHolder>(){
    val imgMarcas = intArrayOf(
        R.drawable.adidas,
        R.drawable.nike,
        R.drawable.converse,
        R.drawable.vans,
        R.drawable.newbalance,
        R.drawable.gucci,
        R.drawable.luoisvuitton,
        R.drawable.offwhite,
        R.drawable.chanel,
        R.drawable.balenciaga,
        R.drawable.crocs
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        val holder = ViewHolder(v)
        v.setOnClickListener{
            val position = holder.adapterPosition
            listado_marcas[position].let { listener(it, position)}
        }
        return holder
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemNombre: TextView

        init {
            itemImage = itemView.findViewById(R.id.iv_Card)
            itemNombre = itemView.findViewById(R.id.tv_Card)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNombre.setText(listado_marcas[position].marca)
        holder.itemImage.setImageResource(imgMarcas[position])
    }

    override fun getItemCount(): Int {
        return listado_marcas.size
    }

    private var listener:(l: Marcas, pos: Int) -> Unit = { _, _ -> }

    fun setOnItemClickListener(listener: (l: Marcas, pos: Int) -> Unit){
        this.listener= listener //Guardamos una referencia al listener
    }
}
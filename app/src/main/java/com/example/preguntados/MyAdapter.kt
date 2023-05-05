package com.example.preguntados

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    val listaPuntuacion: List<ListaPreguntas>,

):RecyclerView.Adapter<PreguntasHolder>() {

    //Definimos su metedo create estableciendo su layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntasHolder(layoutInflater.inflate(R.layout.item_lista,parent, false))
    }
    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: PreguntasHolder, position: Int) {
        val item = listaPuntuacion[position]
        holder.render(item)
    }
    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int {
        return listaPuntuacion.size

    }
}
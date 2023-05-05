package com.example.preguntados

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.preguntados.entidades.Pregunta


class MyAdapter() : RecyclerView.Adapter<PreguntasHolder>() {

    private lateinit var context: Context
    private lateinit var cursor: Cursor

    fun SQLRecyclerViewAdapter(context: Context, cursor: Cursor) {
        this.context = context
        this.cursor = cursor
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreguntasHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PreguntasHolder(layoutInflater.inflate(R.layout.item_lista, parent, false))
    }

    //Renederizamos cada elemento de la lista
    override fun onBindViewHolder(holder: PreguntasHolder, position: Int) {
        cursor.moveToPosition(position)
        var p = Pregunta(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5))
        holder.render(p)
    }

    //Obtenemos el tamaño de la lista
    override fun getItemCount(): Int {
        return cursor.count

    }

}
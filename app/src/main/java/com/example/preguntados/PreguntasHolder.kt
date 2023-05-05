package com.example.preguntados

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.preguntados.entidades.Pregunta

class PreguntasHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val pregunta_id = itemView.findViewById<TextView>(R.id.twId)
    val pregunta_texto = itemView.findViewById<TextView>(R.id.twPregunta)

    fun render(p: Pregunta) {
        pregunta_id.text = p.id.toString()
        pregunta_texto.text = p.texto

    }

}
package com.example.preguntados

import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.io.File


class PreguntasHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textView = view.findViewById<TextView>(R.id.twPregunta)

    fun render(
        lista: ListaDataClass,

    ) {

        textView.text = lista.titulo
        textView.text = lista.pregunta
        textView.text = lista.respuesta

    }

}
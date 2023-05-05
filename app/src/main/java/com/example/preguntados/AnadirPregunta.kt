package com.example.preguntados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.preguntados.databinding.ActivityAnadirPreguntaBinding
import com.example.preguntados.databinding.ActivityListaPreguntasBinding

class AnadirPregunta : AppCompatActivity() {

    lateinit var binding: ActivityAnadirPreguntaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_pregunta)
        binding = ActivityAnadirPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLista.setOnClickListener{lista()}
        binding.btAnadir.setOnClickListener{anadir()}
    }

    fun lista(){
        val intent = Intent(this, AnadirPregunta::class.java).apply {

        }
        startActivity(intent)
    }

    fun anadir(){

    }
}
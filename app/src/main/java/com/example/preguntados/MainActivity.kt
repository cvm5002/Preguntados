package com.example.preguntados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.preguntados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btListaPreguntas.setOnClickListener{listaPreguntas()}

    }

    fun listaPreguntas(){
        val intent = Intent(this, ListaPreguntas::class.java).apply {

        }
        startActivity(intent)
    }
}
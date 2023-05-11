package com.example.preguntados

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.preguntados.databinding.ActivityAnadirPreguntaBinding

class AnadirPregunta : AppCompatActivity() {

    lateinit var binding: ActivityAnadirPreguntaBinding
    lateinit var texto: String
    lateinit var respuesta1: String
    lateinit var respuesta2: String
    lateinit var respuesta3: String
    lateinit var respuesta4: String
    lateinit var preguntasDBHelper: MyBDOpenHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_pregunta)
        //Binding
        binding = ActivityAnadirPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Llamado de funciones
        binding.btLista.setOnClickListener{lista()}
        binding.btAnadir.setOnClickListener{anadir()}

    }

    fun lista(){
        val intent = Intent(this, ListaPreguntas::class.java).apply {

        }
        startActivity(intent)
    }

    fun anadir(){

        preguntasDBHelper = MyBDOpenHelper(this, null)


        //Llamo a los datos
        texto = binding.etPregunta.text.toString()
        respuesta1 = binding.etRespuesta1.text.toString()
        respuesta2 = binding.etRespuesta2.text.toString()
        respuesta3 = binding.etRespuesta3.text.toString()
        respuesta4 = binding.etRespuesta4.text.toString()

        preguntasDBHelper.insertarPregunta(texto, respuesta1, respuesta2, respuesta3, respuesta4)
    }
}
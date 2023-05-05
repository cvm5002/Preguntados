package com.example.preguntados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.preguntados.databinding.ActivityListaPreguntasBinding
import com.example.preguntados.entidades.Pregunta

class ListaPreguntas : AppCompatActivity() {

    private lateinit var myAdapter: MyAdapter
    private lateinit var binding: ActivityListaPreguntasBinding
    private lateinit var preguntasDBHelper: MyBDOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_preguntas)
        binding = ActivityListaPreguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        //Inicializamos
        preguntasDBHelper = MyBDOpenHelper(this, null)
        //Obtnemos las notas de la base de datos
        val cursor = preguntasDBHelper.obtenerPregunta()
        myAdapter = MyAdapter()
        myAdapter.SQLRecyclerViewAdapter(this, cursor)

        //Configuramos el RecylcerView
        binding.rvPreguntas.setHasFixedSize(true)
        binding.rvPreguntas.layoutManager = LinearLayoutManager(this)
        binding.rvPreguntas.adapter = myAdapter
    }

}
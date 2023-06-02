package com.example.preguntados.fragmentos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.preguntados.R
import com.example.preguntados.databinding.ActivityMainBinding
import com.example.preguntados.databinding.ActivityQuizzBinding
import com.example.preguntados.databinding.FragmentPreguntaBinding


class FragmentPregunta : Fragment() {
    lateinit var binding: FragmentPreguntaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPreguntaBinding.inflate(layoutInflater)

        //Si la respuesta es igual a la correcta. Te manda a acierto sino es correcto a fallo.
        if (binding.cbRespuesta1.isChecked){
            binding.btContinuar.setOnClickListener(mostrarAcierto())
        }else{
            binding.btContinuar.setOnClickListener(mostrarFallo())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pregunta, container, false)
    }

    fun mostrarAcierto(){
        intent = Intent(this, FragmentPregunta::class.java).apply{

        }
        startActivity(intent)
    }

    fun mostrarFallo(){

    }
}
package com.example.preguntados.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.preguntados.R
import com.example.preguntados.databinding.FragmentPreguntaBinding


class FragmentPregunta : Fragment() {
    lateinit var binding: FragmentPreguntaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPreguntaBinding.inflate(layoutInflater)

        //Si la respuesta es igual a la correcta. Te manda a acierto sino es correcto a fallo.
        if (binding.cbRespuesta1.isChecked){
            binding.btContinuar.setOnClickListener{replaceFragmentAcierto()}
        }else{
            binding.btContinuar.setOnClickListener{replaceFragmentFallo()}
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.preguntados.R.layout.fragment_pregunta, container, false)
    }

    fun replaceFragmentAcierto() {
        val fragment = FragmentAcierto()
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.addToBackStack(null)

        fragmentTransaction.commit()
    }

    fun replaceFragmentFallo() {
        val fragment = FragmentFallo()
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.addToBackStack(null)

        fragmentTransaction.commit()
    }
}
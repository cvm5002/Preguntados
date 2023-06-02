package com.example.preguntados.fragmentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.preguntados.R
import com.example.preguntados.databinding.ActivityQuizzBinding

class ActivityQuizz : AppCompatActivity() {
    lateinit var binding: ActivityQuizzBinding;


    private val marcadorViewModel: MarcadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizzBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btEmpezar.setOnClickListener {
            mostrarPregunta()
        }

        val nameObserver = Observer<Int> { valor ->
            // Update the UI, in this case, a TextView.
            //binding.tvMarcador?.setText(valor.toString())
        }
        marcadorViewModel.getMarcador().observe(this, nameObserver)
    }

    /////////////////////////////////////////////////////
    private fun mostrarPregunta(){
        intent = Intent(this, FragmentPregunta::class.java).apply {

        }
        startActivity(intent)
    }
    /////////////////////////////////////////////////////

}
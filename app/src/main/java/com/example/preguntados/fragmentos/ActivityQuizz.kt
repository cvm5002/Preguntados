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
    private fun mostrarFragmentoAcierto (){

        //Se establece la transaccion de fragments, necesarios para añadir
        //quitar o reemplazar gragments
        val transaction= supportFragmentManager.beginTransaction()
        //se instancia el fragment a mostrar
        val fragmento1 = FragmentAcierto()
        //Indicamos el elemneto del layout donde haremos el cambio
        transaction.replace(R.id.fragmentContainerView,fragmento1)
        //Se establece valor a null para inidcar que no se está interesado
        //En volver a ese fragmento más tarde, en caso contrario,
        //se indicaría el nombre del fragmento, por ejemplo gragment.TAG,
        //aprovechando la variable creada en la clase
        transaction.addToBackStack(null)
        //se muestra el fragment
        transaction.commit()
    }

    //////////////////////////////////////////////////////

    private fun mostrarFragmentoFallo (){

        val transaction= supportFragmentManager.beginTransaction()
        val fragmento2 = FragmentFallo()

        transaction.replace(R.id.fragmentContainerView,fragmentoFallo)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
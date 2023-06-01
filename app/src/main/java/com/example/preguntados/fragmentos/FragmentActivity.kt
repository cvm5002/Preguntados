package com.example.superheroapplication.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.preguntados.R
import com.example.superheroapplication.R
import com.example.superheroapplication.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var binding:ActivityFragmentBinding


    private val marcadorViewModel: MarcadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonFragmento1.setOnClickListener {
            mostrarFragmentoAcierto()
        }
        binding.buttonFragmento2.setOnClickListener{
            mostrarFragmentoFallo()
        }


        val nameObserver = Observer<Int> { valor ->
            // Update the UI, in this case, a TextView.
            binding.tvMarcador?.setText(valor.toString())
        }
        marcadorViewModel.getMarcador().observe(this, nameObserver)
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
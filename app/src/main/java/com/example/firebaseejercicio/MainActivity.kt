package com.example.firebaseejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var busqueda:TextView
    lateinit var busquedaInput:EditText
    lateinit var buscar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idInstance()

        busquedaInput.hint = "Introduzca busqueda aquí"
        buscar.setOnClickListener (object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var texto = busquedaInput.text
                busqueda.text = texto
                
            }
        })




    }

    private fun idInstance(){
        buscar = findViewById(R.id.submit)

        busqueda = findViewById(R.id.busqueda)
        busquedaInput = findViewById(R.id.inputBusqueda)
    }
}
package com.example.firebaseejercicio

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var busqueda:TextView
    lateinit var busquedaInput:EditText
    lateinit var buscar:Button
    lateinit var myRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idInstance()
        database()

        busquedaInput.hint = "Introduzca busqueda aquí"

    }

    private fun database(){
        val database = Firebase.database("https://bdpruebas2-default-rtdb.europe-west1.firebasedatabase.app")
        myRef = database.getReference("hello1")
        buscar.setOnClickListener (object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var texto = busquedaInput.text.toString()
                myRef.setValue(texto)

            }
        })


        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }


    private fun idInstance(){
        buscar = findViewById(R.id.submit)

        busqueda = findViewById(R.id.busqueda)
        busquedaInput = findViewById(R.id.inputBusqueda)
    }
}
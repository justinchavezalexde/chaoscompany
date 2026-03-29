package com.example.fragments1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelloMainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello_main2)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutBienvenida)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val textoNombre = findViewById<TextView>(R.id.textoNombre)
        val imagenUsuario = findViewById<ImageView>(R.id.imagenUsuario)


        val nombreRecibido = intent.getStringExtra("nombreUsuario")


        textoNombre.text = "Bienvenido $nombreRecibido"


        imagenUsuario.setImageResource(R.drawable.pal)
    }
}
package com.example.loggin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val nombre = intent.getStringExtra("nombreUsuario")

        val texto = findViewById<TextView>(R.id.textoBienvenida)
        val imagen = findViewById<ImageView>(R.id.imagenUsuario)

        texto.text = "Bienvenido: $nombre"

        // Imagen de ejemplo
        imagen.setImageResource(R.drawable.pal)
    }
}
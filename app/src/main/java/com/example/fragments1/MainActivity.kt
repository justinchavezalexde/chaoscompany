package com.example.fragments1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {

        val listaUsuarios = mutableListOf<Triple<String, String, String>>()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val botonLogin = findViewById<Button>(R.id.botonLogin)
        val botonRegistro = findViewById<Button>(R.id.botonRegistro)


        if (listaUsuarios.isEmpty()) {
            listaUsuarios.add(Triple("Marlene", "marlene@gmail.com", "1234"))
            listaUsuarios.add(Triple("Marcelo", "marcelo@gmail.com", "abc"))
            listaUsuarios.add(Triple("Jose Gerardo", "luis@gmail.com", "123abc"))
        }


        botonLogin.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmentos, IniciarSesionFragment())
                .commit()
        }


        botonRegistro.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmentos, RegistroFragment())
                .commit()
        }
    }
}
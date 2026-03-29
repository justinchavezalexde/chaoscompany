package com.example.loggin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.campoNombre)
        val correo = findViewById<EditText>(R.id.campoCorreo)
        val password = findViewById<EditText>(R.id.campoPassword)
        val btnAceptar = findViewById<Button>(R.id.botonAceptar)
        val btnCancelar = findViewById<Button>(R.id.botonCancelar)

        // Usuario de prueba
        val correoCorrecto = "admin@gmail.com"
        val passCorrecto = "1234"

        btnAceptar.setOnClickListener {

            val nom = nombre.text.toString()
            val cor = correo.text.toString()
            val pass = password.text.toString()

            if (nom.isEmpty() || cor.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            } else {

                if (cor == correoCorrecto && pass == passCorrecto) {

                    val intent = Intent(this, BienvenidaActivity::class.java)
                    intent.putExtra("nombreUsuario", nom)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnCancelar.setOnClickListener {
            nombre.text.clear()
            correo.text.clear()
            password.text.clear()
        }
    }
}
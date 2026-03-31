package com.example.registro

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


        val nombre = findViewById<EditText>(R.id.campoNombre)
        val apellidos = findViewById<EditText>(R.id.campoApellidos)
        val correo = findViewById<EditText>(R.id.campoCorreo)
        val password = findViewById<EditText>(R.id.campoClave)

        val btnRegistrar = findViewById<Button>(R.id.botonGuardar)
        val btnCancelar = findViewById<Button>(R.id.botonSalir)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        //  Botón Registrar
        btnRegistrar.setOnClickListener {

            val n = nombre.text.toString()
            val a = apellidos.text.toString()
            val c = correo.text.toString()
            val p = password.text.toString()

            if (n.isEmpty() || a.isEmpty() || c.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {

                // Toast requerido por la práctica
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()

                //  Mostrar datos en la parte inferior
                resultado.text = """
                    Nombre: $n
                    Apellidos: $a
                    E-mail: $c
                    Password: $p
                """.trimIndent()

                //  Limpiar campos
                nombre.text.clear()
                apellidos.text.clear()
                correo.text.clear()
                password.text.clear()
            }
        }

        //  Botón Cancelar
        btnCancelar.setOnClickListener {
            finish()
        }
    }
}
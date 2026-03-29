package com.example.ahorcadoapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtPalabra: TextView
    private lateinit var edtLetra: EditText
    private lateinit var btnIntentar: Button
    private lateinit var imgAhorcado: ImageView
    private lateinit var txtResultado: TextView
    private lateinit var txtPresion: TextView

    private val palabras = listOf("computadora")
    private lateinit var palabraSecreta: String
    private lateinit var palabraOculta: CharArray

    private var errores = 0
    private val maxErrores = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPalabra = findViewById(R.id.txtPalabra)
        edtLetra = findViewById(R.id.edtLetra)
        btnIntentar = findViewById(R.id.btnIntentar)
        imgAhorcado = findViewById(R.id.imgAhorcado)
        txtResultado = findViewById(R.id.txtResultado)
        txtPresion = findViewById(R.id.txtPresion)

        iniciarJuego()

        btnIntentar.setOnClickListener {
            val letra = edtLetra.text.toString()

            if (letra.isNotEmpty()) {
                verificarLetra(letra[0])
                edtLetra.text.clear()
            }
        }
    }

    private fun iniciarJuego() {
        palabraSecreta = palabras.random()
        palabraOculta = CharArray(palabraSecreta.length) { '_' }
        errores = 0
        txtResultado.text = ""
        txtPresion.text = ""

        imgAhorcado.setImageDrawable(null)
        imgAhorcado.visibility = ImageView.INVISIBLE

        btnIntentar.isEnabled = true

        actualizarVista()
    }

    private fun verificarLetra(letra: Char) {
        var acierto = false

        for (i in palabraSecreta.indices) {
            if (palabraSecreta[i] == letra) {
                palabraOculta[i] = letra
                acierto = true
            }
        }

        if (!acierto) {
            errores++
            actualizarImagen()
            actualizarPresionError()
        } else {
            actualizarPresionAcierto()


            imgAhorcado.visibility = ImageView.INVISIBLE
        }

        actualizarVista()
        verificarEstado()
    }

    private fun actualizarVista() {
        txtPalabra.text = palabraOculta.joinToString(" ")
    }

    private fun actualizarImagen() {
        if (errores > 0) {
            val resId = resources.getIdentifier(
                "ahorcado$errores",
                "drawable",
                packageName
            )

            imgAhorcado.setImageResource(resId)
            imgAhorcado.visibility = ImageView.VISIBLE
        }
    }

    //  MENSAJES CUANDO FALLA
    private fun actualizarPresionError() {
        val mensaje = when (errores) {
            1 -> "Fallaste… interesante."
            2 -> "Otra vez mal… qué decepción."
            3 -> "Empiezo a dudar de ti."
            4 -> "No estás a la altura…"
            5 -> "Este es tu último intento… piénsalo bien."
            6 -> "Perdiste. Era obvio."
            else -> ""
        }

        txtPresion.text = mensaje
    }

    //  MENSAJES CUANDO ACIERTA
    private fun actualizarPresionAcierto() {
        val mensaje = listOf(
            "Vaya… hasta que haces algo bien.",
            "No estuvo tan difícil, ¿verdad?",
            "Hmm… pura suerte seguramente.",
            "Eso era obvio…",
            "Bueno, algo es algo.",
            "No te emociones demasiado…"
        ).random()

        txtPresion.text = mensaje
    }

    private fun verificarEstado() {
        if (!palabraOculta.contains('_')) {
            txtResultado.text = "¡Ganaste!"
            btnIntentar.isEnabled = false
        } else if (errores >= maxErrores) {
            txtResultado.text = "Perdiste. Era: $palabraSecreta"
            btnIntentar.isEnabled = false
        }
    }
}
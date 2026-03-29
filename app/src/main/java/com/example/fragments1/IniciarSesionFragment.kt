package com.example.fragments1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class IniciarSesionFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val vista = inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)


        val inputCorreo = vista.findViewById<EditText>(R.id.campoCorreo)
        val inputPassword = vista.findViewById<EditText>(R.id.campoClave)
        val botonEntrar = vista.findViewById<Button>(R.id.botonGuardar)
        val botonCancelar = vista.findViewById<Button>(R.id.botonSalir)


        botonEntrar.setOnClickListener {

            val textoCorreo = inputCorreo.text.toString()
            val textoPass = inputPassword.text.toString()

            if (textoCorreo.isEmpty() || textoPass.isEmpty()) {
                Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show()
            } else {

                val usuario = MainActivity.listaUsuarios.find {
                    it.second == textoCorreo && it.third == textoPass
                }

                if (usuario != null) {
                    val intent = Intent(requireContext(), HelloMainActivity2::class.java)
                    intent.putExtra("nombreUsuario", usuario.first)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }


        botonCancelar.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmentos, RegistroFragment())
                .commit()
        }

        return vista
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IniciarSesionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
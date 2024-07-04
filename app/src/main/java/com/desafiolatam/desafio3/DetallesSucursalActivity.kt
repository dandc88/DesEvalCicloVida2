package com.desafiolatam.desafio3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.desafio3.databinding.ActivityDetallesSucursalBinding

class DetallesSucursalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallesSucursalBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesSucursalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sucursalBundle = intent.getBundleExtra("sucursalBundle")
        val sucursal = sucursalBundle?.let { Sucursal.fromBundle(it) }

        // Mostrar los datos de la sucursal en las vistas correspondientes
        binding.nombreSucursalTextView.text = sucursal?.nombre
        binding.direccionSucursalTextView.text = sucursal?.direccion
        binding.horarioSucursalTextView.text = sucursal?.horario
        binding.historiaSucursalTextView.text = sucursal?.historia

        // Mostrar la imagen de la sucursal en el ImageView correspondiente
        binding.sucursalImageView.setImageResource(sucursal?.fotoResId ?: R.drawable.ic_launcher_background)

        // Configurar el OnClickListener para la dirección
        binding.direccionSucursalTextView.setOnClickListener {
            val direccion = binding.direccionSucursalTextView.text.toString()
            abrirEnGoogleMaps(direccion)
        }
        // Configurar el OnClickListener para compartir nombre
        binding.button2.setOnClickListener {
            val nombre = binding.nombreSucursalTextView.text.toString()
            compartirNombre(nombre)
        }
    }

    private fun abrirEnGoogleMaps(direccion: String) {

        val direccionLimpia = direccion.replace("Dirección: ", "")
        // Preparar la dirección para que sea entendida por Google Maps
        val direccionUri = Uri.parse("https:maps.google.com/maps/search/${direccionLimpia}")


        val intent = Intent(Intent.ACTION_VIEW, direccionUri)
        startActivity(intent)

    }

    private fun compartirNombre(nombre: String) {

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, nombre)
            type = "text/plain"
        }


        val chooser = Intent.createChooser(intent, "Compartir dirección con")


        if (intent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        } else {

            Toast.makeText(this, "No se encontró una aplicación para compartir el texto", Toast.LENGTH_SHORT).show()
        }

    }
}
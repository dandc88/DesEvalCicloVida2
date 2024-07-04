package com.desafiolatam.desafio3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.desafio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Lista de sucursales
        val sucursales = listOf(
            Sucursal(
                nombre = getString(R.string.nombre_sucursal1),
                direccion = getString((R.string.direccion_sucursal1)),
                horario = getString(R.string.horario_sucursal1),
                fotoResId = R.drawable.sucursal1,
                historia = getString(R.string.historia_sucursal1)
            ),
            Sucursal(
                nombre = getString(R.string.nombre_sucursal2),
                direccion = getString((R.string.direccion_sucursal2)),
                horario = getString(R.string.horario_sucursal2),
                fotoResId = R.drawable.sucursal2,
                historia = getString(R.string.historia_sucursal2)
            ),
            Sucursal(
                nombre = getString(R.string.nombre_sucursal3),
                direccion = getString((R.string.direccion_sucursal3)),
                horario = getString(R.string.horario_sucursal3),
                fotoResId = R.drawable.sucursal3,
                historia = getString(R.string.historia_sucursal3)
            ),
            Sucursal(
                nombre = getString(R.string.nombre_sucursal4),
                direccion = getString((R.string.direccion_sucursal4)),
                horario = getString(R.string.horario_sucursal4),
                fotoResId = R.drawable.sucursal4,
                historia = getString(R.string.hostoria_sucursal4)
            ),
            Sucursal(
                nombre = getString(R.string.nombre_sucursal5),
                direccion = getString((R.string.direccion_sucursal5)),
                horario = getString(R.string.horario_sucursal5),
                fotoResId = R.drawable.sucursal5,
                historia = getString(R.string.historia_sucursal5)
            )

        )

        // Puedes ocupar este ejemplo para navegar entre activities
        binding.cardView1.setOnClickListener {
            val sucursal = sucursales[0]
            openDetallesSucursalActivity(sucursal)
        }
        binding.cardView2.setOnClickListener {
            val sucursal = sucursales[1]
            openDetallesSucursalActivity(sucursal)
        }
        binding.cardView3.setOnClickListener {
            val sucursal = sucursales[2]
            openDetallesSucursalActivity(sucursal)
        }

        binding.cardView4.setOnClickListener {
            val sucursal = sucursales[3]
            openDetallesSucursalActivity(sucursal)
        }
        binding.cardView5.setOnClickListener {
            val sucursal = sucursales[4]
            openDetallesSucursalActivity(sucursal)
        }


    }



    //Abre la nueva activity con los datos correspondientes a a sucursal
    private fun openDetallesSucursalActivity(sucursal: Sucursal) {
        val intent = Intent(this, DetallesSucursalActivity::class.java)
        intent.putExtra("sucursalBundle", sucursal.toBundle())
        startActivity(intent)
    }
}
package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.databinding.ActivityHomeBinding
import java.io.ByteArrayOutputStream

class HomeActivity : AppCompatActivity() {
    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val marca1= Marcas(
            "Adidas",
            "BZ0057/B75806",
            "Azul y blanco",
            "16/05/2022",
            98.67F
        )

        val marca2 = Marcas(
            "Nike",
            "NK3453/N5943",
            "Blanco y negro",
            "29/02/2019",
            78.99F
        )

        val marca3 = Marcas(
            "Converse",
            "Tradicional",
            "Negras",
            "01/01/2023",
            119.99F
        )

        val marca4 = Marcas(
            "Vans",
            "Old School",
            "Negras",
            "30/07/2005",
            88.99F
        )

        val marca5 = Marcas(
            "New Balance",
            "NB4345",
            "Marron y blanco",
            "19/09/2020",
            69.99F
        )

        val marca6 = Marcas(
            "Gucci",
            "GC8543/G865",
            "Vintage claro",
            "10/02/2023",
            789.99F
        )

        val marca7 = Marcas(
            "Louis Vuitton",
            "LV5345/L23445",
            "Amarillas y blancas",
            "28/06/2020",
            969.55F
        )

        val marca8= Marcas(
            "Off White",
            "OW345456",
            "Amarillo fluoresciente",
            "21/12/2022",
            531.12F
        )

        val marca9= Marcas(
            "Chanel",
            "Old School",
            "Blancas",
            "17/01/2023",
            656.66F
        )

        val marca10= Marcas(
            "Balenciaga",
            "BB23423/B789",
            "Negras",
            "28/01/2022",
            1890.89F
        )

        val marca11 = Marcas(
            "Crocs",
            "CR45645/C2312",
            "Grises",
            "30/01/2023",
            145.50F
        )

        val listado_marcas = listOf<Marcas>(marca1,marca2,marca3,marca4,marca5,marca6,marca7,marca8,marca9,marca10,marca11)
        val adapter = MarcasAdapter(listado_marcas)


        adapter.setOnItemClickListener{
            l, pos -> val intent = Intent(this,DetallesActivity::class.java)
            intent.putExtra("Marca",listado_marcas.elementAt(pos).marca)
            intent.putExtra("Estilo",listado_marcas.elementAt(pos).estilo)
            intent.putExtra("Color",listado_marcas.elementAt(pos).color)
            intent.putExtra("Lanzamiento",listado_marcas.elementAt(pos).lanzamiento)
            intent.putExtra("Precio",listado_marcas.elementAt(pos).precio)
            intent.putExtra("Imagen",adapter.imgMarcas.elementAt(pos))
            startActivity(intent)
        }

        //Listado
        val LayoutManager = GridLayoutManager(this,2)
        binding.RecyclerView.layoutManager = LayoutManager
        binding.RecyclerView.adapter = adapter

    }

    //Gestión del menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //Acciones del menu
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_configuracion -> {
            startActivity(Intent(this, ConfiguracionActivity::class.java))
            true
        }
        R.id.action_cerrar_sesion -> {
            startActivity(Intent(this, MainActivity::class.java))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
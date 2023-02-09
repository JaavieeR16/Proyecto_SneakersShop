package com.example.proyecto

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyecto.databinding.ActivityDetallesBinding
import com.example.proyecto.databinding.ActivityHomeBinding

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Habilitar boton home, código Kotlin
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val binding = ActivityDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val marca = intent.getStringExtra("Marca")
        binding.tvDetalles.text = marca

        val estilo = intent.getStringExtra("Estilo")
        binding.tvDetalles2.text = estilo

        val color = intent.getStringExtra("Color")
        binding.tvDetalles3.text = color

        val lanzamiento = intent.getStringExtra("Lanzamiento")
        binding.tvDetalles4.text = lanzamiento

        val precio = intent.getStringExtra("Precio")
        binding.tvDetalles5.text = precio

        val imagen = intent.getIntExtra("Imagen",1)

        binding.ivDetalles.setImageResource(imagen)
    }

    //Gestión del menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu3, menu)
        return true
    }

    //Acciones del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            NavUtils.navigateUpTo(this, Intent(this, HomeActivity::class.java))
            true
        }
        R.id.action_marcas -> {
            startActivity(Intent(this, HomeActivity::class.java))
            true
        }
        R.id.action_configuracion -> {
            startActivity(Intent(this, ConfiguracionActivity::class.java))
            true
        }
        R.id.action_cerrarsesion -> {
            startActivity(Intent(this, MainActivity::class.java))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}

package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NavUtils

class ConfiguracionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Habilitar boton home, código Kotlin
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
    }

    //Acciones del menu al dar click
    //Gestión del menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu2, menu)
        return true
    }

    //Acciones del menu{
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            NavUtils.navigateUpTo(this, Intent(this, HomeActivity::class.java))
            true
        }
        R.id.action_marcas -> {
            startActivity(Intent(this, HomeActivity::class.java))
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
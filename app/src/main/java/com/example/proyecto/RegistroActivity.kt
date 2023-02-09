package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.proyecto.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegistro3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Tu privacidad es importante para Sneakers Shop. Esta aplicación utiliza cookies y otras tecnologías, propias y de terceros para obtener información sobre tus preferencias, navegación y comportanmiento en esta aplicación, todo eso con finalidad analítica, publicitaria y para la elaboración de perfiles sobre hábitos de navegación.")
                .setTitle("Política de privacidad y Términos de uso")
                .setPositiveButton("Aceptar", { dialog, which ->
                    binding.switch1.isChecked = true
                    binding.btnRegistro.isEnabled = true
                })
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    /*private fun showAceptarFunc() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }*/
}
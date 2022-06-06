package com.promedia.myfirstcartelera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.promedia.myfirstcartelera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var year = arrayOf("")
    private var tipo = "Serie"
    private var lista = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        getSpinner(this, b.spinner, year, R.array.Years)

        b.rbSerie.setOnClickListener { tipo = "Serie" }
        b.rbPelicula.setOnClickListener { tipo = "Película" }

        b.btnAceptar.setOnClickListener { getAndSend() }
    }

    fun getAndSend(){
        val intentResult = Intent(this, ResultCartelera::class.java)
        //intentResult.putExtra("COVER", b.ivCover.src)
        intentResult.putExtra("TITULO", b.etTitulo.text.toString())
        intentResult.putExtra("YEAR", year[0])
        intentResult.putExtra("TIPO", tipo)
        intentResult.putExtra("CATEGORIA", lista.toString())
        startActivity(intentResult)
    }
    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val ckName = view.text.toString()
            if (view.isChecked) {
                if (!lista.contains(ckName)) { lista.add(ckName) }
            } else {
                if (lista.contains(ckName)) { lista.remove(ckName) }
            }
            msj(this, ckName)
        }
    }
    fun checkCategory(str:String){
        if (!lista.contains(str)) { lista.add(str) }
    }
    fun unCheckCategory(str:String){
        if (lista.contains(str)) { lista.remove(str) }
    }

    fun msj(str:String){
        Toast.makeText(this@MainActivity, str, Toast.LENGTH_SHORT).show()
    }
}

package com.promedia.myfirstcartelera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.promedia.myfirstcartelera.databinding.ActivityResultCarteleraBinding

class ResultCartelera : AppCompatActivity() {
    private lateinit var b: ActivityResultCarteleraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultCarteleraBinding.inflate(layoutInflater)
        setContentView(b.root)
        val datos = intent.extras

        val str = """   DATOS
            Título: ${datos?.get("TITULO")}
            Año: ${datos?.get("YEAR")}
            Tipo: ${datos?.get("TIPO")}
            Categorías: ${datos?.get("CATEGORIA")}
        """.trimIndent()
        b.tvResultado.text = str
        b.btnVolver.setOnClickListener { onBackPressed() }
    }
}


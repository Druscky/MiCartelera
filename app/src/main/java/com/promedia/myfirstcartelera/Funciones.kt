package com.promedia.myfirstcartelera

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

/**
 * Esta es una función que genera un objeto spinner
 * mediante programación.
 *
 * @author kotlinab
 *
 * Para crear el objeto spinner necesitamos cuatro parámetros:
 *
 * @param context es el contexto desde donde se llama a la función
 * @param spinner es la vista del layout con la que vamos a crear el objeto
 * @param select es un Array<String> de un solo elemento donde devolveremos
 * la opción seleccionada
 * @param idValores es el id (Int) del recurso donde se almacenan los valores del objeto.
 * Por ejemplo: R.array.valores
 * */
fun getSpinner(context: Context, mySpinner: Spinner, opSelect: Array<String>, idValores:Int){
    val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(context, idValores,
        android.R.layout.simple_spinner_dropdown_item)
    mySpinner.adapter = adaptador
    mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            opSelect[0] = parent?.getItemAtPosition(position).toString()
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {
            opSelect[0] = "Sin selección"
        }
    }
}

/**
 * Esta función pretende generar Toast de forma más rápida
 *
 * @author kotlinab
 *
 * @param context es el contexto desde donde se llama a la función. Normalmente [this]
 * @param str es el String que queremos mostrar en el Toast
 * @param lengthLong se definirá a [true] si deseamos un tiempo largo
 */
fun msj (context: Context, str:String, lengthLong:Boolean = true){
    Toast.makeText(context, str,
        if (lengthLong) Toast.LENGTH_LONG
        else Toast.LENGTH_SHORT
    ).show()
}


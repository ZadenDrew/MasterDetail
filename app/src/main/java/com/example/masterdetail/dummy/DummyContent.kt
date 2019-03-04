package com.example.masterdetail.dummy

import android.util.Log
import android.view.View
import org.json.JSONArray
import java.net.URL
import java.util.ArrayList
import java.util.HashMap
import org.jetbrains.anko.*
import org.jetbrains.anko.longToast

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 * https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
 * Esta es la manera de kotlin de declarar un singleton
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     * El array de los posts.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     * Un hash map para los posts identificado por los IDs
     * ¿Que es un HashMap? https://www.todoexpertos.com/categorias/tecnologia-e-internet/programacion/java/respuestas/y15actdgfmyx6/explicacion-de-como-se-utiliza-hashmap
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    //private val COUNT = 25
    // ya no hace falta
    // era para construir la lista de items
    val LOGTAG = "SEGUIMIENTO"
    /**
     * inicialización del singleton
     */

    init {
        // En este paso necesitamos añadir los posts.
        // TODO hacer la peticion doAsync, traer el json y parsearlo
        doAsync{
            // capturamos los errores de la peticion
            try {
                // peticion a un servidor rest que devuelve un json generico
                //val respuesta = URL("https://jsonplaceholder.typicode.com/posts").readText()
                val respuesta = URL("http://18.191.29.15/wordpress/?rest_route=/wp/v2/posts").readText()
                // parsing data
                // sabemos que recibimos un array de objetos JSON
                val miJSONArray = JSONArray(respuesta)
                // recorremos el Array
                for (jsonIndex in 0..(miJSONArray.length() - 1)) {
                    // asignamos el valor de 'title' en el constructor de la data class 'DummyItem'
                    val idpost = miJSONArray.getJSONObject(jsonIndex).getString("id")
                    val titulo = miJSONArray.getJSONObject(jsonIndex).getString("title")
                    val resumen = miJSONArray.getJSONObject(jsonIndex).getString("content")
                    addItem(DummyItem(idpost,titulo,resumen))
                }
                Log.d(LOGTAG,"Peticion terminada")
            } catch (e: Exception) { // Si algo va mal lo capturamos
                Log.d(LOGTAG,"Algo va mal: $e")
            }
        }
    }

    /**
     * Añadimos los posts al arraylist y los metemos en el hashmap tambien
     * @param item objeto con el contenido del post
     */

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    /**
     * A dummy item representing a piece of content.
     * Esta clase la utilizamos para almacenar los posts
     * En el constructor le pasamos el id, titulo y resumen
     */

    data class DummyItem(val id: String, val title: String, val resumen: String) {
        // personalizamos toString para que nos devuelva el titulo
        override fun toString(): String = title
    }
}

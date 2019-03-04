package com.example.masterdetail.dummy


import java.util.ArrayList
import java.util.HashMap


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
     * No necesitamos inicializar nada aqui, lo hacemos en la Activity
     */

    init {

    }

    /**
     * La dejamos publica para poder acceder desde la Activity
     * Añadimos los posts al arraylist y los metemos en el hashmap tambien
     * @param item objeto con el contenido del post
     */

    fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


}

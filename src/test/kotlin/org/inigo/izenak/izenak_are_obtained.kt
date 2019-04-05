package org.inigo.izenak

import org.junit.Test
import kotlin.test.assertTrue

class process_is_done{
    @Test
    fun if_names_are_getted(){
        val ws : WebScrapper = WebScrapper()
        val names: List<IzenData> = ws.obtainAllNames()
        names.forEach{ println("'${it.izena}','${it.esanahia}'") }
        assertTrue { names.size > 0 }
    }
}
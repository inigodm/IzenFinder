package org.inigo.izenak

import org.junit.Test
import java.io.File
import kotlin.test.assertTrue

class process_is_done_if{
    @Test
    fun all_names_are_getted(){
        val ws : WebScrapper = WebScrapper()
        val names: List<IzenData> = ws.obtainAllNames()
        names.forEach{ println("'${it.izena}','${it.esanahia}'") }
        File("./izenakOut.html").printWriter().use{ out -> out.write(formatHTML(names)) }
        assertTrue { names.size > 0 }
        assertTrue { names.size > 1100 }
    }
}
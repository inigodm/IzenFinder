package org.inigo.izenak

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HTML_scrappes_if{
    val url: String = "https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=es&sexua=E&view=izenak"
    @Test
    fun gets_all_20_izenData_from_a_page(){
        val ws : WebScrapper = WebScrapper()
        var names: List<IzenData> = ws.obtainIzenDatakFrom(ws.getHtmlDocument(url))
        assertEquals(20, names.size)
        names.forEach{ println("${it.izena} --> ${it.esanahia}") }
    }

    @Test
    fun gets_description_from_a_name(){
        val ws : WebScrapper = WebScrapper()
        var url: String = "https://www.euskaltzaindia.eus/es/?option=com_eoda&Itemid=792&view=izenak&testua=Abeli%C3%B1e"
        var izenInfo: String = ws.obtainIzenEsanahia(ws.getHtmlDocument(url))
        assertEquals("Nombre propuesto en el Santoral publicado por Sabino Arana y Koldo Elizalde como equivalente de Avelina " +
                "/ Aveline. Procede de la ciudad italiana de Avelino y se difundió gracias a San Andrés Avelino, nacido en " +
                "ella. Su festividad se celebra el 10 de noviembre.", izenInfo)
    }

    @Test
    fun gets_link_to_next_page(){
        val ws : WebScrapper = WebScrapper()
        var next: String = ws.obtainNextPageUrl(ws.getHtmlDocument(url))
        assertTrue { next.startsWith("https://") }
    }

    @Test
    fun last_page_has_no_next_url(){
        var url = "https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&view=izenak&sexua=E&nonhasi=Zutoia"
        val ws : WebScrapper = WebScrapper()
        var next: String = ws.obtainNextPageUrl(ws.getHtmlDocument(url))
        assertTrue { next.startsWith("") }
    }
}
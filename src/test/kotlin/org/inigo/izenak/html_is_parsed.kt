package org.inigo.izenak

import org.junit.Test
import kotlin.test.assertEquals

class HTML_scrappes{
    val url: String = "https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak"
    @Test
    fun if_gets_all_20_names_from_a_page(){
        val ws : WebScrapper = WebScrapper()
        var names: List<IzenData> = ws.obtainIzenDatakFrom(ws.getHtmlDocument(url))
        assertEquals(20, names.size)
    }

    fun if_get_all_name_links_from_a_page(){

    }

    fun if_get_description_from_a_name(){

    }
}
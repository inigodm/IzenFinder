package org.inigo.izenak

import org.junit.Test
import kotlin.test.assertEquals

class HTML_scrappes{
    val url: String = "https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak"
    @Test
    fun if_gets_all_20_names_from_a_page(){
        val ws : WebScrapper = WebScrapper()
        val finder: IzenFinder = IzenFinder()
        var names: List<Izena> = ws.obtainIzenak(finder.getHtmlDocument(url))
        assertEquals(20, names.size)
    }

    fun if_get_all_name_links_from_a_page(){

    }

    fun if_get_description_from_a_name(){

    }
}
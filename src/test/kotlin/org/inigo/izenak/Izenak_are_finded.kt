package org.inigo.izenak

import org.jsoup.nodes.Document
import org.junit.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Download_is_ok{
    private val finder: WebScrapper = WebScrapper()

    @Test
    fun if_docconnection_with_https_downloads_doc(){
        var res: Document?  = finder.getHtmlDocument("https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak")
        assertEquals("- Pertsona-izenak - Euskal Onomastikaren Datutegia (EODA)", res?.title())
    }

    @Test(expected = ServiceException::class)
    fun if_docconnection_with_https_with_invalid_certificate_throws_ServiceException(){
        finder.getHtmlDocument("https://dev.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak")
    }

    @Test
    fun if_docconnection_with_http_downloads_doc(){
        var res: Document?  = finder.getHtmlDocument("http://www.google.com")
        assertEquals("Google", res?.title())
    }

    @Test(expected = ServiceException::class)
    fun if_docconnection_with_invalid_url_throws_ServiceException(){
        finder.getHtmlDocument("shit")
    }

    @Test(expected = ServiceException::class)
    fun if_docconnection_with_non_existing_url_throws_ServiceException(){
        finder.getHtmlDocument("http://domeneco.coco.com")
    }
}
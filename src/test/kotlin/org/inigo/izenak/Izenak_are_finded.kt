package org.inigo.izenak

import org.junit.*
import kotlin.test.assertTrue

class Download_is_ok{
    private val finder: IzenFinder = IzenFinder()

    @Test
    fun if_connection_with_https_downloads_html(){
        var res: String  = finder.downloadPage("https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak")
        assertTrue { res.contains("</html>") }
    }

    @Test(expected = ServiceException::class)
    fun if_connection_with_https_with_invalid_certificate_throws_ServiceException(){
        var res: String  = finder.downloadPage("https://dev.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak")
        assertTrue { res.contains("</html>") }
    }

    @Test
    fun if_connection_with_http_downloads_html(){
        var res: String  = finder.downloadPage("http://www.google.com")
        assertTrue { res.contains("</html>") }
    }

    @Test(expected = ServiceException::class)
    fun if_connection_with_invalid_url_throws_ServiceException(){
        var res: String  = finder.downloadPage("shit")
        assertTrue { res.contains("</html>") }
    }

    @Test(expected = ServiceException::class)
    fun if_connection_with_non_existing_url_throws_ServiceException(){
        var res: String  = finder.downloadPage("http://domeneco.coco.com")
        assertTrue { res.contains("</html>") }
    }
}
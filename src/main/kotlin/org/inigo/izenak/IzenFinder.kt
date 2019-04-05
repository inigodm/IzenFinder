package org.inigo.izenak

import java.net.URL
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class IzenFinder {

    fun downloadPage(url: String): String = throwsServiceException({
        return@throwsServiceException (URL(url)).openConnection()?.getInputStream()?.bufferedReader().use { it!!.readText() }
    })

    fun getHtmlDocument(url: String): Document = throwsServiceException{
        return@throwsServiceException Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get()
    }
}

class WebScrapper{
    fun obtainIzenak(doc: Document): List<Izena> {
        return doc.select("a.list-group-item").map { it ->  Izena(izena=it.text(), esanNahiURL=it.attr("href"))}
    }
}

data class Izena(var izena: String, var esanNahia: String = "", var esanNahiURL: String){}
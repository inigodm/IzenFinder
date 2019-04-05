package org.inigo.izenak

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class WebScrapper{
    fun getHtmlDocument(url: String): Document = throwsServiceException{
        return@throwsServiceException Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get()
    }

    fun obtainIzenDatakFrom(doc: Document): List<IzenData> {
        return doc.select("a.list-group-item").map { IzenData(izena=it.text(), esanNahiURL=it.attr("href"))}
    }
}

data class IzenData(var izena: String, var esanNahia: String = "", var esanNahiURL: String){}
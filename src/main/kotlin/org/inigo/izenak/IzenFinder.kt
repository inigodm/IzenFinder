package org.inigo.izenak

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class WebScrapper{
    fun getHtmlDocument(url: String): Document = throwsServiceException{
        return@throwsServiceException Jsoup.connect("$url&lang=es").userAgent("Mozilla/5.0").timeout(100000).get()
    }

    fun obtainIzenDatakFrom(doc: Document): List<IzenData> {
        return doc.select("a.list-group-item").map { IzenData(izena=it.text(), esanahia=obtainIzenEsanahia(getHtmlDocument(it.attr("href"))))}
    }

    fun obtainIzenEsanahia(doc: Document): String {
        return doc.select("div.eoda-azalpena").first().text()
    }

    fun obtainNextPageUrl(doc: Document): String {
        return doc.select("ul.pagination").get(1).getElementsByTag("a").attr("href")
    }
}

data class IzenData(var izena: String, var esanahia: String = "", var esanNahiURL: String=""){}
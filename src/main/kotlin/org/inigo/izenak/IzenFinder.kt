package org.inigo.izenak

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class WebScrapper{
    var URL = "https://www.euskaltzaindia.eus/index.php?option=com_eoda&Itemid=469&lang=eu&sexua=E&view=izenak"

    fun getHtmlDocument(url: String): Document = throwsServiceException{
        return@throwsServiceException Jsoup.connect("$url&lang=es").userAgent("Mozilla/5.0").timeout(100000).get()
    }

    fun obtainIzenDatakFrom(doc: Document): List<IzenData> {
        return doc.select("a.list-group-item").map {
                    println("Data for ${it.text()}");
              IzenData(izena=it.text(), esanahia=obtainIzenEsanahia(getHtmlDocument(it.attr("href"))))}
    }

    fun obtainIzenEsanahia(doc: Document): String {
        return doc.select("div.eoda-azalpena").first().text()
    }

    fun obtainNextPageUrl(doc: Document): String {
        return doc.select("ul.pagination").get(1).getElementsByTag("a").attr("href")
    }

    fun obtainAllNames(): List<IzenData> {
        var url = URL;
        var res = mutableListOf<IzenData>()
        var webDoc: Document
        while(url != "") {
            webDoc = getHtmlDocument(url)
            res.addAll(obtainIzenDatakFrom(webDoc))
            url = obtainNextPageUrl(webDoc)
            Thread.sleep(1000)
        }
        return res
    }
}

data class IzenData(var izena: String, var esanahia: String = "")
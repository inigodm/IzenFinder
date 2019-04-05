package org.inigo.izenak

import java.net.URL

class IzenFinder {

    fun downloadPage(url: String): String {
        return (URL(url)).openConnection()?.getInputStream()?.bufferedReader().use { it!!.readText() }
    }
}

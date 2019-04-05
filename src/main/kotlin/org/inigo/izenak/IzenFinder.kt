package org.inigo.izenak

import java.net.URL

class IzenFinder {

    fun downloadPage(url: String): String = throwsServiceException({
        return@throwsServiceException (URL(url)).openConnection()?.getInputStream()?.bufferedReader().use { it!!.readText() }
    })
}

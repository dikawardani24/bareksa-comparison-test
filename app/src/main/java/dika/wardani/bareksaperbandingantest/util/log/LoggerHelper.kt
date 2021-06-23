package dika.wardani.bareksaperbandingantest.util.log

import android.util.Log
import dika.wardani.bareksaperbandingantest.BuildConfig

@Suppress("unused")
object LoggerHelper {
    private fun isDebugging(): Boolean {
        return BuildConfig.DEBUG
    }

    private fun shortenTag(tag: String): String {
        return if (tag.length > 23) {
            tag.substring(0, 22)
        } else {
            tag
        }
    }

    private fun extractClassName(from: Any): String {
        val fullClassNameArray = from.toString().toCharArray()
        val reversedClassName = StringBuilder()

        for (i in fullClassNameArray.size downTo 0 step 1) {
            val char = fullClassNameArray[i-1]

            if (char == '.') {
                break
            }

            reversedClassName.append(char)
        }

        return reversedClassName.reversed().toString()
    }

    private fun createTag(from: Any): String {
        val tag = from.javaClass.simpleName

        return if (tag.isNotEmpty()) {
            shortenTag(tag)
        } else {
            val className = extractClassName(from)
            shortenTag(className)
        }
    }

    fun debug(from: Any, message: String, throwable: Throwable? = null) {
       if (isDebugging()) {
           val tag = createTag(from)

           if (throwable != null) {
               Log.d(tag, message, throwable)
           } else {
               Log.d(tag, message)
           }
       }
    }

    fun info(from: Any, message: String, throwable: Throwable? = null) {
        if (isDebugging()) {
            val tag = createTag(from)
            if (throwable != null) {
                Log.i(tag, message, throwable)
            } else {
                Log.i(tag, message)
            }
        }
    }

    fun warning(from: Any, message: String, throwable: Throwable? = null) {
        if (isDebugging()) {
            val tag = createTag(from)
            if (throwable != null) {
                Log.w(tag, message, throwable)
            } else {
                Log.w(tag, message)
            }
        }
    }

    fun error(from: Any, message: String, throwable: Throwable? = null) {
        if (isDebugging()) {
            val tag = createTag(from)
            if (throwable != null) {
                Log.e(tag, message, throwable)
            } else {
                Log.e(tag, message)
            }
        }
    }
}
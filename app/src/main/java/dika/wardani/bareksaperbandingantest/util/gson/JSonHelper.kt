package dika.wardani.bareksaperbandingantest.util.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dika.wardani.bareksaperbandingantest.util.gson.exception.JsonException

@Suppress("unused")
object JSonHelper {
    val gSon: Gson = GsonBuilder()
        .disableHtmlEscaping()
        .create()

    fun <T> fromJson(kClass: Class<T>, strJson: String): T {
        return try {
            gSon.fromJson(strJson, kClass)
        } catch (e: Exception) {
            throw JsonException(
                "Unable to create Object of ${kClass.simpleName} from json : $strJson",
                e
            )
        }
    }

    fun <T> fromJson(type: java.lang.reflect.Type, strJson: String): T {
        return try {
            gSon.fromJson(strJson, type)
        } catch (e: Exception) {
            throw JsonException("Unable to create Object of $type from json : $strJson", e)
        }
    }

    fun <T> toJson(kClass: Class<T>, obj: T): String {
        return try {
            gSon.toJson(obj, kClass)
        } catch (e: Exception) {
            throw JsonException("Unable to create json from $obj", e)
        }
    }

    fun <T> toJson(obj: T): String {
        return try {
            gSon.toJson(obj)
        } catch (e: Exception) {
            throw JsonException("Unable to create json from $obj", e)
        }
    }
}
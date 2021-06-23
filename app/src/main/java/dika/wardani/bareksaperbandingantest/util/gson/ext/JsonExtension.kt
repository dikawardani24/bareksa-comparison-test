package dika.myexpense.core.util.gson.ext

import dika.wardani.bareksaperbandingantest.util.gson.JSonHelper

fun <T> String.fromJson(kClass: Class<T>): T {
    return JSonHelper.gSon.fromJson(this, kClass)
}

fun <T> String.fromJson(type: java.lang.reflect.Type): T {
    return JSonHelper.gSon.fromJson(this, type)
}

fun <T> T.toJson(kClass: Class<T>): String {
    return JSonHelper.gSon.toJson(this, kClass)
}

fun <T> T.toJson(): String {
    return JSonHelper.gSon.toJson(this)
}
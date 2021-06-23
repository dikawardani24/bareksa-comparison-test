package dika.wardani.bareksaperbandingantest.util.date.ext

import dika.wardani.bareksaperbandingantest.util.date.DateHelper
import java.util.*

fun Date.format(pattern: String, locale: Locale): String {
    return DateHelper.format(this, pattern, locale)
}

fun Date.format(pattern: String): String {
    return DateHelper.format(this, pattern)
}

fun Date.format(): String {
    return DateHelper.format(this)
}

fun Date.formatOrEmpty(pattern: String, locale: Locale): String {
    return DateHelper.formatOrEmpty(
        this,
        pattern,
        locale
    )
}

fun Date.formatOrEmpty(pattern: String): String {
    return DateHelper.formatOrEmpty(this, pattern)
}

fun Date.formatOrEmpty(): String {
    return DateHelper.formatOrEmpty(this)
}

fun Date.formatOrNull(pattern: String, locale: Locale): String? {
    return DateHelper.formatOrNull(
        this,
        pattern,
        locale
    )
}

fun Date.formatOrNull(pattern: String): String? {
    return DateHelper.formatOrNull(this, pattern)
}

fun Date.formatOrNull(): String? {
    return DateHelper.formatOrNull(this)
}

fun Date.formatOrDefault(pattern: String, locale: Locale, default: String): String {
    return DateHelper.formatOrDefault(
        this,
        pattern,
        locale,
        default
    )
}

fun Date.formatOrDefault(pattern: String, default: String): String {
    return DateHelper.formatOrDefault(
        this,
        pattern,
        default
    )
}

fun Date.formatOrDefault(default: String): String {
    return DateHelper.formatOrDefault(this, default)
}

fun String.parseToDate(pattern: String, locale: Locale): Date? {
    return DateHelper.parse(this, pattern, locale)
}

fun String.parseToDate(pattern: String): Date? {
    return DateHelper.parse(this, pattern)
}

fun String.parseToDate(): Date? {
    return DateHelper.parse(this)
}

fun String.parseToDateOrThrow(pattern: String, locale: Locale): Date {
    return DateHelper.parseOrThrow(this, pattern, locale)
}

fun String.parseToDateOrThrow(pattern: String): Date {
    return DateHelper.parseOrThrow(this, pattern)
}

fun String.parseToDateOrThrow(): Date {
    return DateHelper.parseOrThrow(this)
}

fun String.parseToDateOrDefault(pattern: String, locale: Locale, default: Date): Date {
    return DateHelper.parseOrDefault(this, pattern, locale, default)
}

fun String.parseToDateOrDefault(pattern: String, default: Date): Date {
    return DateHelper.parseOrDefault(this, pattern, default)
}

fun String.parseToDateOrDefault(default: Date): Date {
    return DateHelper.parseOrDefault(this, default)
}

fun Date.minDate(howManyDays: Int) {
    val result = DateHelper.minDate(this, howManyDays)
    this.time = result.time
}

fun Date.plusDate(howManyDays: Int) {
    val result = DateHelper.plusDate(this, howManyDays)
    this.time = result.time
}

fun Date.minMonth(howManyMonth: Int) {
    val result = DateHelper.minMonth(this, howManyMonth)
    this.time = result.time
}

fun Date.plusMonth(howManyMonth: Int) {
    val result = DateHelper.plusMonth(this, howManyMonth)
    this.time = result.time
}

fun todayDate(): Date {
    return DateHelper.todayCalendar().time
}
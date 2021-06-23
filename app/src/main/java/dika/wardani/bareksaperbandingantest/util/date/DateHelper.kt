package dika.wardani.bareksaperbandingantest.util.date

import dika.myexpense.core.util.date.model.Time
import dika.wardani.bareksaperbandingantest.util.date.exception.DateException
import java.text.SimpleDateFormat
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
object DateHelper {

    private fun validatePattern(pattern: String) {
        if (pattern.isEmpty()) {
            throw DateException("Pattern must be not empty")
        }
    }

    fun format(date: Date, pattern: String, locale: Locale): String {
        validatePattern(pattern)
        val simpleDateFormat = SimpleDateFormat(pattern, locale)
        return simpleDateFormat.format(date)
    }

    fun format(date: Date, pattern: String): String {
        return format(date, pattern, Locale.getDefault())
    }

    fun format(date: Date): String {
        return format(date, DatePattern.FULL_DATE)
    }

    fun formatOrEmpty(date: Date, pattern: String, locale: Locale): String {
        return try {
            format(date, pattern, locale)
        } catch (e: Exception) {
            ""
        }
    }

    fun formatOrEmpty(date: Date, pattern: String): String {
        return formatOrEmpty(date, pattern, Locale.getDefault())
    }

    fun formatOrEmpty(date: Date): String {
        return formatOrEmpty(date, DatePattern.FULL_DATE)
    }

    fun formatOrNull(date: Date, pattern: String, locale: Locale): String? {
        return try {
            format(date, pattern, locale)
        } catch (e: Exception) {
            return null
        }
    }

    fun formatOrNull(date: Date, pattern: String): String? {
        return formatOrNull(date, pattern, Locale.getDefault())
    }

    fun formatOrNull(date: Date): String? {
        return formatOrNull(date, DatePattern.FULL_DATE)
    }

    fun formatOrDefault(date: Date, pattern: String, locale: Locale, default: String) : String {
        return try {
            format(date, pattern, locale)
        } catch (e: Exception) {
            default
        }
    }

    fun formatOrDefault(date: Date, pattern: String, default: String): String {
        return formatOrDefault(date, pattern, Locale.getDefault(), default)
    }

    fun formatOrDefault(date: Date, default: String): String {
        return formatOrDefault(date, DatePattern.FULL_DATE, default)
    }

    fun parse(dateInString: String, pattern: String, locale: Locale): Date? {
        validatePattern(pattern)

        val simpleDateFormat = SimpleDateFormat(pattern, locale)
        return try {
            simpleDateFormat.parse(dateInString)
        } catch (e: Exception) {
            null
        }
    }

    fun parse(dateInString: String, pattern: String): Date? {
        return parse(dateInString, pattern, Locale.getDefault())
    }

    fun parse(dateInString: String): Date? {
        return parse(dateInString, DatePattern.FULL_DATE)
    }

    fun parseOrThrow(dateInString: String, pattern: String, locale: Locale): Date {
        val result = parse(dateInString, pattern, locale)
        return result
            ?: throw DateException("The pattern $pattern is not suitable for $dateInString")
    }

    fun parseOrThrow(dateInString: String, pattern: String): Date {
        return parseOrThrow(dateInString, pattern, Locale.getDefault())
    }

    fun parseOrThrow(dateInString: String): Date {
        return parseOrThrow(dateInString, DatePattern.FULL_DATE)
    }

    fun parseOrDefault(dateInString: String, pattern: String, locale: Locale, default: Date): Date {
        val result = parse(dateInString, pattern, locale)
        return result ?: default
    }

    fun parseOrDefault(dateInString: String, pattern: String, default: Date): Date {
        return parseOrDefault(dateInString, pattern, Locale.getDefault(), default)
    }

    fun parseOrDefault(dateInString: String, default: Date): Date {
        return parseOrDefault(dateInString, DatePattern.FULL_DATE, default)
    }

    private fun minOrPlusDate(date: Date, howManyDays: Int): Date {
        val calendar = Calendar.getInstance().apply { time = date }
        calendar.add(Calendar.DAY_OF_MONTH, howManyDays)
        return calendar.time
    }

    fun minDate(date: Date, howManyDays: Int): Date {
        return minOrPlusDate(date, -howManyDays)
    }

    fun plusDate(date: Date, howManyDays: Int): Date {
        return minOrPlusDate(date, howManyDays)
    }

    private fun minOrPlusMonth(date: Date, howManyMonths: Int): Date {
        val calendar = Calendar.getInstance().apply { time = date }
        calendar.add(Calendar.MONTH, howManyMonths)
        return calendar.time
    }

    fun minMonth(date: Date, howManyMonths: Int): Date {
        return minOrPlusMonth(date, -howManyMonths)
    }

    fun plusMonth(date: Date, howManyMonths: Int): Date {
        return minOrPlusMonth(date, howManyMonths)
    }

    fun todayCalendar(): Calendar {
        return Calendar.getInstance()
    }

    fun currentTime(): Time {
        val todayCalendar = todayCalendar()
        return Time(
            hour = todayCalendar.get(Calendar.HOUR),
            minute = todayCalendar.get(Calendar.MINUTE),
            second = todayCalendar.get(Calendar.SECOND),
            milliSecond = todayCalendar.get(Calendar.MILLISECOND)
        )
    }

    fun parse(timeStamp: Long): Date {
        return Date(timeStamp)
    }
}
package dika.wardani.bareksaperbandingantest.model

import java.math.BigInteger
import java.util.*

enum class ProductType(val value: String) {
    SAHAM("Saham"),
    PASAR_UANG("Pasar Uang"),
    CAMPURAN("Campuran"),
    UNKNOWN("-");

    companion object {
        fun toReksaDanaType(value: String): ProductType {
            var found = UNKNOWN

            for (type in values()) {
                if (type.value == value) {
                    found = type
                    break
                }
            }

            return found
        }
    }
}

enum class RiskLevel(val value: String) {
    HIGH("Tinggi"),
    LOW("Rendah"),
    UNKNOWN("-");

    companion object {
        fun toRiskLevel(value: String): RiskLevel {
            var found = UNKNOWN

            for (riskLevel in values()) {
                if (riskLevel.value == value) {
                    found = riskLevel
                    break
                }
            }

            return found
        }
    }
}

enum class TimeUnit(val code: Char, val description: String) {
    WEEK('W', "Week"),
    MONTH('M', "Month"),
    YEAR('Y', "Year"),
    UNKNOWN('-', "Unknown");

    companion object {
        fun from(code: Char): TimeUnit {
            var found = UNKNOWN

            for(unit in values()) {
                if (unit.code == code) {
                    found = unit
                    break
                }
            }

            return found
        }

        fun from(description: String): TimeUnit {
            var found = UNKNOWN

            for(unit in values()) {
                if (unit.description == description) {
                    found = unit
                    break
                }
            }

            return found
        }
    }
}

data class ImbalHasil(
    val product: Product,
    val percentage: Double,
    val date: Date
)

data class ImbalHasilAverage(
    val percentage: Int,
    val periode: Int,
    val unit: TimeUnit,
)

data class JangkaWaktu(
    val tempo: Int,
    val unit: TimeUnit
)

data class Product(
    val id: Int,
    val name: String,
    val type: ProductType,
    val imbalHasilAverage: ImbalHasilAverage,
    val danaKelolaan: BigInteger,
    val minPembelian: BigInteger,
    val jangkaWaktu: JangkaWaktu,
    val tingkatRisiko: RiskLevel,
    val tglPeluncuran: Date
)
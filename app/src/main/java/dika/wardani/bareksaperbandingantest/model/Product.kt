package dika.wardani.bareksaperbandingantest.model

import java.math.BigInteger
import java.util.*

enum class ReksaDanaType(val value: String) {
    SAHAM("Saham"),
    PASAR_UANG("Pasar Uang"),
    CAMPURAN("Campuran"),
    UNKNOWN("-");

    companion object {
        fun toReksaDanaType(value: String): ReksaDanaType {
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

enum class ImbalHasilPeriodeUnit(val code: Char, val description: String) {
    WEEK('W', "Week"),
    MONTH('M', "Month"),
    YEAR('Y', "Year"),
    UNKNOWN('-', "Unknown");

    companion object {
        fun from(code: Char): ImbalHasilPeriodeUnit {
            var found = UNKNOWN

            for(unit in values()) {
                if (unit.code == code) {
                    found = unit
                    break
                }
            }

            return found
        }

        fun from(description: String): ImbalHasilPeriodeUnit {
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
    val imbal: Int,
    val periode: Int,
    val unit: ImbalHasilPeriodeUnit,
)

data class Product(
    val id: Int,
    val name: String,
    val type: ReksaDanaType,
    val imbalHasil: ImbalHasil,
    val danaKelolaan: BigInteger,
    val minPembelian: BigInteger,
    val minPembelianUnit: String,
    val jangkaWaktu: Int,
    val jangkaWaktuPeriodeUnit: String,
    val tingkatRisiko: RiskLevel,
    val tglPeluncuran: Date
)
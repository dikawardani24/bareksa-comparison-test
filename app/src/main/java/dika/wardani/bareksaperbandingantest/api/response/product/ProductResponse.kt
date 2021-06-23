package dika.wardani.bareksaperbandingantest.api.response.product

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class ProductResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("jenis")
    val jenis: String,
    @SerializedName("imbal")
    val imbal: Int,
    @SerializedName("imbal_periode_unit")
    val imbalPeriodeUnit: String,
    @SerializedName("imbal_periode")
    val imbalPeriode: Int,
    @SerializedName("dana_kelolaan")
    val danaKelolaan: BigInteger,
    @SerializedName("min_pembelian")
    val minPembelian: BigInteger,
    @SerializedName("jangka_waktu")
    val jangkaWaktu: Int,
    @SerializedName("jangka_waktu_periode_unit")
    val jangkaWaktuPeriodeUnit: String,
    @SerializedName("tingkat_risiko")
    val tingkatRisiko: String,
    @SerializedName("tgl_peluncuran")
    val tglPeluncuran: String
)
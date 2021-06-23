package dika.wardani.bareksaperbandingantest.api.response.product

import com.google.gson.annotations.SerializedName

data class GetImbalHasilComparisonRes(
    @SerializedName("imbal_hasil")
    val imbalHasils: List<ImbalHasilRes>,
    @SerializedName("periode_unit")
    val periodeUnit: Char,
    @SerializedName("periode")
    val periode: Int
)
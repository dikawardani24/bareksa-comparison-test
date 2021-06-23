package dika.wardani.bareksaperbandingantest.api.request.product

import com.google.gson.annotations.SerializedName

data class GetImbalHasilComparisonReq(
    @SerializedName("product_ids")
    val productIds: List<Int>,
    @SerializedName("periode_unit")
    val periodeUnit: Char,
    @SerializedName("periode")
    val periode: Int
)
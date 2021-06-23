package dika.wardani.bareksaperbandingantest.api.response.product

import com.google.gson.annotations.SerializedName

data class ImbalHasilRes(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("imbal")
    val imbal: Int
)
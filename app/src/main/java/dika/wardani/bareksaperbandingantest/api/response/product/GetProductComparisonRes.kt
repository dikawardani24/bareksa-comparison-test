package dika.wardani.bareksaperbandingantest.api.response.product

import com.google.gson.annotations.SerializedName

data class GetProductComparisonRes(
    @SerializedName("products")
    val productS: List<ProductResponse>
)

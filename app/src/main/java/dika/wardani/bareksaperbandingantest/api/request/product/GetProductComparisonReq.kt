package dika.wardani.bareksaperbandingantest.api.request.product

import com.google.gson.annotations.SerializedName

data class GetProductComparisonReq(
    @SerializedName("product_ids")
    val productIds: List<Int>
)
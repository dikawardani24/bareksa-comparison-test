package dika.wardani.bareksaperbandingantest.api.endpoint

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET

interface ProductEndpoint {

    @GET("comparison_product")
    fun getProductComparison(@Body request: RequestBody): Single<String>

    @GET("comparison_imbal_hasil")
    fun getImbalHasilComparison(request: RequestBody): Single<String>
}
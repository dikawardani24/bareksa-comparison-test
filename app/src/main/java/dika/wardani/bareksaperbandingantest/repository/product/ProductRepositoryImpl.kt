package dika.wardani.bareksaperbandingantest.repository.product

import dika.myexpense.core.util.gson.ext.fromJson
import dika.myexpense.core.util.gson.ext.toJson
import dika.wardani.bareksaperbandingantest.api.endpoint.ProductEndpoint
import dika.wardani.bareksaperbandingantest.api.request.product.GetImbalHasilComparisonReq
import dika.wardani.bareksaperbandingantest.api.request.product.GetProductComparisonReq
import dika.wardani.bareksaperbandingantest.api.response.product.GetImbalHasilComparisonRes
import dika.wardani.bareksaperbandingantest.api.response.product.GetProductComparisonRes
import dika.wardani.bareksaperbandingantest.model.*
import dika.wardani.bareksaperbandingantest.util.date.exception.DateException
import dika.wardani.bareksaperbandingantest.util.date.ext.parseToDate
import dika.wardani.bareksaperbandingantest.util.okhttp.MultipartHelper
import io.reactivex.Single

class ProductRepositoryImpl(
    private val productEndpoint: ProductEndpoint
): ProductRepository {

    override fun getProductComparisons(productIds: List<Int>): Single<List<Product>> {
        val request = GetProductComparisonReq(productIds)
        val requestInJson = request.toJson()
        val requestBody = MultipartHelper.toTextPlainRequestBody(requestInJson)

        return productEndpoint.getProductComparison(requestBody).map { response ->
            val getProductComparisonRes = response.fromJson(GetProductComparisonRes::class.java)
            val productResponses = getProductComparisonRes.productS

            productResponses.map {productResponse ->
                Product(
                    id = productResponse.id,
                    danaKelolaan = productResponse.danaKelolaan,
                    name = productResponse.name,
                    tglPeluncuran = productResponse.tglPeluncuran.parseToDate() ?: throw DateException("No date has been received for tgl peluncurean"),
                    tingkatRisiko = RiskLevel.toRiskLevel(productResponse.tingkatRisiko),
                    type = ProductType.toReksaDanaType(productResponse.jenis),
                    imbalHasilAverage = ImbalHasilAverage(
                        percentage = productResponse.imbal,
                        periode = productResponse.imbalPeriode,
                        unit = TimeUnit.from(productResponse.imbalPeriodeUnit)
                    ),
                    jangkaWaktu = JangkaWaktu(
                        tempo = productResponse.jangkaWaktu,
                        unit = TimeUnit.from(productResponse.jangkaWaktuPeriodeUnit)
                    ),
                    minPembelian = productResponse.minPembelian
                )
            }
        }
    }


    override fun getImbalHasilHistoryComparisons(
        products: List<Product>,
        periode: Int,
        timeUnit: TimeUnit
    ): Single<List<ImbalHasil>> {
        val productIds = products.map { it.id }
        val request = GetImbalHasilComparisonReq(
            periode = periode,
            periodeUnit = timeUnit.code,
            productIds = productIds,
        )

        val requestInJson = request.toJson()
        val requestBody = MultipartHelper.toTextPlainRequestBody(requestInJson)

        return productEndpoint.getImbalHasilComparison(requestBody).map { response ->
            val getImbalHasilComparisonRes = response.fromJson(GetImbalHasilComparisonRes::class.java)
            val imbalHasilComparisonRes = getImbalHasilComparisonRes.imbalHasils

            imbalHasilComparisonRes.map { imbalHasilRes ->
                val product = products.first { imbalHasilRes.productId == it.id }

                ImbalHasil(
                    product = product,
                    percentage = imbalHasilRes.imbal,
                    date = imbalHasilRes.date.parseToDate()?: throw DateException("Unable to parse date on imbal hasil date")
                )
            }
        }
    }
}
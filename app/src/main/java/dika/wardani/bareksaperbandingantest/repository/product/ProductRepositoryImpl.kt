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
                    jangkaWaktu = productResponse.jangkaWaktu,
                    jangkaWaktuPeriodeUnit = productResponse.jangkaWaktuPeriodeUnit,
                    minPembelian = productResponse.minPembelian,
                    minPembelianUnit = productResponse.minPembelianUnit,
                    name = productResponse.name,
                    tglPeluncuran = productResponse.tglPeluncuran.parseToDate() ?: throw DateException("No date has been received for tgl peluncurean"),
                    tingkatRisiko = RiskLevel.toRiskLevel(productResponse.tingkatRisiko),
                    type = ReksaDanaType.toReksaDanaType(productResponse.jenis),
                    imbalHasil = ImbalHasil(
                        imbal = productResponse.imbal,
                        periode = productResponse.imbalPeriode,
                        unit = ImbalHasilPeriodeUnit.from(productResponse.imbalPeriodeUnit)
                    )
                )
            }
        }
    }


    override fun getImbalHasilComparisons(
        productIds: List<Int>,
        periode: Int,
        imbalHasilPeriodeUnit: ImbalHasilPeriodeUnit
    ): Single<List<ImbalHasil>> {
        val request = GetImbalHasilComparisonReq(
            periode = periode,
            productIds = productIds,
            periodeUnit = imbalHasilPeriodeUnit.code
        )

        val requestInJson = request.toJson()
        val requestBody = MultipartHelper.toTextPlainRequestBody(requestInJson)

        return productEndpoint.getImbalHasilComparison(requestBody).map { response ->
            val getImbalHasilComparisonRes = response.fromJson(GetImbalHasilComparisonRes::class.java)
            val imbalHasilComparisonRes = getImbalHasilComparisonRes.imbalHasils

            imbalHasilComparisonRes.map { imbalHasilRes ->
                ImbalHasil(
                    imbal = imbalHasilRes.imbal,
                    unit = imbalHasilPeriodeUnit,
                    periode = getImbalHasilComparisonRes.periode
                )
            }
        }
    }
}
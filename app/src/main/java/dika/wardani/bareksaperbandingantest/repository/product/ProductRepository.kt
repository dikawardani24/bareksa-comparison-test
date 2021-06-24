package dika.wardani.bareksaperbandingantest.repository.product

import dika.wardani.bareksaperbandingantest.model.ImbalHasil
import dika.wardani.bareksaperbandingantest.model.Product
import dika.wardani.bareksaperbandingantest.model.TimeUnit
import io.reactivex.Single

interface ProductRepository {

    fun getProductComparisons(productIds: List<Int>): Single<List<Product>>

    fun getImbalHasilHistoryComparisons(products: List<Product>, periode: Int, timeUnit: TimeUnit): Single<List<ImbalHasil>>
}
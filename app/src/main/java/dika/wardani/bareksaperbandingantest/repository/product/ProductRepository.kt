package dika.wardani.bareksaperbandingantest.repository.product

import dika.wardani.bareksaperbandingantest.model.ImbalHasil
import dika.wardani.bareksaperbandingantest.model.ImbalHasilPeriodeUnit
import dika.wardani.bareksaperbandingantest.model.Product
import io.reactivex.Single

interface ProductRepository {

    fun getProductComparisons(productIds: List<Int>): Single<List<Product>>

    fun getImbalHasilComparisons(productIds: List<Int>, periode: Int, imbalHasilPeriodeUnit: ImbalHasilPeriodeUnit): Single<List<ImbalHasil>>
}
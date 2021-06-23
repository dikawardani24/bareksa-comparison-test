package dika.wardani.bareksaperbandingantest.repository

import dika.wardani.bareksaperbandingantest.repository.product.ProductRepository
import dika.wardani.bareksaperbandingantest.repository.product.ProductRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryModule {

    fun get(): Module {
        return module {
            single<ProductRepository> { ProductRepositoryImpl(get()) }
        }
    }

}
package dika.wardani.bareksaperbandingantest.api

import dika.wardani.bareksaperbandingantest.api.endpoint.ProductEndpoint
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiModule {

    fun get(): Module {
        return module {
            single { ApiClient() }
            single { get(ApiClient::class.java).createEndPoint(ProductEndpoint::class.java) }
        }
    }

}
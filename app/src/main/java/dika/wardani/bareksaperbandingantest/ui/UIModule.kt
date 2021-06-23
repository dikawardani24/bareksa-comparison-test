package dika.wardani.bareksaperbandingantest.ui

import dika.wardani.bareksaperbandingantest.ui.perbandingan.danaKelolaan.DanaKelolaanViewModel
import dika.wardani.bareksaperbandingantest.ui.perbandingan.imbalHasil.ImbalHasilViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object UIModule {

    fun get(): Module {

        return module {
            viewModel { DanaKelolaanViewModel() }

            viewModel {
                ImbalHasilViewModel(
                    productRepository = get()
                )
            }
        }
    }
}
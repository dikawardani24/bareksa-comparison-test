package dika.wardani.bareksaperbandingantest

import android.app.Application
import dika.wardani.bareksaperbandingantest.api.ApiModule
import dika.wardani.bareksaperbandingantest.repository.RepositoryModule
import dika.wardani.bareksaperbandingantest.ui.UIModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Suppress("unused")
class BareksaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BareksaApp)
            modules(
                ApiModule.get(),
                RepositoryModule.get(),
                UIModule.get()
            )
        }
    }
}
import com.example.mvvm_di_kmm.di.commonModule
import org.koin.core.context.startKoin

class KoinInit {
    fun initKoin() {
        startKoin {
            modules(commonModule)
        }
    }
}


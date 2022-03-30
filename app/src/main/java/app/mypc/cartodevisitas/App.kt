package app.mypc.cartodevisitas

import android.app.Application
import app.mypc.cartodevisitas.data.AppDatabase
import app.mypc.cartodevisitas.data.CartaoVisitaRepositorio

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repositorio by lazy { CartaoVisitaRepositorio(database.cartaoDao()) }
}
package app.mypc.cartodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitaRepositorio(private val dao: CartaoVisitaDao) {

    fun insert(cartaoVisita: CartaoVisita) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(cartaoVisita)

        }
    }

    fun getAll() = dao.getAll()
}
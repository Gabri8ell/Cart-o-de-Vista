package app.mypc.cartodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.mypc.cartodevisitas.data.CartaoVisita
import app.mypc.cartodevisitas.data.CartaoVisitaRepositorio

class MainViewModel(private val cartaoVisitaRepositorio: CartaoVisitaRepositorio) : ViewModel() {

    fun insert(cartaoDeVisita: CartaoVisita) {
        cartaoVisitaRepositorio.insert(cartaoDeVisita)
    }

    fun getAll(): LiveData<List<CartaoVisita>>{
        return cartaoVisitaRepositorio.getAll()
    }
}

class  MainViewModeFactory(private val repositorio: CartaoVisitaRepositorio):
    ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repositorio) as T
            }
            throw IllegalArgumentException("Unknow ViewModel Class")
        }

}
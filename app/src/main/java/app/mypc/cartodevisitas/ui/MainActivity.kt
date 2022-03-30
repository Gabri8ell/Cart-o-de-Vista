package app.mypc.cartodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import app.mypc.cartodevisitas.App
import app.mypc.cartodevisitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val  mainViewModel: MainViewModel by viewModels {
        MainViewModeFactory((application as App).repositorio)
    }

    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvCartao.adapter = adapter
        getAllcartaoVisita()
       insertListener()

    }

    private fun insertListener(){
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddCartaoDeVisita::class.java )
            startActivity(intent)
        }

    }

    private fun getAllcartaoVisita(){
        mainViewModel.getAll().observe(this,) {cartaoVisita ->
            adapter.submitList(cartaoVisita)
        }
    }
}


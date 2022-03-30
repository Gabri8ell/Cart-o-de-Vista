package app.mypc.cartodevisitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import app.mypc.cartodevisitas.App
import app.mypc.cartodevisitas.data.CartaoVisita
import app.mypc.cartodevisitas.databinding.ActivityAddCartaoDeVisitaBinding

class AddCartaoDeVisita : AppCompatActivity() {
    private lateinit var binding: ActivityAddCartaoDeVisitaBinding

    private val  mainViewModel: MainViewModel by viewModels {
        MainViewModeFactory((application as App).repositorio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddCartaoDeVisitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListener()

    }
    private fun insertListener(){
        binding.btnFechar.setOnClickListener {
            finish()
        }
        binding.btnSalvar.setOnClickListener {
            val cartaoDeVisita = CartaoVisita(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )

            mainViewModel.insert(cartaoDeVisita)
            Toast.makeText(this, "Cartão cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}
package br.com.logan.pokermao.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.logan.pokermao.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPokedex.setOnClickListener{
            startActivity(Intent(this.ScanActivity::class.java))
        }

        btPokemonList.setOnClickListener{
            startActivity(Intent(this, ListPokemonsActivity::class.java))
        }

        btClose.setOnClickListener{
            finish()
        }
    }


}

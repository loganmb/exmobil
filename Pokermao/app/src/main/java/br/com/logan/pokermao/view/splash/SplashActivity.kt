package br.com.logan.pokermao.view.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import br.com.logan.pokermao.R
import br.com.logan.pokermao.view.main.MainActivity

class SplashActivity : AppCompatActivity(){

    val splashViewModel: SplashViewModel by ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.checkHealth()

        splashViewModel.messageError.observe(this, Observer{
            if (it == ""){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else{
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })
    }
}
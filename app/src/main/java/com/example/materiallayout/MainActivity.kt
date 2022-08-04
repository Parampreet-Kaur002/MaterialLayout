package com.example.materiallayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.materiallayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
            }else{
                binding.etPassword.error = null
            }
        }
        binding. btnClick.setOnClickListener {

            var name =binding. etEmail.text.toString()
            var password =binding. etPassword.text.toString()
            //System.out.println("name $name")
            if(name.isNullOrEmpty()){
                binding.etEmail.error = resources.getString(R.string.please_enter_name)
                binding. etEmail.requestFocus()
            }else if(password.isNullOrEmpty()){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
                binding.etPassword.requestFocus()
            }else if(password.length<6){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
                binding.etPassword.requestFocus()
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches())
            {
                binding.etEmail.error = resources.getString(R.string.please_enter_name)
                binding. etEmail.requestFocus()
            }
            else{

                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()

            }
        }
}
}
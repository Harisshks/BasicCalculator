package com.example.calculator

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b1.setOnClickListener{calculator(op=1)}
        binding.b2.setOnClickListener{calculator(op=2)}
        binding.b3.setOnClickListener{calculator(op=3)}
        binding.b4.setOnClickListener{calculator(op=4)}
        }
    fun calculator(op:Int){
        var f1=binding.n1.text.toString()
        var s1=binding.n2.text.toString()
        if(f1.isEmpty() || s1.isEmpty()){
            Toast.makeText(this,"Enter the values Please!",Toast.LENGTH_SHORT).show()
            return
        }
        var f=f1.toIntOrNull()
        var s=s1.toIntOrNull()
        if(f!== null && s!=null){
            var res= when(op){
                1-> f+s
                2->f-s
                3->f*s
                4->if(s!=0) f/s else {
                    Toast.makeText(this,"You can't divide a number by 0 !!",Toast.LENGTH_SHORT).show()
                    return
                }
                else->0
            }
            binding.result.text=res.toString()
        }
        else{
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show()
        }
    }
    }

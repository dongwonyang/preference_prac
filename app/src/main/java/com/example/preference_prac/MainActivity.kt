package com.example.preference_prac

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preference_prac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }

        loadData()
    }

    private fun saveData(){
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()

        edit.putString("name", binding.et.text.toString())
        edit.apply()
    }

    private fun loadData(){
        val pref = getSharedPreferences("pref", 0)
        binding.et.setText(pref.getString("name", ""))
    }
}
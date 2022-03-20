package com.example.kotlin2l1.presentation.add

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2l1.R
import com.example.kotlin2l1.databinding.ActivityAddBinding
import com.example.kotlin2l1.domain.ShopItem
import com.example.kotlin2l1.presentation.main.MainViewModel

class AddActivity : AppCompatActivity() {

    private val binding: ActivityAddBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        binding.btnAdd.setOnClickListener {
            initListeners()
        }
    }

    private fun initListeners() {
        if (binding.etCount.text.isNotEmpty() &&
            binding.etName.text.isNotEmpty() &&
            binding.etId.text.isNotEmpty()
        ) {
            viewModel.addShopItem(
                ShopItem(
                    binding.etName.text.toString(),
                    binding.etCount.text.toString().toInt(), false,
                    binding.etId.text.toString().toInt()
                )
            )
            finish()
        } else {
            Toast.makeText(this, "Заполните поля:", Toast.LENGTH_SHORT).show()
        }
    }
}
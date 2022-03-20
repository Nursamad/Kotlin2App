package com.example.kotlin2l1.presentation.main
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2l1.R
import com.example.kotlin2l1.databinding.ActivityMainBinding
import com.example.kotlin2l1.presentation.add.AddActivity

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapterMain: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.shopList.observe(this, {
            adapterMain.submitList(it)
        })
    }

    private fun initRecycler() {
        with(binding.recycler) {
            adapterMain = MainAdapter()
            adapter = adapterMain
        }
        setupSwipeListeners(binding.recycler)
    }

    private fun setupSwipeListeners(rv: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapterMain.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShop(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rv)
    }

    private fun initListeners() {
        adapterMain.onShopItemLongClickListener = {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.fab.setOnClickListener {
            Intent(this, AddActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}
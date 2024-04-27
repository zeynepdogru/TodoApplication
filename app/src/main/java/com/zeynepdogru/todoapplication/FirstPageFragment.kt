package com.zeynepdogru.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeynepdogru.todoapplication.databinding.FragmentFirstPageBinding


class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private val items = mutableListOf<Item>()
    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)

        binding.button2.setOnClickListener {
            addItem()
        }
        return binding.root
    }

    private fun addItem() {
        val title = binding.editText.text.toString().trim()
        val description = binding.editText2.text.toString().trim()

        if (title.isNotEmpty() && description.isNotEmpty()) {

            val newItem = Item(items.size + 1, title, description, false)
            items.add(newItem)
            toDoAdapter.notifyItemInserted(items.size - 1)
            removeInputs()
        }
        else {
            Toast.makeText(context, "Fill all the blanks", Toast.LENGTH_SHORT).show()
        }
    }

    private fun removeInputs() {
        binding.editText.setText("")
        binding.editText2.setText("")
    }









}
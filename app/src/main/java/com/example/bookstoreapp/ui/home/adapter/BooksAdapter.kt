package com.example.bookstoreapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bookstoreapp.data.model.Book
import com.example.bookstoreapp.databinding.ItemBooksBinding

class BooksAdapter (
    private val bookListener: BookListener
        ) : ListAdapter<Book,BookViewHolder>(BookDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(ItemBooksBinding.inflate(LayoutInflater.from(parent.context), parent , false),bookListener)

    override fun onBindViewHolder(holder: BookViewHolder, position: Int)  = holder.bind(getItem(position))

}
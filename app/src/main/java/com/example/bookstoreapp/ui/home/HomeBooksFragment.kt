package com.example.bookstoreapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookstoreapp.MainApplication
import com.example.bookstoreapp.R
import com.example.bookstoreapp.common.viewBinding
import com.example.bookstoreapp.data.model.Book
import com.example.bookstoreapp.data.model.GetBooksResponce
import com.example.bookstoreapp.databinding.FragmentHomeBooksBinding
import com.example.bookstoreapp.ui.home.adapter.BookListener
import com.example.bookstoreapp.ui.home.adapter.BooksAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeBooksFragment : Fragment(R.layout.fragment_home_books),BookListener {

    private val binding by viewBinding (FragmentHomeBooksBinding::bind)

    private val booksAdapter by lazy{BooksAdapter(this)}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvBooks.adapter = booksAdapter


        getBooks()
    }


    private fun getBooks () {
        MainApplication.bookService?.getProducts()?.enqueue(object : Callback<GetBooksResponce> {
            override fun onResponse(
                call: Call<GetBooksResponce>,
                response: Response<GetBooksResponce>
            ) {

                val result = response.body()?.books


                if (result.isNullOrEmpty().not()) {
                    booksAdapter.submitList(result)
                }

            }

            override fun onFailure(call: Call<GetBooksResponce>, t: Throwable) {
                Log.e("GetProducts", t.message.orEmpty())
            }

        })
    }

    override fun onBookClick(id: Int) {
        val action = HomeBooksFragmentDirections.homeToDetail(id)
        findNavController().navigate(action)
    }

}
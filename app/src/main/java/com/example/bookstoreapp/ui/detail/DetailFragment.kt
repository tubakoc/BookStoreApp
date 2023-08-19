package com.example.bookstoreapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.bookstoreapp.MainApplication
import com.example.bookstoreapp.R
import com.example.bookstoreapp.common.loadImage
import com.example.bookstoreapp.common.viewBinding
import com.example.bookstoreapp.data.model.GetBookDetailResponce
import com.example.bookstoreapp.data.model.GetBooksResponce
import com.example.bookstoreapp.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding (FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBookDetail(args.id)
    }
    private fun getBookDetail (id : Int) {
        MainApplication.bookService?.getBookDetail(id)?.enqueue(object : Callback<GetBookDetailResponce> {
            override fun onResponse(
                call: Call<GetBookDetailResponce>,
                response: Response<GetBookDetailResponce>
            ) {

                val result = response.body()?.book

                if (result != null) {
                    with(binding)
                    {
                        tvTitles.text = result.name
                        tvPrices.text= "${result.price} ₺ "
                        tvDescription.text = "Author: ${result.author}"
                        tvPublisher.text = "Publisher: ${result.publisher}"
                        ivBooks.loadImage(result.imageUrl)
                    }
                }

            }

            override fun onFailure(call: Call<GetBookDetailResponce>, t: Throwable) {
                Log.e("GetProducts", t.message.orEmpty())
            }

        })
    }



}
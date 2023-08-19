package com.example.bookstoreapp.data.source.remote

import com.example.bookstoreapp.common.Constants.Endpoint.GET_BOOKS
import com.example.bookstoreapp.common.Constants.Endpoint.GET_BOOK_DETAIL
import com.example.bookstoreapp.data.model.GetBookDetailResponce
import com.example.bookstoreapp.data.model.GetBooksResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET(GET_BOOKS)
    fun getProducts(): Call<GetBooksResponce>

    @GET(GET_BOOK_DETAIL)
    fun getBookDetail(
        @Query("id") id:Int
    ):Call<GetBookDetailResponce>
}
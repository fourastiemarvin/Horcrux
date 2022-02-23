package com.example.horcrux.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://hp-api.herokuapp.com/api/"
enum class HorcruxApiFilter(val value: String) { SHOW_NAME("name"), SHOW_IMAGE("image"), SHOW_ALL("all") }

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()


interface HorcruxApiService {
    @GET("characters")
    suspend fun getAllCharacters(@Query("filter") type: String):
            List<HorcruxProperty>
}

object HorcruxApi {
    val retrofitService : HorcruxApiService by lazy {
        retrofit.create(HorcruxApiService::class.java)
    }
}


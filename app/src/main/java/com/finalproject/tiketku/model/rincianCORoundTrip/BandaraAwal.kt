package com.finalproject.tiketku.model.rincianCORoundTrip


import com.google.gson.annotations.SerializedName

data class BandaraAwal(
    @SerializedName("kota")
    val kota: String,
    @SerializedName("nama_bandara")
    val namaBandara: String,
    @SerializedName("negara")
    val negara: String
)
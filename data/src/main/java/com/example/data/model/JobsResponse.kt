package com.example.data.model

data class JobsResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)

data class Offer(
    val id: String?, // может отсутствовать
    val title: String,
    val link: String,
    val button: OfferButton? = null
)

data class OfferButton(
    val text: String
)

package com.example.domain.model

data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val buttonText: String? = null
)

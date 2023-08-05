package br.com.hamamoto.spring_pitfalls.bank.client

data class BankResponse(
    val ispb: String? = null,
    val name: String? = null,
    val code: Int? = null,
    val fullName: String? = null
)

package com.example.chattingapp

data class Message(
    val message: String?,
    val sendId: String?
){
    constructor():this("","")
}

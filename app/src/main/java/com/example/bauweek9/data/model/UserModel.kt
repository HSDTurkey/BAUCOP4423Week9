package com.example.bauweek9.data.model
import java.io.Serializable

data class UserModel(
    val name: NameModel,
    val email: String,
    val phone: String,
    val picture: PictureModel
) : Serializable {

}



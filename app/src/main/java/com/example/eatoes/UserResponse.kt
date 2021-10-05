package com.example.eatoes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {

        @SerializedName("email")
        @Expose
        var email:String?=null

        @SerializedName("id")
        @Expose
        var id:String?=null

        @SerializedName("password")
        @Expose
        var password:String?=null

}
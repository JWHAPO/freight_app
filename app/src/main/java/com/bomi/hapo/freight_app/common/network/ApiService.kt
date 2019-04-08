package com.bomi.hapo.freight_app.common.network

import com.bomi.hapo.freight_app.model.User
import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.http.*

/**
 * freight_app
 * Class: ApiService
 * Created by JEONGWOOKIM on 2019-04-08.
 * Description:
 */
interface ApiService {

    //get Users
    @Headers(value = [  "Accept: application/json",
                        "Content-Type:application/json"
                    ])
    @POST("auth/login")
    fun getToken(@Body userInfo: HashMap<String, String>): Observable<JsonElement>

    //get Users
    @FormUrlEncoded
    @GET("api/user")
    fun getUsers(): Observable<User>

    //get User
    @FormUrlEncoded
    @GET("api/user/{user_id}")
    fun getUser(@Path(value = "user_id", encoded = true) userId: String): Observable<User>


}
package com.bomi.hapo.freight_app.common.network

import com.bomi.hapo.freight_app.model.Order
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
    @GET("api/user")
    fun getUsers(): Observable<User>

    //get User
    @GET("api/user/{user_id}")
    fun getUser(@Path(value = "user_id", encoded = true) userId: String): Observable<User>

    //get User
    @GET("api/user/{email}/{password}")
    fun getUserByEmailAndPassword(@Path(value = "email", encoded = true) email: String
                                    ,@Path(value = "password", encoded = true) password: String): Observable<User>

    //get Order Counting
    @GET("api/orders/count/status/{status}")
    fun getOrderCountByStatus(@Path(value = "status", encoded = true) status: String ) : Observable<Int>

    //get Order
    @GET("/api/orders/{id}")
    fun getOrder(@Path(value="id",encoded = true)id:Long) : Observable<Order>

    //post Order
    @POST("/api/orders")
    fun newOrder(@Body order:Order) : Observable<Order>
}
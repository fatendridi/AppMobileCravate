package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("register.php")
    Call<User> performRegistration(@Query("name") String Name, @Query("user_name") String UserName, @Query("user_password") String userPassword);

    @GET("login.php")
    Call<User> performUserLogin(@Query("user_name") String UserName, @Query("user_password") String userPassword);


}

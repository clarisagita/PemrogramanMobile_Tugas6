package com.example.icha_retrofit.Rest;

import com.example.icha_retrofit.Model.GetHeros;
import com.example.icha_retrofit.Model.PostPutDelHeros;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {
    @GET("heros")
    Call<GetHeros> getHeros();
    @Multipart
    @POST("heros")
    Call<PostPutDelHeros> postHeros(@Part MultipartBody.Part image,
                                    @Part("name") RequestBody name,
                                    @Part("description") RequestBody description,
                                    @Part("date") RequestBody date,
                                    @Part("flag") RequestBody flag);
    @Multipart
    @POST("heros")
    Call<PostPutDelHeros> postUpdateHeros(@Part MultipartBody.Part image,
                                          @Part("id") RequestBody id,
                                          @Part("name") RequestBody name,
                                          @Part("description") RequestBody description,
                                          @Part("date") RequestBody date,
                                          @Part("flag") RequestBody flag);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "heros", hasBody = true)
    Call<PostPutDelHeros> deleteHeros(@Field("id") String id);
}
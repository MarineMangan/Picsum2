package com.vogella.android.picsum;

import com.vogella.android.picsum.Modèle.RestPicsumResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PicsumRestApi {
    @GET("Picsum.json")
    Call<RestPicsumResponse> getListPicsum() ;
}

package com.vogella.android.picsum;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vogella.android.picsum.Modèle.Picsum;
import com.vogella.android.picsum.Modèle.RestPicsumResponse;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private final MainActivity mainActivity;

    private static MainController instance = null;

    public static MainController getInstance(MainActivity mainActivity){
        if(instance == null){
            instance = new MainController(mainActivity);
        }
        return instance;

    }
    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {
        mainActivity.showLoader();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/MarineMangan/Picsum/master/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PicsumRestApi picsumRestApi = retrofit.create(PicsumRestApi.class);

        Call<RestPicsumResponse> call = picsumRestApi.getListPicsum();

        call.enqueue(new Callback<RestPicsumResponse>() {
            @Override
            public void onResponse(Call<RestPicsumResponse> call, Response<RestPicsumResponse> response) {
                RestPicsumResponse restPokemonResponse = response.body();
                List<Picsum> listPicsum = restPokemonResponse.getResults();
                mainActivity.showList(listPicsum);
                mainActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<RestPicsumResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });

    }

    void onItemClicked(Picsum itemClicked){
        Toast.makeText(mainActivity, itemClicked.getFilename(),Toast.LENGTH_SHORT).show();
        Intent descriptif = new Intent(mainActivity, SecondActivity.class);
        mainActivity.startActivity(descriptif);
    }
}

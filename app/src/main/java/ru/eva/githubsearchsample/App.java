package ru.eva.githubsearchsample;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.eva.githubsearchsample.interfaces.Api;

public class App extends Application {
    private static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        OkHttpClient httpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);


    }

    public static Api getApi() {
        return api;
    }
}

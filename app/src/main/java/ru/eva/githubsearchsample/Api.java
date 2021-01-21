package ru.eva.githubsearchsample;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/search/repositories")
    Call<UsersApi> getUsers(@Query("q") String query);
}
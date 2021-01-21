package ru.eva.githubsearchsample.interfaces;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.eva.githubsearchsample.model.UsersApi;

public interface Api {
    @GET("/search/repositories")
    Call<UsersApi> getUsers(@Query("q") String query);
}
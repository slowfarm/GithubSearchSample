package ru.eva.githubsearchsample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.eva.githubsearchsample.App;
import ru.eva.githubsearchsample.R;
import ru.eva.githubsearchsample.adapter.MainActivityAdapter;
import ru.eva.githubsearchsample.model.UsersApi;

public class MainActivity extends AppCompatActivity {

    MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText searchEditText = findViewById(R.id.searchEditText);
        Button findButton = findViewById(R.id.findButton);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new MainActivityAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findButton.setOnClickListener(v ->
                App.getApi().getUsers(searchEditText.getText().toString()).enqueue(new Callback<UsersApi>() {
                    @Override
                    public void onResponse(Call<UsersApi> call, Response<UsersApi> response) {
                        adapter.addItems(response.body().getItems());
                    }

                    @Override
                    public void onFailure(Call<UsersApi> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }));
    }
}
package ado.com.enmanuel.jokerxtreme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import ado.com.enmanuel.jokerxtreme.APIResponse.JokeSONResponse;
import ado.com.enmanuel.jokerxtreme.InterfaceJokes.JokerInterface;
import ado.com.enmanuel.jokerxtreme.JokerAdapter.JokerAdapter;
import ado.com.enmanuel.jokerxtreme.Model.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Value> dataJokes;
    private JokerAdapter adapter;
    private JokerInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startShow();
    }

    private void startShow() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_jokes);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadJokeSON();
        //Comentarios
    }

    private void loadJokeSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JokerInterface request = retrofit.create(JokerInterface.class);
        Call<JokeSONResponse> call = request.getValue();
        call.enqueue(new Callback<JokeSONResponse>() {
            @Override
            public void onResponse(Call<JokeSONResponse> call, Response<JokeSONResponse> response) {
                JokeSONResponse jokeSONResponse = response.body();
                dataJokes = new ArrayList<>(Arrays.asList(jokeSONResponse.getValue()));
                adapter = new JokerAdapter(dataJokes);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JokeSONResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}

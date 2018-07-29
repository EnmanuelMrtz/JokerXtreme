package ado.com.enmanuel.jokerxtreme;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
    }

    private void loadJokeSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com/")
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_Random) {
            Context context = MainActivity.this;



            Toast.makeText(context, "En construcción...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

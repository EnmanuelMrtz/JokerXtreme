package ado.com.enmanuel.jokerxtreme.InterfaceJokes;

import ado.com.enmanuel.jokerxtreme.APIResponse.JokeSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomJokerInterface {

    @GET("jokes/random/10")
    Call<JokeSONResponse> getRandom();
}

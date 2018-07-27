package ado.com.enmanuel.jokerxtreme.InterfaceJokes;

import ado.com.enmanuel.jokerxtreme.APIResponse.JokeSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JokerInterface {

    @GET("random")
    Call<JokeSONResponse> getValue();
}

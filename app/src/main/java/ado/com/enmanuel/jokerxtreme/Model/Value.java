package ado.com.enmanuel.jokerxtreme.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("joke")
    @Expose
    private String joke;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;

    public Value() {
    }

    public Value(Integer id, String joke, List<String> categories) {
        super();
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Value withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Value withJoke(String joke) {
        this.joke = joke;
        return this;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Value withCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }
}

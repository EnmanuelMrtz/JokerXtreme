package ado.com.enmanuel.jokerxtreme.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Jokes {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private List<Value> value = null;

    public Jokes() {
    }

    public Jokes(String type, List<Value> value) {
        super();
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Jokes withType(String type) {
        this.type = type;
        return this;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public Jokes withValue(List<Value> value) {
        this.value = value;
        return this;
    }
}

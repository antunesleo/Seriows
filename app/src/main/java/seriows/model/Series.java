package seriows.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonardo on 31/05/16.
 */
public class Series {
    @SerializedName("series")
    public List<Item> itens;
}

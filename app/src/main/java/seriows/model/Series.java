package seriows.model;

import android.content.ClipData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonardo on 31/05/16.
 */
public class Series {
    @SerializedName("data")
    public List<ClipData.Item> itens;
}

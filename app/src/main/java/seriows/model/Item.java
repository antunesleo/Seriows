package seriows.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonardo on 04/06/16.
 */
public class Item {

    @SerializedName("series_name")
    public String seriesName;

    @SerializedName("series_activity")
    public String seriesActivity;

    @SerializedName("series_type")
    public String seriesType;

    @SerializedName("series_rate")
    public float seriesRate;

    @SerializedName("series_resume")
    public String seriesResume;

    @SerializedName("imagens")
    public Imagem imagens;

}

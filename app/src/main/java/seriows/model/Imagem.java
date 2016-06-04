package seriows.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonardo on 04/06/16.
 */
public class Imagem {
    @SerializedName("url_primary_image")
    public String urlPrimaryImage;

    @SerializedName("url_secondary_image")
    public String urlSecondaryImagem;
}

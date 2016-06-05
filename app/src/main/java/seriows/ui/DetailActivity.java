package seriows.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.leonardo.teste.R;
import com.squareup.picasso.Picasso;

import seriows.database.infrastructure.Constants;
import seriows.model.Imagem;
import seriows.model.Item;
import seriows.model.Series;

public class DetailActivity extends AppCompatActivity {
    private ListView mListView;
    private Series mSeries;

    private TextView mTextViewSeriesName;
    private TextView mTextViewSeriesType;
    private TextView mTextViewSeriesResume;
    private TextView mTextViewSeriesRate;
    private TextView mTextViewSeriesActivity;
    private ImageView mImageViewSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTextViewSeriesName = (TextView) findViewById(R.id.textview_series_name);
        mTextViewSeriesType = (TextView) findViewById(R.id.textview_series_type);
        mTextViewSeriesResume = (TextView) findViewById(R.id.textview_series_resume);
        mTextViewSeriesRate = (TextView) findViewById(R.id.textview_series_rate);
        mTextViewSeriesActivity = (TextView) findViewById(R.id.textview_series_activity);
        mImageViewSerie = (ImageView) findViewById(R.id.imageview_serie);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        Item item = new Item();
        item.seriesName = bundle.getString(Constants.BundleExtras.SERIES_NAME);
        item.seriesActivity = bundle.getString(Constants.BundleExtras.SERIES_ACTIVITY);
        item.seriesType = bundle.getString(Constants.BundleExtras.SERIES_TYPE);
        item.seriesResume = bundle.getString(Constants.BundleExtras.SERIES_RESUME);
        item.seriesRate = bundle.getFloat(Constants.BundleExtras.SERIES_RATE);


        Imagem imagem = new Imagem();
        imagem.urlPrimaryImage = bundle.getString(Constants.BundleExtras.SERIES_PRIMARY_IMAGE);
        imagem.urlSecondaryImagem = bundle.getString(Constants.BundleExtras.SERIES_SECONDARY_IMAGE);

        item.imagens = imagem;

        mTextViewSeriesName.setText(item.seriesName);
        mTextViewSeriesActivity.setText(item.seriesActivity);
        mTextViewSeriesRate.setText(String.valueOf(item.seriesRate));
        mTextViewSeriesType.setText(item.seriesType);
        mTextViewSeriesResume.setText(item.seriesResume);
        Picasso.with(DetailActivity.this).load(imagem.urlSecondaryImagem).
                placeholder(R.drawable.blackcat).
                into(mImageViewSerie);

    }
}

package seriows.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.leonardo.teste.R;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

import seriows.database.helper.SerieHelper;
import seriows.database.infrastructure.Constants;
import seriows.model.Item;
import seriows.model.Series;
import seriows.ui.adapter.SeriesAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private Series mSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview_series);
        mListView.setOnItemClickListener(mOnItemClickListener);

        //Realiza o parse e recebe a lista com os itens carregados do json
        mSeries = getSeries();

        //Instancia classe e insere os dados do json no sqlite
        SerieHelper mSerieHelper = new SerieHelper(MainActivity.this);
        mSerieHelper.insertFromSeries(mSeries);

        //Popula o adapter com a lista de produtos
        SeriesAdapter seriesAdapter = new SeriesAdapter(MainActivity.this, mSeries);
        mListView.setAdapter(seriesAdapter);
    }

    private ListView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Pega o id do item selecionado
            Item itemSelected = mSeries.itens.get(position);

            Intent it = new Intent(MainActivity.this, DetailActivity.class);
            //Insere o pacote dos dados do item selecionado no intent para ser recebido pela outra act
            it.putExtras(getBundleItem(itemSelected));
            startActivity(it);
        }
    };


    private Bundle getBundleItem(Item item){
        //Cria um "pacote" com os dados do item clicado
        Bundle result = new Bundle();
        result.putString(Constants.BundleExtras.SERIES_NAME,item.seriesName);
        result.putString(Constants.BundleExtras.SERIES_ACTIVITY,item.seriesActivity);
        result.putFloat(Constants.BundleExtras.SERIES_RATE,item.seriesRate);
        result.putString(Constants.BundleExtras.SERIES_TYPE,item.seriesType);
        result.putString(Constants.BundleExtras.SERIES_RESUME,item.seriesResume);
        result.putString(Constants.BundleExtras.SERIES_PRIMARY_IMAGE,item.imagens.urlPrimaryImage);
        result.putString(Constants.BundleExtras.SERIES_SECONDARY_IMAGE,item.imagens.urlSecondaryImagem);

        return result;
    }

    private Series getSeries(){

        //abre o arquivo json (pega a referencia do arquivo) na pasta raw
        InputStream inputStream = getResources().openRawResource(R.raw.data);
        //é preciso criar este objeto para o gsin reconhecer porque este ele o formato que ele pede
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //cria uma nova instancia de gson
        Gson gson = new Gson();
        //instancia o objeto produtos e realiza o PARSE
        Series series = gson.fromJson(inputStreamReader, Series.class);

        return series;
    }
}
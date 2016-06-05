package seriows.ui.adapter;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.leonardo.teste.R;

import seriows.model.Series;

public class DetailActivity extends AppCompatActivity {
    private ListView mListView;
    private Series mSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTextViewName = (TextView) findViewById(R.id.);
        mTextViewContact = (TextView) findViewById(R.id.);
        mTextViewProductName = (TextView) findViewById(R.id.textview_product_name);
        mTextViewDescription = (TextView) findViewById(R.id.textview_description);
        mTextViewPrice = (TextView) findViewById(R.id.textview_price);
        mTextViewAvailableCount = (TextView) findViewById(R.id.textview_available_count);


        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        ClipData.Item item = new ClipData.Item();
        item.nomeVendedor = bundle.getString(SyncStateContract.Constants.BundleExtras.VENDOR_NAME);
        item.contatoVendedor = bundle.getString(SyncStateContract.Constants.BundleExtras.CONTACT);
        item.descricao = bundle.getString(SyncStateContract.Constants.BundleExtras.DESCRIPTION);
        item.nomeProduto = bundle.getString(SyncStateContract.Constants.BundleExtras.PRODUCT_NAME);
        item.preco = bundle.getFloat(SyncStateContract.Constants.BundleExtras.PRICE);
        item.quantidadeDisponivel = bundle.getInt(SyncStateContract.Constants.BundleExtras.AVAILABLE_COUNT);

        Imagem imagem = new Imagem();
        imagem.urlImagemPrincipal = bundle.getString(Constants.BundleExtras.PRIMARY_IMAGE);
        imagem.urlImagemSecundaria = bundle.getString(Constants.BundleExtras.SECONDARY_IMAGE);

        item.imagens = imagem;

        mTextViewName.setText(item.nomeVendedor);
        mTextViewContact.setText(item.contatoVendedor);
        mTextViewProductName.setText(item.nomeProduto);
        mTextViewDescription.setText(item.descricao);
        mTextViewPrice.setText(String.valueOf(item.preco));
        mTextViewAvailableCount.setText(String.valueOf(item.quantidadeDisponivel));
    }
}

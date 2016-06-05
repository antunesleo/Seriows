package seriows.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leonardo.teste.R;
import com.squareup.picasso.Picasso;

import seriows.model.Series;

/**
 * Created by leonardo on 04/06/16.
 */
public class SeriesAdapter extends BaseAdapter {

    private Series mSeries;
    private Context mContext;

    public SeriesAdapter(Context context, Series series){
        mSeries = series;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSeries.itens.size();
    }

    @Override
    public Object getItem(int position) {
        return mSeries.itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_custom_list_series, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextViewName = (TextView) convertView.findViewById(R.id.textview_name);
            viewHolder.mImageViewItem = (ImageView) convertView.findViewById(R.id.imageview_item);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mTextViewName.setText(mSeries.itens.get(position).seriesName);

        Picasso.with(mContext).load(mSeries.itens.get(position).imagens.urlPrimaryImage).
                placeholder(R.drawable.blackcat).
                into(viewHolder.mImageViewItem);

        return convertView;
    }

    private class ViewHolder{
        ImageView mImageViewItem;
        TextView mTextViewName;
    }
}

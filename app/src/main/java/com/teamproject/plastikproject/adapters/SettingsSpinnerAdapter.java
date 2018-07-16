package com.teamproject.plastikproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.modeldatalokasi.Response;

import java.util.List;

/**
 * Created by rage on 3/8/15.
 */
public class SettingsSpinnerAdapter extends ArrayAdapter<Response> {
    private static final String TAG = SettingsSpinnerAdapter.class.getSimpleName();
    private List<Response> placesList;
    private int resource, resDefault;
    private LayoutInflater inflater;
    private View.OnClickListener settingsClickListener;

    public SettingsSpinnerAdapter(Context context, int resource, List<Response> placesList, int resDefault) {
        super(context, resource, placesList);
        this.placesList = placesList;
        this.resource = resource;
        this.inflater = LayoutInflater.from(context);
        this.resDefault = resDefault;
    }

    public void setSettingsClickListener(View.OnClickListener settingsClickListener) {
        this.settingsClickListener = settingsClickListener;
    }

    @Override
    public int getCount() {
        return super.getCount() + 1;
    }

    @Override
    public Response getItem(int position) {
        return position == 0 ? null : placesList.get(position - 1);
    }

    @Override
    public int getPosition(Response item) {
        return placesList.indexOf(item) + 1;
    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent, true);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent, false);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent, boolean isDropDown) {

        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(resource, parent, false);
            holder = new Holder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.settings = convertView.findViewById(R.id.settings);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        if (position == 0) {
            holder.title.setText(resDefault);
            if (settingsClickListener != null && isDropDown) {
                holder.settings.setVisibility(View.VISIBLE);
                holder.settings.setOnClickListener(settingsClickListener);
            } else {
                holder.settings.setVisibility(View.INVISIBLE);
            }
        } else {
            holder.settings.setVisibility(View.INVISIBLE);
            Response shop = placesList.get(position - 1);
            holder.title.setText(shop.getDescription());
        }
        return convertView;
    }

    private class Holder {
        TextView title;
        View settings;
    }
}

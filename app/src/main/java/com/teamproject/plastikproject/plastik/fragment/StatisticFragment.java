package com.teamproject.plastikproject.plastik.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.teamproject.plastikproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticFragment extends Fragment {


    @BindView(R.id.webstatistic)
    WebView webstatistic;
    Unbinder unbinder;

    public StatisticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        unbinder = ButterKnife.bind(this, view);
        webstatistic.getSettings().setJavaScriptEnabled(true);
        getActivity().setTitle("Statistic");
        webstatistic.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webstatistic.loadUrl("http://www.theworldcounts.com/counters/waste_pollution_facts/plastic_bags_used_per_year");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

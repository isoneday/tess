package com.teamproject.plastikproject.plastik.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.teamproject.plastikproject.AppClass;
import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.activities.PurchaseActivity;
import com.teamproject.plastikproject.alarmapp.ui.activity.MainActivity;
import com.teamproject.plastikproject.fragments.MapFragment;
import com.teamproject.plastikproject.plastik.activity.MapSmartAreActivity;
import com.teamproject.plastikproject.plastik.activity.ShoppingLocationActivity;
import com.teamproject.plastikproject.plastik.helper.SessionManager;
import com.teamproject.plastikproject.plastik.model.ResponseDataUser;
import com.teamproject.plastikproject.plastik.model.ResponseUser;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.RestApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.myinnos.imagesliderwithswipeslibrary.Animations.DescriptionAnimation;
import in.myinnos.imagesliderwithswipeslibrary.SliderLayout;
import in.myinnos.imagesliderwithswipeslibrary.SliderTypes.BaseSliderView;
import in.myinnos.imagesliderwithswipeslibrary.SliderTypes.TextSliderView;
import retrofit2.Call;
import retrofit2.Callback;

import static com.teamproject.plastikproject.plastik.helper.MyConstant.GETIMAGEURL;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener  {
    Unbinder unbinder;
    private SliderLayout mDemoSlider;
    LinearLayout linelocation;
    // Billionaires json url
    HashMap<String, String> url_maps;
    ImageView imglocation,imgstatistic;
    private ImageView imgschedule;
    private ImageView imgearth;
    private TextView txtjumlahtropy;
    SessionManager manager ;
    private List<ResponseUser> listdatauser;

    public HomeFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onAttach(Context context) {
//
//
//        super.onAttach(context);
//    }


    @Override
    public void onPause() {
        super.onPause();
        getdatauserbaru();
    }

    @Override
    public void onResume() {
        super.onResume();
       getdatauserbaru();
    }

    private void getdatauserbaru() {
        RestApi api = MyRetrofitClient.getInstaceRetrofit();

        final SessionManager ge = new SessionManager(getActivity());
        String id = ge.getIdUser();
        Call<ResponseDataUser> userCall =api.getdatauser(id);
        userCall.enqueue(new Callback<ResponseDataUser>() {
            @Override
            public void onResponse(Call<ResponseDataUser> call, retrofit2.Response<ResponseDataUser> response) {

                if (response.isSuccessful()) {
                    listdatauser = new ArrayList<ResponseUser>();

                    listdatauser = response.body().getResponse();
                    final String[] itemtropy = new String[listdatauser.size()];


                    for (int i = 0; i < listdatauser.size(); i++) {
                        //Storing names to string array
                        itemtropy[i] = String.valueOf(listdatauser.get(i).getThropy());
                        //       Toast.makeText(getApplicationContext(), " banyak button" + itemsnama, Toast.LENGTH_LONG).show();

                    }
                    ge.setTropy(itemtropy[0]);
                }
            }
            @Override
            public void onFailure(Call<ResponseDataUser> call, Throwable t) {

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        manager = new SessionManager(getActivity());
        imglocation = (ImageView) view.findViewById(R.id.imglocation);
        imgstatistic = (ImageView) view.findViewById(R.id.imgstatistic);
        imgearth = (ImageView) view.findViewById(R.id.imgearthhero);
        txtjumlahtropy =(TextView) view.findViewById(R.id.txtjumlahtropy);
        imgschedule = (ImageView) view.findViewById(R.id.imgshoppingschedule);
        txtjumlahtropy.setText(manager.getTropy()+"pts");
        imgearth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragCategory = new EarthHeroFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragCategory);
                transaction.commit();
            }
        });
        imgstatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragCategory = new StatisticFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragCategory);
                transaction.commit();

            }
        });
        imglocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragCategory = new MapFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragCategory);
                transaction.commit();
//             startActivity(new Intent(getActivity(), PlacesActivity.class));
      //       startActivity(new Intent(getActivity(), MapSmartAreActivity.class));
            }
        });
        imgschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });
        mDemoSlider = (SliderLayout)view.findViewById(R.id.slider);
        linelocation = (LinearLayout) view.findViewById(R.id.linelocation);
        linelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent1 = new Intent(getActivity(), ShoppingLocationActivity.class);
                Intent intent1 = new Intent(getActivity(), ShoppingLocationActivity.class);
                startActivity(intent1);
                getActivity().finish();
            }
        });
        unbinder = ButterKnife.bind(this, view);
        // Creating volley request obj
        JsonArrayRequest billionaireReq = new JsonArrayRequest(GETIMAGEURL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        url_maps = new HashMap<String, String>();
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                url_maps.put(obj.getString("company") , obj.getString("image_name"));
//        url_maps.put(obj.getString("company") + " - " + obj.getString("publish_time"), obj.getString("image_name"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        for (String name : url_maps.keySet()) {
                            TextSliderView textSliderView = new TextSliderView(getActivity());
                            // initialize a SliderLayout

                            String temp = "http://35.231.18.55:3000/api/attachments/advertising/download/"+url_maps.get(name);
                            temp = temp.replaceAll(" ", "%20");
                            URL sourceUrl = null;
                            try {
                                sourceUrl = new URL(temp);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                            textSliderView
                                    .description(name)
                                    .descriptionSize(20)
                                    .image(String.valueOf(sourceUrl))
                                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                                   ;

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle().putString("extra", name);

                            mDemoSlider.addSlider(textSliderView);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(getActivity(), "network issue: please enable wifi/mobile data"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Adding request to request queue
        AppClass.getInstance().addToRequestQueue(billionaireReq);

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        mDemoSlider.setPresetTransformer("Stack");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        getdatauserbaru();
    }

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }
}

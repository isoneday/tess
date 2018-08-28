package com.teamproject.plastikproject.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.modeldatalokasi.ResponseDataLokasi;
import com.teamproject.plastikproject.plastik.helper.GPSTracker;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.RestApi;
import com.teamproject.plastikproject.plastik.notif.AddGeofenceFragment;
import com.teamproject.plastikproject.plastik.notif.AllGeofencesAdapter;
import com.teamproject.plastikproject.plastik.notif.AllGeofencesFragment;
import com.teamproject.plastikproject.plastik.notif.GeofenceController;
import com.teamproject.plastikproject.plastik.notif.NamedGeofence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, AddGeofenceFragment.AddGeofenceFragmentListener,AddGeofenceFragment.Ongetdatalagi  {

    @BindView(R.id.edtawal)
    EditText edtawal;
    @BindView(R.id.edtakhir)
    EditText edtakhir;
    @BindView(R.id.edtsearch)
    EditText edtsearch;

    Unbinder unbinder;
    private GoogleMap mMap;
    CameraUpdate cu;
    //init marker , untuk fit zoom all marker
    private List<Marker> markersList = new ArrayList<Marker>();
    Marker mapMarker;
    String catid = null;
    String id = null;
    String name = null;
    String key = "sdf";
    AddGeofenceFragment.AddGeofenceFragmentListener listener;
    private AllGeofencesAdapter allGeofencesAdapter;


    ArrayList<String> placeList = new ArrayList<String>();
    ArrayList<String> idList = new ArrayList<String>();
    private GPSTracker gpStrack;
    private double lat;
    private double lon;
    private String name_location;
    private LatLng lokasiku;
    private Intent intent;
    NamedGeofence geofence;

    public void setListener(AddGeofenceFragment.AddGeofenceFragmentListener listener) {
        this.listener = listener;
    }

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getActivity().getIntent();
        catid = intent.getStringExtra("catid");
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        unbinder = ButterKnife.bind(this, view);
        GeofenceController.getInstance().init(getContext());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private String convertname(Double lat, Double lon) {
        name_location = null;
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        try {
            List<Address> list = geocoder.getFromLocation(lat, lon,1);
            if (list != null && list.size() > 0) {
                name_location = list.get(0).getAddressLine(0) + "" + list.get(0).getFeatureName();

                //fetch data from addresses
            } else {
                Toast.makeText(getActivity(), "kosong", Toast.LENGTH_SHORT).show();
                //display Toast message
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name_location;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        gpStrack = new GPSTracker(getActivity());
        if (gpStrack.canGetLocation() && mMap != null) {
            lat = gpStrack.getLatitude();
            lon = gpStrack.getLongitude();
            mMap.clear();
            name_location = convertname(lat, lon);
            Toast.makeText(getActivity(), "lat " + lat + "\nlon " + lon, Toast.LENGTH_SHORT).show();
            lokasiku = new LatLng(lat, lon);
            //add marker
            mMap.addMarker(new MarkerOptions().position(lokasiku).title(name_location)).setIcon(
                    BitmapDescriptorFactory.fromResource(R.mipmap.ic_iamhere)
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiku, 16));


            edtawal.setText(name_location);

        }
//        //Enable/Show Traffic
//        if (sesi.getTraffic().equals("Yes")){
//            mMap.setTrafficEnabled(true);
//        }

        //iktifkan settingan zoom contol
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //init progess dialog
        getdatalokasi();


    }

    private void getdatalokasi() {
        final ProgressDialog progress = new ProgressDialog(getActivity());
        //tambahkan pesan
        progress.setMessage("Loading...");
        progress.show();

        RestApi api = MyRetrofitClient.getInstaceRetrofit();
        Call<ResponseDataLokasi> dataLokasiCall = api.getalllokasi();
        dataLokasiCall.enqueue(new Callback<ResponseDataLokasi>() {
            @Override
            public void onResponse(Call<ResponseDataLokasi> call, Response<ResponseDataLokasi> response) {
                progress.dismiss();
                if (response.isSuccessful()) {
                    try {
                        if (response.body().getResponse() != null) {
                            for (int i = 0; i < response.body().getResponse().size(); i++) {
                                Double lat = Double.valueOf(response.body().getResponse().get(i).getLat());
                                Double lon = Double.valueOf(response.body().getResponse().get(i).getLong());
                                String placeName = response.body().getResponse().get(i).getDescription();
                                LatLng koordinat = new LatLng(lat, lon);
                                String id = response.body().getResponse().get(i).getId();
                                mapMarker = mMap.addMarker(new MarkerOptions()
                                        .position(koordinat)
                                        .title(placeName)
                                );

                                //add to list, untuk membuat fix bounds, sehingga semua marker terlihat
                                markersList.add(i, mapMarker);

                                placeList.add(placeName);
                                idList.add(id);
                            }
                        } else {
                            Toast.makeText(getActivity(), "tidak ada data", Toast.LENGTH_SHORT).show();
//                            HeroHelper.pesan(ctx,"Tidak ada data wisata");
                        }

                    } catch (Exception e) {
                        Log.d("onResponse", "There is an error");
                        e.printStackTrace();
                    }

                } else {
                    //         Toast.makeText(getActivity(), "tidak ada data", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), "tidak ada data", Toast.LENGTH_SHORT).show();
//
                }

                //kalau ada marker
                //fit zoom all markers
                if (markersList.size() > 0) {
                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    for (Marker m : markersList) {
                        builder.include(m.getPosition());
                    }
                    /**initialize the padding for map boundary*/
                    int padding = 90;
                    /**create the bounds from latlngBuilder to set into map camera*/
                    LatLngBounds bounds = builder.build();
                    /**create the camera with bounds and padding to set into map*/
                    cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                    /**call the map call back to know map is loaded or not*/
                    mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                        @Override
                        public void onMapLoaded() {
                            /**set animated zoom camera into map*/
                            mMap.animateCamera(cu);

                        }
                    });
                }


                //Event Klik infoWindows
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {

                        LatLng latLon = marker.getPosition();

                        //Cycle through places array
                        for (Marker place : markersList) {
                            if (latLon.equals(place.getPosition())) {
                                // Send single item click data to SingleItemView Class
//                                Intent intent = new Intent(MapSmartAreActivity.this, DetailPOIActivity.class);
//                                // Pass all data population
//                                // Pass all data population
//                                int indexArrayList = placeList.indexOf(place.getTitle());
//                                intent.putExtra("id",idList.get(indexArrayList));
//                                startActivity(intent);
                                edtakhir.setText(place.getTitle());
                            }

                        }
                    }
                });


            }

            @Override
            public void onFailure(Call<ResponseDataLokasi> call, Throwable t) {
                Toast.makeText(getActivity(), "gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();
                ;
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }

    @OnClick({R.id.edtawal, R.id.edtsearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.edtawal:

                AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                        .setCountry("ID") // set filter negara
                        .build();

                try {
                    intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY).setFilter(typeFilter)
                            .build(getActivity());
                    startActivityForResult(intent, 1);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.edtsearch:
                AutocompleteFilter typeFilter1 = new AutocompleteFilter.Builder()
                        .setCountry("ID") // set filter negara
                        .build();

                try {
                    intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY).setFilter(typeFilter1).build(getActivity());
                    startActivityForResult(intent, 2);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Place place = PlaceAutocomplete.getPlace(getActivity(), data);
        //getlat dan get lon
        if (requestCode == 1 && resultCode == RESULT_OK) {
            lat = place.getLatLng().latitude;
            lon = place.getLatLng().longitude;
            name_location = place.getName().toString();
            edtawal.setText(name_location);
            mMap.clear();
            addmarker(lat, lon);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            lat = place.getLatLng().latitude;
            lon = place.getLatLng().longitude;
            name_location = place.getName().toString();
            edtakhir.setText(name_location);
            // mMap.clear();
            addmarker(lat, lon);
            //  aksesrute(strmode);
            LatLng latLon = mapMarker.getPosition();

            //Cycle through places array
            for (Marker place1 : markersList) {
                if (latLon.equals(place1.getPosition())) {
                    // Send single item click data to SingleItemView Class
//                                Intent intent = new Intent(MapSmartAreActivity.this, DetailPOIActivity.class);
//                                // Pass all data population
//                                // Pass all data population
//                                int indexArrayList = placeList.indexOf(place.getTitle());
//                                intent.putExtra("id",idList.get(indexArrayList));
//                                startActivity(intent);
                    //     edtakhir.setText(place.getTitle());
                }

            }
        }

    }
    private void addmarker(Double lat, Double lon) {
        lokasiku = new LatLng(lat, lon);
        name_location = convertname(lat, lon);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiku, 15));
        mMap.addMarker(new MarkerOptions().position(lokasiku).title(name_location));

    }

//    @OnClick({R.id.buttonBerita, R.id.buttonMap})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.buttonBerita:
//                Intent in = new Intent(ctx, BeritaAreaActivity.class);
//                in.putExtra("id",id);
//                in.putExtra("name",name);
//                startActivity(in);
//                break;
//            case R.id.buttonMap:
//                //HeroHelper.pesan(ctx,catid+"-"+id);
//                Intent intent = new Intent(ctx, SubPOIWisataActivity.class);
//                // Pass all data population
//                intent.putExtra("id",id);
//                intent.putExtra("catid",catid);
//                intent.putExtra("name",name);
//                startActivity(intent);
//                break;
//        }
//    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);

        //MenuItem item = menu.findItem(R.id.mn_add);

         super.onCreateOptionsMenu(menu,inflater);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.mn_add){
            AddGeofenceFragment dialogFragment = new AddGeofenceFragment();
            dialogFragment.setTargetFragment(MapFragment.this,1);
        //    dialogFragment.show(getActivity().getSupportFragmentManager(), "AddGeofenceFragment");
            dialogFragment.setListener(MapFragment.this);

            dialogFragment.show(getFragmentManager(),"AddGeofenceFragment");

            // PurchaseEditFragmentbaru fragmentbaru =new PurchaseEditFragmentbaru();

        }
        return super.onOptionsItemSelected(item);
    }
    private GeofenceController.GeofenceControllerListener geofenceControllerListener = new GeofenceController.GeofenceControllerListener() {
        @Override
        public void onGeofencesUpdated() {
            refresh();
        }

        @Override
        public void onError() {
           showErrorToast();
        }
    };

    private void refresh() {
        getdatalokasi();
    }


    private void showErrorToast() {
        Toast.makeText(getActivity(), getActivity().getString(R.string.Toast_Error), Toast.LENGTH_SHORT).show();
    }




    @Override
    public void getdatalagi() {
        getdatalokasi();
       // GeofenceController.getInstance().addGeofence(geofence, geofenceControllerListener);

    }

    @Override
    public void onDialogPositiveClick(android.support.v4.app.DialogFragment dialog, NamedGeofence geofence) {
        GeofenceController.getInstance().addGeofence(geofence, geofenceControllerListener);

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}

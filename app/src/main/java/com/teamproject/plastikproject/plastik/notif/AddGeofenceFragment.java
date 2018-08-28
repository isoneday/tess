package com.teamproject.plastikproject.plastik.notif;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.plastik.network.MyRetrofitClient;
import com.teamproject.plastikproject.plastik.network.RestApi;
import com.teamproject.plastikproject.plastik.notif.modeladdlokasi.ModelAddlokasi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class AddGeofenceFragment extends DialogFragment {

  // region Properties

  private ViewHolder viewHolder;
  private double lat;
  private double lon;
  private String name_locationlat;
  private String name_locationlon;
  private Intent intent;

  private ViewHolder getViewHolder() {
    return viewHolder;
  }

  AddGeofenceFragmentListener listener;
  public void setListener(AddGeofenceFragmentListener listener) {
    this.listener = listener;
  }

  // endregion

  // region Overrides

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.dialog_add_geofence, null);

    viewHolder = new ViewHolder();
    viewHolder.populate(view);
    viewHolder.addlokasi.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
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
      }
    });
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setView(view)
            .setPositiveButton(R.string.Add, null)
            .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                AddGeofenceFragment.this.getDialog().cancel();

                if (listener != null) {
                  listener.onDialogNegativeClick(AddGeofenceFragment.this);
                }
              }
            });

    final AlertDialog dialog = builder.create();

    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
      @Override
      public void onShow(DialogInterface dialogInterface) {
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            if (dataIsValid()) {
              NamedGeofence geofence = new NamedGeofence();
              geofence.name = getViewHolder().nameEditText.getText().toString();
              geofence.latitude = Double.parseDouble(getViewHolder().latitudeEditText.getText().toString());
              geofence.longitude = Double.parseDouble(getViewHolder().longitudeEditText.getText().toString());
              geofence.radius = Float.parseFloat(getViewHolder().radiusEditText.getText().toString()) * 1000.0f;
              RestApi api = MyRetrofitClient.getInstaceRetrofit();
              Call<ModelAddlokasi> addlokasiCall =api.addlokasi(geofence.longitude,geofence.latitude,geofence.name);
              addlokasiCall.enqueue(new Callback<ModelAddlokasi>() {
                @Override
                public void onResponse(Call<ModelAddlokasi> call, Response<ModelAddlokasi> response) {
                  if (response.isSuccessful()){

                    Log.d("informasi","insert berhasil");
                    getdatalagibaru.getdatalagi();
                    //getActivity().startService(new Intent(getActivity(),AreWeThereIntentService.class));

                  }else {
                    Log.d("informasi","gagal insert");

                  }
                  dialog.dismiss();
                }

                @Override
                public void onFailure(Call<ModelAddlokasi> call, Throwable t) {
                  Log.d("informasi","gagal jaringan");

                }
              });
              if (listener != null) {
                listener.onDialogPositiveClick(AddGeofenceFragment.this, geofence);
                dialog.dismiss();
              }
            } else {
              showValidationErrorToast();
            }
          }

        });

      }
    });

    return dialog;
  }

  // endregion

  // region Private

  private boolean dataIsValid() {
    boolean validData = true;

    String name = getViewHolder().nameEditText.getText().toString();
    String latitudeString = getViewHolder().latitudeEditText.getText().toString();
    String longitudeString = getViewHolder().longitudeEditText.getText().toString();
    String radiusString = getViewHolder().radiusEditText.getText().toString();

    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(latitudeString)
            || TextUtils.isEmpty(longitudeString) || TextUtils.isEmpty(radiusString)) {
      validData = false;
    } else {
      double latitude = Double.parseDouble(latitudeString);
      double longitude = Double.parseDouble(longitudeString);
      float radius = Float.parseFloat(radiusString);
      if ((latitude < Constants.Geometry.MinLatitude || latitude > Constants.Geometry.MaxLatitude)
              || (longitude < Constants.Geometry.MinLongitude || longitude > Constants.Geometry.MaxLongitude)
              || (radius < Constants.Geometry.MinRadius || radius > Constants.Geometry.MaxRadius)) {
        validData = false;
      }
    }

    return validData;
  }

  private void showValidationErrorToast() {
    Toast.makeText(getActivity(), getActivity().getString(R.string.Toast_Validation), Toast.LENGTH_SHORT).show();
  }

  // endregion

  // region Interfaces

  public interface AddGeofenceFragmentListener {
    void onDialogPositiveClick(DialogFragment dialog, NamedGeofence geofence);
    void onDialogNegativeClick(DialogFragment dialog);
  }
  public interface Ongetdatalagi{
    void getdatalagi();
  }
  public Ongetdatalagi getdatalagibaru;


  // endregion

  // region Inner classes
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    try{
      getdatalagibaru =(Ongetdatalagi)getTargetFragment();
    }catch (ClassCastException e){

    }
  }
  static class ViewHolder {
    EditText nameEditText;
    EditText latitudeEditText;
    EditText longitudeEditText;
    EditText addlokasi;
    EditText radiusEditText;

    public void populate(View v) {
      nameEditText = (EditText) v.findViewById(R.id.fragment_add_geofence_name);
      latitudeEditText = (EditText) v.findViewById(R.id.fragment_add_geofence_latitude);
      longitudeEditText = (EditText) v.findViewById(R.id.fragment_add_geofence_longitude);
      radiusEditText = (EditText) v.findViewById(R.id.fragment_add_geofence_radius);
  addlokasi = (EditText) v.findViewById(R.id.addlokasi);

      latitudeEditText.setHint(String.format(v.getResources().getString(R.string.Hint_Latitude), Constants.Geometry.MinLatitude, Constants.Geometry.MaxLatitude));
      longitudeEditText.setHint(String.format(v.getResources().getString(R.string.Hint_Longitude), Constants.Geometry.MinLongitude, Constants.Geometry.MaxLongitude));
      radiusEditText.setHint(String.format(v.getResources().getString(R.string.Hint_Radius), Constants.Geometry.MinRadius, Constants.Geometry.MaxRadius));
    }
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Place place = PlaceAutocomplete.getPlace(getContext(), data);
    //getlat dan get lon
    if (requestCode == 1 && resultCode == RESULT_OK) {
      lat = place.getLatLng().latitude;
      lon = place.getLatLng().longitude;
    String nameloc =place.getName().toString();
      name_locationlat = String.valueOf(place.getLatLng().latitude);
      name_locationlon = String.valueOf(place.getLatLng().longitude);
      viewHolder.latitudeEditText.setText(name_locationlat);
      viewHolder.longitudeEditText.setText(name_locationlon);
      viewHolder.addlokasi.setText(nameloc);
      // mMap.clear();
      //addmarker(lat, lon);
    }
  }
  // endregion
}
package com.teamproject.plastikproject.plastik.notif;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

public class Constants {

  public static class Geometry {
    public static double MinLatitude = -90.0;
    public static double MaxLatitude = 90.0;
    public static double MinLongitude = -180.0;
    public static double MaxLongitude = 180.0;
    public static double MinRadius = 0.01; // kilometers
    public static double MaxRadius = 20.0; // kilometers
  }

  public static class SharedPrefs {
    public static String Geofences = "SHARED_PREFS_GEOFENCES";
  }

  public static final String GEOFENCE_ID = "TACME";
  public static final String GEOFENCE_ID2 = "TACME2";
  public static final float GEOFENCE_RADIUS_IN_METERS = 100;

  /**
   * Map for storing information about tacme in the dubai.
   */
  public static final HashMap<String, LatLng> AREA_LANDMARKS = new HashMap<String, LatLng>();

  static {
    // Tacme
    AREA_LANDMARKS.put(GEOFENCE_ID, new LatLng(-6.1953446,106.7948103));
    AREA_LANDMARKS.put(GEOFENCE_ID, new LatLng(-6.1955916,106.7921439));
  }

}



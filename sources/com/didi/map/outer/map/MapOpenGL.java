package com.didi.map.outer.map;

public interface MapOpenGL {
    void dumpInspectInfo();

    void onDestroy();

    void onPause();

    void onResume();

    void setOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback);

    void setVisibility(int i);
}

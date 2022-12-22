package com.didi.map.global.component.markers;

import android.graphics.Bitmap;
import android.view.View;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.List;

public interface IMarkersCompContract extends IBaseComponent<MarkersCompParams> {
    void addMarkerLabel(String str, MarkerModel markerModel);

    IconLabelMarker addNewMarkerToComponent(MarkerModel markerModel, MarkersComponent.ImageNetWorkCallback imageNetWorkCallback);

    void changeMarkerIcon(String str, String str2, float f, MarkersComponent.ImageNetWorkCallback imageNetWorkCallback);

    List<Marker> getAllMarkers();

    float getAlpha(String str);

    Marker getIconMarkerById(String str);

    Marker getLabelMarkerById(String str);

    int getLabelZindex(String str);

    int getMarkerLabelDirect(String str);

    int getMarkerZindex(String str);

    List<Marker> getMarkers();

    List<Marker> getMarkers(String str);

    LatLng getPosition(String str);

    void hideMarkerInfoWindow(String str);

    void removeMarker(String str);

    void setAllMarkersVisible(boolean z);

    void setAlpha(String str, float f);

    void setInfoWindowClickListener(String str, OnInfoWindowClickListener onInfoWindowClickListener);

    void setLabelVisible(String str, boolean z);

    void setMarkerVisible(String str, boolean z);

    void setOnClickListener(OnMarkerCompClickListener onMarkerCompClickListener);

    void showMarkerInfoWindow(String str, View view);

    void showMarkerInfoWindow(String str, View view, InfoWindow.Position position);

    void updateLabelSelected(String str, boolean z);

    void updateLabelView(String str, ILabelView iLabelView);

    void updateLabelZindex(String str, int i);

    void updateMarkerIcon(String str, Bitmap bitmap);

    void updateMarkerLabel(String str, String str2);

    void updateMarkerLabelDirect(String str, int i);

    void updateMarkerZindex(String str, int i);

    void updatePosition(String str, LatLng latLng);
}

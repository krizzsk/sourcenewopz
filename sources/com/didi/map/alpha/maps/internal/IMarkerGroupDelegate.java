package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerGroup;
import com.didi.map.outer.model.MarkerOptions;
import java.util.List;

abstract class IMarkerGroupDelegate {
    /* access modifiers changed from: package-private */
    public abstract void addMarker(String str, Marker marker);

    /* access modifiers changed from: package-private */
    public abstract void addMarkerById(String str, String str2);

    /* access modifiers changed from: package-private */
    public abstract MarkerGroup addMarkerGroup(MarkerGroupControl markerGroupControl);

    /* access modifiers changed from: package-private */
    public abstract void addMarkerList(String str, List<Marker> list);

    /* access modifiers changed from: package-private */
    public abstract void clear(String str);

    /* access modifiers changed from: package-private */
    public abstract boolean containMarker(String str, Marker marker);

    /* access modifiers changed from: package-private */
    public abstract boolean containMarkerById(String str, String str2);

    /* access modifiers changed from: package-private */
    public abstract Marker findMarkerById(String str, String str2);

    /* access modifiers changed from: package-private */
    public abstract List<String> getMarkerIdList(String str);

    /* access modifiers changed from: package-private */
    public abstract List<Marker> getMarkerList(String str);

    /* access modifiers changed from: package-private */
    public abstract void remove(String str);

    /* access modifiers changed from: package-private */
    public abstract boolean removeMarker(String str, Marker marker);

    /* access modifiers changed from: package-private */
    public abstract boolean removeMarkerById(String str, String str2);

    /* access modifiers changed from: package-private */
    public abstract void setMarkerGroupOnTapMapBubblesHidden(String str, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void setMarkerGroupOnTapMapInfoWindowHidden(String str, boolean z);

    /* access modifiers changed from: package-private */
    public abstract boolean setMarkerOnTapMapBubblesHidden(String str, Marker marker, boolean z);

    /* access modifiers changed from: package-private */
    public abstract boolean setOnTapMapBubblesHiddenById(String str, String str2, boolean z);

    /* access modifiers changed from: package-private */
    public abstract boolean updateMarkerOptionById(String str, String str2, MarkerOptions markerOptions);

    IMarkerGroupDelegate() {
    }
}

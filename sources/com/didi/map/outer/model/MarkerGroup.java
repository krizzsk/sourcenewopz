package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.MarkerGroupControl;
import java.util.List;

public class MarkerGroup {

    /* renamed from: a */
    private String f27970a = "";

    /* renamed from: b */
    private MarkerGroupControl f27971b;

    public MarkerGroup(MarkerGroupControl markerGroupControl, String str) {
        this.f27971b = markerGroupControl;
        this.f27970a = str;
    }

    public String getId() {
        return this.f27970a;
    }

    public void addMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarkerById(this.f27970a, str);
        }
    }

    public void addMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarker(this.f27970a, marker);
        }
    }

    public void addMarkerList(List<Marker> list) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.addMarkerList(this.f27970a, list);
        }
    }

    public boolean removeMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.removeMarker(this.f27970a, marker);
        }
        return false;
    }

    public boolean removeMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.removeMarkerById(this.f27970a, str);
        }
        return false;
    }

    public void clear() {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.clear(this.f27970a);
        }
    }

    public Marker findMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.findMarkerById(this.f27970a, str);
        }
        return null;
    }

    public List<Marker> getMarkerList() {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.getMarkerList(this.f27970a);
        }
        return null;
    }

    public List<String> getMarkerIdList() {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.getMarkerIdList(this.f27970a);
        }
        return null;
    }

    public boolean containMarker(Marker marker) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.containMarker(this.f27970a, marker);
        }
        return false;
    }

    public boolean containMarkerById(String str) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.containMarkerById(this.f27970a, str);
        }
        return false;
    }

    public boolean updateMarkerOptionById(String str, MarkerOptions markerOptions) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.updateMarkerOptionById(this.f27970a, str, markerOptions);
        }
        return false;
    }

    public void setMarkerGroupOnTapMapInfoWindowHidden(boolean z) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.setMarkerGroupOnTapMapInfoWindowHidden(this.f27970a, z);
        }
    }

    public void setMarkerGroupOnTapMapBubblesHidden(boolean z) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            markerGroupControl.setMarkerGroupOnTapMapBubblesHidden(this.f27970a, z);
        }
    }

    public boolean setMarkerOnTapMapBubblesHidden(Marker marker, boolean z) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.setMarkerOnTapMapBubblesHidden(this.f27970a, marker, z);
        }
        return false;
    }

    public boolean setOnTapMapBubblesHiddenById(String str, boolean z) {
        MarkerGroupControl markerGroupControl = this.f27971b;
        if (markerGroupControl != null) {
            return markerGroupControl.setOnTapMapBubblesHiddenById(this.f27970a, str, z);
        }
        return false;
    }
}

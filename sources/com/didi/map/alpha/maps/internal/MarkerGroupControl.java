package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerGroup;
import com.didi.map.outer.model.MarkerOptions;
import java.util.List;

public class MarkerGroupControl {

    /* renamed from: a */
    private IMarkerGroupDelegate f24539a;

    public MarkerGroupControl(IMarkerGroupDelegate iMarkerGroupDelegate) {
        this.f24539a = iMarkerGroupDelegate;
    }

    public void destroy() {
        if (this.f24539a != null) {
            this.f24539a = null;
        }
    }

    public final MarkerGroup addMarkerGroup(MarkerGroupControl markerGroupControl) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.addMarkerGroup(markerGroupControl);
        }
        return null;
    }

    public final void remove(String str) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.remove(str);
        }
    }

    public final void addMarkerById(String str, String str2) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.addMarkerById(str, str2);
        }
    }

    public final void addMarker(String str, Marker marker) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.addMarker(str, marker);
        }
    }

    public final void addMarkerList(String str, List<Marker> list) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.addMarkerList(str, list);
        }
    }

    public final boolean removeMarker(String str, Marker marker) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.removeMarker(str, marker);
        }
        return false;
    }

    public final boolean removeMarkerById(String str, String str2) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.removeMarkerById(str, str2);
        }
        return false;
    }

    public final void clear(String str) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.clear(str);
        }
    }

    public final Marker findMarkerById(String str, String str2) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.findMarkerById(str, str2);
        }
        return null;
    }

    public final List<Marker> getMarkerList(String str) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.getMarkerList(str);
        }
        return null;
    }

    public final List<String> getMarkerIdList(String str) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.getMarkerIdList(str);
        }
        return null;
    }

    public final boolean containMarker(String str, Marker marker) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.containMarker(str, marker);
        }
        return false;
    }

    public final boolean containMarkerById(String str, String str2) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.containMarkerById(str, str2);
        }
        return false;
    }

    public final boolean updateMarkerOptionById(String str, String str2, MarkerOptions markerOptions) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.updateMarkerOptionById(str, str2, markerOptions);
        }
        return false;
    }

    public final void setMarkerGroupOnTapMapInfoWindowHidden(String str, boolean z) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.setMarkerGroupOnTapMapInfoWindowHidden(str, z);
        }
    }

    public final void setMarkerGroupOnTapMapBubblesHidden(String str, boolean z) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            iMarkerGroupDelegate.setMarkerGroupOnTapMapBubblesHidden(str, z);
        }
    }

    public final boolean setMarkerOnTapMapBubblesHidden(String str, Marker marker, boolean z) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.setMarkerOnTapMapBubblesHidden(str, marker, z);
        }
        return false;
    }

    public final boolean setOnTapMapBubblesHiddenById(String str, String str2, boolean z) {
        IMarkerGroupDelegate iMarkerGroupDelegate = this.f24539a;
        if (iMarkerGroupDelegate != null) {
            return iMarkerGroupDelegate.setOnTapMapBubblesHiddenById(str, str2, z);
        }
        return false;
    }
}

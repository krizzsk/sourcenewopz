package com.didi.navi.core.auto;

import com.didi.map.outer.model.LatLng;

public final class MapAutoCameraDescriptor {
    public LatLng center;
    public long endTime;
    public int index = -1;
    public boolean isAfterActionWait;
    public float rotateAngle;
    public float scale;
    public int targetIndex = -1;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapAutoCameraDescriptor)) {
            return false;
        }
        MapAutoCameraDescriptor mapAutoCameraDescriptor = (MapAutoCameraDescriptor) obj;
        if (this.index == mapAutoCameraDescriptor.index && this.rotateAngle == mapAutoCameraDescriptor.rotateAngle && m20506a(mapAutoCameraDescriptor) && this.scale == mapAutoCameraDescriptor.scale && this.endTime == mapAutoCameraDescriptor.endTime) {
            return true;
        }
        return false;
    }

    public MapAutoCameraDescriptor clone() {
        MapAutoCameraDescriptor mapAutoCameraDescriptor = new MapAutoCameraDescriptor();
        mapAutoCameraDescriptor.index = this.index;
        mapAutoCameraDescriptor.rotateAngle = this.rotateAngle;
        mapAutoCameraDescriptor.center = this.center;
        mapAutoCameraDescriptor.scale = this.scale;
        mapAutoCameraDescriptor.isAfterActionWait = this.isAfterActionWait;
        mapAutoCameraDescriptor.endTime = this.endTime;
        return mapAutoCameraDescriptor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("index:");
        sb.append(this.index);
        sb.append(" center:");
        LatLng latLng = this.center;
        sb.append(latLng != null ? latLng.toString() : "null");
        sb.append(" angle:");
        sb.append(this.rotateAngle);
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m20506a(MapAutoCameraDescriptor mapAutoCameraDescriptor) {
        LatLng latLng = this.center;
        if (latLng == null) {
            return mapAutoCameraDescriptor.center == null;
        }
        return latLng.equals(mapAutoCameraDescriptor.center);
    }
}

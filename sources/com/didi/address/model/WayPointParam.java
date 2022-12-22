package com.didi.address.model;

import java.io.Serializable;
import java.util.List;

public class WayPointParam implements Serializable, Cloneable {
    private boolean isAddDefaultWayPoint;
    private List<Integer> wayPointTypes;
    private List<WayPoint> wayPoints;

    public List<WayPoint> getWayPoints() {
        return this.wayPoints;
    }

    public void setWayPoints(List<WayPoint> list) {
        this.wayPoints = list;
    }

    public List<Integer> getWayPointTypes() {
        return this.wayPointTypes;
    }

    public void setWayPointTypes(List<Integer> list) {
        this.wayPointTypes = list;
    }

    public boolean isAddDefaultWayPoint() {
        return this.isAddDefaultWayPoint;
    }

    public void setAddDefaultWayPoint(boolean z) {
        this.isAddDefaultWayPoint = z;
    }
}

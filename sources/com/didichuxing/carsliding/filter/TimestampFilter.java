package com.didichuxing.carsliding.filter;

import com.didichuxing.carsliding.model.VectorCoordinate;

public class TimestampFilter implements VectorCoordinateFilter {
    public boolean filter(VectorCoordinate vectorCoordinate, VectorCoordinate vectorCoordinate2) {
        long timeStamp = vectorCoordinate2.getTimeStamp();
        if (timeStamp > 0 && timeStamp >= vectorCoordinate.getTimeStamp()) {
            return false;
        }
        return true;
    }
}

package com.didichuxing.carsliding.filter;

import com.didichuxing.carsliding.model.VectorCoordinate;

public interface VectorCoordinateFilter {
    boolean filter(VectorCoordinate vectorCoordinate, VectorCoordinate vectorCoordinate2);
}

package com.didi.map.core.base.impl;

import android.graphics.Rect;

public class MapBoundaryFactory {
    public static final int BOUNDARY_CHINA = 1;
    public static final int BOUNDARY_WORLD = 2;
    private static final int CHINA_EAST = 147822590;
    private static final int CHINA_NORTH = 53558348;
    private static final int CHINA_SOUTH = 4000000;
    private static final int CHINA_WEST = 38968506;
    public static final int WORLD_EAST = 150000000;
    public static final int WORLD_NORTH = 65000000;
    public static final int WORLD_SOUTH = -35000000;
    public static final int WORLD_WEST = -135000000;

    public static Rect getBoundary(int i) {
        if (i == 1) {
            return new Rect(CHINA_WEST, CHINA_SOUTH, CHINA_EAST, CHINA_NORTH);
        }
        if (i != 2) {
            return new Rect(-135000000, -35000000, 150000000, 65000000);
        }
        return new Rect(-135000000, -35000000, 150000000, 65000000);
    }
}

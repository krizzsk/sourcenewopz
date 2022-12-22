package com.map.global.nav.libc.common;

import android.graphics.Rect;

public class MapBoundaryFactory {
    public static final int BOUNDARY_CHINA = 1;
    public static final int BOUNDARY_WORLD = 2;
    public static final int WORLD_EAST = 150000000;
    public static final int WORLD_NORTH = 65000000;
    public static final int WORLD_SOUTH = -35000000;
    public static final int WORLD_WEST = -135000000;

    /* renamed from: a */
    private static final int f55704a = 4000000;

    /* renamed from: b */
    private static final int f55705b = 53558348;

    /* renamed from: c */
    private static final int f55706c = 38968506;

    /* renamed from: d */
    private static final int f55707d = 147822590;

    public static Rect getBoundary(int i) {
        if (i == 1) {
            return new Rect(f55706c, f55704a, f55707d, f55705b);
        }
        if (i != 2) {
            return new Rect(-135000000, -35000000, 150000000, 65000000);
        }
        return new Rect(-135000000, -35000000, 150000000, 65000000);
    }
}

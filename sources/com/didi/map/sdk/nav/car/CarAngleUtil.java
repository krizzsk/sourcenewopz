package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.location.Location;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rui.config.RConfigConstants;

public class CarAngleUtil {
    protected static float ANGLE_STEP = 0.0f;
    protected static float ANGLE_STEP_HALF = 0.0f;
    protected static List<String> CAR_ICONS = null;
    protected static ConcurrentHashMap<Integer, BitmapDescriptor> CAR_ICONS_CACHE = new ConcurrentHashMap<>();
    protected static int CAR_ICONS_COUNT = 0;

    /* renamed from: a */
    private static final String f28364a = "CarAngleUtil";

    public static boolean init(List<String> list) {
        if (list == null || list.size() <= 1) {
            return false;
        }
        for (String file : list) {
            if (!new File(file).exists()) {
                return false;
            }
        }
        CAR_ICONS = list;
        int size = list.size();
        CAR_ICONS_COUNT = size;
        float f = (float) (360 / size);
        ANGLE_STEP = f;
        ANGLE_STEP_HALF = f / 2.0f;
        return true;
    }

    /* renamed from: a */
    private static Location m20107a(LatLng latLng) {
        Location location = new Location("someLoc");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    public static float getAngle(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        return (m20107a(latLng).bearingTo(m20107a(latLng2)) + 360.0f) % 360.0f;
    }

    public static int getIndexByAngle(float f) {
        if (f < 0.0f) {
            f += 360.0f;
        } else if (f > 360.0f) {
            f -= 360.0f;
        }
        int i = (int) ((f + ANGLE_STEP_HALF) / ANGLE_STEP);
        if (i < 0 || i >= CAR_ICONS_COUNT) {
            return 0;
        }
        return i;
    }

    public static int getIndexByLocation(LatLng latLng, LatLng latLng2) {
        return getIndexByAngle(getAngle(latLng, latLng2));
    }

    public static List<Integer> getRotateIndexes(int i, int i2) {
        if (i == i2) {
            return null;
        }
        int abs = Math.abs(i2 - i);
        int i3 = CAR_ICONS_COUNT / 2;
        int i4 = 0;
        boolean z = i2 <= i ? abs >= i3 : abs <= i3;
        int i5 = CAR_ICONS_COUNT;
        ArrayList arrayList = new ArrayList();
        if (z) {
            if (i2 > i) {
                while (i <= i2) {
                    i4++;
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            } else {
                int i6 = 0;
                while (i <= i5) {
                    i6++;
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
                while (i4 <= i2) {
                    i6++;
                    arrayList.add(Integer.valueOf(i4));
                    i4++;
                }
                i4 = i6;
            }
        } else if (i2 > i) {
            while (i >= 0) {
                i4++;
                arrayList.add(Integer.valueOf(i));
                i--;
            }
            while (i5 >= i2) {
                i4++;
                arrayList.add(Integer.valueOf(i5));
                i5--;
            }
        } else {
            while (i >= i2) {
                i4++;
                arrayList.add(Integer.valueOf(i));
                i--;
            }
        }
        if (i4 == 0) {
            return null;
        }
        return arrayList;
    }

    public static int getCarIconResId(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(i > 9 ? "pop_white_0" : "pop_white_00");
        sb.append(i);
        return applicationContext.getResources().getIdentifier(sb.toString(), RConfigConstants.TYPE_DRAWABLE, packageName);
    }

    protected static boolean isCarIconCache(int i) {
        if (i < 0 || i >= CAR_ICONS_COUNT) {
            i = 0;
        }
        return CAR_ICONS_CACHE.containsKey(Integer.valueOf(i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019 A[Catch:{ Exception -> 0x0008 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.common.map.model.BitmapDescriptor getCarBitmapDescriptor(android.content.Context r3, int r4) {
        /*
            r0 = 0
            if (r4 < 0) goto L_0x000a
            int r1 = CAR_ICONS_COUNT     // Catch:{ Exception -> 0x0008 }
            if (r4 < r1) goto L_0x000b
            goto L_0x000a
        L_0x0008:
            r3 = move-exception
            goto L_0x003b
        L_0x000a:
            r4 = 0
        L_0x000b:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.didi.common.map.model.BitmapDescriptor> r1 = CAR_ICONS_CACHE     // Catch:{ Exception -> 0x0008 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0008 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0008 }
            com.didi.common.map.model.BitmapDescriptor r1 = (com.didi.common.map.model.BitmapDescriptor) r1     // Catch:{ Exception -> 0x0008 }
            if (r1 != 0) goto L_0x003a
            java.util.List<java.lang.String> r1 = CAR_ICONS     // Catch:{ Exception -> 0x0008 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0008 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0008 }
            com.didi.common.map.model.BitmapDescriptor r1 = com.didi.common.map.model.BitmapDescriptorFactory.fromPath(r3, r1)     // Catch:{ Exception -> 0x0008 }
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch:{ Exception -> 0x0008 }
            android.graphics.Bitmap r3 = com.didi.common.map.util.ImageUtil.getScaledBitmap(r3, r1)     // Catch:{ Exception -> 0x0008 }
            com.didi.common.map.model.BitmapDescriptor r1 = com.didi.common.map.model.BitmapDescriptorFactory.fromBitmap(r3)     // Catch:{ Exception -> 0x0008 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.didi.common.map.model.BitmapDescriptor> r3 = CAR_ICONS_CACHE     // Catch:{ Exception -> 0x0008 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0008 }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x0008 }
        L_0x003a:
            return r1
        L_0x003b:
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r3 = r3.toString()
            r4[r0] = r3
            java.lang.String r3 = "CarAngleUtil"
            java.lang.String r0 = "getCarBitmapDescriptor : %s"
            com.didi.common.map.util.DLog.m7384d(r3, r0, r4)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.CarAngleUtil.getCarBitmapDescriptor(android.content.Context, int):com.didi.common.map.model.BitmapDescriptor");
    }

    public static void destroy() {
        ConcurrentHashMap<Integer, BitmapDescriptor> concurrentHashMap = CAR_ICONS_CACHE;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (BitmapDescriptor next : CAR_ICONS_CACHE.values()) {
                if (!(next == null || next.getBitmap() == null)) {
                    next.getBitmap().recycle();
                }
            }
            CAR_ICONS_CACHE.clear();
        }
        CarIconsPreloader.getInstance().destory();
    }
}

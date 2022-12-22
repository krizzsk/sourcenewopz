package com.rider.rlab_im_map_plugin.tool;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.PointF;
import android.location.LocationManager;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.MapUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sofa.utils.LocationUtils;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.omega.sdk.common.record.Event;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public final class ImMapUtils {

    /* renamed from: a */
    private static final String f55967a = "TraceLog-1";

    /* renamed from: b */
    private static final Logger f55968b = LoggerFactory.getLogger("ImMapUtils");

    public static void log(Event event) {
        if (ImMapConfig.getInstance().isDebug()) {
            LogUtils.m32691d(f55967a, "🍭Omega Trace Log event:\t" + event.getEventId() + "\t需求参数: [" + event.getAllAttrs() + "]\t所有信息: [" + event + Const.jaRight);
        }
    }

    public static int getNavigationBarHeight(Context context) {
        Activity scanForActivity;
        if (context == null || (scanForActivity = scanForActivity(context)) == null) {
            return 0;
        }
        Resources resources = scanForActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        LogUtils.m32690d("Navi height:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    public static LatLng fromScreenLocation(Map map, float f, float f2) {
        Projection projection;
        if (map == null || (projection = map.getProjection()) == null) {
            return null;
        }
        return projection.fromScreenLocation(new PointF(f, f2));
    }

    public static CameraUpdate calculateBestZoom(MapView mapView, List<LatLng> list, int i, int i2, int i3, int i4, int i5, int i6) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        List<LatLng> list2 = list;
        LatLngBounds build = LatLngBounds.builder().include(list).build();
        LatLng center = build.getCenter();
        double width = (((double) ((mapView.getWidth() - i) - i3)) * 1.0d) / ((double) ((mapView.getHeight() - i2) - i4));
        if (build.getCenter().latitude > 0.0d) {
            if (width > getBoundRatio(build.getCenter(), build.northeast)) {
                d5 = getDistanceHeightSide(build.getCenter(), build.northeast);
                d4 = Math.min(width, 1.0d);
            } else {
                d3 = getDistanceWidthSide(build.getCenter(), build.northeast);
                d2 = Math.max(width, 1.0d);
                d = d3 / d2;
                return CameraUpdateFactory.newLatLngZoom(center, Math.min(Math.min((float) i6, Math.max((float) i5, MapUtils.calculateZoomLevel(mapView.getMap(), center, d, 0, 0, 0, 0))), 21.0f));
            }
        } else if (width > getBoundRatio(build.getCenter(), build.southwest)) {
            d5 = getDistanceHeightSide(build.getCenter(), build.southwest);
            d4 = Math.min(width, 1.0d);
        } else {
            d3 = getDistanceWidthSide(build.getCenter(), build.southwest);
            d2 = Math.max(width, 1.0d);
            d = d3 / d2;
            return CameraUpdateFactory.newLatLngZoom(center, Math.min(Math.min((float) i6, Math.max((float) i5, MapUtils.calculateZoomLevel(mapView.getMap(), center, d, 0, 0, 0, 0))), 21.0f));
        }
        d = d5 * d4;
        return CameraUpdateFactory.newLatLngZoom(center, Math.min(Math.min((float) i6, Math.max((float) i5, MapUtils.calculateZoomLevel(mapView.getMap(), center, d, 0, 0, 0, 0))), 21.0f));
    }

    public static double getDistanceHeightSide(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return -1.0d;
        }
        return LocationUtils.getDistance(latLng2.longitude, latLng.latitude, latLng2.longitude, latLng2.latitude);
    }

    public static double getDistanceWidthSide(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return -1.0d;
        }
        return LocationUtils.getDistance(latLng.longitude, latLng2.latitude, latLng2.longitude, latLng2.latitude);
    }

    public static double getBoundRatio(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 1.0d;
        }
        return Math.abs(getDistanceWidthSide(latLng, latLng2) / getDistanceHeightSide(latLng, latLng2));
    }

    public static LatLng calMirrorLatLng(LatLng latLng, LatLng latLng2) {
        return new LatLng((((latLng.latitude + 256.0d) * 2.0d) - (latLng2.latitude + 256.0d)) - 256.0d, (((latLng.longitude + 256.0d) * 2.0d) - (latLng2.longitude + 256.0d)) - 256.0d);
    }

    public static String getStringWithBrandName(Context context, int i) {
        return context.getString(i, new Object[]{context.getString(R.string.rider_app_name)});
    }

    public static boolean getGpsStatus(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.content.res.AssetFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055 A[SYNTHETIC, Splitter:B:22:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b A[SYNTHETIC, Splitter:B:26:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getImageFromAssetsFile(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.content.res.Resources r4 = r4.getResources()
            android.content.res.AssetManager r4 = r4.getAssets()
            java.lang.String r0 = "rlab_im_map_plugin"
            java.lang.String r5 = p242io.flutter.view.FlutterMain.getLookupKeyForAsset(r5, r0)
            android.content.res.AssetFileDescriptor r4 = r4.openFd(r5)     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
            java.io.FileInputStream r5 = r4.createInputStream()     // Catch:{ IOException -> 0x0030 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ IOException -> 0x0030 }
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x0058
        L_0x0028:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0058
        L_0x002d:
            r5 = move-exception
            r1 = r4
            goto L_0x0059
        L_0x0030:
            r5 = move-exception
            goto L_0x0036
        L_0x0032:
            r5 = move-exception
            goto L_0x0059
        L_0x0034:
            r5 = move-exception
            r4 = r1
        L_0x0036:
            com.didi.sdk.logging.Logger r0 = f55968b     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r2.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "getImageFromAssetsFile catch e : "
            r2.append(r3)     // Catch:{ all -> 0x002d }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x002d }
            r2.append(r5)     // Catch:{ all -> 0x002d }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x002d }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            r0.error((java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0058:
            return r1
        L_0x0059:
            if (r1 == 0) goto L_0x0063
            r1.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0063:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rider.rlab_im_map_plugin.tool.ImMapUtils.getImageFromAssetsFile(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static Marker getOneMarkerByTag(MapView mapView, String str) {
        IMapElement iMapElement;
        if (!(TextUtils.isEmpty(str) || mapView == null || mapView.getMap() == null)) {
            try {
                ArrayList<IMapElement> elementGroup = mapView.getMap().getElementGroup(str);
                if (elementGroup != null && !elementGroup.isEmpty() && (iMapElement = elementGroup.get(0)) != null && (iMapElement instanceof Marker)) {
                    return (Marker) iMapElement;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getString(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static double parseDouble(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}

package com.didi.map.alpha.adapt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.alpha.maps.internal.BitmapCache;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.constant.FileNameConstant;
import com.didi.map.constant.StringConstant;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.util.CrashTryCatcher;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import rui.config.RConfigConstants;

public class MapUtil {
    public static final int ANDROID_HVGA = 2;
    public static final int ANDROID_QVGA = 1;
    public static final int ANDROID_WVGA = 3;
    public static int Android_Dpi = 160;
    public static int Android_ScreenType = 2;
    public static int CHINA_EAST = f24447e;
    public static int CHINA_NORTH = f24445c;
    public static int CHINA_SOUTH = f24444b;
    public static int CHINA_WEST = f24446d;
    public static final int COLOR_DEFAULT_POLYLINE = Color.argb(200, 0, 163, 255);

    /* renamed from: a */
    private static String f24443a = null;

    /* renamed from: b */
    private static final int f24444b = 4000000;
    public static BitmapCache bimMapCach = null;

    /* renamed from: c */
    private static final int f24445c = 53500000;

    /* renamed from: d */
    private static final int f24446d = 73670000;

    /* renamed from: e */
    private static final int f24447e = 135100000;

    /* renamed from: f */
    private static final int f24448f = -85000000;
    public static float fDestiny = 0.0f;

    /* renamed from: g */
    private static final int f24449g = 85000000;

    /* renamed from: h */
    private static final int f24450h = -180000000;

    /* renamed from: i */
    private static final int f24451i = 180000000;
    public static Context m_Context = null;
    public static String suid = "undefined";

    public static float Color2Float(int i) {
        return ((float) i) / 255.0f;
    }

    public static byte[] getBytesFromNet(String str) {
        return null;
    }

    public static String getUrlMarkInfo(String str) {
        return "";
    }

    public static String getUserAgent() {
        return "android map-0.1.4";
    }

    public static float getDensity() {
        return BitmapUtil.fDensityXH;
    }

    public static Bitmap getFromCache(String str) {
        BitmapCache bitmapCache = bimMapCach;
        if (bitmapCache != null) {
            return bitmapCache.get(str);
        }
        return null;
    }

    public static boolean putToCache(String str, Bitmap bitmap) {
        BitmapCache bitmapCache = bimMapCach;
        if (bitmapCache == null) {
            return false;
        }
        bitmapCache.put(str, bitmap);
        return true;
    }

    /* renamed from: a */
    private static String m17476a(String str) {
        if (str == null) {
            return "";
        }
        return str.replace(ParamKeys.SIGN_AND, "").replace(RConfigConstants.KEYWORD_COLOR_SIGN, "").replace("?", "");
    }

    /* renamed from: b */
    private static String m17479b(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static void initBasicInfo(Context context) {
        m_Context = context.getApplicationContext();
        if (BitmapUtil.fDensityXH == 1.0f) {
            BitmapUtil.fDensityXH = 320.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
        }
        if (BitmapUtil.fDensityXXH == 1.0f) {
            BitmapUtil.fDensityXXH = 480.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
        }
        fDestiny = context.getResources().getDisplayMetrics().density;
    }

    public static String getMD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            return m17477a(instance.digest(), "");
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: a */
    private static String m17477a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & 255));
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m17475a(Context context) {
        if (context == null) {
            return "";
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return "";
        }
        return applicationInfo.metaData.getString(StringConstant.META_NAME);
    }

    /* renamed from: b */
    private static String m17478b(Context context) {
        TelephonyManager telephonyManager;
        String subscriberId;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
            return "";
        }
        return subscriberId;
    }

    public static String getIMei() {
        return getIMei(HWContextProvider.getContext());
    }

    public static String getIMei(Context context) {
        String str = f24443a;
        if (str != null) {
            return str;
        }
        String imei = SystemUtil.getIMEI();
        f24443a = imei;
        if (imei == null) {
            f24443a = "";
        }
        return f24443a;
    }

    /* renamed from: c */
    private static String m17480c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return SystemUtils.getApplicationInfo(packageManager, context.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (Exception e) {
            CrashTryCatcher.logCrash(e);
            return "";
        }
    }

    public static void getScreenType(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Field field = null;
            try {
                field = displayMetrics.getClass().getField("densityDpi");
            } catch (NoSuchFieldException | SecurityException unused) {
            }
            if (field != null) {
                long j = (long) (displayMetrics.widthPixels * displayMetrics.heightPixels);
                try {
                    Android_Dpi = field.getInt(displayMetrics);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
                int i = Android_Dpi;
                if (i <= 120) {
                    Android_ScreenType = 1;
                } else if (i <= 160) {
                    Android_ScreenType = 2;
                } else if (i <= 240) {
                    Android_ScreenType = 3;
                } else {
                    int i2 = (j > 153600 ? 1 : (j == 153600 ? 0 : -1));
                    if (i2 > 0) {
                        Android_ScreenType = 3;
                    } else if (i2 < 0) {
                        Android_ScreenType = 1;
                    } else {
                        Android_ScreenType = 2;
                    }
                }
            } else {
                int i3 = (((long) (displayMetrics.widthPixels * displayMetrics.heightPixels)) > 153600 ? 1 : (((long) (displayMetrics.widthPixels * displayMetrics.heightPixels)) == 153600 ? 0 : -1));
                if (i3 > 0) {
                    Android_ScreenType = 3;
                } else if (i3 < 0) {
                    Android_ScreenType = 1;
                } else {
                    Android_ScreenType = 2;
                }
            }
        }
    }

    public static int dip2Pixels(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static final Bitmap decodeBitmapFromFile(Context context, String str) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try {
            fileInputStream = context.openFileInput(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        try {
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static final Bitmap createBitmapFromBitmap(Bitmap bitmap) {
        try {
            if (ApolloHawaii.openCreateBitmapForceCopy) {
                return bitmap.copy(bitmap.getConfig(), true);
            }
            return Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static final Bitmap createBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static final Bitmap decodeBitmapFromPath(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static final Bitmap getBitmapFromAsset(Context context, String str) {
        AssetManager assets = context.getAssets();
        Bitmap bitmap = null;
        try {
            InputStream open = assets.open(FileNameConstant.ASSET_MAP_FOLDER + str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap decodeBitmapFromRes(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap adaptFromXhResource(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / BitmapUtil.fDensityXH), (int) (((float) bitmap.getHeight()) / BitmapUtil.fDensityXH), true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0014 A[ExcHandler: Exception (r1v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap getBimpaFromAsset2(android.content.Context r1, java.lang.String r2) {
        /*
            android.content.res.AssetManager r1 = r1.getAssets()
            r0 = 0
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ Exception -> 0x0014, OutOfMemoryError -> 0x0012 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0014, OutOfMemoryError -> 0x0012 }
            r1.close()     // Catch:{ Exception -> 0x0014, OutOfMemoryError -> 0x0011 }
            goto L_0x0013
        L_0x0011:
            r0 = r2
        L_0x0012:
            r2 = r0
        L_0x0013:
            return r2
        L_0x0014:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.adapt.MapUtil.getBimpaFromAsset2(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static GeoPoint getGeoPointFromLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }

    public static List<GeoPoint> getGeoPointFromLatLng(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            LatLng latLng = list.get(i);
            if (latLng != null) {
                arrayList.add(getGeoPointFromLatLng(latLng));
            }
        }
        return arrayList;
    }

    public static LatLng getLatLngFromGeoPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }

    public static String obtainAppName(Context context) {
        CharSequence charSequence;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            charSequence = SystemUtils.getApplicationInfo(packageManager, context.getPackageName(), 128).loadLabel(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            charSequence = "default";
        }
        try {
            return URLEncoder.encode(charSequence.toString(), "utf-8");
        } catch (Exception unused) {
            return "default";
        }
    }

    public static void initMapDomain(boolean z) {
        if (z) {
            CHINA_WEST = f24446d;
            CHINA_EAST = f24447e;
            CHINA_NORTH = f24445c;
            CHINA_SOUTH = f24444b;
            return;
        }
        CHINA_WEST = f24450h;
        CHINA_EAST = f24451i;
        CHINA_NORTH = f24449g;
        CHINA_SOUTH = f24448f;
    }

    public static List<LatLng> getLatLngsFromGeoPoint(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GeoPoint latLngFromGeoPoint : list) {
            arrayList.add(getLatLngFromGeoPoint(latLngFromGeoPoint));
        }
        return arrayList;
    }

    public static List<LatLng> getLatLngsFromLatLngs(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (LatLng latLng : list) {
            arrayList.add(new LatLng(latLng));
        }
        return arrayList;
    }
}

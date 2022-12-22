package com.didi.map.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.didi.hawaii.utils.C9266IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class MapAssets {
    public static final String HAWAII_COMPASS = "hawaii_compass.png";
    public static final String HAWAII_COMPASS_NIGHT = "hawaii_compass_night.png";
    public static final String HAWAII_EAST = "hawaii_east.png";
    public static final String HAWAII_EAST_NIGHT = "hawaii_east_night.png";
    public static final String HAWAII_LOCATOR = "hawaii_locator.png";
    public static final String HAWAII_LOCATOR_GREY = "hawaii_locator_grey.png";
    public static final String HAWAII_LOCATOR_LIGHT = "hawaii_locator_light.png";
    public static final String HAWAII_LOCATOR_LIGHT_GREY = "hawaii_locator_light_grey.png";
    public static final String HAWAII_LOCATOR_NIGHT = "hawaii_locator_night.png";
    public static final String HAWAII_LOCATOR_NIGHT_GREY = "hawaii_locator_night_grey.png";
    public static final String HAWAII_NORTH = "hawaii_north.png";
    public static final String HAWAII_NORTH_NIGHT = "hawaii_north_night.png";
    public static final String HAWAII_SELF_DRIVING_LOCATOR = "hawaii_selfdriving_location.png";
    public static final String HAWAII_SELF_DRIVING_LOCATOR_DISABLE = "hawaii_selfdriving_location_disable.png";
    public static final String HAWAII_SOUTH = "hawaii_south.png";
    public static final String HAWAII_SOUTH_NIGHT = "hawaii_south_night.png";
    public static final String HAWAII_WEST = "hawaii_west.png";
    public static final String HAWAII_WEST_NIGHT = "hawaii_west_night.png";
    private static final String MAP_ASSETS_DIR = ("map" + File.separator);

    private MapAssets() {
    }

    public static Bitmap bitmapInMapDir(Context context, String str) {
        return bitmap(context, MAP_ASSETS_DIR + str);
    }

    public static Bitmap bitmap(Context context, String str) {
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        InputStream inputStream2 = null;
        if (assets == null) {
            return null;
        }
        try {
            inputStream = assets.open(str);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                C9266IO.safeClose(inputStream);
                return decodeStream;
            } catch (FileNotFoundException unused) {
                C9266IO.safeClose(inputStream);
                return null;
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    C9266IO.safeClose(inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    C9266IO.safeClose(inputStream2);
                    throw th;
                }
            }
        } catch (FileNotFoundException unused2) {
            inputStream = null;
            C9266IO.safeClose(inputStream);
            return null;
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            e.printStackTrace();
            C9266IO.safeClose(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C9266IO.safeClose(inputStream2);
            throw th;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0028=Splitter:B:22:0x0028, B:16:0x001f=Splitter:B:16:0x001f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap bitmap(android.content.Context r1, java.lang.String r2, android.graphics.BitmapFactory.Options r3) {
        /*
            android.content.res.AssetManager r1 = r1.getAssets()
            r0 = 0
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x001d, all -> 0x001b }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0019, IOException -> 0x0017 }
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
            return r2
        L_0x0014:
            r2 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x0017:
            r2 = move-exception
            goto L_0x001f
        L_0x0019:
            r2 = move-exception
            goto L_0x0028
        L_0x001b:
            r2 = move-exception
            goto L_0x002f
        L_0x001d:
            r2 = move-exception
            r1 = r0
        L_0x001f:
            r2.printStackTrace()     // Catch:{ all -> 0x0014 }
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
            return r0
        L_0x0026:
            r2 = move-exception
            r1 = r0
        L_0x0028:
            r2.printStackTrace()     // Catch:{ all -> 0x0014 }
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
            return r0
        L_0x002f:
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.common.MapAssets.bitmap(android.content.Context, java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static InputStream streamInMapDir(Context context, String str) {
        return stream(context, MAP_ASSETS_DIR + str);
    }

    public static InputStream stream(Context context, String str) {
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return null;
        }
        try {
            return assets.open(str);
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.didichuxing.hawaii.arsdk.darcore;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class JNICaller {
    private static int g_imageDebug = 10;

    private static long osImageGetNativePtr(OSImage oSImage) {
        return oSImage.getNativeContext();
    }

    public static int imageGetWidth(Bitmap bitmap) {
        return bitmap.getWidth();
    }

    public static int imageGetHeight(Bitmap bitmap) {
        return bitmap.getHeight();
    }

    public static Bitmap imageCreateGray(int i, int i2) {
        return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public static byte[] imageCompress(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bitmap.recycle();
        int i2 = g_imageDebug;
        if (i2 > 0) {
            int i3 = i2 - 1;
            g_imageDebug = i3;
            if (i3 >= 0) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("/data/data/com.didi.hawaii.navar.helloar/cache/test" + g_imageDebug + ".jpg");
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    byteArrayInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return byteArray;
    }

    public static AssetManager assetManagerGetFromContext(Context context) {
        return context.getAssets();
    }
}

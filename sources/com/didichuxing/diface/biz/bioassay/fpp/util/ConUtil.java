package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ConUtil {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2 A[SYNTHETIC, Splitter:B:34:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac A[SYNTHETIC, Splitter:B:39:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9 A[SYNTHETIC, Splitter:B:47:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3 A[SYNTHETIC, Splitter:B:52:0x00c3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String saveJPGFile(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "/"
            r1 = 0
            if (r6 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = com.didichuxing.diface.biz.bioassay.fpp.util.Constant.cacheImage
            java.io.File r5 = r5.getExternalFilesDir(r2)
            boolean r2 = r5.exists()
            if (r2 != 0) goto L_0x0019
            boolean r2 = r5.mkdirs()
            if (r2 != 0) goto L_0x0019
            return r1
        L_0x0019:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r2.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r2.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r3 = ""
            r2.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.util.Random r3 = new java.util.Random     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r4 = 1000000(0xf4240, float:1.401298E-39)
            int r3 = r3.nextInt(r4)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r2.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r2.append(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r7 = ".jpg"
            r2.append(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.append(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.append(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r3.append(r7)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r3.write(r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
            r6.<init>()     // Catch:{ Exception -> 0x0090 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0090 }
            r6.append(r5)     // Catch:{ Exception -> 0x0090 }
            r6.append(r0)     // Catch:{ Exception -> 0x0090 }
            r6.append(r7)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0090 }
            r3.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0087:
            r2.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008f:
            return r5
        L_0x0090:
            r5 = move-exception
            goto L_0x009d
        L_0x0092:
            r5 = move-exception
            goto L_0x00b7
        L_0x0094:
            r5 = move-exception
            r3 = r1
            goto L_0x009d
        L_0x0097:
            r5 = move-exception
            r2 = r1
            goto L_0x00b7
        L_0x009a:
            r5 = move-exception
            r2 = r1
            r3 = r2
        L_0x009d:
            r5.printStackTrace()     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x00aa
            r3.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00aa:
            if (r2 == 0) goto L_0x00b4
            r2.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00b4:
            return r1
        L_0x00b5:
            r5 = move-exception
            r1 = r3
        L_0x00b7:
            if (r1 == 0) goto L_0x00c1
            r1.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00c1:
            if (r2 == 0) goto L_0x00cb
            r2.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00cb:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.fpp.util.ConUtil.saveJPGFile(android.content.Context, byte[], java.lang.String):java.lang.String");
    }

    public static void copyModels(Context context) {
        File file = new File(context.getExternalFilesDir((String) null), "model");
        if (!file.exists()) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open("model"));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] readModel(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            InputStream inputStream = null;
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String getUUIDString(Context context) {
        SharedUtil sharedUtil = new SharedUtil(context);
        String stringValueByKey = sharedUtil.getStringValueByKey("key_uuid");
        if (stringValueByKey != null && stringValueByKey.trim().length() != 0) {
            return stringValueByKey;
        }
        String encodeToString = Base64.encodeToString(UUID.randomUUID().toString().getBytes(), 0);
        sharedUtil.saveStringValue("key_uuid", encodeToString);
        return encodeToString;
    }

    public static byte[] getGrayscale(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        byte[] bArr = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        for (int i = 0; i < bitmap.getHeight(); i++) {
            for (int i2 = 0; i2 < bitmap.getWidth(); i2++) {
                int pixel = bitmap.getPixel(i2, i);
                bArr[(bitmap.getWidth() * i) + i2] = (byte) ((((((16711680 & pixel) >> 16) * 299) + (((65280 & pixel) >> 8) * 587)) + ((pixel & 255) * 114)) / 1000);
            }
        }
        return bArr;
    }

    public static int readPictureDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotateImage(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: a */
    private static Bitmap m33874a(String str, int i) {
        if (i == -1) {
            return BitmapFactory.decodeFile(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        double d = (double) i;
        options.inSampleSize = Math.max(1, (int) Math.max(((double) options.outWidth) / d, ((double) options.outHeight) / d));
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapConsiderExif(String str) {
        Bitmap a = m33874a(str, 800);
        if (a == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) readPictureDegree(str));
        Bitmap copy = Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true).copy(Bitmap.Config.ARGB_8888, true);
        float height = ((float) (copy.getHeight() > copy.getWidth() ? copy.getHeight() : copy.getWidth())) / 800.0f;
        return height > 1.0f ? Bitmap.createScaledBitmap(copy, (int) (((float) copy.getWidth()) / height), (int) (((float) copy.getHeight()) / height), false) : copy;
    }

    public static Bitmap cropImage(RectF rectF, Bitmap bitmap) {
        float width = rectF.width() * 2.0f;
        if (width > ((float) bitmap.getWidth())) {
            width = (float) bitmap.getWidth();
        }
        float height = rectF.height() * 2.0f;
        if (height > ((float) bitmap.getHeight())) {
            height = (float) bitmap.getHeight();
        }
        float centerX = rectF.centerX() - (width / 2.0f);
        float f = 0.0f;
        if (centerX < 0.0f) {
            centerX = 0.0f;
        }
        float centerY = rectF.centerY() - (height / 2.0f);
        if (centerY >= 0.0f) {
            f = centerY;
        }
        if (centerX + width > ((float) bitmap.getWidth())) {
            width = ((float) bitmap.getWidth()) - centerX;
        }
        if (f + height > ((float) bitmap.getHeight())) {
            height = ((float) bitmap.getHeight()) - f;
        }
        return Bitmap.createBitmap(bitmap, (int) centerX, (int) f, (int) width, (int) height);
    }

    public static Bitmap cutImage(RectF rectF, String str) {
        return cropImage(rectF, BitmapFactory.decodeFile(str));
    }

    public static File getOutputMediaFile(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Constant.cacheCampareImage);
        if (!externalFilesDir.exists() && !externalFilesDir.mkdirs()) {
            return null;
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(externalFilesDir.getPath() + File.separator + "IMG_" + format + ".jpg");
    }

    public static void isGoneKeyBoard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void showToast(Context context, String str) {
        if (context != null) {
            Toast makeText = Toast.makeText(context, str, 0);
            makeText.setGravity(48, 0, 30);
            SystemUtils.showToast(makeText);
        }
    }

    public static void showLongToast(Context context, String str) {
        if (context != null) {
            Toast makeText = Toast.makeText(context, str, 1);
            makeText.setGravity(48, 0, 30);
            SystemUtils.showToast(makeText);
        }
    }

    public static String getVersionName(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap convert(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        canvas.drawBitmap(createBitmap2, new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
        return createBitmap;
    }

    public static String saveBitmap(Context context, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bitmap == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(Constant.cacheImage);
        if (!externalFilesDir.exists() && !externalFilesDir.mkdirs()) {
            return null;
        }
        String str = System.currentTimeMillis() + "";
        try {
            fileOutputStream = new FileOutputStream(externalFilesDir + "/" + str);
            try {
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream)) {
                    String str2 = externalFilesDir.getAbsolutePath() + "/" + str;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str2;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream = null;
            e.printStackTrace();
            fileOutputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2.close();
            throw th;
        }
    }

    public static String getFormatterTime(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }
}

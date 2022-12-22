package com.didi.sdk.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

public class ImageUtil {

    /* renamed from: a */
    private static final String f37633a = "ImageUtil";

    /* renamed from: b */
    private static final int f37634b = 1280;

    public interface ImageListener {
        void onRevise(Bitmap bitmap);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError unused) {
        }
        if (bitmap == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        int i3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i2) {
            return bitmap;
        }
        if (width > i) {
            i3 = (int) Math.floor(((double) height) / ((((double) width) * 1.0d) / ((double) i)));
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i3, true);
        } else {
            i = width;
            i3 = height;
        }
        return i3 > i2 ? Bitmap.createBitmap(bitmap, 0, (int) (((double) (height - i2)) / 2.0d), i, i2) : bitmap;
    }

    public static Bitmap round(Bitmap bitmap, int i, int i2, int i3, boolean z) {
        Bitmap bitmap2;
        if (i == 0 || i2 == 0 || i3 <= 0 || bitmap == null) {
            return bitmap;
        }
        try {
            bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setFlags(1);
        Rect rect = new Rect(0, 0, i, i2);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f = (float) i3;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            clear(bitmap);
        }
        return bitmap2;
    }

    public static Bitmap round(Bitmap bitmap, int i, boolean z) {
        return (i <= 0 || bitmap == null) ? bitmap : round(bitmap, bitmap.getWidth(), bitmap.getHeight(), i, z);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (i == 0 || i2 == 0) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            return null;
        }
        clear(bitmap);
        return bitmap2;
    }

    public static Bitmap crop(String str, int i, int i2) {
        return m26701a(scale(createBitmap(str), (float) i, (float) i2, ImageView.ScaleType.CENTER_CROP, true), i, i2, true);
    }

    public static Bitmap scaleAndCrop(Bitmap bitmap, int i, int i2, boolean z) {
        return m26701a(scale(bitmap, (float) i, (float) i2, ImageView.ScaleType.CENTER_CROP, z), i, i2, true);
    }

    /* renamed from: a */
    private static Bitmap m26701a(Bitmap bitmap, int i, int i2, boolean z) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, Math.max(0, bitmap.getWidth() - i) / 2, Math.max(0, bitmap.getHeight() - i2) / 2, i, i2);
        } catch (OutOfMemoryError unused) {
        }
        if (z && bitmap != bitmap2) {
            clear(bitmap);
        }
        return bitmap2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap scale(android.graphics.Bitmap r8, float r9, float r10, android.widget.ImageView.ScaleType r11, boolean r12) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0054
            boolean r1 = r8.isRecycled()
            if (r1 == 0) goto L_0x000a
            goto L_0x0054
        L_0x000a:
            int r1 = r8.getWidth()
            float r1 = (float) r1
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r3 = r1 / r2
            float r4 = r9 / r10
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP
            if (r11 != r5) goto L_0x0025
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x0022
        L_0x0020:
            float r10 = r10 / r2
            goto L_0x002c
        L_0x0022:
            float r10 = r9 / r1
            goto L_0x002c
        L_0x0025:
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 >= 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            float r9 = r9 / r1
            r10 = r9
        L_0x002c:
            r9 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x0033
            return r8
        L_0x0033:
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r6.setScale(r10, r10)
            r2 = 0
            r3 = 0
            int r4 = r8.getWidth()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            int r5 = r8.getHeight()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            if (r12 == 0) goto L_0x0054
            if (r8 == r0) goto L_0x0054
            clear(r8)
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ImageUtil.scale(android.graphics.Bitmap, float, float, android.widget.ImageView$ScaleType, boolean):android.graphics.Bitmap");
    }

    public static BitmapFactory.Options getBitmapOptions(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth > options.outHeight ? options.outWidth : options.outHeight;
        if (i < 1) {
            i = 1280;
        }
        options.inSampleSize = i2 / i;
        options.inJustDecodeBounds = false;
        return options;
    }

    public static BitmapFactory.Options getBitmapOptions(InputStream inputStream, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        options.inSampleSize = (options.outWidth > options.outHeight ? options.outWidth : options.outHeight) / i;
        options.inJustDecodeBounds = false;
        return options;
    }

    public static BitmapFactory.Options getBitmapOptions(Resources resources, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = (options.outWidth > options.outHeight ? options.outWidth : options.outHeight) / i2;
        options.inJustDecodeBounds = false;
        return options;
    }

    public static BitmapFactory.Options getBitmapOptions(Context context, Uri uri, int i) {
        if (context == null || uri == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        FileDescriptor fileDescriptor = getFileDescriptor(context, uri);
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
        options.inSampleSize = (options.outWidth > options.outHeight ? options.outWidth : options.outHeight) / i;
        options.inJustDecodeBounds = false;
        return options;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.FileDescriptor} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b A[SYNTHETIC, Splitter:B:20:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0033 A[SYNTHETIC, Splitter:B:26:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.FileDescriptor getFileDescriptor(android.content.Context r2, android.net.Uri r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x0006
            goto L_0x003c
        L_0x0006:
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r2 = r2.openFileDescriptor(r3, r1)     // Catch:{ FileNotFoundException -> 0x0024, all -> 0x0022 }
            java.io.FileDescriptor r0 = r2.getFileDescriptor()     // Catch:{ FileNotFoundException -> 0x0020 }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x002e
        L_0x001b:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x002e
        L_0x0020:
            r3 = move-exception
            goto L_0x0026
        L_0x0022:
            r3 = move-exception
            goto L_0x0031
        L_0x0024:
            r3 = move-exception
            r2 = r0
        L_0x0026:
            r3.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x001b }
        L_0x002e:
            return r0
        L_0x002f:
            r3 = move-exception
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003b:
            throw r3
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ImageUtil.getFileDescriptor(android.content.Context, android.net.Uri):java.io.FileDescriptor");
    }

    public static Bitmap createBitmap(String str) {
        return createBitmap(str, 1280);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0045 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[SYNTHETIC, Splitter:B:36:0x0052] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0045=Splitter:B:27:0x0045, B:20:0x003b=Splitter:B:20:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createBitmap(java.lang.String r3, int r4) {
        /*
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x005b
            boolean r0 = r0.isFile()
            if (r0 != 0) goto L_0x001a
            goto L_0x005b
        L_0x001a:
            android.graphics.BitmapFactory$Options r4 = getBitmapOptions((java.lang.String) r3, (int) r4)
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ OutOfMemoryError -> 0x0044, FileNotFoundException -> 0x0039, all -> 0x0037 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ OutOfMemoryError -> 0x0044, FileNotFoundException -> 0x0039, all -> 0x0037 }
            r2.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x0044, FileNotFoundException -> 0x0039, all -> 0x0037 }
            r0.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0044, FileNotFoundException -> 0x0039, all -> 0x0037 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0, r1, r4)     // Catch:{ OutOfMemoryError -> 0x0045, FileNotFoundException -> 0x0035 }
            r0.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x004d
        L_0x0030:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x004d
        L_0x0035:
            r3 = move-exception
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            goto L_0x0050
        L_0x0039:
            r3 = move-exception
            r0 = r1
        L_0x003b:
            r3.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x004d
            r0.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x004d
        L_0x0044:
            r0 = r1
        L_0x0045:
            java.lang.System.gc()     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x004d
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x004d:
            return r1
        L_0x004e:
            r3 = move-exception
            r1 = r0
        L_0x0050:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005a:
            throw r3
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ImageUtil.createBitmap(java.lang.String, int):android.graphics.Bitmap");
    }

    public static Bitmap createBitmap(File file) {
        return createBitmap(file.getAbsolutePath());
    }

    public static Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap createBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(inputStream, (Rect) null, getBitmapOptions(inputStream, 1280));
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap createBitmap(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(inputStream, rect, options);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap createBitmap(Context context, int i) {
        if (context == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, getBitmapOptions(context.getResources(), i, 1280));
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap createBitmap(Context context, Uri uri, int i) {
        if (!(context == null || uri == null)) {
            FileDescriptor fileDescriptor = getFileDescriptor(context, uri);
            BitmapFactory.Options bitmapOptions = getBitmapOptions(context, uri, i);
            if (!(fileDescriptor == null || bitmapOptions == null)) {
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, bitmapOptions);
                if (decodeFileDescriptor == null) {
                    return decodeFileDescriptor;
                }
                if (decodeFileDescriptor.getWidth() <= bitmapOptions.outWidth && decodeFileDescriptor.getHeight() <= bitmapOptions.outHeight) {
                    return decodeFileDescriptor;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFileDescriptor, bitmapOptions.outWidth, bitmapOptions.outHeight, true);
                if (!(createScaledBitmap == null || createScaledBitmap == decodeFileDescriptor)) {
                    clear(decodeFileDescriptor);
                }
                return createScaledBitmap != null ? createScaledBitmap : decodeFileDescriptor;
            }
        }
        return null;
    }

    public static Bitmap revise(Bitmap bitmap, int i, int i2, int i3, boolean z, boolean z2) {
        return revise(bitmap, i, i2, i3, z, z2, true);
    }

    public static void revise(Bitmap bitmap, int i, int i2, int i3, boolean z, boolean z2, ImageListener imageListener) {
        final Bitmap bitmap2 = bitmap;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z3 = z;
        final boolean z4 = z2;
        final ImageListener imageListener2 = imageListener;
        new Thread() {
            Bitmap mBitmap;

            public void run() {
                this.mBitmap = ImageUtil.revise(bitmap2, i4, i5, i6, z3, z4, true);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (imageListener2 != null) {
                            imageListener2.onRevise(C131541.this.mBitmap);
                        }
                    }
                });
            }
        }.start();
    }

    public static Bitmap revise(Bitmap bitmap, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        if (bitmap == null) {
            return null;
        }
        if ((z && z2) || (i3 > 0 && (i > 0 || i2 > 0))) {
            bitmap = scaleAndCrop(bitmap, i, i2, z3);
        } else if (z2) {
            bitmap = scale(bitmap, (float) i, (float) i2, ImageView.ScaleType.CENTER_INSIDE, z3);
        } else if (z) {
            bitmap = m26701a(bitmap, i, i2, z3);
        }
        return i3 > 0 ? round(bitmap, i, i2, i3, z3) : bitmap;
    }

    public static Bitmap revise(String str, Context context, int i, int i2, int i3, boolean z, boolean z2) {
        return revise(createBitmap(context, str, Math.max(i, i2)), i, i2, i3, z, z2);
    }

    public static Bitmap revise(String str, int i, int i2, int i3, boolean z, boolean z2) {
        Bitmap createBitmap = createBitmap(str, Math.max(i, i2));
        if (createBitmap == null) {
            return null;
        }
        return revise(createBitmap, i, i2, i3, z, z2);
    }

    public static String writeToFile(Bitmap bitmap, String str, int i, boolean z) {
        if (bitmap == null) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                file2.delete();
            }
            if (file2.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (z) {
            clear(bitmap);
        }
        return str;
    }

    public static void clear(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 14) {
            bitmap.recycle();
        }
    }

    public static void refresh(ImageView imageView, int i, Bitmap bitmap, Bitmap bitmap2) {
        if (imageView != null) {
            Bitmap bitmap3 = (Bitmap) imageView.getTag(i);
            if (bitmap3 != bitmap) {
                clear(bitmap3);
            }
            if (bitmap != null) {
                bitmap2 = bitmap;
            }
            imageView.setImageBitmap(bitmap2);
            imageView.setTag(i, bitmap);
        }
    }

    public static int refresh(ImageView imageView, int i, Bitmap bitmap, int i2) {
        int i3 = 0;
        if (imageView == null) {
            return 0;
        }
        Bitmap bitmap2 = (Bitmap) imageView.getTag(i);
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            i3 = bitmap2.hashCode();
            clear(bitmap2);
        }
        if (bitmap == null) {
            imageView.setImageResource(i2);
        } else {
            imageView.setImageBitmap(bitmap);
        }
        imageView.setTag(i, bitmap);
        return i3;
    }

    public static Bitmap createBitmap(Context context, String str) {
        return createBitmap(context, str, 1280);
    }

    public static Bitmap createBitmap(Context context, String str, int i) {
        if (context == null || TextUtil.isEmpty(str)) {
            return null;
        }
        return createBitmap(context.getFilesDir() + File.separator + str, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A[SYNTHETIC, Splitter:B:20:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0034 A[SYNTHETIC, Splitter:B:26:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createBitmapFromAsset(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x003d
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r3)
            if (r1 == 0) goto L_0x000a
            goto L_0x003d
        L_0x000a:
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
            java.io.InputStream r2 = r2.open(r3)     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
            android.graphics.Bitmap r0 = createBitmap((java.io.InputStream) r2)     // Catch:{ IOException -> 0x0021 }
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Exception -> 0x001c }
            goto L_0x002f
        L_0x001c:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x002f
        L_0x0021:
            r3 = move-exception
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            goto L_0x0032
        L_0x0025:
            r3 = move-exception
            r2 = r0
        L_0x0027:
            r3.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Exception -> 0x001c }
        L_0x002f:
            return r0
        L_0x0030:
            r3 = move-exception
            r0 = r2
        L_0x0032:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003c:
            throw r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ImageUtil.createBitmapFromAsset(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002b A[SYNTHETIC, Splitter:B:22:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0031 A[SYNTHETIC, Splitter:B:26:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createBitmapFromFile(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x003a
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r3)
            if (r1 == 0) goto L_0x000a
            goto L_0x003a
        L_0x000a:
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            android.graphics.Bitmap r0 = createBitmap((java.io.InputStream) r2)     // Catch:{ IOException -> 0x0020 }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ Exception -> 0x0018 }
            goto L_0x002e
        L_0x0018:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x002e
        L_0x001d:
            r3 = move-exception
            r0 = r2
            goto L_0x002f
        L_0x0020:
            r3 = move-exception
            goto L_0x0026
        L_0x0022:
            r3 = move-exception
            goto L_0x002f
        L_0x0024:
            r3 = move-exception
            r2 = r0
        L_0x0026:
            r3.printStackTrace()     // Catch:{ all -> 0x001d }
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ Exception -> 0x0018 }
        L_0x002e:
            return r0
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0039:
            throw r3
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.ImageUtil.createBitmapFromFile(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        if (bitmap == null) {
            return null;
        }
        try {
            return Bitmap.createBitmap(bitmap, i, i2, i3, i4, matrix, z);
        } catch (IllegalArgumentException | OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static int[] getIntArray(Bitmap bitmap) {
        int[] iArr = null;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            return iArr;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return iArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return iArr;
        }
    }

    public static Bitmap decorate(Bitmap bitmap, int[] iArr) {
        if (!(bitmap == null || iArr == null)) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            try {
                if (iArr.length == width * height && iArr.length > 0) {
                    bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                    return bitmap;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static Uri saveToMediaStore(ContentResolver contentResolver, String str, Location location, int i, byte[] bArr, String str2) {
        ContentValues contentValues = new ContentValues(9);
        contentValues.put("title", str);
        contentValues.put("_display_name", str + ".jpg");
        contentValues.put("datetaken", Integer.valueOf(new Date().getDate()));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put(OptionsBridge.ORIENTATION_KEY, Integer.valueOf(i));
        contentValues.put("_data", str2);
        contentValues.put("_size", Integer.valueOf(bArr.length));
        if (location != null) {
            contentValues.put(Const.PageParams.LATITUDE, Double.valueOf(location.getLatitude()));
            contentValues.put(Const.PageParams.LONGITUDE, Double.valueOf(location.getLongitude()));
        }
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            return null;
        }
        return insert;
    }

    public static byte[] toBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 65, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static String getImageNameByTime() {
        Calendar instance = Calendar.getInstance();
        return "IMG_" + instance.get(1) + instance.get(2) + instance.get(5) + "_" + instance.get(11) + instance.get(12) + instance.get(13) + ".jpg";
    }

    public static String getImageNameFromUrl(String str, String str2) {
        return getImageNameFromUrl(str, str2, (String) null);
    }

    public static String getImageNameFromUrl(String str, String str2, String str3) {
        if (TextUtil.isEmpty(str)) {
            return str;
        }
        if (!TextUtil.isEmpty(str3) && str.startsWith(str3)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf < 0) {
            lastIndexOf = str.length() - 1;
        }
        int max = Math.max(Math.max(str.lastIndexOf("/") + 1, str.lastIndexOf("%2F") + 3), str.lastIndexOf("%252F") + 5);
        if (max >= lastIndexOf) {
            return null;
        }
        return str.substring(max, lastIndexOf);
    }

    public static Bitmap copy(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap.copy(bitmap.getConfig(), bitmap.isMutable());
    }

    public static BitmapDrawable decodeWithOOMHandling(Resources resources, String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        try {
            return new BitmapDrawable(resources, str);
        } catch (OutOfMemoryError e) {
            OutOfMemoryError outOfMemoryError = e;
            SystemUtils.log(6, f37633a, outOfMemoryError.getMessage(), outOfMemoryError, "com.didi.sdk.util.ImageUtil", 935);
            System.gc();
            SystemClock.sleep(1000);
            System.gc();
            return null;
        }
    }

    public static Bitmap createReflectedBitmap(Bitmap bitmap, float f, int i, int i2) {
        Bitmap bitmap2 = bitmap;
        int i3 = i;
        if (0.0f == f && i3 == 0) {
            return bitmap2;
        }
        int i4 = i3 * 2;
        float f2 = f + 1.0f;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + i4, i4 + ((int) (((float) bitmap.getHeight()) * f2)), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        float f3 = (float) i3;
        paint.setShadowLayer(f3, 0.0f, 0.0f, -16777216);
        canvas.drawRect(f3, f3, (float) (bitmap.getWidth() + i3), (float) (createBitmap.getHeight() - i3), paint);
        canvas.drawBitmap(bitmap2, f3, f3, (Paint) null);
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        canvas.setMatrix(matrix);
        int round = Math.round(((float) bitmap.getHeight()) * f);
        canvas.drawBitmap(bitmap2, new Rect(0, bitmap.getHeight() - round, bitmap.getWidth(), bitmap.getHeight()), new Rect(i3, ((-round) - i3) - bitmap.getHeight(), bitmap.getWidth() + i3, (-i3) - bitmap.getHeight()), (Paint) null);
        canvas.setMatrix(new Matrix());
        LinearGradient linearGradient = new LinearGradient(0.0f, (float) bitmap.getHeight(), 0.0f, (float) createBitmap.getHeight(), 1073741824, i2, Shader.TileMode.CLAMP);
        Paint paint2 = new Paint();
        paint2.setShader(linearGradient);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        canvas.drawRect(f3, (float) (bitmap.getHeight() + i3), (float) (i3 + bitmap.getWidth()), f3 + (((float) bitmap.getHeight()) * f2), paint2);
        return createBitmap;
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Drawable createDrawable(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return BitmapDrawable.createFromStream(fileInputStream, (String) null);
    }
}

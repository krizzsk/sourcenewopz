package com.didi.hawaii.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import com.didi.hawaii.basic.DataHolder;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import rui.config.RConfigConstants;

public class BitmapUtil {
    private static final String BITMAP_CLASS = Bitmap.class.getCanonicalName();
    private static final int MAX_BITMAP_SIZE = 2048;
    private static final int NO_COLOR = 1;
    /* access modifiers changed from: private */
    public static final Object cacheLock = new Object();
    public static float fDensityXH = 1.0f;
    public static float fDensityXXH = 1.0f;
    /* access modifiers changed from: private */
    public static final LruCache<String, Bitmap> sBitmapCache = new LruCache<String, Bitmap>(1024) {
        /* access modifiers changed from: protected */
        public int sizeOf(String str, Bitmap bitmap) {
            int byteCount = bitmap.getByteCount() / 1024;
            HWLog.m16761i("BitmapUtil", "load bitmap sizeOf: " + byteCount);
            return byteCount;
        }
    };
    protected static Paint sIconPaint;
    /* access modifiers changed from: private */
    public static final Set<String> sRequestCache = new CopyOnWriteArraySet();

    static {
        Paint paint = new Paint();
        sIconPaint = paint;
        paint.setAntiAlias(true);
    }

    public static Bitmap convertViewToBitmap(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        try {
            view.buildDrawingCache();
            Bitmap copy = copy(view.getDrawingCache());
            view.destroyDrawingCache();
            return copy;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static Bitmap copy(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return copy(bitmap, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap copy(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap;
        if (bitmap == null || bitmap.isRecycled() || i < 1 || i2 < 1 || (createBitmap = createBitmap(i, i2, Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        createBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, sIconPaint);
        return createBitmap;
    }

    public static Bitmap copyScale(Bitmap bitmap, Context context, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled() || i < 1 || i2 < 1) {
            return null;
        }
        if (i > 2048) {
            i = 2048;
        }
        if (i2 > 2048) {
            i2 = 2048;
        }
        Bitmap createBitmap = createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        bitmapDrawable.draw(canvas);
        return createBitmap;
    }

    public static String getBitmapSignature(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bitmap.toString());
        sb.replace(0, BITMAP_CLASS.length() + 1, "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(bitmap.hashCode());
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(width);
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(height);
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(bitmap.getRowBytes());
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(bitmap.getPixel(width / 2, height / 2));
        return sb.toString();
    }

    public static Bitmap drawText(String str, int i) {
        Rect rect = new Rect();
        TextPaint textPaint = new TextPaint(65);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Integer.MIN_VALUE);
        textPaint.setTextSize((float) i);
        textPaint.getTextBounds(str, 0, str.length(), rect);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, (int) Math.round(((double) rect.width()) * 1.2d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        Bitmap createBitmap = createBitmap(rect.width(), staticLayout.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(65);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        canvas.drawPaint(paint);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap drawText(String str, int i, int i2, Typeface typeface) {
        Rect rect = new Rect();
        TextPaint textPaint = new TextPaint(65);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(i2);
        textPaint.setTextSize((float) i);
        textPaint.setTypeface(typeface);
        textPaint.getTextBounds(str, 0, str.length(), rect);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, (int) Math.round(((double) rect.width()) * 1.2d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        Bitmap createBitmap = createBitmap(staticLayout.getWidth(), staticLayout.getHeight(), Bitmap.Config.ARGB_4444);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        staticLayout.draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        if (bitmap != null && !bitmap.isRecycled() && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception unused) {
                C9266IO.safeClose(fileOutputStream2);
                return false;
            } catch (Throwable th) {
                th = th;
                C9266IO.safeClose(fileOutputStream2);
                throw th;
            }
            try {
                bitmap.compress(compressFormat, 100, fileOutputStream);
                C9266IO.safeClose(fileOutputStream);
                return true;
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                C9266IO.safeClose(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                C9266IO.safeClose(fileOutputStream2);
                throw th;
            }
        }
        return false;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str) {
        return saveBitmapToFile(bitmap, str, Bitmap.CompressFormat.PNG);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, ((float) width) / 2.0f, ((float) height) / 2.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError unused) {
                try {
                    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                } catch (OutOfMemoryError unused2) {
                }
            }
        }
        return null;
    }

    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Bitmap drawableToBitmapForCrossingPic(Context context, Drawable drawable) {
        int windowWidth = getWindowWidth(context);
        int dip = dip(context, 197);
        Bitmap createBitmap = Bitmap.createBitmap(windowWidth, dip, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, windowWidth, dip);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static int dip(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * ((float) i));
    }

    public static int dip(Context context, float f) {
        return (int) (context.getResources().getDisplayMetrics().density * f);
    }

    public static int getWindowWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static NinePatchDrawable getNinePatchDrawable(Context context, String str) {
        Bitmap bitmap;
        NinePatchDrawable ninePatchDrawable = null;
        try {
            synchronized (cacheLock) {
                bitmap = sBitmapCache.get(str);
            }
            if (bitmap == null) {
                bitmap = getBitmapFromAsset(context, str);
                synchronized (cacheLock) {
                    sBitmapCache.put(str, bitmap);
                }
            }
            if (bitmap != null) {
                bitmap.setDensity(480);
                ninePatchDrawable = getNinePathDrawableFromBitmap(context, bitmap);
                if (ninePatchDrawable != null) {
                    ninePatchDrawable.setTargetDensity(context.getResources().getDisplayMetrics().densityDpi);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ninePatchDrawable;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return android.graphics.Bitmap.createBitmap(r0, r1, r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap createBitmap(int r0, int r1, android.graphics.Bitmap.Config r2) {
        /*
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)     // Catch:{ OutOfMemoryError -> 0x0005 }
            goto L_0x0009
        L_0x0005:
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)     // Catch:{ OutOfMemoryError -> 0x000a }
        L_0x0009:
            return r0
        L_0x000a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.BitmapUtil.createBitmap(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0026 A[SYNTHETIC, Splitter:B:21:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0033 A[SYNTHETIC, Splitter:B:29:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmapFromAsset(android.content.Context r1, java.lang.String r2) throws java.lang.Exception {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            android.graphics.Bitmap r2 = decodeFromStream(r1)     // Catch:{ IOException -> 0x001b }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001a:
            return r2
        L_0x001b:
            r2 = move-exception
            goto L_0x0021
        L_0x001d:
            r2 = move-exception
            goto L_0x0031
        L_0x001f:
            r2 = move-exception
            r1 = r0
        L_0x0021:
            r2.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002e:
            return r0
        L_0x002f:
            r2 = move-exception
            r0 = r1
        L_0x0031:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.BitmapUtil.getBitmapFromAsset(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static byte[] readChunk(Bitmap bitmap) throws IOException {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int i2 = width - 2;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 1, 0, i2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i2 + -1] == -16777216;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != iArr[i5]) {
                i4++;
                writeInt(byteArrayOutputStream, i5);
                i3 = iArr[i5];
            }
        }
        if (z2) {
            i4++;
            writeInt(byteArrayOutputStream, i2);
        }
        int i6 = i4;
        int i7 = i6 + 1;
        if (z) {
            i7--;
        }
        if (z2) {
            i7--;
        }
        int i8 = i7;
        int i9 = height - 2;
        int[] iArr2 = new int[i9];
        int[] iArr3 = iArr2;
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i9);
        boolean z3 = iArr3[0] == -16777216;
        boolean z4 = iArr3[i9 + -1] == -16777216;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i9; i12++) {
            if (i10 != iArr3[i12]) {
                i11++;
                writeInt(byteArrayOutputStream, i12);
                i10 = iArr3[i12];
            }
        }
        if (z4) {
            i11++;
            writeInt(byteArrayOutputStream, i9);
        }
        int i13 = i11 + 1;
        if (z3) {
            i13--;
        }
        if (z4) {
            i13--;
        }
        int i14 = 0;
        while (true) {
            int i15 = i8 * i13;
            if (i14 < i15) {
                writeInt(byteArrayOutputStream, 1);
                i14++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i6;
                byteArray[2] = (byte) i11;
                byteArray[3] = (byte) i15;
                dealPaddingInfo(bitmap2, byteArray);
                return byteArray;
            }
        }
    }

    public static Bitmap decodeFromStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap drawTextToBitmap(Context context, String str, String str2) {
        Bitmap bitmap = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                bitmap = getBitmapFromAsset(context, str2);
            } catch (Exception unused) {
            }
            if (bitmap != null && !TextUtils.isEmpty(str)) {
                NinePatchDrawable ninePathDrawableFromBitmap = getNinePathDrawableFromBitmap(context, bitmap);
                if (ninePathDrawableFromBitmap == null) {
                    return bitmap;
                }
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = Bitmap.Config.RGB_565;
                }
                Paint paint = new Paint(1);
                if (str2.contains("_b.9.png")) {
                    paint.setColor(Color.parseColor("#B7241F"));
                } else {
                    paint.setColor(Color.parseColor("#13884A"));
                }
                int i = (int) (((float) 13) * context.getResources().getDisplayMetrics().density);
                paint.setTextSize((float) i);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                int height = rect.height() + 50;
                Rect rect2 = new Rect(0, 0, ((int) paint.measureText(str)) + i, height);
                ninePathDrawableFromBitmap.setBounds(rect2);
                bitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), config);
                Canvas canvas = new Canvas(bitmap);
                ninePathDrawableFromBitmap.draw(canvas);
                canvas.drawText(str.trim(), 13.0f, (float) (str2.contains("bottom") ? i + (((height - 26) - i) / 2) : i + 29), paint);
            }
        }
        return bitmap;
    }

    public static Bitmap drawTextToBitmap(Context context, String str, int i, int i2, String str2, int i3) {
        Bitmap bitmap = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                bitmap = getBitmapFromAsset(context, str2);
            } catch (Exception unused) {
            }
            if (bitmap != null && !TextUtils.isEmpty(str)) {
                NinePatchDrawable ninePathDrawableFromBitmap = getNinePathDrawableFromBitmap(context, bitmap);
                if (ninePathDrawableFromBitmap == null) {
                    return bitmap;
                }
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_4444;
                }
                Paint paint = new Paint(1);
                paint.setColor(i2);
                paint.setTextAlign(Paint.Align.CENTER);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i4 = (int) (((float) i) * displayMetrics.density);
                paint.setTextSize((float) i4);
                paint.setFakeBoldText(true);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                int measureText = (int) (paint.measureText(str) + (((float) i3) * displayMetrics.density * 2.0f));
                int height = rect.height() + 78;
                if (fDensityXH >= 1.0f) {
                    height = rect.height() + 52;
                }
                Rect rect2 = new Rect(0, 0, measureText, height);
                ninePathDrawableFromBitmap.setBounds(rect2);
                bitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), config);
                Canvas canvas = new Canvas(bitmap);
                ninePathDrawableFromBitmap.draw(canvas);
                float f = ((float) measureText) / 2.0f;
                float f2 = (float) (i4 + 14);
                if (fDensityXH >= 1.0f) {
                    f2 = (float) (i4 + 9);
                }
                canvas.drawText(str.trim(), f, f2, paint);
            }
        }
        return bitmap;
    }

    public static NinePatchDrawable getNinePathDrawableFromBitmap(Context context, Bitmap bitmap) {
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk == null) {
            try {
                ninePatchChunk = readChunk(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        byte[] bArr = ninePatchChunk;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
        Rect rect = new Rect();
        readPaddingFromChunk(bArr, rect);
        rect.bottom += 2;
        return new NinePatchDrawable(context.getResources(), createBitmap, bArr, rect, (String) null);
    }

    public static void readPaddingFromChunk(byte[] bArr, Rect rect) {
        rect.left = getInt(bArr, 12);
        rect.right = getInt(bArr, 16);
        rect.top = getInt(bArr, 20);
        rect.bottom = getInt(bArr, 24);
    }

    private static void dealPaddingInfo(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= width) {
                break;
            } else if (-16777216 == iArr[i2]) {
                writeInt(bArr, 12, i2);
                break;
            } else {
                i2++;
            }
        }
        int i3 = width - 1;
        while (true) {
            if (i3 < 0) {
                break;
            } else if (-16777216 == iArr[i3]) {
                writeInt(bArr, 16, (width - i3) - 2);
                break;
            } else {
                i3--;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i >= height) {
                break;
            } else if (-16777216 == iArr2[i]) {
                writeInt(bArr, 20, i);
                break;
            } else {
                i++;
            }
        }
        for (int i4 = height - 1; i4 >= 0; i4--) {
            if (-16777216 == iArr2[i4]) {
                writeInt(bArr, 24, (height - i4) - 2);
                return;
            }
        }
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static int getInt(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << Ascii.CAN) | (b2 << 8) | b | (b3 << 16);
    }

    public static Bitmap combineBitmap(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (float) ((width - width2) / 2), (float) ((height - height2) / 2), (Paint) null);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap mirrorConvert(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        if (i == 0) {
            matrix.setScale(-1.0f, 1.0f);
        }
        if (i == 1) {
            matrix.setScale(1.0f, -1.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap drawRoundCorner(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        float f = (float) i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), f, f, paint);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap drawBottomRoundCorner(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        float f = (float) i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), f, f, paint);
        canvas.drawRect(new Rect(0, 0, bitmap.getWidth(), i), paint);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap loadBitmapFromUrl(String str, AsyncNetUtils.Callback callback) {
        return loadBitmapFromUrl(str, callback, 0);
    }

    public static boolean isDownloadingBitmap(String str) {
        return sRequestCache.contains(str);
    }

    public static Bitmap loadBitmapFromCache(String str) {
        Bitmap bitmap;
        synchronized (cacheLock) {
            bitmap = sBitmapCache.get(str);
        }
        return bitmap;
    }

    public static Bitmap loadBitmapFromUrl(String str, AsyncNetUtils.Callback callback, int i) {
        return loadBitmapFromUrl(str, callback, i, (DataHolder<Object>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap loadBitmapFromUrl(final java.lang.String r3, final com.didi.hawaii.utils.AsyncNetUtils.Callback r4, int r5, com.didi.hawaii.basic.DataHolder<java.lang.Object> r6) {
        /*
            java.lang.Class<com.didi.hawaii.utils.BitmapUtil> r0 = com.didi.hawaii.utils.BitmapUtil.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x000c
            r3 = 0
            monitor-exit(r0)
            return r3
        L_0x000c:
            android.graphics.Bitmap r1 = loadBitmapFromCache(r3)     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x002d
            boolean r2 = isDownloadingBitmap(r3)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x001a
            monitor-exit(r0)
            return r1
        L_0x001a:
            java.util.Set<java.lang.String> r2 = sRequestCache     // Catch:{ all -> 0x002f }
            r2.add(r3)     // Catch:{ all -> 0x002f }
            com.didi.hawaii.utils.BitmapUtil$2 r2 = new com.didi.hawaii.utils.BitmapUtil$2     // Catch:{ all -> 0x002f }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x002f }
            java.lang.Object r3 = com.didi.hawaii.utils.AsyncNetUtils.doGet(r3, r2, r5)     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x002d
            r6.setVal(r3)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)
            return r1
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.BitmapUtil.loadBitmapFromUrl(java.lang.String, com.didi.hawaii.utils.AsyncNetUtils$Callback, int, com.didi.hawaii.basic.DataHolder):android.graphics.Bitmap");
    }

    public static Bitmap adaptFromXXhResource(Bitmap bitmap) {
        if (bitmap == null || fDensityXXH == 1.0f) {
            return bitmap;
        }
        float f = fDensityXXH;
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / f), (int) (((float) bitmap.getHeight()) / f), true);
    }
}

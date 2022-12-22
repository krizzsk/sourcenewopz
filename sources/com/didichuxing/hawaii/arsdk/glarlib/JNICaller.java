package com.didichuxing.hawaii.arsdk.glarlib;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.didiglobal.font.DIDIFontUtils;

public class JNICaller {
    public static RenderView renderViewAddToContainer(long j, ViewGroup viewGroup) {
        RenderView renderView = new RenderView(viewGroup.getContext(), j);
        viewGroup.addView(renderView, 0, new ViewGroup.LayoutParams(-1, -1));
        return renderView;
    }

    public static AssetManager getAssetManagerFromView(View view) {
        return view.getContext().getAssets();
    }

    public static AssetManager getAssetManagerFromContext(Context context) {
        return context.getAssets();
    }

    public static float getDensityFromView(View view) {
        return view.getResources().getDisplayMetrics().density;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0022 A[SYNTHETIC, Splitter:B:20:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002d A[SYNTHETIC, Splitter:B:26:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap bitmapLoadFromAssets(android.content.res.AssetManager r1, java.lang.String r2) {
        /*
            r0 = 0
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ Exception -> 0x001b, all -> 0x0019 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0017 }
            if (r1 == 0) goto L_0x0013
            r1.close()     // Catch:{ Exception -> 0x000f }
            goto L_0x0013
        L_0x000f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0013:
            return r2
        L_0x0014:
            r2 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x0017:
            r2 = move-exception
            goto L_0x001d
        L_0x0019:
            r2 = move-exception
            goto L_0x002b
        L_0x001b:
            r2 = move-exception
            r1 = r0
        L_0x001d:
            r2.printStackTrace()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002a:
            return r0
        L_0x002b:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.hawaii.arsdk.glarlib.JNICaller.bitmapLoadFromAssets(android.content.res.AssetManager, java.lang.String):android.graphics.Bitmap");
    }

    public static Bitmap bitmapTextCreate(String str, int i, boolean z, int i2, int i3, int i4, float f, float f2) {
        int i5 = i2;
        int i6 = i3;
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ALPHA_8);
        TextPaint textPaint = getTextPaint(i, z);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        if (i4 <= 0) {
            String str2 = str;
            canvas.drawText(str, ((float) i5) / 2.0f, (((float) i6) / 2.0f) - ((textPaint.descent() + textPaint.ascent()) / 2.0f), textPaint);
        } else {
            textPaint.setTextAlign(Paint.Align.LEFT);
            StaticLayout staticLayout = new StaticLayout(str, textPaint, i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, f, false);
            if (Build.VERSION.SDK_INT >= 21) {
                textPaint.setLetterSpacing(f2);
            }
            staticLayout.draw(canvas);
        }
        return createBitmap;
    }

    public static float[] bitmapTextGetSize(String str, int i, boolean z, int i2, float f, float f2) {
        TextPaint textPaint = getTextPaint(i, z);
        float[] fArr = new float[2];
        if (i2 <= 0) {
            String str2 = str;
            fArr[0] = textPaint.measureText(str) + 1.0f;
            fArr[1] = (float) (2 + i);
        } else {
            textPaint.setTextAlign(Paint.Align.LEFT);
            StaticLayout staticLayout = new StaticLayout(str, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, f, false);
            if (Build.VERSION.SDK_INT >= 21) {
                textPaint.setLetterSpacing(f2);
            }
            fArr[0] = staticLayout.getLineCount() > 0 ? staticLayout.getLineWidth(0) : 0.0f;
            fArr[1] = (float) staticLayout.getHeight();
        }
        return fArr;
    }

    private static synchronized TextPaint getTextPaint(int i, boolean z) {
        TextPaint textPaint;
        synchronized (JNICaller.class) {
            textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.DEFAULT);
            DIDIFontUtils.Companion.setTypeface((Context) null, (Object) textPaint, Typeface.defaultFromStyle(0));
            textPaint.setAntiAlias(true);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setLinearText(true);
            textPaint.setTextSize((float) i);
            textPaint.setFakeBoldText(z);
            textPaint.setColor(-1);
            if (z) {
                textPaint.setStrokeWidth(2.0f);
            }
        }
        return textPaint;
    }
}

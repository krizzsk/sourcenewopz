package com.didi.map.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.util.CrashTryCatcher;
import java.util.HashMap;
import java.util.Map;

public class MarkerBitmapUtil {

    /* renamed from: a */
    private static final String f24649a = "map/fast_red_green_light_2x.png";

    /* renamed from: b */
    private static final String f24650b = "map/fast_red_green_light_3x.png";

    /* renamed from: c */
    private static final String f24651c = "map/slow_red_green_light_2x.png";

    /* renamed from: d */
    private static final String f24652d = "map/slow_red_green_light_3x.png";

    /* renamed from: e */
    private static final String f24653e = "map/fast_red_green_light_night_2x.png";

    /* renamed from: f */
    private static final String f24654f = "map/fast_red_green_light_night_3x.png";

    /* renamed from: g */
    private static final String f24655g = "map/slow_red_green_light_night_2x.png";

    /* renamed from: h */
    private static final String f24656h = "map/slow_red_green_light_night_3x.png";

    /* renamed from: i */
    private Map<String, Bitmap> f24657i = new HashMap();

    /* renamed from: j */
    private LinearLayout f24658j = null;

    public Bitmap getMultiRouteMarkerBitmap(Context context, String str, int i, String str2, int[] iArr, String str3, int[] iArr2) {
        LinearLayout linearLayout = this.f24658j;
        if (linearLayout == null) {
            this.f24658j = new LinearLayout(context);
        } else {
            linearLayout.removeAllViews();
        }
        this.f24658j.setGravity(17);
        this.f24658j.setHorizontalGravity(0);
        this.f24658j.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextSize(2, 17.0f);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextColor(i);
        textView.setHorizontallyScrolling(false);
        textView.getPaint().setFakeBoldText(true);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        if (str3 != null) {
            NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context, str3);
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundDrawable(curRouteNameBgBitmap);
            this.f24658j.addView(imageView);
        }
        this.f24658j.addView(textView);
        this.f24658j.setBackgroundDrawable(getCurRouteNameBgBitmap(context, str2));
        this.f24658j.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        return BitmapUtil.convertViewToBitmap(this.f24658j);
    }

    public int[] getMultiRouteWH(Context context, String str) {
        NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context, str);
        return new int[]{curRouteNameBgBitmap.getIntrinsicWidth(), curRouteNameBgBitmap.getIntrinsicHeight()};
    }

    public int[] getMultiRouteWH(Context context, LableMarkerManager.MultiBubbleParams multiBubbleParams) {
        LinearLayout a = m17555a(context, multiBubbleParams);
        a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        a.layout(0, 0, a.getMeasuredWidth(), a.getMeasuredHeight());
        return new int[]{a.getMeasuredWidth(), a.getMeasuredHeight()};
    }

    public Bitmap getMultiRouteBubbleBitmap_V2(Context context, String str, String str2, int i, String str3, int[] iArr, String str4, int[] iArr2) {
        float f;
        Paint paint;
        float f2;
        Paint.FontMetrics fontMetrics;
        Paint paint2;
        float f3;
        float f4;
        int i2;
        Bitmap bitmap;
        int i3;
        Bitmap.Config config;
        Bitmap.Config config2;
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        int i4 = i;
        Resources resources = context.getResources();
        Paint paint3 = new Paint();
        paint3.setTextSize(TypedValue.applyDimension(2, 17.0f, resources.getDisplayMetrics()));
        paint3.setColor(i4);
        paint3.setTextAlign(Paint.Align.LEFT);
        paint3.setFakeBoldText(true);
        Paint.FontMetrics fontMetrics2 = paint3.getFontMetrics();
        float measureText = paint3.measureText(str5);
        float f5 = fontMetrics2.bottom - fontMetrics2.top;
        if (!TextUtils.isEmpty(str2)) {
            paint = new Paint();
            paint.setTextSize(TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics()));
            paint.setColor(i4);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setFakeBoldText(true);
            fontMetrics = paint.getFontMetrics();
            f2 = paint.measureText(str6);
            f = (fontMetrics.bottom - fontMetrics.top) + 2.0f;
        } else {
            fontMetrics = null;
            f2 = 0.0f;
            paint = null;
            f = 0.0f;
        }
        float f6 = ((float) iArr[1]) + f5;
        if (!TextUtils.isEmpty(str4)) {
            NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context2, str4);
            int intrinsicWidth = curRouteNameBgBitmap.getIntrinsicWidth();
            int intrinsicHeight = curRouteNameBgBitmap.getIntrinsicHeight();
            paint2 = paint;
            if (curRouteNameBgBitmap.getOpacity() != -1) {
                config2 = Bitmap.Config.ARGB_8888;
            } else {
                config2 = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config2);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap bitmap2 = createBitmap;
            curRouteNameBgBitmap.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            curRouteNameBgBitmap.draw(canvas);
            int i5 = iArr2[0] + intrinsicWidth + iArr2[2];
            i2 = iArr2[3] + iArr2[1] + intrinsicHeight;
            f4 = ((float) (iArr2[0] + iArr[0])) + measureText;
            int i6 = i5;
            f3 = ((Math.max((float) i2, f5) - ((float) intrinsicHeight)) / 2.0f) + ((float) iArr[1]);
            bitmap = bitmap2;
            i3 = i6;
        } else {
            paint2 = paint;
            i3 = 0;
            bitmap = null;
            i2 = 0;
            f4 = 0.0f;
            f3 = 0.0f;
        }
        int max = iArr[0] + iArr[2] + ((int) Math.max(measureText + ((float) i3), f2));
        int max2 = iArr[1] + ((int) Math.max(f5, (float) i2)) + iArr[3] + ((int) f);
        NinePatchDrawable curRouteNameBgBitmap2 = getCurRouteNameBgBitmap(context2, str3);
        curRouteNameBgBitmap2.setBounds(0, 0, max, max2);
        if (curRouteNameBgBitmap2.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, config);
        Canvas canvas2 = new Canvas();
        canvas2.setBitmap(createBitmap2);
        curRouteNameBgBitmap2.draw(canvas2);
        canvas2.drawText(str5, (float) iArr[0], f6 - fontMetrics2.descent, paint3);
        if (f != 0.0f) {
            String str7 = str2;
            canvas2.drawText(str7, (float) iArr[0], (f6 + f) - fontMetrics.descent, paint2);
        }
        if (bitmap != null) {
            Paint paint4 = new Paint();
            paint4.setAntiAlias(true);
            canvas2.drawBitmap(bitmap, f4, f3, paint4);
        }
        return createBitmap2;
    }

    public Bitmap getMultiRouteBubbleBitmap(Context context, LableMarkerManager.MultiBubbleParams multiBubbleParams) {
        return BitmapUtil.convertViewToBitmap(m17555a(context, multiBubbleParams));
    }

    /* renamed from: a */
    private LinearLayout m17555a(Context context, LableMarkerManager.MultiBubbleParams multiBubbleParams) {
        int i;
        int i2;
        String str;
        Context context2 = context;
        LableMarkerManager.MultiBubbleParams multiBubbleParams2 = multiBubbleParams;
        String str2 = multiBubbleParams2.strTime;
        int[] iArr = multiBubbleParams2.textColorArray;
        String str3 = multiBubbleParams2.fileName;
        int[] iArr2 = multiBubbleParams2.padding;
        boolean z = multiBubbleParams2.isDynamicRoute;
        boolean z2 = multiBubbleParams2.is2DFullBrowser;
        boolean z3 = multiBubbleParams2.isNight;
        String str4 = multiBubbleParams2.lable;
        int i3 = multiBubbleParams2.diffDistance;
        int i4 = multiBubbleParams2.diffTrafficLightCnt;
        if (iArr == null || iArr.length < 2) {
            HWLog.m16761i("hw", "BubbleParams checkParams: invalid array ?");
            i = Color.parseColor("#009E65");
            i2 = Color.parseColor("#37AD82");
        } else {
            i = iArr[0];
            i2 = iArr[1];
        }
        LinearLayout linearLayout = new LinearLayout(context2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(context2);
        textView.setText(str2);
        int[] iArr3 = iArr2;
        textView.setTextSize(1, 15.0f);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextColor(i);
        textView.setHorizontallyScrolling(false);
        textView.getPaint().setFakeBoldText(true);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(textView);
        if (!TextUtils.isEmpty(str4)) {
            TextView textView2 = new TextView(context2);
            textView2.setText(str4);
            textView2.setTextSize(1, 15.0f);
            textView2.setGravity(17);
            textView2.setSingleLine();
            textView2.setTextColor(i);
            textView2.setHorizontallyScrolling(false);
            textView2.getPaint().setFakeBoldText(true);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(DisplayUtils.dip2px(context2, 3.5f), 0, 0, 0);
            textView2.setLayoutParams(layoutParams3);
            linearLayout2.addView(textView2);
        }
        LinearLayout linearLayout3 = new LinearLayout(context2);
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, DisplayUtils.dip2px(context2, 2.0f), 0, 0);
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        linearLayout.addView(linearLayout3);
        if (BitmapUtil.fDensityXH >= 1.0f) {
            str = str2.contains("快") ? z3 ? f24653e : f24649a : z3 ? f24655g : f24651c;
        } else {
            str = str2.contains("快") ? z3 ? f24654f : f24650b : z3 ? f24656h : f24652d;
        }
        Bitmap bgBitmap = getBgBitmap(context2, str);
        ImageView imageView = new ImageView(context2);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(DisplayUtils.dip2px(context2, 7.0f), DisplayUtils.dip2px(context2, 13.0f));
        layoutParams5.setMargins(0, 0, DisplayUtils.dip2px(context2, 1.5f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setImageBitmap(bgBitmap);
        linearLayout3.addView(imageView);
        TextView textView3 = new TextView(context2);
        String str5 = "少";
        if (i4 == 0) {
            textView3.setText("相同");
        } else if (i4 < 0) {
            textView3.setText(str5 + Math.abs(i4) + "个");
        } else {
            textView3.setText("多" + Math.abs(i4) + "个");
        }
        textView3.setTextSize(1, 13.0f);
        textView3.setGravity(16);
        textView3.setSingleLine();
        textView3.setTextColor(i2);
        textView3.setHorizontallyScrolling(false);
        textView3.getPaint().setFakeBoldText(true);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(textView3);
        TextView textView4 = new TextView(context2);
        if (Math.abs(i3) <= 200) {
            textView4.setText("里程接近");
        } else {
            if (i3 > 0) {
                str5 = "多";
            }
            if (Math.abs(i3) < 1000) {
                textView4.setText(str5 + Math.abs(i3) + "米");
            } else {
                textView4.setText(str5 + m17557a(Math.abs(i3)) + "公里");
            }
        }
        textView4.setTextSize(1, 13.0f);
        textView4.setGravity(16);
        textView4.setSingleLine();
        textView4.setTextColor(i2);
        textView4.setHorizontallyScrolling(false);
        textView4.getPaint().setFakeBoldText(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(DisplayUtils.dip2px(context2, 7.5f), 0, 0, 0);
        textView4.setLayoutParams(layoutParams6);
        linearLayout3.addView(textView4);
        if (i4 != 0 || Math.abs(i3) > 200) {
            linearLayout3.setVisibility(0);
        } else if (z2) {
            linearLayout3.setVisibility(0);
        } else {
            linearLayout3.setVisibility(8);
        }
        linearLayout.setBackgroundDrawable(getCurRouteNameBgBitmap(context2, str3));
        linearLayout.setPadding(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
        return linearLayout;
    }

    public Bitmap getMarkerBitmap_V2(Context context, String str, int i, int[] iArr) {
        Bitmap.Config config;
        NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context, str);
        int intrinsicWidth = curRouteNameBgBitmap.getIntrinsicWidth();
        int intrinsicHeight = curRouteNameBgBitmap.getIntrinsicHeight();
        if (curRouteNameBgBitmap.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        curRouteNameBgBitmap.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        curRouteNameBgBitmap.draw(canvas);
        return createBitmap;
    }

    public Bitmap getMarkerBitmap_V2(Context context, String str, float f, int i, String str2, int i2, int[] iArr) {
        int i3;
        int i4;
        int i5;
        Bitmap.Config config;
        if (iArr == null) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else {
            i5 = iArr[0];
            i4 = iArr[1];
            i3 = iArr[2];
            i2 += iArr[3];
        }
        Resources resources = context.getResources();
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, f, resources.getDisplayMetrics()));
        paint.setColor(i);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setFakeBoldText(true);
        paint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float measureText = paint.measureText(str);
        float f2 = fontMetrics.bottom - fontMetrics.top;
        NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context, str2);
        int i6 = ((int) measureText) + i5 + i3;
        int i7 = ((int) f2) + i4 + i2;
        if (curRouteNameBgBitmap.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, config);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        curRouteNameBgBitmap.setBounds(0, 0, i6, i7);
        curRouteNameBgBitmap.draw(canvas);
        canvas.drawText(str, (float) i5, (((float) i4) + f2) - fontMetrics.bottom, paint);
        return createBitmap;
    }

    public Bitmap getMarkerBitmap(Context context, String str, float f, int i, String str2, int i2, int[] iArr, int i3) {
        TextView a = m17556a(context, i, f, str2, i2, iArr, i3);
        if (a == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = -2;
        } else {
            a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        String str3 = str;
        a.setText(str);
        return BitmapUtil.convertViewToBitmap(a);
    }

    /* renamed from: a */
    private String m17557a(int i) {
        if (i < 1000) {
            return String.valueOf(i);
        }
        if (i % 1000 == 0) {
            return String.valueOf(i / 1000);
        }
        return String.valueOf(((float) ((int) (((float) (i * 10)) / 1000.0f))) / 10.0f);
    }

    /* renamed from: a */
    private TextView m17556a(Context context, int i, float f, String str, int i2, int[] iArr, int i3) {
        int i4;
        int i5;
        int i6;
        if (context == null || str == null) {
            return null;
        }
        NinePatchDrawable curRouteNameBgBitmap = getCurRouteNameBgBitmap(context, str);
        TextView textView = new TextView(context);
        textView.setTextSize(2, f);
        textView.setGravity(i3);
        if (iArr == null) {
            i4 = 0;
            i6 = 0;
            i5 = 0;
        } else {
            i6 = iArr[0];
            i5 = iArr[1];
            i4 = iArr[2];
            i2 += iArr[3];
        }
        textView.setSingleLine();
        textView.setTextColor(i);
        textView.setHorizontallyScrolling(false);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(curRouteNameBgBitmap);
        textView.setPadding(i6, i5, i4, i2);
        return textView;
    }

    public NinePatchDrawable getCurRouteNameBgBitmap(Context context, String str) {
        Bitmap bitmap;
        try {
            if (this.f24657i.get(str) != null) {
                bitmap = this.f24657i.get(str);
            } else {
                Bitmap bitmapFromAsset = BitmapUtil.getBitmapFromAsset(context, str);
                this.f24657i.put(str, bitmapFromAsset);
                bitmap = bitmapFromAsset;
            }
            if (bitmap != null) {
                return BitmapUtil.getNinePathDrawableFromBitmap(context, bitmap);
            }
            return null;
        } catch (Exception e) {
            CrashTryCatcher.logCrash(e);
            return null;
        }
    }

    public Bitmap getBgBitmap(Context context, String str) {
        Bitmap bitmap = null;
        try {
            if (this.f24657i.get(str) != null) {
                return this.f24657i.get(str);
            }
            bitmap = BitmapUtil.getBitmapFromAsset(context, str);
            this.f24657i.put(str, bitmap);
            return bitmap;
        } catch (Exception e) {
            CrashTryCatcher.logCrash(e);
        }
    }

    public void clear() {
        this.f24657i.clear();
    }

    public void remove(String str) {
        this.f24657i.remove(str);
    }

    public void destroy() {
        this.f24658j = null;
        clear();
    }
}

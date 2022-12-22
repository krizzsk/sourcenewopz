package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbos extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context context;
    private View zzaay;

    public static zzbos zza(Context context2, View view, zzdot zzdot) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzbos zzbos = new zzbos(context2);
        if (!(zzdot.zzhmj.isEmpty() || (resources = zzbos.context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzdow zzdow = zzdot.zzhmj.get(0);
            zzbos.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzdow.width) * displayMetrics.density), (int) (((float) zzdow.height) * displayMetrics.density)));
        }
        zzbos.zzaay = view;
        zzbos.addView(view);
        zzr.zzls();
        zzbbm.zza((View) zzbos, (ViewTreeObserver.OnScrollChangedListener) zzbos);
        zzr.zzls();
        zzbbm.zza((View) zzbos, (ViewTreeObserver.OnGlobalLayoutListener) zzbos);
        JSONObject jSONObject = zzdot.zzhmy;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbos.context);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbos.zza(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbos.zza(optJSONObject2, relativeLayout, 12);
            }
            zzbos.addView(relativeLayout);
        }
        return zzbos;
    }

    private zzbos(Context context2) {
        super(context2);
        this.context = context2;
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaay.setY((float) (-iArr[1]));
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaay.setY((float) (-iArr[1]));
    }

    private final void zza(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.context);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble(BlocksConst.WIDGET_PARAMS_TEXT_SIZE, 11.0d));
        int zzb = zzb(jSONObject.optDouble(Const.YogaConst.PADDING_PADDING, 0.0d));
        textView.setPadding(0, zzb, 0, zzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzb(double d) {
        zzww.zzqw();
        return zzbae.zze(this.context, (int) d);
    }
}

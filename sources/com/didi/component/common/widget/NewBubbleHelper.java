package com.didi.component.common.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.taxis99.R;

public class NewBubbleHelper {

    /* renamed from: a */
    private static final String f12028a = "NewBubbleHelper";

    /* renamed from: b */
    private final LEGOBubble.Builder f12029b;

    /* renamed from: c */
    private final BubbleItemModel f12030c;

    /* renamed from: d */
    private int f12031d;

    /* renamed from: e */
    private int f12032e;

    public NewBubbleHelper(Context context, BubbleItemModel bubbleItemModel) {
        this.f12029b = new LEGOBubble.Builder(context);
        this.f12030c = bubbleItemModel;
        m8110a(context, bubbleItemModel, "bottom_left");
    }

    public NewBubbleHelper(Context context, BubbleItemModel bubbleItemModel, String str) {
        this.f12029b = new LEGOBubble.Builder(context);
        this.f12030c = bubbleItemModel;
        m8110a(context, bubbleItemModel, str);
    }

    /* renamed from: a */
    private void m8110a(Context context, BubbleItemModel bubbleItemModel, String str) {
        String content = (bubbleItemModel.bubbleText == null || TextUtil.isEmpty(bubbleItemModel.bubbleText.getContent())) ? "" : bubbleItemModel.bubbleText.getContent();
        int i = bubbleItemModel.viewType;
        this.f12029b.setDirection(str);
        this.f12029b.setBgColor(ResourcesHelper.getColor(context, R.color.g_color_5C6166));
        this.f12029b.setCloseBtnVisible(true);
        this.f12029b.setTextTypeface(3);
        this.f12029b.setText(content);
        this.f12029b.setCloseBtnVisible(false);
        if (i == 2) {
            this.f12029b.setLeftDrawable(bubbleItemModel.extraBubbleIcon);
        } else if (i == 3) {
            this.f12029b.setLeftView(m8109a(context, bubbleItemModel), this.f12031d, this.f12032e);
        } else if (i == 4) {
            this.f12029b.setLeftView(m8111b(context, bubbleItemModel), this.f12031d, this.f12032e);
        }
    }

    public LEGOBubble.Builder getmBuilder() {
        return this.f12029b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackEvent(boolean r4) {
        /*
            r3 = this;
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r0 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r0 = r0.logDate
            r1 = 0
            if (r0 == 0) goto L_0x003b
            if (r4 == 0) goto L_0x0022
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.ShowEvent r4 = r4.showEvent
            if (r4 == 0) goto L_0x003b
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.ShowEvent r4 = r4.showEvent
            java.lang.String r1 = r4.eventId
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.ShowEvent r4 = r4.showEvent
            com.google.gson.JsonObject r4 = r4.params
            goto L_0x003c
        L_0x0022:
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.DismissEvent r4 = r4.dismissEvent
            if (r4 == 0) goto L_0x003b
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.DismissEvent r4 = r4.dismissEvent
            java.lang.String r1 = r4.eventId
            com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel r4 = r3.f12030c
            com.didi.travel.psnger.model.response.newbubbleParams.LogDate r4 = r4.logDate
            com.didi.travel.psnger.model.response.newbubbleParams.DismissEvent r4 = r4.dismissEvent
            com.google.gson.JsonObject r4 = r4.params
            goto L_0x003c
        L_0x003b:
            r4 = r1
        L_0x003c:
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r0 != 0) goto L_0x0061
            if (r4 == 0) goto L_0x0061
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0059 }
            r0.<init>()     // Catch:{ Exception -> 0x0059 }
            com.didi.component.common.widget.NewBubbleHelper$1 r2 = new com.didi.component.common.widget.NewBubbleHelper$1     // Catch:{ Exception -> 0x0059 }
            r2.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r4 = r0.fromJson((com.google.gson.JsonElement) r4, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x0059 }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x0059 }
            goto L_0x005e
        L_0x0059:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x005e:
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r4)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.widget.NewBubbleHelper.trackEvent(boolean):void");
    }

    /* renamed from: a */
    private TextView m8109a(Context context, BubbleItemModel bubbleItemModel) {
        int i;
        int i2;
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTypeface(Typeface.SANS_SERIF, 3);
        textView.setPadding(4, 2, 4, 2);
        String str = bubbleItemModel.extraColorStart;
        String str2 = bubbleItemModel.extraColorEnd;
        try {
            i2 = Color.parseColor(str);
            i = Color.parseColor(str2);
        } catch (Exception unused) {
            int parseColor = Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON);
            i = Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON);
            i2 = parseColor;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i2, i});
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(context, 10.0f));
        if (Build.VERSION.SDK_INT < 16) {
            textView.setBackgroundDrawable(gradientDrawable);
        } else {
            textView.setBackground(gradientDrawable);
        }
        bubbleItemModel.extraText.bindTextView(textView);
        textView.measure(0, 0);
        this.f12031d = textView.getMeasuredWidth();
        this.f12032e = textView.getMeasuredHeight();
        return textView;
    }

    /* renamed from: b */
    private View m8111b(Context context, BubbleItemModel bubbleItemModel) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.new_bubble_left_view_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_text);
        if (bubbleItemModel.extraText == null || TextUtil.isEmpty(bubbleItemModel.extraText.getContent())) {
            SystemUtils.log(6, f12028a, "buildBubbleLeftView: extraText is null", (Throwable) null, "com.didi.component.common.widget.NewBubbleHelper", 168);
        } else {
            bubbleItemModel.extraText.bindTextView(textView);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_img);
        if (!TextUtil.isEmpty(bubbleItemModel.extraBubbleIcon)) {
            Glide.with(context).load(bubbleItemModel.extraBubbleIcon).into(imageView);
        } else {
            SystemUtils.log(6, f12028a, "buildBubbleLeftView: bubbleItemModel.extraBubbleIcon is null", (Throwable) null, "com.didi.component.common.widget.NewBubbleHelper", 175);
        }
        inflate.measure(0, 0);
        this.f12031d = inflate.getMeasuredWidth();
        this.f12032e = inflate.getMeasuredHeight();
        return inflate;
    }

    public void saveBubbleShowCount(Context context) {
        String str = this.f12030c.bubbleId;
        if (!TextUtil.isEmpty(str)) {
            SPUtils.put(context, str, Integer.valueOf(((Integer) SPUtils.get(context, str, 0)).intValue() + 1));
        } else {
            SystemUtils.log(6, f12028a, "saveBubbleShowCount: bubbleId is null", (Throwable) null, "com.didi.component.common.widget.NewBubbleHelper", 190);
        }
    }

    public void saveRedMarkShowCount(Context context) {
        SPUtils.put(context, "red_mark_count", Integer.valueOf(((Integer) SPUtils.get(context, "red_mark_count", 0)).intValue() + 1));
    }

    public boolean isShowRedMark(Context context) {
        int intValue = ((Integer) SPUtils.get(context, "red_mark_count", 0)).intValue();
        if (this.f12030c.redMarkCount == -1 || intValue < this.f12030c.redMarkCount) {
            return true;
        }
        return false;
    }
}

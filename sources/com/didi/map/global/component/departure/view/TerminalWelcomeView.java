package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.view.ITerminalWelcomeView;
import com.sdk.poibase.model.poi.FenceInfo;
import com.taxis99.R;

public class TerminalWelcomeView extends RelativeLayout implements ITerminalWelcomeView {

    /* renamed from: a */
    private TextView f25367a;

    /* renamed from: b */
    private TextView f25368b;

    /* renamed from: c */
    private ImageView f25369c;

    /* renamed from: d */
    private TextView f25370d;

    /* renamed from: e */
    private TextView f25371e;

    /* renamed from: f */
    private FenceInfo f25372f;

    /* renamed from: g */
    private boolean f25373g;

    /* renamed from: h */
    private boolean f25374h;

    /* renamed from: i */
    private boolean f25375i;

    /* renamed from: j */
    private ITerminalWelcomeView.Callback f25376j;

    /* renamed from: k */
    private Context f25377k;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m18156a(View view, MotionEvent motionEvent) {
        return true;
    }

    public TerminalWelcomeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TerminalWelcomeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TerminalWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18154a(context);
    }

    /* renamed from: a */
    private void m18154a(Context context) {
        this.f25377k = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_map_departure_terminal_welcome, this);
        this.f25367a = (TextView) inflate.findViewById(R.id.welcome_title);
        this.f25368b = (TextView) inflate.findViewById(R.id.welcome_subtitle);
        this.f25369c = (ImageView) inflate.findViewById(R.id.welcome_icon);
        this.f25370d = (TextView) inflate.findViewById(R.id.set_pickup_spot);
        this.f25371e = (TextView) inflate.findViewById(R.id.select_other_area);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_departure_right_arrow);
        drawable.setAutoMirrored(true);
        this.f25371e.setCompoundDrawablePadding(DisplayUtils.dp2px(inflate.getContext(), 4.0f));
        this.f25371e.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        inflate.setOnTouchListener($$Lambda$TerminalWelcomeView$Vo5gI9zM2DPOCaWBkakrEHTPE.INSTANCE);
        try {
            this.f25370d.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f25370d.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f25370d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalWelcomeView.this.m18157b(view);
            }
        });
        this.f25371e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TerminalWelcomeView.this.m18155a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18157b(View view) {
        this.f25374h = true;
        ITerminalWelcomeView.Callback callback = this.f25376j;
        if (callback != null) {
            callback.onClickSetPickupSpot();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18155a(View view) {
        this.f25375i = true;
        ITerminalWelcomeView.Callback callback = this.f25376j;
        if (callback != null) {
            callback.onClickSelectOtherArea();
        }
    }

    public void setData(FenceInfo fenceInfo) {
        if (fenceInfo == null) {
            this.f25373g = false;
            this.f25374h = false;
            this.f25375i = false;
            return;
        }
        DLog.m7384d("TerminalWelcomeView", "welcomeText: " + fenceInfo.welcomeText + "recommendText: " + fenceInfo.recommendText + "stationIcon: " + fenceInfo.stationIcon, new Object[0]);
        this.f25372f = fenceInfo;
        this.f25373g = true;
        this.f25367a.setText(fenceInfo.welcomeText);
        this.f25368b.setText(fenceInfo.recommendText);
        ((RequestBuilder) Glide.with(getContext()).load(fenceInfo.stationIcon).override(DisplayUtils.dp2px(this.f25377k, 128.0f), DisplayUtils.dp2px(this.f25377k, 146.0f))).into(this.f25369c);
    }

    public View getView() {
        if (!isValid() || this.f25374h) {
            return null;
        }
        return this;
    }

    public boolean isValid() {
        return !this.f25374h && this.f25373g;
    }

    public void setCallback(ITerminalWelcomeView.Callback callback) {
        this.f25376j = callback;
    }
}

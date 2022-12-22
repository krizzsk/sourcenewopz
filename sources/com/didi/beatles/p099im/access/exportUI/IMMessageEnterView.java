package com.didi.beatles.p099im.access.exportUI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.core.IMMessageListener;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.manager.IMMessageListenerManager;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.access.exportUI.IMMessageEnterView */
public class IMMessageEnterView extends RelativeLayout implements IMMessageListener {

    /* renamed from: a */
    private static final int f8744a = 99;

    /* renamed from: b */
    private static final int f8745b = 18;

    /* renamed from: c */
    private ImageView f8746c;

    /* renamed from: d */
    private TextView f8747d;

    /* renamed from: e */
    private ImageView f8748e;

    /* renamed from: f */
    private int f8749f;

    /* renamed from: g */
    private int f8750g;

    /* renamed from: h */
    private int f8751h;

    /* renamed from: i */
    private int f8752i;

    /* renamed from: j */
    private IMSessionUnreadCallback f8753j;

    /* renamed from: k */
    private int f8754k;

    /* renamed from: l */
    private boolean f8755l;

    /* renamed from: m */
    private int f8756m;

    /* renamed from: n */
    private IMEnterViewCallBack f8757n;

    /* renamed from: com.didi.beatles.im.access.exportUI.IMMessageEnterView$IMEnterViewCallBack */
    public interface IMEnterViewCallBack {
        boolean isUserHasLogin();
    }

    public IMMessageEnterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMMessageEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMMessageEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8746c = null;
        this.f8747d = null;
        this.f8749f = R.drawable.im_msg_enter_icon;
        this.f8750g = R.drawable.im_dots_with_number;
        this.f8751h = R.drawable.im_red_circle_bg;
        this.f8752i = R.color.white;
        this.f8753j = null;
        this.f8754k = 0;
        this.f8755l = false;
        m5827a(attributeSet);
    }

    /* renamed from: a */
    private void m5827a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.im_message_enter_view, this, true);
        this.f8746c = (ImageView) findViewById(R.id.message_redpoint);
        this.f8747d = (TextView) findViewById(R.id.message_numv);
        this.f8748e = (ImageView) findViewById(R.id.message_icon);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(IMViewUtil.dp2px(getContext(), 34.0f), IMViewUtil.dp2px(getContext(), 34.0f));
        }
        setLayoutParams(layoutParams);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.IMEnterView);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f8748e.getLayoutParams();
        layoutParams2.width = obtainStyledAttributes.getDimensionPixelSize(8, IMViewUtil.dp2px(getContext(), 18.0f));
        layoutParams2.height = obtainStyledAttributes.getDimensionPixelOffset(6, IMViewUtil.dp2px(getContext(), 18.0f));
        int resourceId = obtainStyledAttributes.getResourceId(7, R.drawable.im_msg_enter_icon);
        this.f8749f = resourceId;
        this.f8748e.setImageResource(resourceId);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(0, IMViewUtil.dp2px(getContext(), -7.0f));
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f8747d.getLayoutParams();
        layoutParams3.leftMargin = dimensionPixelOffset;
        layoutParams3.bottomMargin = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(1, IMViewUtil.dp2px(getContext(), 18.0f));
        layoutParams3.width = dimensionPixelOffset2;
        layoutParams3.height = dimensionPixelOffset2;
        this.f8747d.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelOffset(2, IMViewUtil.dp2px(getContext(), 10.0f)));
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f8746c.getLayoutParams();
        layoutParams4.leftMargin = obtainStyledAttributes.getDimensionPixelOffset(4, IMViewUtil.dp2px(getContext(), -2.0f));
        layoutParams4.bottomMargin = obtainStyledAttributes.getDimensionPixelOffset(3, IMViewUtil.dp2px(getContext(), -4.0f));
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(5, IMViewUtil.dp2px(getContext(), 7.0f));
        layoutParams4.width = dimensionPixelOffset3;
        layoutParams4.height = dimensionPixelOffset3;
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMMessageEnterView.this.handClick();
            }
        });
        refresh();
    }

    public void refresh() {
        if (this.f8753j == null) {
            this.f8753j = new IMSessionUnreadCallback() {
                public void unReadCount(final int i) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            IMMessageEnterView.this.m5826a(i);
                        }
                    });
                }
            };
        }
        IMManager.getInstance().getAllUnreadMessageCount(this.f8753j);
    }

    public void setNeedSessionType(int i) {
        this.f8756m = i;
    }

    public void handClick() {
        IMEnterViewCallBack iMEnterViewCallBack = this.f8757n;
        int i = 0;
        if (iMEnterViewCallBack == null || iMEnterViewCallBack.isUserHasLogin()) {
            boolean isIMHaveRedDot = IMManager.getInstance().isIMHaveRedDot();
            if (this.f8754k > 0) {
                i = 1;
            }
            IMTraceUtil.addBusinessEvent("ddim_home_icon_ck").add("redpoint", Integer.valueOf(isIMHaveRedDot ? 1 : 0)).add("number", Integer.valueOf(i)).add("log_status", 1).report();
            IMManager.getInstance().reInitIM(2);
            IMEngine.startChatListActivity(getContext(), this.f8756m);
            IMManager.getInstance().clearIMRedDot();
            return;
        }
        IMLog.m6631d("im-sdk", "user not login!,cant open IM!");
        IMTraceUtil.addBusinessEvent("ddim_home_icon_ck").add("redpoint", 0).add("number", 0).add("log_status", 0).report();
    }

    public void setIMEnterViewCallBack(IMEnterViewCallBack iMEnterViewCallBack) {
        this.f8757n = iMEnterViewCallBack;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5826a(int i) {
        this.f8754k = i;
        this.f8755l = false;
        if (i > 0) {
            TextView textView = this.f8747d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f8746c.setVisibility(4);
                if (i > 99) {
                    this.f8747d.setText("···");
                } else {
                    this.f8747d.setText(String.valueOf(i));
                }
            }
        } else {
            boolean isIMHaveRedDot = IMManager.getInstance().isIMHaveRedDot();
            this.f8755l = isIMHaveRedDot;
            IMLog.m6631d("IMMessageEnterView doRefresh", this.f8747d.getVisibility() + "");
            this.f8747d.clearAnimation();
            if (isIMHaveRedDot) {
                this.f8747d.setVisibility(4);
                this.f8746c.setVisibility(0);
                return;
            }
            this.f8747d.setVisibility(4);
            this.f8746c.setVisibility(4);
        }
    }

    public Map<String, Object> getStateMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("number", Integer.valueOf(this.f8754k > 0 ? 1 : 0));
        hashMap.put("redpoint", Integer.valueOf(this.f8755l ? 1 : 0));
        return hashMap;
    }

    public void resetState() {
        TextView textView = this.f8747d;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ImageView imageView = this.f8746c;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IMMessageListenerManager.getInstance().addMessageListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IMMessageListenerManager.getInstance().removeMessageListener(this);
    }

    public void onMessageArrive() {
        if (isShown()) {
            refresh();
        }
    }

    public void setMessageIconRes(int i) {
        this.f8749f = i;
        setIconRes(i);
    }

    public void setIconRes(int i) {
        this.f8748e.setImageResource(i);
    }

    public void setIconDrawable(Drawable drawable) {
        this.f8748e.setImageDrawable(drawable);
    }

    public void setNumRes(int i, int i2) {
        this.f8747d.setTextColor(i2);
        this.f8747d.setBackgroundResource(i);
    }

    public void setNumResByColor(int i, int i2) {
        this.f8747d.setTextColor(i2);
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(this.f8750g);
        gradientDrawable.mutate();
        gradientDrawable.setColor(i);
        this.f8747d.setBackgroundDrawable(gradientDrawable);
    }

    public void setRedRes(int i) {
        this.f8746c.setImageResource(i);
    }

    public void setRedResByColor(int i) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(this.f8751h);
        gradientDrawable.mutate();
        gradientDrawable.setColor(i);
        this.f8746c.setImageDrawable(gradientDrawable);
    }

    public void resetIconRes() {
        setIconRes(this.f8749f);
    }

    public void resetNumRes() {
        setNumRes(this.f8750g, getResources().getColor(this.f8752i));
    }

    public void resetRedRes() {
        setRedRes(this.f8751h);
    }
}

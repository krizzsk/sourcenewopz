package com.didichuxing.xpanel.models;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.base.XPanelCardLayout;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsXPanelAgentModelView<T> implements IXPanelModelView<T> {

    /* renamed from: a */
    private IXPanelAgentModelRecycle f49573a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float f49574b = 3.0f;
    protected XPanelCardData cardData;
    /* access modifiers changed from: protected */
    public XPanelCardData mCardData;
    protected Context mContext;
    /* access modifiers changed from: protected */
    public IXPanelAgentClickListener mListener;

    /* access modifiers changed from: protected */
    public String getCardUrl() {
        return "";
    }

    public abstract void initView();

    public final void init(Context context) {
        this.mContext = context;
        initView();
    }

    /* access modifiers changed from: protected */
    public void bindRecycleCallBack(IXPanelAgentModelRecycle<? extends AbsXPanelAgentModelView> iXPanelAgentModelRecycle) {
        this.f49573a = iXPanelAgentModelRecycle;
    }

    public void destroy() {
        IXPanelAgentModelRecycle iXPanelAgentModelRecycle = this.f49573a;
        if (iXPanelAgentModelRecycle != null) {
            iXPanelAgentModelRecycle.push(this);
            this.f49573a = null;
        }
    }

    public void setRoundCorner(float f) {
        this.f49574b = f;
    }

    /* access modifiers changed from: protected */
    public View createBgContainer(View view) {
        FrameLayout.LayoutParams layoutParams;
        final Context context = view.getContext();
        XPanelCardLayout xPanelCardLayout = new XPanelCardLayout(context);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams = new FrameLayout.LayoutParams(layoutParams2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen._10dip);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_top);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_bottom);
        layoutParams3.leftMargin = dimensionPixelSize;
        layoutParams3.rightMargin = dimensionPixelSize;
        layoutParams3.topMargin = dimensionPixelSize2;
        layoutParams3.bottomMargin = dimensionPixelSize3;
        xPanelCardLayout.setBgDrawable(ContextCompat.getDrawable(context, R.drawable.card2), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) Utils.dip2px(context, AbsXPanelAgentModelView.this.f49574b));
                    }
                }
            });
            view.setClipToOutline(true);
        }
        if (view.getBackground() == null) {
            view.setBackgroundColor(-1);
        }
        xPanelCardLayout.addView(view, layoutParams3);
        return xPanelCardLayout;
    }

    public void initData(XPanelCardData xPanelCardData) {
        this.cardData = xPanelCardData;
    }

    public void bindListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.mListener = iXPanelAgentClickListener;
    }

    public void bindCardData(XPanelCardData xPanelCardData) {
        this.mCardData = xPanelCardData;
    }

    /* access modifiers changed from: protected */
    public void clickCardOmega() {
        XPanelCardData xPanelCardData = this.mCardData;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            this.mCardData.clickCardOmega((Map<String, Object>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void clickButtonOmega() {
        XPanelCardData xPanelCardData = this.mCardData;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_button_ck", this.mCardData.getOmegaParams((Map<String, Object>) null));
        }
    }

    /* access modifiers changed from: protected */
    public void clickSubCardOmega() {
        XPanelCardData xPanelCardData = this.mCardData;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_subcard_ck", this.mCardData.getOmegaParams((Map<String, Object>) null));
        }
    }

    /* access modifiers changed from: protected */
    public void loadUrlOmega(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        XPanelCardData xPanelCardData = this.cardData;
        if (xPanelCardData != null) {
            hashMap.put(BaseCard.KEY_CARD_ID, xPanelCardData.f49329id);
        }
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        XPanelOmegaUtils.trackEvent("xpanel_img_download", hashMap);
    }

    /* access modifiers changed from: protected */
    public void loadUrlRetOmega(String str, Map<String, Object> map, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("img_link", str);
        XPanelCardData xPanelCardData = this.cardData;
        if (!(xPanelCardData == null || xPanelCardData.f49329id == null)) {
            hashMap.put(BaseCard.KEY_CARD_ID, this.cardData.f49329id);
        }
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put("download_status", Integer.valueOf(i));
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j));
        XPanelOmegaUtils.trackEvent("xpanel_img_download_ret", hashMap);
    }

    /* access modifiers changed from: protected */
    public void scrollOmega() {
        XPanelCardData xPanelCardData = this.mCardData;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_card_scroll", this.mCardData.getOmegaParams((Map<String, Object>) null));
        }
    }

    public void setCardClickListener() {
        setCardClickListener(true);
    }

    public void setCardClickListener(final boolean z) {
        getView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (z && AbsXPanelAgentModelView.this.mListener != null) {
                    AbsXPanelAgentModelView.this.mListener.clickUri(AbsXPanelAgentModelView.this.getCardUrl(), AbsXPanelAgentModelView.this.mCardData);
                    AbsXPanelAgentModelView.this.clickCardOmega();
                }
            }
        });
    }

    public ImageView createCornMarkView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setId(R.id.corn_mark);
        imageView.setImageResource(R.drawable.oc_x_panel_coin_mark);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_coin_mark_size);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        return imageView;
    }

    public void showCornMark() {
        View findViewById;
        View view = getView();
        if (view != null && (findViewById = view.findViewById(R.id.corn_mark)) != null) {
            findViewById.setVisibility(0);
        }
    }

    public void hideCornMark() {
        View findViewById;
        View view = getView();
        if (view != null && (findViewById = view.findViewById(R.id.corn_mark)) != null) {
            findViewById.setVisibility(8);
        }
    }
}

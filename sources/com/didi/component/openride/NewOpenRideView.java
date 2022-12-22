package com.didi.component.openride;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.view.LazyInflateView;
import com.taxis99.R;

public class NewOpenRideView extends LazyInflateView implements View.OnClickListener, INewOpenRideView {

    /* renamed from: a */
    private View f14715a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f14716b;

    /* renamed from: c */
    private ImageView f14717c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsNewOpenRidePresenter f14718d;

    /* renamed from: e */
    private int f14719e = 0;

    /* renamed from: f */
    private BusinessContext f14720f;

    /* renamed from: g */
    private LEGOBubble f14721g;

    public NewOpenRideView(Context context, ViewGroup viewGroup, BusinessContext businessContext) {
        super(context, new FrameLayout(context), R.layout.new_global_open_ride_entrance);
        this.f14720f = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f14715a = view;
        this.f14717c = (ImageView) view.findViewById(R.id.open_ride_entrance);
        this.f14716b = (ViewGroup) this.f14715a.findViewById(R.id.open_ride_bubble_container);
        this.f14717c.setOnClickListener(this);
        int i = this.f14719e;
        if (i <= 0) {
            this.f14715a.setTranslationY((float) i);
        }
        m10519b();
    }

    public void setPresenter(AbsNewOpenRidePresenter absNewOpenRidePresenter) {
        this.f14718d = absNewOpenRidePresenter;
    }

    public View getView() {
        return getRealView();
    }

    public boolean isShowTips() {
        return GlobalSPUtil.getClickedOpenRideTipCloseTimes(this.mContext) < 3 && !m10517a();
    }

    public void onClick(View view) {
        AbsNewOpenRidePresenter absNewOpenRidePresenter;
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f14717c && (absNewOpenRidePresenter = this.f14718d) != null) {
            absNewOpenRidePresenter.onOpenRideEntranceClick();
        }
    }

    /* renamed from: a */
    private boolean m10517a() {
        return TextUtils.isEmpty(FormStore.getInstance().getOpenRideBrand());
    }

    /* renamed from: b */
    private void m10519b() {
        if (!m10517a()) {
            LEGOBubble createBubble = LEGOUICreator.createBubble(this.f14715a.getContext(), String.format(getContext().getResources().getString(R.string.global_home_open_ride_tips), new Object[]{FormStore.getInstance().getOpenRideBrand()}), Color.parseColor("#5C6166"), "right", 3, true, new BubbleCloseListener() {
                public void onClick(LEGOBubble lEGOBubble) {
                    NewOpenRideView.this.f14716b.setVisibility(4);
                    GlobalOmegaUtils.trackEvent("ibt_gp_home_guidenewlearn_close_ck");
                    int clickedOpenRideTipCloseTimes = GlobalSPUtil.getClickedOpenRideTipCloseTimes(NewOpenRideView.this.mContext);
                    if (clickedOpenRideTipCloseTimes < 3) {
                        GlobalSPUtil.setClickedOpenRideTipCloseTimes(NewOpenRideView.this.mContext, clickedOpenRideTipCloseTimes + 1);
                    }
                }
            });
            this.f14721g = createBubble;
            if (createBubble.getView() != null) {
                this.f14716b.removeAllViews();
                this.f14716b.addView(this.f14721g.getView());
            }
        }
        if (isShowTips()) {
            this.f14716b.setVisibility(0);
        } else {
            this.f14716b.setVisibility(4);
        }
    }

    public void setTranslationY(int i) {
        if (i > 0) {
            return;
        }
        if (this.isInflated) {
            getView().setTranslationY((float) i);
        } else {
            this.f14719e = i;
        }
    }

    public void setVisible(final boolean z) {
        if ("ride".equals(ConfProxy.getInstance().getSelectedType())) {
            super.inflate();
            m10519b();
            if (isShowTips()) {
                GlobalOmegaUtils.trackEvent("ibt_gp_home_guidenewlearn_sw");
            }
            this.f14715a.setVisibility(z ? 0 : 4);
            this.f14720f.addViewToRightRegion(this.f14715a);
            this.f14715a.postDelayed(new Runnable() {
                public void run() {
                    int measuredHeight = (int) (((float) NewOpenRideView.this.getView().getMeasuredHeight()) - TypedValue.applyDimension(1, 2.0f, NewOpenRideView.this.getView().getResources().getDisplayMetrics()));
                    if (measuredHeight < 0) {
                        measuredHeight = 0;
                    }
                    if (z) {
                        NewOpenRideView.this.f14718d.doPublish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, new OpenRideVisibilityEvent(measuredHeight, true));
                    } else {
                        NewOpenRideView.this.f14718d.doPublish(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_VISIBILITY_CHANGED, new OpenRideVisibilityEvent(measuredHeight, false));
                    }
                }
            }, 300);
        }
    }

    public boolean isVisible() {
        View view = this.f14715a;
        return view != null && view.getVisibility() == 0;
    }
}

package com.didi.component.confirmupdateaddress.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.GLog;
import com.didi.component.confirmupdateaddress.presenter.ConfirmUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.util.ConfirmGuideUtil;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class ConfirmUpdateAddressView implements View.OnClickListener, IConfirmUpdateAddress {

    /* renamed from: a */
    private final BusinessContext f12709a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f12710b;

    /* renamed from: c */
    private final ViewGroup f12711c;

    /* renamed from: d */
    private View f12712d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ConfirmUpdateAddressPresenter f12713e;

    /* renamed from: f */
    private TextView f12714f;

    /* renamed from: g */
    private TextView f12715g;

    /* renamed from: h */
    private TextView f12716h;

    /* renamed from: i */
    private FrameLayout f12717i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FrameLayout f12718j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f12719k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f12720l;

    public ConfirmUpdateAddressView(BusinessContext businessContext, ViewGroup viewGroup) {
        this.f12709a = businessContext;
        this.f12710b = businessContext.getContext();
        this.f12711c = viewGroup;
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_confirm_update_address_layout);
        viewByResId = viewByResId == null ? LayoutInflater.from(this.f12710b).inflate(R.layout.global_confirm_update_address_layout, viewGroup, false) : viewByResId;
        this.f12712d = viewByResId;
        this.f12714f = (TextView) viewByResId.findViewById(R.id.global_confirm_update_address_pick_up_tv);
        this.f12715g = (TextView) this.f12712d.findViewById(R.id.global_confirm_update_address_destination_tv);
        this.f12716h = (TextView) this.f12712d.findViewById(R.id.global_confirm_update_address_change_tv);
        this.f12717i = (FrameLayout) this.f12712d.findViewById(R.id.global_confirm_update_address_change_select_area);
        this.f12718j = (FrameLayout) this.f12712d.findViewById(R.id.guideLayout);
        this.f12717i.setOnClickListener(this);
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress != null && !TextUtils.isEmpty(startAddress.getDisplayName())) {
            this.f12714f.setText(startAddress.getDisplayName());
        } else if (!TextUtils.isEmpty(FormStore.getInstance().getDisplayName())) {
            this.f12714f.setText(FormStore.getInstance().getDisplayName());
        } else {
            this.f12714f.setText(ResourcesHelper.getString(this.f12710b, R.string.map_flow_current_location));
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            this.f12715g.setText(endAddress.getDisplayName());
        }
        m8665a();
    }

    public View getView() {
        return this.f12712d;
    }

    public void setPresenter(ConfirmUpdateAddressPresenter confirmUpdateAddressPresenter) {
        this.f12713e = confirmUpdateAddressPresenter;
    }

    public void onClick(View view) {
        ConfirmUpdateAddressPresenter confirmUpdateAddressPresenter;
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_confirm_update_address_change_select_area && (confirmUpdateAddressPresenter = this.f12713e) != null) {
            confirmUpdateAddressPresenter.onChangeClick();
        }
    }

    public void setPickUpText(String str) {
        TextView textView = this.f12714f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDestinationText(String str) {
        TextView textView = this.f12715g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setVisible(int i) {
        View view = this.f12712d;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m8665a() {
        if (ConfirmGuideUtil.INSTANCE.isShowEditGuideOnConfirm(this.f12710b)) {
            hideGuide();
            return;
        }
        final LEGOBubble createBubble = LEGOUICreator.createBubble(this.f12712d.getContext(), ResourcesHelper.getString(this.f12710b, R.string.GRider_page_Click_to_jxKZ), Color.parseColor("#5C6166"), "top_right", 3, false, (BubbleCloseListener) null);
        this.f12718j.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        View view = createBubble.getView();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ConfirmUpdateAddressView.this.f12713e != null) {
                    ConfirmUpdateAddressView.this.f12713e.onChangeClick();
                }
            }
        });
        this.f12718j.addView(view, layoutParams);
        this.f12718j.post(new Runnable() {
            public void run() {
                int[] iArr = new int[2];
                ConfirmUpdateAddressView.this.f12718j.getLocationInWindow(iArr);
                ConfirmUpdateAddressView confirmUpdateAddressView = ConfirmUpdateAddressView.this;
                int unused = confirmUpdateAddressView.f12719k = (confirmUpdateAddressView.f12718j.getMeasuredHeight() + iArr[1]) - ((ConfirmUpdateAddressView.this.f12718j.getMeasuredHeight() - createBubble.getPopupHeight()) / 2);
                int i = iArr[1];
                GLog.m7964d("showGuide>>>mBestViewPaddingTop: " + ConfirmUpdateAddressView.this.f12719k);
                if (ConfirmUpdateAddressView.this.f12719k != 0) {
                    ConfirmGuideUtil.INSTANCE.setBestViewPaddingTopValue(ConfirmUpdateAddressView.this.f12710b, i);
                }
                if (ConfirmUpdateAddressView.this.f12720l) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Location.EVENT_PADDING_TOP, Integer.valueOf(ConfirmUpdateAddressView.this.f12719k));
                }
            }
        });
    }

    public void hideGuide() {
        FrameLayout frameLayout = this.f12718j;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public int getBestViewTopPadding() {
        if (!ConfirmGuideUtil.INSTANCE.isShowEditGuideOnConfirm(this.f12710b)) {
            return this.f12719k;
        }
        return ConfirmGuideUtil.INSTANCE.getBestViewPaddingTopValue(this.f12710b);
    }

    public void sendGetBestViewTopPaddingEvent() {
        this.f12720l = true;
    }

    public void updateAlpha(float f) {
        View view = this.f12712d;
        if (view != null) {
            if (view.getAlpha() != f) {
                this.f12712d.setAlpha(f);
            }
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0 && this.f12712d.getVisibility() != 8) {
                this.f12712d.setVisibility(8);
            }
            if (i > 0 && this.f12712d.getVisibility() != 0) {
                this.f12712d.setVisibility(0);
            }
        }
    }
}

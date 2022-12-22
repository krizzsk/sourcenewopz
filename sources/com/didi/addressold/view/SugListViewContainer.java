package com.didi.addressold.view;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.didi.address.view.IPoiChangeListener;
import com.didi.address.view.ISugViewController;
import com.didi.addressold.util.ViewUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.Padding;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class SugListViewContainer extends FrameLayout implements ISugViewController {

    /* renamed from: a */
    float f7929a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISugMapCtrlCallback f7930b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ISugContainerOpCallback f7931c;

    /* renamed from: d */
    private IPoiChangeListener f7932d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<IPoiChangeListener> f7933e;

    /* renamed from: f */
    private Scroller f7934f;

    /* renamed from: g */
    private LinearLayout f7935g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SugListView f7936h;

    /* renamed from: i */
    private CommonAddressView f7937i;

    /* renamed from: j */
    private ViewGroup f7938j;

    /* renamed from: k */
    private ViewGroup f7939k;

    /* renamed from: l */
    private ViewGroup f7940l;

    /* renamed from: m */
    private ViewGroup f7941m;
    public boolean mIsMapDragged;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f7942n;

    /* renamed from: o */
    private ImageView f7943o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f7944p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f7945q;

    /* renamed from: r */
    private boolean f7946r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public View.OnClickListener f7947s;

    /* renamed from: t */
    private boolean f7948t;

    /* renamed from: u */
    private boolean f7949u;

    /* renamed from: v */
    private int f7950v;

    /* renamed from: w */
    private boolean f7951w;

    public int getScrollTime() {
        return 650;
    }

    public void onMapTouch() {
    }

    public SugListViewContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5116a();
    }

    public ListView getListView() {
        return this.f7936h;
    }

    /* renamed from: a */
    private void m5116a() {
        LayoutInflater.from(getContext()).inflate(R.layout.old_layout_list_view, this);
        this.f7934f = new Scroller(getContext());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lv_root);
        this.f7935g = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        SugListView sugListView = (SugListView) findViewById(R.id.lv);
        this.f7936h = sugListView;
        sugListView.setHeaderDividersEnabled(false);
        this.f7936h.setDivider((Drawable) null);
        this.f7936h.setDividerHeight(0);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_list_header_view, this.f7936h, false);
        this.f7937i = (CommonAddressView) viewGroup.findViewById(R.id.common_address_view);
        this.f7936h.addHeaderView(viewGroup);
        this.f7938j = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_tips_info_header_view, this.f7936h, false);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_select_poi_view, this.f7936h, false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.select_poi_layout);
        this.f7939k = viewGroup3;
        viewGroup3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SugListViewContainer.this.f7931c != null) {
                    SugListViewContainer.this.f7931c.hideInputWindow();
                }
                if (SugListViewContainer.this.f7947s != null) {
                    SugListViewContainer.this.f7947s.onClick(view);
                }
                SugListViewContainer.this.scrollToBottom();
                if (SugListViewContainer.this.f7936h.getAdapter() != null && SugListViewContainer.this.f7936h.getAdapter().getCount() > 0) {
                    SugListViewContainer.this.f7936h.smoothScrollToPosition(0);
                }
            }
        });
        this.f7936h.addFooterView(viewGroup2);
        this.f7940l = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_address_power_by_google_view, this.f7936h, false);
        this.f7936h.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        m5120b();
        m5124d();
    }

    /* renamed from: b */
    private void m5120b() {
        this.f7941m = (ViewGroup) findViewById(R.id.layout_map_ctrl);
        this.f7942n = (TextView) findViewById(R.id.tv_confirm);
        ImageView imageView = (ImageView) findViewById(R.id.iv_reset_map);
        this.f7943o = imageView;
        imageView.setContentDescription(getResources().getString(R.string.global_sug_contentdiscription_reset_click));
        this.f7943o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SugListViewContainer.this.f7930b != null) {
                    SugListViewContainer.this.f7930b.onResetBtnClick();
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            }
        });
        m5122c();
        this.f7942n.post(new Runnable() {
            public void run() {
                SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                int unused = sugListViewContainer.f7945q = sugListViewContainer.f7942n.getMeasuredHeight() + ((RelativeLayout.LayoutParams) SugListViewContainer.this.f7942n.getLayoutParams()).topMargin + ((RelativeLayout.LayoutParams) SugListViewContainer.this.f7942n.getLayoutParams()).bottomMargin;
                SystemUtils.log(3, "xu", "mMapTopPadding:" + SugListViewContainer.this.f7944p + ", mMapBottomPadding:" + SugListViewContainer.this.f7945q, (Throwable) null, "com.didi.addressold.view.SugListViewContainer$4", 199);
            }
        });
    }

    /* renamed from: c */
    private void m5122c() {
        if (this.f7942n != null) {
            try {
                if (DidiThemeManager.getIns().getResPicker(getContext()) == null) {
                    SystemUtils.log(3, "sfs", "SugListViewContainer initConfirmButton() DidiThemeManager.getIns().getResPicker(getContext()) == null", (Throwable) null, "com.didi.addressold.view.SugListViewContainer", 208);
                    DidiThemeManager.getIns().init((Application) getContext().getApplicationContext());
                }
                this.f7942n.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(this.f7942n.getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
                this.f7942n.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_selector));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m5124d() {
        this.f7933e = new ArrayList<>();
        this.f7932d = new IPoiChangeListener() {
            public void onPinLoading(double d, double d2) {
                Iterator it = SugListViewContainer.this.f7933e.iterator();
                while (it.hasNext()) {
                    ((IPoiChangeListener) it.next()).onPinLoading(d, d2);
                }
            }

            public void onPinPoiChanged(Address address) {
                Iterator it = SugListViewContainer.this.f7933e.iterator();
                while (it.hasNext()) {
                    IPoiChangeListener iPoiChangeListener = (IPoiChangeListener) it.next();
                    String string = SugListViewContainer.this.getResources().getString(R.string.global_sug_current_location);
                    if (TextUtils.isEmpty(address.displayName) || address.displayName.equals(string)) {
                        address.displayName = string;
                        address.address = string;
                        address.fullName = string;
                    }
                    iPoiChangeListener.onPinPoiChanged(address);
                }
            }

            public void onPinFetchPoiFailed(Address address) {
                Iterator it = SugListViewContainer.this.f7933e.iterator();
                while (it.hasNext()) {
                    ((IPoiChangeListener) it.next()).onPinFetchPoiFailed(address);
                }
            }
        };
    }

    public void setDragEnable(boolean z) {
        this.f7946r = z;
    }

    public void setConfirmBtnClickListener(View.OnClickListener onClickListener) {
        this.f7942n.setOnClickListener(onClickListener);
    }

    public void setConfirmBtnEnabled(boolean z) {
        this.f7942n.setEnabled(z);
    }

    public void addPoiListener(IPoiChangeListener iPoiChangeListener) {
        if (iPoiChangeListener != null) {
            synchronized (this.f7933e) {
                if (!this.f7933e.contains(iPoiChangeListener)) {
                    this.f7933e.add(iPoiChangeListener);
                }
            }
        }
    }

    public void removePoiListener(IPoiChangeListener iPoiChangeListener) {
        synchronized (this.f7933e) {
            this.f7933e.remove(iPoiChangeListener);
        }
    }

    public void setOperCallback(ISugMapCtrlCallback iSugMapCtrlCallback) {
        this.f7930b = iSugMapCtrlCallback;
    }

    public void setSugContainerOpCallback(ISugContainerOpCallback iSugContainerOpCallback) {
        this.f7931c = iSugContainerOpCallback;
    }

    public void onMapScroll() {
        if (this.f7935g.getVisibility() != 4) {
            this.f7935g.setVisibility(4);
            this.f7934f.forceFinished(true);
            if (getScrollY() != 0) {
                scrollTo(0, 0);
            }
            this.mIsMapDragged = true;
            if (!isMapCtrlState()) {
                this.f7941m.setVisibility(0);
            }
        }
        this.f7943o.setVisibility(0);
    }

    public IPoiChangeListener getPoiChangeListener() {
        return this.f7932d;
    }

    public Address getTargetAddress() {
        ISugContainerOpCallback iSugContainerOpCallback = this.f7931c;
        if (iSugContainerOpCallback == null) {
            return null;
        }
        return iSugContainerOpCallback.getTargetAddress();
    }

    public boolean isMapCtrlState() {
        return this.f7941m.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public int getScrollerCurrY() {
        Scroller scroller = this.f7934f;
        if (scroller != null) {
            return scroller.getCurrY();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5117a(int i, int i2) {
        ISugContainerOpCallback iSugContainerOpCallback;
        if (!this.f7948t) {
            this.f7941m.setVisibility(4);
            this.f7935g.setVisibility(0);
            int scrollY = getScrollY();
            this.f7934f.startScroll(0, scrollY, 0, i - scrollY, i2);
            if (i == 0) {
                ISugContainerOpCallback iSugContainerOpCallback2 = this.f7931c;
                if (iSugContainerOpCallback2 != null) {
                    iSugContainerOpCallback2.onScrollToTop();
                }
            } else if (i == getScrollYMax() && (iSugContainerOpCallback = this.f7931c) != null) {
                iSugContainerOpCallback.onScrollToBottom();
            }
            invalidate();
        }
    }

    public void scrollToTop() {
        post(new Runnable() {
            public void run() {
                if (SugListViewContainer.this.getScrollerCurrY() != 0) {
                    SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                    sugListViewContainer.m5117a(0, sugListViewContainer.getScrollTime());
                }
            }
        });
    }

    public void scrollToBottom() {
        post(new Runnable() {
            public void run() {
                if (SugListViewContainer.this.getScrollerCurrY() != SugListViewContainer.this.getScrollYMax()) {
                    SugListViewContainer sugListViewContainer = SugListViewContainer.this;
                    sugListViewContainer.m5117a(sugListViewContainer.getScrollYMax(), SugListViewContainer.this.getScrollTime());
                }
            }
        });
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f7934f.computeScrollOffset()) {
            scrollTo(this.f7934f.getCurrX(), this.f7934f.getCurrY());
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7946r) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            float rawY = motionEvent.getRawY();
            this.f7929a = rawY;
            if (rawY < ((float) (getTop() - getScrollY()))) {
                this.f7949u = true;
            } else {
                this.f7949u = false;
            }
        } else if (actionMasked == 2) {
            float rawY2 = motionEvent.getRawY() - this.f7929a;
            if (this.f7936h.isScrollToTop() && rawY2 > 0.0f) {
                return true;
            }
            if (getScrollY() < 0 && rawY2 < ((float) (-ViewUtils.dip2px(getContext(), 7.0f)))) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7946r || isMapCtrlState()) {
            return super.onTouchEvent(motionEvent);
        }
        int rawY = (int) motionEvent.getRawY();
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (rawY < rect.top + Math.abs(getScrollY())) {
            return super.onTouchEvent(motionEvent);
        }
        if (rawY < getTop() - getScrollY() && this.f7949u) {
            return super.onTouchEvent(motionEvent);
        }
        if (getScrollY() <= (-getScrollYMax()) * -1 && rawY - this.f7950v > 0) {
            this.f7950v = rawY;
            if (getScrollY() < (-getScrollYMax()) * -1) {
                scrollTo(0, (-getScrollYMax()) * -1);
            }
            return super.onTouchEvent(motionEvent);
        } else if (getScrollY() < 0 || rawY - this.f7950v >= 0) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (getScrollY() >= 0 || getScrollY() <= getScrollYMax()) {
                    m5117a(0, 0);
                } else if (getScrollY() < getScrollYMax() / 2) {
                    m5117a(getScrollYMax(), getScrollTime());
                } else {
                    m5117a(0, getScrollTime());
                }
                rawY = 0;
            } else if (action == 2) {
                ViewUtils.hideInputWindow(getContext(), this);
                if (this.f7950v == 0) {
                    this.f7950v = rawY;
                }
                scrollBy(0, -(rawY - this.f7950v));
            }
            this.f7950v = rawY;
            return true;
        } else {
            this.f7950v = rawY;
            if (getScrollY() > 0) {
                scrollTo(0, 0);
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ISugContainerOpCallback iSugContainerOpCallback = this.f7931c;
        if (iSugContainerOpCallback != null) {
            iSugContainerOpCallback.onSugContainerScrollChanged(i, i2, i3, i4);
        }
        if (this.f7930b != null) {
            if (this.f7935g.getVisibility() != 0) {
                this.f7930b.onDeparturePinShow(true, new Padding(0, this.f7944p, 0, this.f7945q));
            } else if (i2 == 0) {
                this.f7930b.onDeparturePinShow(false, (Padding) null);
            } else {
                this.f7930b.onDeparturePinShow(true, new Padding(0, this.f7944p, 0, this.f7945q));
            }
        }
        if (i2 < 0 && !this.f7951w) {
            this.f7951w = true;
            this.f7936h.setBackgroundDrawable(getResources().getDrawable(R.drawable.old_poi_one_address_listview_bg));
        } else if (i2 >= 0 && this.f7951w) {
            this.f7951w = false;
            this.f7936h.setBackgroundColor(-1);
        }
    }

    public int getScrollYMax() {
        int i;
        CommonAddressView commonAddressView = this.f7937i;
        if (commonAddressView == null || commonAddressView.getVisibility() != 0) {
            i = ViewUtils.dip2px(getContext(), 140.0f);
        } else {
            i = this.f7937i.getMeasuredHeight() + ((RelativeLayout.LayoutParams) this.f7937i.getLayoutParams()).topMargin;
        }
        return Math.min(0, (-getMeasuredHeight()) + i);
    }

    public void setTopPadding(int i) {
        this.f7944p = i;
        SystemUtils.log(3, "xu", "mMapTopPadding:" + this.f7944p + ", mMapBottomPadding:" + this.f7945q, (Throwable) null, "com.didi.addressold.view.SugListViewContainer", 564);
    }

    public void showCommonAddressHeaderView(boolean z) {
        this.f7937i.setVisibility(z ? 0 : 8);
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7936h.removeHeaderView(this.f7938j);
        if (tipsInfo != null && !TextUtils.isEmpty(tipsInfo.content)) {
            this.f7936h.addHeaderView(this.f7938j);
            TextView textView = (TextView) this.f7938j.findViewById(R.id.tips_info_view);
            textView.setText(tipsInfo.content);
            if (!TextUtils.isEmpty(tipsInfo.content_color)) {
                textView.setTextColor(Color.parseColor(tipsInfo.content_color));
            }
            if (!TextUtils.isEmpty(tipsInfo.background_color)) {
                ((RelativeLayout) this.f7938j.findViewById(R.id.tips_info_layout)).setBackgroundColor(Color.parseColor(tipsInfo.background_color));
            }
        }
    }

    public void showSelectPoiFooterView(boolean z) {
        this.f7939k.setVisibility(z ? 0 : 8);
    }

    public void setOnSelectPoiFooterViewClickListener(View.OnClickListener onClickListener) {
        this.f7947s = onClickListener;
    }

    public void onlyShowSelectPoiFooterView() {
        this.f7936h.setVisibility(0);
        this.f7936h.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        this.f7939k.setVisibility(0);
        this.f7936h.removeFooterView(this.f7940l);
    }

    public void updateLogoView(boolean z, String str, int i, int i2) {
        this.f7936h.removeFooterView(this.f7940l);
        if (z && !TextUtils.isEmpty(str) && i > 0 && i2 > 0) {
            ImageView imageView = (ImageView) this.f7940l.findViewById(R.id.powered_by_img);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (ViewUtils.isBigScreen(getContext())) {
                layoutParams.width = i * 3;
                layoutParams.height = i2 * 3;
            } else {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            imageView.setLayoutParams(layoutParams);
            Glide.with(getContext().getApplicationContext()).load(str).into(imageView);
            this.f7936h.addFooterView(this.f7940l, (Object) null, false);
        }
    }

    public void setHomeAddress(Address address) {
        this.f7937i.setHome(address);
    }

    public Address getHomeAddress() {
        return this.f7937i.getHomeAddress();
    }

    public void setCompanyAddress(Address address) {
        this.f7937i.setCompany(address);
    }

    public Address getCompanyAddress() {
        return this.f7937i.getCompanyAddress();
    }

    public void setCommonAddressViewClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f7937i.setHomeClickListener(onClickListener);
        this.f7937i.setCompanyClickListener(onClickListener2);
        this.f7937i.setCommonAddressClickListener(onClickListener3);
    }

    public void onDestory() {
        this.f7948t = true;
    }
}

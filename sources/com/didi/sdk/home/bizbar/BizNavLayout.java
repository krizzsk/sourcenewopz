package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.home.bizbar.HomeBizNavBarFragment;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;

public class BizNavLayout extends LinearLayout {

    /* renamed from: a */
    private Logger f36376a = LoggerFactory.getLogger("BizEntranceLayout");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CarGrop f36377b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HomeBizNavBarFragment.BizSelectListener f36378c;

    /* renamed from: d */
    private int f36379d;

    /* renamed from: e */
    private BizNavItemMgr f36380e;

    /* renamed from: f */
    private int f36381f;

    public BizNavLayout(Context context) {
        super(context);
    }

    public BizNavLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizNavLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setBizNavItemMgr(BizNavItemMgr bizNavItemMgr) {
        this.f36380e = bizNavItemMgr;
        this.f36381f = bizNavItemMgr.getMaxColumnNum();
        notifyDataChanged();
    }

    public void setSelectListener(HomeBizNavBarFragment.BizSelectListener bizSelectListener) {
        this.f36378c = bizSelectListener;
    }

    public View getItemByGroupType(String str) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof BizNavItemView) && str != null && str.equals(childAt.getTag())) {
                return ((BizNavItemView) childAt).getBizBarll();
            }
        }
        return null;
    }

    public void notifyDataChanged() {
        if (this.f36380e.getList() == null || this.f36380e.getList().size() == 0) {
            removeAllViews();
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        int size = this.f36380e.getList().size();
        int i = 0;
        while (true) {
            int i2 = this.f36381f;
            if (i >= (size > i2 ? i2 - 1 : size)) {
                break;
            }
            m25748a(i, this.f36380e.getList().get(i));
            i++;
        }
        if (size > this.f36381f) {
            m25753b();
            this.f36379d = this.f36381f;
        } else {
            this.f36379d = size;
        }
        this.f36376a.debug("biz_bar", "requestLayout: ");
    }

    /* renamed from: a */
    private void m25747a() {
        ViewParent viewParent = this;
        while (viewParent != null) {
            viewParent.requestLayout();
            if (viewParent instanceof View) {
                ((View) viewParent).forceLayout();
            }
            viewParent = viewParent.getParent();
            Logger logger = this.f36376a;
            logger.debug("biz_bar", "forceLayoutByHand: viewparent = " + viewParent);
        }
    }

    /* renamed from: a */
    private void m25748a(int i, TopCarGroupWrapper topCarGroupWrapper) {
        if (topCarGroupWrapper == null || topCarGroupWrapper.carGrop == null) {
            this.f36376a.error("biz_bar", "there contains invalid data when addView: ");
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        addView(m25751b(i, topCarGroupWrapper), layoutParams);
        if (topCarGroupWrapper.isSelected) {
            this.f36377b = topCarGroupWrapper.carGrop;
        }
    }

    /* renamed from: b */
    private void m25753b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        final BizNavItemView bizNavItemView = new BizNavItemView(getContext(), false);
        m25749a(bizNavItemView);
        if (this.f36380e.getHotInfo() != null && this.f36380e.isRedPointShowOnMore() && this.f36380e.isRedPointNeedShow()) {
            bizNavItemView.setRedPoint(this.f36380e.getHotInfo().hotUrl);
            this.f36380e.setNavRedPointItemView(bizNavItemView);
        }
        bizNavItemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BizNavLayout.this.f36378c == null || !BizNavLayout.this.isClickable()) {
                    SystemUtils.log(3, "BizNavLayout", "isClickable: " + BizNavLayout.this.isClickable(), (Throwable) null, "com.didi.sdk.home.bizbar.BizNavLayout$1", 152);
                    return;
                }
                BizNavLayout.this.f36378c.onSelect((CarGrop) null, (CarGrop) null, bizNavItemView.getRedPointVisibility() == 0, 2);
            }
        });
        addView(bizNavItemView, layoutParams);
    }

    /* renamed from: b */
    private BizNavItemView m25751b(int i, TopCarGroupWrapper topCarGroupWrapper) {
        final CarGrop carGrop = topCarGroupWrapper.carGrop;
        final BizNavItemView bizNavItemView = new BizNavItemView(getContext(), this.f36380e.getList().size() <= 3);
        bizNavItemView.setText(carGrop.getName());
        bizNavItemView.setGravity(17);
        bizNavItemView.setTag(carGrop.getGroupType());
        m25750a(bizNavItemView, carGrop, topCarGroupWrapper.isSelected);
        if (this.f36380e.hasRedPoint(carGrop.getGroupType(), carGrop.getNavTag()) && this.f36380e.isRedPointNeedShow()) {
            bizNavItemView.setRedPoint(this.f36380e.getHotInfo().hotUrl);
            this.f36380e.setNavRedPointItemView(bizNavItemView);
        }
        bizNavItemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BizNavLayout.this.f36377b == null || BizNavLayout.this.f36377b.getNavTag() != carGrop.getNavTag()) {
                    bizNavItemView.showIconAnimation();
                    if (BizNavLayout.this.f36378c == null || !BizNavLayout.this.isClickable()) {
                        SystemUtils.log(3, "BizNavLayout", "isClickable: " + BizNavLayout.this.isClickable(), (Throwable) null, "com.didi.sdk.home.bizbar.BizNavLayout$2", 183);
                        return;
                    }
                    BizNavLayout.this.f36378c.onSelect(BizNavLayout.this.f36377b, carGrop, bizNavItemView.getRedPointVisibility() == 0, 1);
                }
            }
        });
        return bizNavItemView;
    }

    public TopCarGroupWrapper switchToPage(String str) {
        int i;
        TopCarGroupWrapper topCarGroupWrapper;
        boolean z;
        BizNavItemMgr bizNavItemMgr = this.f36380e;
        if (!(bizNavItemMgr == null || bizNavItemMgr.getList() == null || this.f36380e.getList().size() == 0)) {
            Iterator<TopCarGroupWrapper> it = this.f36380e.getList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    topCarGroupWrapper = null;
                    z = false;
                    break;
                }
                topCarGroupWrapper = it.next();
                if (str.equals(topCarGroupWrapper.carGrop.getNavTag())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                List<TopCarGroupWrapper> list = this.f36380e.getList();
                boolean z2 = list.size() > this.f36381f;
                for (i = 0; i < list.size(); i++) {
                    if (str.equals(list.get(i).carGrop.getNavTag())) {
                        setItemSelected(i);
                        if (!z2 || i < this.f36381f - 1) {
                            return null;
                        }
                        return topCarGroupWrapper;
                    }
                }
            }
        }
        return null;
    }

    private void setItemSelected(int i) {
        if (this.f36380e.getList() != null && this.f36380e.getList().size() != 0) {
            this.f36377b = this.f36380e.getList().get(i).carGrop;
            for (int i2 = 0; i2 < this.f36379d; i2++) {
                if (i2 == this.f36381f - 1 && this.f36380e.getList().size() > this.f36381f) {
                    m25749a((BizNavItemView) getChildAt(i2));
                } else if (i2 == i) {
                    this.f36380e.getList().get(i2).isSelected = true;
                    m25750a((BizNavItemView) getChildAt(i2), this.f36380e.getList().get(i2).carGrop, true);
                } else {
                    this.f36380e.getList().get(i2).isSelected = false;
                    m25750a((BizNavItemView) getChildAt(i2), this.f36380e.getList().get(i2).carGrop, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m25750a(BizNavItemView bizNavItemView, CarGrop carGrop, boolean z) {
        if (z) {
            bizNavItemView.setTextColor(getContext().getResources().getColor(R.color.new_ui_biz_text_color_sel));
            bizNavItemView.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(getContext(), Typeface.DEFAULT_BOLD));
            bizNavItemView.setIcon(carGrop.getGroupIconActived());
            bizNavItemView.setIconAlpha(1.0f);
            bizNavItemView.setText(carGrop.getName());
            if (bizNavItemView.getRedPointVisibility() == 0) {
                this.f36380e.activeRedPointCount();
                if (!this.f36380e.isRedPointNeedShow()) {
                    bizNavItemView.setRedPointVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        bizNavItemView.setTextColor(getContext().getResources().getColor(R.color.new_ui_biz_text_color_unsel));
        bizNavItemView.setTypeface(DIDIFontUtils.Companion.getDidiTypeface(getContext(), Typeface.DEFAULT));
        bizNavItemView.setIcon(carGrop.getGroupIcon());
        bizNavItemView.setIconAlpha(0.4f);
        bizNavItemView.setText(carGrop.getName());
    }

    /* renamed from: a */
    private void m25749a(BizNavItemView bizNavItemView) {
        bizNavItemView.setText(ResourcesHelper.getString(getContext(), R.string.GRider_Homepage0714_More_ZFoX));
        bizNavItemView.setIconRes(R.drawable.biz_bar_nav_icon_more);
        bizNavItemView.setIconAlpha(0.4f);
        bizNavItemView.setTextColor(getContext().getResources().getColor(R.color.new_ui_biz_text_color_unsel));
        if (bizNavItemView.getRedPointVisibility() == 0 && !this.f36380e.isRedPointNeedShow()) {
            bizNavItemView.setRedPointVisibility(8);
        }
    }

    public CarGrop getSelectedGrop() {
        return this.f36377b;
    }
}

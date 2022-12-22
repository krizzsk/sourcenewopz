package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.LayoutParamsUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.view.helper.GuideViewHelper;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.sdk.global.sign.view.helper.RedDotViewHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PayMethodSelectFragmentView extends PayMethodBaseFragmentView implements View.OnClickListener {

    /* renamed from: a */
    private LinearLayout f36331a;

    /* renamed from: b */
    private LinearLayout f36332b;

    /* renamed from: c */
    private LinearLayout f36333c;

    /* renamed from: d */
    private PaySelPageData f36334d;

    /* renamed from: e */
    private EnterprisePayway f36335e;

    /* renamed from: f */
    private RelativeLayout f36336f;

    /* renamed from: g */
    private TextView f36337g;

    /* renamed from: h */
    private AccountFreezeData f36338h = null;

    public PayMethodSelectFragmentView(Context context) {
        super(context);
        m25712a(context);
    }

    public PayMethodSelectFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25712a(context);
    }

    /* renamed from: a */
    private void m25712a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_paymethod_select, this, true);
        this.f36333c = (LinearLayout) findViewById(R.id.ll_paymethod_container);
        this.f36331a = (LinearLayout) findViewById(R.id.ll_empty);
        this.f36332b = (LinearLayout) findViewById(R.id.ll_content);
        this.f36336f = (RelativeLayout) findViewById(R.id.freeze_banner_container);
        this.f36337g = (TextView) findViewById(R.id.banner_title_tv);
        this.f36331a.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mPayMethodPageEventListener != null) {
            if (view.getId() == R.id.freeze_banner_container) {
                AccountFreezeData accountFreezeData = this.f36338h;
                this.mPayMethodPageEventListener.onPageUrlClicked((accountFreezeData == null || !accountFreezeData.isJumpable(0)) ? "" : this.f36338h.getLink(0));
                return;
            }
            this.mPayMethodPageEventListener.onPageClickEvent(view, this.f36334d);
        }
    }

    public void updateContentView(PaySelPageData paySelPageData, DidiGlobalPayMethodListData.Entrance entrance, EnterprisePayway enterprisePayway) {
        this.f36334d = paySelPageData;
        this.f36335e = enterprisePayway;
        if (paySelPageData == null || paySelPageData.payMethodList == null || paySelPageData.payMethodList.size() == 0) {
            showEmptyView();
            return;
        }
        showContentView();
        this.f36338h = paySelPageData.accountFreezeData;
        if (!WalletApolloUtil.isNewPayMethodListEnable() || CollectionUtil.isEmpty((Collection<?>) paySelPageData.groupList)) {
            this.mCardViewManager.insertPayMethodView(this.f36333c, paySelPageData.payMethodList, enterprisePayway);
        } else {
            m25713a(this.f36338h);
            this.mCardViewManager.insertPayMethodViewByGroup(this.f36333c, paySelPageData.payMethodList, paySelPageData.groupList, enterprisePayway);
        }
        PayMethodSelectHelper.checkCombine(this.mPayMethodViewList);
        RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
        GuideViewHelper.showGuideView(this.mContext, this.mPayMethodViewList);
    }

    /* renamed from: a */
    private void m25713a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData != null && accountFreezeData.isBannerValid()) {
            this.f36336f.setVisibility(0);
            LayoutParamsUtil.resetLayoutMarginInV(this, 0, -9999);
            this.f36337g.setText(accountFreezeData.getTitle(0));
            if (!accountFreezeData.isJumpable(0)) {
                this.f36336f.findViewById(R.id.gotodetail_img).setVisibility(8);
            } else {
                this.f36336f.setOnClickListener(this);
            }
        }
    }

    public int getEnterpriseFlag() {
        EnterprisePayway enterprisePayway = this.f36335e;
        if (enterprisePayway == null) {
            return 1;
        }
        return enterprisePayway.toggle ? 3 : 2;
    }

    public void showEmptyView() {
        this.f36332b.setVisibility(8);
        this.f36331a.setVisibility(0);
    }

    public void showContentView() {
        this.f36332b.setVisibility(0);
        this.f36331a.setVisibility(8);
    }

    public List<PaySelItemData> getSelectedPayMethod() {
        ArrayList arrayList = new ArrayList();
        if (!(this.mPayMethodViewList == null || this.mPayMethodViewList.size() == 0)) {
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if (payMethodCardView.getIsSelected()) {
                    arrayList.add(payMethodCardView.getPayMethodItemInfo());
                }
            }
        }
        return arrayList;
    }

    public boolean hasSelectablePayMethod() {
        if (!(this.mPayMethodViewList == null || this.mPayMethodViewList.size() == 0)) {
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if ((payMethodCardView.getPayMethodItemInfo().style == 3 || payMethodCardView.getPayMethodItemInfo().style == 1) && payMethodCardView.getPayMethodItemInfo().isEnabled && payMethodCardView.getPayMethodItemInfo().isSufficient) {
                    return true;
                }
            }
        }
        return false;
    }

    public void doPayMethodPerformClick(PaySelItemData paySelItemData) {
        PaySelPageData paySelPageData;
        if (paySelItemData != null) {
            SystemUtils.log(3, "wallet", "Replay click on item: " + paySelItemData.toString(), (Throwable) null, "com.didi.sdk.global.sign.view.PayMethodSelectFragmentView", 212);
            if (this.mPayMethodViewList != null && this.mPayMethodViewList.size() != 0 && (paySelPageData = this.f36334d) != null && paySelPageData.payMethodList != null && this.f36334d.payMethodList.size() != 0) {
                for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                    if (paySelItemData.channelId == payMethodCardView.getChannelId()) {
                        PaySelItemData payMethodItemInfo = payMethodCardView.getPayMethodItemInfo();
                        if (TextUtil.isEmpty(paySelItemData.cardIndex) || paySelItemData.cardIndex.equalsIgnoreCase(payMethodItemInfo.cardIndex)) {
                            payMethodCardView.performClick();
                            return;
                        }
                    }
                }
            }
        }
    }

    public void doEnterprisePayMethodPerformClick(int i) {
        PaySelPageData paySelPageData;
        if (this.mPayMethodViewList != null && this.mPayMethodViewList.size() != 0 && (paySelPageData = this.f36334d) != null && paySelPageData.payMethodList != null && this.f36334d.payMethodList.size() != 0) {
            PaySelItemData paySelItemData = null;
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if (i == payMethodCardView.getChannelId()) {
                    paySelItemData = payMethodCardView.getPayMethodItemInfo();
                }
            }
            if (paySelItemData != null) {
                for (PayMethodCardView payMethodCardView2 : this.mPayMethodViewList) {
                    if (i == payMethodCardView2.getChannelId()) {
                        payMethodCardView2.setIsSelected(true);
                    } else if (!m25714a(payMethodCardView2.getPayMethodItemInfo(), paySelItemData)) {
                        payMethodCardView2.setIsSelected(false);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m25714a(PaySelItemData paySelItemData, PaySelItemData paySelItemData2) {
        return (paySelItemData == null || paySelItemData.allowedCombineTags == null || !paySelItemData.allowedCombineTags.contains(Integer.valueOf(paySelItemData2.combineTag))) ? false : true;
    }
}

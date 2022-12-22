package com.didi.payment.wallet.global.wallet.view.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.LayoutParamsUtil;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.view.helper.FreezeHelper;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.WalletAccountData;
import com.didi.payment.wallet.global.model.WalletApolloUtils;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.mainlist.WalletMainListAccountSectionView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;

public class WalletMainListView extends WalletAbsSectionView<WalletPageInfo, IWalletMainListEventListener> {

    /* renamed from: a */
    private ImageView f32420a;

    /* renamed from: b */
    private ImageView f32421b;

    /* renamed from: c */
    private ImageView f32422c;

    /* renamed from: d */
    private ImageView f32423d;

    /* renamed from: e */
    private TextView f32424e;

    /* renamed from: f */
    private View f32425f;

    /* renamed from: g */
    private View f32426g;

    /* renamed from: h */
    private View f32427h;

    /* renamed from: i */
    private View f32428i;

    /* renamed from: j */
    private WalletPromotionSectionView f32429j;

    /* renamed from: k */
    private WalletPayMethodSectionView f32430k;

    /* renamed from: l */
    private WalletMainListAccountSectionView f32431l;

    /* renamed from: m */
    private PixMainEntrySectionView f32432m;

    /* renamed from: n */
    private WalletConsumeSectionView f32433n;

    /* renamed from: o */
    private WalletBalanceSectionView f32434o;

    /* renamed from: p */
    private WalletNewPayMethodListView f32435p;

    /* renamed from: q */
    private WalletFinancialServiceSectionView f32436q;

    /* renamed from: r */
    private View f32437r;

    /* renamed from: s */
    private ViewStub f32438s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public View f32439t;

    /* renamed from: u */
    private View f32440u;

    /* renamed from: v */
    private LottieAnimationView f32441v;

    /* renamed from: w */
    private LoadingProxyHolder.ILoadingProxy f32442w;

    /* renamed from: x */
    private boolean f32443x;

    /* renamed from: y */
    private WalletPageInfo f32444y;

    public WalletMainListView(Context context) {
        super(context);
    }

    public WalletMainListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletMainListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.mContext = context;
        boolean z = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_main_list, this, true);
        this.f32425f = findViewById(R.id.ll_content);
        this.f32426g = findViewById(R.id.ll_content_parent);
        this.f32428i = findViewById(R.id.ll_empty);
        this.f32420a = (ImageView) inflate.findViewById(R.id.wallet_iv_close);
        this.f32427h = inflate.findViewById(R.id.ll_payment_title);
        this.f32421b = (ImageView) inflate.findViewById(R.id.iv_service_center);
        this.f32422c = (ImageView) inflate.findViewById(R.id.iv_setting);
        this.f32423d = (ImageView) inflate.findViewById(R.id.iv_transaction);
        this.f32424e = (TextView) inflate.findViewById(R.id.tv_payment_method_title);
        this.f32429j = (WalletPromotionSectionView) inflate.findViewById(R.id.v_promotion_section);
        this.f32430k = (WalletPayMethodSectionView) inflate.findViewById(R.id.v_paymethod_section);
        this.f32437r = inflate.findViewById(R.id.wallet_page_frozen_header_root);
        this.f32435p = (WalletNewPayMethodListView) inflate.findViewById(R.id.v_new_paymethod_section);
        this.f32431l = (WalletMainListAccountSectionView) inflate.findViewById(R.id.v_account_section);
        this.f32432m = (PixMainEntrySectionView) inflate.findViewById(R.id.v_pix_entrylist_section);
        this.f32434o = (WalletBalanceSectionView) inflate.findViewById(R.id.v_balance_section);
        this.f32433n = (WalletConsumeSectionView) inflate.findViewById(R.id.v_consume_section);
        this.f32440u = inflate.findViewById(R.id.tv_agent_retry);
        this.f32441v = (LottieAnimationView) findViewById(R.id.account_animation_view);
        this.f32438s = (ViewStub) findViewById(R.id.vs_setting_popup);
        this.f32436q = (WalletFinancialServiceSectionView) findViewById(R.id.v_finance_section);
        this.f32420a.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletMainListView.this.mListener != null) {
                    ((IWalletMainListEventListener) WalletMainListView.this.mListener).onCloseEvent();
                }
            }
        });
        this.f32421b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletMainListView.this.mListener != null) {
                    ((IWalletMainListEventListener) WalletMainListView.this.mListener).onServiceCenterClicked();
                }
            }
        });
        this.f32440u.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletMainListView.this.mListener != null) {
                    ((IWalletMainListEventListener) WalletMainListView.this.mListener).onRefreshPage();
                }
            }
        });
        this.f32422c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletMainListView.this.mListener != null) {
                    ((IWalletMainListEventListener) WalletMainListView.this.mListener).onSettingClicked();
                }
            }
        });
        this.f32423d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletMainListView.this.mListener != null) {
                    ((IWalletMainListEventListener) WalletMainListView.this.mListener).onTransactionClicked();
                }
            }
        });
        if (!WalletApolloUtil.isNewPayMethodListEnable() || WalletApolloUtils.useOldServer()) {
            z = false;
        }
        this.f32443x = z;
    }

    public void showFlowerAnimation() {
        this.f32441v.setRepeatCount(5);
        this.f32441v.playAnimation();
    }

    public void updateContent(WalletPageInfo walletPageInfo) {
        if (walletPageInfo == null) {
            showEmptyView();
            return;
        }
        showContentView();
        this.f32444y = walletPageInfo;
        if (walletPageInfo.accountSection != null) {
            m23013a(walletPageInfo.accountSection);
        }
        this.f32424e.setText(walletPageInfo.title);
        this.f32433n.updateContent(walletPageInfo.consumeSection);
        this.f32434o.updateContent(walletPageInfo.balanceSection);
        this.f32436q.updateContent(walletPageInfo.financeSection);
        boolean z = walletPageInfo.freezonData != null && walletPageInfo.freezonData.isFrozen();
        int i = 2;
        if (this.f32443x) {
            int color = ResourcesHelper.getColor(this.mContext, R.color.wallet_color_F3F4F5);
            setBackgroundColor(color);
            this.f32427h.setBackgroundColor(color);
            m23012a(this.f32437r, walletPageInfo.freezonData);
            this.f32435p.setStyle(2);
            this.f32435p.updateContent(m23010a(walletPageInfo.newPayMethodSection, new IViewFreezeApplyer.FreezeState(z), walletPageInfo.freezonData));
            this.f32430k.setVisibility(8);
            this.f32431l.setVisibility(8);
            this.f32429j.setVisibility(8);
        } else {
            setBackgroundColor(-1);
            this.f32427h.setBackgroundColor(-1);
            this.f32430k.updateContent(walletPageInfo.payMethodSection);
            this.f32431l.updateContent(walletPageInfo.accountSection);
            if (walletPageInfo.financeSection == null) {
                this.f32429j.updateContent(walletPageInfo.promotionSection);
            } else {
                this.f32429j.setVisibility(8);
            }
            this.f32435p.setVisibility(8);
        }
        if (WalletHomeResp.isSectionValid(walletPageInfo.pixSection)) {
            if (walletPageInfo.freezonData == null || !walletPageInfo.freezonData.isBlocked()) {
                PixMainEntrySectionView pixMainEntrySectionView = this.f32432m;
                if (this.f32443x) {
                    i = 3;
                }
                pixMainEntrySectionView.setStyle(i);
            } else {
                this.f32432m.setStyle(4);
            }
            this.f32432m.setVisibility(0);
            this.f32432m.setPixEntries(walletPageInfo.pixSection.title, walletPageInfo.pixSection);
        }
        updateTitleBarRightEntrance(walletPageInfo);
        if (z) {
            FreezeHelper.freezePageUI(this, new IViewFreezeApplyer.FreezeState(z));
        }
    }

    /* renamed from: a */
    private void m23013a(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        WalletAccountData walletAccountData = new WalletAccountData();
        walletAccountData.setStatus(accountSectionItem.status);
        walletAccountData.setFullKycStatus(accountSectionItem.fullKycStatus);
        walletAccountData.setSupportFullKyc(accountSectionItem.supportFullKyc);
        walletAccountData.setAccountStatus(accountSectionItem.accountStatus);
        walletAccountData.setAuthenticationStatus(accountSectionItem.facialRecognitionStatus);
        WalletSecuritySPUtils.setWalletAccountData(walletAccountData);
    }

    /* renamed from: a */
    private void m23012a(View view, final AccountFreezeData accountFreezeData) {
        if (accountFreezeData == null || !accountFreezeData.isBannerValid() || accountFreezeData.isBlocked()) {
            view.setVisibility(8);
            return;
        }
        this.f32427h.setBackgroundColor(ResourcesHelper.getColor(getContext(), R.color.transparent));
        view.setVisibility(0);
        LayoutParamsUtil.resetLayoutMarginInV(this.f32426g, 0, -9999);
        LayoutParamsUtil.resetLayoutMarginInV(this.f32435p, -UIUtil.dip2px(getContext(), 51.0f), -9999);
        TextView textView = (TextView) view.findViewById(R.id.frozen_header_main_title_tv);
        TextView textView2 = (TextView) view.findViewById(R.id.frozen_header_subtitle_tv);
        TextView textView3 = (TextView) view.findViewById(R.id.frozen_header_extra_tv);
        LayoutParamsUtil.resetLayoutWH(view.findViewById(R.id.frozen_header_topspace_view), -9999, UIUtil.dip2px(getContext(), 60.0f));
        int dimensionPixelSize = ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.wallet_account_freezebanner_margin_in_H_short);
        LayoutParamsUtil.resetLayoutMarginInH(textView, dimensionPixelSize, dimensionPixelSize);
        LayoutParamsUtil.resetLayoutMarginInH(textView2, dimensionPixelSize, dimensionPixelSize);
        LayoutParamsUtil.resetLayoutMarginInH(textView3, dimensionPixelSize, dimensionPixelSize);
        textView.setText(accountFreezeData.title);
        textView2.setText(accountFreezeData.subTitle);
        textView3.setText(accountFreezeData.desc);
        if (accountFreezeData.isJumpable(0)) {
            final String link = accountFreezeData.getLink(0);
            view.setOnClickListener(new DoubleCheckOnClickListener() {
                public void doClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
                    hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(WalletMainListView.this.mContext, "uid"));
                    PayTracker.trackEvent("pax_freezen_banner_ck", hashMap);
                    WebBrowserUtil.startInternalWebActivity(WalletMainListView.this.getContext(), link, "");
                }
            });
        } else {
            view.setOnClickListener((View.OnClickListener) null);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
        PayTracker.trackEvent("pax_freezen_banner_sw", hashMap);
    }

    /* renamed from: a */
    private WalletNewPayMethodListContract.Model m23010a(WalletPageQueryResp.NewPaymentMethodSectionBean newPaymentMethodSectionBean, IViewFreezeApplyer.FreezeState freezeState, AccountFreezeData accountFreezeData) {
        if (newPaymentMethodSectionBean == null) {
            return null;
        }
        WalletNewPayMethodListContract.Model model = new WalletNewPayMethodListContract.Model();
        model.title = newPaymentMethodSectionBean.title;
        if (newPaymentMethodSectionBean.transLink != null) {
            model.transEntrance = newPaymentMethodSectionBean.transLink.title;
            model.entranceLink = newPaymentMethodSectionBean.transLink.link;
        }
        if (accountFreezeData == null || !accountFreezeData.isBlocked()) {
            model.topTips = newPaymentMethodSectionBean.topTips;
        } else {
            model.topTipsTextColor = R.color.wallet_color_FF4060;
            model.topTipsBgColor = R.color.wallet_frozen_text_bg_color;
            model.topTips = accountFreezeData.title;
            model.faqLink = accountFreezeData.link;
        }
        if (newPaymentMethodSectionBean.entryList == null) {
            return model;
        }
        ArrayList arrayList = new ArrayList();
        for (WalletPageQueryResp.PaymentMethodEntryItemBean next : newPaymentMethodSectionBean.entryList) {
            next.freezeData = accountFreezeData;
            arrayList.add(m23009a(next, freezeState, accountFreezeData));
        }
        model.items = arrayList;
        return model;
    }

    /* renamed from: a */
    private WalletNewPayMethodListContract.ItemModel m23009a(WalletPageQueryResp.PaymentMethodEntryItemBean paymentMethodEntryItemBean, IViewFreezeApplyer.FreezeState freezeState, AccountFreezeData accountFreezeData) {
        int i = 0;
        boolean z = true;
        boolean z2 = freezeState != null && freezeState.isFreeze;
        boolean z3 = accountFreezeData != null && accountFreezeData.isBlocked();
        WalletNewPayMethodListContract.ItemModel itemModel = new WalletNewPayMethodListContract.ItemModel();
        itemModel.iconUrl = paymentMethodEntryItemBean.iconUrl;
        itemModel.name = paymentMethodEntryItemBean.name;
        itemModel.desc = paymentMethodEntryItemBean.desc;
        if (paymentMethodEntryItemBean.cardStatus != 1) {
            itemModel.descColor = R.color.wallet_color_FF5252;
        }
        int i2 = paymentMethodEntryItemBean.channelId;
        int i3 = R.color.wallet_color_D4D7D9;
        if (i2 == 150 && TextUtil.isEmpty(paymentMethodEntryItemBean.cardIndex)) {
            itemModel.type = 2;
            itemModel.name = ResourcesHelper.getString(this.mContext, R.string.GRider_Cognition_Add_a_dpKu);
            if (!z2 && !z3) {
                z = false;
            }
            itemModel.isInFreezeMode = z;
            if (z2 || z3) {
                i = R.color.wallet_color_D4D7D9;
            }
            itemModel.mainTextColor = i;
        } else if (paymentMethodEntryItemBean.channelId == 190 || paymentMethodEntryItemBean.channelId == 120) {
            itemModel.rightStyle = 2;
            int i4 = R.drawable.wallet_global_mainlist_balance_right_label_bg;
            if (z3) {
                itemModel.rightText = ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_unblock);
                itemModel.rightTextBg = R.drawable.wallet_global_mainlist_balance_right_label_bg;
                itemModel.rightTextColor = R.color.wallet_color_000000;
                itemModel.rightClickLink = accountFreezeData.dialogData.landingUrl;
                itemModel.rightClickable = true;
            } else {
                itemModel.rightText = ResourcesHelper.getString(this.mContext, R.string.wallet_balance_type_topup);
                if (z2) {
                    i4 = R.drawable.wallet_global_mainlist_account_btn_disable_bg;
                }
                itemModel.rightTextBg = i4;
                if (!z2) {
                    i3 = R.color.wallet_color_000000;
                }
                itemModel.rightTextColor = i3;
                itemModel.rightClickable = !z2;
            }
        } else {
            itemModel.rightStyle = 1;
            if (paymentMethodEntryItemBean.expired == 1 && !TextUtils.isEmpty(paymentMethodEntryItemBean.expiredDesc)) {
                itemModel.rightText = paymentMethodEntryItemBean.expiredDesc;
                itemModel.rightTextColor = R.color.wallet_boleto_cashin_tv_min_value_red;
            }
        }
        return itemModel;
    }

    public void initProgressDialog(final Activity activity) {
        this.f32442w = new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, (int) R.id.ll_payment_title, true);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide();
            }
        };
    }

    public void showProgressDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f32442w;
        if (iLoadingProxy != null) {
            iLoadingProxy.showLoading();
        }
    }

    public void dismissProgressDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f32442w;
        if (iLoadingProxy != null) {
            iLoadingProxy.dismissLoading();
        }
    }

    public void releaseProgressDialog() {
        this.f32442w = null;
    }

    public void showEmptyView() {
        this.f32425f.setVisibility(8);
        this.f32428i.setVisibility(0);
    }

    public void showContentView() {
        this.f32425f.setVisibility(0);
        this.f32428i.setVisibility(8);
    }

    public void setListener(IWalletMainListEventListener iWalletMainListEventListener) {
        super.setListener(iWalletMainListEventListener);
        this.f32429j.setListener(this.mListener);
        this.f32430k.setListener(this.mListener);
        this.f32431l.setListener(this.mListener);
        this.f32434o.setListener(this.mListener);
        this.f32433n.setListener(this.mListener);
        this.f32435p.setListener((WalletNewPayMethodListContract.Listener) this.mListener);
        this.f32436q.setListener(this.mListener);
        this.f32432m.setEventDeliveryListener((IPixEntryClickListener) this.mListener);
    }

    public void updateTitleBarRightEntrance(WalletPageInfo walletPageInfo) {
        if (walletPageInfo != null) {
            if (TextUtils.isEmpty(walletPageInfo.serviceCenterUrl)) {
                this.f32421b.setVisibility(8);
            } else {
                this.f32421b.setVisibility(0);
            }
            if (!(walletPageInfo.extendEntrySection == null || walletPageInfo.extendEntrySection.transaction == null)) {
                String str = walletPageInfo.extendEntrySection.transaction.iconUrl;
                if (!TextUtils.isEmpty(str) && walletPageInfo.extendEntrySection.transaction.enabled) {
                    this.f32422c.setVisibility(8);
                    this.f32421b.setVisibility(8);
                    this.f32423d.setVisibility(0);
                    GlideUtils.with2load2into(this.mContext, str, this.f32423d);
                }
            }
            if (walletPageInfo.newPayMethodSection != null && this.f32443x) {
                this.f32422c.setVisibility(0);
                m23014b(walletPageInfo.accountSection);
            }
        }
    }

    /* renamed from: b */
    private void m23014b(WalletPageQueryResp.AccountSectionItem accountSectionItem) {
        if (accountSectionItem != null && accountSectionItem.status == 0 && PaySharedPreferencesUtil.needWalletMainListSettingPopupShown(this.mContext)) {
            PaySharedPreferencesUtil.updateWalletMainListSettingPopupShownTimes(this.mContext);
            View view = this.f32439t;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            View inflate = this.f32438s.inflate();
            this.f32439t = inflate;
            ((WalletTriangleView) inflate.findViewById(R.id.wtv_setting_popup_arrow)).setColor(-10722970);
            this.f32439t.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletMainListView.this.f32439t.setVisibility(8);
                }
            });
        }
    }

    /* renamed from: a */
    private void m23011a() {
        View view = this.f32439t;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}

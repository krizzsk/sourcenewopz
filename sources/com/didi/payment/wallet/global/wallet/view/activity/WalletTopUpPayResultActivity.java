package com.didi.payment.wallet.global.wallet.view.activity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.finResource.FinResUtils;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.widget.CircleLoadingView;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.base.widget.FastCheckOnClickListener;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.prepaidcard.TopupPrepaidDialog;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletOperationBannerContract;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpOrderDetailPresenter;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpPayResultPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletOrderDetailSharePicAdapter;
import com.didi.payment.wallet.global.wallet.view.view.WalletOperationBannerSectionView;
import com.didi.payment.wallet.global.wallet.view.view.WalletOrderSharePicView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class WalletTopUpPayResultActivity extends WalletBaseActivity implements WalletTopUpPayResultContract.View {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public WalletTopUpPayResultContract.Presenter f32250A;

    /* renamed from: B */
    private int f32251B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f32252C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f32253D;

    /* renamed from: E */
    private int f32254E;

    /* renamed from: a */
    private ImageView f32255a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f32256b;

    /* renamed from: c */
    private TextView f32257c;

    /* renamed from: d */
    private CircleLoadingView f32258d;

    /* renamed from: e */
    private RelativeLayout f32259e;

    /* renamed from: f */
    private View f32260f;

    /* renamed from: g */
    private LottieAnimationView f32261g;

    /* renamed from: h */
    private View f32262h;

    /* renamed from: i */
    private ImageView f32263i;

    /* renamed from: j */
    private LinearLayout f32264j;

    /* renamed from: k */
    private TextView f32265k;

    /* renamed from: l */
    private TextView f32266l;

    /* renamed from: m */
    private TextView f32267m;
    protected TextView mTvBtn;

    /* renamed from: n */
    private TextView f32268n;

    /* renamed from: o */
    private TextView f32269o;

    /* renamed from: p */
    private ImageView f32270p;

    /* renamed from: q */
    private TextView f32271q;

    /* renamed from: r */
    private TextView f32272r;

    /* renamed from: s */
    private LinearLayout f32273s;

    /* renamed from: t */
    private WalletOperationBannerSectionView f32274t;

    /* renamed from: u */
    private RelativeLayout f32275u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public LEGODrawer f32276v;

    /* renamed from: w */
    private ScrollView f32277w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public WalletOrderSharePicContract.Presenter f32278x;

    /* renamed from: y */
    private WalletOrderSharePicContract.View f32279y;

    /* renamed from: z */
    private WalletOrderDetailSharePicAdapter f32280z;

    interface IPayResultUI {
        void onBottomBtnUI();

        void onPageTitleUI();

        void onTableViewUI();

        void onTitleBarUI();
    }

    public void onNetworkError() {
    }

    public static void launchFromFlutterTopUp(Context context, int i, int i2, String str, int i3) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtra("product_line", i2);
        intent.putExtra("order_id", str);
        intent.putExtra("order_type", i3);
        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, int i2, String str, int i3) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtra("product_line", i2);
        intent.putExtra("order_id", str);
        intent.putExtra("order_type", i3);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void launch(Context context, int i, Bundle bundle) {
        Intent intent = new Intent(context, WalletTopUpPayResultActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_topup_pay_result);
        this.f32250A = createPresenter();
        initViews();
        this.f32250A.executeTask();
    }

    /* access modifiers changed from: protected */
    public WalletTopUpPayResultContract.Presenter createPresenter() {
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 0);
            this.f32254E = intExtra;
            this.f32252C = intExtra == 256 || intExtra == 260;
        }
        if (intent != null) {
            this.f32253D = intent.getIntExtra("product_line", 0);
        }
        if (intent == null || intent.getIntExtra("order_type", -1) != 1) {
            return new WalletTopUpPayResultPresenter(this, this);
        }
        return new WalletTopUpOrderDetailPresenter(this, this);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.f32275u = (RelativeLayout) findViewById(R.id.root_view_layout);
        this.f32274t = (WalletOperationBannerSectionView) findViewById(R.id.v_operation_section);
        this.f32258d = (CircleLoadingView) findViewById(R.id.pay_result_circle_view);
        this.f32257c = (TextView) findViewById(R.id.pay_result_details_tv);
        this.mTvBtn = (TextView) findViewById(R.id.pay_result_confirm_btn);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.history_contacts_title_bar);
        this.f32259e = relativeLayout;
        relativeLayout.setBackgroundColor(ResourcesHelper.getColor(this, R.color.transparent));
        View findViewById = findViewById(R.id.divider_line);
        this.f32260f = findViewById;
        findViewById.setVisibility(8);
        this.f32256b = (TextView) findViewById(R.id.tv_right);
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        this.f32255a = imageView;
        if (!this.f32252C) {
            imageView.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
        }
        this.f32270p = (ImageView) findViewById(R.id.iv_right);
        this.f32262h = findViewById(R.id.pay_result_content_rl);
        this.f32263i = (ImageView) findViewById(R.id.pay_result_card_icon_iv);
        this.f32264j = (LinearLayout) findViewById(R.id.pay_result_page_card_ll);
        this.f32265k = (TextView) findViewById(R.id.pay_result_card_sub_title_tv);
        this.f32266l = (TextView) findViewById(R.id.pay_result_card_main_title_tv);
        this.f32251B = this.f32264j.getPaddingLeft();
        this.f32267m = (TextView) findViewById(R.id.pay_result_amount_price_tv);
        this.f32268n = (TextView) findViewById(R.id.pay_result_amount_symbol_tv);
        this.f32269o = (TextView) findViewById(R.id.tv_limit_info);
        this.f32271q = (TextView) findViewById(R.id.bubble_area_tv);
        this.f32272r = (TextView) findViewById(R.id.cancel_payment_btn);
        this.f32273s = (LinearLayout) findViewById(R.id.bottom_btn_layout);
        this.f32277w = (ScrollView) findViewById(R.id.content_view);
        this.mTvBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpPayResultActivity.this.f32250A.handleConfirmClick();
            }
        });
        this.f32255a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletTopUpPayResultActivity.this.f32252C) {
                    WalletTopUpPayResultActivity.this.f32250A.handleBackClick();
                } else if (WalletCommonParamsUtil.isPassengerClient()) {
                    DRouter.build("taxis99OneTravel://ride/backhome?groupType=wallet").start(WalletTopUpPayResultActivity.this.getContext());
                } else {
                    DRouter.build("99pay://one/nativeWallet").start(WalletTopUpPayResultActivity.this.getContext());
                }
            }
        });
        initLoadingDialog(this, R.id.history_contacts_title_bar);
        this.f32274t.setListener(new WalletOperationBannerContract.Listener() {
            public void onOperationItemClicked(WalletOperationItem walletOperationItem) {
                WalletTopUpPayResultActivity.this.f32250A.onOperationItemClicked(walletOperationItem);
            }

            public void onOperationItemShown(WalletOperationItem walletOperationItem) {
                WalletTopUpPayResultActivity.this.f32250A.onOperationItemShown(walletOperationItem);
            }
        });
    }

    public void showLoadingStart() {
        this.mTvBtn.setEnabled(false);
    }

    public void showCountdownLoading(int i, int i2) {
        if (this.f32258d.getVisibility() != 0) {
            this.f32258d.setVisibility(0);
        }
        if (this.f32257c.getVisibility() != 0) {
            this.f32257c.setVisibility(0);
        }
        this.f32277w.setVisibility(8);
        this.f32273s.setVisibility(8);
        this.f32269o.setVisibility(8);
        this.f32274t.setVisibility(8);
        CircleLoadingView circleLoadingView = this.f32258d;
        circleLoadingView.setText(i + ExifInterface.LATITUDE_SOUTH);
        this.f32258d.setProgress((double) i2);
    }

    /* renamed from: a */
    private void m22892a() {
        if (this.f32258d.getVisibility() != 8) {
            this.f32258d.setVisibility(8);
        }
        if (this.f32257c.getVisibility() != 8) {
            this.f32257c.setVisibility(8);
        }
        this.f32277w.setVisibility(0);
    }

    public void showLoadingFinish(WalletPayResultResp.PayResultData payResultData) {
        if (!this.f32250A.isSupportCountdonw()) {
            m22892a();
            if (payResultData == null) {
                return;
            }
        } else if (payResultData != null) {
            m22892a();
        } else {
            return;
        }
        refreshUIData(payResultData);
        m22905b(payResultData);
        m22895a(payResultData);
        m22897a(payResultData.pop);
    }

    /* renamed from: a */
    private void m22895a(WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null && payResultData.commonResourceState != null && isVisible2User()) {
            FinResUtils.INSTANCE.showFinSysPopUpDlg(this, payResultData.commonResourceState.getPopUpState());
        }
    }

    /* renamed from: a */
    private void m22897a(WalletPayResultResp.PopInfo popInfo) {
        if (popInfo != null && "0".equals(popInfo.type)) {
            new TopupPrepaidDialog(popInfo).show(getSupportFragmentManager(), "prepaid");
        }
    }

    /* renamed from: b */
    private void m22905b(WalletPayResultResp.PayResultData payResultData) {
        if (this.f32279y == null) {
            this.f32279y = new WalletOrderSharePicView(this);
            WalletOrderDetailSharePicAdapter walletOrderDetailSharePicAdapter = new WalletOrderDetailSharePicAdapter(this, this.f32250A.isTopupByDriver());
            this.f32280z = walletOrderDetailSharePicAdapter;
            this.f32279y.setAdapter(walletOrderDetailSharePicAdapter);
        }
        if (this.f32278x == null) {
            WalletOrderSharePicPresenter walletOrderSharePicPresenter = new WalletOrderSharePicPresenter(this, this.f32279y);
            walletOrderSharePicPresenter.setLoadingView(this);
            this.f32278x = walletOrderSharePicPresenter;
        }
        WalletOrderDetailSharePicAdapter walletOrderDetailSharePicAdapter2 = this.f32280z;
        if (walletOrderDetailSharePicAdapter2 != null) {
            walletOrderDetailSharePicAdapter2.setData(payResultData);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshUIData(WalletPayResultResp.PayResultData payResultData) {
        if (!this.f32252C) {
            this.f32255a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
        }
        this.mTvBtn.setEnabled(true);
        this.f32262h.setVisibility(0);
        if (payResultData != null) {
            if (payResultData.share) {
                m22904b();
            } else {
                this.f32270p.setVisibility(8);
            }
            this.f32274t.updateContent(payResultData.operationSection);
            WalletPayResultResp.RuleLimitDetailVo ruleLimitDetailVo = payResultData.ruleLimitDetail;
            if (ruleLimitDetailVo != null) {
                String str = ruleLimitDetailVo.text;
                final String str2 = ruleLimitDetailVo.link;
                this.f32269o.setText(TextHighlightUtil.highlight(str, Color.parseColor("#000000"), Color.parseColor("#FF8040")));
                this.f32269o.setOnClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        if (!TextUtils.isEmpty(str2)) {
                            DRouter.build(str2).start(WalletTopUpPayResultActivity.this);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("pub_page", "order_finish");
                        hashMap.put("pub_target", "text");
                        hashMap.put("pub_biz", "fintech");
                        hashMap.put("product_line", Integer.valueOf(WalletTopUpPayResultActivity.this.f32253D));
                        hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                        hashMap.put("button_name", "text");
                        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                        PayTracker.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
                    }
                });
                this.f32269o.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
                if (this.f32269o.getVisibility() == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "order_finish");
                    hashMap.put("pub_target", "text");
                    hashMap.put("pub_biz", "fintech");
                    hashMap.put("product_line", Integer.valueOf(this.f32253D));
                    hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                    hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                    PayTracker.trackEvent("ibt_fintech_passenger_text_sw", hashMap);
                }
            } else {
                this.f32269o.setText((CharSequence) null);
                this.f32269o.setVisibility(8);
                this.f32269o.setOnClickListener((View.OnClickListener) null);
            }
            boolean isTopupByDriver = this.f32250A.isTopupByDriver();
            int i = R.drawable.wallet_transfer_icon_failed;
            if (isTopupByDriver) {
                if (payResultData.status == 1) {
                    i = R.drawable.wallet_transfer_icon_success;
                } else if (payResultData.status == 0) {
                    i = R.drawable.wallet_transfer_icon_processing;
                }
                if (i != -1) {
                    this.f32263i.setVisibility(0);
                    this.f32263i.setImageResource(i);
                    this.f32266l.setPadding(0, 0, 0, 0);
                    this.f32265k.setPadding(0, 0, 0, 0);
                } else {
                    this.f32263i.setVisibility(8);
                    this.f32266l.setPadding(this.f32251B, 0, 0, 0);
                    this.f32265k.setPadding(this.f32251B, 0, 0, 0);
                }
            } else {
                if (payResultData.status == 1) {
                    showFlowerAnimation();
                    i = R.drawable.wallet_transfer_icon_success;
                } else if (payResultData.status == 0 || payResultData.status == 6) {
                    i = R.drawable.wallet_transfer_icon_processing;
                }
                this.f32263i.setImageResource(i);
            }
            this.f32266l.setText(payResultData.resultMainTitle);
            this.f32267m.setText(payResultData.amount);
            this.f32268n.setText(payResultData.currencySymbol);
            if (this.f32250A.isTopupByDriver()) {
                this.mTvBtn.setText(R.string.GRider_Riders_Send_it_fAPb);
            }
            if (payResultData.status == 0 && this.f32250A.isCancelableOrder()) {
                this.mTvBtn.setBackgroundResource(R.drawable.wallet_topup_order_detail_cancel_btn_selector);
                this.mTvBtn.setText(R.string.GRider_Riders_Cancel_this_zJFP);
                this.mTvBtn.setTextColor(ResourcesHelper.getColor(this, R.color.ggk_color_666666));
                this.f32273s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.f32272r.setVisibility(8);
            } else if (payResultData.status != 99 || !this.f32250A.isTopupByDriver()) {
                this.f32273s.setVisibility(8);
                this.mTvBtn.setVisibility(8);
            } else {
                try {
                    this.mTvBtn.setBackground(DidiThemeManager.getIns().getResPicker(this).getDrawable(R.attr.submit_btn_bg_selector));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mTvBtn.setText(R.string.GRider_Riders_Send_it_fAPb);
                this.f32273s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.f32272r.setVisibility(8);
            }
            m22896a(payResultData, false);
            m22914e(payResultData);
            m22912d(payResultData);
            m22909c(payResultData);
        }
    }

    /* renamed from: c */
    private void m22909c(final WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (payResultData.status == 6 && this.f32254E == 260) {
                this.f32273s.setVisibility(0);
                this.mTvBtn.setVisibility(0);
                this.mTvBtn.setText(getString(R.string.Fintech_Payment_optimization_Payment_iJVF));
                this.f32272r.setVisibility(0);
                this.f32272r.setOnClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("g_BizId", "Boleto");
                        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                        hashMap.put("button_name", "Cancel Payment");
                        PayTracker.trackEvent("fin_boleto_unpaidpage_btn_ck", hashMap);
                        WalletTopUpPayResultActivity.this.m22903a(payResultData.cancelTitle, payResultData.cancelSubTitle);
                    }
                });
                HashMap hashMap = new HashMap();
                hashMap.put("g_BizId", "Boleto");
                hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                PayTracker.trackEvent("fin_boleto_unpaidpage_sw", hashMap);
                return;
            }
            this.f32273s.setVisibility(8);
            this.mTvBtn.setVisibility(8);
            this.f32272r.setVisibility(8);
            m22893a(this.f32253D, this.f32254E, payResultData.status);
        }
    }

    /* renamed from: d */
    private void m22912d(WalletPayResultResp.PayResultData payResultData) {
        PayResultAdapter payResultAdapter = ((payResultData.status == 1 || payResultData.status == 2) && this.f32253D == 605) ? new PayResultAdapter() : null;
        if (payResultAdapter != null) {
            if (!payResultData.share) {
                payResultAdapter.onTitleBarUI();
            }
            payResultAdapter.onPageTitleUI();
            payResultAdapter.onTableViewUI();
            if (!this.f32250A.isTopupByDriver()) {
                payResultAdapter.onBottomBtnUI();
            }
        }
    }

    /* renamed from: b */
    private void m22904b() {
        this.f32270p.setVisibility(0);
        this.f32270p.setImageResource(R.drawable.wallet_topup_share_entrance_icon);
        this.f32270p.setOnClickListener(new FastCheckOnClickListener() {
            public void doClick(View view) {
                if (WalletTopUpPayResultActivity.this.f32278x != null) {
                    WalletTopUpPayResultActivity.this.f32278x.onShareClicked();
                }
            }
        });
        PayTracker.trackEvent("ibt_didipay_receipt_sharing_sw");
    }

    /* renamed from: e */
    private void m22914e(WalletPayResultResp.PayResultData payResultData) {
        if (payResultData != null) {
            if (!TextUtils.isEmpty(payResultData.resultSubTitle)) {
                this.f32271q.setVisibility(0);
                this.f32271q.setText(payResultData.resultSubTitle);
                if (!TextUtils.isEmpty(payResultData.subTitleColor)) {
                    this.f32271q.setTextColor(Color.parseColor(payResultData.subTitleColor));
                }
                if (!TextUtils.isEmpty(payResultData.subTitleBgColor)) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor(payResultData.subTitleBgColor));
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(getContext(), 16.0f));
                    this.f32271q.setBackground(gradientDrawable);
                }
            } else {
                this.f32271q.setVisibility(8);
            }
            if (!CollectionUtil.isEmpty((Collection) payResultData.rechargeStatement) && !CollectionUtil.isEmpty((Collection) payResultData.payeeStatement)) {
                this.f32264j.removeAllViews();
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f32264j, false);
                ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(payResultData.rechargeStatementTile);
                this.f32264j.addView(inflate);
                for (WalletPayResultResp.ItemModel next : payResultData.rechargeStatement) {
                    View inflate2 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f32264j, false);
                    TextView textView = (TextView) inflate2.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate2.findViewById(R.id.pay_result_item_title)).setText(next.title);
                    textView.setText(next.value);
                    if (next.color != null && !TextUtils.isEmpty(next.color)) {
                        textView.setTextColor(Color.parseColor(next.color));
                    }
                    if (next.isBold) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f32264j.addView(inflate2);
                }
                this.f32264j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f32264j, false));
                View inflate3 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f32264j, false);
                ((TextView) inflate3.findViewById(R.id.pay_result_item_content)).setText(payResultData.payeeStatementTitle);
                this.f32264j.addView(inflate3);
                for (WalletPayResultResp.ItemModel next2 : payResultData.payeeStatement) {
                    View inflate4 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f32264j, false);
                    TextView textView2 = (TextView) inflate4.findViewById(R.id.pay_result_item_content);
                    ((TextView) inflate4.findViewById(R.id.pay_result_item_title)).setText(next2.title);
                    textView2.setText(next2.value);
                    if (next2.color != null && !TextUtils.isEmpty(next2.color)) {
                        textView2.setTextColor(Color.parseColor(next2.color));
                    }
                    if (next2.isBold) {
                        textView2.setTypeface(Typeface.defaultFromStyle(1));
                    }
                    this.f32264j.addView(inflate4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22896a(final WalletPayResultResp.PayResultData payResultData, boolean z) {
        if (payResultData != null && !CollectionUtil.isEmpty((Collection) payResultData.statement)) {
            LinkedList<WalletPayResultResp.ItemModel> linkedList = new LinkedList<>(payResultData.statement);
            if (z && !CollectionUtil.isEmpty((Collection) payResultData.statementExtend)) {
                linkedList.addAll(payResultData.statementExtend);
            }
            this.f32264j.removeAllViews();
            this.f32264j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_detail_title_view, this.f32264j, false));
            for (WalletPayResultResp.ItemModel itemModel : linkedList) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_item_view, this.f32264j, false);
                TextView textView = (TextView) inflate.findViewById(R.id.pay_result_item_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.pay_result_item_content);
                textView.setText(itemModel.title);
                textView2.setText(itemModel.value);
                if (itemModel.color != null && !TextUtils.isEmpty(itemModel.color)) {
                    textView.setTextColor(Color.parseColor(itemModel.color));
                    textView2.setTextColor(Color.parseColor(itemModel.color));
                }
                this.f32264j.addView(inflate);
            }
            if (!z && !CollectionUtil.isEmpty((Collection) payResultData.statementExtend)) {
                PayTracker.trackEvent("ibt_didipay_full_receipt_sw");
                View inflate2 = LayoutInflater.from(this).inflate(R.layout.wallet_global_activity_topup_pay_result_extend_view, this.f32264j, false);
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        PayTracker.trackEvent("ibt_didipay_full_receipt_ck");
                        WalletTopUpPayResultActivity.this.m22896a(payResultData, true);
                    }
                });
                this.f32264j.addView(inflate2);
            }
            if (!CollectionUtil.isEmpty((Collection) payResultData.expirationReminder)) {
                this.f32264j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f32264j, false));
                for (String text : payResultData.expirationReminder) {
                    View inflate3 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_bottom_desc_text, this.f32264j, false);
                    ((TextView) inflate3.findViewById(R.id.desc_tv)).setText(text);
                    this.f32264j.addView(inflate3);
                }
            } else if (!TextUtils.isEmpty(payResultData.resultSubTitle)) {
                this.f32265k.setVisibility(8);
                this.f32264j.addView(LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f32264j, false));
                View inflate4 = LayoutInflater.from(this).inflate(R.layout.wallet_boleto_history_bottom_desc_text, this.f32264j, false);
                ((TextView) inflate4.findViewById(R.id.desc_tv)).setText(payResultData.resultSubTitle);
                this.f32264j.addView(inflate4);
            }
        }
    }

    public void onBackPressed() {
        if (this.f32250A != null) {
            if (!this.f32252C) {
                setResult(-1);
            }
            this.f32250A.handleBackClick();
        }
    }

    public void showFlowerAnimation() {
        if (this.f32261g == null) {
            new LottieTask(new Callable<LottieResult<LottieComposition>>() {
                public LottieResult<LottieComposition> call() {
                    return WalletTopUpPayResultActivity.this.m22908c();
                }
            }).addListener(new LottieListener<LottieComposition>() {
                public void onResult(LottieComposition lottieComposition) {
                    WalletTopUpPayResultActivity.this.m22894a(lottieComposition);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LottieResult<LottieComposition> m22908c() {
        try {
            return LottieCompositionFactory.fromJsonInputStreamSync(getAssets().open("installment_firework.json"), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22894a(LottieComposition lottieComposition) {
        try {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
            this.f32261g = lottieAnimationView;
            lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-1, UIUtil.dip2px(this, 800.0f)));
            this.f32261g.setComposition(lottieComposition);
            this.f32261g.playAnimation();
            this.f32275u.addView(this.f32261g);
            this.f32261g.addAnimatorListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    WalletTopUpPayResultActivity.this.m22911d();
                }

                public void onAnimationCancel(Animator animator) {
                    WalletTopUpPayResultActivity.this.m22911d();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22911d() {
        try {
            if (this.f32261g != null) {
                if (this.f32261g.getParent() == null) {
                    this.f32261g = null;
                    return;
                }
                this.f32261g.removeAllAnimatorListeners();
                ((ViewGroup) this.f32261g.getParent()).removeView(this.f32261g);
                this.f32261g = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1 && this.f32250A != null) {
                this.f32252C = false;
                this.f32255a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
                this.f32250A.startPollingStatus();
            }
        } else if (i == 200 && intent.getIntExtra("code", 3) == 1 && this.f32250A != null) {
            this.f32252C = false;
            this.f32255a.setImageDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_global_paymethod_adddialog_close));
            this.f32250A.startPollingStatus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22903a(String str, String str2) {
        if (str == null) {
            str = getString(R.string.GRider_reminder_Are_you_tLEI);
        }
        if (str2 == null) {
            str2 = "";
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wallet_dialog_extended_rich_title_view, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.wallet_extended_dialog_subtitle);
        NViewUtils.INSTANCE.setText2HighLight((TextView) inflate.findViewById(R.id.wallet_extended_dialog_title), str, Color.parseColor("#000000"), Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        textView.setVisibility(0);
        textView.setText(str2);
        C1129612 r9 = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(getContext().getString(R.string.Wallet_App_Onboarding_Confirmation_NpIr), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpPayResultActivity.this.f32276v != null && WalletTopUpPayResultActivity.this.f32276v.isShowing()) {
                    WalletTopUpPayResultActivity.this.f32276v.dismiss();
                    if (WalletTopUpPayResultActivity.this.f32250A != null) {
                        WalletTopUpPayResultActivity.this.m22902a("Confirm");
                        WalletTopUpPayResultActivity.this.f32250A.onCancelBtnClick();
                    }
                }
            }
        })) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                lEGODrawerModel.isTwoBtnHorizontal = true;
                return lEGODrawerModel;
            }
        };
        r9.setExtendedView(inflate);
        r9.addMinorBtn(new LEGOBtnTextAndCallback(getContext().getString(R.string.Wallet_App_window_Not_now_fzRN), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (WalletTopUpPayResultActivity.this.f32276v != null && WalletTopUpPayResultActivity.this.f32276v.isShowing()) {
                    WalletTopUpPayResultActivity.this.m22902a("Not Now");
                    WalletTopUpPayResultActivity.this.f32276v.dismiss();
                }
            }
        }));
        this.f32276v = LEGOUICreator.showDrawerTemplate(this, r9);
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        PayTracker.trackEvent("fin_boleto_cancel_popup_sw", hashMap);
    }

    class PayResultAdapter implements IPayResultUI {
        public void onBottomBtnUI() {
        }

        public void onPageTitleUI() {
        }

        public void onTableViewUI() {
        }

        PayResultAdapter() {
        }

        public void onTitleBarUI() {
            WalletTopUpPayResultActivity.this.f32256b.setText(R.string.cs_history_list_page_title);
            WalletTopUpPayResultActivity.this.f32256b.setVisibility(0);
            WalletTopUpPayResultActivity.this.f32256b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletTopupHistoryActivity.startActivity((Context) WalletTopUpPayResultActivity.this, 605);
                }
            });
        }
    }

    /* renamed from: a */
    private void m22893a(int i, int i2, int i3) {
        String str = i2 == 256 ? HistoryRecordConstant.VAMOS_HISTORY : "trans_page";
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("product_line", Integer.toString(i));
        hashMap.put("wallet_trans_result", Integer.toString(i3));
        hashMap.put("pub_from_page", str);
        PayTracker.trackEvent("fin_transresult_sw", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22902a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        hashMap.put("button_name", str);
        PayTracker.trackEvent("fin_boleto_cancel_popup_ck", hashMap);
    }
}

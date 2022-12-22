package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.Utils;
import com.didi.unifiedPay.component.manager.PayMethodManager;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.widget.CardTitleView;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.didi.unifiedPay.component.widget.LoadingStateView;
import com.didi.unifiedPay.component.widget.PayMethodView;
import com.didi.unifiedPay.component.widget.PayRootLinearLayout;
import com.didi.unifiedPay.component.widget.PlatformPayView;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.component.widget.ToastView;
import com.didi.unifiedPay.util.HighlightUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import java.util.ArrayList;
import java.util.List;

public class PaymentView extends FrameLayout implements View.OnClickListener, IPayView {

    /* renamed from: A */
    private static final int f44396A = 50;

    /* renamed from: B */
    private static final int f44397B = 29;

    /* renamed from: x */
    private static final String f44398x = "PaymentView";

    /* renamed from: y */
    private static final int f44399y = 20;

    /* renamed from: z */
    private static final int f44400z = 10;

    /* renamed from: C */
    private TotalPayAreaView f44401C;

    /* renamed from: D */
    private TextView f44402D;

    /* renamed from: a */
    private Context f44403a;

    /* renamed from: b */
    private CardTitleView f44404b;

    /* renamed from: c */
    private TextView f44405c;

    /* renamed from: d */
    private LinearLayout f44406d;

    /* renamed from: e */
    private TextView f44407e;

    /* renamed from: f */
    private TextView f44408f;

    /* renamed from: g */
    private LinearLayout f44409g;

    /* renamed from: h */
    private LinearLayout f44410h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PlatformPayView f44411i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PayMethodView f44412j;

    /* renamed from: k */
    private TextView f44413k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f44414l;

    /* renamed from: m */
    private TextView f44415m;
    protected IPayView.PayViewListener mListener;
    protected View mView;

    /* renamed from: n */
    private ImageView f44416n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ScrollView f44417o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LinearLayout f44418p;
    protected LinearLayout payBizViewLayout;
    protected boolean payBtnClicked;
    protected FrameLayout payStateLayout;

    /* renamed from: q */
    private List<PlatformPayItem> f44419q;

    /* renamed from: r */
    private int f44420r;
    protected PayRootLinearLayout rootGroupView;

    /* renamed from: s */
    private List f44421s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f44422t;

    /* renamed from: u */
    private ViewTreeObserver.OnGlobalLayoutListener f44423u;

    /* renamed from: v */
    private PayBizType f44424v;

    /* renamed from: w */
    private IPayManager f44425w;

    /* access modifiers changed from: protected */
    public int getPayDisableResourceId() {
        return R.drawable.oc_button_normal_shape;
    }

    /* access modifiers changed from: protected */
    public int getPayResourceId() {
        return R.drawable.oc_button_selector;
    }

    public View getView() {
        return this;
    }

    public void setCrossFeeWithUnit(String str) {
    }

    public PaymentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44403a = context;
        this.f44424v = PayBizType.BIZ_TRIP;
        loadView();
        initView();
    }

    /* access modifiers changed from: protected */
    public void loadView() {
        this.mView = LayoutInflater.from(getContext()).inflate(R.layout.oc_unified_pay_layout, this);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f44425w = new TripPayManager(this.f44403a, this);
        m31544b();
        this.rootGroupView = (PayRootLinearLayout) findViewById(R.id.oc_pay_root);
        this.payBizViewLayout = (LinearLayout) findViewById(R.id.oc_ll_pay_biz_view);
        this.payStateLayout = (FrameLayout) findViewById(R.id.oc_fl_pay_state);
        this.f44405c = (TextView) findViewById(R.id.oc_tv_pay_type_info);
        this.f44401C = (TotalPayAreaView) findViewById(R.id.oc_pay_totalpayview);
        m31535a();
        this.f44409g = (LinearLayout) findViewById(R.id.oc_pay_supplement_container);
        this.f44417o = (ScrollView) findViewById(R.id.oc_sv_pay_list);
        this.f44410h = (LinearLayout) findViewById(R.id.oc_ll_platform_pay);
        this.f44411i = (PlatformPayView) findViewById(R.id.oc_lv_platform_pay);
        this.f44412j = (PayMethodView) findViewById(R.id.oc_paymethod_view);
        this.f44402D = (TextView) findViewById(R.id.oc_tv_pay_marketing);
        TextView textView = (TextView) findViewById(R.id.oc_tv_more_pay_item);
        this.f44413k = textView;
        textView.setContentDescription(this.f44413k.getText() + getResources().getString(R.string.oc_voice_button));
        this.f44418p = (LinearLayout) findViewById(R.id.oc_ll_pay_area);
        this.f44414l = (TextView) findViewById(R.id.oc_tv_pay_statement);
        ImageView imageView = (ImageView) findViewById(R.id.oc_btn_pay_loading);
        this.f44416n = imageView;
        imageView.setBackgroundResource(getPayResourceId());
        this.f44415m = (TextView) findViewById(R.id.oc_btn_pay);
        this.f44415m.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        this.f44415m.setTextColor(getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        this.f44415m.setOnClickListener(this);
        this.f44413k.setOnClickListener(this);
        m31549d();
        m31536a(this.f44417o, this.f44418p, this.f44414l.getVisibility() == 0);
    }

    /* renamed from: a */
    private void m31535a() {
        this.f44406d = (LinearLayout) findViewById(R.id.oc_pay_total_fee_container);
        View inflate = LayoutInflater.from(this.f44403a).inflate(R.layout.gua_oc_unified_pay_include_pay_total_fee, this.f44406d, false);
        this.f44407e = (TextView) inflate.findViewById(R.id.oc_tv_pay_toal_fee);
        this.f44408f = (TextView) inflate.findViewById(R.id.oc_tv_pay_total_fee_more);
        this.f44406d.addView(inflate);
    }

    /* renamed from: b */
    private void m31544b() {
        this.f44404b = (CardTitleView) this.mView.findViewById(R.id.oc_include_pay_title);
    }

    public void setMarketing(String str, View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f44402D.setVisibility(8);
            return;
        }
        this.f44402D.setVisibility(0);
        this.f44402D.setText(HighlightUtil.highlight(str));
        this.f44402D.setOnClickListener(onClickListener);
    }

    public void setCardPaddingTop(int i) {
        this.rootGroupView.setPadding(0, i, 0, 0);
    }

    public void setBizType(PayBizType payBizType) {
        if (this.f44424v != payBizType) {
            if (payBizType == PayBizType.BIZ_NON_TRIP) {
                this.f44425w = new NonTripPayManager(this.f44403a, this);
            } else if (payBizType == PayBizType.BIZ_TRIP) {
                this.f44425w = new TripPayManager(this.f44403a, this);
            }
            this.f44424v = payBizType;
        }
    }

    public void setCradTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f44404b.setTitle(str);
        }
    }

    public void refreshTotalPayArea(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            this.f44401C.setVisibility(8);
            return;
        }
        this.f44401C.setVisibility(0);
        this.f44401C.refresh(str, str2, str3);
    }

    public void setPayTypeInfo(CharSequence charSequence) {
        if (UnipayTextUtil.isEmpty(charSequence)) {
            this.f44405c.setVisibility(8);
            return;
        }
        this.f44405c.setText(charSequence);
        this.f44405c.setVisibility(0);
    }

    public void setPayTypeInfo(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.f44405c.setVisibility(8);
            return;
        }
        this.f44405c.setText(str);
        this.f44405c.setVisibility(0);
    }

    public void setDisplayFee(String str) {
        setDisplayFeeWithUnit(this.f44403a.getString(R.string.oc_pay_total_str) + this.f44403a.getString(R.string.oc_pay_total_fee_str, new Object[]{str}));
    }

    public void setDisplayFeeWithUnit(String str) {
        UnipayTextUtil unipayTextUtil = new UnipayTextUtil(str);
        unipayTextUtil.spanNumSize(3.0f);
        this.f44407e.setText(unipayTextUtil);
    }

    public void setJumpableItem(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            showFeeDetailEntraView(false);
            return;
        }
        this.f44408f.setText(str);
        showFeeDetailEntraView(true);
    }

    public void setVoucherDeductible(double d) {
        if (d > 0.0d) {
            String string = getResources().getString(R.string.oc_pay_voucher_deduction_str);
            Resources resources = getResources();
            setVoucherView(new VoucherViewConfig(string, resources.getString(R.string.oc_uni_pay_voucher_deduction_value, new Object[]{"" + d}), true));
            return;
        }
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, false);
    }

    public void setVoucherView(VoucherViewConfig voucherViewConfig) {
        removeDeductionItem(DeductionItemType.TYPE_VOUCHER);
        voucherViewConfig.deductionType = DeductionItemType.TYPE_VOUCHER;
        addDeductionItem(voucherViewConfig);
    }

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
        if (voucherViewConfig != null) {
            View inflate = LayoutInflater.from(this.f44403a).inflate(R.layout.oc_unified_pay_supply_item, this.f44409g, false);
            inflate.setTag(voucherViewConfig);
            TextView textView = (TextView) inflate.findViewById(R.id.oc_tv_voucher_left);
            textView.setText(voucherViewConfig.leftDes);
            TextView textView2 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_desc);
            if (TextUtils.isEmpty(voucherViewConfig.desc)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(Const.jaLeft + voucherViewConfig.desc + Const.jaRight);
            }
            TextView textView3 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_mount);
            textView3.setText(voucherViewConfig.rightDes);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.oc_iv_pay_voucher_icon);
            if (voucherViewConfig.showOrangeText) {
                textView.setTextColor(getResources().getColor(R.color.oc_color_FC9153));
                textView3.setTextColor(getResources().getColor(R.color.oc_color_FC9153));
                imageView.setImageResource(R.mipmap.pay_icon_right_oringe);
            } else {
                textView.setTextColor(getResources().getColor(R.color.oc_color_333333));
                textView3.setTextColor(getResources().getColor(R.color.oc_color_999999));
                imageView.setImageResource(R.drawable.pay_icon_right_grey);
            }
            if (voucherViewConfig.showRightIcon) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (voucherViewConfig.canClick) {
                inflate.setOnClickListener(this);
                inflate.setBackgroundDrawable(this.f44403a.getResources().getDrawable(R.drawable.oc_view_selector));
            } else {
                inflate.setOnClickListener((View.OnClickListener) null);
                inflate.setBackgroundDrawable((Drawable) null);
            }
            this.f44409g.addView(inflate);
            if (this.f44409g.getVisibility() != 0) {
                this.f44409g.setVisibility(0);
            }
        }
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
        if (list != null && list.size() >= 1) {
            removeAllDeductions();
            for (int i = 0; i < list.size(); i++) {
                addDeductionItem(list.get(i));
            }
        }
    }

    public void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z) {
        if (this.f44409g.getChildCount() > 0) {
            for (int i = 0; i < this.f44409g.getChildCount(); i++) {
                View childAt = this.f44409g.getChildAt(i);
                if (childAt.getTag() == deductionItemType) {
                    childAt.setVisibility(z ? 0 : 8);
                    if (z) {
                        this.f44409g.setVisibility(0);
                    }
                }
            }
        }
        if (!z && m31542a((ViewGroup) this.f44409g)) {
            this.f44409g.setVisibility(8);
        }
    }

    public void showOrHideDeductions(boolean z) {
        if (z) {
            this.f44409g.setVisibility(0);
            if (this.f44409g.getVisibility() != 0) {
                this.f44409g.setVisibility(0);
                return;
            }
            return;
        }
        this.f44409g.setVisibility(8);
    }

    public void removeAllDeductions() {
        if (this.f44409g.getChildCount() > 0) {
            this.f44409g.removeAllViews();
        }
        this.f44409g.setVisibility(8);
    }

    public void removeDeductionItem(DeductionItemType deductionItemType) {
        if (this.f44409g.getChildCount() > 0) {
            for (int i = 0; i < this.f44409g.getChildCount(); i++) {
                if (this.f44409g.getChildAt(i).getTag() == deductionItemType) {
                    this.f44409g.removeViewAt(i);
                }
            }
        }
    }

    public void showVoucherView(boolean z) {
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, z);
    }

    public void updatePlatformPayView(List<PlatformPayItem> list) {
        updatePlatformPayView(list, false);
    }

    public void updatePlatformPayView(List<PlatformPayItem> list, boolean z) {
        this.f44419q = list;
        if (list == null || list.size() < 1) {
            this.f44410h.setVisibility(8);
            return;
        }
        this.payBtnClicked = false;
        LogUtil.m31684d(f44398x, "updatePlatformPayView platformPayItems:" + list);
        m31549d();
        m31539a(list);
        this.f44411i.setData(list, z);
        this.f44411i.setOnSelectListener(new PlatformPayView.OnselectListener() {
            public void onItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2) {
                if (PaymentView.this.f44411i.hasLoadingStateItem()) {
                    PaymentView.this.m31545b(false);
                }
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onPlatformItemSelectChange(i, z, platformPayItem, z2);
                }
            }

            public void itemClicked(int i, PlatformPayItem platformPayItem) {
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.itemClicked(i, platformPayItem);
                }
            }
        });
        this.f44410h.setVisibility(0);
    }

    /* renamed from: a */
    private void m31539a(List<PlatformPayItem> list) {
        if (this.f44421s == null) {
            this.f44421s = new ArrayList();
            for (PlatformPayItem next : list) {
                if (!next.canSelect) {
                    this.f44421s.add(Integer.valueOf(next.channelId));
                } else if (next.selected) {
                    this.f44421s.add(Integer.valueOf(next.channelId));
                }
            }
        }
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i) {
        updateThirdPartPayView(list, i, false);
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        if (list == null || list.size() < 1 || list.size() <= i) {
            this.f44412j.setVisibility(8);
            return;
        }
        this.payBtnClicked = false;
        LogUtil.m31684d(f44398x, "updateThirdPartPayView payChannelItems:" + list);
        if (this.f44420r <= 0 && i >= 0) {
            this.f44420r = list.get(i).channelId;
        }
        m31549d();
        this.f44412j.setData(list, z, false);
        if (z) {
            this.f44412j.onItemClick(i, true);
            this.f44412j.setSelection(i);
        } else {
            this.f44412j.onItemClick(i, true);
        }
        this.f44412j.setVisibility(0);
        m31540a(this.f44412j.hasHidePayItem());
        this.f44412j.setOnSelectionListener(new SingleSelectionListView.OnSelectListener() {
            public void onSelect(int i, Object obj) {
                if (PaymentView.this.f44412j.hasLoadingStateItem()) {
                    PaymentView.this.m31545b(false);
                }
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onPayItemSelected(i, payChannelItem);
                }
            }

            public void unSelect(int i, Object obj) {
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.unSelectThirdPartItem(i, payChannelItem);
                }
            }

            public void itemClicked(int i, PayChannelItem payChannelItem) {
                PaymentView.this.mListener.onThirdPartPayItemClicked(i, payChannelItem);
            }
        });
    }

    public void setChangePayItemResult(boolean z) {
        PayMethodView payMethodView = this.f44412j;
        if (payMethodView != null && payMethodView.hasLoadingStateItem()) {
            this.f44412j.setBlockChangeResult(z);
        }
        PlatformPayView platformPayView = this.f44411i;
        if (platformPayView != null && platformPayView.hasLoadingStateItem()) {
            this.f44411i.setBlockChangeResult(z);
        }
        m31545b(true);
    }

    public void setThirdPartPayChangeMode(boolean z) {
        this.f44412j.setItemChangeMode(z);
    }

    public void setCancelableForThirdPay(boolean z) {
        this.f44412j.setCancelable(z);
    }

    /* renamed from: a */
    private void m31540a(boolean z) {
        if (z) {
            this.f44413k.setVisibility(0);
        } else {
            this.f44413k.setVisibility(8);
        }
    }

    public void selectedPayItem(PayChannelItem payChannelItem) {
        this.f44412j.onItemClick(payChannelItem);
    }

    public void setPayStatement(String str) {
        m31549d();
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f44414l.setText(str);
            this.f44414l.setVisibility(0);
            return;
        }
        this.f44414l.setVisibility(8);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f44415m.setText(str);
        }
    }

    public boolean isPayItemsExpand() {
        return this.f44412j.getChildCount() > 0 && this.f44413k.getVisibility() == 8;
    }

    public void showFeeDetailEntraView(boolean z) {
        if (z) {
            this.f44408f.setVisibility(0);
            this.f44406d.setOnClickListener(this);
            return;
        }
        this.f44408f.setVisibility(8);
        this.f44406d.setOnClickListener((View.OnClickListener) null);
    }

    public PayTypes getPayMethodTypes() {
        PayTypes payTypes = new PayTypes();
        PayChannelItem selection = this.f44412j.getSelection();
        if (selection != null) {
            payTypes.thirdPartPayType = selection.channelId;
        }
        payTypes.canUseEntraprisepay = this.f44411i.canUseEntraprisePay();
        payTypes.platformPayType = this.f44411i.isDDCreditSected() ? 161 : 0;
        return payTypes;
    }

    public void setCloseIconEnable(boolean z) {
        this.f44404b.setClosable(z);
    }

    public boolean isCloseIconEnable() {
        return this.f44404b.isCloseAble();
    }

    public void setListener(IPayView.PayViewListener payViewListener) {
        this.mListener = payViewListener;
        this.f44404b.setCloseIconListener(new CardTitleView.CardTitleCloseBtnListener() {
            public void onCloseBtnClick() {
                if (PaymentView.this.mListener != null) {
                    PaymentView.this.mListener.onCloseBtnClick();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31545b(boolean z) {
        if (z) {
            this.f44415m.setBackgroundResource(getPayResourceId());
            this.f44415m.setEnabled(true);
            this.f44412j.setItemEnable(true);
            this.f44411i.setItemEnable(true);
            return;
        }
        this.f44415m.setBackgroundResource(getPayDisableResourceId());
        this.f44415m.setEnabled(false);
        this.f44412j.setItemEnable(false);
        this.f44411i.setItemEnable(false);
    }

    public void showQueryPayResultView(boolean z, LoadingState loadingState, int i) {
        this.f44425w.showQueryPayResultView(z);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showLoadingView(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            r0 = 8
            r1 = 0
            if (r6 == 0) goto L_0x0041
            r6 = 0
            android.widget.FrameLayout r2 = r4.payStateLayout
            int r2 = r2.getChildCount()
            if (r2 <= 0) goto L_0x001d
            android.widget.FrameLayout r2 = r4.payStateLayout
            android.view.View r2 = r2.getChildAt(r1)
            boolean r3 = r2 instanceof com.didi.unifiedPay.component.widget.LoadingStateView
            if (r3 == 0) goto L_0x001d
            r6 = r2
            com.didi.unifiedPay.component.widget.LoadingStateView r6 = (com.didi.unifiedPay.component.widget.LoadingStateView) r6
            r2 = 1
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r6 != 0) goto L_0x0029
            com.didi.unifiedPay.component.widget.LoadingStateView r6 = new com.didi.unifiedPay.component.widget.LoadingStateView
            android.content.Context r3 = r4.getContext()
            r6.<init>(r3)
        L_0x0029:
            com.didi.unifiedPay.component.widget.LoadingStateView$State r3 = com.didi.unifiedPay.component.widget.LoadingStateView.State.LOADING_STATE
            r6.changeState(r3)
            r6.setText((java.lang.String) r5)
            if (r2 != 0) goto L_0x0050
            r4.showPayStateView(r6)
            android.widget.LinearLayout r5 = r4.payBizViewLayout
            r5.setVisibility(r0)
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.setVisibility(r1)
            goto L_0x0050
        L_0x0041:
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.removeAllViews()
            android.widget.FrameLayout r5 = r4.payStateLayout
            r5.setVisibility(r0)
            android.widget.LinearLayout r5 = r4.payBizViewLayout
            r5.setVisibility(r1)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.component.view.PaymentView.showLoadingView(java.lang.String, boolean):void");
    }

    public void showSuccessOnPayBtn() {
        if (!this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(true);
        }
        setPayBtnState(PayBtnState.ENABLE);
        setPayBtnText(getResources().getString(R.string.oc_pay_success_string));
    }

    public boolean isShowSuccessOnBtn() {
        return getResources().getString(R.string.oc_pay_success_string).equals(this.f44415m.getText());
    }

    public void showSuccessView(boolean z) {
        this.f44425w.showSuccessView(z, this.f44403a.getString(R.string.oc_pay_success_state_string));
    }

    public void showSuccessView(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f44403a.getResources().getString(R.string.oc_pay_success_state_string);
        }
        this.f44425w.showSuccessView(z, str);
    }

    public void showToastView(final ToastView.Config config) {
        ToastView toastView = new ToastView(getContext());
        toastView.setListener(new ToastView.DismissListener() {
            public void onDismiss() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onDismiss();
                }
            }
        });
        toastView.setupView(config);
        showPayStateView(toastView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
    }

    public void showErrorView(final FailStateView.Config config) {
        FailStateView failStateView = new FailStateView(getContext());
        failStateView.setupView(config);
        failStateView.setTag(new PayErrorEvent(config.errorCode, config.message));
        failStateView.setFailViewClickListener(new FailStateView.ClickListener() {
            public void onCancel() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onCancel();
                }
            }

            public void onConfirm() {
                PaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onConfirm();
                }
            }
        });
        showPayStateView(failStateView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
        resetViewClickable();
    }

    public PayErrorEvent isShowErrorView() {
        View childAt;
        if (this.payBizViewLayout.getVisibility() != 8 || this.payStateLayout.getVisibility() != 0 || (childAt = this.payStateLayout.getChildAt(0)) == null || !(childAt.getTag() instanceof PayErrorEvent)) {
            return null;
        }
        return (PayErrorEvent) childAt.getTag();
    }

    /* access modifiers changed from: protected */
    public boolean isShowLoadingStateView() {
        if (this.payStateLayout.getChildCount() <= 0 || !(this.payStateLayout.getChildAt(0) instanceof LoadingStateView)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void showBizViewLayout() {
        this.payStateLayout.setVisibility(8);
        this.payBizViewLayout.setVisibility(0);
        resetViewClickable();
    }

    /* access modifiers changed from: protected */
    public boolean isShowBizView() {
        return this.payBizViewLayout.getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void showPayStateView(View view) {
        this.payStateLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.payStateLayout.getLayoutParams();
        int payBizViewHeight = getPayBizViewHeight();
        if (payBizViewHeight > 0) {
            layoutParams.height = payBizViewHeight;
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            int dimension = (int) this.f44403a.getResources().getDimension(R.dimen.oc_pay_state_margin);
            layoutParams.setMargins(0, dimension, 0, dimension);
        }
        this.payStateLayout.addView(view);
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.f44416n.setVisibility(8);
            this.f44415m.setVisibility(0);
            this.f44415m.setEnabled(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.f44416n.setVisibility(8);
            this.f44415m.setVisibility(0);
            this.f44415m.setEnabled(false);
        } else if (payBtnState == PayBtnState.LOADING) {
            this.f44415m.setVisibility(8);
            this.f44416n.setVisibility(0);
            ((AnimationDrawable) this.f44416n.getDrawable()).start();
        }
    }

    public void resetViewClickable() {
        setPayBtnState(PayBtnState.ENABLE);
        setCloseIconEnable(true);
        if (this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(false);
        }
    }

    private int getPayBizViewHeight() {
        return this.payBizViewLayout.getHeight();
    }

    /* renamed from: a */
    private boolean m31542a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i).getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public String getPayMethod() {
        PayChannelItem selection;
        List<PlatformPayItem> list = this.f44419q;
        String str = "";
        if (list != null && list.size() > 0) {
            for (PlatformPayItem next : this.f44419q) {
                if (next != null) {
                    String payMethodFromType = PayMethodManager.getPayMethodFromType(next.channelId);
                    if (!UnipayTextUtil.isEmpty(payMethodFromType)) {
                        payMethodFromType = payMethodFromType + ",";
                    }
                    str = str + payMethodFromType;
                }
            }
        }
        PayMethodView payMethodView = this.f44412j;
        if (payMethodView == null || (selection = payMethodView.getSelection()) == null) {
            return str;
        }
        return str + PayMethodManager.getPayMethodFromType(selection.channelId);
    }

    public void removeThirdPartPay() {
        findViewById(R.id.oc_iv_pay_pay_line).setVisibility(8);
        this.f44412j.setVisibility(8);
        this.f44413k.setVisibility(8);
    }

    public void showThirdPartPay() {
        findViewById(R.id.oc_iv_pay_pay_line).setVisibility(0);
        this.f44412j.setVisibility(0);
        if (this.f44412j.hasHidePayItem()) {
            this.f44413k.setVisibility(0);
        }
    }

    public String getInitPayMethod() {
        List list = this.f44421s;
        String str = "";
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.f44421s.size(); i++) {
                Integer num = (Integer) this.f44421s.get(i);
                if (num != null) {
                    String payMethodFromType = PayMethodManager.getPayMethodFromType(num.intValue());
                    if (!UnipayTextUtil.isEmpty(payMethodFromType)) {
                        payMethodFromType = payMethodFromType + ",";
                    }
                    str = str + payMethodFromType;
                }
            }
        }
        if (this.f44420r <= 0) {
            return str;
        }
        return str + PayMethodManager.getPayMethodFromType(this.f44420r);
    }

    /* renamed from: c */
    private boolean m31548c() {
        return this.f44412j.hasLoadingStateItem() || this.f44411i.hasLoadingStateItem();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null && view != null && !Utils.isFastDoubleClick()) {
            if (view == this.f44406d) {
                this.mListener.onShowFeeDetailClick();
            } else if (view == this.f44413k) {
                m31540a(false);
                this.f44412j.showAllPayItem(!m31548c());
                this.mListener.onExpandAllThirdPayItemByUser();
            } else if (view == this.f44415m) {
                onPayBtnClick();
            } else if (m31541a(view)) {
                this.mListener.onDeductionItemClick((VoucherViewConfig) view.getTag());
            }
        }
    }

    public void onPayBtnClick() {
        this.f44425w.onPayBtnClick();
        this.payBtnClicked = true;
        this.mListener.onPayButtonClick();
    }

    /* renamed from: a */
    private boolean m31541a(View view) {
        if (view == null) {
            return false;
        }
        DeductionItemType deductionItemType = ((VoucherViewConfig) view.getTag()).deductionType;
        if (deductionItemType == DeductionItemType.TYPE_VOUCHER || deductionItemType == DeductionItemType.TYPE_SVIP || deductionItemType == DeductionItemType.REPLACE_ORDER_DEDUCTION || deductionItemType == DeductionItemType.MERCHANT_RIGHT_DEDUCTIO) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private void m31549d() {
        if (this.f44423u == null) {
            this.f44423u = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (PaymentView.this.f44417o != null) {
                        if (Build.VERSION.SDK_INT < 16) {
                            PaymentView.this.f44417o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            PaymentView.this.f44417o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        boolean z = false;
                        boolean z2 = PaymentView.this.f44417o.getMeasuredHeight() < PaymentView.this.f44417o.getChildAt(0).getHeight();
                        if (z2 != PaymentView.this.f44422t) {
                            LogUtil.m31684d(PaymentView.f44398x, " mIsScrollable:" + z2);
                            boolean unused = PaymentView.this.f44422t = z2;
                            PaymentView paymentView = PaymentView.this;
                            ScrollView c = paymentView.f44417o;
                            LinearLayout e = PaymentView.this.f44418p;
                            if (PaymentView.this.f44414l.getVisibility() == 0) {
                                z = true;
                            }
                            paymentView.m31536a(c, e, z);
                        }
                    }
                }
            };
        }
        this.f44417o.getViewTreeObserver().addOnGlobalLayoutListener(this.f44423u);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31536a(ScrollView scrollView, LinearLayout linearLayout, boolean z) {
        Context context;
        if (scrollView != null && linearLayout != null && (context = this.f44403a) != null) {
            int dip2pxInt = UIUtils.dip2pxInt(context, z ? 79.0f : 50.0f);
            int dip2pxInt2 = UIUtils.dip2pxInt(this.f44403a, 10.0f) + dip2pxInt;
            LogUtil.m31684d(f44398x, "reLayout payArea Height:" + dip2pxInt + " marginBttom:" + dip2pxInt2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) scrollView.getLayoutParams();
            if (this.f44422t) {
                layoutParams.setMargins(0, 0, 0, dip2pxInt2);
            } else {
                layoutParams.setMargins(0, 0, 0, UIUtils.dip2pxInt(this.f44403a, 20.0f) + dip2pxInt2);
            }
            scrollView.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, -dip2pxInt2, 0, 0);
            linearLayout.setLayoutParams(layoutParams2);
        }
    }
}

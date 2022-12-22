package global.didi.pay.merchant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.sdk.model.EventInfoModel;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PayStatusBasicBill;
import com.didi.unifiedPay.util.SimpleSpanStringBuilder;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.taxis99.R;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchant.processor.model.MerchantResponseFactory;
import global.didi.pay.merchantcore.model.DPayResponse;
import global.didi.pay.omega.GlobalPayOmegaManager;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\n\u0010*\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0015J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayStatusActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "mBtn", "Landroid/widget/Button;", "getMBtn", "()Landroid/widget/Button;", "setMBtn", "(Landroid/widget/Button;)V", "mContainer", "Landroid/view/ViewGroup;", "getMContainer", "()Landroid/view/ViewGroup;", "setMContainer", "(Landroid/view/ViewGroup;)V", "mCrossFee", "Landroid/widget/TextView;", "getMCrossFee", "()Landroid/widget/TextView;", "setMCrossFee", "(Landroid/widget/TextView;)V", "mFee", "getMFee", "setMFee", "mHeaderBg", "Landroid/view/View;", "getMHeaderBg", "()Landroid/view/View;", "setMHeaderBg", "(Landroid/view/View;)V", "mIconView", "Landroid/widget/ImageView;", "getMIconView", "()Landroid/widget/ImageView;", "setMIconView", "(Landroid/widget/ImageView;)V", "mOmegaManager", "Lglobal/didi/pay/omega/GlobalPayOmegaManager;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getOmegaManager", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "Companion", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUniPayStatusActivity.kt */
public final class GlobalMerchantUniPayStatusActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_OID = "oid";
    public Button mBtn;
    public ViewGroup mContainer;
    public TextView mCrossFee;
    public TextView mFee;
    public View mHeaderBg;
    public ImageView mIconView;
    private GlobalPayOmegaManager mOmegaManager;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUniPayStatusActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MerchantRequestType.values().length];
            iArr[MerchantRequestType.TYPE_MERCHANT_SDK.ordinal()] = 1;
            iArr[MerchantRequestType.TYPE_PC.ordinal()] = 2;
            iArr[MerchantRequestType.TYPE_H5.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final void startActivity(Activity activity, String str, MerchantRequestType merchantRequestType) {
        Companion.startActivity(activity, str, merchantRequestType);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lglobal/didi/pay/merchant/GlobalMerchantUniPayStatusActivity$Companion;", "", "()V", "PARAM_OID", "", "startActivity", "", "context", "Landroid/app/Activity;", "oid", "merchantType", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUniPayStatusActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void startActivity(Activity activity, String str, MerchantRequestType merchantRequestType) {
            Intrinsics.checkNotNullParameter(activity, "context");
            Intrinsics.checkNotNullParameter(str, "oid");
            Intrinsics.checkNotNullParameter(merchantRequestType, "merchantType");
            Intent intent = new Intent(activity, GlobalMerchantUniPayStatusActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(GlobalMerchantUniPayActivity.MERCHANT_REQUEST_TYPE, merchantRequestType);
            intent.putExtra("oid", str);
            Unit unit = Unit.INSTANCE;
            intent.putExtras(bundle);
            Unit unit2 = Unit.INSTANCE;
            activity.startActivity(intent);
        }
    }

    public final View getMHeaderBg() {
        View view = this.mHeaderBg;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHeaderBg");
        throw null;
    }

    public final void setMHeaderBg(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mHeaderBg = view;
    }

    public final ImageView getMIconView() {
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIconView");
        throw null;
    }

    public final void setMIconView(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mIconView = imageView;
    }

    public final TextView getMFee() {
        TextView textView = this.mFee;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFee");
        throw null;
    }

    public final void setMFee(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mFee = textView;
    }

    public final TextView getMCrossFee() {
        TextView textView = this.mCrossFee;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCrossFee");
        throw null;
    }

    public final void setMCrossFee(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mCrossFee = textView;
    }

    public final Button getMBtn() {
        Button button = this.mBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBtn");
        throw null;
    }

    public final void setMBtn(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.mBtn = button;
    }

    public final ViewGroup getMContainer() {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        throw null;
    }

    public final void setMContainer(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mContainer = viewGroup;
    }

    private final GlobalPayOmegaManager getOmegaManager() {
        if (this.mOmegaManager == null) {
            this.mOmegaManager = new GlobalPayOmegaManager();
        }
        return this.mOmegaManager;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PayStatusBasicBill payStatusBasicBill;
        List<PayStatusBasicBill.PayMethod> list;
        PayStatusBasicBill payStatusBasicBill2;
        PayStatusBasicBill payStatusBasicBill3;
        PayStatusBasicBill payStatusBasicBill4;
        String str;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_global_merchant_uni_pay_status);
        View findViewById = findViewById(R.id.oc_uni_view_header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.oc_uni_view_header)");
        setMHeaderBg(findViewById);
        View findViewById2 = findViewById(R.id.tv_unified_pay_status_fee);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_unified_pay_status_fee)");
        setMFee((TextView) findViewById2);
        View findViewById3 = findViewById(R.id.tv_unified_pay_cross_fee);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_unified_pay_cross_fee)");
        setMCrossFee((TextView) findViewById3);
        getMCrossFee().getPaint().setFlags(16);
        View findViewById4 = findViewById(R.id.ll_unified_pay_status_item_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ll_unified_pay_status_item_container)");
        setMContainer((ViewGroup) findViewById4);
        View findViewById5 = findViewById(R.id.btn_unified_pay_status);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.btn_unified_pay_status)");
        setMBtn((Button) findViewById5);
        View findViewById6 = findViewById(R.id.iv_unified_pay_status_bottom_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_unified_pay_status_bottom_logo)");
        setMIconView((ImageView) findViewById6);
        Context context = this;
        getMHeaderBg().setBackgroundResource(UnifiedPayThemeManager.Companion.getINS().getPayTheme(context).getMerchantStatusBg());
        getMIconView().setImageResource(UnifiedPayThemeManager.Companion.getINS().getPayTheme(context).getMerchantStatusIcon());
        Bundle extras = getIntent().getExtras();
        Serializable serializable = null;
        String string = extras == null ? null : extras.getString("oid");
        getMBtn().setBackgroundResource(UnifiedPayThemeManager.Companion.getINS().getPayTheme(context).getNewMainBtnBg());
        getMBtn().setTextColor(getResources().getColorStateList(UnifiedPayThemeManager.Companion.getINS().getPayTheme(context).getPayBtnTxtColor()));
        PayStatus payStatus = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayStatus(string);
        TextView mFee2 = getMFee();
        String str2 = "";
        if (!(payStatus == null || (payStatusBasicBill4 = payStatus.billBasic) == null || (str = payStatusBasicBill4.actualPayFeeDisplay) == null)) {
            str2 = str;
        }
        SimpleSpanStringBuilder simpleSpanStringBuilder = new SimpleSpanStringBuilder(str2);
        simpleSpanStringBuilder.spanNumSize(2.14f);
        Unit unit = Unit.INSTANCE;
        mFee2.setText(simpleSpanStringBuilder);
        getMCrossFee().setText((payStatus == null || (payStatusBasicBill3 = payStatus.billBasic) == null) ? null : payStatusBasicBill3.totalFeeDisplay);
        TextView mCrossFee2 = getMCrossFee();
        int i = 0;
        if (!((payStatus == null || (payStatusBasicBill2 = payStatus.billBasic) == null || !payStatusBasicBill2.showCrossFee()) ? false : true)) {
            i = 4;
        }
        mCrossFee2.setVisibility(i);
        if (!(payStatus == null || (payStatusBasicBill = payStatus.billBasic) == null || (list = payStatusBasicBill.paymentMethods) == null)) {
            for (PayStatusBasicBill.PayMethod payMethod : list) {
                GlobalMerchantUniPayStatusItemViewHolder newIns = GlobalMerchantUniPayStatusItemViewHolder.Companion.newIns(context, getMContainer());
                String str3 = payMethod.channelName;
                Intrinsics.checkNotNullExpressionValue(str3, "it.channelName");
                newIns.setTitle(str3);
                String str4 = payMethod.feeValueDisplay;
                Intrinsics.checkNotNullExpressionValue(str4, "it.feeValueDisplay");
                newIns.setPrice(str4, payMethod.preferentialChannel);
                newIns.setIcon(payMethod.icon);
            }
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            serializable = extras2.getSerializable(GlobalMerchantUniPayActivity.MERCHANT_REQUEST_TYPE);
        }
        if (serializable != null) {
            MerchantRequestType merchantRequestType = (MerchantRequestType) serializable;
            Button mBtn2 = getMBtn();
            int i2 = WhenMappings.$EnumSwitchMapping$0[merchantRequestType.ordinal()];
            int i3 = R.string.GRider_payment_Return_to_cFOA;
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = R.string.Wallet_App_payment_Finished_jAkV;
                } else if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            mBtn2.setText(i3);
            getMBtn().setOnClickListener(new View.OnClickListener(merchantRequestType, payStatus) {
                public final /* synthetic */ MerchantRequestType f$1;
                public final /* synthetic */ PayStatus f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    GlobalMerchantUniPayStatusActivity.m47653onCreate$lambda3(GlobalMerchantUniPayStatusActivity.this, this.f$1, this.f$2, view);
                }
            });
            GlobalPayOmegaManager omegaManager = getOmegaManager();
            if (omegaManager != null) {
                omegaManager.doOmegaForThirdStatusPageSW();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type global.didi.pay.merchant.processor.model.MerchantRequestType");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m47653onCreate$lambda3(GlobalMerchantUniPayStatusActivity globalMerchantUniPayStatusActivity, MerchantRequestType merchantRequestType, PayStatus payStatus, View view) {
        Intrinsics.checkNotNullParameter(globalMerchantUniPayStatusActivity, "this$0");
        Intrinsics.checkNotNullParameter(merchantRequestType, "$merchantType");
        globalMerchantUniPayStatusActivity.getMBtn().setEnabled(false);
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
        GlobalPayOmegaManager omegaManager = globalMerchantUniPayStatusActivity.getOmegaManager();
        if (omegaManager != null) {
            omegaManager.doOmegaForThirdStatusPageConfirmCK();
        }
        UiThreadHandler.postDelayed(new Runnable(merchantRequestType, payStatus) {
            public final /* synthetic */ MerchantRequestType f$1;
            public final /* synthetic */ PayStatus f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GlobalMerchantUniPayStatusActivity.m47654onCreate$lambda3$lambda2(GlobalMerchantUniPayStatusActivity.this, this.f$1, this.f$2);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3$lambda-2  reason: not valid java name */
    public static final void m47654onCreate$lambda3$lambda2(GlobalMerchantUniPayStatusActivity globalMerchantUniPayStatusActivity, MerchantRequestType merchantRequestType, PayStatus payStatus) {
        EventInfoModel eventInfoModel;
        Intrinsics.checkNotNullParameter(globalMerchantUniPayStatusActivity, "this$0");
        Intrinsics.checkNotNullParameter(merchantRequestType, "$merchantType");
        GlobalMerchantUnifiedPayProcessor globalMerchantUnifiedPayProcessor = GlobalMerchantUnifiedPayProcessor.INS;
        Context context = globalMerchantUniPayStatusActivity;
        MerchantResponseFactory.Companion companion = MerchantResponseFactory.Companion;
        DPayResponse success = DPayResponse.Companion.getSUCCESS();
        String str = null;
        if (!(payStatus == null || (eventInfoModel = payStatus.eventInfo) == null)) {
            str = eventInfoModel.getReturnUrl();
        }
        globalMerchantUnifiedPayProcessor.onHandleMerchantResponse(context, companion.getInstance(merchantRequestType, success, str));
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (UniPayParamUtil.getResourceConfigurationProxy() != null) {
            UniPayParamUtil.getResourceConfigurationProxy().updateConfiguration(context);
        }
    }
}

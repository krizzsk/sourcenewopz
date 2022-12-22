package com.didi.payment.pix.refund;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.widget.WCommonDataPicker;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixRefundExtrasResp;
import com.didi.payment.pix.net.response.PixRefundResultResp;
import com.didi.payment.pix.refund.p140vm.PixOrderRefundDetailVM;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020[2\u0006\u0010_\u001a\u00020\u0019H\u0016J\u0010\u0010`\u001a\u00020[2\u0006\u0010a\u001a\u00020:H\u0002J\u000e\u0010b\u001a\u00020[2\u0006\u0010c\u001a\u00020\rJ\u0012\u0010d\u001a\u00020[2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J&\u0010g\u001a\u0004\u0018\u00010\u00192\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010k\u001a\u00020lH\u0016J\u001a\u0010m\u001a\u00020[2\u0006\u0010_\u001a\u00020\u00192\b\u0010e\u001a\u0004\u0018\u00010fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\u001a\u0010B\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00100\"\u0004\bD\u00102R\u001a\u0010E\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001a\u0010H\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00100\"\u0004\bS\u00102R\u001a\u0010T\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00100\"\u0004\bV\u00102R\u001a\u0010W\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00100\"\u0004\bY\u00102¨\u0006n"}, mo175978d2 = {"Lcom/didi/payment/pix/refund/PixRefundEditFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/refund/vm/PixOrderRefundDetailVM;", "()V", "NFloatParser", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "getNFloatParser", "()Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "setNFloatParser", "(Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;)V", "contentView", "Landroid/view/ViewGroup;", "inputAmountValid", "", "getInputAmountValid", "()Z", "setInputAmountValid", "(Z)V", "mRefundOrderId", "", "getMRefundOrderId", "()Ljava/lang/String;", "setMRefundOrderId", "(Ljava/lang/String;)V", "payeeContianer", "Landroid/view/View;", "payeeEntry", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$SectionEntry;", "getPayeeEntry", "()Lcom/didi/payment/pix/net/response/PixOrderDetailResp$SectionEntry;", "setPayeeEntry", "(Lcom/didi/payment/pix/net/response/PixOrderDetailResp$SectionEntry;)V", "payeeHeadIconImg", "Landroid/widget/ImageView;", "getPayeeHeadIconImg", "()Landroid/widget/ImageView;", "setPayeeHeadIconImg", "(Landroid/widget/ImageView;)V", "payeeHeadIconTv", "Landroid/widget/TextView;", "refundAmountEt", "Landroidx/appcompat/widget/AppCompatEditText;", "getRefundAmountEt", "()Landroidx/appcompat/widget/AppCompatEditText;", "setRefundAmountEt", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "refundAmountLabel", "getRefundAmountLabel", "()Landroid/widget/TextView;", "setRefundAmountLabel", "(Landroid/widget/TextView;)V", "refundAvaliableLabel", "getRefundAvaliableLabel", "setRefundAvaliableLabel", "refundAvaliableValueTv", "getRefundAvaliableValueTv", "setRefundAvaliableValueTv", "refundExtrasList", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;", "getRefundExtrasList", "()Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;", "setRefundExtrasList", "(Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$RefundOptions;)V", "refundReasonLabel", "getRefundReasonLabel", "setRefundReasonLabel", "refundReasonValueTv", "getRefundReasonValueTv", "setRefundReasonValueTv", "refundTypeLabelTv", "getRefundTypeLabelTv", "setRefundTypeLabelTv", "refundTypeValueTv", "getRefundTypeValueTv", "setRefundTypeValueTv", "selectExtras", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$ReasonEntry;", "getSelectExtras", "()Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$ReasonEntry;", "setSelectExtras", "(Lcom/didi/payment/pix/net/response/PixRefundExtrasResp$ReasonEntry;)V", "submitBtn", "getSubmitBtn", "setSubmitBtn", "titleDescTv", "getTitleDescTv", "setTitleDescTv", "titleTv", "getTitleTv", "setTitleTv", "initCommonTitlebar", "", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "initPayeeHeader", "data", "invalidConfirmBtn", "inputValid", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onInflateLayout", "", "onViewCreated", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixRefundEditFragment.kt */
public final class PixRefundEditFragment extends AbsWBaseFragment<PixOrderRefundDetailVM> {

    /* renamed from: a */
    private View f31196a;

    /* renamed from: b */
    private ViewGroup f31197b;

    /* renamed from: c */
    private TextView f31198c;

    /* renamed from: d */
    private PixRefundExtrasResp.ReasonEntry f31199d;

    /* renamed from: e */
    private PixRefundExtrasResp.RefundOptions f31200e;

    /* renamed from: f */
    private String f31201f = "";

    /* renamed from: g */
    private NFloatInputHelper f31202g = new NFloatInputHelper();

    /* renamed from: h */
    private boolean f31203h = true;
    public PixOrderDetailResp.SectionEntry payeeEntry;
    public ImageView payeeHeadIconImg;
    public AppCompatEditText refundAmountEt;
    public TextView refundAmountLabel;
    public TextView refundAvaliableLabel;
    public TextView refundAvaliableValueTv;
    public TextView refundReasonLabel;
    public TextView refundReasonValueTv;
    public TextView refundTypeLabelTv;
    public TextView refundTypeValueTv;
    public TextView submitBtn;
    public TextView titleDescTv;
    public TextView titleTv;

    public int onInflateLayout() {
        return R.layout.fragment_pix_order_refund_edit;
    }

    public static final /* synthetic */ PixOrderRefundDetailVM access$getVm(PixRefundEditFragment pixRefundEditFragment) {
        return (PixOrderRefundDetailVM) pixRefundEditFragment.getVm();
    }

    public final PixRefundExtrasResp.ReasonEntry getSelectExtras() {
        return this.f31199d;
    }

    public final void setSelectExtras(PixRefundExtrasResp.ReasonEntry reasonEntry) {
        this.f31199d = reasonEntry;
    }

    public final TextView getSubmitBtn() {
        TextView textView = this.submitBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("submitBtn");
        return null;
    }

    public final void setSubmitBtn(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.submitBtn = textView;
    }

    public final TextView getTitleTv() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void setTitleTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    public final TextView getTitleDescTv() {
        TextView textView = this.titleDescTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleDescTv");
        return null;
    }

    public final void setTitleDescTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleDescTv = textView;
    }

    public final ImageView getPayeeHeadIconImg() {
        ImageView imageView = this.payeeHeadIconImg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payeeHeadIconImg");
        return null;
    }

    public final void setPayeeHeadIconImg(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.payeeHeadIconImg = imageView;
    }

    public final TextView getRefundAmountLabel() {
        TextView textView = this.refundAmountLabel;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundAmountLabel");
        return null;
    }

    public final void setRefundAmountLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundAmountLabel = textView;
    }

    public final AppCompatEditText getRefundAmountEt() {
        AppCompatEditText appCompatEditText = this.refundAmountEt;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundAmountEt");
        return null;
    }

    public final void setRefundAmountEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.refundAmountEt = appCompatEditText;
    }

    public final TextView getRefundReasonLabel() {
        TextView textView = this.refundReasonLabel;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundReasonLabel");
        return null;
    }

    public final void setRefundReasonLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundReasonLabel = textView;
    }

    public final TextView getRefundReasonValueTv() {
        TextView textView = this.refundReasonValueTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundReasonValueTv");
        return null;
    }

    public final void setRefundReasonValueTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundReasonValueTv = textView;
    }

    public final TextView getRefundTypeLabelTv() {
        TextView textView = this.refundTypeLabelTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundTypeLabelTv");
        return null;
    }

    public final void setRefundTypeLabelTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundTypeLabelTv = textView;
    }

    public final TextView getRefundTypeValueTv() {
        TextView textView = this.refundTypeValueTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundTypeValueTv");
        return null;
    }

    public final void setRefundTypeValueTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundTypeValueTv = textView;
    }

    public final TextView getRefundAvaliableLabel() {
        TextView textView = this.refundAvaliableLabel;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundAvaliableLabel");
        return null;
    }

    public final void setRefundAvaliableLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundAvaliableLabel = textView;
    }

    public final TextView getRefundAvaliableValueTv() {
        TextView textView = this.refundAvaliableValueTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundAvaliableValueTv");
        return null;
    }

    public final void setRefundAvaliableValueTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.refundAvaliableValueTv = textView;
    }

    public final PixRefundExtrasResp.RefundOptions getRefundExtrasList() {
        return this.f31200e;
    }

    public final void setRefundExtrasList(PixRefundExtrasResp.RefundOptions refundOptions) {
        this.f31200e = refundOptions;
    }

    public final PixOrderDetailResp.SectionEntry getPayeeEntry() {
        PixOrderDetailResp.SectionEntry sectionEntry = this.payeeEntry;
        if (sectionEntry != null) {
            return sectionEntry;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payeeEntry");
        return null;
    }

    public final void setPayeeEntry(PixOrderDetailResp.SectionEntry sectionEntry) {
        Intrinsics.checkNotNullParameter(sectionEntry, "<set-?>");
        this.payeeEntry = sectionEntry;
    }

    public final String getMRefundOrderId() {
        return this.f31201f;
    }

    public final void setMRefundOrderId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f31201f = str;
    }

    public final NFloatInputHelper getNFloatParser() {
        return this.f31202g;
    }

    public final void setNFloatParser(NFloatInputHelper nFloatInputHelper) {
        Intrinsics.checkNotNullParameter(nFloatInputHelper, "<set-?>");
        this.f31202g = nFloatInputHelper;
    }

    public final boolean getInputAmountValid() {
        return this.f31203h;
    }

    public final void setInputAmountValid(boolean z) {
        this.f31203h = z;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("payee_info");
            if (serializable != null) {
                setPayeeEntry((PixOrderDetailResp.SectionEntry) serializable);
            }
            String string = arguments.getString("order_id");
            if (string == null) {
                string = "";
            }
            setMRefundOrderId(string);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_refund_sw", "order_id", this.f31201f);
        ViewModel viewModel = new ViewModelProvider(this).get(PixOrderRefundDetailVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…fundDetailVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((PixOrderRefundDetailVM) getVm()).getExtrasRefundOptions().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixRefundEditFragment.m21955a(PixRefundEditFragment.this, (PixRefundExtrasResp.RefundOptions) obj);
            }
        });
        ((PixOrderRefundDetailVM) getVm()).getRefundDetails().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixRefundEditFragment.m21956a(PixRefundEditFragment.this, (PixRefundResultResp.OrderRefundDetails) obj);
            }
        });
        ((PixOrderRefundDetailVM) getVm()).loadData(this.f31201f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21955a(PixRefundEditFragment pixRefundEditFragment, PixRefundExtrasResp.RefundOptions refundOptions) {
        View view;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(pixRefundEditFragment, "this$0");
        if (refundOptions.valid()) {
            ViewGroup viewGroup2 = pixRefundEditFragment.f31197b;
            boolean z = true;
            if (!(viewGroup2 != null && viewGroup2.getVisibility() == 0) && (viewGroup = pixRefundEditFragment.f31197b) != null) {
                viewGroup.setVisibility(0);
            }
            View view2 = pixRefundEditFragment.f31196a;
            if (view2 == null || view2.getVisibility() != 0) {
                z = false;
            }
            if (!z && (view = pixRefundEditFragment.f31196a) != null) {
                view.setVisibility(0);
            }
            if (pixRefundEditFragment.getSubmitBtn().getVisibility() != 0) {
                pixRefundEditFragment.getSubmitBtn().setVisibility(0);
            }
            pixRefundEditFragment.setRefundExtrasList(refundOptions);
            PixRefundExtrasResp.RefundOptions refundExtrasList = pixRefundEditFragment.getRefundExtrasList();
            if (refundExtrasList != null) {
                pixRefundEditFragment.m21952a(refundExtrasList);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21956a(PixRefundEditFragment pixRefundEditFragment, PixRefundResultResp.OrderRefundDetails orderRefundDetails) {
        Intrinsics.checkNotNullParameter(pixRefundEditFragment, "this$0");
        if (orderRefundDetails != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("refund_result", orderRefundDetails);
            bundle.putString("order_id", pixRefundEditFragment.getMRefundOrderId());
            Editable text = pixRefundEditFragment.getRefundAmountEt().getText();
            bundle.putString("pix_refund_amount", text == null ? null : text.toString());
            pixRefundEditFragment.forwardNextPage(OrderRefundDetailFragment.class, bundle);
            EventBus.getDefault().post(new WalletRefreshDataEvent());
        }
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.getLeftImgView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixRefundEditFragment.m21954a(PixRefundEditFragment.this, view);
            }
        });
        commonTitleBar.setTitle((int) R.string.GRider_payment_Refund_CjZI);
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21954a(PixRefundEditFragment pixRefundEditFragment, View view) {
        Intrinsics.checkNotNullParameter(pixRefundEditFragment, "this$0");
        pixRefundEditFragment.backToPrePage();
    }

    /* renamed from: a */
    private final void m21952a(PixRefundExtrasResp.RefundOptions refundOptions) {
        if (TextUtils.isEmpty(refundOptions.getTitle())) {
            TextView titleTv2 = getTitleTv();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.GRider_payment_Refund_to_mrJQ);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRider_payment_Refund_to_mrJQ)");
            String format = String.format(string, Arrays.copyOf(new Object[]{refundOptions.getPayeeName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            titleTv2.setText(format);
        } else {
            getTitleTv().setText(refundOptions.getTitle());
        }
        getTitleDescTv().setText(refundOptions.getSubTitle());
        if (!TextUtils.isEmpty(refundOptions.getPayeeIconUrl())) {
            TextView textView = this.f31198c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            getPayeeHeadIconImg().setVisibility(0);
            GlideUtils.loadCircleImageWithDefaultImg(getActivity(), Uri.parse(refundOptions.getPayeeIconUrl()), R.drawable.pay_icon_contacts, getPayeeHeadIconImg());
        } else {
            getPayeeHeadIconImg().setVisibility(8);
            TextView textView2 = this.f31198c;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.f31198c;
            if (textView3 != null) {
                textView3.setText(refundOptions.getPayeeName().subSequence(0, 1));
            }
        }
        getRefundTypeValueTv().setText(new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").format(new Date()));
        String centToDollar = MathUtil.centToDollar(Double.valueOf((double) refundOptions.getUserAvailableAmount()));
        TextView refundAvaliableValueTv2 = getRefundAvaliableValueTv();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("R$ %s", Arrays.copyOf(new Object[]{centToDollar}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
        refundAvaliableValueTv2.setText(format2);
        getRefundTypeValueTv().setText(refundOptions.getTransferType());
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initContentView(view);
        this.f31197b = (ViewGroup) view.findViewById(R.id.refund_edit_pannel_ll);
        this.f31196a = view.findViewById(R.id.payee_header_view);
        View findViewById = view.findViewById(R.id.payment_to_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.payment_to_tv)");
        setTitleTv((TextView) findViewById);
        View findViewById2 = view.findViewById(R.id.payment_to_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.payment_to_desc_tv)");
        setTitleDescTv((TextView) findViewById2);
        View findViewById3 = view.findViewById(R.id.payee_head_icon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.payee_head_icon_img)");
        setPayeeHeadIconImg((ImageView) findViewById3);
        this.f31198c = (TextView) view.findViewById(R.id.payee_head_icon_tv);
        View findViewById4 = view.findViewById(R.id.refund_current_balance_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.refund_current_balance_tv)");
        setRefundAmountLabel((TextView) findViewById4);
        View findViewById5 = view.findViewById(R.id.refund_transfer_amount_et);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.refund_transfer_amount_et)");
        setRefundAmountEt((AppCompatEditText) findViewById5);
        getRefundAmountEt().addTextChangedListener(new PixRefundEditFragment$initContentView$1(this));
        getRefundAmountEt().setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, this.f31202g.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
        View findViewById6 = view.findViewById(R.id.refund_reason_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.refund_reason_title_tv)");
        setRefundReasonLabel((TextView) findViewById6);
        View findViewById7 = view.findViewById(R.id.refund_reason_title_value_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.r…nd_reason_title_value_tv)");
        setRefundReasonValueTv((TextView) findViewById7);
        getRefundReasonValueTv().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixRefundEditFragment.m21957b(PixRefundEditFragment.this, view);
            }
        });
        View findViewById8 = view.findViewById(R.id.refund_operate_type_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.refund_operate_type_tv)");
        setRefundTypeLabelTv((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.refund_operate_type_value_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.r…nd_operate_type_value_tv)");
        setRefundTypeValueTv((TextView) findViewById9);
        View findViewById10 = view.findViewById(R.id.refund_avaliable_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.refund_avaliable_title_tv)");
        setRefundAvaliableLabel((TextView) findViewById10);
        View findViewById11 = view.findViewById(R.id.refund_avaliable_title_value_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.r…avaliable_title_value_tv)");
        setRefundAvaliableValueTv((TextView) findViewById11);
        View findViewById12 = view.findViewById(R.id.comfirm_to_refund_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.comfirm_to_refund_btn_tv)");
        setSubmitBtn((TextView) findViewById12);
        getSubmitBtn().setOnClickListener(new PixRefundEditFragment$initContentView$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21957b(PixRefundEditFragment pixRefundEditFragment, View view) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(pixRefundEditFragment, "this$0");
        PixRefundExtrasResp.RefundOptions refundExtrasList = pixRefundEditFragment.getRefundExtrasList();
        if (refundExtrasList != null && !CollectionUtil.isEmpty((Collection<?>) refundExtrasList.getReasons())) {
            WCommonDataPicker wCommonDataPicker = new WCommonDataPicker();
            wCommonDataPicker.setTitle(pixRefundEditFragment.getString(R.string.GRider_payment_Refund_Reason_JKKP));
            List arrayList = new ArrayList();
            for (PixRefundExtrasResp.ReasonEntry next : refundExtrasList.getReasons()) {
                if (next.valid()) {
                    arrayList.add(next.getDesc());
                }
            }
            if (arrayList.size() > 0) {
                wCommonDataPicker.setWheelData(arrayList);
                wCommonDataPicker.setOnSelectListener(new SimpleWheelPopup.OnSelectListener(pixRefundEditFragment) {
                    public final /* synthetic */ PixRefundEditFragment f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSelect(int i, Object obj) {
                        PixRefundEditFragment.m21953a(PixRefundExtrasResp.RefundOptions.this, this.f$1, i, obj);
                    }
                });
                int i = -1;
                int size = refundExtrasList.getReasons().size() - 1;
                if (size >= 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        if (!refundExtrasList.getReasons().get(i2).isFocus()) {
                            i2 = -1;
                        }
                        if (i3 > size) {
                            break;
                        }
                        i2 = i3;
                    }
                    i = i2;
                }
                if (i >= 0) {
                    wCommonDataPicker.setInitialSelect(new int[]{i});
                }
                FragmentActivity activity = pixRefundEditFragment.getActivity();
                if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                    wCommonDataPicker.show(supportFragmentManager, "refund_reason_picker");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21953a(PixRefundExtrasResp.RefundOptions refundOptions, PixRefundEditFragment pixRefundEditFragment, int i, Object obj) {
        Intrinsics.checkNotNullParameter(refundOptions, "$it");
        Intrinsics.checkNotNullParameter(pixRefundEditFragment, "this$0");
        if (i >= 0 && i < refundOptions.getReasons().size()) {
            pixRefundEditFragment.setSelectExtras(refundOptions.getReasons().get(i));
            PixRefundExtrasResp.ReasonEntry selectExtras = pixRefundEditFragment.getSelectExtras();
            if (selectExtras != null) {
                pixRefundEditFragment.getRefundReasonValueTv().setText(!TextUtils.isEmpty(selectExtras.getDesc()) ? selectExtras.getDesc() : "");
                for (PixRefundExtrasResp.ReasonEntry next : refundOptions.getReasons()) {
                    next.setFocus(Intrinsics.areEqual((Object) next, (Object) pixRefundEditFragment.getSelectExtras()));
                }
                pixRefundEditFragment.invalidConfirmBtn(pixRefundEditFragment.getInputAmountValid());
            }
        }
    }

    public final void invalidConfirmBtn(boolean z) {
        boolean z2 = true;
        boolean z3 = (getRefundAmountEt().getText() == null || TextUtils.isEmpty(getRefundAmountEt().getText()) || this.f31199d == null) ? false : true;
        TextView submitBtn2 = getSubmitBtn();
        if (!z3 || !z) {
            z2 = false;
        }
        submitBtn2.setEnabled(z2);
    }
}

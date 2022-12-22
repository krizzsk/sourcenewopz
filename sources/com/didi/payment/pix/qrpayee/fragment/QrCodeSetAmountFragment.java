package com.didi.payment.pix.qrpayee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WCommonNoteEditText;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.payment.pix.qrpayee.QRPayeeMainActivity;
import com.didi.payment.pix.qrpayee.widget.AmountEditText;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/fragment/QrCodeSetAmountFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "()V", "amountEditText", "Lcom/didi/payment/pix/qrpayee/widget/AmountEditText;", "getAmountEditText", "()Lcom/didi/payment/pix/qrpayee/widget/AmountEditText;", "setAmountEditText", "(Lcom/didi/payment/pix/qrpayee/widget/AmountEditText;)V", "confirmBtn", "Landroid/widget/TextView;", "getConfirmBtn", "()Landroid/widget/TextView;", "setConfirmBtn", "(Landroid/widget/TextView;)V", "noteEditView", "Lcom/didi/payment/commonsdk/widget/WCommonNoteEditText;", "getNoteEditView", "()Lcom/didi/payment/commonsdk/widget/WCommonNoteEditText;", "setNoteEditView", "(Lcom/didi/payment/commonsdk/widget/WCommonNoteEditText;)V", "initCommonTitlebar", "", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "Landroid/view/View;", "initViewModels", "onInflateLayout", "", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QrCodeSetAmountFragment.kt */
public final class QrCodeSetAmountFragment extends AbsWBaseFragment<WBaseViewModel> {
    public AmountEditText amountEditText;
    public TextView confirmBtn;
    public WCommonNoteEditText noteEditView;

    public int onInflateLayout() {
        return R.layout.pix_qrcode_setamount_fragment;
    }

    public final AmountEditText getAmountEditText() {
        AmountEditText amountEditText2 = this.amountEditText;
        if (amountEditText2 != null) {
            return amountEditText2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("amountEditText");
        return null;
    }

    public final void setAmountEditText(AmountEditText amountEditText2) {
        Intrinsics.checkNotNullParameter(amountEditText2, "<set-?>");
        this.amountEditText = amountEditText2;
    }

    public final WCommonNoteEditText getNoteEditView() {
        WCommonNoteEditText wCommonNoteEditText = this.noteEditView;
        if (wCommonNoteEditText != null) {
            return wCommonNoteEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("noteEditView");
        return null;
    }

    public final void setNoteEditView(WCommonNoteEditText wCommonNoteEditText) {
        Intrinsics.checkNotNullParameter(wCommonNoteEditText, "<set-?>");
        this.noteEditView = wCommonNoteEditText;
    }

    public final TextView getConfirmBtn() {
        TextView textView = this.confirmBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        return null;
    }

    public final void setConfirmBtn(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.confirmBtn = textView;
    }

    public void initViewModels() {
        super.initViewModels();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_amount_sw", "pix_payee_key", arguments == null ? null : arguments.getString("pix_payee_key"));
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initContentView(view);
        View findViewById = view.findViewById(R.id.receive_amount_aet);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.receive_amount_aet)");
        setAmountEditText((AmountEditText) findViewById);
        AmountEditText amountEditText2 = getAmountEditText();
        String string = getString(R.string.GRider_payment_Enter_the_sYXn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRider_payment_Enter_the_sYXn)");
        amountEditText2.setLabelText(string);
        View findViewById2 = view.findViewById(R.id.note_edit_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.note_edit_view)");
        setNoteEditView((WCommonNoteEditText) findViewById2);
        WCommonNoteEditText noteEditView2 = getNoteEditView();
        String string2 = getString(R.string.GRider_payment_Remarks_OzRB);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment_Remarks_OzRB)");
        noteEditView2.setHintText(string2);
        getNoteEditView().setMaxInputLength(72);
        PixTransferOption.TransferOptionInfo transferOptionInfo = new PixTransferOption.TransferOptionInfo();
        transferOptionInfo.setUserAvailableAmount(500000);
        getAmountEditText().initConfig(transferOptionInfo);
        getAmountEditText().setValueWatcher(new QrCodeSetAmountFragment$initContentView$1(this));
        View findViewById3 = view.findViewById(R.id.receive_amount_confirm_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.r…ve_amount_confirm_btn_tv)");
        setConfirmBtn((TextView) findViewById3);
        getConfirmBtn().setEnabled(false);
        getConfirmBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QrCodeSetAmountFragment.m21944a(QrCodeSetAmountFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21944a(QrCodeSetAmountFragment qrCodeSetAmountFragment, View view) {
        Intrinsics.checkNotNullParameter(qrCodeSetAmountFragment, "this$0");
        Bundle arguments = qrCodeSetAmountFragment.getArguments();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_amount_ck", "pix_payee_key", arguments == null ? null : arguments.getString("pix_payee_key"));
        Intent intent = new Intent();
        intent.setClass(qrCodeSetAmountFragment.requireContext(), QRPayeeMainActivity.class);
        intent.putExtra("amount", qrCodeSetAmountFragment.getAmountEditText().getInputValue());
        intent.putExtra("note", qrCodeSetAmountFragment.getNoteEditView().getInputVal());
        qrCodeSetAmountFragment.backToPrePage();
        qrCodeSetAmountFragment.startActivity(intent);
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        getDefaultCommonTitlebar().setTitle(getString(R.string.GRider_payment_Set_Up_BpQi));
        getDefaultCommonTitlebar().setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QrCodeSetAmountFragment.m21945b(QrCodeSetAmountFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21945b(QrCodeSetAmountFragment qrCodeSetAmountFragment, View view) {
        Intrinsics.checkNotNullParameter(qrCodeSetAmountFragment, "this$0");
        qrCodeSetAmountFragment.backToPrePage();
    }
}

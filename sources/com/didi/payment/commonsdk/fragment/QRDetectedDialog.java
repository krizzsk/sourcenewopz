package com.didi.payment.commonsdk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp.QRCodeData;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002-.B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\"H\u0014J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\"H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006/"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog;", "T", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "Lcom/didi/sdk/view/SimplePopupBase;", "clickListener", "Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;", "t", "(Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;)V", "()V", "confirmBtnTv", "Landroid/widget/TextView;", "data", "Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogData;", "getData", "()Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogData;", "setData", "(Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogData;)V", "innerClickListener", "getInnerClickListener", "()Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;", "setInnerClickListener", "(Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;)V", "negativeBtnTv", "subTitleTv", "getSubTitleTv", "()Landroid/widget/TextView;", "setSubTitleTv", "(Landroid/widget/TextView;)V", "titleTv", "getTitleTv", "setTitleTv", "getLayout", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "DialogBtnClicikListener", "DialogData", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QRDetectedDialog.kt */
public class QRDetectedDialog<T extends PixQrCodeQueryResp.QRCodeData> extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TextView f30153a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f30154b;

    /* renamed from: c */
    private DialogData f30155c;

    /* renamed from: d */
    private TextView f30156d;

    /* renamed from: e */
    private TextView f30157e;

    /* renamed from: f */
    private DialogBtnClicikListener f30158f;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogBtnClicikListener;", "", "onConfirmClicked", "", "view", "Landroid/widget/TextView;", "onNegativeClicked", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: QRDetectedDialog.kt */
    public interface DialogBtnClicikListener {
        void onConfirmClicked(TextView textView);

        void onNegativeClicked(TextView textView);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fragment/QRDetectedDialog$DialogData;", "", "getConfirmBtnText", "", "getNegativeBtnText", "getSubtitle", "getTitle", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: QRDetectedDialog.kt */
    public interface DialogData {
        String getConfirmBtnText();

        String getNegativeBtnText();

        String getSubtitle();

        String getTitle();
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.w_common_center_dialog_fragment;
    }

    public QRDetectedDialog() {
    }

    public final DialogData getData() {
        return this.f30155c;
    }

    public final void setData(DialogData dialogData) {
        this.f30155c = dialogData;
    }

    public final TextView getTitleTv() {
        return this.f30156d;
    }

    public final void setTitleTv(TextView textView) {
        this.f30156d = textView;
    }

    public final TextView getSubTitleTv() {
        return this.f30157e;
    }

    public final void setSubTitleTv(TextView textView) {
        this.f30157e = textView;
    }

    public final DialogBtnClicikListener getInnerClickListener() {
        return this.f30158f;
    }

    public final void setInnerClickListener(DialogBtnClicikListener dialogBtnClicikListener) {
        this.f30158f = dialogBtnClicikListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QRDetectedDialog(DialogBtnClicikListener dialogBtnClicikListener, T t) {
        this();
        Intrinsics.checkNotNullParameter(dialogBtnClicikListener, "clickListener");
        Intrinsics.checkNotNullParameter(t, RavenKey.TYPE);
        this.f30158f = dialogBtnClicikListener;
        setArguments(new Bundle());
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putSerializable("dialog_data", (Serializable) t);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.containsKey("dialog_data") ? arguments.getSerializable("dialog_data") : null;
            if (serializable != null && (serializable instanceof DialogData)) {
                setData((DialogData) serializable);
            }
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        Window window = dialog == null ? null : dialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.gravity = 16;
        }
        if (window != null) {
            window.setAttributes(layoutParams);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f30156d = (TextView) this.mRootView.findViewById(R.id.dialog_title_tv);
        this.f30157e = (TextView) this.mRootView.findViewById(R.id.dialog_subtitle_tv);
        View findViewById = this.mRootView.findViewById(R.id.dialog_confirm_btn_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R….dialog_confirm_btn_text)");
        this.f30153a = (TextView) findViewById;
        View findViewById2 = this.mRootView.findViewById(R.id.dialog_negative_btn_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R…dialog_negative_btn_text)");
        this.f30154b = (TextView) findViewById2;
        DialogData dialogData = this.f30155c;
        TextView textView = null;
        if (dialogData != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.GRider_payment_Are_you_wzjV);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRider_payment_Are_you_wzjV)");
            String format = String.format(string, Arrays.copyOf(new Object[]{dialogData.getTitle()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            String string2 = getString(R.string.GRider_payment_detected_a_YjPB);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment_detected_a_YjPB)");
            String string3 = getString(R.string.GRider_payment_Confirmation_VAdW);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.GRide…ayment_Confirmation_VAdW)");
            String string4 = getString(R.string.GRider_payment_Cancel_kxPt);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.GRider_payment_Cancel_kxPt)");
            TextView titleTv = getTitleTv();
            if (titleTv != null) {
                titleTv.setText(format);
            }
            TextView subTitleTv = getSubTitleTv();
            if (subTitleTv != null) {
                subTitleTv.setText(string2);
            }
            TextView textView2 = this.f30153a;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtnTv");
                textView2 = null;
            }
            textView2.setText(string3);
            TextView textView3 = this.f30154b;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("negativeBtnTv");
                textView3 = null;
            }
            textView3.setText(string4);
        }
        TextView textView4 = this.f30153a;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtnTv");
            textView4 = null;
        }
        textView4.setOnClickListener(new QRDetectedDialog$initView$2(this));
        TextView textView5 = this.f30154b;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("negativeBtnTv");
        } else {
            textView = textView5;
        }
        textView.setOnClickListener(new QRDetectedDialog$initView$3(this));
    }
}

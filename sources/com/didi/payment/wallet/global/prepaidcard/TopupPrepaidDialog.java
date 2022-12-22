package com.didi.payment.wallet.global.prepaidcard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.utils.GlideRoundedCornersTransform;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/TopupPrepaidDialog;", "Landroidx/fragment/app/DialogFragment;", "resp", "Lcom/didi/payment/wallet/global/model/resp/WalletPayResultResp$PopInfo;", "(Lcom/didi/payment/wallet/global/model/resp/WalletPayResultResp$PopInfo;)V", "getResp", "()Lcom/didi/payment/wallet/global/model/resp/WalletPayResultResp$PopInfo;", "setResp", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopupPrepaidDialog.kt */
public final class TopupPrepaidDialog extends DialogFragment {

    /* renamed from: a */
    private WalletPayResultResp.PopInfo f31769a;

    public TopupPrepaidDialog(WalletPayResultResp.PopInfo popInfo) {
        this.f31769a = popInfo;
    }

    public final WalletPayResultResp.PopInfo getResp() {
        return this.f31769a;
    }

    public final void setResp(WalletPayResultResp.PopInfo popInfo) {
        this.f31769a = popInfo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.WalletHomeDialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.requestWindowFeature(1);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            Window window2 = dialog.getWindow();
            WindowManager.LayoutParams attributes = window2 == null ? null : window2.getAttributes();
            if (attributes != null) {
                attributes.windowAnimations = R.style.common_dialog_anim_style;
            }
        }
        return layoutInflater.inflate(R.layout.layout_topup_prepaid, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        List<PayRichInfo> list;
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_sub_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_pic);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_cancel);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_confirm);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_content);
        WalletPayResultResp.PopInfo popInfo = this.f31769a;
        textView.setText(popInfo == null ? null : popInfo.title);
        WalletPayResultResp.PopInfo popInfo2 = this.f31769a;
        textView2.setText(popInfo2 == null ? null : popInfo2.subTitle);
        WalletPayResultResp.PopInfo popInfo3 = this.f31769a;
        textView4.setText(popInfo3 == null ? null : popInfo3.confirmButton);
        WalletPayResultResp.PopInfo popInfo4 = this.f31769a;
        textView3.setText(popInfo4 == null ? null : popInfo4.cancelButton);
        Context context = getContext();
        if (context != null) {
            RequestManager with = Glide.with(context);
            WalletPayResultResp.PopInfo resp = getResp();
            ((RequestBuilder) with.load(resp == null ? null : resp.pictureUrl).transform((Transformation<Bitmap>) new GlideRoundedCornersTransform(20.0f, GlideRoundedCornersTransform.CornerType.TOP))).into(imageView);
        }
        linearLayout.removeAllViews();
        WalletPayResultResp.PopInfo popInfo5 = this.f31769a;
        if (!(popInfo5 == null || (list = popInfo5.items) == null)) {
            for (PayRichInfo bindTextView : list) {
                TextView textView5 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = UIUtil.dip2px(getContext(), 6.0f);
                textView5.setLayoutParams(layoutParams);
                linearLayout.addView(textView5);
                bindTextView.bindTextView(textView5, (PayRichInfo.ISpannableString) null);
            }
        }
        textView4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TopupPrepaidDialog.m22530a(TopupPrepaidDialog.this, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TopupPrepaidDialog.m22531b(TopupPrepaidDialog.this, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                TopupPrepaidDialog.m22532c(TopupPrepaidDialog.this, view);
            }
        });
        WalletHomeTrackerManager.Companion.trackTopupPrepaidDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22530a(TopupPrepaidDialog topupPrepaidDialog, View view) {
        Intrinsics.checkNotNullParameter(topupPrepaidDialog, "this$0");
        PrepaidCardManager.Companion.start$default(PrepaidCardManager.Companion, topupPrepaidDialog.getContext(), PrepaidSource.TOP_UP_DIALOG.getValue(), PrepaidConstant.SCENE_APPLY, WalletHomeTrackerManager.Companion.getStatus(), "1", (String) null, (RouterCallback) null, 96, (Object) null);
        topupPrepaidDialog.dismiss();
        WalletHomeTrackerManager.Companion.trackTopupPrepaidDialogClick(XPanelScene.SCENE_CONFIRM);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m22531b(TopupPrepaidDialog topupPrepaidDialog, View view) {
        Intrinsics.checkNotNullParameter(topupPrepaidDialog, "this$0");
        WalletHomeTrackerManager.Companion.trackTopupPrepaidDialogClick("cancel");
        topupPrepaidDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m22532c(TopupPrepaidDialog topupPrepaidDialog, View view) {
        Intrinsics.checkNotNullParameter(topupPrepaidDialog, "this$0");
        WalletHomeTrackerManager.Companion.trackTopupPrepaidDialogClick("cancel");
        topupPrepaidDialog.dismiss();
    }
}

package com.didi.global.fintech.cashier.core;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierConfirmPay;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.core.ktx.StringKtxKt;
import com.didi.global.fintech.cashier.core.ktx.TextClickCallback;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierConfirmPayPresenter;
import com.didi.global.fintech.cashier.core.view.GlobalCashierConfirmPayView;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.global.fintech.cashier.model.net.request.ConfirmButton;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierConfirmPayActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierConfirmPay;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "()V", "getPresenter", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter;", "getView", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierConfirmPayView;", "initViewAndData", "", "layoutRes", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierConfirmPayActivity.kt */
public final class GlobalCashierConfirmPayActivity extends BaseCashierActivity<IGlobalCashierConfirmPay, IGlobalCashierPayView> {
    public int layoutRes() {
        return R.layout.activity_global_cashier_confirm_pay;
    }

    public static final /* synthetic */ IGlobalCashierConfirmPay access$getMPresenter(GlobalCashierConfirmPayActivity globalCashierConfirmPayActivity) {
        return (IGlobalCashierConfirmPay) globalCashierConfirmPayActivity.getMPresenter();
    }

    public GlobalCashierConfirmPayPresenter getPresenter() {
        return new GlobalCashierConfirmPayPresenter(this, getMUniqueId());
    }

    public GlobalCashierConfirmPayView getView() {
        return new GlobalCashierConfirmPayView();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m15719a();
    }

    /* renamed from: a */
    private final void m15719a() {
        List<ConfirmButton> buttons;
        TextView textView;
        TextView textView2;
        String bottom;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        String title;
        String str2;
        CashierActionData cashierActionData = (CashierActionData) getIntent().getSerializableExtra("actionData");
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        if (imageView != null) {
            ViewKtxKt.click$default(imageView, 0, new GlobalCashierConfirmPayActivity$initViewAndData$1(this), 1, (Object) null);
        }
        TextView textView3 = (TextView) findViewById(R.id.tv_page_title);
        SpannableStringBuilder spannableStringBuilder2 = null;
        if (textView3 != null) {
            if (cashierActionData == null) {
                str2 = null;
            } else {
                str2 = cashierActionData.getPageTitle();
            }
            textView3.setText(str2);
        }
        TextView textView4 = (TextView) findViewById(R.id.tv_title);
        if (textView4 != null) {
            if (cashierActionData == null || (title = cashierActionData.getTitle()) == null) {
                spannableStringBuilder = null;
            } else {
                spannableStringBuilder = StringKtxKt.highlight$default(title, this, 0, false, (TextClickCallback) null, 8, (Object) null);
            }
            textView4.setText(spannableStringBuilder);
        }
        TextView textView5 = (TextView) findViewById(R.id.tv_content);
        if (textView5 != null) {
            if (cashierActionData == null) {
                str = null;
            } else {
                str = cashierActionData.getContent();
            }
            textView5.setText(str);
        }
        TextView textView6 = (TextView) findViewById(R.id.tv_bottom_desc);
        if (textView6 != null) {
            if (!(cashierActionData == null || (bottom = cashierActionData.getBottom()) == null)) {
                spannableStringBuilder2 = StringKtxKt.highlight$default(bottom, this, 0, false, (TextClickCallback) null, 8, (Object) null);
            }
            textView6.setText(spannableStringBuilder2);
        }
        if (cashierActionData != null && (buttons = cashierActionData.getButtons()) != null) {
            for (ConfirmButton confirmButton : buttons) {
                if (Intrinsics.areEqual((Object) "1", (Object) confirmButton.getType()) && (textView2 = (TextView) findViewById(R.id.btn_confirm)) != null) {
                    View view = textView2;
                    view.setVisibility(0);
                    textView2.setText(confirmButton.getText());
                    ViewKtxKt.click$default(view, 0, new GlobalCashierConfirmPayActivity$initViewAndData$6$1$1(this), 1, (Object) null);
                }
                if (Intrinsics.areEqual((Object) "2", (Object) confirmButton.getType()) && (textView = (TextView) findViewById(R.id.btn_cancel)) != null) {
                    View view2 = textView;
                    view2.setVisibility(0);
                    textView.setText(confirmButton.getText());
                    ViewKtxKt.click$default(view2, 0, new GlobalCashierConfirmPayActivity$initViewAndData$6$2$1(this), 1, (Object) null);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i == 201) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}

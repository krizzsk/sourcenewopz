package com.didi.component.operationpanel.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.operationpanel.impl.view.EmailEditDialog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.WebActivity;
import com.didi.travel.psnger.utils.LogUtil;
import com.taxis99.R;

public class ReceiptReceiveEmailActivity extends WebActivity {

    /* renamed from: a */
    private FrameLayout f14823a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f14824b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f14825c;

    /* renamed from: d */
    private EmailEditDialog f14826d;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<Integer> f14827e = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (BaseEventKeys.Invoice.KEY_INVOICE_STATUS_NOTIFY.equalsIgnoreCase(str)) {
                ReceiptReceiveEmailActivity.this.f14825c.setEnabled(num.intValue() == 0);
                if (Build.VERSION.SDK_INT >= 23) {
                    ReceiptReceiveEmailActivity.this.f14825c.setTextColor(ReceiptReceiveEmailActivity.this.getColor(num.intValue() == 0 ? R.color.white : R.color.g_color_999999));
                } else {
                    ReceiptReceiveEmailActivity.this.f14825c.setTextColor(Color.parseColor(num.intValue() == 0 ? "#ffffff" : "#999999"));
                }
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<EmailEditDialog.InvoiceSend2EmalResp> f14828f = new BaseEventPublisher.OnEventListener<EmailEditDialog.InvoiceSend2EmalResp>() {
        public void onEvent(String str, EmailEditDialog.InvoiceSend2EmalResp invoiceSend2EmalResp) {
            if (BaseEventKeys.Invoice.KEY_INVOICE_EMAIL_SEND_RESPONSE.equalsIgnoreCase(str) && invoiceSend2EmalResp != null) {
                LogUtil.m31426d("hgl_tag sendemail finish with errno:" + invoiceSend2EmalResp.errno);
                ToastHelper.showLongInfo((Context) ReceiptReceiveEmailActivity.this, invoiceSend2EmalResp.errno == 0 ? ReceiptReceiveEmailActivity.this.getString(R.string.Global_Rider_0417_GlobalRider_RU_Send_Receipt_After_the_Trip_mail_send_wzsw) : invoiceSend2EmalResp.errmsg, invoiceSend2EmalResp.errno == 0 ? R.drawable.global_common_icon_success : R.drawable.global_common_icon_fail);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setTheme(R.style.GlobalActivityTheme);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.webview_fl_grandpa);
        this.f14823a = frameLayout;
        m10612a(frameLayout);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Invoice.KEY_INVOICE_STATUS_NOTIFY, this.f14827e);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Invoice.KEY_INVOICE_EMAIL_SEND_RESPONSE, this.f14828f);
    }

    /* renamed from: a */
    private void m10612a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            LogUtil.m31427d("hgl_tag", "init bottom operation button fail, obtain parentview fail");
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.receipt_send2email_button_lay, frameLayout, false);
        frameLayout.addView(inflate);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        inflate.setLayoutParams(layoutParams);
        this.f14824b = findViewById(R.id.send_via_email_parent);
        TextView textView = (TextView) findViewById(R.id.send_via_email_tvbtn);
        this.f14825c = textView;
        textView.setEnabled(false);
        this.f14825c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ReceiptReceiveEmailActivity.this.m10613b();
            }
        });
        this.f14824b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ReceiptReceiveEmailActivity.this.f14824b.getViewTreeObserver();
                int height = ReceiptReceiveEmailActivity.this.f14824b.getHeight();
                View findViewById = ReceiptReceiveEmailActivity.this.findViewById(R.id.webview_ll_parent);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.bottomMargin = height;
                findViewById.setLayoutParams(layoutParams);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10613b() {
        EmailEditDialog emailEditDialog = new EmailEditDialog();
        this.f14826d = emailEditDialog;
        emailEditDialog.show(getSupportFragmentManager(), "default");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtil.m31426d("hgl_tag activity finish, dismiss ");
        EmailEditDialog emailEditDialog = this.f14826d;
        if (emailEditDialog != null) {
            emailEditDialog.dismiss();
        }
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Invoice.KEY_INVOICE_STATUS_NOTIFY, this.f14827e);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Invoice.KEY_INVOICE_EMAIL_SEND_RESPONSE, this.f14828f);
    }
}

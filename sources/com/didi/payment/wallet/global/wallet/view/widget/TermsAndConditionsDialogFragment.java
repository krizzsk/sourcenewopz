package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.payment.base.web.WebViewModel;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class TermsAndConditionsDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f32830a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f32831b;

    /* renamed from: c */
    private ImageView f32832c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DialogBtnClickListener f32833d;

    /* renamed from: e */
    private LinearLayout f32834e;

    /* renamed from: f */
    private FusionWebView f32835f;

    /* renamed from: g */
    private Context f32836g;

    /* renamed from: h */
    private String f32837h;
    protected WebViewModel mWebViewModel;

    public interface DialogBtnClickListener {
        void onClicked(TextView textView);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_terms_and_conditions;
    }

    public TermsAndConditionsDialogFragment(String str, DialogBtnClickListener dialogBtnClickListener) {
        this.f32837h = str;
        this.f32833d = dialogBtnClickListener;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f32836g = getContext();
        this.f32830a = (TextView) this.mRootView.findViewById(R.id.dialog_title);
        this.f32832c = (ImageView) this.mRootView.findViewById(R.id.btn_closeImg);
        this.f32831b = (TextView) this.mRootView.findViewById(R.id.btn_agree);
        this.f32834e = (LinearLayout) this.mRootView.findViewById(R.id.web_view_container);
        FusionWebView fusionWebView = new FusionWebView(this.f32836g);
        this.f32835f = fusionWebView;
        this.f32834e.addView(fusionWebView);
        this.f32831b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TermsAndConditionsDialogFragment.this.dismiss();
                TermsAndConditionsDialogFragment.this.f32833d.onClicked(TermsAndConditionsDialogFragment.this.f32831b);
            }
        });
        this.f32832c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TermsAndConditionsDialogFragment.this.dismiss();
            }
        });
        String str = this.f32837h;
        if (str != null && !str.isEmpty()) {
            this.f32830a.setText(this.f32837h);
        }
        m23169a();
    }

    public void setData(String str) {
        WebViewModel webViewModel = new WebViewModel();
        this.mWebViewModel = webViewModel;
        if (str != null) {
            webViewModel.url = str;
        }
        this.mWebViewModel.isSupportCache = true;
    }

    /* renamed from: a */
    private void m23169a() {
        this.f32835f.setWebViewClient(new FusionWebViewClient(this.f32835f));
        this.f32835f.setWebChromeClient(new FusionWebChromeClient(this.f32835f));
        this.f32835f.setVerticalScrollBarEnabled(true);
        this.f32835f.setHorizontalScrollBarEnabled(false);
        this.f32835f.loadUrl(this.mWebViewModel.url);
    }

    public void onDestroy() {
        super.onDestroy();
        FusionWebView fusionWebView = this.f32835f;
        if (fusionWebView != null) {
            if (fusionWebView.getParent() != null && (this.f32835f.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f32835f.getParent()).removeView(this.f32835f);
            }
            this.f32835f.removeAllViews();
            this.f32835f.destroy();
        }
    }
}

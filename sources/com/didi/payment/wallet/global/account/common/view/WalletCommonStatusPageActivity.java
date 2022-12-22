package com.didi.payment.wallet.global.account.common.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.account.common.model.WalletCommonPageModel;
import com.didi.payment.wallet.global.model.event.WalletSignUpSuccessEvent;
import com.didi.payment.wallet.global.utils.TextViewUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class WalletCommonStatusPageActivity extends WalletBaseActivity {

    /* renamed from: a */
    private static final String f31727a = "common_page_data";

    /* renamed from: b */
    private TextView f31728b;

    /* renamed from: c */
    private TextView f31729c;

    /* renamed from: d */
    private TextView f31730d;

    /* renamed from: e */
    private TextView f31731e;

    /* renamed from: f */
    private ImageView f31732f;

    /* renamed from: g */
    private View f31733g;

    /* renamed from: h */
    private LinearLayout f31734h;

    /* renamed from: i */
    private WalletCommonPageModel f31735i;

    public static void startActivity(Context context, WalletCommonPageModel walletCommonPageModel) {
        Intent intent = new Intent(context, WalletCommonStatusPageActivity.class);
        intent.putExtra(f31727a, walletCommonPageModel);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_common_status_page_activity);
        m22501c();
        m22497a();
        m22500b();
        m22502d();
        m22504f();
    }

    /* renamed from: a */
    private void m22497a() {
        this.f31728b = (TextView) findViewById(R.id.wallet_common_page_main_title_tv);
        this.f31729c = (TextView) findViewById(R.id.wallet_common_page_sub_title_tv);
        this.f31730d = (TextView) findViewById(R.id.wallet_common_page_bottom_btn);
        this.f31733g = findViewById(R.id.wallet_common_page_back_btn);
        this.f31731e = (TextView) findViewById(R.id.wallet_common_page_comment_tv);
        this.f31732f = (ImageView) findViewById(R.id.wallet_common_page_big_iv);
        this.f31734h = (LinearLayout) findViewById(R.id.wallet_common_page_wallet_container);
    }

    /* renamed from: b */
    private void m22500b() {
        C110951 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.wallet_common_page_back_btn) {
                    WalletCommonStatusPageActivity.this.onBackPressed();
                } else if (view.getId() == R.id.wallet_common_page_bottom_btn) {
                    WalletCommonStatusPageActivity.this.m22506h();
                }
            }
        };
        this.f31733g.setOnClickListener(r0);
        this.f31730d.setOnClickListener(r0);
    }

    /* renamed from: c */
    private void m22501c() {
        this.f31735i = (WalletCommonPageModel) getIntent().getSerializableExtra(f31727a);
    }

    /* renamed from: d */
    private void m22502d() {
        if (this.f31735i != null) {
            m22503e();
            this.f31732f.setImageResource(this.f31735i.topImageId);
            this.f31730d.setText(this.f31735i.buttonText);
            if (this.f31735i.accountStatus != null) {
                TextViewUtils.setText(this.f31728b, this.f31735i.accountStatus.title);
                TextViewUtils.setText(this.f31729c, this.f31735i.accountStatus.subTitle);
                TextViewUtils.setText(this.f31731e, this.f31735i.accountStatus.comment);
                m22499a(this.f31735i.accountStatus.entries);
            }
            if (this.f31735i.targetPage == 3) {
                this.f31733g.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    private void m22499a(List<IWalletService.WalletFunction> list) {
        if (list != null && list.size() != 0) {
            for (IWalletService.WalletFunction next : list) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.wallet_common_page_list_item, this.f31734h, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = UIUtil.dip2px(this, 15.0f);
                this.f31734h.addView(linearLayout, layoutParams);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.wallet_list_item_iv);
                TextView textView = (TextView) linearLayout.findViewById(R.id.wallet_list_item_tv);
                if (next.iconUrl != null) {
                    GlideUtils.with2load2into(this, next.iconUrl, imageView);
                }
                textView.setText(next.desc);
            }
        }
    }

    /* renamed from: e */
    private void m22503e() {
        WalletCommonPageModel walletCommonPageModel = this.f31735i;
        if (walletCommonPageModel != null) {
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                this.f31735i.buttonText = getString(R.string.wallet_common_page_btn_verify_now);
                this.f31735i.topImageId = R.drawable.wallet_common_png_intro;
            } else if (i == 2) {
                if (this.f31735i.accountStatus == null || !this.f31735i.accountStatus.isAllowFullKyc) {
                    this.f31735i.buttonText = getString(R.string.wallet_common_page_btn_ok);
                } else {
                    this.f31735i.buttonText = getString(R.string.GRider_Optimization_Continue_NgOT);
                }
                this.f31735i.topImageId = R.drawable.wallet_common_png_on_check;
            } else if (i == 3) {
                this.f31735i.buttonText = getString(R.string.wallet_common_page_btn_get_start);
                this.f31735i.topImageId = R.drawable.wallet_common_png_create_success;
            } else if (i == 4) {
                this.f31735i.buttonText = getString(R.string.wallet_common_page_btn_try_again);
                this.f31735i.topImageId = R.drawable.wallet_common_png_create_failed;
            }
        }
    }

    /* renamed from: f */
    private void m22504f() {
        WalletCommonPageModel walletCommonPageModel = this.f31735i;
        if (walletCommonPageModel != null) {
            String str = null;
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                str = "gp_99pay_newlearn_view_sw";
            } else if (i == 2) {
                str = "gp_99pay_examine_vew_sw";
            } else if (i == 3) {
                str = "gp_99pay_application_success_sw";
            } else if (i == 4) {
                str = "gp_99pay_application_fail_sw";
            }
            if (str != null) {
                FinOmegaSDK.trackEvent(str);
            }
        }
    }

    /* renamed from: g */
    private void m22505g() {
        WalletCommonPageModel walletCommonPageModel = this.f31735i;
        if (walletCommonPageModel != null) {
            String str = null;
            int i = walletCommonPageModel.targetPage;
            if (i == 1) {
                str = "gp_99pay_newlearn_confirm_ck";
            } else if (i == 4) {
                str = "gp_99pay_application_fail_again_ck";
            }
            if (str != null) {
                FinOmegaSDK.trackEvent(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m22506h() {
        m22505g();
        int i = this.f31735i.targetPage;
        if (i == 1) {
            m22507i();
        } else if (i != 2) {
            if (i == 3) {
                m22508j();
            } else if (i == 4) {
                m22507i();
            }
        } else if (this.f31735i.accountStatus == null || !this.f31735i.accountStatus.isAllowFullKyc) {
            m22509k();
        } else {
            m22510l();
        }
    }

    /* renamed from: i */
    private void m22507i() {
        WalletRouter.gotoApplyAccountPage(this);
        finish();
    }

    /* renamed from: j */
    private void m22508j() {
        EventBus.getDefault().post(new WalletSignUpSuccessEvent());
        finish();
    }

    /* renamed from: k */
    private void m22509k() {
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        finish();
    }

    /* renamed from: l */
    private void m22510l() {
        WalletRouter.gotoFullKycRegisterPage(this, 0);
        finish();
    }
}

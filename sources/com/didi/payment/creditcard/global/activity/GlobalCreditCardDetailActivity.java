package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.creditcard.global.contract.CreditCardDetailContract;
import com.didi.payment.creditcard.global.model.CancelCardParam;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.presenter.GlobalCreditCardDetailPresenter;
import com.didi.payment.creditcard.global.utils.GlobalCreditPayTipDialogFragment;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import org.json.JSONObject;

public class GlobalCreditCardDetailActivity extends GlobalBaseActivity implements CreditCardDetailContract.IView {
    public static final int REQ_CODE_UPDATE_CARD = 6;

    /* renamed from: a */
    private static final String f30338a = "param";

    /* renamed from: b */
    private TextView f30339b;

    /* renamed from: c */
    private ImageView f30340c;

    /* renamed from: d */
    private TextView f30341d;

    /* renamed from: e */
    private TextView f30342e;

    /* renamed from: f */
    private TextView f30343f;

    /* renamed from: g */
    private TextView f30344g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FragmentActivity f30345h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CancelCardParam f30346i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalCreditCardDetailPresenter f30347j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GGKDrawer f30348k;

    public static void launch(Activity activity, int i, CancelCardParam cancelCardParam) {
        Intent intent = new Intent(activity, GlobalCreditCardDetailActivity.class);
        intent.putExtra("param", cancelCardParam);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_credit_card_detail);
        this.f30345h = this;
        m21313a();
        m21319c();
        GlobalOmegaUtils.trackCardDetailPageSW(this);
    }

    /* renamed from: a */
    private void m21313a() {
        this.f30346i = (CancelCardParam) getIntent().getSerializableExtra("param");
        this.f30347j = new GlobalCreditCardDetailPresenter(this);
    }

    /* renamed from: b */
    private void m21317b() {
        this.f30339b = (TextView) findViewById(R.id.tv_title);
        this.f30340c = (ImageView) findViewById(R.id.iv_left);
        this.f30341d = (TextView) findViewById(R.id.tv_right);
        this.f30339b.setText(getString(R.string.one_payment_creditcard_global_detail_page_title));
        this.f30340c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardDetailActivity.this.onBackPressed();
                GlobalOmegaUtils.trackCardDetailPageReturnCk(GlobalCreditCardDetailActivity.this);
            }
        });
        this.f30341d.setText(getString(R.string.one_payment_creditcard_global_detail_page_remove_btn));
        this.f30341d.setVisibility(0);
        this.f30341d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalCreditCardDetailActivity.this.f30346i != null) {
                    GlobalCreditCardDetailActivity.this.f30347j.checkCard(150, GlobalCreditCardDetailActivity.this.f30346i.cardIndex);
                }
                GlobalOmegaUtils.trackCardDetailPageRemoveCk(GlobalCreditCardDetailActivity.this);
            }
        });
    }

    /* renamed from: c */
    private void m21319c() {
        m21317b();
        this.f30342e = (TextView) findViewById(R.id.tv_card_number);
        this.f30343f = (TextView) findViewById(R.id.tv_expired_date);
        this.f30344g = (TextView) findViewById(R.id.tv_update);
        CancelCardParam cancelCardParam = this.f30346i;
        if (cancelCardParam != null) {
            String str = cancelCardParam.cardNo;
            if (!TextUtils.isEmpty(str) && str.length() >= 4) {
                str = str.substring(str.length() - 4);
            }
            this.f30342e.setText(str);
            this.f30343f.setText(this.f30346i.expiryDate);
            if (this.f30346i.expired == 1) {
                this.f30344g.setVisibility(0);
                this.f30344g.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalCreditCardDetailActivity.this.f30346i != null) {
                            GlobalCreditCardDetailPresenter b = GlobalCreditCardDetailActivity.this.f30347j;
                            GlobalCreditCardDetailActivity globalCreditCardDetailActivity = GlobalCreditCardDetailActivity.this;
                            b.updateCard(globalCreditCardDetailActivity, globalCreditCardDetailActivity.f30346i.cardNo, GlobalCreditCardDetailActivity.this.f30346i.resourceId);
                        }
                    }
                });
            } else {
                this.f30344g.setVisibility(8);
            }
            if (this.f30346i.expired == 1) {
                findViewById(R.id.rl_expired_layout).setBackgroundResource(R.drawable.one_payment_creditcard_global_bg_card_detail_expired);
                ((ImageView) findViewById(R.id.iv_card_icon)).setImageResource(R.drawable.one_payment_creditcard_global_icon_credit_card_expired);
            }
        }
    }

    public void showCancelSignConfirmDialog() {
        GlobalDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalCreditCardDetailActivity.this.f30346i != null) {
                    GlobalCreditCardDetailActivity.this.f30347j.removeCard(150, GlobalCreditCardDetailActivity.this.f30346i.cardIndex);
                }
                GlobalOmegaUtils.trackCardDetailPageRemoveOKCk(GlobalCreditCardDetailActivity.this);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackCardDetailPageRemoveCancelCk(GlobalCreditCardDetailActivity.this);
            }
        });
    }

    public void showInvalidCancelDialog(String str) {
        GGKDrawerModel1 gGKDrawerModel1 = new GGKDrawerModel1("", new GGKBtnTextAndCallback(getString(R.string.pay_base_confirm), new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (GlobalCreditCardDetailActivity.this.f30348k != null) {
                    GlobalCreditCardDetailActivity.this.f30348k.dismiss();
                }
            }
        }));
        gGKDrawerModel1.setSubTitle(str);
        this.f30348k = GGKUICreatorWithThemeCheck.showDrawerModel(this, gGKDrawerModel1);
    }

    public void onCancelSignSuccess() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    public void showPayTipDialog(String str, String str2, String str3, String str4, String str5, String str6) {
        final String a = m21312a(str3);
        final String str7 = str4;
        final String str8 = str5;
        final String str9 = str6;
        GlobalDialogUtil.showPayTipDialog(this.f30345h, str, str2, new GlobalCreditPayTipDialogFragment.PayTipDialogEventListener() {
            public void onNegativeClick() {
            }

            public void onPositiveClick() {
                GlobalCreditCardDetailActivity.this.m21315a(str7, str8, str9);
            }

            public void onFaqClick() {
                WebBrowserUtil.startInternalWebActivity(GlobalCreditCardDetailActivity.this.f30345h, a, "");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21315a(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.didi.global.unifiedPay.entrance");
        intent.setPackage(getPackageName());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.PayParams.OUT_TRADE_ID, str);
            jSONObject.put("oid", str2);
            jSONObject.put("sid", str3);
            Bundle bundle = new Bundle();
            bundle.putSerializable("uni_pay_param", jSONObject.toString());
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m21312a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (!str.contains("token")) {
            str2 = str2 + "&token=" + PayBaseParamUtil.getStringParam(this, "token");
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.contains("?")) {
            return str + str2;
        }
        return str + str2.replaceFirst(ParamKeys.SIGN_AND, "?");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 6 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }
}

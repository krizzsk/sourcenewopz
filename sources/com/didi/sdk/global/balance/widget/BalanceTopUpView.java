package com.didi.sdk.global.balance.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.contract.GlobalBalanceAccountContract;
import com.didi.sdk.global.balance.model.BalanceDataConverter;
import com.didi.sdk.global.balance.model.bean.BalanceAccount;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.balance.model.bean.TopUpMethodDetail;
import com.didi.sdk.global.balance.widget.TopUpMethodCardView;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

@Deprecated
public class BalanceTopUpView extends LinearLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private static final String f36028a = "Balance";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f36029b;

    /* renamed from: c */
    private int f36030c;

    /* renamed from: d */
    private BalancePageResponse f36031d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalBalanceAccountContract.Presenter f36032e;

    /* renamed from: f */
    private LinearLayout f36033f;

    /* renamed from: g */
    private LinearLayout f36034g;

    /* renamed from: h */
    private TopUpMethodCardView f36035h;

    /* renamed from: i */
    private TextView f36036i;

    /* renamed from: j */
    private TextView f36037j;

    /* renamed from: k */
    private TextView f36038k;

    /* renamed from: l */
    private Button f36039l;

    /* renamed from: m */
    private final boolean f36040m = false;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public BalanceTopUpView(Context context) {
        super(context);
        m25486a();
        m25487a(context);
    }

    public BalanceTopUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25486a();
        m25487a(context);
    }

    public BalanceTopUpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25486a();
        m25487a(context);
    }

    /* renamed from: a */
    private void m25486a() {
        this.f36030c = 0;
    }

    public void setPresenter(GlobalBalanceAccountContract.Presenter presenter) {
        this.f36032e = presenter;
    }

    public void refreshData(BalancePageResponse balancePageResponse) {
        this.f36031d = balancePageResponse;
        m25490b();
    }

    /* renamed from: a */
    private void m25487a(Context context) {
        this.f36029b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_balance_topup_view, this, true);
        this.f36033f = (LinearLayout) inflate.findViewById(R.id.ll_topup_content);
        this.f36034g = (LinearLayout) inflate.findViewById(R.id.ll_topup_empty);
        this.f36033f.setVisibility(8);
        this.f36037j = (TextView) inflate.findViewById(R.id.tv_select_topup_method_title);
        this.f36035h = (TopUpMethodCardView) inflate.findViewById(R.id.cv_default_topup_method);
        this.f36036i = (TextView) inflate.findViewById(R.id.tv_topup_legal_terms);
        this.f36039l = (Button) inflate.findViewById(R.id.btn_topup);
        this.f36038k = (TextView) inflate.findViewById(R.id.tv_balance_disabled);
    }

    /* renamed from: b */
    private void m25490b() {
        BalanceAccount balanceAccount = this.f36031d.data.allEntries.get(this.f36030c);
        if (balanceAccount.isActive.booleanValue()) {
            this.f36033f.setVisibility(0);
            this.f36034g.setVisibility(8);
            m25488a(balanceAccount);
            return;
        }
        this.f36033f.setVisibility(8);
        this.f36034g.setVisibility(0);
        m25491b(balanceAccount);
    }

    /* renamed from: a */
    private void m25488a(BalanceAccount balanceAccount) {
        final TopUpMethodDetail topUpMethodDetail = balanceAccount.topUpMethodDetail;
        this.f36035h.setPayMethodItemInfo(BalanceDataConverter.convertToPayMethodItemInfo(topUpMethodDetail));
        this.f36035h.setEnabled(true);
        boolean z = topUpMethodDetail.hasMoreTopUpMethod;
        this.f36035h.setSelectStyle(TopUpMethodCardView.STYLE.CHECK);
        this.f36035h.setIsSelected(true);
        this.f36035h.setOnClickListener((View.OnClickListener) null);
        if (!TextUtils.isEmpty(topUpMethodDetail.title)) {
            this.f36037j.setText(topUpMethodDetail.title);
        }
        if (!TextUtils.isEmpty(topUpMethodDetail.legalTermsTitle)) {
            this.f36036i.setText(topUpMethodDetail.legalTermsTitle);
        }
        if (!TextUtils.isEmpty(topUpMethodDetail.topUpDesc)) {
            this.f36039l.setText(topUpMethodDetail.topUpDesc);
        }
        this.f36036i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BalanceTopUpView.this.f36032e != null) {
                    BalanceTopUpView.this.f36032e.jumpToLegalTermsActivity(topUpMethodDetail.legalTermsUrl, topUpMethodDetail.channelId);
                } else {
                    SystemUtils.log(6, "Balance", "presenter is null", (Throwable) null, "com.didi.sdk.global.balance.widget.BalanceTopUpView$1", 156);
                }
            }
        });
        this.f36039l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (BalanceTopUpView.this.f36032e != null) {
                    BalanceTopUpView.this.f36032e.jumpToTopUpPage(topUpMethodDetail.topUpUrl, topUpMethodDetail.channelId, 0);
                } else {
                    SystemUtils.log(6, "Balance", "presenter is null", (Throwable) null, "com.didi.sdk.global.balance.widget.BalanceTopUpView$2", 168);
                }
                GlobalOmegaUtils.trackBalanceDetailPageTopUpCK(BalanceTopUpView.this.f36029b);
            }
        });
    }

    /* renamed from: b */
    private void m25491b(BalanceAccount balanceAccount) {
        this.f36038k.setText(balanceAccount.message);
    }

    /* renamed from: c */
    private void m25492c() {
        this.f36035h.setSelectStyle(TopUpMethodCardView.STYLE.CLICK);
        this.f36035h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AlertDialog.Builder builder = new AlertDialog.Builder(BalanceTopUpView.this.f36029b);
                builder.setMessage("Not Implemented Yet").setPositiveButton(Payload.RESPONSE_OK, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        dialogInterface.dismiss();
                    }
                });
                SystemUtils.showDialog(builder.create());
            }
        });
    }

    public void onPageSelected(int i) {
        this.f36030c = i;
        m25490b();
    }
}

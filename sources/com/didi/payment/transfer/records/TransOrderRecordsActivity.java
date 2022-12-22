package com.didi.payment.transfer.records;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.payment.transfer.records.TransHistoryRcyAdapter;
import com.didi.payment.transfer.records.presenter.ITransRecordPresenter;
import com.didi.payment.transfer.records.presenter.TransRecordPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class TransOrderRecordsActivity extends TransBaseActivity<ITransRecordPresenter> implements ITransRecordPageView {

    /* renamed from: b */
    private CommonTitleBar f31484b;

    /* renamed from: c */
    private RecyclerView f31485c;

    /* renamed from: d */
    private View f31486d;

    /* renamed from: e */
    private TextView f31487e;

    /* renamed from: f */
    private TransHistoryRcyAdapter f31488f;

    /* renamed from: g */
    private int f31489g;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_history_root_lay;
    }

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return true;
    }

    public void loadHistoryRecords() {
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.trans_history_titlebar;
    }

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, TransOrderRecordsActivity.class);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, i);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, TransOrderRecordsActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.f31484b = (CommonTitleBar) findViewById(R.id.trans_history_titlebar);
        this.f31485c = (RecyclerView) findViewById(R.id.trans_history_ry);
        this.f31486d = findViewById(R.id.trans_history_empty_layout);
        this.f31487e = (TextView) findViewById(R.id.trans_history_empty_tv);
        this.f31488f = new TransHistoryRcyAdapter(this, new TransHistoryRcyAdapter.HistoryListCallback() {
            public void onLastItemShowed() {
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadHistoryData(false);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadNextPage();
            }
        }, new TransHistoryRcyAdapter.HistoryListItemClickListener() {
            public void onItemClick(TransHistoryListResp.HistoryItem historyItem) {
                if (historyItem == null) {
                    SystemUtils.log(3, "wallet", "click item null", (Throwable) null, "com.didi.payment.transfer.records.TransOrderRecordsActivity$2", 80);
                    return;
                }
                SystemUtils.log(3, "hgl_tag", "click item: " + historyItem.name, (Throwable) null, "com.didi.payment.transfer.records.TransOrderRecordsActivity$2", 84);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).handleItemClick(historyItem);
            }
        });
        this.f31485c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f31485c.setAdapter(this.f31488f);
        m22252b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m22250a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
    }

    /* renamed from: a */
    private void m22250a() {
        this.f31489g = getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 606);
        ((ITransRecordPresenter) this.mPresenter).loadHistoryData(true);
    }

    /* renamed from: b */
    private void m22252b() {
        this.f31484b.setLeftImage(ResourcesHelper.getDrawable(this, R.drawable.one_payment_creditcard_global_btn_title_back_selector), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).handleBackClick();
            }
        });
        this.f31484b.setTitle(getResources().getString(R.string.GRider_PAX_Transfers_records_IXzB));
    }

    public void appendHistoryItem(TransHistoryListResp.DataModel dataModel) {
        this.f31485c.setVisibility(0);
        this.f31488f.addData(dataModel.orders);
    }

    public void pageFinish() {
        finish();
    }

    public void showEmptyView(int i) {
        this.f31485c.setVisibility(8);
        this.f31486d.setVisibility(0);
        this.f31486d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (TransOrderRecordsActivity.this.mPresenter != null) {
                    ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadHistoryData(true);
                }
            }
        });
        this.f31487e.setText(i);
    }

    /* access modifiers changed from: protected */
    public ITransRecordPresenter onCreatePresenter() {
        return new TransRecordPresenter(this, this);
    }
}

package com.didi.payment.pix.orderhistory;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.response.PixOrderHistoryListResp;
import com.didi.payment.pix.orderhistory.p137vm.PixOrderHistoryVM;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0014J\u0010\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/payment/pix/orderhistory/PixOrderHistoryActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM;", "()V", "mAdapter", "Lcom/didi/payment/pix/orderhistory/PixHistoryLvAdapter;", "mListEmptyLayout", "Landroid/view/View;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "mTvEmpty", "Landroid/widget/TextView;", "noMoreItemsTv", "getTitleBarView", "initContentView", "", "initData", "initTitleBar", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInflateContentLayout", "", "onResume", "showEmptyView", "id", "showNoMoreItem", "show", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOrderHistoryActivity.kt */
public class PixOrderHistoryActivity extends WBaseActivity<PixOrderHistoryVM> {

    /* renamed from: a */
    private TextView f31123a;

    /* renamed from: b */
    private CommonTitleBar f31124b;

    /* renamed from: c */
    private RecyclerView f31125c;

    /* renamed from: d */
    private View f31126d;

    /* renamed from: e */
    private TextView f31127e;

    /* renamed from: f */
    private PixHistoryLvAdapter f31128f;

    public int onInflateContentLayout() {
        return R.layout.pix_order_history_root_lay;
    }

    public static final /* synthetic */ PixOrderHistoryVM access$getVm(PixOrderHistoryActivity pixOrderHistoryActivity) {
        return (PixOrderHistoryVM) pixOrderHistoryActivity.getVm();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f31124b;
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m21889b();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_history_sw");
    }

    public void initContentView() {
        super.initContentView();
        m21882a();
    }

    public void initTitleBar() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.pix_transfer_history_titlebar);
        this.f31124b = commonTitleBar;
        if (commonTitleBar != null) {
            commonTitleBar.setLeftBackListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixOrderHistoryActivity.m21884a(PixOrderHistoryActivity.this, view);
                }
            });
        }
        CommonTitleBar commonTitleBar2 = this.f31124b;
        if (commonTitleBar2 != null) {
            commonTitleBar2.setTitle(getString(R.string.CS_payment_History_Details_vCjc));
        }
        CommonTitleBar commonTitleBar3 = this.f31124b;
        if (commonTitleBar3 != null) {
            decoretaTitlebar(commonTitleBar3);
            View findViewById = commonTitleBar3.findViewById(R.id.title_bar_layout_above);
            if (findViewById != null) {
                findViewById.setBackgroundColor(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21884a(PixOrderHistoryActivity pixOrderHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryActivity, "this$0");
        pixOrderHistoryActivity.finish();
    }

    /* renamed from: a */
    private final void m21882a() {
        this.f31125c = (RecyclerView) findViewById(R.id.trans_history_ry);
        this.f31126d = findViewById(R.id.trans_history_empty_layout);
        this.f31127e = (TextView) findViewById(R.id.trans_history_empty_tv);
        this.f31123a = (TextView) findViewById(R.id.no_more_orders_tv);
        ViewModelStoreOwner viewModelStoreOwner = this;
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner).get(PixOrderHistoryVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…derHistoryVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        LifecycleOwner lifecycleOwner = this;
        ((PixOrderHistoryVM) getVm()).getOnItemClickListener().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderHistoryActivity.m21885a(PixOrderHistoryActivity.this, (PixOrderHistoryListResp.OrderItem) obj);
            }
        });
        ((PixOrderHistoryVM) getVm()).getEndOfListWatcher().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderHistoryActivity.m21886a(PixOrderHistoryActivity.this, (Boolean) obj);
            }
        });
        ((PixOrderHistoryVM) getVm()).getNextPageOrders().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderHistoryActivity.m21887a(PixOrderHistoryActivity.this, (List) obj);
            }
        });
        Context context = this;
        this.f31128f = new PixHistoryLvAdapter(context, viewModelStoreOwner);
        RecyclerView recyclerView = this.f31125c;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerView recyclerView2 = this.f31125c;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(this.f31128f);
        initTitleBar();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21885a(PixOrderHistoryActivity pixOrderHistoryActivity, PixOrderHistoryListResp.OrderItem orderItem) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_history_ck", "order_id", orderItem.orderId);
        ((Request) DRouter.build(PixRouter.build("/pix_order_detail")).putExtra("order_id", orderItem.orderId)).start(pixOrderHistoryActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21886a(PixOrderHistoryActivity pixOrderHistoryActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "reachEndOfListView");
        if (bool.booleanValue()) {
            ((PixOrderHistoryVM) pixOrderHistoryActivity.getVm()).loadNextPage();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21887a(PixOrderHistoryActivity pixOrderHistoryActivity, List list) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryActivity, "this$0");
        Integer num = null;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            PixHistoryLvAdapter pixHistoryLvAdapter = pixOrderHistoryActivity.f31128f;
            Integer valueOf = pixHistoryLvAdapter == null ? null : Integer.valueOf(pixHistoryLvAdapter.getItemCount());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() <= 0) {
                pixOrderHistoryActivity.m21888a(true);
                return;
            }
        }
        RecyclerView recyclerView = pixOrderHistoryActivity.f31125c;
        Intrinsics.checkNotNull(recyclerView);
        if (recyclerView.getVisibility() != 0) {
            RecyclerView recyclerView2 = pixOrderHistoryActivity.f31125c;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setVisibility(0);
        }
        PixHistoryLvAdapter pixHistoryLvAdapter2 = pixOrderHistoryActivity.f31128f;
        if (pixHistoryLvAdapter2 != null) {
            pixHistoryLvAdapter2.appendOrderData(list);
        }
        PixHistoryLvAdapter pixHistoryLvAdapter3 = pixOrderHistoryActivity.f31128f;
        if (pixHistoryLvAdapter3 != null) {
            num = Integer.valueOf(pixHistoryLvAdapter3.getItemCount());
        }
        Intrinsics.checkNotNull(num);
        if (num.intValue() < 20) {
            UiThreadHandler.post(new Runnable() {
                public final void run() {
                    PixOrderHistoryActivity.m21883a(PixOrderHistoryActivity.this);
                }
            });
        } else {
            pixOrderHistoryActivity.m21888a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21883a(PixOrderHistoryActivity pixOrderHistoryActivity) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryActivity, "this$0");
        Context context = pixOrderHistoryActivity;
        int screenHeight = UIUtils.getScreenHeight(context);
        int dip2px = UIUtils.dip2px(context, 30.0f);
        RecyclerView recyclerView = pixOrderHistoryActivity.f31125c;
        Intrinsics.checkNotNull(recyclerView);
        if (recyclerView.getBottom() < screenHeight - dip2px) {
            pixOrderHistoryActivity.m21888a(true);
        } else {
            SystemUtils.log(3, "pix_transfer", "bottom out of screen.", (Throwable) null, "com.didi.payment.pix.orderhistory.PixOrderHistoryActivity", 119);
        }
    }

    /* renamed from: a */
    private final void m21888a(boolean z) {
        if (z) {
            TextView textView = this.f31123a;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView2 = this.f31123a;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
    }

    /* renamed from: b */
    private final void m21889b() {
        ((PixOrderHistoryVM) getVm()).loadHistoryData(true);
    }

    public final void showEmptyView(int i) {
        RecyclerView recyclerView = this.f31125c;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(8);
        View view = this.f31126d;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        View view2 = this.f31126d;
        Intrinsics.checkNotNull(view2);
        view2.setOnClickListener(new PixOrderHistoryActivity$showEmptyView$1(this));
        TextView textView = this.f31127e;
        Intrinsics.checkNotNull(textView);
        textView.setText(i);
    }
}

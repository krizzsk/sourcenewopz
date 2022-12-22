package com.didi.payment.wallet.global.wallet.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.utils.WalletDateUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalanceHistoryPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletNewBalanceHistoryAdapter;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletTopUpOmegaUtil;
import com.didi.payment.wallet.global.wallet.view.widget.BalanceDateDialogFragment;
import com.didi.payment.wallet.global.wallet.view.widget.BalanceTypeDialogFragment;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.greenrobot.eventbus.EventBus;

public class WalletNewBalanceHistoryFragment extends Fragment implements WalletNewBalanceHistoryContract.View {

    /* renamed from: a */
    final LinearLayoutManager f32346a = new LinearLayoutManager(this.f32355j);

    /* renamed from: b */
    BalanceDateDialogFragment f32347b;

    /* renamed from: c */
    BalanceTypeDialogFragment f32348c;

    /* renamed from: d */
    WalletBalanceOption f32349d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletNewBalanceHistoryContract.Presenter f32350e;

    /* renamed from: f */
    private RecyclerView f32351f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f32352g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f32353h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletNewBalanceHistoryAdapter f32354i;

    /* renamed from: j */
    private FragmentActivity f32355j;

    /* renamed from: k */
    private SmartRefreshLayout f32356k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletDateUtil f32357l = new WalletDateUtil();
    public List<WalletBalanceOption> walletBalanceOptionsList = new ArrayList();

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32355j = getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_new_balance_history, viewGroup, false);
        m22971a(inflate);
        WalletNewBalanceHistoryPresenter walletNewBalanceHistoryPresenter = new WalletNewBalanceHistoryPresenter(this.f32355j, this, this.f32356k);
        this.f32350e = walletNewBalanceHistoryPresenter;
        walletNewBalanceHistoryPresenter.init();
        BalanceDateDialogFragment.Companion.init();
        return inflate;
    }

    /* renamed from: a */
    private void m22971a(View view) {
        this.f32351f = (RecyclerView) view.findViewById(R.id.rv_wallet_new_balance_history_list);
        TextView textView = (TextView) view.findViewById(R.id.tv_balanceTopDate);
        this.f32352g = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "walletbalance");
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_timefilter_ck", hashMap);
                WalletNewBalanceHistoryFragment.this.m22970a();
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.tv_balanceTopAll);
        this.f32353h = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "walletbalance");
                hashMap.put("button_name", ParamKeys.PARAM_COMPLAIN_ENTRY);
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_typefilter_ck", hashMap);
                WalletNewBalanceHistoryFragment.this.m22973b();
            }
        });
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.srl_balance);
        this.f32356k = smartRefreshLayout;
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout refreshLayout) {
                long nextMonth = WalletNewBalanceHistoryFragment.this.f32357l.getNextMonth();
                WalletNewBalanceHistoryFragment.this.f32354i.defaultDate = WalletNewBalanceHistoryFragment.this.f32357l.getDateStr();
                WalletNewBalanceHistoryFragment.this.f32352g.setText(WalletNewBalanceHistoryFragment.this.f32357l.getDateStr());
                WalletNewBalanceHistoryFragment.this.f32350e.requestNextData(nextMonth);
            }
        });
        this.f32356k.setOnLoadMoreListener(new OnLoadMoreListener() {
            public void onLoadMore(RefreshLayout refreshLayout) {
                WalletNewBalanceHistoryFragment.this.f32350e.requestData();
            }
        });
        this.f32346a.setOrientation(1);
        this.f32351f.setLayoutManager(this.f32346a);
        this.f32351f.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.f32355j, 1);
        dividerItemDecoration.setDrawable(ResourcesHelper.getDrawable(this.f32355j, R.drawable.wallet_balance_history_list_divider));
        this.f32351f.addItemDecoration(dividerItemDecoration);
        WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = new WalletNewBalanceHistoryAdapter(this.f32355j);
        this.f32354i = walletNewBalanceHistoryAdapter;
        walletNewBalanceHistoryAdapter.defaultDate = this.f32357l.getDefaultDate();
        this.f32351f.setAdapter(this.f32354i);
        this.f32351f.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                WalletNewBalanceHistoryFragment.this.f32354i.updateTopItemIndex(WalletNewBalanceHistoryFragment.this.f32346a.findFirstVisibleItemPosition());
                WalletNewBalanceHistoryFragment.this.f32352g.setText(WalletNewBalanceHistoryFragment.this.f32354i.getTopItemDate());
            }
        });
        this.f32354i.setLoadMore(new WalletNewBalanceHistoryAdapter.ILoadMore() {
            public void onLoadMore() {
                WalletNewBalanceHistoryFragment.this.f32354i.removeAtIndex(WalletNewBalanceHistoryFragment.this.f32354i.getBankBalanceItems().size() - 1);
                WalletNewBalanceHistoryFragment.this.f32354i.addItem((WalletNewBalanceHistoryAdapter.HistoryItem) null);
                WalletNewBalanceHistoryFragment.this.f32350e.requestData();
            }
        });
        this.f32354i.setRetryCallback(new WalletNewBalanceHistoryAdapter.INetworkErrorRetry() {
            public void onRetry() {
                WalletNewBalanceHistoryFragment.this.f32350e.retryRequestData();
            }
        });
    }

    public void showLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = true;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void dismissLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = false;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void onNetworkError() {
        this.f32354i.clearAllItems();
        ArrayList arrayList = new ArrayList();
        this.f32356k.setEnableLoadMore(false);
        arrayList.add(m22969a(7, (WalletBalanceHistoryResp.StatementBean) null));
        this.f32354i.addItemList(arrayList);
    }

    public void onBalanceDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z, WalletBalanceHistoryResp.TopUpBtn topUpBtn) {
        this.f32354i.setTipsInfo(topUpBtn);
        ArrayList arrayList = new ArrayList();
        if (list.size() == 0) {
            this.f32352g.setText(this.f32354i.defaultDate);
            this.f32356k.setEnableLoadMore(false);
            arrayList.add(m22969a(6, (WalletBalanceHistoryResp.StatementBean) null));
            this.f32354i.addEmptyItem(arrayList);
            return;
        }
        this.f32356k.setEnableLoadMore(true);
        for (int i = 0; i < list.size(); i++) {
            WalletBalanceHistoryResp.StatementBean statementBean = list.get(i);
            if (statementBean != null) {
                arrayList.add(m22969a(2, statementBean));
            }
        }
        this.f32354i.resetItemList(arrayList, this.f32357l);
        this.f32352g.setText(this.f32354i.getTopItemDate());
    }

    public void onBalanceMoreDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(m22969a(2, list.get(i)));
        }
        WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = this.f32354i;
        walletNewBalanceHistoryAdapter.removeAtIndex(walletNewBalanceHistoryAdapter.getBankBalanceItems().size() - 1);
        if (z) {
            arrayList.add(m22969a(3, (WalletBalanceHistoryResp.StatementBean) null));
        } else {
            arrayList.add(m22969a(5, (WalletBalanceHistoryResp.StatementBean) null));
        }
        this.f32354i.addItemList(arrayList);
    }

    public void onBalanceOptionSuccessful(List<WalletBalanceOption> list) {
        this.walletBalanceOptionsList.clear();
        this.walletBalanceOptionsList.addAll(list);
    }

    /* renamed from: a */
    private WalletNewBalanceHistoryAdapter.HistoryItem m22969a(int i, WalletBalanceHistoryResp.StatementBean statementBean) {
        return new WalletNewBalanceHistoryAdapter.HistoryItem(i, statementBean);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22970a() {
        if (this.f32347b == null) {
            this.f32347b = new BalanceDateDialogFragment();
        }
        if (!this.f32347b.isAdded()) {
            this.f32347b.show(getChildFragmentManager(), "dialogDataBuilder");
            this.f32347b.addOnSelectListener(new Function2<Long, String, Unit>() {
                public Unit invoke(Long l, String str) {
                    WalletNewBalanceHistoryFragment.this.f32357l.setTime(l.longValue());
                    WalletNewBalanceHistoryFragment.this.f32354i.defaultDate = str;
                    WalletNewBalanceHistoryFragment.this.f32352g.setText(WalletNewBalanceHistoryFragment.this.f32354i.defaultDate);
                    WalletNewBalanceHistoryFragment.this.f32350e.onSelectedBalanceTime(l.longValue());
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22973b() {
        if (!this.walletBalanceOptionsList.isEmpty()) {
            if (this.f32348c == null) {
                this.f32348c = new BalanceTypeDialogFragment();
            }
            if (!this.f32348c.isAdded()) {
                this.f32348c.show(getChildFragmentManager(), "dialogTypeBuilder");
                this.f32348c.setDate(this.walletBalanceOptionsList, this.f32349d);
                this.f32348c.addOnSelectListener(new Function1<WalletBalanceOption, Unit>() {
                    public Unit invoke(WalletBalanceOption walletBalanceOption) {
                        WalletNewBalanceHistoryFragment.this.f32349d = walletBalanceOption;
                        String label = walletBalanceOption.getLabel();
                        if (label != null && !label.isEmpty()) {
                            WalletNewBalanceHistoryFragment.this.f32353h.setText(label);
                            HashMap hashMap = new HashMap();
                            hashMap.put("pub_page", "walletbalance");
                            hashMap.put("button_name", label);
                            WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_typefilter_ck", hashMap);
                        }
                        WalletNewBalanceHistoryFragment.this.f32350e.onSelectedBalanceOption(walletBalanceOption);
                        return null;
                    }
                });
            }
        }
    }
}

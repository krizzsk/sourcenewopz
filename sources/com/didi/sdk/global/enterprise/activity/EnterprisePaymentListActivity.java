package com.didi.sdk.global.enterprise.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.enterprise.adapter.EnterprisePaymentListAdapter;
import com.didi.sdk.global.enterprise.contract.EnterprisePaymentListContract;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import com.didi.sdk.global.enterprise.presenter.EnterprisePaymentListPresenter;
import com.didi.sdk.global.indexbar.Decoration.DividerItemDecoration;
import com.didi.sdk.global.indexbar.Decoration.GroupItemDecoration;
import com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener;
import com.didi.sdk.global.indexbar.utils.SortUtil;
import com.didi.sdk.global.indexbar.widget.SearchView;
import com.didi.sdk.global.indexbar.widget.SideBar;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class EnterprisePaymentListActivity extends FragmentActivity implements EnterprisePaymentListContract.View {
    public static final String EXTRA_LAUNCH_TYPE = "LAUNCH_TYPE";
    public static final String EXTRA_RESULT = "RESULT";
    public static final int LAUNCH_TYPE_COMPANY_LIST = 1;
    public static final int LAUNCH_TYPE_COST_CENTER_LIST = 2;
    public static final int LAUNCH_TYPE_PROJECT_LIST = 3;

    /* renamed from: a */
    private static final String f36123a = "PHONE_NUMBER";

    /* renamed from: b */
    private static final String f36124b = "CAR_LEVEL";

    /* renamed from: c */
    private static final String f36125c = "MEMBER_ID";

    /* renamed from: d */
    private static final String f36126d = "COMPANY_ID";

    /* renamed from: e */
    private static final String f36127e = "COST_CENTER_ID";

    /* renamed from: f */
    private static final String f36128f = "COST_CHECKED_ID";

    /* renamed from: A */
    private String f36129A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public List<EnterpriseItem> f36130B;

    /* renamed from: g */
    private TextView f36131g;

    /* renamed from: h */
    private ImageView f36132h;

    /* renamed from: i */
    private RecyclerView f36133i;

    /* renamed from: j */
    private SideBar f36134j;

    /* renamed from: k */
    private SearchView f36135k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f36136l;

    /* renamed from: m */
    private TextView f36137m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f36138n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f36139o;

    /* renamed from: p */
    private RecyclerView.ItemDecoration f36140p;

    /* renamed from: q */
    private RecyclerView.ItemDecoration f36141q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public LinearLayoutManager f36142r;

    /* renamed from: s */
    private EnterprisePaymentListAdapter f36143s;

    /* renamed from: t */
    private EnterprisePaymentListContract.Presenter f36144t;

    /* renamed from: u */
    private int f36145u = 1;

    /* renamed from: v */
    private String f36146v;

    /* renamed from: w */
    private String f36147w;

    /* renamed from: x */
    private String f36148x;

    /* renamed from: y */
    private String f36149y;

    /* renamed from: z */
    private String f36150z;

    public static class LaunchInfo {
        public String carLevel;
        public String checkedId;
        public String companyId;
        public String costCenterId;
        public int launchType;
        public String memberId;
        public String phoneNumber;
        public int requestCode;
    }

    /* renamed from: a */
    private int m25524a(int i) {
        return i != 2 ? i != 3 ? R.string.one_payment_global_enterprise_company_list_title : R.string.one_payment_global_enterprise_project_list_title : R.string.one_payment_global_enterprise_cost_center_list_title;
    }

    public Context getContext() {
        return this;
    }

    public static void launch(Activity activity, LaunchInfo launchInfo) {
        Intent intent = new Intent(activity, EnterprisePaymentListActivity.class);
        intent.putExtra(EXTRA_LAUNCH_TYPE, launchInfo.launchType);
        intent.putExtra(f36123a, launchInfo.phoneNumber);
        intent.putExtra(f36124b, launchInfo.carLevel);
        intent.putExtra(f36125c, launchInfo.memberId);
        intent.putExtra(f36126d, launchInfo.companyId);
        intent.putExtra(f36127e, launchInfo.costCenterId);
        intent.putExtra(f36128f, launchInfo.checkedId);
        activity.startActivityForResult(intent, launchInfo.requestCode);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m25528a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_in_from_right, R.anim.one_payment_out_to_left);
        setContentView((int) R.layout.one_payment_activity_enterprise_payment_list);
        m25531b();
        LoggerFactory.getLogger("Enterprise").info(">> onCreate, %d", Integer.valueOf(this.f36145u));
        m25534c();
        m25538e();
        m25539f();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.one_payment_in_from_left, R.anim.one_payment_out_to_right);
    }

    /* renamed from: a */
    private void m25528a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: b */
    private void m25531b() {
        this.f36145u = getIntent().getIntExtra(EXTRA_LAUNCH_TYPE, 1);
        this.f36146v = getIntent().getStringExtra(f36123a);
        this.f36147w = getIntent().getStringExtra(f36124b);
        this.f36148x = getIntent().getStringExtra(f36125c);
        this.f36149y = getIntent().getStringExtra(f36126d);
        this.f36150z = getIntent().getStringExtra(f36127e);
        this.f36129A = getIntent().getStringExtra(f36128f);
        this.f36144t = new EnterprisePaymentListPresenter(this);
    }

    /* renamed from: c */
    private void m25534c() {
        m25536d();
        EnterprisePaymentListAdapter enterprisePaymentListAdapter = new EnterprisePaymentListAdapter();
        this.f36143s = enterprisePaymentListAdapter;
        enterprisePaymentListAdapter.setItemSelectListener(new EnterprisePaymentListAdapter.OnItemSelectListener() {
            public void onItemSelect(int i, EnterpriseItem enterpriseItem, boolean z) {
                if (!z) {
                    Intent intent = new Intent();
                    intent.putExtra(EnterprisePaymentListActivity.EXTRA_RESULT, (Serializable) enterpriseItem.getBean());
                    EnterprisePaymentListActivity.this.setResult(-1, intent);
                }
                EnterprisePaymentListActivity.this.finish();
            }
        });
        this.f36142r = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.f36133i = recyclerView;
        recyclerView.setLayoutManager(this.f36142r);
        this.f36133i.setAdapter(this.f36143s);
        this.f36136l = findViewById(R.id.layout_retry);
        TextView textView = (TextView) findViewById(R.id.tv_retry);
        this.f36137m = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.this.f36136l.setVisibility(8);
                EnterprisePaymentListActivity.this.m25538e();
            }
        });
        this.f36138n = findViewById(R.id.layout_search_no_result);
        this.f36139o = (TextView) findViewById(R.id.tv_search_no_result);
        this.f36134j = (SideBar) findViewById(R.id.side_bar);
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        this.f36135k = searchView;
        searchView.setOnSearchListener(new SearchView.OnSearchListener() {
            public void onSearch(String str) {
                if (TextUtils.isEmpty(str)) {
                    EnterprisePaymentListActivity.this.f36138n.setVisibility(8);
                    EnterprisePaymentListActivity enterprisePaymentListActivity = EnterprisePaymentListActivity.this;
                    enterprisePaymentListActivity.m25530a((List<EnterpriseItem>) enterprisePaymentListActivity.f36130B, true);
                    return;
                }
                EnterprisePaymentListActivity enterprisePaymentListActivity2 = EnterprisePaymentListActivity.this;
                List a = enterprisePaymentListActivity2.m25527a((List<EnterpriseItem>) enterprisePaymentListActivity2.f36130B, str);
                EnterprisePaymentListActivity.this.m25530a((List<EnterpriseItem>) a, false);
                if (a == null || a.isEmpty()) {
                    EnterprisePaymentListActivity.this.f36138n.setVisibility(0);
                    EnterprisePaymentListActivity.this.f36139o.setText(EnterprisePaymentListActivity.this.getString(R.string.one_payment_global_enterprise_list_no_result, new Object[]{str}));
                    return;
                }
                EnterprisePaymentListActivity.this.f36138n.setVisibility(8);
            }
        });
    }

    /* renamed from: d */
    private void m25536d() {
        this.f36131g = (TextView) findViewById(R.id.tv_title);
        this.f36132h = (ImageView) findViewById(R.id.iv_left);
        this.f36131g.setText(m25524a(this.f36145u));
        this.f36132h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.this.m25542g();
                EnterprisePaymentListActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m25538e() {
        showLoadingDialog(getString(R.string.one_payment_global_net_toast_loading));
        int i = this.f36145u;
        if (i == 2) {
            this.f36144t.requestCostCenterList(this.f36148x, this.f36149y);
        } else if (i != 3) {
            this.f36144t.requestCompanyList(this.f36146v, this.f36147w);
        } else {
            this.f36144t.requestProjectList(this.f36148x, this.f36149y, this.f36150z);
        }
    }

    public void showToast(String str) {
        if (str.length() > 20) {
            ToastHelper.showLongInfo((Context) this, str);
        } else {
            ToastHelper.showShortInfo((Context) this, str);
        }
    }

    public void showLoadingDialog(String str) {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void refreshList(List<EnterpriseItem> list) {
        dismissLoadingDialog();
        this.f36130B = list;
        if (list == null) {
            LoggerFactory.getLogger("Enterprise").info("refreshList, network error", new Object[0]);
            this.f36137m.setText(R.string.one_payment_global_net_toast_connectionerror);
            this.f36136l.setVisibility(0);
            this.f36135k.setVisibility(8);
            this.f36134j.setVisibility(8);
        } else if (list.isEmpty()) {
            LoggerFactory.getLogger("Enterprise").info("refreshList, list empty", new Object[0]);
            this.f36137m.setText(R.string.one_payment_global_enterprise_list_empty);
            this.f36136l.setVisibility(0);
            this.f36135k.setVisibility(8);
            this.f36134j.setVisibility(8);
        } else {
            SortUtil.sort(list);
            m25530a(list, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25530a(List<EnterpriseItem> list, boolean z) {
        if (list != null) {
            this.f36135k.setVisibility(0);
            this.f36133i.removeItemDecoration(this.f36140p);
            this.f36133i.removeItemDecoration(this.f36141q);
            if (z) {
                List<String> groups = SortUtil.getGroups(list);
                this.f36140p = new GroupItemDecoration(this, groups);
                this.f36141q = new DividerItemDecoration(this, groups);
                this.f36133i.addItemDecoration(this.f36140p);
                this.f36133i.addItemDecoration(this.f36141q);
                this.f36134j.setVisibility(0);
                this.f36134j.setOnSideBarTouchListener(groups, new OnSideBarTouchListener() {
                    public void onTouchEnd() {
                    }

                    public void onTouch(String str, int i) {
                        if (i != -1) {
                            EnterprisePaymentListActivity.this.f36142r.scrollToPositionWithOffset(i, 0);
                        }
                    }
                });
            } else {
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this);
                this.f36141q = dividerItemDecoration;
                this.f36133i.addItemDecoration(dividerItemDecoration);
                this.f36134j.setVisibility(8);
                this.f36134j.setOnSideBarTouchListener((List<String>) null, (OnSideBarTouchListener) null);
            }
            this.f36143s.refresh(list, this.f36129A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<EnterpriseItem> m25527a(List<EnterpriseItem> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (EnterpriseItem next : list) {
            if (next.getName() != null && next.getName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m25539f() {
        int i = this.f36145u;
        if (i == 1) {
            GlobalOmegaUtils.trackEnterpriseCompanyListSW(this);
        } else if (i == 2) {
            GlobalOmegaUtils.trackEnterpriseCostcenterListSW(this);
        } else if (i == 3) {
            GlobalOmegaUtils.trackEnterpriseProjectListSW(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m25542g() {
        int i = this.f36145u;
        if (i == 1) {
            GlobalOmegaUtils.trackEnterpriseCompanyListBackCK(this);
        } else if (i == 2) {
            GlobalOmegaUtils.trackEnterpriseCostcenterListBackCK(this);
        } else if (i == 3) {
            GlobalOmegaUtils.trackEnterpriseProjectListBackCK(this);
        }
    }
}

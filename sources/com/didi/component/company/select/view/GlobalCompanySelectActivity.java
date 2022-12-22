package com.didi.component.company.select.view;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.presenter.GlobalCompanySelectPresenter;
import com.didi.component.company.select.presenter.ICompanySelectPresenter;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.indexbar.Decoration.DividerItemDecoration;
import com.taxis99.R;
import java.util.List;

public class GlobalCompanySelectActivity extends AbsLoadingActivity implements ICompanySelectView {
    public static final String DATA_EXTRA_COMPANY_ID = "company_id";
    public static final String DATA_EXTRA_SELECTED_COMPANY_INFO = "company_info";
    public static final String DATA_EXTRA_SHOW_DEFAULT = "show_default";
    public static final String DATA_EXTRA_START_LAT = "start_lat";
    public static final String DATA_EXTRA_START_LNG = "start_lng";

    /* renamed from: a */
    private ICompanySelectPresenter f12571a;

    /* renamed from: b */
    private RecyclerView f12572b;

    /* renamed from: c */
    private CompanyListAdapter f12573c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m8557a();
        setContentView((int) R.layout.global_company_page);
        m8558b();
        m8559c();
        m8561e();
    }

    /* renamed from: a */
    private void m8557a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: b */
    private void m8558b() {
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCompanySelectActivity.this.onBackPressed();
            }
        });
        ((TextView) findViewById(R.id.tv_payment_method_title)).setText(R.string.global_company_select_title);
    }

    /* renamed from: c */
    private void m8559c() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_global_company_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.addItemDecoration(m8560d());
        CompanyListAdapter companyListAdapter = new CompanyListAdapter(this);
        this.f12573c = companyListAdapter;
        recyclerView.setAdapter(companyListAdapter);
        this.f12572b = recyclerView;
    }

    /* renamed from: d */
    private RecyclerView.ItemDecoration m8560d() {
        return new DividerItemDecoration(this);
    }

    /* renamed from: e */
    private void m8561e() {
        GlobalCompanySelectPresenter globalCompanySelectPresenter = new GlobalCompanySelectPresenter(this);
        this.f12571a = globalCompanySelectPresenter;
        globalCompanySelectPresenter.setView(this);
        this.f12571a.onAdd(getIntent().getExtras());
        this.f12573c.setPresenter(this.f12571a);
    }

    public View getFallbackView() {
        return findViewById(R.id.ll_global_company_title_container);
    }

    public void showCompanys(List<CompanyInfo> list, String str) {
        this.f12573c.update(list, str);
    }

    public void showDefault(boolean z) {
        this.f12573c.setShowDefault(z);
        if (!z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12572b.getLayoutParams();
            layoutParams.topMargin = 0;
            this.f12572b.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ICompanySelectPresenter iCompanySelectPresenter = this.f12571a;
        if (iCompanySelectPresenter != null) {
            iCompanySelectPresenter.onRemove();
        }
    }
}

package com.didi.map.global.flow.toolkit.nav;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.flow.toolkit.nav.VamosNavAdapter;
import com.didi.map.global.flow.utils.VamosNavUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class VamosNavSelectActivity extends Activity {

    /* renamed from: a */
    private static final String f27212a = VamosNavSelectActivity.class.getSimpleName();

    /* renamed from: b */
    private RecyclerView f27213b;

    /* renamed from: c */
    private ImageView f27214c;

    /* renamed from: d */
    private View f27215d;

    /* renamed from: e */
    private VamosNavAdapter f27216e;

    /* renamed from: f */
    private List<VamosNavModel> f27217f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
        }
        setContentView(R.layout.activity_vamos_nav_select);
        m19251a();
        m19254b();
    }

    /* renamed from: a */
    private void m19251a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_nav_main);
        this.f27213b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f27213b.addItemDecoration(new VamosNavHorizonDivider(this, R.drawable.nav_divider));
        this.f27214c = (ImageView) findViewById(R.id.iv_nav_close);
        this.f27215d = findViewById(R.id.v_empty_area);
    }

    /* renamed from: b */
    private void m19254b() {
        this.f27214c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VamosNavSelectActivity.this.m19255b(view);
            }
        });
        this.f27215d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VamosNavSelectActivity.this.m19252a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m19255b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19252a(View view) {
        finish();
    }

    /* renamed from: c */
    private void m19256c() {
        VamosNavAdapter vamosNavAdapter = new VamosNavAdapter(this, this.f27217f);
        this.f27216e = vamosNavAdapter;
        this.f27213b.setAdapter(vamosNavAdapter);
        this.f27216e.setOnNavItemClickListener(new VamosNavAdapter.OnNavItemClickListener() {
            public final void onNavItemClicked(VamosNavModel vamosNavModel) {
                VamosNavSelectActivity.this.m19253a(vamosNavModel);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19253a(VamosNavModel vamosNavModel) {
        if (vamosNavModel != null) {
            if (vamosNavModel.isInstalled) {
                VamosNavUtils.sCurChoice = vamosNavModel.pkgName;
                VamosNavUtils.startNavDirectly(this);
                VamosNavUtils.trackEventClickNavBtn(0);
            } else {
                VamosNavUtils.goToGooglePlay(this, vamosNavModel.pkgName);
            }
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        List<VamosNavModel> curNavAppList = VamosNavUtils.getCurNavAppList(this);
        this.f27217f = curNavAppList;
        VamosNavAdapter vamosNavAdapter = this.f27216e;
        if (vamosNavAdapter == null) {
            m19256c();
            return;
        }
        vamosNavAdapter.setDataList(curNavAppList);
        this.f27216e.notifyDataSetChanged();
    }
}

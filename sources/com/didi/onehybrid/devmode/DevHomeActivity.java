package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.onehybrid.FusionWebActivity;
import com.didi.onehybrid.resource.FusionCacheClient;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.util.C10393Util;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Map;

public class DevHomeActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private static final String f29534a = "xxx";

    /* renamed from: b */
    private FusionRuntimeInfo f29535b;

    /* renamed from: c */
    private View f29536c;

    /* renamed from: d */
    private View f29537d;

    /* renamed from: e */
    private TextView f29538e;

    /* renamed from: f */
    private TextView f29539f;

    /* renamed from: g */
    private View f29540g;

    /* renamed from: h */
    private TextView f29541h;

    /* renamed from: i */
    private TextView f29542i;

    /* renamed from: j */
    private View f29543j;

    /* renamed from: k */
    private TextView f29544k;

    /* renamed from: l */
    private TextView f29545l;

    /* renamed from: m */
    private View f29546m;

    /* renamed from: n */
    private TextView f29547n;

    /* renamed from: o */
    private TextView f29548o;

    /* renamed from: p */
    private View f29549p;

    /* renamed from: q */
    private TextView f29550q;

    /* renamed from: r */
    private TextView f29551r;

    /* renamed from: s */
    private View f29552s;

    /* renamed from: t */
    private TextView f29553t;

    /* renamed from: u */
    private TextView f29554u;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_home);
        this.f29535b = (FusionRuntimeInfo) getIntent().getSerializableExtra("fusionRuntimeInfo");
        m20792a();
    }

    /* renamed from: a */
    private void m20792a() {
        View findViewById = findViewById(R.id.title_back);
        this.f29536c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevHomeActivity.this.finish();
            }
        });
        View findViewById2 = findViewById(R.id.render_info);
        this.f29537d = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f29538e = (TextView) findViewById(R.id.render_info_text);
        this.f29539f = (TextView) findViewById(R.id.render_info_time);
        m20793b();
        View findViewById3 = findViewById(R.id.offline_bundle);
        this.f29540g = findViewById3;
        findViewById3.setOnClickListener(this);
        this.f29541h = (TextView) findViewById(R.id.offline_bundle_text);
        this.f29542i = (TextView) findViewById(R.id.offline_bundle_size);
        m20794c();
        View findViewById4 = findViewById(R.id.file_cache);
        this.f29543j = findViewById4;
        findViewById4.setOnClickListener(this);
        this.f29544k = (TextView) findViewById(R.id.file_cache_text);
        this.f29545l = (TextView) findViewById(R.id.file_cache_size);
        m20795d();
        View findViewById5 = findViewById(R.id.bridge_info);
        this.f29546m = findViewById5;
        findViewById5.setOnClickListener(this);
        this.f29547n = (TextView) findViewById(R.id.bridge_info_text);
        this.f29548o = (TextView) findViewById(R.id.bridge_info_count);
        m20796e();
        View findViewById6 = findViewById(R.id.total_offline);
        this.f29549p = findViewById6;
        findViewById6.setOnClickListener(this);
        this.f29550q = (TextView) findViewById(R.id.total_offline_text);
        this.f29551r = (TextView) findViewById(R.id.total_offline_size);
        m20797f();
        View findViewById7 = findViewById(R.id.fusion_test);
        this.f29552s = findViewById7;
        findViewById7.setOnClickListener(this);
        this.f29553t = (TextView) findViewById(R.id.fusion_test_title);
        this.f29554u = (TextView) findViewById(R.id.fusion_test_content);
        m20798g();
    }

    /* renamed from: b */
    private void m20793b() {
        this.f29538e.setText("渲染信息");
        TextView textView = this.f29539f;
        textView.setText(this.f29535b.getRenderInfo().totalTime + "ms >");
    }

    /* renamed from: c */
    private void m20794c() {
        this.f29541h.setText(String.format("当前页面离线包(%d个)", new Object[]{Integer.valueOf(this.f29535b.getRenderInfo().mBundles.size())}));
        this.f29542i.setText(C10393Util.smartConvert(this.f29535b.getRenderInfo().getOfflineSize()) + " >");
    }

    /* renamed from: d */
    private void m20795d() {
        this.f29544k.setText("文件缓存");
        long cacheFileSize = this.f29535b.getRenderInfo().getCacheFileSize(FusionCacheClient.getHybridDir());
        this.f29545l.setText(C10393Util.smartConvert(cacheFileSize) + " >");
    }

    /* renamed from: e */
    private void m20796e() {
        this.f29547n.setText("Bridge调用信息");
        TextView textView = this.f29548o;
        textView.setText(this.f29535b.getBridgeInfoMap().size() + "个 >");
    }

    /* renamed from: f */
    private void m20797f() {
        if (OfflineBundleManager.isInitialized()) {
            OfflineBundleManager.getInstance().getOfflineInfo(this.f29535b);
        }
        this.f29550q.setText(String.format("所有页面离线包(%d个)", new Object[]{Integer.valueOf(this.f29535b.getRenderInfo().bundles.size())}));
        long j = 0;
        for (Map.Entry<String, Long> value : this.f29535b.getRenderInfo().bundles.entrySet()) {
            j += ((Long) value.getValue()).longValue();
        }
        this.f29551r.setText(C10393Util.smartConvert(j));
    }

    /* renamed from: g */
    private void m20798g() {
        this.f29553t.setText("打开FusionBridge Demo页面(乘客端)");
        this.f29554u.setText(IMTextUtils.STREET_IMAGE_TAG_END);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.render_info) {
            Intent intent = new Intent(this, DevRenderInfoActivity.class);
            intent.putExtra("renderInfo", this.f29535b.getRenderInfo());
            startActivity(intent);
        } else if (id == R.id.bridge_info) {
            Intent intent2 = new Intent(this, DevBridgeInfoActivity.class);
            intent2.putExtra("fusionRuntimeInfo", this.f29535b);
            startActivity(intent2);
        } else if (id == R.id.offline_bundle) {
            Intent intent3 = new Intent(this, OfflineDetailActivity.class);
            intent3.putExtra(Const._FUSION_OFFLINE_CACHE_INFO, this.f29535b);
            startActivity(intent3);
        } else if (id == R.id.file_cache) {
            startActivity(new Intent(this, CacheDetailActivity.class));
        } else if (id == R.id.total_offline) {
            Intent intent4 = new Intent(this, TotalOfflineActivity.class);
            intent4.putExtra(Const._FUSION_ALL_OFFLINE_CACHE_INFO, this.f29535b);
            startActivity(intent4);
        } else if (id == R.id.fusion_test) {
            Intent intent5 = new Intent(this, FusionWebActivity.class);
            intent5.putExtra("url", f29534a);
            startActivity(intent5);
        }
    }
}

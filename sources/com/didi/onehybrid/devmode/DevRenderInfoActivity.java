package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class DevRenderInfoActivity extends Activity {

    /* renamed from: a */
    private FusionRuntimeInfo.RenderInfo f29555a;

    /* renamed from: b */
    private View f29556b;

    /* renamed from: c */
    private TextView f29557c;

    /* renamed from: d */
    private TextView f29558d;

    /* renamed from: e */
    private TextView f29559e;

    /* renamed from: f */
    private TextView f29560f;

    /* renamed from: g */
    private TextView f29561g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_render_info);
        this.f29555a = (FusionRuntimeInfo.RenderInfo) getIntent().getSerializableExtra("renderInfo");
        m20799a();
    }

    /* renamed from: a */
    private void m20799a() {
        View findViewById = findViewById(R.id.title_back);
        this.f29556b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevRenderInfoActivity.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.url_content);
        this.f29557c = textView;
        textView.setText(this.f29555a.reqUrl);
        TextView textView2 = (TextView) findViewById(R.id.render_time_content);
        this.f29558d = textView2;
        textView2.setText(this.f29555a.totalTime + "ms");
        this.f29559e = (TextView) findViewById(R.id.offline_bundle_content);
        if (this.f29555a.mBundles == null || this.f29555a.mBundles.isEmpty()) {
            this.f29559e.setText("------无------");
        } else {
            for (Map.Entry<String, HashMap<String, String>> value : this.f29555a.mBundles.entrySet()) {
                for (Map.Entry key : ((HashMap) value.getValue()).entrySet()) {
                    TextView textView3 = this.f29559e;
                    textView3.append(((String) key.getKey()) + "\n");
                }
            }
        }
        this.f29560f = (TextView) findViewById(R.id.file_cache_content);
        if (this.f29555a.fileCacheRes == null || this.f29555a.fileCacheRes.isEmpty()) {
            this.f29560f.setText("------无------");
        } else {
            for (String str : this.f29555a.fileCacheRes) {
                TextView textView4 = this.f29560f;
                textView4.append(str + "\n");
            }
        }
        this.f29561g = (TextView) findViewById(R.id.cdn_content);
        if (this.f29555a.cdnRes == null || this.f29555a.cdnRes.isEmpty()) {
            this.f29561g.setText("------无------");
            return;
        }
        for (String str2 : this.f29555a.cdnRes) {
            TextView textView5 = this.f29561g;
            textView5.append(str2 + "\n");
        }
    }
}

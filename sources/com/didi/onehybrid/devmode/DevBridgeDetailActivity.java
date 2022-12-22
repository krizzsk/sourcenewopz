package com.didi.onehybrid.devmode;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class DevBridgeDetailActivity extends Activity {

    /* renamed from: a */
    private FusionRuntimeInfo.BridgeInfo f29523a;

    /* renamed from: b */
    private View f29524b;

    /* renamed from: c */
    private TextView f29525c;

    /* renamed from: d */
    private TextView f29526d;

    /* renamed from: e */
    private TextView f29527e;

    /* renamed from: f */
    private TextView f29528f;

    /* renamed from: g */
    private TextView f29529g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_dev_bridge_detail);
        this.f29523a = (FusionRuntimeInfo.BridgeInfo) getIntent().getSerializableExtra("bridgeInfo");
        m20789a();
    }

    /* renamed from: a */
    private void m20789a() {
        View findViewById = findViewById(R.id.title_back);
        this.f29524b = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DevBridgeDetailActivity.this.finish();
            }
        });
        this.f29525c = (TextView) findViewById(R.id.call_pass_result);
        this.f29526d = (TextView) findViewById(R.id.bridge_version_content);
        this.f29527e = (TextView) findViewById(R.id.call_info_content);
        this.f29528f = (TextView) findViewById(R.id.call_args_content);
        this.f29529g = (TextView) findViewById(R.id.call_result_content);
        m20790b();
    }

    /* renamed from: b */
    private void m20790b() {
        if (this.f29523a.isRejected) {
            this.f29525c.setText("调用被拒绝");
            this.f29526d.setText("--------未知---------");
            this.f29527e.setText(this.f29523a.bridgeUrl);
            this.f29528f.setText("--------未知---------");
            this.f29529g.setText(this.f29523a.errMsg);
            return;
        }
        if (TextUtils.isEmpty(this.f29523a.errMsg)) {
            this.f29525c.setText("调用成功");
        } else {
            this.f29525c.setText("调用失败");
        }
        this.f29526d.setText(this.f29523a.bridgeVersion);
        TextView textView = this.f29527e;
        textView.setText(this.f29523a.moduleName + "." + this.f29523a.functionName);
        this.f29528f.setText(this.f29523a.args);
        if (!TextUtils.isEmpty(this.f29523a.callbackResult)) {
            this.f29529g.setText(this.f29523a.callbackResult);
        } else if (!TextUtils.isEmpty(this.f29523a.errMsg)) {
            this.f29529g.setText(this.f29523a.errMsg);
        } else {
            this.f29529g.setText("--------无响应信息---------");
        }
    }
}

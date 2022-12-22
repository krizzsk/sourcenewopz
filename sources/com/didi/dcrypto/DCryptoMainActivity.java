package com.didi.dcrypto;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class DCryptoMainActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_ENV = "env";
    public static final String KEY_EXTRA_TERMINAL_ID = "terminal_id";

    /* renamed from: c */
    private static final String f16385c = "https://help.didiglobal.com/processing-passenger-new.html?source=99pay&kfPageSource=99pay&pageSource=help_center_wallet";

    /* renamed from: a */
    private ImageView f16386a;

    /* renamed from: b */
    private ImageView f16387b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_d_crypto_main);
        ImageView imageView = (ImageView) findViewById(R.id.iv_crypto_activity_title_bar_left_img1);
        this.f16386a = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DCryptoMainActivity.this.m12007b(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_crypto_activity_customer_service);
        this.f16387b = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DCryptoMainActivity.this.m12006a(view);
            }
        });
        String str2 = "";
        if (getIntent().hasExtra("env")) {
            str = getIntent().getStringExtra("env");
            SystemUtils.log(4, "DCrypto params", "DCryptoMainActivity onCreate(): extra [env] is " + str, (Throwable) null, "com.didi.dcrypto.DCryptoMainActivity", 51);
        } else {
            SystemUtils.log(6, "DCrypto params", "DCryptoMainActivity onCreate(): extra [env] is EMPTY", (Throwable) null, "com.didi.dcrypto.DCryptoMainActivity", 53);
            str = str2;
        }
        if (getIntent().hasExtra("terminal_id")) {
            str2 = getIntent().getStringExtra("terminal_id");
            SystemUtils.log(4, "DCrypto params", "DCryptoMainActivity onCreate(): extra [terminal_id] is " + str2, (Throwable) null, "com.didi.dcrypto.DCryptoMainActivity", 57);
        } else {
            SystemUtils.log(6, "DCrypto params", "DCryptoMainActivity onCreate(): extra [terminal_id] is EMPTY", (Throwable) null, "com.didi.dcrypto.DCryptoMainActivity", 59);
        }
        DCryptoMainFragment dCryptoMainFragment = new DCryptoMainFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("env", str);
        bundle2.putString("terminal_id", str2);
        dCryptoMainFragment.setArguments(bundle2);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, dCryptoMainFragment).commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12007b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12006a(View view) {
        DRouter.build("https://help.didiglobal.com/processing-passenger-new.html?source=99pay&kfPageSource=99pay&pageSource=help_center_wallet").start(getApplicationContext());
    }
}

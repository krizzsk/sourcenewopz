package com.didi.dimina.starbox.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.container.webengine.webview.DMGeneralWebView;
import com.didi.sdk.apm.SystemUtils;

public class DiminaDemoActivity extends AppCompatActivity {

    /* renamed from: a */
    private final String f17998a = "ddb8b110573b9e4d8b";

    /* access modifiers changed from: protected */
    public int getContentId() {
        return 16908290;
    }

    public static void startDiminaDemoActivity(Context context) {
        Intent intent = new Intent(context, DiminaDemoActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        DMConfig4Di dMConfig4Di = new DMConfig4Di(this);
        dMConfig4Di.getLaunchConfig().setAppId("ddb8b110573b9e4d8b");
        dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new ReleaseBundleMangerStrategy());
        dMConfig4Di.getLaunchConfig().setEngineFactory(new DMConfig.EngineFactory() {
            public WebViewEngine createWebViewEngine(Activity activity) {
                return new DMGeneralWebView(activity);
            }

            public JSEngine createJSEngine() {
                return new DiminaEngine();
            }
        });
        Dimina.launch(this, dMConfig4Di, new DMNavigator(getSupportFragmentManager(), getContentId()));
    }

    public class DMNavigator extends DefaultDMNavigator {
        public DMNavigator(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        public boolean navigateBack(int i, int i2, int i3) {
            boolean navigateBack = super.navigateBack(i, i2, i3);
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                DiminaDemoActivity.this.finish();
            }
            return navigateBack;
        }

        public boolean closeDimina() {
            boolean closeDimina = super.closeDimina();
            if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
                DiminaDemoActivity.this.finish();
            }
            return closeDimina;
        }
    }
}

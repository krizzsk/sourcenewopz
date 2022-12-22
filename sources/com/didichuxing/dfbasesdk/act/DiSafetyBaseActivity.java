package com.didichuxing.dfbasesdk.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.sensor.SensorDelegate;
import com.didichuxing.dfbasesdk.touch.OnTouchDataListener;
import com.didichuxing.dfbasesdk.touch.TouchData;
import com.didichuxing.dfbasesdk.touch.TouchHandler;
import com.didichuxing.dfbasesdk.touch.TouchPage;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.DiSafetyLoading;
import java.util.List;

public abstract class DiSafetyBaseActivity extends FragmentActivity implements OnTouchDataListener {

    /* renamed from: a */
    private DiSafetyLoading f46485a;

    /* renamed from: b */
    private TouchHandler f46486b;
    protected boolean mRecreated;

    /* access modifiers changed from: protected */
    public boolean collectSensorsData() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean collectTouchData() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int getContentLayout();

    /* access modifiers changed from: protected */
    public int getThemeResId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean hideInput() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        return false;
    }

    public void onTouchData(List<TouchData> list) {
    }

    /* access modifiers changed from: protected */
    public abstract void setupSubViews();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        boolean z = true;
        requestWindowFeature(1);
        super.onCreate(bundle);
        initDataFromIntent(getIntent());
        if (fullScreen()) {
            getWindow().setFlags(1024, 1024);
        }
        int themeResId = getThemeResId();
        if (themeResId > 0) {
            setTheme(themeResId);
        }
        if (hideInput()) {
            getWindow().setSoftInputMode(2);
        }
        if (bundle == null) {
            z = false;
        }
        this.mRecreated = z;
        int contentLayout = getContentLayout();
        if (contentLayout != 0) {
            setContentView(contentLayout);
        }
        setupSubViews();
        if (needEventBus()) {
            BusUtils.register(this);
        }
    }

    @Deprecated
    public void showProgress() {
        getLoading().show();
    }

    @Deprecated
    public void hideProgress() {
        DiSafetyLoading diSafetyLoading = this.f46485a;
        if (diSafetyLoading != null) {
            diSafetyLoading.hide();
            this.f46485a = null;
        }
    }

    public DiSafetyLoading getLoading() {
        if (this.f46485a == null) {
            this.f46485a = new DiSafetyLoading(this);
        }
        return this.f46485a;
    }

    public void onBackPressed() {
        if (!onBackKeyIntercept()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (needEventBus()) {
            BusUtils.unregister(this);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (collectTouchData()) {
            if (this.f46486b == null) {
                TouchHandler touchHandler = new TouchHandler(this);
                this.f46486b = touchHandler;
                touchHandler.setPage(m33315a());
                this.f46486b.setMotionUpListener(this);
            }
            this.f46486b.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private TouchPage m33315a() {
        final String simpleName = getClass().getSimpleName();
        final View decorView = getWindow().getDecorView();
        return new TouchPage() {
            public String getPageName() {
                return simpleName;
            }

            public View getRootView() {
                return decorView;
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (collectSensorsData()) {
            SensorDelegate.onSdkPageStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (collectSensorsData()) {
            SensorDelegate.onSdkPageStop();
        }
    }
}

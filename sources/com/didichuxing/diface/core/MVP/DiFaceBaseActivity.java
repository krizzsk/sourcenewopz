package com.didichuxing.diface.core.MVP;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.custom_view.ProgressDialogFragment;
import com.taxis99.R;

public abstract class DiFaceBaseActivity extends FragmentActivity implements IView {

    /* renamed from: a */
    private static final String f47505a = "Act";
    protected ProgressDialogFragment mProgress;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return false;
    }

    public Context getVContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean hideInput() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean printLifeCycle() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean progressCancelable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_loading;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        }
        if (fullScreen()) {
            getWindow().setFlags(1024, 1024);
        }
        if (hideInput()) {
            getWindow().setSoftInputMode(2);
        }
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        this.mProgress = progressDialogFragment;
        progressDialogFragment.setContent(getResources().getString(progressMsgResId()), progressCancelable());
    }

    public void showProgress() {
        this.mProgress.show(getSupportFragmentManager(), "df_progress");
    }

    public void hideProgress() {
        this.mProgress.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, "onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, "onResume");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, "onPause");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, "onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, "onRestart");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (printLifeCycle()) {
            LogUtils.m33564d(f47505a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        }
    }

    public void onBackPressed() {
        makeFaceResult(new DiFaceResult(102));
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
        Intent intent = new Intent();
        intent.putExtra(DiFace.DIFACE_RESULT_KEY, diFaceResult);
        setResult(-1, intent);
    }

    public void finishWithResult(DiFaceResult diFaceResult) {
        makeFaceResult(diFaceResult);
        finish();
    }
}

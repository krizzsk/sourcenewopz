package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;

@Deprecated
public class ProgressbarActivity extends FragmentActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile ProgressbarActivity f46928a = null;

    /* renamed from: b */
    private static volatile boolean f46929b = false;

    /* renamed from: c */
    private static volatile String f46930c;
    protected ProgressDialogFragment mProgress;

    /* access modifiers changed from: protected */
    public boolean progressCancelable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_algo_model_loading;
    }

    public static void setProgressVisible(Context context, boolean z) {
        f46929b = z;
        if (z) {
            if (f46928a == null) {
                Intent intent = new Intent(context, ProgressbarActivity.class);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } else if (f46928a != null) {
            f46928a.finish();
        }
    }

    public static void setProgressVisible(Context context, boolean z, String str) {
        f46929b = z;
        f46930c = str;
        if (z) {
            if (f46928a == null) {
                Intent intent = new Intent(context, ProgressbarActivity.class);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } else if (f46928a != null) {
            f46928a.finish();
        }
    }

    public static void setProgressContent(final String str) {
        f46930c = str;
        if (f46928a != null && f46928a.mProgress != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f46928a.mProgress.setContent(str, f46928a.progressCancelable());
            } else {
                f46928a.runOnUiThread(new Runnable() {
                    public void run() {
                        ProgressbarActivity.f46928a.mProgress.setContent(str, ProgressbarActivity.f46928a.progressCancelable());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (f46928a != null) {
            f46928a.finish();
            f46928a = null;
        }
        if (f46929b) {
            f46928a = this;
            ProgressDialogFragment createProgressDialogFragment = createProgressDialogFragment();
            this.mProgress = createProgressDialogFragment;
            createProgressDialogFragment.show(getSupportFragmentManager(), "df_progress");
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public ProgressDialogFragment createProgressDialogFragment() {
        InnerFragment innerFragment = new InnerFragment();
        innerFragment.setContent(f46930c != null ? f46930c : getResources().getString(progressMsgResId()), progressCancelable());
        int progressDrawable = getProgressDrawable();
        if (progressDrawable > 0) {
            innerFragment.setIndeterminateDrawable(progressDrawable);
        }
        return innerFragment;
    }

    /* access modifiers changed from: protected */
    public int getProgressDrawable() {
        String packageName = WsgSecInfo.packageName(this);
        if ("com.huaxiaozhu.driver".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz;
        }
        if ("com.huaxiaozhu.rider".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz_rider;
        }
        return 0;
    }

    public void finish() {
        super.finish();
        ProgressDialogFragment progressDialogFragment = this.mProgress;
        if (progressDialogFragment != null) {
            progressDialogFragment.dismiss();
        }
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (f46928a == this) {
            f46928a = null;
        }
    }

    public static class InnerFragment extends ProgressDialogFragment {
        private TextView contentView;

        public void setContent(String str, boolean z) {
            View view;
            super.setContent(str, z);
            if (this.contentView == null && (view = getView()) != null) {
                View findViewById = view.findViewById(R.id.tv_msg);
                if (findViewById instanceof TextView) {
                    this.contentView = (TextView) findViewById;
                }
            }
            TextView textView = this.contentView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}

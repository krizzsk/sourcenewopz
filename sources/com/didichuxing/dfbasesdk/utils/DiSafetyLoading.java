package com.didichuxing.dfbasesdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DiSafetyLoading {

    /* renamed from: a */
    private static int f46726a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Map<Integer, WeakReference<DiSafetyLoading>> f46727b = new ConcurrentHashMap();

    /* renamed from: c */
    private final int f46728c;

    /* renamed from: d */
    private Context f46729d;

    /* renamed from: e */
    private DiSafetyLoadingFragment f46730e;

    /* renamed from: f */
    private String f46731f;

    /* renamed from: g */
    private int f46732g;

    /* renamed from: h */
    private boolean f46733h;

    /* renamed from: i */
    private LoadingListener f46734i;

    public interface LoadingListener {
        void onHide();

        void onShow();
    }

    public DiSafetyLoading(Context context) {
        int i = f46726a;
        f46726a = i + 1;
        this.f46728c = i;
        this.f46729d = context;
    }

    public void show() {
        if (!f46727b.containsKey(Integer.valueOf(this.f46728c))) {
            f46727b.put(Integer.valueOf(this.f46728c), new WeakReference(this));
            Context context = this.f46729d;
            if (context instanceof FragmentActivity) {
                m33554a((FragmentActivity) context);
                return;
            }
            Intent intent = new Intent(this.f46729d, DfLoadingActivity.class);
            intent.putExtra("loading_id", this.f46728c);
            intent.addFlags(268435456);
            this.f46729d.startActivity(intent);
        }
    }

    public void hide() {
        f46727b.remove(Integer.valueOf(this.f46728c));
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f46730e;
        this.f46730e = null;
        if (diSafetyLoadingFragment != null) {
            Activity parentActivity = diSafetyLoadingFragment.getParentActivity();
            diSafetyLoadingFragment.dismiss();
            if (parentActivity instanceof DfLoadingActivity) {
                parentActivity.finish();
            }
            LoadingListener loadingListener = this.f46734i;
            if (loadingListener != null) {
                loadingListener.onHide();
            }
        }
    }

    public DiSafetyLoading setMessage(String str) {
        this.f46731f = str;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f46730e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setContent(str, diSafetyLoadingFragment.isCancelable());
        }
        return this;
    }

    public DiSafetyLoading setDrawable(int i) {
        this.f46732g = i;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f46730e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setIndeterminateDrawable(i);
        }
        return this;
    }

    public DiSafetyLoading setCancelable(boolean z) {
        this.f46733h = z;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f46730e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setCancelable(z);
        }
        return this;
    }

    public DiSafetyLoading setListener(LoadingListener loadingListener) {
        this.f46734i = loadingListener;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33554a(FragmentActivity fragmentActivity) {
        DiSafetyLoadingFragment diSafetyLoadingFragment = new DiSafetyLoadingFragment();
        this.f46730e = diSafetyLoadingFragment;
        diSafetyLoadingFragment.setParentActivity(fragmentActivity);
        this.f46730e.setContent(TextUtils.isEmpty(this.f46731f) ? "加载中，请稍后..." : this.f46731f, this.f46733h);
        int i = this.f46732g;
        if (i != 0) {
            this.f46730e.setIndeterminateDrawable(i);
        }
        DiSafetyLoadingFragment diSafetyLoadingFragment2 = this.f46730e;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        diSafetyLoadingFragment2.show(supportFragmentManager, "df_progress" + this.f46728c);
        LoadingListener loadingListener = this.f46734i;
        if (loadingListener != null) {
            loadingListener.onShow();
        }
    }

    public static class DfLoadingActivity extends FragmentActivity {
        public static final String EXTRA_ID = "loading_id";

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            SystemUtils.hookOnlyFullscreenOpaque(this);
            requestWindowFeature(1);
            super.onCreate(bundle);
            getWindow().setFlags(1024, 1024);
            getWindow().setSoftInputMode(2);
            WeakReference weakReference = (WeakReference) DiSafetyLoading.f46727b.get(Integer.valueOf(getIntent().getIntExtra("loading_id", 0)));
            if (weakReference == null) {
                finish();
                return;
            }
            DiSafetyLoading diSafetyLoading = (DiSafetyLoading) weakReference.get();
            if (diSafetyLoading == null) {
                finish();
            } else {
                diSafetyLoading.m33554a(this);
            }
        }
    }

    public static class DiSafetyLoadingFragment extends ProgressDialogFragment {
        private TextView contentView;
        private Activity parentActivity;

        public void setParentActivity(Activity activity) {
            this.parentActivity = activity;
        }

        public Activity getParentActivity() {
            return this.parentActivity;
        }

        public void setContent(String str, boolean z) {
            View view;
            super.setContent(str, z);
            if (this.contentView == null && (view = getView()) != null) {
                try {
                    View findViewById = view.findViewById(R.id.tv_msg);
                    if (findViewById instanceof TextView) {
                        this.contentView = (TextView) findViewById;
                    }
                } catch (Throwable unused) {
                }
            }
            TextView textView = this.contentView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}

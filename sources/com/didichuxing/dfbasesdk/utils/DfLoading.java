package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;

@Deprecated
public class DfLoading extends FragmentActivity {

    /* renamed from: a */
    private static final String f46723a = "param";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static DfLoading f46724b = null;

    /* renamed from: c */
    private static boolean f46725c = false;
    protected ProgressDialogFragment mProgress;

    public static class Param {
        public boolean cancelable = false;
        public int drawable = -1;
        public String message = null;
    }

    public static void show(Context context) {
        show(context, new ParamBuilder().build());
    }

    public static void show(Context context, String str) {
        show(context, new ParamBuilder().message(str).build());
    }

    public static void show(Context context, int i) {
        show(context, new ParamBuilder().drawable(i).build());
    }

    public static void show(Context context, Param param) {
        f46725c = true;
        Intent intent = new Intent(context, DfLoading.class);
        if (param != null) {
            intent.putExtra("param", GsonUtils.toJson(param, true));
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void hide() {
        f46725c = false;
        DfLoading dfLoading = f46724b;
        if (dfLoading != null) {
            dfLoading.finish();
        }
    }

    public static void setMessage(final String str) {
        DfLoading dfLoading = f46724b;
        if (dfLoading != null && dfLoading.mProgress != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ProgressDialogFragment progressDialogFragment = f46724b.mProgress;
                progressDialogFragment.setContent(str, progressDialogFragment.isCancelable());
                return;
            }
            f46724b.runOnUiThread(new Runnable() {
                public void run() {
                    DfLoading.f46724b.mProgress.setContent(str, DfLoading.f46724b.mProgress.isCancelable());
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didichuxing.dfbasesdk.utils.DfLoading$Param} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r3) {
        /*
            r2 = this;
            com.didi.sdk.apm.SystemUtils.hookOnlyFullscreenOpaque(r2)
            super.onCreate(r3)
            com.didichuxing.dfbasesdk.utils.DfLoading r3 = f46724b
            r0 = 0
            if (r3 == 0) goto L_0x0010
            r3.finish()
            f46724b = r0
        L_0x0010:
            boolean r3 = f46725c
            if (r3 == 0) goto L_0x003f
            f46724b = r2
            android.content.Intent r3 = r2.getIntent()
            java.lang.String r1 = "param"
            java.lang.String r3 = r3.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x002f
            java.lang.Class<com.didichuxing.dfbasesdk.utils.DfLoading$Param> r0 = com.didichuxing.dfbasesdk.utils.DfLoading.Param.class
            java.lang.Object r3 = com.didichuxing.dfbasesdk.utils.GsonUtils.fromJson((java.lang.String) r3, r0)
            r0 = r3
            com.didichuxing.dfbasesdk.utils.DfLoading$Param r0 = (com.didichuxing.dfbasesdk.utils.DfLoading.Param) r0
        L_0x002f:
            com.didi.sdk.view.dialog.ProgressDialogFragment r3 = r2.createProgressDialogFragment(r0)
            r2.mProgress = r3
            androidx.fragment.app.FragmentManager r0 = r2.getSupportFragmentManager()
            java.lang.String r1 = "df_loading"
            r3.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r1)
            goto L_0x0042
        L_0x003f:
            r2.finish()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.DfLoading.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public ProgressDialogFragment createProgressDialogFragment(Param param) {
        InnerFragment innerFragment = new InnerFragment();
        innerFragment.setContent((param == null || param.message == null) ? "加载中，请稍后..." : param.message, param != null && param.cancelable);
        int a = m33551a(param);
        if (a > 0) {
            innerFragment.setIndeterminateDrawable(a);
        }
        return innerFragment;
    }

    /* renamed from: a */
    private int m33551a(Param param) {
        if (param != null && param.drawable > 0) {
            return param.drawable;
        }
        String packageName = WsgSecInfo.packageName(this);
        if ("com.huaxiaozhu.driver".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz;
        }
        return "com.huaxiaozhu.rider".equalsIgnoreCase(packageName) ? R.drawable.df_loading_hxz_rider : R.drawable.df_loading;
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
        if (f46724b == this) {
            f46724b = null;
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

    public static class ParamBuilder {
        Param param = new Param();

        public ParamBuilder message(String str) {
            this.param.message = str;
            return this;
        }

        public ParamBuilder drawable(int i) {
            this.param.drawable = i;
            return this;
        }

        public ParamBuilder cancelable(boolean z) {
            this.param.cancelable = z;
            return this;
        }

        public Param build() {
            return this.param;
        }
    }
}

package com.didi.zxing.scan.util;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class TopPermissionViewHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ViewGroup f45519a;

    /* renamed from: b */
    private final int f45520b;

    /* renamed from: c */
    private final LayoutInflater f45521c;

    /* renamed from: d */
    private final Handler f45522d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f45523e;

    /* renamed from: f */
    private Runnable f45524f;

    public TopPermissionViewHelper(ViewGroup viewGroup) {
        this(viewGroup, 0);
    }

    public TopPermissionViewHelper(ViewGroup viewGroup, int i) {
        this.f45519a = viewGroup;
        this.f45520b = i;
        this.f45521c = LayoutInflater.from(viewGroup.getContext());
        this.f45522d = new Handler(Looper.getMainLooper());
    }

    public void showViewDelayed(int i, int i2, long j) {
        View inflate = this.f45521c.inflate(R.layout.zxing_qr_code_top_permission_desc_view, this.f45519a, false);
        this.f45523e = inflate;
        ((TextView) inflate.findViewById(R.id.top_title_tv)).setText(i);
        ((TextView) this.f45523e.findViewById(R.id.top_desc_tv)).setText(i2);
        if (this.f45520b > 0 && (this.f45523e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.f45523e.getLayoutParams()).topMargin = this.f45520b;
        }
        C149751 r5 = new Runnable() {
            public void run() {
                TopPermissionViewHelper.this.f45519a.addView(TopPermissionViewHelper.this.f45523e);
            }
        };
        this.f45524f = r5;
        this.f45522d.postDelayed(r5, j);
    }

    public void removeIfNeeded() {
        Runnable runnable = this.f45524f;
        if (runnable != null) {
            this.f45522d.removeCallbacks(runnable);
        }
        View view = this.f45523e;
        if (view != null) {
            this.f45519a.removeView(view);
        }
    }
}

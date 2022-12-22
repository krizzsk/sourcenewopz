package com.didi.component.payway;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/component/payway/PaywayGuidanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mFrameeLayout", "Landroid/widget/FrameLayout;", "mGet", "Landroid/widget/TextView;", "mTriangle", "Landroid/view/View;", "paywayTv", "init", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "comp-payway_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaywayGuidanceActivity.kt */
public final class PaywayGuidanceActivity extends AppCompatActivity {

    /* renamed from: a */
    private TextView f15109a;

    /* renamed from: b */
    private FrameLayout f15110b;

    /* renamed from: c */
    private View f15111c;

    /* renamed from: d */
    private TextView f15112d;

    public void _$_clearFindViewByIdCache() {
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
        }
        setContentView((int) R.layout.payway_guidance);
        m10794a();
        m10795b();
    }

    /* renamed from: a */
    private final void m10794a() {
        WindowManager.LayoutParams layoutParams;
        Window window = getWindow();
        if (window == null) {
            layoutParams = null;
        } else {
            layoutParams = window.getAttributes();
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (layoutParams != null) {
            layoutParams.width = displayMetrics.widthPixels;
        }
        window.setAttributes(layoutParams);
        window.setGravity(80);
    }

    /* renamed from: b */
    private final void m10795b() {
        this.f15111c = findViewById(R.id.v_triangle);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.payway_default_layout);
        this.f15110b = frameLayout;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.payway_guide_bg);
        }
        TextView textView = (TextView) findViewById(R.id.tv_get);
        this.f15109a = textView;
        if (textView != null) {
            textView.setOnClickListener(new PaywayGuidanceActivity$initView$1(this));
        }
        TextView textView2 = (TextView) findViewById(R.id.guide_text);
        this.f15112d = textView2;
        if (textView2 != null) {
            textView2.setText(ResourcesHelper.getString(this, R.string.global_user_guild_payment_hint));
        }
    }
}

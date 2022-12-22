package com.didi.component.substitute.call;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/component/substitute/call/ScNoviceGuidanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mAnycarAvatar", "Landroid/widget/ImageView;", "mAnycarRelativeLayout", "Landroid/widget/RelativeLayout;", "mAnycarScText", "Landroid/widget/TextView;", "mAnycarSelectContainer", "Landroid/widget/FrameLayout;", "mAvatar", "mBannerContainer", "Landroid/widget/LinearLayout;", "mGet", "mRelativeLayout", "mScText", "mSelectContainer", "mTriangle", "Landroid/view/View;", "init", "", "initHollowedOutData", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScNoviceGuidanceActivity.kt */
public final class ScNoviceGuidanceActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f16021a;

    /* renamed from: b */
    private TextView f16022b;

    /* renamed from: c */
    private TextView f16023c;

    /* renamed from: d */
    private RelativeLayout f16024d;

    /* renamed from: e */
    private FrameLayout f16025e;

    /* renamed from: f */
    private ImageView f16026f;

    /* renamed from: g */
    private TextView f16027g;

    /* renamed from: h */
    private RelativeLayout f16028h;

    /* renamed from: i */
    private FrameLayout f16029i;

    /* renamed from: j */
    private LinearLayout f16030j;

    /* renamed from: k */
    private View f16031k;

    public void _$_clearFindViewByIdCache() {
    }

    public void onBackPressed() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/substitute/call/ScNoviceGuidanceActivity$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ScNoviceGuidanceActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, ScNoviceGuidanceActivity.class);
            intent.setFlags(268435456);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
        }
        setContentView((int) R.layout.sc_novice_guidance);
        m11772a();
        m11773b();
        m11774c();
    }

    /* renamed from: a */
    private final void m11772a() {
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
    private final void m11773b() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        this.f16021a = (ImageView) findViewById(R.id.iv_sp_avatar);
        this.f16022b = (TextView) findViewById(R.id.tv_sp_text);
        this.f16031k = findViewById(R.id.v_triangle);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_hollowed_out);
        this.f16024d = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.select_passager_bg);
        }
        this.f16025e = (FrameLayout) findViewById(R.id.select_container);
        this.f16026f = (ImageView) findViewById(R.id.anycar_iv_sp_avatar);
        this.f16027g = (TextView) findViewById(R.id.anycar_tv_sp_text);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.anycar_rl_hollowed_out);
        this.f16028h = relativeLayout2;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.anycar_select_passager_bg);
        }
        this.f16029i = (FrameLayout) findViewById(R.id.anycar_select_container);
        this.f16030j = (LinearLayout) findViewById(R.id.banner_container);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        boolean z = true;
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            z = false;
        }
        if (z) {
            FrameLayout frameLayout = this.f16029i;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FrameLayout frameLayout2 = this.f16025e;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            LinearLayout linearLayout = this.f16030j;
            if (!(linearLayout == null || (layoutParams2 = linearLayout.getLayoutParams()) == null || !(layoutParams2 instanceof LinearLayout.LayoutParams))) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                Context context = this;
                layoutParams3.setMarginStart(UIUtils.dip2pxInt(context, 5.0f));
                layoutParams3.setMarginEnd(UIUtils.dip2pxInt(context, 5.0f));
            }
            View view = this.f16031k;
            if (!(view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof LinearLayout.LayoutParams))) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(UIUtils.dip2pxInt(this, 36.0f));
            }
        } else {
            FrameLayout frameLayout3 = this.f16029i;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FrameLayout frameLayout4 = this.f16025e;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        }
        TextView textView = (TextView) findViewById(R.id.tv_get);
        this.f16023c = textView;
        if (textView != null) {
            textView.setOnClickListener(new ScNoviceGuidanceActivity$initView$3(this));
        }
    }

    /* renamed from: c */
    private final void m11774c() {
        TextView textView;
        TextView textView2;
        FormStore instance = FormStore.getInstance();
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        boolean z = false;
        if (confirmListener != null && confirmListener.getIsAnyCar()) {
            z = true;
        }
        if (z) {
            String substituteCallIcon = instance.getSubstituteCallIcon();
            if (substituteCallIcon != null) {
                ImageView imageView = this.f16026f;
                Intrinsics.checkNotNull(imageView);
                ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(substituteCallIcon).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(imageView);
            }
            String substituteCallText = instance.getSubstituteCallText();
            if (substituteCallText != null && (textView2 = this.f16027g) != null) {
                textView2.setText(substituteCallText);
                return;
            }
            return;
        }
        String substituteCallIcon2 = instance.getSubstituteCallIcon();
        if (substituteCallIcon2 != null) {
            ImageView imageView2 = this.f16021a;
            Intrinsics.checkNotNull(imageView2);
            ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(substituteCallIcon2).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(imageView2);
        }
        String substituteCallText2 = instance.getSubstituteCallText();
        if (substituteCallText2 != null && (textView = this.f16022b) != null) {
            textView.setText(substituteCallText2);
        }
    }
}

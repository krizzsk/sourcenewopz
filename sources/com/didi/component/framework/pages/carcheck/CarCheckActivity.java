package com.didi.component.framework.pages.carcheck;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.framework.pages.carcheck.fragment.CarCheckFragment;
import com.didi.component.framework.pages.carcheck.fragment.CarResultFragment;
import com.didi.component.framework.pages.carcheck.view.CarCheckListener;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/CarCheckActivity;", "Lcom/didi/global/loading/app/AbsLoadingActivity;", "Lcom/didi/component/framework/pages/carcheck/view/CarCheckListener;", "()V", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager$delegate", "Lkotlin/Lazy;", "lastTime", "", "oid", "", "getCarResult", "", "getFallbackView", "Landroid/view/View;", "hideLoadingView", "initTitleBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showErrorDialog", "msg", "showErrorView", "showLoadingView", "switchToTargetPage", "tag", "bundle", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckActivity.kt */
public final class CarCheckActivity extends AbsLoadingActivity implements CarCheckListener {
    public static final String ANSWER = "answer";
    public static final String ANSWERS = "answers";
    public static final String CARD_NUM = "card_num";
    public static final String CAR_CHECK = "car_check";
    public static final String CAR_RESULT = "car_result";
    public static final String CAR_TYPE = "card_type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ORDER_ID = "order_id";
    public static final String QUESTION_BODY = "question_body";
    public static final String QUESTION_ID = "question_id";
    public static final String USER_REPLY = "user_reply";

    /* renamed from: a */
    private final Lazy f13760a = LazyKt.lazy(new CarCheckActivity$fragmentManager$2(this));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f13761b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f13762c;

    public void _$_clearFindViewByIdCache() {
    }

    /* renamed from: a */
    private final FragmentManager m9551a() {
        return (FragmentManager) this.f13760a.getValue();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/CarCheckActivity$Companion;", "", "()V", "ANSWER", "", "ANSWERS", "CARD_NUM", "CAR_CHECK", "CAR_RESULT", "CAR_TYPE", "ORDER_ID", "QUESTION_BODY", "QUESTION_ID", "USER_REPLY", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CarCheckActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_car_check_activity);
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            GLog.m7969e("CarCheckActivity", "StatusBarLightingCompat.setStatusBarBgLightning", e);
        }
        this.f13762c = SystemClock.uptimeMillis();
        m9553b();
        m9555c();
    }

    public View getFallbackView() {
        return (WebTitleBar) findViewById(R.id.car_check_title);
    }

    /* renamed from: b */
    private final void m9553b() {
        WebTitleBar webTitleBar = (WebTitleBar) findViewById(R.id.car_check_title);
        TextView textView = null;
        TextView middleTv = webTitleBar == null ? null : webTitleBar.getMiddleTv();
        if (middleTv != null) {
            middleTv.setTypeface(Typeface.DEFAULT_BOLD);
        }
        WebTitleBar webTitleBar2 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar2 != null) {
            textView = webTitleBar2.getMiddleTv();
        }
        if (textView != null) {
            textView.setTextSize(21.0f);
        }
        WebTitleBar webTitleBar3 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar3 != null) {
            webTitleBar3.setCloseBtnVisibility(8);
        }
        WebTitleBar webTitleBar4 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar4 != null) {
            webTitleBar4.setMoreBtnVisibility(8);
        }
        WebTitleBar webTitleBar5 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar5 != null) {
            webTitleBar5.setBackBtnVisibility(0);
        }
        String string = ResourcesHelper.getString(this, R.string.global_car_check_title);
        WebTitleBar webTitleBar6 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar6 != null) {
            webTitleBar6.setTitle(string);
        }
        WebTitleBar webTitleBar7 = (WebTitleBar) findViewById(R.id.car_check_title);
        if (webTitleBar7 != null) {
            webTitleBar7.setOnBackClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CarCheckActivity.m9552a(CarCheckActivity.this, view);
                }
            });
        }
        String stringExtra = getIntent().getStringExtra("oid");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"oid\")!!");
        this.f13761b = stringExtra;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m9552a(CarCheckActivity carCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(carCheckActivity, "this$0");
        super.onBackPressed();
    }

    public void switchToTargetPage(String str, Bundle bundle) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(str, "tag");
        FragmentManager a = m9551a();
        if (a.findFragmentByTag(str) == null) {
            if (Intrinsics.areEqual((Object) str, (Object) CAR_CHECK)) {
                fragment = CarCheckFragment.Companion.newInstance(bundle);
            } else {
                fragment = CarResultFragment.Companion.newInstance(bundle);
            }
            a.beginTransaction().replace(R.id.car_check_container, fragment).commit();
        }
    }

    /* renamed from: c */
    private final void m9555c() {
        showLoading();
        CarOrder order = CarOrderHelper.getOrder();
        if (!(this.f13761b.length() == 0)) {
            CarRequest.getCarCheckResult(this, this.f13761b, new CarCheckActivity$getCarResult$1(this, order));
        }
    }

    public void showLoadingView() {
        showLoading();
    }

    public void hideLoadingView() {
        hideLoading();
    }

    public void showErrorView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.car_check_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        TextView textView = (TextView) findViewById(R.id.car_check_reload);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CarCheckActivity.m9554b(CarCheckActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m9554b(CarCheckActivity carCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(carCheckActivity, "this$0");
        carCheckActivity.m9555c();
        LinearLayout linearLayout = (LinearLayout) carCheckActivity.findViewById(R.id.car_check_error_view);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void showErrorDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
        builder.setCancelable(false);
        builder.setCloseVisible(false);
        builder.setSupprtMullineTitle(true);
        builder.setIcon(AlertController.IconType.INFO);
        builder.setMessage(str);
        builder.setPositiveButton((int) R.string.fine);
        builder.setPositiveButtonDefault();
        AlertDialogFragment create = builder.create();
        if (create != null) {
            create.show(m9551a(), (String) null);
        }
    }
}

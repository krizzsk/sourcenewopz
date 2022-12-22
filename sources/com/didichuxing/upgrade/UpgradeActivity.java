package com.didichuxing.upgrade;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.p154ms.common.account.IAccountChooser;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didichuxing.request.UploadGAccountRequester;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.util.OmegaUtilsKt;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSp;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0014\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0002J\b\u0010&\u001a\u00020!H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020!H\u0002J\"\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0012\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u00067"}, mo175978d2 = {"Lcom/didichuxing/upgrade/UpgradeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_requestGmailCode", "", "_tag", "", "mAccountHintTv", "Landroid/widget/TextView;", "getMAccountHintTv", "()Landroid/widget/TextView;", "setMAccountHintTv", "(Landroid/widget/TextView;)V", "mAccountTv", "getMAccountTv", "setMAccountTv", "mAgreeTv", "getMAgreeTv", "setMAgreeTv", "mJoinPlan", "mLearnMoreTv", "getMLearnMoreTv", "setMLearnMoreTv", "mStep2View", "Landroid/view/View;", "getMStep2View", "()Landroid/view/View;", "setMStep2View", "(Landroid/view/View;)V", "mStep3View", "getMStep3View", "setMStep3View", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "createConfigurationContext", "context", "finish", "forLanguageTag", "Ljava/util/Locale;", "tag", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setNextStepVisible", "visible", "", "startActivityForAccount", "upgrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UpgradeActivity.kt */
public final class UpgradeActivity extends AppCompatActivity {

    /* renamed from: a */
    private final int f49238a = 16;

    /* renamed from: b */
    private final String f49239b = "UpgradeActivity";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f49240c;

    /* renamed from: d */
    private HashMap f49241d;
    public TextView mAccountHintTv;
    public TextView mAccountTv;
    public TextView mAgreeTv;
    public TextView mLearnMoreTv;
    public View mStep2View;
    public View mStep3View;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f49241d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f49241d == null) {
            this.f49241d = new HashMap();
        }
        View view = (View) this.f49241d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f49241d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final TextView getMAccountTv() {
        TextView textView = this.mAccountTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTv");
        }
        return textView;
    }

    public final void setMAccountTv(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mAccountTv = textView;
    }

    public final TextView getMAccountHintTv() {
        TextView textView = this.mAccountHintTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountHintTv");
        }
        return textView;
    }

    public final void setMAccountHintTv(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mAccountHintTv = textView;
    }

    public final TextView getMAgreeTv() {
        TextView textView = this.mAgreeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgreeTv");
        }
        return textView;
    }

    public final void setMAgreeTv(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mAgreeTv = textView;
    }

    public final TextView getMLearnMoreTv() {
        TextView textView = this.mLearnMoreTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLearnMoreTv");
        }
        return textView;
    }

    public final void setMLearnMoreTv(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mLearnMoreTv = textView;
    }

    public final View getMStep2View() {
        View view = this.mStep2View;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStep2View");
        }
        return view;
    }

    public final void setMStep2View(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.mStep2View = view;
    }

    public final View getMStep3View() {
        View view = this.mStep3View;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStep3View");
        }
        return view;
    }

    public final void setMStep3View(View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.mStep3View = view;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "newBase");
        Context a = m35512a(context);
        if (a != null) {
            context = a;
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_upgrade);
        m35514a();
        OmegaUtilsKt.OmegaTrack_appupdate_guide_gp_beta_sw();
    }

    /* renamed from: a */
    private final void m35514a() {
        View findViewById = findViewById(R.id.step2_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.step2_view)");
        this.mStep2View = findViewById;
        View findViewById2 = findViewById(R.id.step3_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.step3_view)");
        this.mStep3View = findViewById2;
        View findViewById3 = findViewById(R.id.step1_account_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.step1_account_tv)");
        this.mAccountTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.step1_account_hint_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.step1_account_hint_tv)");
        this.mAccountHintTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.step2_agree_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.step2_agree_tv)");
        this.mAgreeTv = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.step2_agree_info_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.step2_agree_info_tv)");
        this.mLearnMoreTv = (TextView) findViewById6;
        findViewById(R.id.titlebar_back).setOnClickListener(new UpgradeActivity$initView$1(this));
        TextView textView = this.mAccountTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAccountTv");
        }
        textView.setOnClickListener(new UpgradeActivity$initView$2(this));
        CharSequence googleAccount$default = UpgradeSp.getGoogleAccount$default(UpgradeSp.Companion.getInstance(), (String) null, 1, (Object) null);
        if (googleAccount$default == null || googleAccount$default.length() == 0) {
            TextView textView2 = this.mAccountHintTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAccountHintTv");
            }
            textView2.setVisibility(8);
            TextView textView3 = this.mAccountTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAccountTv");
            }
            textView3.setText(getString(R.string.join_testing_step1_select_account));
            m35515a(false);
        } else {
            TextView textView4 = this.mAccountHintTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAccountHintTv");
            }
            textView4.setVisibility(0);
            TextView textView5 = this.mAccountHintTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAccountHintTv");
            }
            textView5.setText(getString(R.string.join_testing_step1_select_account));
            TextView textView6 = this.mAccountTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAccountTv");
            }
            textView6.setText(googleAccount$default);
            m35515a(true);
            this.f49240c = 1;
        }
        TextView textView7 = this.mAgreeTv;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAgreeTv");
        }
        textView7.setOnClickListener(new UpgradeActivity$initView$3(this));
        TextView textView8 = this.mLearnMoreTv;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLearnMoreTv");
        }
        textView8.setOnClickListener(UpgradeActivity$initView$4.INSTANCE);
    }

    /* renamed from: a */
    private final void m35515a(boolean z) {
        if (z) {
            View view = this.mStep2View;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStep2View");
            }
            view.setVisibility(0);
            View view2 = this.mStep3View;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStep3View");
            }
            view2.setVisibility(0);
            return;
        }
        View view3 = this.mStep2View;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStep2View");
        }
        view3.setVisibility(8);
        View view4 = this.mStep3View;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStep3View");
        }
        view4.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m35516b() {
        Intent newChooseAccountIntent;
        try {
            IAccountChooser iAccountChooser = (IAccountChooser) ServiceUtil.getServiceImp(IAccountChooser.class);
            if (iAccountChooser != null && (newChooseAccountIntent = iAccountChooser.newChooseAccountIntent()) != null) {
                startActivityForResult(newChooseAccountIntent, this.f49238a);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.f49238a && i2 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("authAccount") : null;
            String str = this.f49239b;
            UpLogger.m35522d(str, "get google account " + stringExtra);
            CharSequence charSequence = stringExtra;
            if (!(charSequence == null || charSequence.length() == 0)) {
                TextView textView = this.mAccountTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAccountTv");
                }
                textView.setText(charSequence);
                TextView textView2 = this.mAccountHintTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAccountHintTv");
                }
                textView2.setVisibility(0);
                m35515a(true);
                UpgradeSp.Companion.getInstance().setGoogleAccount(stringExtra);
                OmegaUtilsKt.OmegaTrack_appupdate_guide_gp_acct_ck(stringExtra);
            }
        }
    }

    public void finish() {
        super.finish();
        if (this.f49240c == 0) {
            new UploadGAccountRequester("", 0).request();
        }
    }

    /* renamed from: a */
    private final Context m35512a(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        UpgradeConfig.IConfig iConfig = UpgradeConfig.iConfig;
        Intrinsics.checkExpressionValueIsNotNull(iConfig, "UpgradeConfig.iConfig");
        String appLanguage = iConfig.getAppLanguage();
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(appLanguage, "language");
        Locale a = m35513a(appLanguage);
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(a);
        Intrinsics.checkExpressionValueIsNotNull(configuration, "configuration");
        configuration.setLocales(new LocaleList(new Locale[]{a}));
        return context.createConfigurationContext(configuration);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Locale m35513a(java.lang.String r8) {
        /*
            r7 = this;
            r6 = r8
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x000b
            r8 = 0
            return r8
        L_0x000b:
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.lang.String r1 = "-"
            r0 = r6
            int r0 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r0, (java.lang.String) r1, (int) r2, (boolean) r3, (int) r4, (java.lang.Object) r5)
            if (r0 <= 0) goto L_0x008d
            kotlin.text.Regex r8 = new kotlin.text.Regex
            java.lang.String r0 = "-"
            r8.<init>((java.lang.String) r0)
            r0 = 0
            java.util.List r8 = r8.split(r6, r0)
            boolean r1 = r8.isEmpty()
            r2 = 1
            if (r1 != 0) goto L_0x0058
            int r1 = r8.size()
            java.util.ListIterator r1 = r8.listIterator(r1)
        L_0x0033:
            boolean r3 = r1.hasPrevious()
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r1.previous()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0049
            r3 = 1
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r3 != 0) goto L_0x0033
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            int r1 = r1.nextIndex()
            int r1 = r1 + r2
            java.util.List r8 = kotlin.collections.CollectionsKt.take(r8, r1)
            goto L_0x005c
        L_0x0058:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x005c:
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.Object[] r8 = r8.toArray(r1)
            if (r8 == 0) goto L_0x0085
            java.lang.String[] r8 = (java.lang.String[]) r8
            r0 = r8[r0]
            r8 = r8[r2]
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x007b
            java.util.Locale r1 = new java.util.Locale
            r1.<init>(r0, r8)
            return r1
        L_0x007b:
            java.util.Locale r8 = new java.util.Locale
            java.lang.String r0 = "en"
            java.lang.String r1 = "US"
            r8.<init>(r0, r1)
            return r8
        L_0x0085:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r8.<init>(r0)
            throw r8
        L_0x008d:
            java.util.Locale r0 = new java.util.Locale
            r0.<init>(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.upgrade.UpgradeActivity.m35513a(java.lang.String):java.util.Locale");
    }
}

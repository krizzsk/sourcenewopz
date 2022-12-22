package com.didi.component.framework.pages.promo;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.framework.pages.promo.fragment.ActionListener;
import com.didi.component.framework.pages.promo.fragment.PromoShareFragment;
import com.didi.component.framework.pages.promo.fragment.PromoShowFragment;
import com.didi.component.framework.pages.promo.helper.PromoCodeInterceptor;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.view.fragment.PlatformClickListener;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.util.GlobalCountryCode;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J(\u0010\u001d\u001a\u00020\u00132\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/PromoCodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/didi/component/framework/pages/promo/fragment/ActionListener;", "()V", "countryCode", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager$delegate", "Lkotlin/Lazy;", "promoCode", "rspData", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "share", "show", "title", "addRspData", "", "getRspData", "onBackArrowClick", "page", "Lcom/didi/component/framework/pages/promo/PromoCodePage;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDialog", "msg", "showShareDialog", "info", "Ljava/util/ArrayList;", "Lcom/didi/onekeyshare/entity/OneKeyShareInfo;", "Lkotlin/collections/ArrayList;", "callback", "Lcom/didi/onekeyshare/view/fragment/PlatformClickListener;", "switchToSharePage", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoCodeActivity.kt */
public final class PromoCodeActivity extends AppCompatActivity implements ActionListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "PromoCodeActivity";
    private String countryCode = "br";
    private final Lazy fragmentManager$delegate = LazyKt.lazy(new PromoCodeActivity$fragmentManager$2(this));
    private String promoCode = "";
    private PromoData rspData;
    private final String share = "share";
    private final String show = "show";
    private String title = "";

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoCodeActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PromoCodePage.values().length];
            iArr[PromoCodePage.PAGE_SHOW.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/PromoCodeActivity$Companion;", "", "()V", "TAG", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoCodeActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final FragmentManager getFragmentManager() {
        return (FragmentManager) this.fragmentManager$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.global_promo_code_activity);
        String stringExtra = getIntent().getStringExtra(PromoCodeInterceptor.PROMO_CODE);
        String str2 = "";
        if (stringExtra == null) {
            stringExtra = str2;
        }
        this.promoCode = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("title");
        if (stringExtra2 != null) {
            str2 = stringExtra2;
        }
        this.title = str2;
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        if (curBusinessContext != null && (curBusinessContext instanceof BusinessContext)) {
            CountryInfo countryInfo = ((BusinessContext) curBusinessContext).getCountryInfo();
            if (countryInfo == null) {
                str = null;
            } else {
                str = countryInfo.getCountryIsoCode();
            }
            if (str == null) {
                str = this.countryCode;
            }
            this.countryCode = str;
        }
        String str3 = this.countryCode;
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, GlobalCountryCode.AMERICA);
        String lowerCase = str3.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        this.countryCode = lowerCase;
        try {
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        } catch (Exception e) {
            SystemUtils.log(6, "PromoCodeActivity", "StatusBarLightingCompat.setStatusBarBgLightning", e, "com.didi.component.framework.pages.promo.PromoCodeActivity", 64);
        }
        if (getFragmentManager().findFragmentByTag(this.show) == null) {
            getFragmentManager().beginTransaction().add(R.id.promo_code_fragment_container, PromoShowFragment.Companion.newInstance(this.promoCode, this.countryCode, this.title), this.show).commit();
        }
    }

    public void switchToSharePage() {
        if (getFragmentManager().findFragmentByTag(this.share) == null) {
            getFragmentManager().beginTransaction().replace(R.id.promo_code_fragment_container, PromoShareFragment.Companion.newInstance(this.countryCode, this.title), this.share).addToBackStack((String) null).commit();
        }
    }

    public void showShareDialog(ArrayList<OneKeyShareInfo> arrayList, PlatformClickListener platformClickListener) {
        Intrinsics.checkNotNullParameter(arrayList, "info");
        Intrinsics.checkNotNullParameter(platformClickListener, "callback");
        ShareBuilder.buildShare((FragmentActivity) this, arrayList, (ICallback.IPlatformShareCallback) null, platformClickListener);
    }

    public void onBackArrowClick(PromoCodePage promoCodePage) {
        Intrinsics.checkNotNullParameter(promoCodePage, "page");
        if (WhenMappings.$EnumSwitchMapping$0[promoCodePage.ordinal()] == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void showDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        SimpleDialog.Companion.newInstance(str).show(getSupportFragmentManager(), "dialog");
    }

    public PromoData getRspData() {
        return this.rspData;
    }

    public void addRspData(PromoData promoData) {
        this.rspData = promoData;
    }
}

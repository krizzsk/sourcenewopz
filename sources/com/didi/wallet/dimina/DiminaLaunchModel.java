package com.didi.wallet.dimina;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.wallet.dimina.rpc.WalletDiminaRpcKt;
import com.didi.wallet.dimina.view.WalletDiminaFragment;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/wallet/dimina/DiminaLaunchModel;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "checkAntiCheating", "", "diminaUri", "Landroid/net/Uri;", "launchEvent", "Lkotlin/Function1;", "", "isFromWalletHome", "launchDimina", "savedInstanceState", "Landroid/os/Bundle;", "loadConfig", "Lcom/didi/dimina/container/DMConfig;", "appId", "", "path", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiminaLaunchModel.kt */
public final class DiminaLaunchModel {
    public static final String ANTI_EVENT = "antiEvent";
    public static final String APP_ID = "appid";
    public static final String BUNDLE_LOCAL_PATH = "dimina/bundle/";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PATH = "path";
    public static final String PRODUCT_LINE = "productLine";

    /* renamed from: a */
    private final Fragment f45170a;

    public DiminaLaunchModel(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f45170a = fragment;
    }

    public final Fragment getFragment() {
        return this.f45170a;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/wallet/dimina/DiminaLaunchModel$Companion;", "", "()V", "ANTI_EVENT", "", "APP_ID", "BUNDLE_LOCAL_PATH", "PATH", "PRODUCT_LINE", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DiminaLaunchModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void launchDimina(Bundle bundle) {
        Fragment fragment = this.f45170a;
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        String str = null;
        DMNavigator dMNavigator = new DMNavigator(getFragment().requireActivity().getSupportFragmentManager(), getFragment().getChildFragmentManager(), R.id.container, m32447a() ? getFragment().requireActivity() : null);
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            str = arguments.getString(WalletDiminaFragment.DIMINA_ROUTER_URL);
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            dMNavigator.closePage();
        } else if (str != null) {
            Uri parse = Uri.parse(StringsKt.trim(charSequence).toString());
            DMConfig a = m32445a(parse.getQueryParameter("appid"), parse.getQueryParameter("path"));
            if (a == null) {
                dMNavigator.closePage();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(parse, "diminaUri");
            m32446a(parse, (Function1<? super Boolean, Unit>) new DiminaLaunchModel$launchDimina$1$1(fragment, a, dMNavigator));
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    /* renamed from: a */
    private final DMConfig m32445a(String str, String str2) {
        String string;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        DMConfig4Di dMConfig4Di = new DMConfig4Di(this.f45170a.requireContext());
        dMConfig4Di.getLaunchConfig().setAppId(str);
        if (str2 != null) {
            dMConfig4Di.getLaunchConfig().setEntryPath(str2);
        }
        dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new ReleaseBundleMangerStrategy(Intrinsics.stringPlus("dimina/bundle/", str)));
        dMConfig4Di.getLaunchConfig().setEngineFactory(new DiminaLaunchModel$loadConfig$2());
        Bundle arguments = this.f45170a.getArguments();
        if (!(arguments == null || (string = arguments.getString(WalletDiminaFragment.DIMINA_ROUTER_URL)) == null)) {
            JSONObject jSONObject = new JSONObject();
            Uri parse = Uri.parse(StringsKt.trim(string).toString());
            if (parse != null) {
                for (String next : parse.getQueryParameterNames()) {
                    jSONObject.put(next, parse.getQueryParameter(next));
                }
                dMConfig4Di.getLaunchConfig().setExtraOptions(jSONObject);
            }
        }
        return dMConfig4Di;
    }

    /* renamed from: a */
    private final void m32446a(Uri uri, Function1<? super Boolean, Unit> function1) {
        Fragment fragment = this.f45170a;
        HashMap<String, Object> httpBaseParams = PayBaseParamUtil.getHttpBaseParams(fragment.requireContext());
        Intrinsics.checkNotNullExpressionValue(httpBaseParams, "getHttpBaseParams(requireContext())");
        String queryParameter = uri.getQueryParameter(ANTI_EVENT);
        if (queryParameter == null) {
            queryParameter = null;
        } else {
            httpBaseParams.put("event", queryParameter);
        }
        CharSequence charSequence = queryParameter;
        if (charSequence == null || charSequence.length() == 0) {
            function1.invoke(true);
            return;
        }
        String queryParameter2 = uri.getQueryParameter(PRODUCT_LINE);
        if (queryParameter2 != null) {
            httpBaseParams.put(PRODUCT_LINE, queryParameter2);
        }
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        WalletDiminaRpcKt.walletDiminaRpcService(requireContext).checkAntiCheating(httpBaseParams, new DiminaLaunchModel$checkAntiCheating$1$2(function1, fragment));
    }

    /* renamed from: a */
    private final boolean m32447a() {
        Bundle arguments = this.f45170a.getArguments();
        return arguments != null && arguments.getBoolean(WalletDiminaFragment.IS_NEED_FINISH_ACTIVITY, false);
    }
}

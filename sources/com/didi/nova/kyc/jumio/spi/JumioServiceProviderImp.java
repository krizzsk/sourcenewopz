package com.didi.nova.kyc.jumio.spi;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import com.didi.nova.kyc.jumio.DDCustomActivity;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.commonsdk.spi.JumioServiceProvider;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.jumio.sdk.JumioSDK;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/spi/JumioServiceProviderImp;", "Lcom/didi/payment/commonsdk/spi/JumioServiceProvider;", "()V", "checkPermissions", "", "ctx", "Landroid/app/Activity;", "isSupportedPlatform", "startDDCustomActivity", "", "activity", "token", "", "dateCenter", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioServiceProviderImp.kt */
public final class JumioServiceProviderImp implements JumioServiceProvider {
    public boolean isSupportedPlatform(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "ctx");
        Context context = activity;
        if (JumioSDK.Companion.isSupportedPlatform(context)) {
            return true;
        }
        WalletToastNew.showFailedMsg(context, ApplicationContextProvider.Companion.getContext().getResources().getString(R.string.GRider_wording4_Sorry_the_oXoZ));
        KycOmega.Companion.trackEvent("fin_fullkycjumio_no_supported_platform_ex");
        activity.finish();
        return false;
    }

    public boolean checkPermissions(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "ctx");
        Context context = activity;
        if (JumioSDK.Companion.hasAllRequiredPermissions(context)) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, JumioSDK.Companion.getMissingPermissions(context), 303);
        return false;
    }

    public void startDDCustomActivity(Activity activity, String str, String str2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "token");
        DDCustomActivity.Companion.startActivity(activity, str, str2);
    }
}

package atd.p044r0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import java.util.Collection;

/* renamed from: atd.r0.e */
public final class C1158e {
    /* renamed from: a */
    public static boolean m728a(Context context, Collection<String> collection) {
        String installerPackageName;
        PackageManager packageManager = context.getPackageManager();
        if (!(packageManager == null || (installerPackageName = packageManager.getInstallerPackageName(context.getPackageName())) == null || installerPackageName.isEmpty())) {
            for (String equals : collection) {
                if (equals.equals(installerPackageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Signature[] m729a(Context context) {
        Signature[] signatureArr;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = SystemUtils.getPackageInfo(packageManager, context.getPackageName(), View.NAVIGATION_BAR_TRANSIENT).signingInfo;
                signatureArr = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            } else {
                signatureArr = SystemUtils.getPackageInfo(packageManager, context.getPackageName(), 64).signatures;
            }
            return signatureArr;
        } catch (PackageManager.NameNotFoundException unused) {
            return new Signature[0];
        }
    }
}

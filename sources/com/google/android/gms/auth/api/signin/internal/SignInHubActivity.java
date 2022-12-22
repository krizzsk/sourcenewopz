package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.C13565R2;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SignInHubActivity extends FragmentActivity {
    private static boolean zba = false;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    /* access modifiers changed from: private */
    public int zbe;
    /* access modifiers changed from: private */
    public Intent zbf;

    private final void zbc() {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new zbw(this, (zbv) null));
        zba = false;
    }

    private final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent, C13565R2.styleable.yoga_yg_minHeight);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            SystemUtils.log(5, "AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...", (Throwable) null, "com.google.android.gms.auth.api.signin.internal.SignInHubActivity", 7);
            zbd(17);
        }
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (!this.zbb) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.zba() != null) {
                        GoogleSignInAccount zba2 = signInAccount.zba();
                        zbn zbc2 = zbn.zbc(this);
                        GoogleSignInOptions zba3 = this.zbc.zba();
                        if (zba2 != null) {
                            zbc2.zbe(zba3, zba2);
                            intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                            intent.putExtra("googleSignInAccount", zba2);
                            this.zbd = true;
                            this.zbe = i2;
                            this.zbf = intent;
                            zbc();
                            return;
                        }
                        throw null;
                    } else if (intent.hasExtra(Constants.ERROR_CODE)) {
                        int intExtra = intent.getIntExtra(Constants.ERROR_CODE, 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        zbd(intExtra);
                        return;
                    }
                }
                zbd(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            throw null;
        } else if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            if (bundleExtra != null) {
                SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
                if (signInConfiguration == null) {
                    SystemUtils.log(6, "AuthSignInClient", "Activity started with invalid configuration.", (Throwable) null, "com.google.android.gms.auth.api.signin.internal.SignInHubActivity", 9);
                    setResult(0);
                    finish();
                    return;
                }
                this.zbc = signInConfiguration;
                if (bundle != null) {
                    boolean z = bundle.getBoolean("signingInGoogleApiClients");
                    this.zbd = z;
                    if (z) {
                        this.zbe = bundle.getInt("signInResultCode");
                        Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                        if (intent2 != null) {
                            this.zbf = intent2;
                            zbc();
                            return;
                        }
                        throw null;
                    }
                } else if (zba) {
                    setResult(0);
                    zbd(12502);
                } else {
                    zba = true;
                    zbe(action);
                }
            } else {
                throw null;
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            SystemUtils.log(6, "AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "), (Throwable) null, "com.google.android.gms.auth.api.signin.internal.SignInHubActivity", 21);
            finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }
}

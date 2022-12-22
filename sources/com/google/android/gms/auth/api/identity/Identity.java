package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p216authapi.zbao;
import com.google.android.gms.internal.p216authapi.zbay;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class Identity {
    private Identity() {
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbao((Activity) Preconditions.checkNotNull(activity), new zbc());
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zbay((Activity) Preconditions.checkNotNull(activity), new zbn());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbao((Context) Preconditions.checkNotNull(context), new zbc());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zbay((Context) Preconditions.checkNotNull(context), new zbn());
    }
}

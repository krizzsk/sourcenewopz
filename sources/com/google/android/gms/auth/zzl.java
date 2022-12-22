package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzcz;
import com.google.android.gms.internal.auth.zze;
import com.google.android.gms.internal.auth.zzg;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzhj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};
    public static final String zzb = "androidPackageName";
    private static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    /* access modifiers changed from: private */
    public static final Logger zzd = zzd.zza("GoogleAuthUtil");

    zzl() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(zzb)) {
            bundle.putString(zzb, str2);
        }
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            zzg zza2 = zzh.zza(context);
            zzbw zzbw = new zzbw();
            zzbw.zza(str);
            try {
                zzh(zza2.zza(zzbw), "clear token");
                return;
            } catch (ApiException e) {
                zzk(e, "clear token");
            }
        }
        zzg(context, zzc, new zzh(str, bundle));
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        AccountChangeEventsRequest accountChangeEventsRequest = new AccountChangeEventsRequest();
        accountChangeEventsRequest.setAccountName(str);
        accountChangeEventsRequest.setEventIndex(i);
        zzcz.zze(context);
        if (zzhj.zzd() && zzm(context)) {
            try {
                AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzh(zzh.zza(context).zzb(accountChangeEventsRequest), "account change events retrieval");
                zzi(accountChangeEventsResponse);
                return accountChangeEventsResponse.getEvents();
            } catch (ApiException e) {
                zzk(e, "account change events retrieval");
            }
        }
        return (List) zzg(context, zzc, new zzi(accountChangeEventsRequest));
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        zzj(context, 8400000);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    public static Bundle removeAccount(Context context, Account account) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzl(account);
        zzj(context, 8400000);
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle = (Bundle) zzh(zzh.zza(context).zzd(account), "account removal");
                zzi(bundle);
                return bundle;
            } catch (ApiException e) {
                zzk(e, "account removal");
            }
        }
        return (Bundle) zzg(context, zzc, new zzf(account));
    }

    public static Boolean requestGoogleAccountsAccess(Context context) throws GoogleAuthException, IOException {
        Preconditions.checkNotNull(context);
        zzj(context, 11400000);
        String str = context.getApplicationInfo().packageName;
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle = (Bundle) zzh(zzh.zza(context).zze(str), "google accounts access request");
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                zzby zza2 = zzby.zza(string);
                if (zzby.SUCCESS.equals(zza2)) {
                    return true;
                }
                if (zzby.zzb(zza2)) {
                    Logger logger = zzd;
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
                    sb.append("isUserRecoverableError status: ");
                    sb.append(valueOf);
                    logger.mo136184w("GoogleAuthUtil", sb.toString());
                    throw new UserRecoverableAuthException(string, intent);
                }
                throw new GoogleAuthException(string);
            } catch (ApiException e) {
                zzk(e, "google accounts access request");
            }
        }
        return (Boolean) zzg(context, zzc, new zzj(str));
    }

    public static TokenData zza(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zzl(account);
        zzj(context, 8400000);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(zzb))) {
            bundle2.putString(zzb, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        zzcz.zze(context);
        if (zzhj.zze() && zzm(context)) {
            try {
                Bundle bundle3 = (Bundle) zzh(zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                zzi(bundle3);
                return zzf(bundle3);
            } catch (ApiException e) {
                zzk(e, "token retrieval");
            }
        }
        return (TokenData) zzg(context, zzc, new zzg(account, str, bundle2));
    }

    static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zze = zze.zzb(iBinder).zze(account, str, bundle);
        if (zze != null) {
            return zzf(zze);
        }
        throw new IOException("Service call returned null");
    }

    private static TokenData zzf(Bundle bundle) throws GoogleAuthException, IOException {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (zzby.zzb(zza2)) {
            Logger logger = zzd;
            String valueOf = String.valueOf(zza2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            logger.mo136184w("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        } else if (zzby.zze.equals(zza2) || zzby.zzf.equals(zza2) || zzby.INTNERNAL_ERROR.equals(zza2) || zzby.AUTH_SECURITY_ERROR.equals(zza2)) {
            throw new IOException(string);
        } else {
            throw new GoogleAuthException(string);
        }
    }

    private static <T> T zzg(Context context, ComponentName componentName, zzk<T> zzk) throws IOException, GoogleAuthException {
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor instance = GmsClientSupervisor.getInstance(context);
        try {
            if (instance.bindService(componentName, (ServiceConnection) blockingServiceConnection, "GoogleAuthUtil")) {
                try {
                    T zza2 = zzk.zza(blockingServiceConnection.getService());
                    instance.unbindService(componentName, (ServiceConnection) blockingServiceConnection, "GoogleAuthUtil");
                    return zza2;
                } catch (RemoteException | InterruptedException e) {
                    SystemUtils.log(4, "GoogleAuthUtil", "Error on service connection.", e, "com.google.android.gms.auth.zzl", 7);
                    throw new IOException("Error on service connection.", e);
                } catch (Throwable th) {
                    instance.unbindService(componentName, (ServiceConnection) blockingServiceConnection, "GoogleAuthUtil");
                    throw th;
                }
            } else {
                throw new IOException("Could not bind to service.");
            }
        } catch (SecurityException e2) {
            SystemUtils.log(5, "GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", new Object[]{e2.getMessage()}), (Throwable) null, "com.google.android.gms.auth.zzl", 4);
            throw new IOException("SecurityException while binding to Auth service.", e2);
        }
    }

    private static <ResultT> ResultT zzh(Task<ResultT> task, String str) throws IOException, ApiException {
        try {
            return Tasks.await(task);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String format = String.format("Unable to get a result for %s due to ExecutionException.", new Object[]{str});
            zzd.mo136184w(format, new Object[0]);
            throw new IOException(format, e);
        } catch (InterruptedException e2) {
            String format2 = String.format("Interrupted while waiting for the task of %s to finish.", new Object[]{str});
            zzd.mo136184w(format2, new Object[0]);
            throw new IOException(format2, e2);
        } catch (CancellationException e3) {
            String format3 = String.format("Canceled while waiting for the task of %s to finish.", new Object[]{str});
            zzd.mo136184w(format3, new Object[0]);
            throw new IOException(format3, e3);
        }
    }

    /* access modifiers changed from: private */
    public static <T> T zzi(T t) throws IOException {
        if (t != null) {
            return t;
        }
        zzd.mo136184w("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    private static void zzj(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesIncorrectManifestValueException | GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage(), e2);
        }
    }

    private static void zzk(ApiException apiException, String str) {
        zzd.mo136184w("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    private static boolean zzm(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        String str = context.getApplicationInfo().packageName;
        for (String equals : zzhj.zzb().zzm()) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzl(account);
        return zza(context, account, str, bundle).zza();
    }

    static void zze(Intent intent) {
        if (intent != null) {
            try {
                Intent.parseUri(intent.toUri(1), 1);
            } catch (URISyntaxException unused) {
                throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            }
        } else {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
    }

    private static void zzl(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (!TextUtils.isEmpty(account.name)) {
            String[] strArr = zza;
            int i = 0;
            while (i < 3) {
                if (!strArr[i].equals(account.type)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        } else {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }
}

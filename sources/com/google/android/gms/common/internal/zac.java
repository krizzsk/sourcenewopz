package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.p006os.ConfigurationCompat;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.taxis99.R;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zac {
    private static final SimpleArrayMap zaa = new SimpleArrayMap();
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    public static String zad(Context context, int i) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zaa2});
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zaa2});
            } else if (i == 5) {
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                if (i == 7) {
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zaa2});
                } else if (i == 20) {
                    return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                } else {
                    switch (i) {
                        case 16:
                            return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                        case 17:
                            return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zaa2});
                        default:
                            return resources.getString(R.string.common_google_play_services_unknown_issue, new Object[]{zaa2});
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zaa2});
        }
    }

    public static String zaf(Context context, int i) {
        String str;
        if (i == 6) {
            str = zai(context, "common_google_play_services_resolution_required_title");
        } else {
            str = zag(context, i);
        }
        return str == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : str;
    }

    public static String zag(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                SystemUtils.log(6, "GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.", (Throwable) null, "com.google.android.gms.common.internal.zac", 13);
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                SystemUtils.log(6, "GoogleApiAvailability", "Network error occurred. Please retry request later.", (Throwable) null, "com.google.android.gms.common.internal.zac", 11);
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                SystemUtils.log(6, "GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information", (Throwable) null, "com.google.android.gms.common.internal.zac", 10);
                return null;
            case 9:
                SystemUtils.log(6, "GoogleApiAvailability", "Google Play services is invalid. Cannot recover.", (Throwable) null, "com.google.android.gms.common.internal.zac", 9);
                return null;
            case 10:
                SystemUtils.log(6, "GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information", (Throwable) null, "com.google.android.gms.common.internal.zac", 8);
                return null;
            case 11:
                SystemUtils.log(6, "GoogleApiAvailability", "The application is not licensed to the user.", (Throwable) null, "com.google.android.gms.common.internal.zac", 7);
                return null;
            case 16:
                SystemUtils.log(6, "GoogleApiAvailability", "One of the API components you attempted to connect to is not available.", (Throwable) null, "com.google.android.gms.common.internal.zac", 6);
                return null;
            case 17:
                SystemUtils.log(6, "GoogleApiAvailability", "The specified account could not be signed in.", (Throwable) null, "com.google.android.gms.common.internal.zac", 4);
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                SystemUtils.log(6, "GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.", (Throwable) null, "com.google.android.gms.common.internal.zac", 2);
                return zai(context, "common_google_play_services_restricted_profile_title");
            default:
                SystemUtils.log(6, "GoogleApiAvailability", "Unexpected error code " + i, (Throwable) null, "com.google.android.gms.common.internal.zac", 18);
                return null;
        }
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, new Object[]{str2});
    }

    private static String zai(Context context, String str) {
        synchronized (zaa) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(zab)) {
                zaa.clear();
                zab = locale;
            }
            String str2 = (String) zaa.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, TypedValues.Custom.S_STRING, "com.google.android.gms");
            if (identifier == 0) {
                SystemUtils.log(5, "GoogleApiAvailability", "Missing resource: " + str, (Throwable) null, "com.google.android.gms.common.internal.zac", 10);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                SystemUtils.log(5, "GoogleApiAvailability", "Got empty resource: " + str, (Throwable) null, "com.google.android.gms.common.internal.zac", 14);
                return null;
            }
            zaa.put(str, string);
            return string;
        }
    }

    public static String zae(Context context, int i) {
        if (i == 6 || i == 19) {
            return zah(context, "common_google_play_services_resolution_required_text", zaa(context));
        }
        return zad(context, i);
    }
}

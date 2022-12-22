package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzp {
    private final Application zza;
    private final zzab zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzal zze;
    private final zzaz zzf;
    private final zzn zzg;
    private final zzz zzh;
    private final zze zzi;

    zzp(Application application, zzab zzab, Handler handler, Executor executor, zzal zzal, zzaz zzaz, zzn zzn, zzz zzz, zze zze2) {
        this.zza = application;
        this.zzb = zzab;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzal;
        this.zzf = zzaz;
        this.zzg = zzn;
        this.zzh = zzz;
        this.zzi = zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzd.execute(new zzs(this, activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener));
    }

    private final zzby zza(zzbn zzbn) throws zzk {
        try {
            return zzb(zzbn);
        } catch (SocketTimeoutException e) {
            throw new zzk(4, "The server timed out.", e);
        } catch (IOException e2) {
            throw new zzk(2, "Error making request.", e2);
        }
    }

    private final zzby zzb(zzbn zzbn) throws IOException {
        String str;
        JsonWriter jsonWriter;
        JsonReader jsonReader;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection();
        Application application = this.zza;
        if (Build.VERSION.SDK_INT >= 17) {
            str = WebSettings.getDefaultUserAgent(application);
        } else {
            str = new WebView(application).getSettings().getUserAgentString();
        }
        httpURLConnection.setRequestProperty("User-Agent", str);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
        try {
            jsonWriter = new JsonWriter(outputStreamWriter);
            jsonWriter.beginObject();
            String str2 = zzbn.zza;
            if (str2 != null) {
                jsonWriter.name("admob_app_id");
                jsonWriter.value(str2);
            }
            String str3 = zzbn.zzb;
            if (str3 != null) {
                jsonWriter.name(Constants.JSON_KEY_ANDID);
                jsonWriter.value(str3);
            }
            zzbr zzbr = zzbn.zzc;
            if (zzbr != null) {
                jsonWriter.name(DeviceRequestsHelper.DEVICE_INFO_PARAM);
                jsonWriter.beginObject();
                int i = zzbr.zza;
                if (i != zzbu.zza) {
                    jsonWriter.name("os_type");
                    zzbu.zza(i, jsonWriter);
                }
                String str4 = zzbr.zzb;
                if (str4 != null) {
                    jsonWriter.name("model");
                    jsonWriter.value(str4);
                }
                Integer num = zzbr.zzc;
                if (num != null) {
                    jsonWriter.name("android_api_level");
                    jsonWriter.value(num);
                }
                jsonWriter.endObject();
            }
            String str5 = zzbn.zzd;
            if (str5 != null) {
                jsonWriter.name("publisher_privacy_policy_url");
                jsonWriter.value(str5);
            }
            String str6 = zzbn.zze;
            if (str6 != null) {
                jsonWriter.name("language_code");
                jsonWriter.value(str6);
            }
            String str7 = zzbn.zzf;
            if (str7 != null) {
                jsonWriter.name("country_code_if_unknown_region");
                jsonWriter.value(str7);
            }
            Boolean bool = zzbn.zzg;
            if (bool != null) {
                jsonWriter.name("opt_out_if_unknown_region");
                jsonWriter.value(bool.booleanValue());
            }
            Boolean bool2 = zzbn.zzh;
            if (bool2 != null) {
                jsonWriter.name("tag_for_under_age_of_consent");
                jsonWriter.value(bool2.booleanValue());
            }
            Boolean bool3 = zzbn.zzi;
            if (bool3 != null) {
                jsonWriter.name("is_lat");
                jsonWriter.value(bool3.booleanValue());
            }
            Map<String, String> map = zzbn.zzj;
            if (!map.isEmpty()) {
                jsonWriter.name("stored_infos_map");
                jsonWriter.beginObject();
                for (Map.Entry next : map.entrySet()) {
                    jsonWriter.name((String) next.getKey());
                    jsonWriter.value((String) next.getValue());
                }
                jsonWriter.endObject();
            }
            zzbt zzbt = zzbn.zzk;
            if (zzbt != null) {
                jsonWriter.name("screen_info");
                jsonWriter.beginObject();
                Integer num2 = zzbt.zza;
                if (num2 != null) {
                    jsonWriter.name("width");
                    jsonWriter.value(num2);
                }
                Integer num3 = zzbt.zzb;
                if (num3 != null) {
                    jsonWriter.name("height");
                    jsonWriter.value(num3);
                }
                Double d = zzbt.zzc;
                if (d != null) {
                    jsonWriter.name("density");
                    jsonWriter.value(d);
                }
                List<zzbw> list = zzbt.zzd;
                if (!list.isEmpty()) {
                    jsonWriter.name("screen_insets");
                    jsonWriter.beginArray();
                    for (zzbw next2 : list) {
                        jsonWriter.beginObject();
                        Integer num4 = next2.zza;
                        if (num4 != null) {
                            jsonWriter.name("top");
                            jsonWriter.value(num4);
                        }
                        Integer num5 = next2.zzb;
                        if (num5 != null) {
                            jsonWriter.name("left");
                            jsonWriter.value(num5);
                        }
                        Integer num6 = next2.zzc;
                        if (num6 != null) {
                            jsonWriter.name("right");
                            jsonWriter.value(num6);
                        }
                        Integer num7 = next2.zzd;
                        if (num7 != null) {
                            jsonWriter.name("bottom");
                            jsonWriter.value(num7);
                        }
                        jsonWriter.endObject();
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }
            zzbp zzbp = zzbn.zzl;
            if (zzbp != null) {
                jsonWriter.name("app_info");
                jsonWriter.beginObject();
                String str8 = zzbp.zza;
                if (str8 != null) {
                    jsonWriter.name(GlobalCashierCoreModule.PACKAGE_NAME);
                    jsonWriter.value(str8);
                }
                String str9 = zzbp.zzb;
                if (str9 != null) {
                    jsonWriter.name("publisher_display_name");
                    jsonWriter.value(str9);
                }
                String str10 = zzbp.zzc;
                if (str10 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str10);
                }
                jsonWriter.endObject();
            }
            zzbv zzbv = zzbn.zzm;
            if (zzbv != null) {
                jsonWriter.name("sdk_info");
                jsonWriter.beginObject();
                String str11 = zzbv.zza;
                if (str11 != null) {
                    jsonWriter.name("version");
                    jsonWriter.value(str11);
                }
                jsonWriter.endObject();
            }
            List<zzbs> list2 = zzbn.zzn;
            if (!list2.isEmpty()) {
                jsonWriter.name("debug_params");
                jsonWriter.beginArray();
                for (zzbs zza2 : list2) {
                    zza2.zza(jsonWriter);
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
            jsonWriter.close();
            outputStreamWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                if (headerField != null) {
                    zzby zza3 = zzby.zza(new JsonReader(new StringReader(headerField)));
                    zza3.zzb = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                    return zza3;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                try {
                    bufferedReader.readLine();
                    jsonReader = new JsonReader(bufferedReader);
                    zzby zza4 = zzby.zza(jsonReader);
                    jsonReader.close();
                    bufferedReader.close();
                    return zza4;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        zzcj.zza(th, th2);
                    }
                    throw th;
                }
            } else {
                String next3 = new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next();
                StringBuilder sb = new StringBuilder(String.valueOf(next3).length() + 31);
                sb.append("Http error code - ");
                sb.append(responseCode);
                sb.append(".\n");
                sb.append(next3);
                throw new IOException(sb.toString());
            }
            throw th;
            throw th;
        } catch (Throwable th3) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th4) {
                zzcj.zza(th3, th4);
            }
            throw th3;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        onConsentInfoUpdateSuccessListener.getClass();
        handler.post(zzu.zza(onConsentInfoUpdateSuccessListener));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        try {
            ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
            if (consentDebugSettings == null || !consentDebugSettings.isTestDevice()) {
                String zza2 = zzbz.zza((Context) this.zza);
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 95);
                sb.append("Use new ConsentDebugSettings.Builder().addTestDeviceHashedId(\"");
                sb.append(zza2);
                sb.append("\") to set this as a debug device.");
                SystemUtils.log(4, "UserMessagingPlatform", sb.toString(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzp", 211);
            }
            zzy zza3 = new zzaa(this.zzh, zza(this.zzg.zza(activity, consentRequestParameters))).zza();
            this.zze.zza(zza3.zza);
            this.zze.zzb(zza3.zzb);
            this.zzf.zza(zza3.zzc);
            this.zzi.zza().execute(new zzr(this, onConsentInfoUpdateSuccessListener));
        } catch (zzk e) {
            this.zzc.post(new zzt(onConsentInfoUpdateFailureListener, e));
        } catch (RuntimeException e2) {
            String valueOf = String.valueOf(Log.getStackTraceString(e2));
            this.zzc.post(new zzw(onConsentInfoUpdateFailureListener, new zzk(1, valueOf.length() != 0 ? "Caught exception when trying to request consent info update: ".concat(valueOf) : new String("Caught exception when trying to request consent info update: "))));
        }
    }
}

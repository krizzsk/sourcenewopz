package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.p003v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import com.yanzhenjie.permission.runtime.Permission;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbfa extends WebChromeClient {
    private final zzbfi zzdkm;

    public zzbfa(zzbfi zzbfi) {
        this.zzdkm = zzbfi;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zza zzadl;
        try {
            if (this.zzdkm == null || this.zzdkm.zzaef() == null || this.zzdkm.zzaef().zzadl() == null || (zzadl = this.zzdkm.zzaef().zzadl()) == null || zzadl.zzkc()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    SystemUtils.showDialog(builder.setView(linearLayout).setPositiveButton(17039370, new zzbfg(jsPromptResult, editText)).setNegativeButton(17039360, new zzbfd(jsPromptResult)).setOnCancelListener(new zzbfe(jsPromptResult)).create());
                } else {
                    SystemUtils.showDialog(builder.setMessage(str3).setPositiveButton(17039370, new zzbfb(jsResult)).setNegativeButton(17039360, new zzbfc(jsResult)).setOnCancelListener(new zzbez(jsResult)).create());
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzadl.zzbk(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzd.zzd("Fail to display Dialog.", e);
        }
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzdkm.zzaeg() != null) {
            webView2.setWebViewClient(this.zzdkm.zzaeg());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbfi)) {
            zzd.zzez("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zze zzaeb = ((zzbfi) webView).zzaeb();
        if (zzaeb == null) {
            zzd.zzez("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaeb.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzbff.zzesv[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzd.zzex(sb2);
        } else if (i == 2) {
            zzd.zzez(sb2);
        } else if (i == 3 || i == 4) {
            zzd.zzey(sb2);
        } else if (i != 5) {
            zzd.zzey(sb2);
        } else {
            zzd.zzdz(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        zze zzaeb = this.zzdkm.zzaeb();
        if (zzaeb == null) {
            zzd.zzez("Could not get ad overlay when hiding custom view.");
        } else {
            zzaeb.zzwf();
        }
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbfi)) {
            return webView.getContext();
        }
        zzbfi zzbfi = (zzbfi) webView;
        Activity zzabx = zzbfi.zzabx();
        if (zzabx != null) {
            return zzabx;
        }
        return zzbfi.getContext();
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), XPanelScene.SCENE_CONFIRM, str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zze zzaeb = this.zzdkm.zzaeb();
        if (zzaeb == null) {
            zzd.zzez("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzaeb.zza(view, customViewCallback);
        zzaeb.setRequestedOrientation(i);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzr.zzkv();
            if (!zzj.zzp(this.zzdkm.getContext(), Permission.ACCESS_FINE_LOCATION)) {
                zzr.zzkv();
                if (!zzj.zzp(this.zzdkm.getContext(), Permission.ACCESS_COARSE_LOCATION)) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }
}

package com.didichuxing.omega.sdk.feedback.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didichuxing.afanty.AfantySDK;
import com.didichuxing.afanty.common.collector.PackageCollector;
import com.didichuxing.afanty.common.record.FeedbackRecord;
import com.didichuxing.afanty.common.transport.HttpSender;
import com.didichuxing.afanty.common.utils.CacheFileUtil;
import com.didichuxing.afanty.common.utils.CommonUtil;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.FeatureTeam;
import com.didichuxing.omega.sdk.feedback.FeedbackBitmap;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;
import com.didichuxing.omega.sdk.feedback.NetworkHelper;
import com.didichuxing.omega.sdk.feedback.shake.ShakeConfig;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.feedback.webview.TitleBar;
import com.didichuxing.omega.sdk.feedback.webview.WebAppInterface;
import com.didichuxing.omega.sdk.feedback.wheelUi.SimplePickerPopDialog;
import com.facebook.share.internal.ShareConstants;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class FeedbackWebviewActivity extends FragmentActivity {
    /* access modifiers changed from: private */
    public File cacheFile;
    /* access modifiers changed from: private */
    public ProgressDialog dialog;
    /* access modifiers changed from: private */

    /* renamed from: f1 */
    public int f48483f1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: f2 */
    public int f48484f2 = 0;
    /* access modifiers changed from: private */

    /* renamed from: ft */
    public String f48485ft;
    /* access modifiers changed from: private */
    public FeatureTeam ftm1;
    /* access modifiers changed from: private */
    public FeatureTeam ftm2;
    /* access modifiers changed from: private */
    public WebView myWebView = null;
    /* access modifiers changed from: private */
    public ArrayList<Uri> photo_uris;
    /* access modifiers changed from: private */
    public List<FeatureTeam> test_feature_teams;
    /* access modifiers changed from: private */
    public Uri uri;

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        SystemUtils.hookSetRequestedOrientation(this, 1);
        setContentView((int) R.layout.activity_web_js);
        Intent intent = getIntent();
        this.f48485ft = intent.getStringExtra("ft");
        boolean booleanExtra = intent.getBooleanExtra("reportOmegaServer", false);
        this.myWebView = (WebView) findViewById(R.id.awj_myWebView);
        TitleBar titleBar = (TitleBar) findViewById(R.id.awj_titlebar);
        titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                FeedbackWebviewActivity.this.finish();
            }
        });
        WebSettings settings = this.myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        this.myWebView.setWebViewClient(new WebViewClient());
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        this.myWebView.addJavascriptInterface(new WebInterface(), "AddFeedbackJs");
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            this.myWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.myWebView.removeJavascriptInterface("accessibility");
            this.myWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        WebView webView = this.myWebView;
        webView.addJavascriptInterface(new WebAppInterface(webView), ShakeConfig.JavascriptInterface);
        if (FeedbackConfig.FT_SUG.equals(this.f48485ft)) {
            this.uri = (Uri) intent.getExtras().get(ShareConstants.MEDIA_URI);
            if (booleanExtra) {
                String stringExtra = intent.getStringExtra("result");
                FeedbackConfig.AFANTY_CHOOSE_BUT_TYPE = getString(R.string.afanty_report_bug_choose_bug_type);
                handleFeature(stringExtra);
                this.cacheFile = CacheFileUtil.getCacheFile();
                this.photo_uris = new ArrayList<>(3);
                this.myWebView.loadUrl("file:///android_asset/add_feedback.html");
            } else {
                FeedbackBitmap.getInstance().setScreenshot_uri(this.uri);
                String userToken = SwarmUtil.getUserToken();
                if (userToken == null || userToken.length() == 0) {
                    this.myWebView.loadUrl("file:///android_asset/add_feedback.html");
                } else {
                    this.myWebView.loadUrl(ShakeConfig.getTiyanUrl() + "tiyan_from=" + AfantySDK.getTiyanFrom() + "&tab=1&ticket=" + userToken + ShakeConfig.TIYAN_BID + PackageCollector.getPkgName() + "&os=ANDROID&cityid=" + SwarmUtil.getCityId());
                }
            }
            titleBar.setTitle(getString(R.string.afanty_report_title_sug_report_sug));
            return;
        }
        this.uri = (Uri) intent.getExtras().get(ShareConstants.MEDIA_URI);
        String stringExtra2 = intent.getStringExtra("result");
        FeedbackConfig.AFANTY_CHOOSE_BUT_TYPE = getString(R.string.afanty_report_bug_choose_bug_type);
        handleFeature(stringExtra2);
        this.cacheFile = CacheFileUtil.getCacheFile();
        this.photo_uris = new ArrayList<>(3);
        this.myWebView.loadUrl("file:///android_asset/add_feedback.html");
        titleBar.setTitle(getString(R.string.afanty_report_bug_title_submit_bug));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            setPhoto(intent.getData());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[SYNTHETIC, Splitter:B:28:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getEncodedStr(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ all -> 0x0042 }
            java.io.InputStream r2 = r2.openInputStream(r7)     // Catch:{ all -> 0x0042 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x003e }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003e }
            r4.<init>()     // Catch:{ all -> 0x003e }
        L_0x0014:
            int r1 = r2.read(r3)     // Catch:{ all -> 0x003c }
            r5 = -1
            if (r1 == r5) goto L_0x0020
            r5 = 0
            r4.write(r3, r5, r1)     // Catch:{ all -> 0x003c }
            goto L_0x0014
        L_0x0020:
            byte[] r1 = r4.toByteArray()     // Catch:{ all -> 0x003c }
            r3 = 2
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0033:
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x005e
        L_0x0037:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x005e
        L_0x003c:
            r1 = move-exception
            goto L_0x0046
        L_0x003e:
            r3 = move-exception
            r4 = r1
            r1 = r3
            goto L_0x0046
        L_0x0042:
            r2 = move-exception
            r4 = r1
            r1 = r2
            r2 = r4
        L_0x0046:
            r1.printStackTrace()     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x0053
            r2.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0053:
            if (r4 == 0) goto L_0x005d
            r4.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005d:
            r1 = r0
        L_0x005e:
            if (r1 == 0) goto L_0x0078
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0067
            goto L_0x0078
        L_0x0067:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "data:image/jpg;base64,"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0078:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = r7.toString()
            r1.append(r7)
            java.lang.String r7 = "|||"
            r1.append(r7)
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            return r7
        L_0x0091:
            r7 = move-exception
            if (r2 == 0) goto L_0x009c
            r2.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009c:
            if (r4 == 0) goto L_0x00a6
            r4.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a6:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.getEncodedStr(android.net.Uri):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void setPhoto(Uri uri2) {
        if (uri2 != null) {
            this.photo_uris.add(uri2);
            final String encodedStr = getEncodedStr(uri2);
            WebView webView = this.myWebView;
            if (webView != null) {
                webView.post(new Runnable() {
                    public void run() {
                        FeedbackWebviewActivity.this.myWebView.loadUrl("javascript:fwa_setScreenshot('" + encodedStr + "')");
                    }
                });
            }
        }
    }

    private void handleFeature(String str) {
        List<FeatureTeam> arrayList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            arrayList = NetworkHelper.getFeatureFromJson(str, arrayList);
        }
        if (arrayList == null || arrayList.size() <= 0) {
            ArrayList arrayList2 = new ArrayList(1);
            FeatureTeam featureTeam = new FeatureTeam();
            featureTeam.setHasSub(false);
            featureTeam.setHasCW(false);
            featureTeam.setId(0);
            featureTeam.setName(getString(R.string.afanty_report_bug_empty));
            arrayList2.add(featureTeam);
            this.test_feature_teams = arrayList2;
            return;
        }
        this.test_feature_teams = arrayList;
    }

    public class WebInterface {
        public WebInterface() {
        }

        @JavascriptInterface
        public void getwheel1() {
            if (FeedbackWebviewActivity.this.test_feature_teams != null && FeedbackWebviewActivity.this.test_feature_teams.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (FeatureTeam name : FeedbackWebviewActivity.this.test_feature_teams) {
                    arrayList.add(name.getName());
                }
                SimplePickerPopDialog newInstance = SimplePickerPopDialog.newInstance(arrayList, new SimplePickerPopDialog.OnItemSelectListener() {
                    public void onConfirmed(int i) {
                        if (FeedbackWebviewActivity.this.test_feature_teams != null && FeedbackWebviewActivity.this.test_feature_teams.size() > 0) {
                            FeatureTeam unused = FeedbackWebviewActivity.this.ftm1 = (FeatureTeam) FeedbackWebviewActivity.this.test_feature_teams.get(i);
                            if (FeedbackWebviewActivity.this.ftm1 != null) {
                                int unused2 = FeedbackWebviewActivity.this.f48483f1 = FeedbackWebviewActivity.this.ftm1.getId();
                                FeedbackWebviewActivity.this.setWheel1Text(FeedbackWebviewActivity.this.ftm1.getName());
                                if (FeedbackWebviewActivity.this.ftm1.isHasSub()) {
                                    List<FeatureTeam> featureTeams = FeedbackWebviewActivity.this.ftm1.getFeatureTeams();
                                    if (featureTeams != null && featureTeams.size() > 0) {
                                        FeedbackWebviewActivity.this.setWheel2Text(featureTeams.get(0).getName());
                                    }
                                } else {
                                    FeedbackWebviewActivity.this.setWheel2Text(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_empty));
                                }
                                if (!FeedbackWebviewActivity.this.f48485ft.equals(FeedbackConfig.FT_BUG)) {
                                    return;
                                }
                                if (FeedbackWebviewActivity.this.ftm1.isHasCW()) {
                                    FeedbackWebviewActivity.this.setTextHint(FeedbackWebviewActivity.this.ftm1.getCw());
                                } else {
                                    FeedbackWebviewActivity.this.setTextHint(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_hint_input_desc));
                                }
                            }
                        }
                    }
                });
                if (FeedbackWebviewActivity.this.myWebView.getContext() instanceof FragmentActivity) {
                    newInstance.show(((FragmentActivity) FeedbackWebviewActivity.this.myWebView.getContext()).getSupportFragmentManager(), (String) null);
                }
            }
        }

        @JavascriptInterface
        public void getwheel2() {
            ArrayList arrayList = new ArrayList();
            if (FeedbackWebviewActivity.this.test_feature_teams != null && FeedbackWebviewActivity.this.test_feature_teams.size() != 0 && FeedbackWebviewActivity.this.ftm1 != null && FeedbackWebviewActivity.this.ftm1.isHasSub()) {
                for (FeatureTeam name : FeedbackWebviewActivity.this.ftm1.getFeatureTeams()) {
                    arrayList.add(name.getName());
                }
                SimplePickerPopDialog newInstance = SimplePickerPopDialog.newInstance(arrayList, new SimplePickerPopDialog.OnItemSelectListener() {
                    public void onConfirmed(int i) {
                        FeatureTeam unused = FeedbackWebviewActivity.this.ftm2 = FeedbackWebviewActivity.this.ftm1.getFeatureTeams().get(i);
                        if (FeedbackWebviewActivity.this.ftm2 != null) {
                            int unused2 = FeedbackWebviewActivity.this.f48484f2 = FeedbackWebviewActivity.this.ftm2.getId();
                            FeedbackWebviewActivity.this.setWheel2Text(FeedbackWebviewActivity.this.ftm2.getName());
                            if (!FeedbackWebviewActivity.this.f48485ft.equals(FeedbackConfig.FT_BUG)) {
                                return;
                            }
                            if (FeedbackWebviewActivity.this.ftm2.isHasCW()) {
                                FeedbackWebviewActivity.this.setTextHint(FeedbackWebviewActivity.this.ftm2.getCw());
                            } else if (FeedbackWebviewActivity.this.ftm1.isHasCW()) {
                                FeedbackWebviewActivity.this.setTextHint(FeedbackWebviewActivity.this.ftm1.getCw());
                            } else {
                                FeedbackWebviewActivity.this.setTextHint(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_hint_input_desc));
                            }
                        }
                    }
                });
                if (FeedbackWebviewActivity.this.myWebView.getContext() instanceof FragmentActivity) {
                    newInstance.show(((FragmentActivity) FeedbackWebviewActivity.this.myWebView.getContext()).getSupportFragmentManager(), (String) null);
                }
            }
        }

        @JavascriptInterface
        public void addphoto() {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
            Activity currentActivity = SwarmUtil.getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivityForResult(intent, 100);
            }
        }

        @JavascriptInterface
        public void removephoto(String str) {
            for (int i = 0; i < FeedbackWebviewActivity.this.photo_uris.size(); i++) {
                if (((Uri) FeedbackWebviewActivity.this.photo_uris.get(i)).toString().equals(str)) {
                    FeedbackWebviewActivity.this.photo_uris.remove(i);
                    return;
                }
            }
        }

        @JavascriptInterface
        public void getScreenShot() {
            FeedbackWebviewActivity feedbackWebviewActivity = FeedbackWebviewActivity.this;
            feedbackWebviewActivity.setPhoto(feedbackWebviewActivity.uri);
        }

        @JavascriptInterface
        public void getHint() {
            if (FeedbackWebviewActivity.this.f48485ft.equals(FeedbackConfig.FT_BUG)) {
                FeedbackWebviewActivity feedbackWebviewActivity = FeedbackWebviewActivity.this;
                feedbackWebviewActivity.setTextHint(feedbackWebviewActivity.getString(R.string.afanty_report_bug_hint_input_desc));
                FeedbackWebviewActivity feedbackWebviewActivity2 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity2.setWheel1Text(feedbackWebviewActivity2.getString(R.string.afanty_report_bug_choose_bug_type));
                FeedbackWebviewActivity feedbackWebviewActivity3 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity3.setWheel2Text(feedbackWebviewActivity3.getString(R.string.afanty_report_bug_empty));
                FeedbackWebviewActivity feedbackWebviewActivity4 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity4.setSendButtonText(feedbackWebviewActivity4.getString(R.string.afanty_send));
            } else if (FeedbackWebviewActivity.this.f48485ft.equals(FeedbackConfig.FT_SUG)) {
                FeedbackWebviewActivity feedbackWebviewActivity5 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity5.setTextHint(feedbackWebviewActivity5.getString(R.string.afanty_report_bug_input_info_hint));
                FeedbackWebviewActivity feedbackWebviewActivity6 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity6.setWheel1Text(feedbackWebviewActivity6.getString(R.string.afanty_report_bug_choose_bug_type));
                FeedbackWebviewActivity feedbackWebviewActivity7 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity7.setWheel2Text(feedbackWebviewActivity7.getString(R.string.afanty_report_bug_empty));
                FeedbackWebviewActivity feedbackWebviewActivity8 = FeedbackWebviewActivity.this;
                feedbackWebviewActivity8.setSendButtonText(feedbackWebviewActivity8.getString(R.string.afanty_send));
            }
        }

        @JavascriptInterface
        public void sendmessage(String str) {
            int i;
            String userPhone = SwarmUtil.getUserPhone();
            if (userPhone == null || userPhone.isEmpty()) {
                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_err_phone));
                return;
            }
            if (FeedbackWebviewActivity.this.f48484f2 == 0) {
                i = FeedbackWebviewActivity.this.f48483f1;
            } else {
                i = FeedbackWebviewActivity.this.f48484f2;
            }
            final FeedbackRecord fr = FeedbackBitmap.getInstance().getFr();
            if (fr == null) {
                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_err_system_info));
                return;
            }
            final String str2 = (String) fr.get("rid");
            final String str3 = (String) fr.get("oid");
            final String str4 = (String) fr.get("pn");
            if (str4 == null || str4.isEmpty()) {
                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_err_phone));
            } else if (str2 == null || str2.length() == 0) {
                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_err_system_info));
            } else if (str3 == null || str3.length() == 0) {
                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_err_device_info));
            } else {
                fr.setFeedbackType(FeedbackWebviewActivity.this.f48485ft);
                fr.setFeatureTeam(i);
                fr.setFeedbackContent(str);
                FeedbackWebviewActivity feedbackWebviewActivity = FeedbackWebviewActivity.this;
                ProgressDialog unused = feedbackWebviewActivity.dialog = ProgressDialog.show(feedbackWebviewActivity, (CharSequence) null, (CharSequence) null, true, false);
                new Thread(new Runnable() {
                    public void run() {
                        WebInterface webInterface = WebInterface.this;
                        File access$1500 = webInterface.saveRecord(fr, FeedbackWebviewActivity.this.photo_uris);
                        boolean z = false;
                        if (access$1500.exists()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("msgid", str2);
                            hashMap.put("oid", str3);
                            hashMap.put("phone", str4);
                            String dopost = HttpSender.dopost("http://omgup.didiglobal.com/feedback/up/android", access$1500, hashMap);
                            if (dopost == null || dopost.length() <= 0) {
                                OLog.m32669i("err: http request fail!");
                            } else {
                                try {
                                    JSONObject jSONObject = new JSONObject(dopost);
                                    jSONObject.getInt(C12407a.f36608f);
                                    if (jSONObject.getInt(C12407a.f36608f) == 0) {
                                        z = true;
                                        access$1500.delete();
                                    }
                                } catch (Exception e) {
                                    OLog.m32669i("decode response of upload-feedback fail." + e.toString() + " response:" + dopost);
                                }
                            }
                        } else {
                            OLog.m32669i("err: zipfile not exist!");
                        }
                        Handler handler = new Handler(Looper.getMainLooper());
                        if (z) {
                            FeedbackBitmap.getInstance().setFr((FeedbackRecord) null);
                            handler.post(new Runnable() {
                                public void run() {
                                    if (FeedbackWebviewActivity.this.dialog != null && FeedbackWebviewActivity.this.dialog.isShowing()) {
                                        FeedbackWebviewActivity.this.dialog.dismiss();
                                    }
                                    CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_send_success));
                                    FeedbackWebviewActivity.this.finish();
                                }
                            });
                            return;
                        }
                        handler.post(new Runnable() {
                            public void run() {
                                if (FeedbackWebviewActivity.this.dialog != null && FeedbackWebviewActivity.this.dialog.isShowing()) {
                                    FeedbackWebviewActivity.this.dialog.dismiss();
                                }
                                CommonUtil.toast_send_error(FeedbackWebviewActivity.this.getString(R.string.afanty_report_bug_send_fail_by_neterr));
                            }
                        });
                    }
                }).start();
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:34|(2:36|37)|38|39) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00dd */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[SYNTHETIC, Splitter:B:48:0x00ea] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File saveRecord(com.didichuxing.afanty.common.record.FeedbackRecord r9, java.util.List<android.net.Uri> r10) {
            /*
                r8 = this;
                com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity r0 = com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.this
                java.io.File r0 = r0.cacheFile
                boolean r0 = r0.exists()
                if (r0 != 0) goto L_0x0015
                com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity r0 = com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.this
                java.io.File r0 = r0.cacheFile
                com.didichuxing.afanty.common.utils.CacheFileUtil.createDir(r0)
            L_0x0015:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r9.getRecordId()
                r0.append(r1)
                java.lang.String r1 = ".zip"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.io.File r1 = new java.io.File
                com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity r2 = com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.this
                java.io.File r2 = r2.cacheFile
                r1.<init>(r2, r0)
                boolean r0 = r1.exists()
                if (r0 != 0) goto L_0x00f3
                r0 = 0
                java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                r4.<init>(r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                r3.<init>(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00ee, all -> 0x00e7 }
                java.lang.String r3 = r9.toJson()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                java.lang.String r5 = "0.json"
                r4.<init>(r5)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.putNextEntry(r4)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.write(r3)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.closeEntry()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                byte[] r9 = r9.getLogcat()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                java.lang.String r4 = "1.log"
                r3.<init>(r4)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.putNextEntry(r3)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.write(r9)     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r2.closeEntry()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                if (r10 == 0) goto L_0x00de
                int r9 = r10.size()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                if (r9 <= 0) goto L_0x00de
                r9 = 1024(0x400, float:1.435E-42)
                byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                r3 = 0
                r4 = 0
            L_0x0085:
                int r5 = r10.size()     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
                if (r4 >= r5) goto L_0x00de
                java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x00cc }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
                r6.<init>()     // Catch:{ all -> 0x00cc }
                int r7 = r4 + 2
                r6.append(r7)     // Catch:{ all -> 0x00cc }
                java.lang.String r7 = ".jpg"
                r6.append(r7)     // Catch:{ all -> 0x00cc }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00cc }
                r5.<init>(r6)     // Catch:{ all -> 0x00cc }
                r2.putNextEntry(r5)     // Catch:{ all -> 0x00cc }
                com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity r5 = com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.this     // Catch:{ all -> 0x00cc }
                android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ all -> 0x00cc }
                java.lang.Object r6 = r10.get(r4)     // Catch:{ all -> 0x00cc }
                android.net.Uri r6 = (android.net.Uri) r6     // Catch:{ all -> 0x00cc }
                java.io.InputStream r5 = r5.openInputStream(r6)     // Catch:{ all -> 0x00cc }
            L_0x00b6:
                int r6 = r5.read(r9)     // Catch:{ all -> 0x00ca }
                r7 = -1
                if (r6 == r7) goto L_0x00c1
                r2.write(r9, r3, r6)     // Catch:{ all -> 0x00ca }
                goto L_0x00b6
            L_0x00c1:
                r2.closeEntry()     // Catch:{ all -> 0x00ca }
                if (r5 == 0) goto L_0x00d4
            L_0x00c6:
                r5.close()     // Catch:{ IOException -> 0x00d4 }
                goto L_0x00d4
            L_0x00ca:
                r6 = move-exception
                goto L_0x00ce
            L_0x00cc:
                r6 = move-exception
                r5 = r0
            L_0x00ce:
                r6.printStackTrace()     // Catch:{ all -> 0x00d7 }
                if (r5 == 0) goto L_0x00d4
                goto L_0x00c6
            L_0x00d4:
                int r4 = r4 + 1
                goto L_0x0085
            L_0x00d7:
                r9 = move-exception
                if (r5 == 0) goto L_0x00dd
                r5.close()     // Catch:{ IOException -> 0x00dd }
            L_0x00dd:
                throw r9     // Catch:{ Exception -> 0x00e5, all -> 0x00e2 }
            L_0x00de:
                r2.close()     // Catch:{ IOException -> 0x00f3 }
                goto L_0x00f3
            L_0x00e2:
                r9 = move-exception
                r0 = r2
                goto L_0x00e8
            L_0x00e5:
                r0 = r2
                goto L_0x00ee
            L_0x00e7:
                r9 = move-exception
            L_0x00e8:
                if (r0 == 0) goto L_0x00ed
                r0.close()     // Catch:{ IOException -> 0x00ed }
            L_0x00ed:
                throw r9
            L_0x00ee:
                if (r0 == 0) goto L_0x00f3
                r0.close()     // Catch:{ IOException -> 0x00f3 }
            L_0x00f3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity.WebInterface.saveRecord(com.didichuxing.afanty.common.record.FeedbackRecord, java.util.List):java.io.File");
        }
    }

    /* access modifiers changed from: private */
    public void setTextHint(final String str) {
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    FeedbackWebviewActivity.this.myWebView.loadUrl("javascript:fwa_initDescPlaceHolder('" + str + "')");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setWheel1Text(final String str) {
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    FeedbackWebviewActivity.this.myWebView.loadUrl("javascript:fwa_setwheel1Text('" + str + "')");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setWheel2Text(final String str) {
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    FeedbackWebviewActivity.this.myWebView.loadUrl("javascript:fwa_setwheel2Text('" + str + "')");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setSendButtonText(final String str) {
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.post(new Runnable() {
                public void run() {
                    FeedbackWebviewActivity.this.myWebView.loadUrl("javascript:fwa_setsendButtonText('" + str + "')");
                }
            });
        }
    }
}

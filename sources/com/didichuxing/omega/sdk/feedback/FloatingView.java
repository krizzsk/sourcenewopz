package com.didichuxing.omega.sdk.feedback;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.afanty.AfantySDK;
import com.didichuxing.afanty.beans.SmileMenuItem;
import com.didichuxing.afanty.common.collector.AllCollectorsFacade;
import com.didichuxing.afanty.common.collector.NetworkCollector;
import com.didichuxing.afanty.common.collector.PackageCollector;
import com.didichuxing.afanty.common.record.RecordFactory;
import com.didichuxing.afanty.common.utils.CacheFileUtil;
import com.didichuxing.afanty.common.utils.CommonUtil;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.omega.sdk.feedback.KeyExample;
import com.didichuxing.omega.sdk.feedback.activity.FeedbackListWebviewActivity;
import com.didichuxing.omega.sdk.feedback.activity.FeedbackWebviewActivity;
import com.didichuxing.omega.sdk.feedback.activity.TestOOMActivity;
import com.didichuxing.omega.sdk.feedback.shake.ShakeConfig;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.feedback.webview.neweb.AfantyWebActivity;
import com.didichuxing.omega.sdk.feedback.webview.neweb.WebViewModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewMenuItemListener;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.facebook.share.internal.ShareConstants;
import com.taxis99.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.osgi.framework.BundleContext;

public class FloatingView {
    private static final String bugMonthCount = "bugMonthCount";
    /* access modifiers changed from: private */
    public static Uri currentScreenShotUri = null;
    /* access modifiers changed from: private */
    public static ProgressDialog dialog = null;
    /* access modifiers changed from: private */
    public static String feature_teams_result = null;
    public static volatile boolean isClickReported = false;
    private static boolean isOmegasdkInit = false;
    /* access modifiers changed from: private */
    public static String myFeedbackListjsonStr = null;
    private static final String orderMonthCount = "orderMonthCount";
    /* access modifiers changed from: private */
    public static String personStr = null;
    private static final String sugMonthCount = "sugMonthCount";
    private static final String xcrash_path = "xcrash.XCrash";

    private static void uiInit(Application application) {
        FloatingViewApi.init(application, SwarmUtil.getCurrentActivity());
        FloatingViewApi.addExceptActivity("FeedbackListWebviewActivity");
        FloatingViewApi.addExceptActivity("FeedbackWebviewActivity");
        FloatingViewApi.addExceptActivity("FeedbackDetailWebActivity");
        FloatingViewApi.addExceptActivity("LoginActivity");
        FloatingViewApi.addExceptActivity("AfantyWebActivity");
        FloatingViewApi.addExceptActivity("MapQuickSettingWindowActivity");
        FloatingViewApi.addExceptActivity("MapSettingWindowActivity");
        FloatingViewApi.addExceptActivity("com.didi.map.setting.sdk.haitun.HaitunQuickSettingWindowActivity");
        FloatingViewApi.addExceptActivity("com.didi.map.setting.sdk.MapQuickSettingWindowActivity");
    }

    public static void showUI(Application application) {
        try {
            FeedbackConfig.AFANTY_BUG = application.getString(R.string.afanty_report_bug);
            FeedbackConfig.AFANTY_FEEDBACK = application.getString(R.string.afanty_report_sug);
            FeedbackConfig.AFANTY_MY_FEEDBACK = application.getString(R.string.afanty_my_feedback);
            uiInit(application);
            FloatingViewApi.addSubMenuItem(application.getResources().getDrawable(R.drawable.bug), FeedbackConfig.AFANTY_BUG, new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    FloatingView.startFeedbackWeb(FeedbackConfig.FT_BUG);
                }
            });
            FloatingViewApi.addSubMenuItem(application.getResources().getDrawable(R.drawable.feedback), FeedbackConfig.AFANTY_FEEDBACK, new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    FloatingView.startFeedbackWeb(FeedbackConfig.FT_SUG);
                }
            });
            FloatingViewApi.addSubMenuItem(application.getResources().getDrawable(R.drawable.user), FeedbackConfig.AFANTY_MY_FEEDBACK, new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    FloatingView.startMyFeedbackListWeb();
                }
            });
        } catch (Exception unused) {
        }
    }

    private void makeStackOverflow() {
        new JavaVMStackSOF().stackLeak();
    }

    public static void makeJavaOOM2() {
        HashMap hashMap = new HashMap();
        while (true) {
            for (int i = 0; i < 100000; i++) {
                if (!hashMap.containsKey(new KeyExample.Key(Integer.valueOf(i)))) {
                    KeyExample.Key key = new KeyExample.Key(Integer.valueOf(i));
                    hashMap.put(key, "Number:" + i);
                }
            }
        }
    }

    public static void makeJavaOOM() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(createLongString(1073741824).substring(1, 10));
        }
    }

    private static String createLongString(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('a');
            sb.append(System.nanoTime());
        }
        return sb.toString();
    }

    public static synchronized void makeOOMReport() {
        synchronized (FloatingView.class) {
            if (!isClickReported) {
                Activity currentActivity = SwarmUtil.getCurrentActivity();
                if (currentActivity != null) {
                    isClickReported = true;
                    currentActivity.startActivity(new Intent(currentActivity, TestOOMActivity.class));
                }
            }
        }
    }

    public static void makeNativeCrash() {
        Method method;
        try {
            Class<?> cls = Class.forName(xcrash_path);
            if (cls != null) {
                method = cls.getMethod("testNativeCrash", new Class[]{Boolean.TYPE});
            } else {
                method = null;
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke((Object) null, new Object[]{false});
            }
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            SystemUtils.log(6, "SEE_THIS", "NativeCapture makeCrash failed.", exc, "com.didichuxing.omega.sdk.feedback.FloatingView", 205);
        }
    }

    public static void makeNativeCrashNewThread() {
        Method method;
        try {
            Class<?> cls = Class.forName(xcrash_path);
            if (cls != null) {
                method = cls.getMethod("testNativeCrash", new Class[]{Boolean.TYPE});
            } else {
                method = null;
            }
            if (method != null) {
                method.setAccessible(true);
                method.invoke((Object) null, new Object[]{true});
            }
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            SystemUtils.log(6, "SEE_THIS", "NativeCapture makeCrash failed.", exc, "com.didichuxing.omega.sdk.feedback.FloatingView", 227);
        }
    }

    public static void makeAnr() {
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void makeJavaCrash() {
        LogUtils.m32692e("res=" + (200 / 0));
    }

    public static void makeJavaCrashNewThread() {
        new Thread() {
            public void run() {
                String str = null;
                int length = str.length();
                LogUtils.m32692e("len=" + length);
            }
        }.start();
    }

    public static void makeCarton() {
        try {
            Thread.sleep(Const.DELAY_TIME4LAST_GPS_TASK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeThreadOverload() {
        for (int i = 0; i < 300; i++) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void makeException() {
        String str = null;
        try {
            if (str.length() > 0) {
                LogUtils.m32691d(FloatingView.class.getCanonicalName(), "str长度大于0");
            }
        } catch (Exception e) {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", "18910733630202009271455");
            hashMap.put("version", OmegaSDK.getAppVersion());
            hashMap.put("sdkVersion", OmegaSDK.getSdkVersion());
            hashMap.put("phone", "18910733630");
            Omega.trackError("测试异常分析", "-1", e.getMessage(), hashMap);
        }
    }

    public void makeNetError() {
        new Thread("CubeRequester request") {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
            /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    r0 = 0
                    java.lang.String r1 = "http://omgup.didiglobal.com/static/zhuancheimg/upload/20200507/*.png"
                    java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
                    r2.<init>(r1)     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
                    java.net.URLConnection r1 = r2.openConnection()     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x006e, all -> 0x0069 }
                    java.lang.String r0 = "GET"
                    r1.setRequestMethod(r0)     // Catch:{ Exception -> 0x0067 }
                    r0 = 15000(0x3a98, float:2.102E-41)
                    r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0067 }
                    r1.connect()     // Catch:{ Exception -> 0x0067 }
                    int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x0067 }
                    r2 = 200(0xc8, float:2.8E-43)
                    if (r0 != r2) goto L_0x0050
                    java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x0067 }
                    r2 = 1024(0x400, float:1.435E-42)
                    byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0067 }
                    java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0067 }
                    r3.<init>()     // Catch:{ Exception -> 0x0067 }
                L_0x0030:
                    int r4 = r0.read(r2)     // Catch:{ Exception -> 0x0067 }
                    r5 = -1
                    if (r4 == r5) goto L_0x003c
                    r5 = 0
                    r3.write(r2, r5, r4)     // Catch:{ Exception -> 0x0067 }
                    goto L_0x0030
                L_0x003c:
                    java.lang.String r2 = "utf-8"
                    java.lang.String r2 = r3.toString(r2)     // Catch:{ Exception -> 0x0067 }
                    r3.close()     // Catch:{ Exception -> 0x0067 }
                    r0.close()     // Catch:{ Exception -> 0x0067 }
                    java.lang.String r0 = r7.getName()     // Catch:{ Exception -> 0x0067 }
                    com.didichuxing.apollo.sdk.log.LogUtils.m32691d(r0, r2)     // Catch:{ Exception -> 0x0067 }
                    goto L_0x0064
                L_0x0050:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
                    r2.<init>()     // Catch:{ Exception -> 0x0067 }
                    java.lang.String r3 = "net response code="
                    r2.append(r3)     // Catch:{ Exception -> 0x0067 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0067 }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0067 }
                    com.didichuxing.apollo.sdk.log.LogUtils.m32692e(r0)     // Catch:{ Exception -> 0x0067 }
                L_0x0064:
                    if (r1 == 0) goto L_0x0081
                    goto L_0x007e
                L_0x0067:
                    r0 = move-exception
                    goto L_0x0072
                L_0x0069:
                    r1 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                    goto L_0x0083
                L_0x006e:
                    r1 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                L_0x0072:
                    r0.printStackTrace()     // Catch:{ all -> 0x0082 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0082 }
                    com.didichuxing.apollo.sdk.log.LogUtils.m32692e(r0)     // Catch:{ all -> 0x0082 }
                    if (r1 == 0) goto L_0x0081
                L_0x007e:
                    r1.disconnect()
                L_0x0081:
                    return
                L_0x0082:
                    r0 = move-exception
                L_0x0083:
                    if (r1 == 0) goto L_0x0088
                    r1.disconnect()
                L_0x0088:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.FloatingView.C160366.run():void");
            }
        }.start();
    }

    public static void startFeedbackWeb_BUG(String str) {
        FeedbackConfig.AFANTY_UPLOAD_URLPATH = str;
        startFeedbackWeb(FeedbackConfig.FT_BUG);
    }

    public static void startAfantyWebView(String str) {
        startAfantyFeedbackWebview(str);
    }

    public static void startAfantyWebView(final String str, String str2) {
        if ("true".equalsIgnoreCase(str2)) {
            dialog = ProgressDialog.show(SwarmUtil.getCurrentActivity(), (CharSequence) null, (CharSequence) null, true, false);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            takeScreenShot(countDownLatch);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await(15, TimeUnit.SECONDS);
                    } catch (Exception unused) {
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (FloatingView.dialog != null && FloatingView.dialog.isShowing()) {
                                FloatingView.dialog.dismiss();
                            }
                        }
                    });
                    FloatingView.startAfantyFeedbackWebview(str);
                }
            }).start();
            return;
        }
        startAfantyWebView(str);
    }

    /* access modifiers changed from: private */
    public static void startFeedbackWeb(final String str) {
        final Activity currentActivity = SwarmUtil.getCurrentActivity();
        if (currentActivity != null) {
            String networkType = NetworkCollector.getNetworkType();
            if (!networkType.equals("WIFI") && !networkType.equals("MOBILE")) {
                CommonUtil.toast_send_error(currentActivity.getString(R.string.afanty_net_unreachable));
            } else if (!FeedbackConfig.FT_SUG.equals(str) || AfantySDK.isReportToOmegaServer()) {
                dialog = ProgressDialog.show(currentActivity, (CharSequence) null, (CharSequence) null, true, false);
                final CountDownLatch countDownLatch = new CountDownLatch(3);
                takeScreenShot(countDownLatch);
                startFeedback(countDownLatch);
                getFeatureList(countDownLatch, str);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            countDownLatch.await(15, TimeUnit.SECONDS);
                        } catch (Exception unused) {
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (FloatingView.dialog != null && FloatingView.dialog.isShowing()) {
                                    FloatingView.dialog.dismiss();
                                }
                            }
                        });
                        Intent intent = new Intent(currentActivity, FeedbackWebviewActivity.class);
                        intent.putExtra("ft", str);
                        intent.putExtra("reportOmegaServer", AfantySDK.isReportToOmegaServer());
                        if (FloatingView.currentScreenShotUri != null) {
                            intent.putExtra(ShareConstants.MEDIA_URI, FloatingView.currentScreenShotUri);
                        }
                        if (FloatingView.feature_teams_result != null && FloatingView.feature_teams_result.length() > 0) {
                            intent.putExtra("result", FloatingView.feature_teams_result);
                        }
                        currentActivity.startActivity(intent);
                    }
                }).start();
            } else {
                dialog = ProgressDialog.show(currentActivity, (CharSequence) null, (CharSequence) null, true, false);
                final CountDownLatch countDownLatch2 = new CountDownLatch(1);
                takeScreenShot(countDownLatch2);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            countDownLatch2.await(15, TimeUnit.SECONDS);
                        } catch (Exception unused) {
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (FloatingView.dialog != null && FloatingView.dialog.isShowing()) {
                                    FloatingView.dialog.dismiss();
                                }
                            }
                        });
                        Intent intent = new Intent(currentActivity, FeedbackWebviewActivity.class);
                        intent.putExtra("ft", str);
                        if (FloatingView.currentScreenShotUri != null) {
                            intent.putExtra(ShareConstants.MEDIA_URI, FloatingView.currentScreenShotUri);
                        }
                        currentActivity.startActivity(intent);
                    }
                }).start();
            }
        }
    }

    public static void showHuiduUI(Application application) {
        try {
            FeedbackConfig.AFANTY_FANKUI = application.getString(R.string.afanty_report_huidu);
            uiInit(application);
            FloatingViewApi.addSubMenuItem(application.getResources().getDrawable(R.drawable.tiyijian), FeedbackConfig.AFANTY_FANKUI, new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    Activity currentActivity;
                    final String userToken = SwarmUtil.getUserToken();
                    if (userToken != null && userToken.length() > 0 && (currentActivity = SwarmUtil.getCurrentActivity()) != null) {
                        ProgressDialog unused = FloatingView.dialog = ProgressDialog.show(currentActivity, (CharSequence) null, (CharSequence) null, true, false);
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        FloatingView.takeHuiduScreenShot(countDownLatch);
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    countDownLatch.await(15, TimeUnit.SECONDS);
                                } catch (Exception unused) {
                                }
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    public void run() {
                                        if (FloatingView.dialog != null && FloatingView.dialog.isShowing()) {
                                            FloatingView.dialog.dismiss();
                                        }
                                    }
                                });
                                FloatingView.startAfantyFeedbackWebview(ShakeConfig.getTiyanUrl() + "tab=1&tiyan_from=zhongce&ticket=" + userToken + ShakeConfig.TIYAN_BID + PackageCollector.getPkgName() + "&cityid=" + SwarmUtil.getCityId());
                            }
                        }).start();
                    }
                }
            });
            FloatingViewApi.addSubMenuItem(application.getResources().getDrawable(R.drawable.wodeyijian), FeedbackConfig.AFANTY_MY_FEEDBACK, new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    String userToken = SwarmUtil.getUserToken();
                    if (userToken != null && userToken.length() > 0) {
                        FloatingView.startAfantyFeedbackWebview(ShakeConfig.getTiyanUrl() + "tab=2&tiyan_from=zhongce&ticket=" + userToken + ShakeConfig.TIYAN_BID + PackageCollector.getPkgName() + "&cityid=" + SwarmUtil.getCityId());
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void hideUI() {
        try {
            FloatingViewApi.removeSubMenuItem(FeedbackConfig.AFANTY_BUG);
            FloatingViewApi.removeSubMenuItem(FeedbackConfig.AFANTY_FEEDBACK);
            FloatingViewApi.removeSubMenuItem(FeedbackConfig.AFANTY_MY_FEEDBACK);
            FloatingViewApi.removeSubMenuItem(FeedbackConfig.AFANTY_FANKUI);
        } catch (Exception unused) {
        }
    }

    public static void feedback_init(Application application) {
        OmegaSDKinit(application);
    }

    public static void OmegaSDKinit(Application application) {
        if (application != null && !isOmegasdkInit) {
            isOmegasdkInit = true;
            AllCollectorsFacade.initAll(application);
            CacheFileUtil.init(application);
        }
    }

    private static void setListData(final CountDownLatch countDownLatch) {
        new Thread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                com.didichuxing.omega.sdk.feedback.FloatingView.access$702("");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
                r2.countDown();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    java.lang.String r0 = ""
                    r1 = 0
                    r2 = 50
                    java.lang.String r1 = com.didichuxing.omega.sdk.feedback.NetworkHelper.getFeedbackRecords(r1, r2)     // Catch:{ Exception -> 0x0031 }
                    if (r1 == 0) goto L_0x002b
                    int r2 = r1.length()     // Catch:{ Exception -> 0x0031 }
                    if (r2 != 0) goto L_0x0012
                    goto L_0x002b
                L_0x0012:
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0031 }
                    r2.<init>(r1)     // Catch:{ Exception -> 0x0031 }
                    java.lang.String r1 = "records"
                    org.json.JSONArray r1 = r2.getJSONArray(r1)     // Catch:{ Exception -> 0x0031 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0031 }
                    java.lang.String r2 = "\\n"
                    java.lang.String r1 = r1.replace(r2, r0)     // Catch:{ Exception -> 0x0031 }
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.myFeedbackListjsonStr = r1     // Catch:{ Exception -> 0x0031 }
                    goto L_0x0034
                L_0x002b:
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.myFeedbackListjsonStr = r0     // Catch:{ Exception -> 0x0031 }
                    goto L_0x0034
                L_0x002f:
                    r0 = move-exception
                    goto L_0x003a
                L_0x0031:
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.myFeedbackListjsonStr = r0     // Catch:{ all -> 0x002f }
                L_0x0034:
                    java.util.concurrent.CountDownLatch r0 = r2
                    r0.countDown()
                    return
                L_0x003a:
                    java.util.concurrent.CountDownLatch r1 = r2
                    r1.countDown()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.FloatingView.C1602312.run():void");
            }
        }).start();
    }

    private static void setPerson_button(final CountDownLatch countDownLatch, final Activity activity) {
        new Thread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                com.didichuxing.omega.sdk.feedback.FloatingView.access$802("");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x00ca, code lost:
                r2.countDown();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x00cf, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x00bf, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x00c1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    java.lang.String r0 = ""
                    java.lang.String r1 = com.didichuxing.omega.sdk.feedback.NetworkHelper.getPersonInfo()
                    int r2 = com.didichuxing.omega.sdk.feedback.util.SwarmUtil.getAppType()     // Catch:{ Exception -> 0x00c1 }
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c1 }
                    r3.<init>(r1)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                    r1.<init>()     // Catch:{ Exception -> 0x00c1 }
                    r1.append(r0)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r4 = "bugMonthCount"
                    int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x00c1 }
                    r1.append(r4)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c1 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                    r4.<init>()     // Catch:{ Exception -> 0x00c1 }
                    r4.append(r0)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r5 = "orderMonthCount"
                    int r5 = r3.getInt(r5)     // Catch:{ Exception -> 0x00c1 }
                    r4.append(r5)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00c1 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                    r5.<init>()     // Catch:{ Exception -> 0x00c1 }
                    r5.append(r0)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r6 = "sugMonthCount"
                    int r3 = r3.getInt(r6)     // Catch:{ Exception -> 0x00c1 }
                    r5.append(r3)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00c1 }
                    r5 = 1
                    r6 = 2131953430(0x7f130716, float:1.954333E38)
                    java.lang.String r7 = " "
                    if (r2 != r5) goto L_0x0094
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                    r2.<init>()     // Catch:{ Exception -> 0x00c1 }
                    android.app.Activity r5 = r3     // Catch:{ Exception -> 0x00c1 }
                    r8 = 2131953429(0x7f130715, float:1.9543329E38)
                    java.lang.String r5 = r5.getString(r8)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r5)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r4)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r7)     // Catch:{ Exception -> 0x00c1 }
                    android.app.Activity r4 = r3     // Catch:{ Exception -> 0x00c1 }
                    r5 = 2131953426(0x7f130712, float:1.9543323E38)
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r4)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r1)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r7)     // Catch:{ Exception -> 0x00c1 }
                    android.app.Activity r1 = r3     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r1 = r1.getString(r6)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r1)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r3)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.personStr = r1     // Catch:{ Exception -> 0x00c1 }
                    goto L_0x00c4
                L_0x0094:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
                    r2.<init>()     // Catch:{ Exception -> 0x00c1 }
                    android.app.Activity r4 = r3     // Catch:{ Exception -> 0x00c1 }
                    r5 = 2131953427(0x7f130713, float:1.9543325E38)
                    java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r4)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r1)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r7)     // Catch:{ Exception -> 0x00c1 }
                    android.app.Activity r1 = r3     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r1 = r1.getString(r6)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r1)     // Catch:{ Exception -> 0x00c1 }
                    r2.append(r3)     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00c1 }
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.personStr = r1     // Catch:{ Exception -> 0x00c1 }
                    goto L_0x00c4
                L_0x00bf:
                    r0 = move-exception
                    goto L_0x00ca
                L_0x00c1:
                    java.lang.String unused = com.didichuxing.omega.sdk.feedback.FloatingView.personStr = r0     // Catch:{ all -> 0x00bf }
                L_0x00c4:
                    java.util.concurrent.CountDownLatch r0 = r2
                    r0.countDown()
                    return
                L_0x00ca:
                    java.util.concurrent.CountDownLatch r1 = r2
                    r1.countDown()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.FloatingView.C1602413.run():void");
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static void startMyFeedbackListWeb() {
        final Activity currentActivity = SwarmUtil.getCurrentActivity();
        if (currentActivity != null) {
            dialog = ProgressDialog.show(currentActivity, (CharSequence) null, (CharSequence) null, true, false);
            final CountDownLatch countDownLatch = new CountDownLatch(2);
            setListData(countDownLatch);
            setPerson_button(countDownLatch, currentActivity);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await(15, TimeUnit.SECONDS);
                    } catch (Exception unused) {
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (FloatingView.dialog != null && FloatingView.dialog.isShowing()) {
                                FloatingView.dialog.dismiss();
                            }
                        }
                    });
                    Intent intent = new Intent(currentActivity, FeedbackListWebviewActivity.class);
                    intent.putExtra("personinfo", FloatingView.personStr);
                    intent.putExtra("listdata", FloatingView.myFeedbackListjsonStr);
                    currentActivity.startActivity(intent);
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public static void takeHuiduScreenShot(final CountDownLatch countDownLatch) {
        FeedbackBitmap.getInstance().setScreenshot_uri((Uri) null);
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            ((ScreenshotService) bundleContext.getService(bundleContext.getServiceReference(ScreenshotService.class))).takeScreenshot(2, new ScreenshotService.Callback() {
                public void onScreenshotTaken(Uri uri) {
                    FeedbackBitmap.getInstance().setScreenshot_uri(uri);
                    countDownLatch.countDown();
                }
            });
        } catch (Exception unused) {
            FeedbackBitmap.getInstance().setScreenshot_uri((Uri) null);
        }
    }

    private static void takeScreenShot(final CountDownLatch countDownLatch) {
        currentScreenShotUri = null;
        try {
            BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
            ((ScreenshotService) bundleContext.getService(bundleContext.getServiceReference(ScreenshotService.class))).takeScreenshot(2, new ScreenshotService.Callback() {
                public void onScreenshotTaken(Uri uri) {
                    Uri unused = FloatingView.currentScreenShotUri = uri;
                    FeedbackBitmap.getInstance().setScreenshot_uri(FloatingView.currentScreenShotUri);
                    countDownLatch.countDown();
                }
            });
        } catch (Exception unused) {
            currentScreenShotUri = null;
        }
    }

    /* access modifiers changed from: private */
    public static void startAfantyFeedbackWebview(String str) {
        try {
            Activity currentActivity = SwarmUtil.getCurrentActivity();
            if (currentActivity != null) {
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.url = str;
                Intent intent = new Intent(currentActivity, AfantyWebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                currentActivity.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startFeedback(final CountDownLatch countDownLatch) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    FeedbackBitmap.getInstance().setFr(RecordFactory.createFeedbackRecord());
                } catch (Exception unused) {
                } catch (Throwable th) {
                    countDownLatch.countDown();
                    throw th;
                }
                countDownLatch.countDown();
            }
        }).start();
    }

    private static void getFeatureList(final CountDownLatch countDownLatch, final String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    String unused = FloatingView.feature_teams_result = NetworkHelper.getFeatureList(str);
                } catch (Exception unused2) {
                    String unused3 = FloatingView.feature_teams_result = "";
                } catch (Throwable th) {
                    countDownLatch.countDown();
                    throw th;
                }
                countDownLatch.countDown();
            }
        }).start();
    }

    public static void addSmileMenuItem(final SmileMenuItem smileMenuItem, final Application application) {
        if (smileMenuItem.isVisiable()) {
            uiInit(application);
            FloatingViewState.getInstance().addMenuItemState(smileMenuItem);
            FloatingViewApi.addSubMenuItem(smileMenuItem.getIcon(), smileMenuItem.getText(), new FloatingViewMenuItemListener() {
                public void onClick(View view) {
                    smileMenuItem.doAction(application);
                }
            });
            FloatingViewApi.setSubMenuOrderWeight(smileMenuItem.getText(), smileMenuItem.getWeight());
        }
    }
}

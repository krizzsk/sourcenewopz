package com.didichuxing.omega.sdk.feedback.judgment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didichuxing.omega.sdk.feedback.FloatingView;
import com.didichuxing.omega.sdk.feedback.util.OmegaHelper;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.uicomponents.floatingview.C16159Util;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;
import com.didichuxing.omega.sdk.uicomponents.floatingview.UIComponentCache;
import com.taxis99.R;
import java.net.URLEncoder;

public class Judge {
    private static final String HOST = "https://apm.didiglobal.com/fireeye/tip";
    private static final String TAG = "Judge";
    private static int activityCount;
    private static Judge instance;
    /* access modifiers changed from: private */
    public Application application;
    /* access modifiers changed from: private */
    public Activity currentAty;
    /* access modifiers changed from: private */
    public long delay;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public Runnable judgeRunnable = new Runnable() {
        public void run() {
            UIComponentCache.init(Judge.this.application);
            Judge.this.requestJudgeInfo(new JudgeListener() {
                public void onFailed(int i) {
                }

                public void onSucceed(final JudgeBean judgeBean) {
                    Judge.this.handler.post(new Runnable() {
                        public void run() {
                            if (Judge.this.application != null && Judge.this.currentAty != null) {
                                FloatingViewApi.init(Judge.this.application);
                                FloatingViewApi.setCurrentActivity(Judge.this.currentAty);
                                FloatingViewApi.show(Judge.this.currentAty);
                                Judge.this.showHintView(Judge.this.currentAty, judgeBean);
                                OmegaHelper.getInstance().trackEvent("judge_tip_show");
                            }
                        }
                    });
                }
            }, Judge.this.param);
        }
    };
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityStarted(Activity activity) {
            Activity unused = Judge.this.currentAty = activity;
            if (Judge.access$108() == 0) {
                Judge.this.handler.postDelayed(Judge.this.judgeRunnable, Judge.this.delay);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (1 == Judge.access$110()) {
                Judge.this.handler.removeCallbacks(Judge.this.judgeRunnable);
                Activity unused = Judge.this.currentAty = null;
                FloatingViewApi.uninit();
                Judge.this.removeSubView();
            }
        }
    };
    /* access modifiers changed from: private */
    public String param = "";
    private FrameLayout subContentView;

    public interface JudgeListener {
        void onFailed(int i);

        void onSucceed(JudgeBean judgeBean);
    }

    static /* synthetic */ int access$108() {
        int i = activityCount;
        activityCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$110() {
        int i = activityCount;
        activityCount = i - 1;
        return i;
    }

    private Judge() {
    }

    public static Judge getInstance() {
        if (instance == null) {
            instance = new Judge();
        }
        return instance;
    }

    public void startJudge(Application application2, long j) {
        if (application2 != null) {
            String userUid = SwarmUtil.getUserUid();
            String userPhone = SwarmUtil.getUserPhone();
            String encode = !TextUtils.isEmpty(userPhone) ? URLEncoder.encode(EncryptUtils.encrypt(userPhone.getBytes())) : "";
            String packageName = application2.getPackageName();
            this.application = application2;
            this.delay = j;
            this.param = "os_type=android&app_name=" + packageName + "&uid=" + userUid + "&lan=" + SwarmUtil.getLang() + "&tn=" + encode;
            application2.registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
    }

    public void stopJudge(Application application2) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        if (!(application2 == null || (activityLifecycleCallbacks = this.lifecycleCallbacks) == null)) {
            application2.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.currentAty = null;
        activityCount = 0;
    }

    /* access modifiers changed from: private */
    public void showHintView(Activity activity, final JudgeBean judgeBean) {
        if (activity != null && judgeBean != null) {
            SmartTextView smartTextView = (SmartTextView) LayoutInflater.from(activity).inflate(R.layout.layout_tips, (ViewGroup) activity.getWindow().getDecorView(), false);
            smartTextView.setMaxWidth(C16159Util.dpToPx(activity.getApplicationContext(), 280.0f));
            smartTextView.setSmartText(judgeBean.tips);
            smartTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OmegaHelper.getInstance().trackEvent("judge_tip_ck");
                    FloatingViewApi.removeHintView();
                    Judge judge = Judge.this;
                    judge.showTipsSubMenu(judge.currentAty, judgeBean);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = smartTextView.getSmartWidth();
            layoutParams.height = smartTextView.getSmartHeight();
            FloatingViewApi.addHintView(smartTextView, layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void showTipsSubMenu(Activity activity, final JudgeBean judgeBean) {
        if (activity != null && judgeBean != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(activity).inflate(R.layout.layout_sub_tips, (ViewGroup) activity.getWindow().getDecorView(), false);
            this.subContentView = frameLayout;
            frameLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Judge.this.removeSubView();
                    Judge judge = Judge.this;
                    judge.showHintView(judge.currentAty, judgeBean);
                }
            });
            ((TextView) this.subContentView.findViewById(R.id.tips_title)).setText(judgeBean.title);
            ((TextView) this.subContentView.findViewById(R.id.tv_cancel)).setText(judgeBean.ignore);
            ((TextView) this.subContentView.findViewById(R.id.tips_detail)).setText(Html.fromHtml(judgeBean.msg));
            Button button = (Button) this.subContentView.findViewById(R.id.btn_h5);
            button.setText(judgeBean.confirm);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OmegaHelper.getInstance().trackEvent("judge_tip_confirm_ck");
                    Judge.this.uploadJudgeState(1, judgeBean.tipId);
                    Judge judge = Judge.this;
                    judge.goToHtml5(judge.currentAty, judgeBean.url);
                    Judge.this.removeSubView();
                    FloatingViewApi.uninit();
                }
            });
            this.subContentView.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OmegaHelper.getInstance().trackEvent("judge_tip_ignore_ck");
                    Judge.this.uploadJudgeState(2, judgeBean.tipId);
                    Judge.this.removeSubView();
                    FloatingViewApi.uninit();
                }
            });
            try {
                activity.addContentView(this.subContentView, new FrameLayout.LayoutParams(-1, -1));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void removeSubView() {
        FrameLayout frameLayout = this.subContentView;
        if (frameLayout != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.subContentView);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void uploadJudgeState(final int i, final int i2) {
        new Thread("UPLOAD STATE") {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x008b  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0092  */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    java.lang.String r0 = "UTF-8"
                    r1 = 0
                    java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    r3.<init>()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.lang.String r4 = "https://apm.didiglobal.com/fireeye/tip?"
                    r3.append(r4)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    com.didichuxing.omega.sdk.feedback.judgment.Judge r4 = com.didichuxing.omega.sdk.feedback.judgment.Judge.this     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.lang.String r4 = r4.param     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    r3.append(r4)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    r2.<init>(r3)     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x008f, all -> 0x0088 }
                    java.lang.String r1 = "POST"
                    r2.setRequestMethod(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1 = 1
                    r2.setDoOutput(r1)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r1 = "Content-Type"
                    java.lang.String r3 = "application/x-www-form-urlencoded"
                    r2.setRequestProperty(r1, r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r2.connect()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1.<init>(r3)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r3.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r4 = "status="
                    r3.append(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    int r4 = r3     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r4 = java.net.URLEncoder.encode(r4, r0)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r3.append(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r4 = "&tip_id="
                    r3.append(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    int r4 = r4     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r0 = java.net.URLEncoder.encode(r4, r0)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r3.append(r0)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1.writeBytes(r0)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1.flush()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1.close()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r2.getResponseCode()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    r1.close()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                    if (r2 == 0) goto L_0x0095
                    r2.disconnect()
                    goto L_0x0095
                L_0x0083:
                    r0 = move-exception
                    r1 = r2
                    goto L_0x0089
                L_0x0086:
                    r1 = r2
                    goto L_0x0090
                L_0x0088:
                    r0 = move-exception
                L_0x0089:
                    if (r1 == 0) goto L_0x008e
                    r1.disconnect()
                L_0x008e:
                    throw r0
                L_0x008f:
                L_0x0090:
                    if (r1 == 0) goto L_0x0095
                    r1.disconnect()
                L_0x0095:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.judgment.Judge.C160787.run():void");
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void goToHtml5(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            FloatingView.startAfantyWebView(str);
        }
    }

    /* access modifiers changed from: private */
    public void requestJudgeInfo(final JudgeListener judgeListener, final String str) {
        if (judgeListener != null && !FloatingViewApi.isUserClosedFloatingView()) {
            new Thread("JUDGE") {
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
                    r1.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00bb */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x00c8  */
                /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        r0 = 999(0x3e7, float:1.4E-42)
                        r1 = 0
                        java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00bb }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb }
                        r3.<init>()     // Catch:{ Exception -> 0x00bb }
                        java.lang.String r4 = "https://apm.didiglobal.com/fireeye/tip?"
                        r3.append(r4)     // Catch:{ Exception -> 0x00bb }
                        java.lang.String r4 = r4     // Catch:{ Exception -> 0x00bb }
                        r3.append(r4)     // Catch:{ Exception -> 0x00bb }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bb }
                        r2.<init>(r3)     // Catch:{ Exception -> 0x00bb }
                        java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00bb }
                        java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00bb }
                        java.lang.String r1 = "GET"
                        r2.setRequestMethod(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r1 = 5000(0x1388, float:7.006E-42)
                        r2.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r2.connect()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r3 = 200(0xc8, float:2.8E-43)
                        if (r1 != r3) goto L_0x00a9
                        java.io.InputStream r1 = r2.getInputStream()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r3 = 1024(0x400, float:1.435E-42)
                        byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r4.<init>()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                    L_0x0043:
                        int r5 = r1.read(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r6 = -1
                        if (r5 == r6) goto L_0x004f
                        r6 = 0
                        r4.write(r3, r6, r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        goto L_0x0043
                    L_0x004f:
                        java.lang.String r3 = "utf-8"
                        java.lang.String r3 = r4.toString(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r4.close()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r1.close()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        com.didichuxing.omega.sdk.feedback.judgment.JudgeBean r1 = com.didichuxing.omega.sdk.feedback.judgment.JudgeBean.parse(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        int r3 = r1.errorNo     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x00a1
                        java.lang.String r3 = r1.msg     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x009b
                        java.lang.String r3 = r1.url     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x009b
                        java.lang.String r3 = r1.url     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        java.lang.String r4 = "http"
                        boolean r3 = r3.startsWith(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 == 0) goto L_0x009b
                        java.lang.String r3 = r1.confirm     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x009b
                        java.lang.String r3 = r1.ignore     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x009b
                        java.lang.String r3 = r1.title     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        if (r3 != 0) goto L_0x009b
                        com.didichuxing.omega.sdk.feedback.judgment.Judge$JudgeListener r3 = r3     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r3.onSucceed(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        goto L_0x00ae
                    L_0x009b:
                        com.didichuxing.omega.sdk.feedback.judgment.Judge$JudgeListener r1 = r3     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r1.onFailed(r0)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        goto L_0x00ae
                    L_0x00a1:
                        com.didichuxing.omega.sdk.feedback.judgment.Judge$JudgeListener r3 = r3     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        int r1 = r1.errorNo     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r3.onFailed(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        goto L_0x00ae
                    L_0x00a9:
                        com.didichuxing.omega.sdk.feedback.judgment.Judge$JudgeListener r3 = r3     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                        r3.onFailed(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                    L_0x00ae:
                        if (r2 == 0) goto L_0x00c5
                        r2.disconnect()
                        goto L_0x00c5
                    L_0x00b4:
                        r0 = move-exception
                        r1 = r2
                        goto L_0x00c6
                    L_0x00b7:
                        r1 = r2
                        goto L_0x00bb
                    L_0x00b9:
                        r0 = move-exception
                        goto L_0x00c6
                    L_0x00bb:
                        com.didichuxing.omega.sdk.feedback.judgment.Judge$JudgeListener r2 = r3     // Catch:{ all -> 0x00b9 }
                        r2.onFailed(r0)     // Catch:{ all -> 0x00b9 }
                        if (r1 == 0) goto L_0x00c5
                        r1.disconnect()
                    L_0x00c5:
                        return
                    L_0x00c6:
                        if (r1 == 0) goto L_0x00cb
                        r1.disconnect()
                    L_0x00cb:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.judgment.Judge.C160798.run():void");
                }
            }.start();
        }
    }
}

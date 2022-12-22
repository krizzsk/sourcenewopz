package com.didichuxing.omega.sdk.feedback.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.omega.sdk.feedback.FloatingView;
import com.didichuxing.omega.sdk.feedback.leaked.LeakMaker;
import com.kwai.koom.javaoom.KOOM;
import com.kwai.koom.javaoom.KOOMProgressListener;
import com.taxis99.R;

public class TestOOMActivity extends Activity {
    private static volatile boolean isClicked = false;
    private Button btn_goback;
    private Handler mainHandler;
    private Button reportButton;
    private TextView reportText;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_oom);
        this.btn_goback = (Button) findViewById(R.id.btn_goback);
        this.reportButton = (Button) findViewById(R.id.btn_report_leak);
        this.reportText = (TextView) findViewById(R.id.tv_report_status);
        this.btn_goback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TestOOMActivity.this.finish();
            }
        });
        this.reportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LeakMaker.makeLeak(TestOOMActivity.this);
                TestOOMActivity.this.testReport();
            }
        });
    }

    /* access modifiers changed from: private */
    public void changeStatusText(final KOOMProgressListener.Progress progress) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                TestOOMActivity.this.chanStatusTextInMain(progress);
            }
        });
    }

    /* renamed from: com.didichuxing.omega.sdk.feedback.activity.TestOOMActivity$5 */
    static /* synthetic */ class C160695 {
        static final /* synthetic */ int[] $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.kwai.koom.javaoom.KOOMProgressListener$Progress[] r0 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress = r0
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_DUMP_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_DUMPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_DUMP_FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_ANALYSIS_START     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress     // Catch:{ NoSuchFieldError -> 0x003e }
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_ANALYSIS_DONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.kwai.koom.javaoom.KOOMProgressListener$Progress r1 = com.kwai.koom.javaoom.KOOMProgressListener.Progress.HEAP_ANALYSIS_FAILED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.feedback.activity.TestOOMActivity.C160695.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void chanStatusTextInMain(KOOMProgressListener.Progress progress) {
        String str;
        switch (C160695.$SwitchMap$com$kwai$koom$javaoom$KOOMProgressListener$Progress[progress.ordinal()]) {
            case 1:
                str = "heap dump stared";
                break;
            case 2:
                str = "heap dump ended";
                break;
            case 3:
                str = "heap dump failed";
                break;
            case 4:
                str = "heap analysis start";
                break;
            case 5:
                str = "heap analysis done, please check report in " + KOOM.getInstance().getReportDir();
                break;
            case 6:
                str = "heap analysis failed";
                break;
            default:
                str = "";
                break;
        }
        this.reportText.setText(str);
    }

    public synchronized void testReport() {
        if (!isClicked) {
            isClicked = true;
            Handler handler = new Handler();
            this.mainHandler = handler;
            handler.postDelayed(new Runnable() {
                public void run() {
                    KOOM.getInstance().manualTrigger();
                    KOOM.getInstance().setProgressListener(new KOOMProgressListener() {
                        public void onProgress(KOOMProgressListener.Progress progress) {
                            TestOOMActivity.this.changeStatusText(progress);
                        }
                    });
                }
            }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        FloatingView.isClickReported = false;
        super.onDestroy();
    }
}

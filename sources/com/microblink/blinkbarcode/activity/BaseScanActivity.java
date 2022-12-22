package com.microblink.blinkbarcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment;
import com.microblink.blinkbarcode.fragment.overlay.ScanningOverlay;
import com.microblink.blinkbarcode.library.R;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.uisettings.ActivityRunner;
import com.microblink.blinkbarcode.uisettings.UISettings;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;

/* compiled from: line */
abstract class BaseScanActivity<UiSettingsType extends UISettings, ScanOverlayType extends ScanningOverlay> extends AppCompatActivity implements RecognizerRunnerFragment.ScanningOverlayBinder {
    /* access modifiers changed from: private */
    public Throwable llIIlIlIIl;
    public RecognizerRunnerFragment recognizerRunnerFragment;
    public ScanOverlayType scanningOverlay;
    public UiSettingsType uiSettings;

    /* renamed from: com.microblink.blinkbarcode.activity.BaseScanActivity$1 */
    /* compiled from: line */
    public static /* synthetic */ class C182341 {
        public static final /* synthetic */ int[] llIIlIlIIl;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001b */
        static {
            /*
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType.values()
                r0 = 4
                int[] r1 = new int[r0]
                llIIlIlIIl = r1
                r2 = 1
                r3 = 2
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r4 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r1 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r4 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.PARTIAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r1 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x001b }
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r2 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.STAGE_SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x001b }
                r2 = 3
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x001b }
            L_0x001b:
                int[] r1 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0022 }
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r2 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.UNSUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.activity.BaseScanActivity.C182341.<clinit>():void");
        }
    }

    /* compiled from: line */
    public class ResultListener implements ScanResultListener {
        public ResultListener() {
        }

        public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
            BaseScanActivity.this.onScanningDone(recognitionSuccessType);
        }

        public void onUnrecoverableError(Throwable th) {
            Throwable unused = BaseScanActivity.this.llIIlIlIIl = th;
        }
    }

    public ScanningOverlay getScanningOverlay() {
        return this.scanningOverlay;
    }

    public abstract UiSettingsType loadUiSettings(Intent intent);

    public void onBackPressed() {
        if (this.llIIlIlIIl != null) {
            Intent intent = new Intent();
            intent.putExtra(ActivityRunner.EXTRA_SCAN_EXCEPTION, this.llIIlIlIIl);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        UiSettingsType loadUiSettings = loadUiSettings(getIntent());
        this.uiSettings = loadUiSettings;
        this.scanningOverlay = loadUiSettings.createOverlayController(this, new ResultListener());
        int activityTheme = this.uiSettings.getActivityTheme();
        if (activityTheme != 0) {
            setTheme(activityTheme);
        }
        llIIlIlIIl();
        super.onCreate(bundle);
        setContentView(R.layout.mb_activity_scan);
        setVolumeControlStream(3);
        if (this.uiSettings.getUsingFlagSecure()) {
            getWindow().setFlags(8192, 8192);
        }
        findViewById(16908290).getRootView().setFilterTouchesWhenObscured(this.uiSettings.getFilterTouchesWhenObscured());
        if (bundle == null) {
            this.recognizerRunnerFragment = new RecognizerRunnerFragment();
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.recognizer_runner_view_container, this.recognizerRunnerFragment);
            beginTransaction.commit();
            return;
        }
        this.recognizerRunnerFragment = (RecognizerRunnerFragment) getSupportFragmentManager().findFragmentById(R.id.recognizer_runner_view_container);
    }

    public void onScanningDone(RecognitionSuccessType recognitionSuccessType) {
        this.recognizerRunnerFragment.getRecognizerRunnerView().pauseScanning();
        Intent intent = new Intent();
        int ordinal = recognitionSuccessType.ordinal();
        if (ordinal == 0) {
            setResult(0);
        } else if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            setResult(-1, intent);
        }
        saveResultsToIntent(intent);
        finish();
    }

    public abstract void saveResultsToIntent(Intent intent);

    public void llIIlIlIIl() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(com.taxis99.R.attr.colorPrimary, typedValue, true);
        if (typedValue.data == 0) {
            setTheme(R.style.MB_theme);
        }
    }
}

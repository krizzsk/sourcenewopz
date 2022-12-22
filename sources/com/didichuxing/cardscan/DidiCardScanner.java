package com.didichuxing.cardscan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.cardscan.p175a.C15182c;
import com.didichuxing.cardscan.view.CardScanActivity;
import java.util.Arrays;
import java.util.HashMap;
import p242io.card.payment.CardScanner;

public class DidiCardScanner {
    private static final String TAG = "DidiCardScanner";
    private static DidiCardScanner sCardScanner;
    private String mButtonText = "Tap to enter data manually";
    private CardScanCallback mCardScanCallback;
    private String mCenterText = "Position your card here";
    private int mRequestCode;
    private String mSmallText = "Your card will be scanned automatically";
    private Boolean mSupportScan = null;
    private String mTitleText = "Scan Card";

    private DidiCardScanner() {
    }

    public static DidiCardScanner getInstance() {
        if (sCardScanner == null) {
            sCardScanner = new DidiCardScanner();
        }
        return sCardScanner;
    }

    private boolean isABISupport(String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (Arrays.asList(Build.SUPPORTED_ABIS).contains(str)) {
                return true;
            }
        } else if (str.equals(Build.CPU_ABI) || str.equals(Build.CPU_ABI2)) {
            return true;
        }
        return false;
    }

    private void setErrResult(int i) {
        if (this.mCardScanCallback != null) {
            CardScanResult cardScanResult = new CardScanResult();
            cardScanResult.resultCode = i;
            this.mCardScanCallback.onScanResult(cardScanResult);
            getInstance().setScanCallback((CardScanCallback) null);
        }
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public CardScanCallback getCardScanCallback() {
        return this.mCardScanCallback;
    }

    public String getCenterText() {
        return this.mCenterText;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public String getSmallText() {
        return this.mSmallText;
    }

    public String getTitleText() {
        return this.mTitleText;
    }

    public void reset() {
        this.mCardScanCallback = null;
        sCardScanner = null;
        this.mSupportScan = null;
    }

    public void scan(Activity activity, int i) {
        if (activity == null) {
            setErrResult(3);
        } else if (supportScan(activity)) {
            this.mRequestCode = i;
            activity.startActivity(new Intent(activity, CardScanActivity.class));
        } else {
            setErrResult(2);
            reset();
        }
    }

    public DidiCardScanner setScanCallback(CardScanCallback cardScanCallback) {
        this.mCardScanCallback = cardScanCallback;
        return this;
    }

    public DidiCardScanner setTexts(String str, String str2, String str3, String str4) {
        this.mCenterText = str;
        this.mSmallText = str2;
        this.mButtonText = str3;
        this.mTitleText = str4;
        return this;
    }

    public boolean supportScan(Context context) {
        Boolean bool = this.mSupportScan;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (!isABISupport("armeabi-v7a") && !isABISupport("arm64-v8a")) {
            this.mSupportScan = false;
            hashMap.put("abiSupport", false);
        }
        if (this.mSupportScan == null) {
            try {
                boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera");
                this.mSupportScan = Boolean.valueOf(hasSystemFeature && CardScanner.processorSupported());
                hashMap.put("cameraSupport", Boolean.valueOf(hasSystemFeature));
                hashMap.put("processorSupport", Boolean.valueOf(CardScanner.processorSupported()));
                SystemUtils.log(3, TAG, "cameraSupport return " + hasSystemFeature, (Throwable) null, "com.didichuxing.cardscan.DidiCardScanner", -1);
                SystemUtils.log(3, TAG, "processorSupport return " + CardScanner.processorSupported(), (Throwable) null, "com.didichuxing.cardscan.DidiCardScanner", -1);
            } catch (Throwable unused) {
                this.mSupportScan = false;
                SystemUtils.log(3, TAG, "catch UnsatisfiedLinkError", (Throwable) null, "com.didichuxing.cardscan.DidiCardScanner", -1);
            }
        }
        hashMap.put("isSupport", this.mSupportScan);
        SystemUtils.log(3, TAG, "isSupport return " + this.mSupportScan, (Throwable) null, "com.didichuxing.cardscan.DidiCardScanner", -1);
        C15182c.m33168a(hashMap);
        return this.mSupportScan.booleanValue();
    }
}

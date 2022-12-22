package com.didi.payment.creditcard.global.ocr;

import android.app.Activity;
import android.content.Context;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.taxis99.R;

public class ScanHelper {

    /* renamed from: a */
    private static long f30397a;

    public static void scan(final Activity activity, int i, final CardScanCallback cardScanCallback) {
        f30397a = System.currentTimeMillis();
        m21346d(activity);
        DidiCardScanner instance = DidiCardScanner.getInstance();
        instance.setScanCallback(new CardScanCallback() {
            public void onScanResult(CardScanResult cardScanResult) {
                ScanHelper.m21347e(activity);
                CardScanCallback cardScanCallback = cardScanCallback;
                if (cardScanCallback != null) {
                    cardScanCallback.onScanResult(cardScanResult);
                }
            }

            public void onBottomBackBtnClick() {
                ScanHelper.m21347e(activity);
                ScanHelper.m21349g(activity);
            }

            public void onLeftTopBackBtnClick() {
                ScanHelper.m21347e(activity);
                ScanHelper.m21348f(activity);
            }

            public void onKeyBackBtnClick() {
                ScanHelper.m21347e(activity);
                ScanHelper.m21348f(activity);
            }
        });
        instance.setTexts(activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_center_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_small_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_button_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_title_text));
        instance.scan(activity, i);
    }

    public static boolean isSupport(Context context) {
        return DidiCardScanner.getInstance().supportScan(context);
    }

    /* renamed from: d */
    private static void m21346d(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrCk(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m21347e(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrTimeCk(context, System.currentTimeMillis() - f30397a);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m21348f(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrBackCk(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m21349g(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrMnlCk(context);
    }
}

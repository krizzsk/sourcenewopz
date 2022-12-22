package com.didichuxing.security.cardverify.report;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DiCardVerifyTracker {
    public static final String EVENT_DEDUCT = "ibt_verify_account_deduct_sw";
    public static final String EVENT_DEDUCT_FAILED = "ibt_verify_account_deduct_failed_bt";
    public static final String EVENT_DEDUCT_SUCCEED = "ibt_verify_account_deduct_succeed_bt";
    public static final String EVENT_ENTER_SDK = "ibt_verify_account_enter_sdk_en";
    public static final String EVENT_FAILED_SERVICE = "ibt_verify_account_failed_service_sw";
    public static final String EVENT_REMOVE_CONFIRM = "ibt_verify_account_remove_confirm_sw";
    public static final String EVENT_REMOVE_FAILED = "ibt_verify_account_remove_failed_bt";
    public static final String EVENT_REMOVE_SUCCEED = "ibt_verify_account_remove_succeed_bt";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EVENT_VERIFY = "ibt_verify_account_verify_sw";
    public static final String EVENT_VERIFY_CK = "ibt_verify_account_verify_ck";
    public static final String EVENT_VERIFY_FAILED = "ibt_verify_account_verify_failed_bt";
    public static final String EVENT_VERIFY_SUCCEED = "ibt_verify_account_verify_succeed_bt";

    public static void track(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackEnterSdk() {
        track(EVENT_ENTER_SDK, (Map<String, Object>) null);
    }

    public static void trackDeduct(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        track(EVENT_DEDUCT, hashMap);
    }

    public static void trackDeductSucceed() {
        track(EVENT_DEDUCT_SUCCEED, (Map<String, Object>) null);
    }

    public static void trackDeductFailed() {
        track(EVENT_DEDUCT_FAILED, (Map<String, Object>) null);
    }

    public static void trackVerify(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        track(EVENT_VERIFY, hashMap);
    }

    public static void trackVerifyCk() {
        track(EVENT_VERIFY_CK, (Map<String, Object>) null);
    }

    public static void trackVerifySucceed() {
        track(EVENT_VERIFY_SUCCEED, (Map<String, Object>) null);
    }

    public static void trackVerifyFailed() {
        track(EVENT_VERIFY_FAILED, (Map<String, Object>) null);
    }

    public static void trackRemoveConfirm(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        track(EVENT_REMOVE_CONFIRM, hashMap);
    }

    public static void trackRemoveSucceed() {
        track(EVENT_REMOVE_SUCCEED, (Map<String, Object>) null);
    }

    public static void trackRemoveFailed() {
        track(EVENT_REMOVE_FAILED, (Map<String, Object>) null);
    }

    public static void trackFailedService(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        track(EVENT_FAILED_SERVICE, hashMap);
    }
}

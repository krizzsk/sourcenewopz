package com.jumio.core.network;

import java.net.SocketTimeoutException;
import javax.net.ssl.SSLException;
import jumio.core.C21339a0;
import jumio.core.C21380s0;
import jumio.core.C21393z;
import org.json.JSONObject;

public class ErrorMock {
    public static String[] getAvailableApiMocks() {
        return new String[0];
    }

    public static String[] getAvailableAutomationResultMocks() {
        return new String[0];
    }

    public static String[] getAvailableCameraConnectionMocks() {
        return new String[0];
    }

    public static String[] getAvailableGoogleVisionMocks() {
        return new String[0];
    }

    public static String[] getAvailableLivenessResultMocks() {
        return new String[0];
    }

    public static String[] getAvailableOcrLoadingMocks() {
        return new String[0];
    }

    public static void onApiMock(int i) throws SocketTimeoutException, C21339a0, C21380s0, SSLException {
    }

    public static void onAutomationResultMock() throws C21393z {
    }

    public static void onCameraConnectionMock() throws Exception {
    }

    public static void onGoogleVisionMock() throws Exception {
    }

    public static void onLivenessResultMock() throws C21393z {
    }

    public static void onOcrLoadingMock() throws Exception {
    }

    public static void onSettingsMock(JSONObject jSONObject) {
    }
}

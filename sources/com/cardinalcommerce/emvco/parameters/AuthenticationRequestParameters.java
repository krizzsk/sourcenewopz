package com.cardinalcommerce.emvco.parameters;

import com.cardinalcommerce.p060a.setImageMatrix;
import com.cardinalcommerce.p060a.setProgressBackgroundTintMode;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;

public class AuthenticationRequestParameters {

    /* renamed from: a */
    private char[] f3253a;

    /* renamed from: b */
    private char[] f3254b;

    /* renamed from: c */
    private char[] f3255c;

    /* renamed from: d */
    private char[] f3256d;

    /* renamed from: e */
    private char[] f3257e;

    /* renamed from: f */
    private char[] f3258f;

    public AuthenticationRequestParameters(char[] cArr, char[] cArr2, char[] cArr3, char[] cArr4, char[] cArr5, char[] cArr6) throws InvalidInputException {
        setProgressBackgroundTintMode init = setProgressBackgroundTintMode.init();
        if (cArr4 == null || cArr4.length <= 0) {
            init.init(new setImageMatrix(11316, " Null SDKAppID \n"));
            throw m2223a("sdkAppID");
        }
        this.f3256d = cArr4;
        if (cArr == null || cArr.length <= 0) {
            init.init(new setImageMatrix(11316, " Null SDKTransactionID \n"));
            throw m2223a("sdkTransactionID");
        }
        this.f3253a = cArr;
        this.f3254b = cArr2;
        if (cArr3 == null || cArr3.length <= 0) {
            init.init(new setImageMatrix(11316, " Null SDKEphemeralPublicKey \n"));
            throw m2223a("sdkEphemeralPublicKey");
        }
        this.f3255c = cArr3;
        if (cArr5 == null || cArr5.length <= 0) {
            init.init(new setImageMatrix(11316, " Null SDKReferenceNumber \n"));
            throw m2223a("sdkReferenceNumber");
        }
        this.f3257e = cArr5;
        if (cArr6 == null || cArr6.length <= 0) {
            init.init(new setImageMatrix(11316, " Null MessageVersion \n"));
            throw m2223a("messageVersion");
        } else {
            this.f3258f = cArr6;
        }
    }

    /* renamed from: a */
    private static InvalidInputException m2223a(String str) {
        return new InvalidInputException("InvalidInputException", new Throwable("Caught in AuthenticationRequestParameters \n Invalid ".concat(String.valueOf(str))));
    }

    public String getSDKTransactionID() {
        return new String(this.f3253a);
    }

    public String getDeviceData() {
        return new String(this.f3254b);
    }

    public String getSDKEphemeralPublicKey() {
        return new String(this.f3255c);
    }

    public String getSDKAppID() {
        return new String(this.f3256d);
    }

    public String getSDKReferenceNumber() {
        return new String(this.f3257e);
    }

    public String getMessageVersion() {
        return new String(this.f3258f);
    }
}

package com.cardinalcommerce.cardinalmobilesdk.p061cm.models;

import java.util.Arrays;

/* renamed from: com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError */
public class CardinalError {
    public static final int CARDINAL_JSON_EXCEPTION_ERROR_CODE = 10610;
    public static final int CONTINUE_HTML_CHALLENGE_INVALID_URI_EXCEPTION = 10616;
    public static final int CONTINUE_IO_EXCEPTION = 10612;
    public static final int CONTINUE_JWT_PARSER_EXCEPTION = 10611;
    public static final int CONTINUE_PROTOCOL_EXCEPTION = 10615;
    public static final int CONTINUE_TIME_EXCEPTION = 10614;
    public static final int CONTINUE_URL_EXCEPTION = 10613;
    public static final int INIT_DF_PARAMETERS_ERROR_CODE = 10204;
    public static final int INIT_DF_REQUEST_ERROR_CODE = 10218;
    public static final int INIT_EMPTY_RESPONSE = 10219;
    public static final int INIT_IO_EXCEPTION = 10212;
    public static final int INIT_JWT_PARSER_EXCEPTION = 10206;
    public static final int INIT_PROTOCOL_EXCEPTION = 10213;
    public static final int INIT_RESPONSE_ERROR_CODE = 10214;
    public static final String INIT_RESPONSE_ERROR_MESSAGE = "Cardinal Init Response Error. Missing field :";
    public static final int INIT_URL_EXCEPTION = 10211;
    public static final int SDK_APP_ID_PACKAGE_NAME_NOT_FOUND = 10220;
    public static final int SEND_STEPUP_DATA_INVALID_USER_INPUT_ERROR_CODE = 10703;
    public static final int SEND_STEPUP_DATA_STARTED_CONTEXT_ERROR_CODE = 10712;
    public static final int SEND_STEPUP_DATA_STARTED_RESPONSE_ERROR_CODE = 10702;
    public static final int SEND_STEPUP_DATA_STARTED_SESSION_ID_ERROR_CODE = 10711;
    public static final int SEND_STEPUP_DATA_STARTED_USER_INPUT_ERROR_CODE = 10713;
    public static final int SOCKET_TIMEOUT_ERROR_CODE = 10216;
    public static final int SUBSEQUENT_CRES_INVALID_RUNTIME_EXCEPTION = 10705;
    public static final String SUBSEQUENT_CRES_VALIDATION_ERROR_MESSAGE = "Subsequent CRes Validation fails.";
    public final int Cardinal;
    public final String init;

    public CardinalError(int i, String str) {
        this.Cardinal = i;
        this.init = str;
    }

    public CardinalError(int i, Exception exc) {
        this.Cardinal = i;
        this.init = Arrays.toString(exc.getStackTrace());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        r1.init = "Invalid Activity: Null Activity.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005d, code lost:
        r1.init = "Invalid Transition: An error occurred during Cardinal Configure.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CardinalError(int r2) {
        /*
            r1 = this;
            r1.<init>()
            r1.Cardinal = r2
            if (r2 == 0) goto L_0x0071
            r0 = 10207(0x27df, float:1.4303E-41)
            if (r2 == r0) goto L_0x006c
            r0 = 10703(0x29cf, float:1.4998E-41)
            if (r2 == r0) goto L_0x0067
            r0 = 10705(0x29d1, float:1.5001E-41)
            if (r2 == r0) goto L_0x0062
            switch(r2) {
                case 10101: goto L_0x005d;
                case 10102: goto L_0x0058;
                case 10103: goto L_0x0053;
                default: goto L_0x0016;
            }
        L_0x0016:
            switch(r2) {
                case 10201: goto L_0x005d;
                case 10202: goto L_0x004e;
                case 10203: goto L_0x0049;
                default: goto L_0x0019;
            }
        L_0x0019:
            switch(r2) {
                case 10601: goto L_0x0044;
                case 10602: goto L_0x003f;
                case 10603: goto L_0x003a;
                case 10604: goto L_0x0035;
                case 10605: goto L_0x0030;
                case 10606: goto L_0x002b;
                case 10607: goto L_0x0026;
                case 10608: goto L_0x0021;
                case 10609: goto L_0x0058;
                default: goto L_0x001c;
            }
        L_0x001c:
            java.lang.String r2 = "Internal Error."
            r1.init = r2
            return
        L_0x0021:
            java.lang.String r2 = "Invalid ACS Payload."
            r1.init = r2
            return
        L_0x0026:
            java.lang.String r2 = "Invalid Payload."
            r1.init = r2
            return
        L_0x002b:
            java.lang.String r2 = "Payload Validation failed."
            r1.init = r2
            return
        L_0x0030:
            java.lang.String r2 = "Invalid Payload passed to Continue."
            r1.init = r2
            return
        L_0x0035:
            java.lang.String r2 = "Invalid Payload passed to Continue: Null or Empty Payload."
            r1.init = r2
            return
        L_0x003a:
            java.lang.String r2 = "Invalid Transaction ID passed to Continue."
            r1.init = r2
            return
        L_0x003f:
            java.lang.String r2 = "Invalid Cardinal Validate Receiver."
            r1.init = r2
            return
        L_0x0044:
            java.lang.String r2 = "Invalid Transition: An error occurred during Cardinal Init."
            r1.init = r2
            return
        L_0x0049:
            java.lang.String r2 = "Invalid Receiver or Interface."
            r1.init = r2
            return
        L_0x004e:
            java.lang.String r2 = "Invalid JWT String."
            r1.init = r2
            return
        L_0x0053:
            java.lang.String r2 = "Invalid Cardinal Configuration Parameters: Null."
            r1.init = r2
            return
        L_0x0058:
            java.lang.String r2 = "Invalid Activity: Null Activity."
            r1.init = r2
            return
        L_0x005d:
            java.lang.String r2 = "Invalid Transition: An error occurred during Cardinal Configure."
            r1.init = r2
            return
        L_0x0062:
            java.lang.String r2 = "Subsequent CRes Validation fails."
            r1.init = r2
            return
        L_0x0067:
            java.lang.String r2 = "Invalid Input."
            r1.init = r2
            return
        L_0x006c:
            java.lang.String r2 = "SDKRenderType value 'HTML' is not valid when SDKUIType is set to NATIVE"
            r1.init = r2
            return
        L_0x0071:
            java.lang.String r2 = "Challenge timed out."
            r1.init = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError.<init>(int):void");
    }
}

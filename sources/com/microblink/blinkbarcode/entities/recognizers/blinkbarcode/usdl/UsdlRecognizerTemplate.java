package com.microblink.blinkbarcode.entities.recognizers.blinkbarcode.usdl;

import com.microblink.blinkbarcode.util.StringUtils;

@Deprecated
/* compiled from: line */
class UsdlRecognizerTemplate {

    /* compiled from: line */
    public static class Result {
        private static native byte[][] dynamicElementsNativeGet(long j);

        private static native byte[] elementNativeGet(long j, int i);

        public String getField(UsdlKeys usdlKeys) {
            return StringUtils.convertByteArrayToString(elementNativeGet(0, usdlKeys.ordinal()));
        }

        @Deprecated
        public String[] getOptionalElements() {
            byte[][] dynamicElementsNativeGet = dynamicElementsNativeGet(0);
            String[] strArr = new String[dynamicElementsNativeGet.length];
            for (int i = 0; i < dynamicElementsNativeGet.length; i++) {
                strArr[i] = StringUtils.convertByteArrayToString(dynamicElementsNativeGet[i]);
            }
            return strArr;
        }

        public String toString() {
            return "US Driver's License\n\n" + null;
        }
    }
}

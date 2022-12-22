package com.didi.security.uuid;

public class NetUtils {
    public String netInterfaceInfo() {
        return null;
    }

    /* renamed from: a */
    private String m27305a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.length();
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}

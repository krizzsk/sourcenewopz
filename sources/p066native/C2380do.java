package p066native;

import android.content.Context;
import android.provider.Settings;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: native.do */
/* compiled from: DeviceIdProvider */
public class C2380do {
    /* renamed from: do */
    public static String m3041do(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            return m3040a(string + "iProov");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m3040a(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & 255);
            while (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}

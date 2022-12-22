package com.didi.unifylogin.utils.autologin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.Signature;
import android.util.Base64;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.apm.SystemUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppSignatureHashHelper extends ContextWrapper {
    public static final int NUM_BASE64_CHAR = 11;
    public static final int NUM_HASHED_BYTES = 9;
    public static final String TAG = AppSignatureHashHelper.class.getSimpleName();

    /* renamed from: a */
    private static final String f44948a = "SHA-256";

    public AppSignatureHashHelper(Context context) {
        super(context);
    }

    public ArrayList<String> getAppSignatures() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = getPackageName();
            for (Signature charsString : SystemUtils.getPackageInfo(getPackageManager(), packageName, 64).signatures) {
                String a = m32228a(packageName, charsString.toCharsString());
                if (a != null) {
                    arrayList.add(String.format(InvitationTrackFragment.INVITE_DATE, new Object[]{a}));
                }
            }
        } catch (Exception e) {
            SystemUtils.log(6, TAG, "Package not found", e, "com.didi.unifylogin.utils.autologin.AppSignatureHashHelper", 50);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static String m32228a(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str3.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeToString(Arrays.copyOfRange(instance.digest(), 0, 9), 3).substring(0, 11);
        } catch (NoSuchAlgorithmException e) {
            SystemUtils.log(6, TAG, "No Such Algorithm Exception", e, "com.didi.unifylogin.utils.autologin.AppSignatureHashHelper", 71);
            return null;
        }
    }
}

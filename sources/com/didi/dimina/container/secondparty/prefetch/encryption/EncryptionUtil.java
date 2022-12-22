package com.didi.dimina.container.secondparty.prefetch.encryption;

import android.util.Base64;
import android.util.Log;
import com.didi.dimina.container.util.LogUtil;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
    public static final String TAG = "EncryptionUtil";

    /* renamed from: a */
    private static final String f17434a = "AES";

    /* renamed from: b */
    private static final String f17435b = "AES/ECB/PKCS7Padding";

    public static String encryption(String str) {
        try {
            String str2 = get16Random();
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), f17434a);
            Cipher instance = Cipher.getInstance(f17435b);
            instance.init(1, secretKeySpec);
            String str3 = str2 + new String(Base64.encode(instance.doFinal(str.getBytes(StandardCharsets.UTF_8)), 2), StandardCharsets.UTF_8);
            LogUtil.m13412i(TAG, "key:" + str2 + "\t data:" + str3);
            return str3;
        } catch (Exception e) {
            LogUtil.m13410e(TAG, "发生错误:" + Log.getStackTraceString(e));
            e.printStackTrace();
            return null;
        }
    }

    public static String get16Random() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }
}

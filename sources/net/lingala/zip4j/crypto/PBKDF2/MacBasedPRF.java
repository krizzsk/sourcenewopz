package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MacBasedPRF implements C2384c {

    /* renamed from: a */
    private Mac f4805a;

    /* renamed from: b */
    private int f4806b;

    /* renamed from: c */
    private String f4807c;

    public MacBasedPRF(String str) {
        this.f4807c = str;
        try {
            Mac instance = Mac.getInstance(str);
            this.f4805a = instance;
            this.f4806b = instance.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] doFinal(byte[] bArr) {
        return this.f4805a.doFinal(bArr);
    }

    public byte[] doFinal() {
        return this.f4805a.doFinal();
    }

    public int getHLen() {
        return this.f4806b;
    }

    public void init(byte[] bArr) {
        try {
            this.f4805a.init(new SecretKeySpec(bArr, this.f4807c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(byte[] bArr) {
        try {
            this.f4805a.update(bArr);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        try {
            this.f4805a.update(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}

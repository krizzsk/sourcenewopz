package com.didi.sdk.audiorecorder.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryption {
    public static final int AES_Key_Size = 128;
    public static final String EMPTY_STRING = "";
    public static int PUBLIC_KEY_VERSION = 1;

    /* renamed from: a */
    private static final String f35573a = "FileEncryption -> ";

    /* renamed from: b */
    private static String f35574b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtikyBUIL5D3dwLUd2VRzvaBqd75RS99jt756beQzg3DAjD+775Cgepp5BCSrPiiS4BMFO4v+/3wBUnIEycog2rh6EpUZC+DqsVeSY2Uh5uhcvMZLX262EJVwtGDL7wV4SSbxRZAKVs3/pbCPcn1HWXxpqbmHyfFVbJehZ5yroI+DCYjmIqMx7g10llR1uoBlEanLEFbXM+1YC5HKwRo0odCCz2AhblA6eLljdouwff1k/v073+8jSonDR7Dtf6YDFleN/4kBTGNQk3ceVAMCWIvXNYPecfxommt/RES5SGNRa6PoO0UjPOokizoKZL1HvCm6BypsAA5ZztJeSRjpJQIDAQAB";

    /* renamed from: c */
    private Cipher f35575c = Cipher.getInstance("AES/CBC/PKCS5Padding");

    /* renamed from: d */
    private SecretKeySpec f35576d;

    /* renamed from: e */
    private IvParameterSpec f35577e;

    public FileEncryption() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    public FileEncryption(String str) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.f35576d = new SecretKeySpec(str.getBytes(), "AES");
    }

    public FileEncryption(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.f35576d = new SecretKeySpec(bArr, "AES");
    }

    public static String getEncryptString(byte[] bArr) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("ibt_record_voice_public_key");
        if (!(toggle == null || (experiment = toggle.getExperiment()) == null)) {
            String str = (String) experiment.getParam("publicKey", "");
            int intValue = ((Integer) experiment.getParam("version", -1)).intValue();
            if (!TextUtils.isEmpty(str) && intValue != -1) {
                f35574b = str;
                PUBLIC_KEY_VERSION = intValue;
                LogUtil.log("KEYVERSION:" + intValue);
            }
        }
        try {
            return String.format("vault:v%s:%s", new Object[]{Integer.valueOf(PUBLIC_KEY_VERSION), Base64Utils.encode(RSAUtils.encryptByPublicKey(bArr, f35574b))});
        } catch (Exception e) {
            LogUtil.log("FileEncryption -> getEncryptString failed.", e);
            return "";
        }
    }

    public byte[] makeKey() throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        byte[] encoded = instance.generateKey().getEncoded();
        this.f35576d = new SecretKeySpec(encoded, "AES");
        this.f35577e = new IvParameterSpec(m25172a());
        return encoded;
    }

    /* renamed from: a */
    private byte[] m25172a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public void encrypt(File file, File file2) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        CipherOutputStream cipherOutputStream;
        this.f35575c.init(1, this.f35576d, this.f35577e);
        FileInputStream fileInputStream = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(this.f35577e.getIV());
                cipherOutputStream = new CipherOutputStream(fileOutputStream, this.f35575c);
                try {
                    m25171a(fileInputStream2, cipherOutputStream);
                    fileInputStream2.close();
                    cipherOutputStream.close();
                    m25170a(fileInputStream2);
                    m25170a(cipherOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m25170a(fileInputStream);
                    m25170a(cipherOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cipherOutputStream = null;
                fileInputStream = fileInputStream2;
                m25170a(fileInputStream);
                m25170a(cipherOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cipherOutputStream = null;
            m25170a(fileInputStream);
            m25170a(cipherOutputStream);
            throw th;
        }
    }

    public void decrypt(File file, File file2) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        FileOutputStream fileOutputStream;
        CipherInputStream cipherInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[this.f35575c.getBlockSize()];
            fileInputStream.read(bArr);
            this.f35575c.init(2, this.f35576d, new IvParameterSpec(bArr));
            CipherInputStream cipherInputStream2 = new CipherInputStream(fileInputStream, this.f35575c);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m25171a(cipherInputStream2, fileOutputStream);
                    cipherInputStream2.close();
                    fileOutputStream.close();
                    m25170a(cipherInputStream2);
                    m25170a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    cipherInputStream = cipherInputStream2;
                    m25170a(cipherInputStream);
                    m25170a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                cipherInputStream = cipherInputStream2;
                m25170a(cipherInputStream);
                m25170a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            m25170a(cipherInputStream);
            m25170a(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private void m25170a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    private void m25171a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}

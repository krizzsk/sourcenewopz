package com.facebook.crypto;

import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.mac.NativeMac;
import com.facebook.crypto.streams.FixedSizeByteArrayOutputStream;
import com.facebook.crypto.streams.NativeMacLayeredInputStream;
import com.facebook.crypto.streams.NativeMacLayeredOutputStream;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Crypto {
    private final CipherHelper mCipherHelper;
    private final KeyChain mKeyChain;
    private final NativeCryptoLibrary mNativeCryptoLibrary;

    public Crypto(KeyChain keyChain, NativeCryptoLibrary nativeCryptoLibrary) {
        this.mKeyChain = keyChain;
        this.mNativeCryptoLibrary = nativeCryptoLibrary;
        this.mCipherHelper = new CipherHelper(keyChain, nativeCryptoLibrary);
    }

    public boolean isAvailable() {
        try {
            this.mNativeCryptoLibrary.ensureCryptoLoaded();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, Entity entity) throws IOException, CryptoInitializationException, KeyChainException {
        return this.mCipherHelper.getCipherOutputStream(outputStream, entity);
    }

    public InputStream getCipherInputStream(InputStream inputStream, Entity entity) throws IOException, CryptoInitializationException, KeyChainException {
        return this.mCipherHelper.getCipherInputStream(inputStream, entity, (byte) inputStream.read(), (byte) inputStream.read());
    }

    public byte[] encrypt(byte[] bArr, Entity entity) throws KeyChainException, CryptoInitializationException, IOException {
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(bArr.length + this.mCipherHelper.getCipherMetaDataLength());
        OutputStream cipherOutputStream = this.mCipherHelper.getCipherOutputStream(fixedSizeByteArrayOutputStream, entity);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return fixedSizeByteArrayOutputStream.getBytes();
    }

    public byte[] decrypt(byte[] bArr, Entity entity) throws KeyChainException, CryptoInitializationException, IOException {
        byte b = bArr[0];
        byte b2 = bArr[1];
        int length = bArr.length;
        InputStream cipherInputStream = this.mCipherHelper.getCipherInputStream(new ByteArrayInputStream(bArr, 2, length), entity, b, b2);
        FixedSizeByteArrayOutputStream fixedSizeByteArrayOutputStream = new FixedSizeByteArrayOutputStream(length - this.mCipherHelper.getCipherMetaDataLength());
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = cipherInputStream.read(bArr2);
            if (read != -1) {
                fixedSizeByteArrayOutputStream.write(bArr2, 0, read);
            } else {
                cipherInputStream.close();
                return fixedSizeByteArrayOutputStream.getBytes();
            }
        }
    }

    public OutputStream getMacOutputStream(OutputStream outputStream, Entity entity) throws IOException, KeyChainException, CryptoInitializationException {
        outputStream.write(1);
        outputStream.write(1);
        NativeMac nativeMac = new NativeMac(this.mNativeCryptoLibrary);
        byte[] macKey = this.mKeyChain.getMacKey();
        nativeMac.init(macKey, macKey.length);
        computeMacAad(nativeMac, (byte) 1, (byte) 1, entity.getBytes());
        return new NativeMacLayeredOutputStream(nativeMac, outputStream);
    }

    public InputStream getMacInputStream(InputStream inputStream, Entity entity) throws IOException, KeyChainException, CryptoInitializationException {
        byte read = (byte) inputStream.read();
        boolean z = false;
        boolean z2 = read == 1;
        Assertions.checkArgumentForIO(z2, "Unexpected mac version " + read);
        byte read2 = (byte) inputStream.read();
        if (read2 == 1) {
            z = true;
        }
        Assertions.checkArgumentForIO(z, "Unexpected mac ID " + read2);
        NativeMac nativeMac = new NativeMac(this.mNativeCryptoLibrary);
        byte[] macKey = this.mKeyChain.getMacKey();
        nativeMac.init(macKey, macKey.length);
        computeMacAad(nativeMac, read, (byte) 1, entity.getBytes());
        return new NativeMacLayeredInputStream(nativeMac, inputStream);
    }

    private static void computeMacAad(NativeMac nativeMac, byte b, byte b2, byte[] bArr) throws IOException {
        byte[] bArr2 = {b};
        nativeMac.update(bArr2, 0, 1);
        nativeMac.update(new byte[]{b2}, 0, 1);
        nativeMac.update(bArr, 0, bArr.length);
    }
}

package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import com.facebook.crypto.cipher.NativeGCMCipherException;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.streams.NativeGCMCipherInputStream;
import com.facebook.crypto.streams.NativeGCMCipherOutputStream;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class CipherHelper {
    private final KeyChain mKeyChain;
    private final NativeCryptoLibrary mNativeCryptoLibrary;

    public int getCipherMetaDataLength() {
        return 30;
    }

    public CipherHelper(KeyChain keyChain, NativeCryptoLibrary nativeCryptoLibrary) {
        this.mKeyChain = keyChain;
        this.mNativeCryptoLibrary = nativeCryptoLibrary;
    }

    public OutputStream getCipherOutputStream(OutputStream outputStream, Entity entity) throws KeyChainException, CryptoInitializationException, IOException {
        outputStream.write(1);
        outputStream.write(1);
        byte[] newIV = this.mKeyChain.getNewIV();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.mNativeCryptoLibrary);
        nativeGCMCipher.encryptInit(this.mKeyChain.getCipherKey(), newIV);
        outputStream.write(newIV);
        computeCipherAad(nativeGCMCipher, (byte) 1, (byte) 1, entity.getBytes());
        return new NativeGCMCipherOutputStream(outputStream, nativeGCMCipher);
    }

    public InputStream getCipherInputStream(InputStream inputStream, Entity entity, byte b, byte b2) throws IOException, KeyChainException, CryptoInitializationException {
        boolean z = false;
        boolean z2 = b == 1;
        Assertions.checkArgumentForIO(z2, "Unexpected crypto version " + b);
        if (b2 == 1) {
            z = true;
        }
        Assertions.checkArgumentForIO(z, "Unexpected cipher ID " + b2);
        byte[] bArr = new byte[12];
        int read = inputStream.read(bArr);
        if (read == 12) {
            NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.mNativeCryptoLibrary);
            nativeGCMCipher.decryptInit(this.mKeyChain.getCipherKey(), bArr);
            computeCipherAad(nativeGCMCipher, b, b2, entity.getBytes());
            return new NativeGCMCipherInputStream(inputStream, nativeGCMCipher);
        }
        throw new IOException("Not enough bytes for iv: " + read);
    }

    public void computeCipherAad(NativeGCMCipher nativeGCMCipher, byte b, byte b2, byte[] bArr) throws NativeGCMCipherException {
        byte[] bArr2 = {b};
        nativeGCMCipher.updateAad(bArr2, 1);
        nativeGCMCipher.updateAad(new byte[]{b2}, 1);
        nativeGCMCipher.updateAad(bArr, bArr.length);
    }
}

package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.InputStream;

public class NativeGCMCipherInputStream extends InputStream {
    private static final int UPDATE_BUFFER_SIZE = 256;
    private final NativeGCMCipher mCipher;
    private final TailInputStream mCipherDelegate;
    private boolean mTagChecked = false;
    private final byte[] mUpdateBuffer;

    public boolean markSupported() {
        return false;
    }

    public NativeGCMCipherInputStream(InputStream inputStream, NativeGCMCipher nativeGCMCipher) {
        this.mCipherDelegate = new TailInputStream(inputStream, 16);
        this.mCipher = nativeGCMCipher;
        this.mUpdateBuffer = new byte[(nativeGCMCipher.getCipherBlockSize() + 256)];
    }

    public int available() throws IOException {
        return this.mCipherDelegate.available();
    }

    public void close() throws IOException {
        try {
            ensureTagValid();
        } finally {
            this.mCipherDelegate.close();
        }
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int read = this.mCipherDelegate.read(bArr, i, i2);
            if (read == -1) {
                ensureTagValid();
                return -1;
            }
            int i4 = read / 256;
            int i5 = read % 256;
            int i6 = i;
            int i7 = i6;
            for (int i8 = 0; i8 < i4; i8++) {
                int update = this.mCipher.update(bArr, i6, 256, this.mUpdateBuffer);
                System.arraycopy(this.mUpdateBuffer, 0, bArr, i7, update);
                i7 += update;
                i6 += 256;
            }
            if (i5 > 0) {
                int update2 = this.mCipher.update(bArr, i6, i5, this.mUpdateBuffer);
                System.arraycopy(this.mUpdateBuffer, 0, bArr, i7, update2);
                i7 += update2;
            }
            return i7 - i;
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    private void ensureTagValid() throws IOException {
        if (!this.mTagChecked) {
            this.mTagChecked = true;
            try {
                this.mCipher.decryptFinal(this.mCipherDelegate.getTail(), 16);
            } finally {
                this.mCipher.destroy();
            }
        }
    }

    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        throw new UnsupportedOperationException();
    }
}

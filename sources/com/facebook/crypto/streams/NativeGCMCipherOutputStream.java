package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.OutputStream;

public class NativeGCMCipherOutputStream extends OutputStream {
    private static final int UPDATE_BUFFER_SIZE = 256;
    private final NativeGCMCipher mCipher;
    private final OutputStream mCipherDelegate;
    private final byte[] mTag = new byte[16];
    private boolean mTagAppended = false;
    private final byte[] mUpdateBuffer;

    public NativeGCMCipherOutputStream(OutputStream outputStream, NativeGCMCipher nativeGCMCipher) {
        this.mCipherDelegate = outputStream;
        this.mCipher = nativeGCMCipher;
        this.mUpdateBuffer = new byte[(nativeGCMCipher.getCipherBlockSize() + 256)];
    }

    public void close() throws IOException {
        try {
            appendTag();
        } finally {
            this.mCipherDelegate.close();
        }
    }

    private void appendTag() throws IOException {
        if (!this.mTagAppended) {
            this.mTagAppended = true;
            try {
                this.mCipher.encryptFinal(this.mTag, this.mTag.length);
                this.mCipherDelegate.write(this.mTag);
            } finally {
                this.mCipher.destroy();
            }
        }
    }

    public void flush() throws IOException {
        this.mCipherDelegate.flush();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int i4 = i2 / 256;
            int i5 = i2 % 256;
            for (int i6 = 0; i6 < i4; i6++) {
                this.mCipherDelegate.write(this.mUpdateBuffer, 0, this.mCipher.update(bArr, i, 256, this.mUpdateBuffer));
                i += 256;
            }
            if (i5 > 0) {
                this.mCipherDelegate.write(this.mUpdateBuffer, 0, this.mCipher.update(bArr, i, i5, this.mUpdateBuffer));
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }
}

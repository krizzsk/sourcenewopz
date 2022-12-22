package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class Utils {
    private static final String TAG = "Utils";

    Utils() {
    }

    static int getSampleSize(int i, int i2, int i3, int i4) {
        int i5;
        int min = Math.min(i2 / i4, i / i3);
        if (min == 0) {
            i5 = 0;
        } else {
            i5 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i5);
        if (Log.isLoggable(TAG, 2) && max > 1) {
            SystemUtils.log(2, TAG, "Downsampling WEBP, sampleSize: " + max + ", target dimens: [" + i3 + "x" + i4 + "], actual dimens: [" + i + "x" + i2 + Const.jaRight, (Throwable) null, "com.bumptech.glide.integration.webp.decoder.Utils", 23);
        }
        return max;
    }

    static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            IOException iOException = e;
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            SystemUtils.log(5, TAG, "Error reading data from stream", iOException, "com.bumptech.glide.integration.webp.decoder.Utils", 43);
            return null;
        }
    }
}

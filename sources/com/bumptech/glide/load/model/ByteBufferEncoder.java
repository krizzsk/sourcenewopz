package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    public boolean encode(ByteBuffer byteBuffer, File file, Options options) {
        try {
            ByteBufferUtil.toFile(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                SystemUtils.log(3, TAG, "Failed to write data", e, "com.bumptech.glide.load.model.ByteBufferEncoder", 24);
            }
            return false;
        }
    }
}

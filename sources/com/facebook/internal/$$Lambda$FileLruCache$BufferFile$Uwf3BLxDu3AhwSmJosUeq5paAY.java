package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.-$$Lambda$FileLruCache$BufferFile$Uwf3BLxD-u3AhwSmJosUeq5paAY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FileLruCache$BufferFile$Uwf3BLxDu3AhwSmJosUeq5paAY implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$FileLruCache$BufferFile$Uwf3BLxDu3AhwSmJosUeq5paAY INSTANCE = new $$Lambda$FileLruCache$BufferFile$Uwf3BLxDu3AhwSmJosUeq5paAY();

    private /* synthetic */ $$Lambda$FileLruCache$BufferFile$Uwf3BLxDu3AhwSmJosUeq5paAY() {
    }

    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.m47383filterExcludeBufferFiles$lambda0(file, str);
    }
}

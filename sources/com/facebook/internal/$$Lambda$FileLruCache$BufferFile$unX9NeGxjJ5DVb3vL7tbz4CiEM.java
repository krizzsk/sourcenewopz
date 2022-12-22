package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.-$$Lambda$FileLruCache$BufferFile$unX9NeGxjJ5DVb3-vL7tbz4CiEM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$FileLruCache$BufferFile$unX9NeGxjJ5DVb3vL7tbz4CiEM implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$FileLruCache$BufferFile$unX9NeGxjJ5DVb3vL7tbz4CiEM INSTANCE = new $$Lambda$FileLruCache$BufferFile$unX9NeGxjJ5DVb3vL7tbz4CiEM();

    private /* synthetic */ $$Lambda$FileLruCache$BufferFile$unX9NeGxjJ5DVb3vL7tbz4CiEM() {
    }

    public final boolean accept(File file, String str) {
        return FileLruCache.BufferFile.m47384filterExcludeNonBufferFiles$lambda1(file, str);
    }
}

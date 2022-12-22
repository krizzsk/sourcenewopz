package com.didi.dimina.container.secondparty.image;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public class GlideDiskCache extends DiskLruCacheFactory {

    /* renamed from: a */
    private static final int f17127a = 262144000;

    /* renamed from: b */
    private static final String f17128b = "image_manager_disk_cache";

    /* renamed from: d */
    private static GlideDiskCache f17129d;

    /* renamed from: c */
    private DiskCache f17130c;

    public static GlideDiskCache getDiskCache(Context context) {
        if (f17129d == null) {
            synchronized (GlideDiskCache.class) {
                if (f17129d == null) {
                    f17129d = new GlideDiskCache(context, "image_manager_disk_cache", 262144000);
                }
            }
        }
        return f17129d;
    }

    public GlideDiskCache(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public GlideDiskCache(Context context, int i) {
        this(context, "image_manager_disk_cache", i);
    }

    public GlideDiskCache(final Context context, final String str, int i) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, (long) i);
    }

    public DiskCache build() {
        if (this.f17130c == null) {
            this.f17130c = super.build();
        }
        return this.f17130c;
    }
}

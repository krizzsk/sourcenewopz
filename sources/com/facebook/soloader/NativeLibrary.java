package com.facebook.soloader;

import com.didi.sdk.apm.SystemUtils;
import java.util.List;
import javax.annotation.Nullable;

public abstract class NativeLibrary {
    private static final String TAG = NativeLibrary.class.getName();
    private boolean mLibrariesLoaded = false;
    @Nullable
    private List<String> mLibraryNames;
    @Nullable
    private volatile UnsatisfiedLinkError mLinkError = null;
    private Boolean mLoadLibraries = true;
    private final Object mLock = new Object();

    /* access modifiers changed from: protected */
    public void initialNativeCheck() throws UnsatisfiedLinkError {
    }

    protected NativeLibrary(List<String> list) {
        this.mLibraryNames = list;
    }

    @Nullable
    public boolean loadLibraries() {
        synchronized (this.mLock) {
            if (!this.mLoadLibraries.booleanValue()) {
                boolean z = this.mLibrariesLoaded;
                return z;
            }
            try {
                if (this.mLibraryNames != null) {
                    for (String loadLibrary : this.mLibraryNames) {
                        SoLoader.loadLibrary(loadLibrary);
                    }
                }
                initialNativeCheck();
                this.mLibrariesLoaded = true;
                this.mLibraryNames = null;
            } catch (UnsatisfiedLinkError e) {
                SystemUtils.log(6, TAG, "Failed to load native lib (initial check): ", e, "com.facebook.soloader.NativeLibrary", 70);
                this.mLinkError = e;
                this.mLibrariesLoaded = false;
            } catch (Throwable th) {
                SystemUtils.log(6, TAG, "Failed to load native lib (other error): ", th, "com.facebook.soloader.NativeLibrary", 74);
                this.mLinkError = new UnsatisfiedLinkError("Failed loading libraries");
                this.mLinkError.initCause(th);
                this.mLibrariesLoaded = false;
            }
            this.mLoadLibraries = false;
            boolean z2 = this.mLibrariesLoaded;
            return z2;
        }
    }

    public void ensureLoaded() throws UnsatisfiedLinkError {
        if (!loadLibraries()) {
            throw this.mLinkError;
        }
    }

    @Nullable
    public UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }
}

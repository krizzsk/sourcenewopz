package com.didi.trackupload.sdk;

import com.didi.trackupload.sdk.datachannel.IDataChannel;
import java.io.File;
import java.util.Locale;

public class TrackInitParams {

    /* renamed from: a */
    private IDataChannel f36989a;

    /* renamed from: b */
    private ICommonInfoDelegate f36990b;

    /* renamed from: c */
    private boolean f36991c;

    /* renamed from: d */
    private File f36992d;

    TrackInitParams(IDataChannel iDataChannel, ICommonInfoDelegate iCommonInfoDelegate, boolean z, File file) {
        this.f36989a = iDataChannel;
        this.f36990b = iCommonInfoDelegate;
        this.f36991c = z;
        this.f36992d = file;
    }

    public IDataChannel getDataChannel() {
        return this.f36989a;
    }

    public ICommonInfoDelegate getCommonInfoDelegate() {
        return this.f36990b;
    }

    public boolean isDirectUploadModeEnabled() {
        return this.f36991c;
    }

    public File getBaMaiLogPath() {
        return this.f36992d;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackInitParams@%s{dataChannel=%s, commonDelegate=%s, directUpload=%s, bmLogPath=%s}", new Object[]{Integer.toHexString(hashCode()), this.f36989a, this.f36990b, Boolean.valueOf(this.f36991c), this.f36992d});
    }

    public static class Builder {
        private File mBaMaiLogPath;
        private ICommonInfoDelegate mCommonInfoDelegate;
        private IDataChannel mDataChannel;
        private boolean mDirectUploadModeEnabled;

        public Builder dataChannel(IDataChannel iDataChannel) {
            this.mDataChannel = iDataChannel;
            return this;
        }

        public Builder commonInfoDelegate(ICommonInfoDelegate iCommonInfoDelegate) {
            this.mCommonInfoDelegate = iCommonInfoDelegate;
            return this;
        }

        public Builder enableDirectUploadMode() {
            this.mDirectUploadModeEnabled = true;
            return this;
        }

        public Builder setBaMaiLogPath(File file) {
            this.mBaMaiLogPath = file;
            return this;
        }

        public TrackInitParams build() {
            return new TrackInitParams(this.mDataChannel, this.mCommonInfoDelegate, this.mDirectUploadModeEnabled, this.mBaMaiLogPath);
        }
    }
}

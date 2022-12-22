package com.didi.app.nova.skeleton.image.glide.internal;

import android.net.Uri;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.app.nova.skeleton.image.glide.internal.DiFitUriLoader;

public class SodaUrl {

    /* renamed from: a */
    private GlideUrl f8468a;

    /* renamed from: b */
    private DiFitUriLoader.FitSize f8469b;

    public SodaUrl(Uri uri, DiFitUriLoader.FitSize fitSize) {
        this.f8468a = new GlideUrl(uri.toString());
        this.f8469b = fitSize;
    }

    public GlideUrl getSourceUrl() {
        return this.f8468a;
    }

    public DiFitUriLoader.FitSize getFitSize() {
        return this.f8469b;
    }

    public GlideUrl getResizeUrl() {
        if (this.f8469b == null) {
            return this.f8468a;
        }
        return new GlideUrl(this.f8468a.toStringUrl() + "!" + this.f8469b.width() + "x" + this.f8469b.height() + "_m");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SodaUrl)) {
            return false;
        }
        SodaUrl sodaUrl = (SodaUrl) obj;
        if (!this.f8468a.equals(sodaUrl.f8468a) || !DiFitUriLoader.isEqualsSize(this.f8469b, sodaUrl.getFitSize())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f8468a.hashCode() + 31;
        DiFitUriLoader.FitSize fitSize = this.f8469b;
        return hashCode + (fitSize == null ? 0 : fitSize.width() * this.f8469b.height());
    }
}

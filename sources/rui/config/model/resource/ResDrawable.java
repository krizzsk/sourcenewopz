package rui.config.model.resource;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import rui.config.model.color.IRModelColor;

public class ResDrawable implements IRModelColor {

    /* renamed from: a */
    private String f6760a;

    /* renamed from: b */
    private int f6761b;

    /* renamed from: c */
    private Drawable f6762c;

    /* renamed from: d */
    private Uri f6763d;

    public ResDrawable(String str, int i, Drawable drawable, Uri uri) {
        this.f6760a = str;
        this.f6761b = i;
        this.f6762c = drawable;
        this.f6763d = uri;
    }

    public String getResName() {
        return this.f6760a;
    }

    public int getResId() {
        return this.f6761b;
    }

    public Drawable getResDrawable() {
        return this.f6762c;
    }

    public Uri getResUri() {
        return this.f6763d;
    }
}

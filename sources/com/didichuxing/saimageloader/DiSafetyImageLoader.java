package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.io.File;
import java.net.URL;

public final class DiSafetyImageLoader {

    /* renamed from: a */
    private static boolean f48585a = true;

    /* renamed from: b */
    private Context f48586b = null;

    /* renamed from: c */
    private ImageView f48587c = null;

    /* renamed from: d */
    private Object f48588d = null;

    /* renamed from: e */
    private Object f48589e = null;

    /* renamed from: f */
    private Object f48590f = null;

    private DiSafetyImageLoader(Context context) {
        this.f48586b = context;
    }

    public static DiSafetyImageLoader with(Context context) {
        return new DiSafetyImageLoader(context);
    }

    public DiSafetyImageLoader load(String str) {
        this.f48588d = str;
        return this;
    }

    public DiSafetyImageLoader load(int i) {
        this.f48588d = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader load(Drawable drawable) {
        this.f48588d = drawable;
        return this;
    }

    public DiSafetyImageLoader load(Bitmap bitmap) {
        this.f48588d = bitmap;
        return this;
    }

    public DiSafetyImageLoader load(Uri uri) {
        this.f48588d = uri;
        return this;
    }

    public DiSafetyImageLoader load(URL url) {
        this.f48588d = url;
        return this;
    }

    public DiSafetyImageLoader load(File file) {
        this.f48588d = file;
        return this;
    }

    @Deprecated
    public DiSafetyImageLoader load(Object obj) {
        this.f48588d = obj;
        return this;
    }

    public DiSafetyImageLoader placeholder(int i) {
        this.f48589e = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader placeholder(Drawable drawable) {
        this.f48589e = drawable;
        return this;
    }

    public DiSafetyImageLoader error(int i) {
        this.f48590f = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader error(Drawable drawable) {
        this.f48590f = drawable;
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:8:0x0015=Splitter:B:8:0x0015, B:4:0x000a=Splitter:B:4:0x000a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void into(android.widget.ImageView r1) {
        /*
            r0 = this;
            r0.f48587c = r1
            boolean r1 = f48585a
            if (r1 == 0) goto L_0x0011
            r0.m34806a()     // Catch:{ all -> 0x000a }
            goto L_0x001b
        L_0x000a:
            r0.m34807b()     // Catch:{ all -> 0x001b }
            r1 = 0
            f48585a = r1     // Catch:{ all -> 0x001b }
            goto L_0x001b
        L_0x0011:
            r0.m34807b()     // Catch:{ all -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            r0.m34806a()     // Catch:{ all -> 0x001b }
            r1 = 1
            f48585a = r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.saimageloader.DiSafetyImageLoader.into(android.widget.ImageView):void");
    }

    /* renamed from: a */
    private void m34806a() {
        C16296b.m34814a(this.f48586b).mo120430a(this.f48588d).mo120432b(this.f48589e).mo120433c(this.f48590f).mo120431a(this.f48587c);
    }

    /* renamed from: b */
    private void m34807b() {
        C16295a.m34808a(this.f48586b).mo120426a(this.f48588d).mo120428b(this.f48589e).mo120429c(this.f48590f).mo120427a(this.f48587c);
    }
}

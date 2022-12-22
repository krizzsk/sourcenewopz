package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {

    /* renamed from: a */
    private final MutablePair<String> f1357a = new MutablePair<>();

    /* renamed from: b */
    private final Map<MutablePair<String>, Typeface> f1358b = new HashMap();

    /* renamed from: c */
    private final Map<String, Typeface> f1359c = new HashMap();

    /* renamed from: d */
    private final AssetManager f1360d;

    /* renamed from: e */
    private FontAssetDelegate f1361e;

    /* renamed from: f */
    private String f1362f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.f1361e = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.f1360d = null;
            return;
        }
        this.f1360d = ((View) callback).getContext().getAssets();
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f1361e = fontAssetDelegate;
    }

    public void setDefaultFontFileExtension(String str) {
        this.f1362f = str;
    }

    public Typeface getTypeface(String str, String str2) {
        this.f1357a.set(str, str2);
        Typeface typeface = this.f1358b.get(this.f1357a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = m1300a(m1301a(str), str2);
        this.f1358b.put(this.f1357a, a);
        return a;
    }

    /* renamed from: a */
    private Typeface m1301a(String str) {
        String fontPath;
        Typeface typeface = this.f1359c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        FontAssetDelegate fontAssetDelegate = this.f1361e;
        if (fontAssetDelegate != null) {
            typeface2 = fontAssetDelegate.fetchFont(str);
        }
        FontAssetDelegate fontAssetDelegate2 = this.f1361e;
        if (!(fontAssetDelegate2 == null || typeface2 != null || (fontPath = fontAssetDelegate2.getFontPath(str)) == null)) {
            typeface2 = Typeface.createFromAsset(this.f1360d, fontPath);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f1360d, "fonts/" + str + this.f1362f);
        }
        this.f1359c.put(str, typeface2);
        return typeface2;
    }

    /* renamed from: a */
    private Typeface m1300a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}

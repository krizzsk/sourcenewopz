package com.didi.soda.blocks.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class FontManager {
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "font/";
    private static FontManager instance;
    private final Map<String, FontFamily> mFontCache = new HashMap();

    private FontManager() {
    }

    public static FontManager getInstance() {
        if (instance == null) {
            instance = new FontManager();
        }
        return instance;
    }

    public Typeface getTypeface(String str, int i, AssetManager assetManager) {
        return getTypeface(str, FONTS_ASSET_PATH, i, assetManager);
    }

    public Typeface getTypeface(String str, String str2, int i, AssetManager assetManager) {
        FontFamily fontFamily = this.mFontCache.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily();
            this.mFontCache.put(str, fontFamily);
        }
        Typeface typeface = fontFamily.getTypeface(i);
        if (typeface == null && (typeface = createTypeface(str, str2, i, assetManager)) != null) {
            fontFamily.setTypeface(i, typeface);
        }
        return typeface;
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        if (typeface != null) {
            FontFamily fontFamily = this.mFontCache.get(str);
            if (fontFamily == null) {
                fontFamily = new FontFamily();
                this.mFontCache.put(str, fontFamily);
            }
            fontFamily.setTypeface(i, typeface);
        }
    }

    private static Typeface createTypeface(String str, String str2, int i, AssetManager assetManager) {
        if (str2 == null) {
            str2 = FONTS_ASSET_PATH;
        } else if (!TextUtils.isEmpty(str2)) {
            str2 = str2 + "/";
        }
        String str3 = EXTENSIONS[i];
        String[] strArr = FILE_EXTENSIONS;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                return Typeface.createFromAsset(assetManager, str2 + str + str3 + strArr[i2]);
            } catch (Exception e) {
                e.printStackTrace();
                i2++;
            }
        }
        return null;
    }

    private static class FontFamily {
        private final SparseArray<Typeface> mTypefaceSparseArray;

        private FontFamily() {
            this.mTypefaceSparseArray = new SparseArray<>(4);
        }

        public Typeface getTypeface(int i) {
            return this.mTypefaceSparseArray.get(i);
        }

        public void setTypeface(int i, Typeface typeface) {
            this.mTypefaceSparseArray.put(i, typeface);
        }
    }
}

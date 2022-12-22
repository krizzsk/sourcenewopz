package com.didi.component.common.util;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import com.didi.travel.psnger.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternTextHelper {
    public static SpannableString getFormatTextByAdapter(String str, String str2, RichTextAdapter richTextAdapter) {
        try {
            return richTextAdapter.convertText2Span();
        } catch (Exception e) {
            LogUtil.m31427d("hgl_tag", "convert text to richtext fail with:  " + e.getMessage());
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return SpannableString.valueOf(str);
            }
            if (str.length() != str2.length()) {
                return SpannableString.valueOf(str);
            }
            return SpannableString.valueOf(str);
        }
    }

    public static RichTextAdapter defaultLargeTextAdapter(String str, String str2) {
        return new LargeModeRichTextAdapter(str, str2);
    }

    public static RichTextAdapter defaultSmallTextAdapter(String str, String str2) {
        return new LargeModeRichTextAdapter(str, str2) {
            /* access modifiers changed from: package-private */
            public void initTextSizeConf() {
                this.largeModeConf = new HashMap();
                this.largeModeConf.put('s', 10);
                this.largeModeConf.put('m', 12);
                this.largeModeConf.put('l', 15);
                this.largeModeConf.put('t', 9);
                this.largeModeConf.put('b', 9);
                this.largeModeConf.put('w', 12);
                this.largeModeConf.put('-', 12);
            }

            /* access modifiers changed from: protected */
            public void resizeSuperSpanBaselineShft(TextPaint textPaint) {
                textPaint.baselineShift += (int) (textPaint.ascent() / 3.0f);
            }
        };
    }

    public static class LargeModeRichTextAdapter extends RichTextAdapter {
        protected Map<Character, Integer> largeModeConf = null;

        public /* bridge */ /* synthetic */ void bindText(String str, String str2) {
            super.bindText(str, str2);
        }

        public /* bridge */ /* synthetic */ SpannableString convertText2Span() throws IllegalStateException {
            return super.convertText2Span();
        }

        public /* bridge */ /* synthetic */ boolean isSupportWhiteSpace() {
            return super.isSupportWhiteSpace();
        }

        public LargeModeRichTextAdapter() {
        }

        public LargeModeRichTextAdapter(String str, String str2) {
            super(str, str2);
            initData();
        }

        /* access modifiers changed from: package-private */
        public void initData() {
            initTextSizeConf();
        }

        /* access modifiers changed from: package-private */
        public void initTextSizeConf() {
            HashMap hashMap = new HashMap();
            this.largeModeConf = hashMap;
            hashMap.put('s', 23);
            this.largeModeConf.put('m', 28);
            this.largeModeConf.put('l', 33);
            this.largeModeConf.put('t', 16);
            this.largeModeConf.put('b', 16);
            this.largeModeConf.put('w', 28);
            this.largeModeConf.put('-', 28);
        }

        /* access modifiers changed from: package-private */
        public int getTextSize(Character ch) {
            if (this.largeModeConf.containsKey(ch)) {
                return this.largeModeConf.get(ch).intValue();
            }
            if (this.largeModeConf.containsKey("m")) {
                return this.largeModeConf.get("m").intValue();
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public void resizeSuperSpanBaselineShft(TextPaint textPaint) {
            textPaint.baselineShift += (int) (textPaint.ascent() / 2.0f);
            LogUtil.m31427d("hgl_tag", "shift value2 = " + (textPaint.ascent() / 2.0f));
        }

        public SpannableString doConvert() {
            List<PatternItem> parsePattern = parsePattern();
            if (parsePattern == null || parsePattern.size() <= 0) {
                return SpannableString.valueOf(this.mOriginText);
            }
            int length = this.mOriginText.length();
            SpannableString spannableString = new SpannableString(this.mOriginText);
            for (PatternItem next : parsePattern) {
                int textSize = getTextSize(Character.valueOf(next.patternLetter));
                if (textSize >= 0) {
                    int i = length - 1;
                    if (next.startIndex >= i) {
                        break;
                    }
                    if (next.lastIndex >= i) {
                        next.lastIndex = i;
                    }
                    if (next.patternLetter != '-') {
                        spannableString.setSpan(new AbsoluteSizeSpan((int) (((double) ((float) textSize)) + 0.5d), true), next.startIndex, next.lastIndex + 1, 17);
                    }
                    char c = next.patternLetter;
                    if (c == 'b') {
                        spannableString.setSpan(new SubscriptSpan(), next.startIndex, next.lastIndex + 1, 17);
                    } else if (c == 't') {
                        spannableString.setSpan(new SuperscriptSpan() {
                            public void updateDrawState(TextPaint textPaint) {
                                LargeModeRichTextAdapter.this.resizeSuperSpanBaselineShft(textPaint);
                            }
                        }, next.startIndex, next.lastIndex + 1, 17);
                    } else if (c == 'w' && isSupportWhiteSpace()) {
                        spannableString.setSpan(new ScaleXSpan(0.3f), next.startIndex, next.lastIndex + 1, 33);
                    }
                } else {
                    throw new IllegalStateException(String.format("Invalid text size config with negative value %d", new Object[]{Integer.valueOf(textSize)}));
                }
            }
            return spannableString;
        }

        private List<PatternItem> parsePattern() {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(this.mPattern)) {
                return arrayList;
            }
            char c = '0';
            PatternItem patternItem = null;
            for (int i = 0; i < this.mPattern.length(); i++) {
                char charAt = this.mPattern.charAt(i);
                if (i == 0 || charAt != c) {
                    PatternItem patternItem2 = new PatternItem();
                    patternItem2.patternLetter = charAt;
                    patternItem2.startIndex = i;
                    patternItem2.lastIndex = i;
                    arrayList.add(patternItem2);
                    patternItem = patternItem2;
                } else if (patternItem != null) {
                    patternItem.lastIndex = i;
                }
                c = this.mPattern.charAt(i);
            }
            return arrayList;
        }
    }

    static abstract class RichTextAdapter {
        protected String mOriginText;
        protected String mPattern;

        public abstract SpannableString doConvert();

        /* access modifiers changed from: package-private */
        public abstract int getTextSize(Character ch);

        /* access modifiers changed from: package-private */
        public abstract void initData();

        /* access modifiers changed from: package-private */
        public abstract void initTextSizeConf();

        public boolean isSupportWhiteSpace() {
            return false;
        }

        public RichTextAdapter() {
        }

        public RichTextAdapter(String str, String str2) {
            this.mOriginText = str;
            this.mPattern = str2;
        }

        public void bindText(String str, String str2) {
            this.mOriginText = str;
            this.mPattern = str2;
        }

        public SpannableString convertText2Span() throws IllegalStateException {
            if (TextUtils.isEmpty(this.mOriginText) || TextUtils.isEmpty(this.mPattern)) {
                throw new IllegalStateException("format text and pattern not specified!");
            } else if (this.mOriginText.length() != this.mPattern.length()) {
                return SpannableString.valueOf(this.mOriginText);
            } else {
                return doConvert();
            }
        }
    }

    static class PatternItem {
        public int lastIndex;
        public char patternLetter;
        public int startIndex;

        PatternItem() {
        }

        public String toString() {
            return String.format("%s start: %d, end: %d", new Object[]{Character.valueOf(this.patternLetter), Integer.valueOf(this.startIndex), Integer.valueOf(this.lastIndex)});
        }
    }
}

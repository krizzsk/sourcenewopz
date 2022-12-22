package com.didi.beatles.p099im.access.card;

import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.card.HighlightHelper */
public class HighlightHelper {
    public static SpannableString processIMHighlight(String str) {
        HighlightTexts a = m5823a(str);
        int processIMHighlightColor = processIMHighlightColor();
        SpannableString spannableString = new SpannableString(a.text);
        if (a.ranges != null && a.ranges.size() > 0) {
            for (HighlightTexts.Range next : a.ranges) {
                spannableString.setSpan(new ForegroundColorSpan(processIMHighlightColor), next.from, next.f8717to, 17);
            }
        }
        return spannableString;
    }

    public static SpannableString processHighlight(String str) {
        HighlightTexts a = m5823a(str);
        int processIMHighlightColor = processIMHighlightColor();
        SpannableString spannableString = new SpannableString(a.text);
        if (a.ranges != null && a.ranges.size() > 0) {
            for (HighlightTexts.Range next : a.ranges) {
                spannableString.setSpan(new ForegroundColorSpan(processIMHighlightColor), next.from, next.f8717to, 17);
            }
        }
        return spannableString;
    }

    public static SpannableString processHighlight(String str, ClickableSpan clickableSpan) {
        HighlightTexts a = m5823a(str);
        int processIMHighlightColor = processIMHighlightColor();
        SpannableString spannableString = new SpannableString(a.text);
        if (!(a.ranges == null || a.ranges.size() == 0)) {
            for (HighlightTexts.Range next : a.ranges) {
                spannableString.setSpan(new ForegroundColorSpan(processIMHighlightColor), next.from, next.f8717to, 17);
            }
            if (clickableSpan != null) {
                spannableString.setSpan(clickableSpan, a.ranges.get(0).from, a.ranges.get(0).f8717to, 33);
            }
        }
        return spannableString;
    }

    public static int processIMHighlightColor() {
        int color = IMResource.getColor(R.color.im_color_nomix_orange);
        return R.color.im_color_nomix_orange == color ? IMResource.getColor(R.color.im_nomix_orange) : color;
    }

    /* renamed from: a */
    private static HighlightTexts m5823a(String str) {
        HighlightTexts highlightTexts = new HighlightTexts();
        StringBuffer stringBuffer = new StringBuffer(str);
        ArrayList arrayList = new ArrayList();
        while (stringBuffer.indexOf("<H>") != -1 && stringBuffer.indexOf("</H>") != -1) {
            int indexOf = stringBuffer.indexOf("<H>");
            int indexOf2 = stringBuffer.indexOf("</H>");
            if (indexOf >= 0 && indexOf2 >= 0) {
                stringBuffer.delete(indexOf2, indexOf2 + 4);
                stringBuffer.delete(indexOf, indexOf + 3);
                HighlightTexts.Range range = new HighlightTexts.Range();
                range.from = indexOf;
                range.f8717to = indexOf2 - 3;
                arrayList.add(range);
            }
        }
        highlightTexts.ranges = arrayList;
        highlightTexts.text = stringBuffer.toString();
        return highlightTexts;
    }

    /* renamed from: com.didi.beatles.im.access.card.HighlightHelper$HighlightTexts */
    private static class HighlightTexts {
        List<Range> ranges;
        String text;

        private HighlightTexts() {
        }

        /* renamed from: com.didi.beatles.im.access.card.HighlightHelper$HighlightTexts$Range */
        static class Range {
            int from;

            /* renamed from: to */
            int f8717to;

            Range() {
            }
        }
    }
}

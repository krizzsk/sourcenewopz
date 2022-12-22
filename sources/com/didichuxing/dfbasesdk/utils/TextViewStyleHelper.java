package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.push.ServerParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

public class TextViewStyleHelper {

    /* renamed from: a */
    private static final int f46750a = 33;

    /* renamed from: b */
    private String f46751b;

    /* renamed from: c */
    private ArrayList<Range> f46752c = new ArrayList<>();

    /* renamed from: d */
    private Context f46753d;

    /* renamed from: e */
    private SpannableStringBuilder f46754e;

    private TextViewStyleHelper(Context context, String str) {
        this.f46753d = context;
        this.f46751b = str;
        this.f46754e = new SpannableStringBuilder(str);
    }

    public static TextViewStyleHelper with(Context context, String str) {
        return new TextViewStyleHelper(context, str);
    }

    public TextViewStyleHelper first(String str) {
        this.f46752c.clear();
        int indexOf = this.f46751b.indexOf(str);
        Range create = Range.create(indexOf, str.length() + indexOf);
        if (m33578a(ServerParam.PARAM_FIRST, create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper last(String str) {
        this.f46752c.clear();
        int lastIndexOf = this.f46751b.lastIndexOf(str);
        Range create = Range.create(lastIndexOf, str.length() + lastIndexOf);
        if (m33578a("last", create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper every(String str) {
        return every(str, true);
    }

    public TextViewStyleHelper every(String str, boolean z) {
        if (z) {
            this.f46752c.clear();
        }
        int indexOf = this.f46751b.indexOf(str);
        while (indexOf >= 0) {
            Range create = Range.create(indexOf, str.length() + indexOf);
            if (m33578a("every", create)) {
                this.f46752c.add(create);
            }
            indexOf = this.f46751b.indexOf(str, indexOf + 1);
        }
        return this;
    }

    public TextViewStyleHelper append(String str) {
        int length = this.f46751b.length();
        this.f46751b = this.f46751b.concat(str);
        this.f46754e.append(str);
        this.f46752c.clear();
        Range create = Range.create(length, str.length() + length);
        if (m33578a(AgentOptions.APPEND, create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper all() {
        this.f46752c.clear();
        Range create = Range.create(0, this.f46751b.length());
        if (m33578a("all", create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper range(int i, int i2) {
        this.f46752c.clear();
        Range create = Range.create(i, i2);
        if (m33578a("range", create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper ranges(List<Range> list) {
        this.f46752c.clear();
        for (Range next : list) {
            if (m33578a("ranges", next)) {
                this.f46752c.add(next);
            }
        }
        return this;
    }

    public TextViewStyleHelper between(String str, String str2) {
        this.f46752c.clear();
        Range create = Range.create(this.f46751b.indexOf(str) + str.length(), this.f46751b.lastIndexOf(str2));
        if (m33578a("between", create)) {
            this.f46752c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper size(int i) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new AbsoluteSizeSpan(i, true), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper scaleSize(int i) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new RelativeSizeSpan((float) i), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper bold() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new StyleSpan(1), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper italic() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new StyleSpan(2), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper font(String str) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new TypefaceSpan(str), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper strikethrough() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new StrikethroughSpan(), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper underline() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new UnderlineSpan(), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper background(int i) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new BackgroundColorSpan(i), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper textColor(int i) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new ForegroundColorSpan(i), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper subscript() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new SubscriptSpan(), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper superscript() {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new SuperscriptSpan(), next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper url(String str) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, next.from, next.f46755to, 33);
        }
        return this;
    }

    public TextViewStyleHelper onClick(final View.OnClickListener onClickListener) {
        Iterator<Range> it = this.f46752c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f46754e.setSpan(new ClickableSpan() {
                public void updateDrawState(TextPaint textPaint) {
                }

                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    onClickListener.onClick(view);
                }
            }, next.from, next.f46755to, 33);
        }
        return this;
    }

    public void into(TextView textView) {
        if (textView != null) {
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f46754e);
        }
    }

    /* renamed from: a */
    private boolean m33578a(String str, Range range) {
        int length = this.f46751b.length();
        if (range.f46755to <= length) {
            return true;
        }
        CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException(str + " (" + range.from + " ... " + range.f46755to + ") ends beyond length " + length));
        return false;
    }

    public static class Range {
        public final int from;

        /* renamed from: to */
        public final int f46755to;

        private Range(int i, int i2) {
            if (i < 0 || i2 < 0) {
                CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException("(" + i + " ... " + i2 + ") starts before 0"));
                this.f46755to = 0;
                this.from = 0;
            } else if (i2 < i) {
                CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException("(" + i + " ... " + i2 + ") has end before start"));
                this.f46755to = 0;
                this.from = 0;
            } else {
                this.from = i;
                this.f46755to = i2;
            }
        }

        public static Range create(int i, int i2) {
            return new Range(i, i2);
        }
    }
}

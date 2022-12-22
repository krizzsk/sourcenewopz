package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

public abstract class AbstractDecorator {

    /* renamed from: a */
    private String f4121a;

    /* renamed from: b */
    private Object f4122b;

    /* renamed from: c */
    private String f4123c;

    /* renamed from: d */
    private String f4124d;

    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        if (getMatchingValue() != null && !getMatchingValue().equals(obj)) {
            return true;
        }
        if (getReplacementTag() != null) {
            str = getReplacementTag();
        }
        dDSpanContext.setTag(str, getReplacementValue() == null ? String.valueOf(obj) : getReplacementValue());
        return false;
    }

    public String getMatchingTag() {
        return this.f4121a;
    }

    public void setMatchingTag(String str) {
        this.f4121a = str;
    }

    public Object getMatchingValue() {
        return this.f4122b;
    }

    public void setMatchingValue(Object obj) {
        this.f4122b = obj;
    }

    public String getReplacementTag() {
        return this.f4123c;
    }

    public void setReplacementTag(String str) {
        this.f4123c = str;
    }

    public String getReplacementValue() {
        return this.f4124d;
    }

    public void setReplacementValue(String str) {
        this.f4124d = str;
    }
}

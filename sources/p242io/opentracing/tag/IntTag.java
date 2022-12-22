package p242io.opentracing.tag;

import p242io.opentracing.Span;

/* renamed from: io.opentracing.tag.IntTag */
public class IntTag extends AbstractTag<Integer> {
    public IntTag(String str) {
        super(str);
    }

    public void set(Span span, Integer num) {
        span.setTag(this.key, (Number) num);
    }
}

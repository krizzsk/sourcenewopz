package p242io.opentracing.tag;

import p242io.opentracing.Span;

/* renamed from: io.opentracing.tag.Tag */
public interface Tag<T> {
    String getKey();

    void set(Span span, T t);
}

package com.datadog.opentracing.propagation;

import com.datadog.opentracing.DDSpanContext;
import com.datadog.opentracing.propagation.HttpCodec;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p242io.opentracing.SpanContext;
import p242io.opentracing.propagation.TextMapExtract;
import p242io.opentracing.propagation.TextMapInject;

public class HaystackHttpCodec {

    /* renamed from: a */
    private static final String f4142a = "Baggage-";

    /* renamed from: b */
    private static final String f4143b = "Trace-ID";

    /* renamed from: c */
    private static final String f4144c = "Span-ID";

    /* renamed from: d */
    private static final String f4145d = "Parent_ID";

    private HaystackHttpCodec() {
    }

    public static class Injector implements HttpCodec.Injector {
        public void inject(DDSpanContext dDSpanContext, TextMapInject textMapInject) {
            textMapInject.put(HaystackHttpCodec.f4143b, dDSpanContext.getTraceId().toString());
            textMapInject.put(HaystackHttpCodec.f4144c, dDSpanContext.getSpanId().toString());
            textMapInject.put(HaystackHttpCodec.f4145d, dDSpanContext.getParentId().toString());
            for (Map.Entry next : dDSpanContext.baggageItems()) {
                textMapInject.put(HaystackHttpCodec.f4142a + ((String) next.getKey()), HttpCodec.m2565a((String) next.getValue()));
            }
        }
    }

    public static class Extractor implements HttpCodec.Extractor {
        private final Map<String, String> taggedHeaders = new HashMap();

        public Extractor(Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                this.taggedHeaders.put(((String) next.getKey()).trim().toLowerCase(Locale.US), (String) next.getValue());
            }
        }

        public SpanContext extract(TextMapExtract textMapExtract) {
            try {
                Map emptyMap = Collections.emptyMap();
                Map emptyMap2 = Collections.emptyMap();
                BigInteger bigInteger = BigInteger.ZERO;
                BigInteger bigInteger2 = BigInteger.ZERO;
                Map map = emptyMap;
                Map map2 = emptyMap2;
                BigInteger bigInteger3 = bigInteger;
                BigInteger bigInteger4 = bigInteger2;
                for (Map.Entry next : textMapExtract) {
                    String lowerCase = ((String) next.getKey()).toLowerCase(Locale.US);
                    String str = (String) next.getValue();
                    if (str != null) {
                        if (HaystackHttpCodec.f4143b.equalsIgnoreCase(lowerCase)) {
                            bigInteger3 = HttpCodec.m2566a(str, 10);
                        } else if (HaystackHttpCodec.f4144c.equalsIgnoreCase(lowerCase)) {
                            bigInteger4 = HttpCodec.m2566a(str, 10);
                        } else if (lowerCase.startsWith(HaystackHttpCodec.f4142a.toLowerCase(Locale.US))) {
                            if (map.isEmpty()) {
                                map = new HashMap();
                            }
                            map.put(lowerCase.replace(HaystackHttpCodec.f4142a.toLowerCase(Locale.US), ""), HttpCodec.m2567b(str));
                        }
                        if (this.taggedHeaders.containsKey(lowerCase)) {
                            if (map2.isEmpty()) {
                                map2 = new HashMap();
                            }
                            map2.put(this.taggedHeaders.get(lowerCase), HttpCodec.m2567b(str));
                        }
                    }
                }
                if (!BigInteger.ZERO.equals(bigInteger3)) {
                    ExtractedContext extractedContext = new ExtractedContext(bigInteger3, bigInteger4, 1, (String) null, map, map2);
                    extractedContext.lockSamplingPriority();
                    return extractedContext;
                }
                if (!map2.isEmpty()) {
                    return new TagContext((String) null, map2);
                }
                return null;
            } catch (RuntimeException unused) {
            }
        }
    }
}

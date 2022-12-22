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

class DatadogHttpCodec {

    /* renamed from: a */
    private static final String f4132a = "ot-baggage-";

    /* renamed from: b */
    private static final String f4133b = "x-datadog-trace-id";

    /* renamed from: c */
    private static final String f4134c = "x-datadog-parent-id";

    /* renamed from: d */
    private static final String f4135d = "x-datadog-sampling-priority";

    /* renamed from: e */
    private static final String f4136e = "x-datadog-origin";

    private DatadogHttpCodec() {
    }

    public static class Injector implements HttpCodec.Injector {
        public void inject(DDSpanContext dDSpanContext, TextMapInject textMapInject) {
            textMapInject.put(DatadogHttpCodec.f4133b, dDSpanContext.getTraceId().toString());
            textMapInject.put(DatadogHttpCodec.f4134c, dDSpanContext.getSpanId().toString());
            if (dDSpanContext.lockSamplingPriority()) {
                textMapInject.put(DatadogHttpCodec.f4135d, String.valueOf(dDSpanContext.getSamplingPriority()));
            }
            String origin = dDSpanContext.getOrigin();
            if (origin != null) {
                textMapInject.put(DatadogHttpCodec.f4136e, origin);
            }
            for (Map.Entry next : dDSpanContext.baggageItems()) {
                textMapInject.put(DatadogHttpCodec.f4132a + ((String) next.getKey()), HttpCodec.m2565a((String) next.getValue()));
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
                String str = null;
                Map map = emptyMap;
                Map map2 = emptyMap2;
                BigInteger bigInteger3 = bigInteger;
                BigInteger bigInteger4 = bigInteger2;
                int i = Integer.MIN_VALUE;
                for (Map.Entry next : textMapExtract) {
                    String lowerCase = ((String) next.getKey()).toLowerCase(Locale.US);
                    String str2 = (String) next.getValue();
                    if (str2 != null) {
                        if (DatadogHttpCodec.f4133b.equalsIgnoreCase(lowerCase)) {
                            bigInteger3 = HttpCodec.m2566a(str2, 10);
                        } else if (DatadogHttpCodec.f4134c.equalsIgnoreCase(lowerCase)) {
                            bigInteger4 = HttpCodec.m2566a(str2, 10);
                        } else if (DatadogHttpCodec.f4135d.equalsIgnoreCase(lowerCase)) {
                            i = Integer.parseInt(str2);
                        } else if (DatadogHttpCodec.f4136e.equalsIgnoreCase(lowerCase)) {
                            str = str2;
                        } else if (lowerCase.startsWith(DatadogHttpCodec.f4132a)) {
                            if (map.isEmpty()) {
                                map = new HashMap();
                            }
                            map.put(lowerCase.replace(DatadogHttpCodec.f4132a, ""), HttpCodec.m2567b(str2));
                        }
                        if (this.taggedHeaders.containsKey(lowerCase)) {
                            if (map2.isEmpty()) {
                                map2 = new HashMap();
                            }
                            map2.put(this.taggedHeaders.get(lowerCase), HttpCodec.m2567b(str2));
                        }
                    }
                }
                if (!BigInteger.ZERO.equals(bigInteger3)) {
                    ExtractedContext extractedContext = new ExtractedContext(bigInteger3, bigInteger4, i, str, map, map2);
                    extractedContext.lockSamplingPriority();
                    return extractedContext;
                }
                if (str != null || !map2.isEmpty()) {
                    return new TagContext(str, map2);
                }
                return null;
            } catch (RuntimeException unused) {
            }
        }
    }
}

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

class B3HttpCodec {

    /* renamed from: a */
    private static final String f4126a = "X-B3-TraceId";

    /* renamed from: b */
    private static final String f4127b = "X-B3-SpanId";

    /* renamed from: c */
    private static final String f4128c = "X-B3-Sampled";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f4129d = String.valueOf(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f4130e = String.valueOf(0);

    /* renamed from: f */
    private static final int f4131f = 16;

    private B3HttpCodec() {
    }

    public static class Injector implements HttpCodec.Injector {
        public void inject(DDSpanContext dDSpanContext, TextMapInject textMapInject) {
            try {
                textMapInject.put(B3HttpCodec.f4126a, dDSpanContext.getTraceId().toString(16).toLowerCase(Locale.US));
                textMapInject.put(B3HttpCodec.f4127b, dDSpanContext.getSpanId().toString(16).toLowerCase(Locale.US));
                if (dDSpanContext.lockSamplingPriority()) {
                    textMapInject.put(B3HttpCodec.f4128c, convertSamplingPriority(dDSpanContext.getSamplingPriority()));
                }
            } catch (NumberFormatException unused) {
            }
        }

        private String convertSamplingPriority(int i) {
            return i > 0 ? B3HttpCodec.f4129d : B3HttpCodec.f4130e;
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
                BigInteger bigInteger = BigInteger.ZERO;
                BigInteger bigInteger2 = BigInteger.ZERO;
                Map map = emptyMap;
                BigInteger bigInteger3 = bigInteger;
                BigInteger bigInteger4 = bigInteger2;
                int i = Integer.MIN_VALUE;
                for (Map.Entry next : textMapExtract) {
                    String lowerCase = ((String) next.getKey()).toLowerCase(Locale.US);
                    String str = (String) next.getValue();
                    if (str != null) {
                        if (B3HttpCodec.f4126a.equalsIgnoreCase(lowerCase)) {
                            int length = str.length();
                            if (length > 32) {
                                bigInteger3 = BigInteger.ZERO;
                            } else {
                                bigInteger3 = HttpCodec.m2566a(length > 16 ? str.substring(length - 16) : str, 16);
                            }
                        } else if (B3HttpCodec.f4127b.equalsIgnoreCase(lowerCase)) {
                            bigInteger4 = HttpCodec.m2566a(str, 16);
                        } else if (B3HttpCodec.f4128c.equalsIgnoreCase(lowerCase)) {
                            i = convertSamplingPriority(str);
                        }
                        if (this.taggedHeaders.containsKey(lowerCase)) {
                            if (map.isEmpty()) {
                                map = new HashMap();
                            }
                            map.put(this.taggedHeaders.get(lowerCase), HttpCodec.m2567b(str));
                        }
                    }
                }
                if (!BigInteger.ZERO.equals(bigInteger3)) {
                    ExtractedContext extractedContext = new ExtractedContext(bigInteger3, bigInteger4, i, (String) null, Collections.emptyMap(), map);
                    extractedContext.lockSamplingPriority();
                    return extractedContext;
                }
                if (!map.isEmpty()) {
                    return new TagContext((String) null, map);
                }
                return null;
            } catch (RuntimeException unused) {
            }
        }

        private int convertSamplingPriority(String str) {
            return Integer.parseInt(str) == 1 ? 1 : 0;
        }
    }
}

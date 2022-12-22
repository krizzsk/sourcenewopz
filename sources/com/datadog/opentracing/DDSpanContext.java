package com.datadog.opentracing;

import com.datadog.trace.api.DDTags;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import p242io.opentracing.SpanContext;

public class DDSpanContext implements SpanContext {
    public static final String ORIGIN_KEY = "_dd.origin";
    public static final String PRIORITY_SAMPLING_KEY = "_sampling_priority_v1";
    public static final String SAMPLE_RATE_KEY = "_sample_rate";

    /* renamed from: a */
    static final /* synthetic */ boolean f4086a = (!DDSpanContext.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final Map<String, Number> f4087b = Collections.emptyMap();

    /* renamed from: c */
    private final DDTracer f4088c;

    /* renamed from: d */
    private final PendingTrace f4089d;

    /* renamed from: e */
    private final Map<String, String> f4090e;

    /* renamed from: f */
    private final BigInteger f4091f;

    /* renamed from: g */
    private final BigInteger f4092g;

    /* renamed from: h */
    private final BigInteger f4093h;

    /* renamed from: i */
    private final Map<String, Object> f4094i = new ConcurrentHashMap();

    /* renamed from: j */
    private volatile String f4095j;

    /* renamed from: k */
    private volatile String f4096k;

    /* renamed from: l */
    private volatile String f4097l;

    /* renamed from: m */
    private volatile String f4098m;

    /* renamed from: n */
    private volatile boolean f4099n;

    /* renamed from: o */
    private boolean f4100o = false;

    /* renamed from: p */
    private final String f4101p;

    /* renamed from: q */
    private final AtomicReference<Map<String, Number>> f4102q = new AtomicReference<>();

    /* renamed from: r */
    private final String f4103r = Thread.currentThread().getName();

    /* renamed from: s */
    private final long f4104s = Thread.currentThread().getId();

    /* renamed from: t */
    private final Map<String, String> f4105t;

    public DDSpanContext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str, String str2, String str3, int i, String str4, Map<String, String> map, boolean z, String str5, Map<String, Object> map2, PendingTrace pendingTrace, DDTracer dDTracer, Map<String, String> map3) {
        BigInteger bigInteger4 = bigInteger;
        BigInteger bigInteger5 = bigInteger2;
        BigInteger bigInteger6 = bigInteger3;
        int i2 = i;
        String str6 = str4;
        Map<String, String> map4 = map;
        Map<String, Object> map5 = map2;
        PendingTrace pendingTrace2 = pendingTrace;
        DDTracer dDTracer2 = dDTracer;
        if (!f4086a && dDTracer2 == null) {
            throw new AssertionError();
        } else if (f4086a || pendingTrace2 != null) {
            this.f4088c = dDTracer2;
            this.f4089d = pendingTrace2;
            if (!f4086a && bigInteger4 == null) {
                throw new AssertionError();
            } else if (!f4086a && bigInteger5 == null) {
                throw new AssertionError();
            } else if (f4086a || bigInteger6 != null) {
                this.f4091f = bigInteger4;
                this.f4092g = bigInteger5;
                this.f4093h = bigInteger6;
                if (map4 == null) {
                    this.f4090e = new ConcurrentHashMap(0);
                } else {
                    this.f4090e = new ConcurrentHashMap(map4);
                }
                if (map5 != null) {
                    this.f4094i.putAll(map5);
                }
                this.f4105t = map3;
                setServiceName(str);
                this.f4097l = str2;
                this.f4096k = str3;
                this.f4099n = z;
                this.f4098m = str5;
                this.f4101p = str6;
                if (i2 != Integer.MIN_VALUE) {
                    setSamplingPriority(i2);
                }
                if (str6 != null) {
                    this.f4094i.put(ORIGIN_KEY, str6);
                }
                this.f4094i.put(DDTags.THREAD_NAME, this.f4103r);
                this.f4094i.put(DDTags.THREAD_ID, Long.valueOf(this.f4104s));
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public BigInteger getTraceId() {
        return this.f4091f;
    }

    public String toTraceId() {
        return this.f4091f.toString();
    }

    public BigInteger getParentId() {
        return this.f4093h;
    }

    public BigInteger getSpanId() {
        return this.f4092g;
    }

    public String toSpanId() {
        return this.f4092g.toString();
    }

    public String getServiceName() {
        return this.f4095j;
    }

    public void setServiceName(String str) {
        if (this.f4105t.containsKey(str)) {
            this.f4095j = this.f4105t.get(str);
        } else {
            this.f4095j = str;
        }
    }

    public String getResourceName() {
        return isResourceNameSet() ? this.f4096k : this.f4097l;
    }

    public boolean isResourceNameSet() {
        return this.f4096k != null && !this.f4096k.isEmpty();
    }

    public boolean hasResourceName() {
        return isResourceNameSet() || this.f4094i.containsKey(DDTags.RESOURCE_NAME);
    }

    public void setResourceName(String str) {
        this.f4096k = str;
    }

    public String getOperationName() {
        return this.f4097l;
    }

    public void setOperationName(String str) {
        this.f4097l = str;
    }

    public boolean getErrorFlag() {
        return this.f4099n;
    }

    public void setErrorFlag(boolean z) {
        this.f4099n = z;
    }

    public String getSpanType() {
        return this.f4098m;
    }

    public void setSpanType(String str) {
        this.f4098m = str;
    }

    public boolean setSamplingPriority(int i) {
        DDSpan rootSpan;
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        PendingTrace pendingTrace = this.f4089d;
        if (pendingTrace != null && (rootSpan = pendingTrace.getRootSpan()) != null && rootSpan.context() != this) {
            return rootSpan.context().setSamplingPriority(i);
        }
        synchronized (this) {
            if (this.f4100o) {
                return false;
            }
            setMetric(PRIORITY_SAMPLING_KEY, Integer.valueOf(i));
            return true;
        }
    }

    public int getSamplingPriority() {
        DDSpan rootSpan = this.f4089d.getRootSpan();
        if (rootSpan != null && rootSpan.context() != this) {
            return rootSpan.context().getSamplingPriority();
        }
        Number number = getMetrics().get(PRIORITY_SAMPLING_KEY);
        if (number == null) {
            return Integer.MIN_VALUE;
        }
        return number.intValue();
    }

    public boolean lockSamplingPriority() {
        boolean z;
        DDSpan rootSpan = this.f4089d.getRootSpan();
        if (rootSpan != null && rootSpan.context() != this) {
            return rootSpan.context().lockSamplingPriority();
        }
        synchronized (this) {
            if (getMetrics().get(PRIORITY_SAMPLING_KEY) != null) {
                if (!this.f4100o) {
                    this.f4100o = true;
                }
            }
            z = this.f4100o;
        }
        return z;
    }

    public String getOrigin() {
        DDSpan rootSpan = this.f4089d.getRootSpan();
        if (rootSpan != null) {
            return rootSpan.context().f4101p;
        }
        return this.f4101p;
    }

    public void setBaggageItem(String str, String str2) {
        this.f4090e.put(str, str2);
    }

    public String getBaggageItem(String str) {
        return this.f4090e.get(str);
    }

    public Map<String, String> getBaggageItems() {
        return this.f4090e;
    }

    public Iterable<Map.Entry<String, String>> baggageItems() {
        return this.f4090e.entrySet();
    }

    public PendingTrace getTrace() {
        return this.f4089d;
    }

    @Deprecated
    public DDTracer getTracer() {
        return this.f4088c;
    }

    public Map<String, Number> getMetrics() {
        Map<String, Number> map = this.f4102q.get();
        return map == null ? f4087b : map;
    }

    public void setMetric(String str, Number number) {
        if (this.f4102q.get() == null) {
            this.f4102q.compareAndSet((Object) null, new ConcurrentHashMap());
        }
        if (number instanceof Float) {
            this.f4102q.get().put(str, Double.valueOf(number.doubleValue()));
        } else {
            this.f4102q.get().put(str, number);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setTag(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 == 0) goto L_0x0039
            boolean r0 = r5 instanceof java.lang.String     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0011
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0040 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0011
            goto L_0x0039
        L_0x0011:
            r0 = 1
            com.datadog.opentracing.DDTracer r1 = r3.f4088c     // Catch:{ all -> 0x0040 }
            java.util.List r1 = r1.getSpanContextDecorators(r4)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0030
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0040 }
        L_0x001e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0040 }
            com.datadog.opentracing.decorators.AbstractDecorator r2 = (com.datadog.opentracing.decorators.AbstractDecorator) r2     // Catch:{ all -> 0x0040 }
            boolean r2 = r2.shouldSetTag(r3, r4, r5)     // Catch:{ all -> 0x001e }
            r0 = r0 & r2
            goto L_0x001e
        L_0x0030:
            if (r0 == 0) goto L_0x0037
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.f4094i     // Catch:{ all -> 0x0040 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0040 }
        L_0x0037:
            monitor-exit(r3)
            return
        L_0x0039:
            java.util.Map<java.lang.String, java.lang.Object> r5 = r3.f4094i     // Catch:{ all -> 0x0040 }
            r5.remove(r4)     // Catch:{ all -> 0x0040 }
            monitor-exit(r3)
            return
        L_0x0040:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.opentracing.DDSpanContext.setTag(java.lang.String, java.lang.Object):void");
    }

    public synchronized Map<String, Object> getTags() {
        return Collections.unmodifiableMap(this.f4094i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DDSpan [ t_id=");
        sb.append(this.f4091f);
        sb.append(", s_id=");
        sb.append(this.f4092g);
        sb.append(", p_id=");
        sb.append(this.f4093h);
        sb.append("] trace=");
        sb.append(getServiceName());
        sb.append("/");
        sb.append(getOperationName());
        sb.append("/");
        sb.append(getResourceName());
        sb.append(" metrics=");
        sb.append(new TreeMap(getMetrics()));
        if (this.f4099n) {
            sb.append(" *errored*");
        }
        sb.append(" tags=");
        sb.append(new TreeMap(this.f4094i));
        return sb.toString();
    }
}

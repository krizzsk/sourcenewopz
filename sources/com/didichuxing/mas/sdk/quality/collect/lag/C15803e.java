package com.didichuxing.mas.sdk.quality.collect.lag;

import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.e */
/* compiled from: StackSampler */
class C15803e extends C15799a {

    /* renamed from: c */
    private static final int f48138c = 100;

    /* renamed from: d */
    private static final LinkedHashMap<Long, String> f48139d = new LinkedHashMap<>();

    /* renamed from: e */
    private int f48140e;

    /* renamed from: f */
    private Thread f48141f;

    public C15803e(Thread thread, long j) {
        this(thread, 100, j);
    }

    public C15803e(Thread thread, int i, long j) {
        super(j);
        this.f48140e = 100;
        this.f48141f = thread;
        this.f48140e = i;
    }

    /* renamed from: a */
    public ArrayList<String> mo118410a(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f48139d) {
            for (Long next : f48139d.keySet()) {
                if (j < next.longValue() && next.longValue() < j2) {
                    arrayList.add(BlockInfo.TIME_FORMATTER.format(next) + "\r\n" + "\r\n" + f48139d.get(next));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo118406c() {
        StringBuilder sb = new StringBuilder(2048);
        try {
            for (StackTraceElement stackTraceElement : this.f48141f.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\r\n");
            }
            synchronized (f48139d) {
                if (f48139d.size() == this.f48140e && this.f48140e > 0) {
                    f48139d.remove(f48139d.keySet().iterator().next());
                }
                f48139d.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
            }
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
        }
    }
}

package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.tracing;

import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.MetricCategory;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.C15787Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Trace {

    /* renamed from: a */
    private static final String f48049a = "category";

    /* renamed from: b */
    private static final AgentLog f48050b = AgentLogManager.getAgentLog();

    /* renamed from: c */
    private volatile Map<String, Object> f48051c;
    public long childExclusiveTime;

    /* renamed from: d */
    private List<String> f48052d;
    public String displayName;

    /* renamed from: e */
    private volatile Set<UUID> f48053e;
    public long entryTimestamp;
    public long exclusiveTime;
    public long exitTimestamp;

    /* renamed from: f */
    private TraceType f48054f;

    /* renamed from: g */
    private boolean f48055g;
    public String metricBackgroundName;
    public String metricName;
    public final UUID myUUID;
    public final UUID parentUUID;
    public String scope;
    public long threadId;
    public String threadName;
    public TraceMachine traceMachine;

    public Trace() {
        this.myUUID = new UUID(C15787Util.getRandom().nextLong(), C15787Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.f48054f = TraceType.TRACE;
        this.f48055g = false;
        this.parentUUID = null;
    }

    public Trace(String str, UUID uuid, TraceMachine traceMachine2) {
        this.myUUID = new UUID(C15787Util.getRandom().nextLong(), C15787Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.f48054f = TraceType.TRACE;
        this.f48055g = false;
        this.displayName = str;
        this.parentUUID = uuid;
        this.traceMachine = traceMachine2;
    }

    public void addChild(Trace trace) {
        if (this.f48053e == null) {
            synchronized (this) {
                if (this.f48053e == null) {
                    this.f48053e = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        this.f48053e.add(trace.myUUID);
    }

    public Set<UUID> getChildren() {
        if (this.f48053e == null) {
            synchronized (this) {
                if (this.f48053e == null) {
                    this.f48053e = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        return this.f48053e;
    }

    public Map<String, Object> getParams() {
        if (this.f48051c == null) {
            synchronized (this) {
                if (this.f48051c == null) {
                    this.f48051c = new ConcurrentHashMap();
                }
            }
        }
        return this.f48051c;
    }

    public void setAnnotationParams(List<String> list) {
        this.f48052d = list;
    }

    public Map<String, Object> getAnnotationParams() {
        HashMap hashMap = new HashMap();
        List<String> list = this.f48052d;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.f48052d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object a = m34278a(next, it.next(), it.next());
                if (a != null) {
                    hashMap.put(next, a);
                }
            }
        }
        return hashMap;
    }

    public boolean isComplete() {
        return this.f48055g;
    }

    public void complete() throws TracingInactiveException {
        if (this.f48055g) {
            AgentLog agentLog = f48050b;
            agentLog.warning("Attempted to double complete trace " + this.myUUID.toString());
            return;
        }
        if (this.exitTimestamp == 0) {
            this.exitTimestamp = System.currentTimeMillis();
        }
        this.exclusiveTime = getDuration() - this.childExclusiveTime;
        this.f48055g = true;
        try {
            this.traceMachine.storeCompletedTrace(this);
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public void prepareForSerialization() {
        getParams().put("type", this.f48054f.toString());
    }

    public TraceType getType() {
        return this.f48054f;
    }

    public void setType(TraceType traceType) {
        this.f48054f = traceType;
    }

    public long getDuration() {
        return this.exitTimestamp - this.entryTimestamp;
    }

    public MetricCategory getCategory() {
        if (!getAnnotationParams().containsKey(f48049a)) {
            return null;
        }
        Object obj = getAnnotationParams().get(f48049a);
        if (obj instanceof MetricCategory) {
            return (MetricCategory) obj;
        }
        f48050b.error("Category annotation parameter is not of type MetricCategory");
        return null;
    }

    /* renamed from: a */
    private static Object m34278a(String str, String str2, String str3) {
        try {
            Class<?> cls = Class.forName(str2);
            if (MetricCategory.class == cls) {
                return MetricCategory.valueOf(str3);
            }
            if (String.class == cls) {
                return str3;
            }
            return null;
        } catch (ClassNotFoundException e) {
            AgentLog agentLog = f48050b;
            agentLog.error("Unable to resolve parameter class in enterMethod: " + e.getMessage(), e);
            return null;
        }
    }
}

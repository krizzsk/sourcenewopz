package com.didichuxing.ditest.agent.android.tracing;

import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didichuxing.ditest.agent.android.instrumentation.MetricCategory;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.util.C15538Util;
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
    private static final String CATEGORY_PARAMETER = "category";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    public long childExclusiveTime;
    private volatile Set<UUID> children;
    public String displayName;
    public long entryTimestamp;
    public long exclusiveTime;
    public long exitTimestamp;
    private boolean isComplete;
    public String metricBackgroundName;
    public String metricName;
    public final UUID myUUID;
    private volatile Map<String, Object> params;
    public final UUID parentUUID;
    private List<String> rawAnnotationParams;
    public String scope;
    public long threadId;
    public String threadName;
    public TraceMachine traceMachine;
    private TraceType type;

    public Trace() {
        this.myUUID = new UUID(C15538Util.getRandom().nextLong(), C15538Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.type = TraceType.TRACE;
        this.isComplete = false;
        this.parentUUID = null;
    }

    public Trace(String str, UUID uuid, TraceMachine traceMachine2) {
        this.myUUID = new UUID(C15538Util.getRandom().nextLong(), C15538Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.type = TraceType.TRACE;
        this.isComplete = false;
        this.displayName = str;
        this.parentUUID = uuid;
        this.traceMachine = traceMachine2;
    }

    public void addChild(Trace trace) {
        if (this.children == null) {
            synchronized (this) {
                if (this.children == null) {
                    this.children = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        this.children.add(trace.myUUID);
    }

    public Set<UUID> getChildren() {
        if (this.children == null) {
            synchronized (this) {
                if (this.children == null) {
                    this.children = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        return this.children;
    }

    public Map<String, Object> getParams() {
        if (this.params == null) {
            synchronized (this) {
                if (this.params == null) {
                    this.params = new ConcurrentHashMap();
                }
            }
        }
        return this.params;
    }

    public void setAnnotationParams(List<String> list) {
        this.rawAnnotationParams = list;
    }

    public Map<String, Object> getAnnotationParams() {
        HashMap hashMap = new HashMap();
        List<String> list = this.rawAnnotationParams;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.rawAnnotationParams.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object createParameter = createParameter(next, it.next(), it.next());
                if (createParameter != null) {
                    hashMap.put(next, createParameter);
                }
            }
        }
        return hashMap;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void complete() throws TracingInactiveException {
        if (this.isComplete) {
            AgentLog agentLog = log;
            agentLog.warning("Attempted to double complete trace " + this.myUUID.toString());
            return;
        }
        if (this.exitTimestamp == 0) {
            this.exitTimestamp = System.currentTimeMillis();
        }
        this.exclusiveTime = getDuration() - this.childExclusiveTime;
        this.isComplete = true;
        try {
            this.traceMachine.storeCompletedTrace(this);
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public void prepareForSerialization() {
        getParams().put("type", this.type.toString());
    }

    public TraceType getType() {
        return this.type;
    }

    public void setType(TraceType traceType) {
        this.type = traceType;
    }

    public long getDuration() {
        return this.exitTimestamp - this.entryTimestamp;
    }

    public MetricCategory getCategory() {
        if (!getAnnotationParams().containsKey(CATEGORY_PARAMETER)) {
            return null;
        }
        Object obj = getAnnotationParams().get(CATEGORY_PARAMETER);
        if (obj instanceof MetricCategory) {
            return (MetricCategory) obj;
        }
        log.error("Category annotation parameter is not of type MetricCategory");
        return null;
    }

    private static Object createParameter(String str, String str2, String str3) {
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
            AgentLog agentLog = log;
            agentLog.error("Unable to resolve parameter class in enterMethod: " + e.getMessage(), e);
            return null;
        }
    }
}

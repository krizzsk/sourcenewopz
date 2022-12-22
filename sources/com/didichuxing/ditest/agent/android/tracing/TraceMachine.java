package com.didichuxing.ditest.agent.android.tracing;

import com.didichuxing.ditest.agent.android.TaskQueue;
import com.didichuxing.ditest.agent.android.api.p186v2.TraceFieldInterface;
import com.didichuxing.ditest.agent.android.api.p186v2.TraceMachineInterface;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class TraceMachine {
    public static final String ACTIVITY_BACKGROUND_METRIC_PREFIX = "Mobile/Activity/Background/Name/";
    public static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Name/";
    public static final String ACTIVTY_DISPLAY_NAME_PREFIX = "Display ";
    public static final int HEALTHY_TRACE_TIMEOUT = 500;
    public static final String NR_TRACE_FIELD = "_nr_trace";
    public static final String NR_TRACE_TYPE = "Lcom/didichuxing/ditest/agent/android/tracing/Trace;";
    public static final int UNHEALTHY_TRACE_TIMEOUT = 60000;
    public static final AtomicBoolean disabled = new AtomicBoolean(false);
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final ThreadLocal<Trace> threadLocalTrace = new ThreadLocal<>();
    private static final ThreadLocal<TraceStack> threadLocalTraceStack = new ThreadLocal<>();
    private static TraceMachine traceMachine = null;
    private static TraceMachineInterface traceMachineInterface;

    public static void endTrace(String str) {
    }

    public static String getCurrentScope() {
        return null;
    }

    public static Trace getCurrentTrace() throws TracingInactiveException {
        return null;
    }

    public static void setTraceMachineInterface(TraceMachineInterface traceMachineInterface2) {
    }

    public void completeActivityTrace() {
    }

    protected TraceMachine(Trace trace) {
    }

    public static TraceMachine getTraceMachine() {
        return traceMachine;
    }

    public static void startTracing(String str) {
        startTracing(str, false);
    }

    public static void startTracing(String str, boolean z) {
        try {
            if (isTracingActive()) {
                traceMachine.completeActivityTrace();
            }
            threadLocalTrace.remove();
            threadLocalTraceStack.set(new TraceStack());
            Trace trace = new Trace();
            if (z) {
                trace.displayName = str;
            } else {
                trace.displayName = formatActivityDisplayName(str);
            }
            trace.metricName = formatActivityMetricName(trace.displayName);
            trace.metricBackgroundName = formatActivityBackgroundMetricName(trace.displayName);
            trace.entryTimestamp = System.currentTimeMillis();
            if (log.getLevel() == 5) {
                AgentLog agentLog = log;
                agentLog.debug("Started trace of " + str + ":" + trace.myUUID.toString());
            }
            TraceMachine traceMachine2 = new TraceMachine(trace);
            traceMachine = traceMachine2;
            trace.traceMachine = traceMachine2;
            pushTraceContext(trace);
        } catch (Exception e) {
            log.error("Caught error while initializing TraceMachine, shutting it down", e);
            traceMachine = null;
            threadLocalTrace.remove();
            threadLocalTraceStack.remove();
        }
    }

    public static void haltTracing() {
        if (!isTracingInactive()) {
            traceMachine = null;
            threadLocalTrace.remove();
            threadLocalTraceStack.remove();
        }
    }

    public static void endTrace() {
        traceMachine.completeActivityTrace();
    }

    public static String formatActivityMetricName(String str) {
        return "Mobile/Activity/Name/" + str;
    }

    public static String formatActivityBackgroundMetricName(String str) {
        return "Mobile/Activity/Background/Name/" + str;
    }

    public static String formatActivityDisplayName(String str) {
        return "Display " + str;
    }

    private static Trace registerNewTrace(String str) throws TracingInactiveException {
        if (!isTracingInactive()) {
            Trace currentTrace = getCurrentTrace();
            Trace trace = new Trace(str, currentTrace.myUUID, traceMachine);
            if (log.getLevel() == 5) {
                AgentLog agentLog = log;
                agentLog.debug("Registering trace of " + str + " with parent " + currentTrace.displayName);
            }
            currentTrace.addChild(trace);
            return trace;
        }
        log.debug("Tried to register a new trace but tracing is inactive!");
        throw new TracingInactiveException();
    }

    public static void enterNetworkSegment(String str) {
        try {
            if (!isTracingInactive()) {
                if (getCurrentTrace().getType() == TraceType.NETWORK) {
                    exitMethod();
                }
                enterMethod((Trace) null, str, (ArrayList<String>) null);
                getCurrentTrace().setType(TraceType.NETWORK);
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e) {
            log.error("Caught error while calling enterNetworkSegment()", e);
        }
    }

    public static void enterMethod(String str) {
        enterMethod((Trace) null, str, (ArrayList<String>) null);
    }

    public static void enterMethod(String str, ArrayList<String> arrayList) {
        enterMethod((Trace) null, str, arrayList);
    }

    public static void enterMethod(Trace trace, String str, ArrayList<String> arrayList) {
        try {
            if (!isTracingInactive()) {
                System.currentTimeMillis();
                loadTraceContext(trace);
                Trace registerNewTrace = registerNewTrace(str);
                pushTraceContext(registerNewTrace);
                registerNewTrace.scope = getCurrentScope();
                registerNewTrace.setAnnotationParams(arrayList);
                registerNewTrace.entryTimestamp = System.currentTimeMillis();
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e) {
            log.error("Caught error while calling enterMethod()", e);
        }
    }

    public static void exitMethod() {
        try {
            if (!isTracingInactive()) {
                Trace trace = threadLocalTrace.get();
                if (trace == null) {
                    log.debug("threadLocalTrace is null");
                    return;
                }
                trace.exitTimestamp = System.currentTimeMillis();
                if (trace.threadId == 0 && traceMachineInterface != null) {
                    trace.threadId = traceMachineInterface.getCurrentThreadId();
                    trace.threadName = traceMachineInterface.getCurrentThreadName();
                }
                try {
                    trace.complete();
                    threadLocalTraceStack.get().pop();
                    if (threadLocalTraceStack.get().empty()) {
                        threadLocalTrace.set((Object) null);
                    } else {
                        Trace trace2 = (Trace) threadLocalTraceStack.get().peek();
                        threadLocalTrace.set(trace2);
                        trace2.childExclusiveTime += trace.getDuration();
                    }
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                } catch (TracingInactiveException unused) {
                    threadLocalTrace.remove();
                    threadLocalTraceStack.remove();
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Caught error while calling exitMethod()", e);
        }
    }

    private static void pushTraceContext(Trace trace) {
        if (!isTracingInactive() && trace != null) {
            TraceStack traceStack = threadLocalTraceStack.get();
            if (traceStack.empty()) {
                traceStack.push(trace);
            } else if (traceStack.peek() != trace) {
                traceStack.push(trace);
            }
            threadLocalTrace.set(trace);
        }
    }

    private static void loadTraceContext(Trace trace) {
        if (!isTracingInactive()) {
            if (threadLocalTrace.get() == null) {
                threadLocalTrace.set(trace);
                threadLocalTraceStack.set(new TraceStack());
                if (trace != null) {
                    threadLocalTraceStack.get().push(trace);
                } else {
                    return;
                }
            } else if (trace == null) {
                if (threadLocalTraceStack.get().isEmpty()) {
                    if (log.getLevel() == 5) {
                        log.debug("No context to load!");
                    }
                    threadLocalTrace.set((Object) null);
                    return;
                }
                trace = (Trace) threadLocalTraceStack.get().peek();
                threadLocalTrace.set(trace);
            }
            if (log.getLevel() == 5) {
                AgentLog agentLog = log;
                agentLog.debug("Trace " + trace.myUUID.toString() + " is now active");
            }
        }
    }

    public static void unloadTraceContext(Object obj) {
        try {
            if (!isTracingInactive()) {
                if (traceMachineInterface == null || !traceMachineInterface.isUIThread()) {
                    if (threadLocalTrace.get() != null && log.getLevel() == 5) {
                        AgentLog agentLog = log;
                        agentLog.debug("Trace " + threadLocalTrace.get().myUUID.toString() + " is now inactive");
                    }
                    threadLocalTrace.remove();
                    threadLocalTraceStack.remove();
                    ((TraceFieldInterface) obj)._nr_setTrace((Trace) null);
                }
            }
        } catch (Exception e) {
            log.error("Caught error while calling unloadTraceContext()", e);
        }
    }

    public static Map<String, Object> getCurrentTraceParams() throws TracingInactiveException {
        return getCurrentTrace().getParams();
    }

    public static void setCurrentTraceParam(String str, Object obj) {
        if (!isTracingInactive()) {
            try {
                getCurrentTrace().getParams().put(str, obj);
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static void setCurrentDisplayName(String str) {
        if (!isTracingInactive()) {
            try {
                getCurrentTrace().displayName = str;
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static boolean isTracingActive() {
        return traceMachine != null;
    }

    public static boolean isTracingInactive() {
        return traceMachine == null;
    }

    public void storeCompletedTrace(Trace trace) {
        try {
            if (isTracingInactive()) {
                log.debug("Attempted to store a completed trace with no trace machine!");
            }
        } catch (Exception e) {
            log.error("Caught error while calling storeCompletedTrace()", e);
        }
    }

    private static class TraceStack extends Stack<Trace> {
        private TraceStack() {
        }
    }
}

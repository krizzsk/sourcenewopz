package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class Bus {
    public static final String DEFAULT_IDENTIFIER = "default";
    private final ThreadEnforcer enforcer;
    private final ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> eventsToDispatch;
    private final ConcurrentMap<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final HandlerFinder handlerFinder;
    private final ConcurrentMap<Class<?>, Set<EventHandler>> handlersByType;
    private final String identifier;
    private final ThreadLocal<Boolean> isDispatching;
    private final ConcurrentMap<Class<?>, EventProducer> producersByType;

    public Bus() {
        this("default");
    }

    public Bus(String str) {
        this(ThreadEnforcer.MAIN, str);
    }

    public Bus(ThreadEnforcer threadEnforcer) {
        this(threadEnforcer, "default");
    }

    public Bus(ThreadEnforcer threadEnforcer, String str) {
        this(threadEnforcer, str, HandlerFinder.ANNOTATED);
    }

    Bus(ThreadEnforcer threadEnforcer, String str, HandlerFinder handlerFinder2) {
        this.handlersByType = new ConcurrentHashMap();
        this.producersByType = new ConcurrentHashMap();
        this.eventsToDispatch = new ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>>() {
            /* access modifiers changed from: protected */
            public ConcurrentLinkedQueue<EventWithHandler> initialValue() {
                return new ConcurrentLinkedQueue<>();
            }
        };
        this.isDispatching = new ThreadLocal<Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean initialValue() {
                return false;
            }
        };
        this.flattenHierarchyCache = new ConcurrentHashMap();
        this.enforcer = threadEnforcer;
        this.identifier = str;
        this.handlerFinder = handlerFinder2;
    }

    public String toString() {
        return "[Bus \"" + this.identifier + "\"]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b1, code lost:
        r2 = new java.util.concurrent.CopyOnWriteArraySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void register(java.lang.Object r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0129
            com.squareup.otto.ThreadEnforcer r0 = r5.enforcer
            r0.enforce(r5)
            com.squareup.otto.HandlerFinder r0 = r5.handlerFinder
            java.util.Map r0 = r0.findAllProducers(r6)
            java.util.Set r1 = r0.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r1.next()
            java.lang.Class r2 = (java.lang.Class) r2
            java.lang.Object r3 = r0.get(r2)
            com.squareup.otto.EventProducer r3 = (com.squareup.otto.EventProducer) r3
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.squareup.otto.EventProducer> r4 = r5.producersByType
            java.lang.Object r4 = r4.putIfAbsent(r2, r3)
            com.squareup.otto.EventProducer r4 = (com.squareup.otto.EventProducer) r4
            if (r4 != 0) goto L_0x0055
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.Set<com.squareup.otto.EventHandler>> r4 = r5.handlersByType
            java.lang.Object r2 = r4.get(r2)
            java.util.Set r2 = (java.util.Set) r2
            if (r2 == 0) goto L_0x0015
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0015
            java.util.Iterator r2 = r2.iterator()
        L_0x0045:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0015
            java.lang.Object r4 = r2.next()
            com.squareup.otto.EventHandler r4 = (com.squareup.otto.EventHandler) r4
            r5.dispatchProducerResultToHandler(r4, r3)
            goto L_0x0045
        L_0x0055:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Producer method for type "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " found on type "
            r0.append(r1)
            java.lang.Object r1 = r3.target
            java.lang.Class r1 = r1.getClass()
            r0.append(r1)
            java.lang.String r1 = ", but already registered by type "
            r0.append(r1)
            java.lang.Object r1 = r4.target
            java.lang.Class r1 = r1.getClass()
            r0.append(r1)
            java.lang.String r1 = "."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x008d:
            com.squareup.otto.HandlerFinder r0 = r5.handlerFinder
            java.util.Map r6 = r0.findAllSubscribers(r6)
            java.util.Set r0 = r6.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d7
            java.lang.Object r1 = r0.next()
            java.lang.Class r1 = (java.lang.Class) r1
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.Set<com.squareup.otto.EventHandler>> r2 = r5.handlersByType
            java.lang.Object r2 = r2.get(r1)
            java.util.Set r2 = (java.util.Set) r2
            if (r2 != 0) goto L_0x00c2
            java.util.concurrent.CopyOnWriteArraySet r2 = new java.util.concurrent.CopyOnWriteArraySet
            r2.<init>()
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.Set<com.squareup.otto.EventHandler>> r3 = r5.handlersByType
            java.lang.Object r3 = r3.putIfAbsent(r1, r2)
            java.util.Set r3 = (java.util.Set) r3
            if (r3 != 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r2 = r3
        L_0x00c2:
            java.lang.Object r1 = r6.get(r1)
            java.util.Set r1 = (java.util.Set) r1
            boolean r1 = r2.addAll(r1)
            if (r1 == 0) goto L_0x00cf
            goto L_0x009b
        L_0x00cf:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Object already registered."
            r6.<init>(r0)
            throw r6
        L_0x00d7:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00df:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0128
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Class r1 = (java.lang.Class) r1
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.squareup.otto.EventProducer> r2 = r5.producersByType
            java.lang.Object r1 = r2.get(r1)
            com.squareup.otto.EventProducer r1 = (com.squareup.otto.EventProducer) r1
            if (r1 == 0) goto L_0x00df
            boolean r2 = r1.isValid()
            if (r2 == 0) goto L_0x00df
            java.lang.Object r0 = r0.getValue()
            java.util.Set r0 = (java.util.Set) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x010b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00df
            java.lang.Object r2 = r0.next()
            com.squareup.otto.EventHandler r2 = (com.squareup.otto.EventHandler) r2
            boolean r3 = r1.isValid()
            if (r3 != 0) goto L_0x011e
            goto L_0x00df
        L_0x011e:
            boolean r3 = r2.isValid()
            if (r3 == 0) goto L_0x010b
            r5.dispatchProducerResultToHandler(r2, r1)
            goto L_0x010b
        L_0x0128:
            return
        L_0x0129:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "Object to register must not be null."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.otto.Bus.register(java.lang.Object):void");
    }

    private void dispatchProducerResultToHandler(EventHandler eventHandler, EventProducer eventProducer) {
        Object obj;
        try {
            obj = eventProducer.produceEvent();
        } catch (InvocationTargetException e) {
            throwRuntimeException("Producer " + eventProducer + " threw an exception.", e);
            obj = null;
        }
        if (obj != null) {
            dispatch(obj, eventHandler);
        }
    }

    public void unregister(Object obj) {
        if (obj != null) {
            this.enforcer.enforce(this);
            for (Map.Entry next : this.handlerFinder.findAllProducers(obj).entrySet()) {
                Class cls = (Class) next.getKey();
                EventProducer producerForEventType = getProducerForEventType(cls);
                EventProducer eventProducer = (EventProducer) next.getValue();
                if (eventProducer == null || !eventProducer.equals(producerForEventType)) {
                    throw new IllegalArgumentException("Missing event producer for an annotated method. Is " + obj.getClass() + " registered?");
                }
                ((EventProducer) this.producersByType.remove(cls)).invalidate();
            }
            for (Map.Entry next2 : this.handlerFinder.findAllSubscribers(obj).entrySet()) {
                Set<EventHandler> handlersForEventType = getHandlersForEventType((Class) next2.getKey());
                Collection collection = (Collection) next2.getValue();
                if (handlersForEventType == null || !handlersForEventType.containsAll(collection)) {
                    throw new IllegalArgumentException("Missing event handler for an annotated method. Is " + obj.getClass() + " registered?");
                }
                for (EventHandler next3 : handlersForEventType) {
                    if (collection.contains(next3)) {
                        next3.invalidate();
                    }
                }
                handlersForEventType.removeAll(collection);
            }
            return;
        }
        throw new NullPointerException("Object to unregister must not be null.");
    }

    public void post(Object obj) {
        if (obj != null) {
            this.enforcer.enforce(this);
            boolean z = false;
            for (Class<?> handlersForEventType : flattenHierarchy(obj.getClass())) {
                Set<EventHandler> handlersForEventType2 = getHandlersForEventType(handlersForEventType);
                if (handlersForEventType2 != null && !handlersForEventType2.isEmpty()) {
                    z = true;
                    for (EventHandler enqueueEvent : handlersForEventType2) {
                        enqueueEvent(obj, enqueueEvent);
                    }
                }
            }
            if (!z && !(obj instanceof DeadEvent)) {
                post(new DeadEvent(this, obj));
            }
            dispatchQueuedEvents();
            return;
        }
        throw new NullPointerException("Event to post must not be null.");
    }

    /* access modifiers changed from: protected */
    public void enqueueEvent(Object obj, EventHandler eventHandler) {
        this.eventsToDispatch.get().offer(new EventWithHandler(obj, eventHandler));
    }

    /* access modifiers changed from: protected */
    public void dispatchQueuedEvents() {
        if (!this.isDispatching.get().booleanValue()) {
            this.isDispatching.set(true);
            while (true) {
                try {
                    EventWithHandler eventWithHandler = (EventWithHandler) this.eventsToDispatch.get().poll();
                    if (eventWithHandler != null) {
                        if (eventWithHandler.handler.isValid()) {
                            dispatch(eventWithHandler.event, eventWithHandler.handler);
                        }
                    } else {
                        return;
                    }
                } finally {
                    this.isDispatching.set(false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatch(Object obj, EventHandler eventHandler) {
        try {
            eventHandler.handleEvent(obj);
        } catch (InvocationTargetException e) {
            throwRuntimeException("Could not dispatch event: " + obj.getClass() + " to handler " + eventHandler, e);
        }
    }

    /* access modifiers changed from: package-private */
    public EventProducer getProducerForEventType(Class<?> cls) {
        return (EventProducer) this.producersByType.get(cls);
    }

    /* access modifiers changed from: package-private */
    public Set<EventHandler> getHandlersForEventType(Class<?> cls) {
        return (Set) this.handlersByType.get(cls);
    }

    /* access modifiers changed from: package-private */
    public Set<Class<?>> flattenHierarchy(Class<?> cls) {
        Set<Class<?>> set = (Set) this.flattenHierarchyCache.get(cls);
        if (set != null) {
            return set;
        }
        Set<Class<?>> classesFor = getClassesFor(cls);
        Set<Class<?>> putIfAbsent = this.flattenHierarchyCache.putIfAbsent(cls, classesFor);
        return putIfAbsent == null ? classesFor : putIfAbsent;
    }

    private Set<Class<?>> getClassesFor(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        HashSet hashSet = new HashSet();
        linkedList.add(cls);
        while (!linkedList.isEmpty()) {
            Class cls2 = (Class) linkedList.remove(0);
            hashSet.add(cls2);
            Class superclass = cls2.getSuperclass();
            if (superclass != null) {
                linkedList.add(superclass);
            }
        }
        return hashSet;
    }

    private static void throwRuntimeException(String str, InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            throw new RuntimeException(str + ": " + cause.getMessage(), cause);
        }
        throw new RuntimeException(str + ": " + invocationTargetException.getMessage(), invocationTargetException);
    }

    static class EventWithHandler {
        final Object event;
        final EventHandler handler;

        public EventWithHandler(Object obj, EventHandler eventHandler) {
            this.event = obj;
            this.handler = eventHandler;
        }
    }
}

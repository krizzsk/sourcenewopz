package kshark.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kshark.GcRoot;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;
import kshark.IgnoredReferenceMatcher;
import kshark.LeakTraceReference;
import kshark.LibraryLeakReferenceMatcher;
import kshark.OnAnalysisProgressListener;
import kshark.PrimitiveType;
import kshark.ReferenceMatcher;
import kshark.ReferencePattern;
import kshark.SharkLog;
import kshark.internal.ReferencePathNode;
import kshark.internal.hppc.LongLongScatterMap;
import kshark.internal.hppc.LongScatterSet;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002?@B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"0\u0007H\u0002J\u0014\u0010%\u001a\u00020\n*\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020**\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u0010H\u0002J\f\u0010-\u001a\u00020**\u00020&H\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020&H\u0002J\f\u0010.\u001a\u00020(*\u00020&H\u0002J\u001c\u0010/\u001a\u00020**\u00020&2\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\nH\u0002J\u0014\u00102\u001a\u00020**\u00020&2\u0006\u00100\u001a\u00020\u0013H\u0002J$\u00103\u001a\u00020**\u00020&2\u0006\u00104\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\nH\u0002J\u001c\u00105\u001a\u00020**\u00020&2\u0006\u00106\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013H\u0002J\u001c\u00107\u001a\u00020**\u00020&2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020(H\u0002J\u001c\u0010:\u001a\u00020**\u00020&2\u0006\u0010;\u001a\u00020 2\u0006\u00104\u001a\u00020(H\u0002J\u001c\u0010<\u001a\u00020**\u00020&2\u0006\u0010=\u001a\u00020>2\u0006\u00104\u001a\u00020(H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, mo175978d2 = {"Lkshark/internal/PathFinder;", "", "graph", "Lkshark/HeapGraph;", "listener", "Lkshark/OnAnalysisProgressListener;", "referenceMatchers", "", "Lkshark/ReferenceMatcher;", "enableSameInstanceThreshold", "", "(Lkshark/HeapGraph;Lkshark/OnAnalysisProgressListener;Ljava/util/List;Z)V", "SAME_INSTANCE_THRESHOLD", "", "fieldNameByClassName", "", "", "instanceCountMap", "", "", "", "jniGlobalReferenceMatchers", "staticFieldNameByClassName", "threadNameReferenceMatchers", "determineSizeOfObjectInstances", "findPathsFromGcRoots", "Lkshark/internal/PathFinder$PathFindingResults;", "leakingObjectIds", "", "computeRetainedHeapSize", "isOverThresholdInstance", "graphObject", "Lkshark/HeapObject$HeapInstance;", "sortedGcRoots", "Lkotlin/Pair;", "Lkshark/HeapObject;", "Lkshark/GcRoot;", "checkSeen", "Lkshark/internal/PathFinder$State;", "node", "Lkshark/internal/ReferencePathNode;", "enqueue", "", "heapClassName", "fieldName", "enqueueGcRoots", "poll", "undominate", "objectId", "neverEnqueued", "undominateWithSkips", "updateDominator", "parent", "updateDominatorWithSkips", "parentObjectId", "visitClassRecord", "heapClass", "Lkshark/HeapObject$HeapClass;", "visitInstance", "instance", "visitObjectArray", "objectArray", "Lkshark/HeapObject$HeapObjectArray;", "PathFindingResults", "State", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: PathFinder.kt */
public final class PathFinder {

    /* renamed from: a */
    private final Map<String, Map<String, ReferenceMatcher>> f4655a;

    /* renamed from: b */
    private final Map<String, Map<String, ReferenceMatcher>> f4656b;

    /* renamed from: c */
    private final Map<String, ReferenceMatcher> f4657c;

    /* renamed from: d */
    private final Map<String, ReferenceMatcher> f4658d;

    /* renamed from: e */
    private final int f4659e;

    /* renamed from: f */
    private Map<Long, Short> f4660f;

    /* renamed from: g */
    private final HeapGraph f4661g;

    /* renamed from: h */
    private final OnAnalysisProgressListener f4662h;

    /* renamed from: i */
    private final boolean f4663i;

    public PathFinder(HeapGraph heapGraph, OnAnalysisProgressListener onAnalysisProgressListener, List<? extends ReferenceMatcher> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        Intrinsics.checkParameterIsNotNull(onAnalysisProgressListener, "listener");
        Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
        this.f4661g = heapGraph;
        this.f4662h = onAnalysisProgressListener;
        this.f4663i = z;
        Map<String, Map<String, ReferenceMatcher>> linkedHashMap = new LinkedHashMap<>();
        Map<String, Map<String, ReferenceMatcher>> linkedHashMap2 = new LinkedHashMap<>();
        Map<String, ReferenceMatcher> linkedHashMap3 = new LinkedHashMap<>();
        Map<String, ReferenceMatcher> linkedHashMap4 = new LinkedHashMap<>();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            ReferenceMatcher referenceMatcher = (ReferenceMatcher) next;
            if ((referenceMatcher instanceof IgnoredReferenceMatcher) || ((referenceMatcher instanceof LibraryLeakReferenceMatcher) && ((LibraryLeakReferenceMatcher) referenceMatcher).getPatternApplies().invoke(this.f4661g).booleanValue())) {
                arrayList.add(next);
            }
        }
        for (ReferenceMatcher referenceMatcher2 : (List) arrayList) {
            ReferencePattern pattern = referenceMatcher2.getPattern();
            if (pattern instanceof ReferencePattern.JavaLocalPattern) {
                linkedHashMap3.put(((ReferencePattern.JavaLocalPattern) pattern).getThreadName(), referenceMatcher2);
            } else if (pattern instanceof ReferencePattern.StaticFieldPattern) {
                ReferencePattern.StaticFieldPattern staticFieldPattern = (ReferencePattern.StaticFieldPattern) pattern;
                Map map = linkedHashMap2.get(staticFieldPattern.getClassName());
                if (map == null) {
                    map = new LinkedHashMap();
                    linkedHashMap2.put(staticFieldPattern.getClassName(), map);
                }
                map.put(staticFieldPattern.getFieldName(), referenceMatcher2);
            } else if (pattern instanceof ReferencePattern.InstanceFieldPattern) {
                ReferencePattern.InstanceFieldPattern instanceFieldPattern = (ReferencePattern.InstanceFieldPattern) pattern;
                Map map2 = linkedHashMap.get(instanceFieldPattern.getClassName());
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                    linkedHashMap.put(instanceFieldPattern.getClassName(), map2);
                }
                map2.put(instanceFieldPattern.getFieldName(), referenceMatcher2);
            } else if (pattern instanceof ReferencePattern.NativeGlobalVariablePattern) {
                linkedHashMap4.put(((ReferencePattern.NativeGlobalVariablePattern) pattern).getClassName(), referenceMatcher2);
            }
        }
        this.f4655a = linkedHashMap;
        this.f4656b = linkedHashMap2;
        this.f4657c = linkedHashMap3;
        this.f4658d = linkedHashMap4;
        this.f4659e = 1024;
        this.f4660f = new LinkedHashMap();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lkshark/internal/PathFinder$PathFindingResults;", "", "pathsToLeakingObjects", "", "Lkshark/internal/ReferencePathNode;", "dominatedObjectIds", "Lkshark/internal/hppc/LongLongScatterMap;", "(Ljava/util/List;Lkshark/internal/hppc/LongLongScatterMap;)V", "getDominatedObjectIds", "()Lkshark/internal/hppc/LongLongScatterMap;", "getPathsToLeakingObjects", "()Ljava/util/List;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: PathFinder.kt */
    public static final class PathFindingResults {
        private final LongLongScatterMap dominatedObjectIds;
        private final List<ReferencePathNode> pathsToLeakingObjects;

        public PathFindingResults(List<? extends ReferencePathNode> list, LongLongScatterMap longLongScatterMap) {
            Intrinsics.checkParameterIsNotNull(list, "pathsToLeakingObjects");
            Intrinsics.checkParameterIsNotNull(longLongScatterMap, "dominatedObjectIds");
            this.pathsToLeakingObjects = list;
            this.dominatedObjectIds = longLongScatterMap;
        }

        public final List<ReferencePathNode> getPathsToLeakingObjects() {
            return this.pathsToLeakingObjects;
        }

        public final LongLongScatterMap getDominatedObjectIds() {
            return this.dominatedObjectIds;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001cj\b\u0012\u0004\u0012\u00020\u0004`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR!\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001cj\b\u0012\u0004\u0012\u00020\u0004`\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006("}, mo175978d2 = {"Lkshark/internal/PathFinder$State;", "", "leakingObjectIds", "", "", "sizeOfObjectInstances", "", "computeRetainedHeapSize", "", "(Ljava/util/Set;IZ)V", "getComputeRetainedHeapSize", "()Z", "dominatedObjectIds", "Lkshark/internal/hppc/LongLongScatterMap;", "getDominatedObjectIds", "()Lkshark/internal/hppc/LongLongScatterMap;", "getLeakingObjectIds", "()Ljava/util/Set;", "queuesNotEmpty", "getQueuesNotEmpty", "getSizeOfObjectInstances", "()I", "toVisitLastQueue", "Ljava/util/Deque;", "Lkshark/internal/ReferencePathNode;", "getToVisitLastQueue", "()Ljava/util/Deque;", "toVisitLastSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getToVisitLastSet", "()Ljava/util/HashSet;", "toVisitQueue", "getToVisitQueue", "toVisitSet", "getToVisitSet", "visitedSet", "Lkshark/internal/hppc/LongScatterSet;", "getVisitedSet", "()Lkshark/internal/hppc/LongScatterSet;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: PathFinder.kt */
    private static final class State {
        private final boolean computeRetainedHeapSize;
        private final LongLongScatterMap dominatedObjectIds = new LongLongScatterMap();
        private final Set<Long> leakingObjectIds;
        private final int sizeOfObjectInstances;
        private final Deque<ReferencePathNode> toVisitLastQueue = new ArrayDeque();
        private final HashSet<Long> toVisitLastSet = new HashSet<>();
        private final Deque<ReferencePathNode> toVisitQueue = new ArrayDeque();
        private final HashSet<Long> toVisitSet = new HashSet<>();
        private final LongScatterSet visitedSet = new LongScatterSet();

        public State(Set<Long> set, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(set, "leakingObjectIds");
            this.leakingObjectIds = set;
            this.sizeOfObjectInstances = i;
            this.computeRetainedHeapSize = z;
        }

        public final Set<Long> getLeakingObjectIds() {
            return this.leakingObjectIds;
        }

        public final int getSizeOfObjectInstances() {
            return this.sizeOfObjectInstances;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final Deque<ReferencePathNode> getToVisitQueue() {
            return this.toVisitQueue;
        }

        public final Deque<ReferencePathNode> getToVisitLastQueue() {
            return this.toVisitLastQueue;
        }

        public final HashSet<Long> getToVisitSet() {
            return this.toVisitSet;
        }

        public final HashSet<Long> getToVisitLastSet() {
            return this.toVisitLastSet;
        }

        public final LongScatterSet getVisitedSet() {
            return this.visitedSet;
        }

        public final LongLongScatterMap getDominatedObjectIds() {
            return this.dominatedObjectIds;
        }

        public final boolean getQueuesNotEmpty() {
            return (this.toVisitQueue.isEmpty() ^ true) || (this.toVisitLastQueue.isEmpty() ^ true);
        }
    }

    public final PathFindingResults findPathsFromGcRoots(Set<Long> set, boolean z) {
        Intrinsics.checkParameterIsNotNull(set, "leakingObjectIds");
        SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
        if (logger != null) {
            logger.mo23715d("findPathsFromGcRoots");
        }
        this.f4662h.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_PATHS_TO_RETAINED_OBJECTS);
        return m2982a(new State(set, m2980a(this.f4661g), z));
    }

    /* renamed from: a */
    private final int m2980a(HeapGraph heapGraph) {
        int identifierByteSize;
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName("java.lang.Object");
        if (findClassByName == null || findClassByName.readFieldsByteSize() != (identifierByteSize = heapGraph.getIdentifierByteSize() + PrimitiveType.INT.getByteSize())) {
            return 0;
        }
        return identifierByteSize;
    }

    /* renamed from: a */
    private final PathFindingResults m2982a(State state) {
        SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
        if (logger != null) {
            logger.mo23715d("start findPathsFromGcRoots");
        }
        m2995c(state);
        List arrayList = new ArrayList();
        while (state.getQueuesNotEmpty()) {
            ReferencePathNode b = m2994b(state);
            if (!m2993a(state, b)) {
                if (state.getLeakingObjectIds().contains(Long.valueOf(b.getObjectId()))) {
                    arrayList.add(b);
                    if (arrayList.size() == state.getLeakingObjectIds().size()) {
                        if (!state.getComputeRetainedHeapSize()) {
                            break;
                        }
                        this.f4662h.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_DOMINATORS);
                    }
                }
                HeapObject findObjectById = this.f4661g.findObjectById(b.getObjectId());
                if (findObjectById instanceof HeapObject.HeapClass) {
                    m2987a(state, (HeapObject.HeapClass) findObjectById, b);
                } else if (findObjectById instanceof HeapObject.HeapInstance) {
                    m2988a(state, (HeapObject.HeapInstance) findObjectById, b);
                } else if (findObjectById instanceof HeapObject.HeapObjectArray) {
                    m2989a(state, (HeapObject.HeapObjectArray) findObjectById, b);
                }
            } else {
                throw new IllegalStateException("Node " + b + " objectId=" + b.getObjectId() + " should not be enqueued when already visited or enqueued");
            }
        }
        SharkLog.Logger logger2 = SharkLog.INSTANCE.getLogger();
        if (logger2 != null) {
            logger2.mo23715d("end findPathsFromGcRoots");
        }
        return new PathFindingResults(arrayList, state.getDominatedObjectIds());
    }

    /* renamed from: b */
    private final ReferencePathNode m2994b(State state) {
        if (!state.getToVisitQueue().isEmpty()) {
            ReferencePathNode poll = state.getToVisitQueue().poll();
            state.getToVisitSet().remove(Long.valueOf(poll.getObjectId()));
            Intrinsics.checkExpressionValueIsNotNull(poll, "removedNode");
            return poll;
        }
        ReferencePathNode poll2 = state.getToVisitLastQueue().poll();
        state.getToVisitLastSet().remove(Long.valueOf(poll2.getObjectId()));
        Intrinsics.checkExpressionValueIsNotNull(poll2, "removedNode");
        return poll2;
    }

    /* renamed from: a */
    private final boolean m2993a(State state, ReferencePathNode referencePathNode) {
        return !state.getVisitedSet().add(referencePathNode.getObjectId());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: kshark.internal.ReferencePathNode$ChildNode$NormalNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kshark.internal.ReferencePathNode$ChildNode$LibraryLeakChildNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kshark.internal.ReferencePathNode$ChildNode$LibraryLeakChildNode} */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2995c(kshark.internal.PathFinder.State r21) {
        /*
            r20 = this;
            r7 = r20
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "start enqueueGcRoots"
            r0.mo23715d(r1)
        L_0x000f:
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = "start sortedGcRoots"
            r0.mo23715d(r1)
        L_0x001c:
            java.util.List r0 = r20.m2981a()
            kshark.SharkLog r1 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r1 = r1.getLogger()
            if (r1 == 0) goto L_0x002d
            java.lang.String r2 = "end sortedGcRoots"
            r1.mo23715d(r2)
        L_0x002d:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r8 = r1
            java.util.Map r8 = (java.util.Map) r8
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            r9 = r1
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r10 = r0.iterator()
        L_0x0043:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x01fd
            java.lang.Object r0 = r10.next()
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r1 = r0.component1()
            kshark.HeapObject r1 = (kshark.HeapObject) r1
            java.lang.Object r0 = r0.component2()
            r6 = r0
            kshark.GcRoot r6 = (kshark.GcRoot) r6
            boolean r0 = r21.getComputeRetainedHeapSize()
            if (r0 == 0) goto L_0x006c
            long r2 = r6.getId()
            r11 = r21
            r7.m2983a((kshark.internal.PathFinder.State) r11, (long) r2)
            goto L_0x006e
        L_0x006c:
            r11 = r21
        L_0x006e:
            boolean r0 = r6 instanceof kshark.GcRoot.ThreadObject
            if (r0 == 0) goto L_0x00a5
            r0 = r6
            kshark.GcRoot$ThreadObject r0 = (kshark.GcRoot.ThreadObject) r0
            int r0 = r0.getThreadSerialNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            kshark.HeapObject$HeapInstance r1 = r1.getAsInstance()
            if (r1 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0086:
            kotlin.Pair r1 = kotlin.TuplesKt.m42317to(r1, r6)
            r9.put(r0, r1)
            kshark.internal.ReferencePathNode$RootNode$NormalRootNode r0 = new kshark.internal.ReferencePathNode$RootNode$NormalRootNode
            long r1 = r6.getId()
            r0.<init>(r1, r6)
            r2 = r0
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x00a5:
            boolean r0 = r6 instanceof kshark.GcRoot.JavaFrame
            if (r0 == 0) goto L_0x0153
            r0 = r6
            kshark.GcRoot$JavaFrame r0 = (kshark.GcRoot.JavaFrame) r0
            int r0 = r0.getThreadSerialNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r9.get(r0)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x00d5
            kshark.internal.ReferencePathNode$RootNode$NormalRootNode r0 = new kshark.internal.ReferencePathNode$RootNode$NormalRootNode
            long r1 = r6.getId()
            r0.<init>(r1, r6)
            r2 = r0
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x00d5:
            java.lang.Object r1 = r0.component1()
            kshark.HeapObject$HeapInstance r1 = (kshark.HeapObject.HeapInstance) r1
            java.lang.Object r0 = r0.component2()
            r12 = r0
            kshark.GcRoot$ThreadObject r12 = (kshark.GcRoot.ThreadObject) r12
            java.lang.Object r0 = r8.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x00eb
            goto L_0x00ff
        L_0x00eb:
            kshark.internal.PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1 r13 = new kshark.internal.PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1
            r0 = r13
            r2 = r20
            r3 = r21
            r4 = r9
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            java.lang.Object r0 = r13.invoke()
            java.lang.String r0 = (java.lang.String) r0
        L_0x00ff:
            java.util.Map<java.lang.String, kshark.ReferenceMatcher> r1 = r7.f4657c
            java.lang.Object r0 = r1.get(r0)
            kshark.ReferenceMatcher r0 = (kshark.ReferenceMatcher) r0
            boolean r1 = r0 instanceof kshark.IgnoredReferenceMatcher
            if (r1 != 0) goto L_0x0043
            kshark.internal.ReferencePathNode$RootNode$NormalRootNode r1 = new kshark.internal.ReferencePathNode$RootNode$NormalRootNode
            long r2 = r12.getId()
            r1.<init>(r2, r6)
            kshark.LeakTraceReference$ReferenceType r16 = kshark.LeakTraceReference.ReferenceType.LOCAL
            java.lang.String r17 = ""
            boolean r2 = r0 instanceof kshark.LibraryLeakReferenceMatcher
            if (r2 == 0) goto L_0x0132
            kshark.internal.ReferencePathNode$ChildNode$LibraryLeakChildNode r2 = new kshark.internal.ReferencePathNode$ChildNode$LibraryLeakChildNode
            long r13 = r6.getId()
            r15 = r1
            kshark.internal.ReferencePathNode r15 = (kshark.internal.ReferencePathNode) r15
            r18 = r0
            kshark.LibraryLeakReferenceMatcher r18 = (kshark.LibraryLeakReferenceMatcher) r18
            java.lang.String r19 = ""
            r12 = r2
            r12.<init>(r13, r15, r16, r17, r18, r19)
            kshark.internal.ReferencePathNode$ChildNode r2 = (kshark.internal.ReferencePathNode.ChildNode) r2
            goto L_0x0144
        L_0x0132:
            kshark.internal.ReferencePathNode$ChildNode$NormalNode r0 = new kshark.internal.ReferencePathNode$ChildNode$NormalNode
            long r13 = r6.getId()
            r15 = r1
            kshark.internal.ReferencePathNode r15 = (kshark.internal.ReferencePathNode) r15
            java.lang.String r18 = ""
            r12 = r0
            r12.<init>(r13, r15, r16, r17, r18)
            r2 = r0
            kshark.internal.ReferencePathNode$ChildNode r2 = (kshark.internal.ReferencePathNode.ChildNode) r2
        L_0x0144:
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x0153:
            boolean r0 = r6 instanceof kshark.GcRoot.JniGlobal
            if (r0 == 0) goto L_0x01e4
            boolean r0 = r1 instanceof kshark.HeapObject.HeapClass
            if (r0 == 0) goto L_0x016a
            java.util.Map<java.lang.String, kshark.ReferenceMatcher> r0 = r7.f4658d
            kshark.HeapObject$HeapClass r1 = (kshark.HeapObject.HeapClass) r1
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.get(r1)
            kshark.ReferenceMatcher r0 = (kshark.ReferenceMatcher) r0
            goto L_0x01a2
        L_0x016a:
            boolean r0 = r1 instanceof kshark.HeapObject.HeapInstance
            if (r0 == 0) goto L_0x017d
            java.util.Map<java.lang.String, kshark.ReferenceMatcher> r0 = r7.f4658d
            kshark.HeapObject$HeapInstance r1 = (kshark.HeapObject.HeapInstance) r1
            java.lang.String r1 = r1.getInstanceClassName()
            java.lang.Object r0 = r0.get(r1)
            kshark.ReferenceMatcher r0 = (kshark.ReferenceMatcher) r0
            goto L_0x01a2
        L_0x017d:
            boolean r0 = r1 instanceof kshark.HeapObject.HeapObjectArray
            if (r0 == 0) goto L_0x0190
            java.util.Map<java.lang.String, kshark.ReferenceMatcher> r0 = r7.f4658d
            kshark.HeapObject$HeapObjectArray r1 = (kshark.HeapObject.HeapObjectArray) r1
            java.lang.String r1 = r1.getArrayClassName()
            java.lang.Object r0 = r0.get(r1)
            kshark.ReferenceMatcher r0 = (kshark.ReferenceMatcher) r0
            goto L_0x01a2
        L_0x0190:
            boolean r0 = r1 instanceof kshark.HeapObject.HeapPrimitiveArray
            if (r0 == 0) goto L_0x01de
            java.util.Map<java.lang.String, kshark.ReferenceMatcher> r0 = r7.f4658d
            kshark.HeapObject$HeapPrimitiveArray r1 = (kshark.HeapObject.HeapPrimitiveArray) r1
            java.lang.String r1 = r1.getArrayClassName()
            java.lang.Object r0 = r0.get(r1)
            kshark.ReferenceMatcher r0 = (kshark.ReferenceMatcher) r0
        L_0x01a2:
            boolean r1 = r0 instanceof kshark.IgnoredReferenceMatcher
            if (r1 != 0) goto L_0x0043
            boolean r1 = r0 instanceof kshark.LibraryLeakReferenceMatcher
            if (r1 == 0) goto L_0x01c5
            kshark.internal.ReferencePathNode$RootNode$LibraryLeakRootNode r1 = new kshark.internal.ReferencePathNode$RootNode$LibraryLeakRootNode
            long r2 = r6.getId()
            kshark.LibraryLeakReferenceMatcher r0 = (kshark.LibraryLeakReferenceMatcher) r0
            r1.<init>(r2, r6, r0)
            r2 = r1
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x01c5:
            kshark.internal.ReferencePathNode$RootNode$NormalRootNode r0 = new kshark.internal.ReferencePathNode$RootNode$NormalRootNode
            long r1 = r6.getId()
            r0.<init>(r1, r6)
            r2 = r0
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x01de:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01e4:
            kshark.internal.ReferencePathNode$RootNode$NormalRootNode r0 = new kshark.internal.ReferencePathNode$RootNode$NormalRootNode
            long r1 = r6.getId()
            r0.<init>(r1, r6)
            r2 = r0
            kshark.internal.ReferencePathNode r2 = (kshark.internal.ReferencePathNode) r2
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r0 = r20
            r1 = r21
            m2991a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0043
        L_0x01fd:
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x020a
            java.lang.String r1 = "end enqueueGcRoots"
            r0.mo23715d(r1)
        L_0x020a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.PathFinder.m2995c(kshark.internal.PathFinder$State):void");
    }

    /* renamed from: a */
    private final List<Pair<HeapObject, GcRoot>> m2981a() {
        Function1 function1 = PathFinder$sortedGcRoots$rootClassName$1.INSTANCE;
        Collection arrayList = new ArrayList();
        for (Object next : this.f4661g.getGcRoots()) {
            if (this.f4661g.objectExists(((GcRoot) next).getId())) {
                arrayList.add(next);
            }
        }
        Iterable<GcRoot> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (GcRoot gcRoot : iterable) {
            arrayList2.add(TuplesKt.m42317to(this.f4661g.findObjectById(gcRoot.getId()), gcRoot));
        }
        return CollectionsKt.sortedWith((List) arrayList2, new PathFinder$sortedGcRoots$3(function1));
    }

    /* renamed from: a */
    private final void m2987a(State state, HeapObject.HeapClass heapClass, ReferencePathNode referencePathNode) {
        ReferencePathNode.ChildNode childNode;
        if (!StringsKt.startsWith$default(heapClass.getName(), "android.R$", false, 2, (Object) null)) {
            Map map = this.f4656b.get(heapClass.getName());
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map map2 = map;
            for (HeapField next : heapClass.readStaticFields()) {
                if (next.getValue().isNonNullReference()) {
                    String name = next.getName();
                    if (!Intrinsics.areEqual((Object) name, (Object) "$staticOverhead") && !Intrinsics.areEqual((Object) name, (Object) "$classOverhead") && !StringsKt.startsWith$default(name, "$class$", false, 2, (Object) null)) {
                        Long asObjectId = next.getValue().getAsObjectId();
                        if (asObjectId == null) {
                            Intrinsics.throwNpe();
                        }
                        long longValue = asObjectId.longValue();
                        State state2 = state;
                        if (state.getComputeRetainedHeapSize()) {
                            m2983a(state2, longValue);
                        }
                        ReferenceMatcher referenceMatcher = (ReferenceMatcher) map2.get(name);
                        if (referenceMatcher == null) {
                            childNode = new ReferencePathNode.ChildNode.NormalNode(longValue, referencePathNode, LeakTraceReference.ReferenceType.STATIC_FIELD, name, next.getDeclaringClass().getName());
                        } else if (referenceMatcher instanceof LibraryLeakReferenceMatcher) {
                            childNode = new ReferencePathNode.ChildNode.LibraryLeakChildNode(longValue, referencePathNode, LeakTraceReference.ReferenceType.STATIC_FIELD, name, (LibraryLeakReferenceMatcher) referenceMatcher, next.getDeclaringClass().getName());
                        } else if (referenceMatcher instanceof IgnoredReferenceMatcher) {
                            childNode = null;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!(childNode == null || childNode.getObjectId() == 0 || this.f4661g.findObjectByIdOrNull(childNode.getObjectId()) == null)) {
                            m2991a(this, state, childNode, (String) null, (String) null, 6, (Object) null);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m2988a(State state, HeapObject.HeapInstance heapInstance, ReferencePathNode referencePathNode) {
        ReferencePathNode.ChildNode childNode;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (HeapObject.HeapClass name : heapInstance.getInstanceClass().getClassHierarchy()) {
            Map map = this.f4655a.get(name.getName());
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    ReferenceMatcher referenceMatcher = (ReferenceMatcher) entry.getValue();
                    if (!linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, referenceMatcher);
                    }
                }
            }
        }
        List<HeapField> mutableList = SequencesKt.toMutableList(SequencesKt.filter(heapInstance.readFields(), PathFinder$visitInstance$fieldNamesAndValues$1.INSTANCE));
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new PathFinder$visitInstance$$inlined$sortBy$1());
        }
        for (HeapField heapField : mutableList) {
            Long asObjectId = heapField.getValue().getAsObjectId();
            if (asObjectId == null) {
                Intrinsics.throwNpe();
            }
            long longValue = asObjectId.longValue();
            if (state.getComputeRetainedHeapSize()) {
                m2984a(state, referencePathNode.getObjectId(), longValue);
            }
            ReferenceMatcher referenceMatcher2 = (ReferenceMatcher) linkedHashMap.get(heapField.getName());
            if (referenceMatcher2 == null) {
                childNode = new ReferencePathNode.ChildNode.NormalNode(longValue, referencePathNode, LeakTraceReference.ReferenceType.INSTANCE_FIELD, heapField.getName(), heapField.getDeclaringClass().getName());
            } else if (referenceMatcher2 instanceof LibraryLeakReferenceMatcher) {
                childNode = new ReferencePathNode.ChildNode.LibraryLeakChildNode(longValue, referencePathNode, LeakTraceReference.ReferenceType.INSTANCE_FIELD, heapField.getName(), (LibraryLeakReferenceMatcher) referenceMatcher2, heapField.getDeclaringClass().getName());
            } else if (referenceMatcher2 instanceof IgnoredReferenceMatcher) {
                childNode = null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (childNode == null || childNode.getObjectId() == 0 || this.f4661g.findObjectByIdOrNull(childNode.getObjectId()) == null) {
                State state2 = state;
            } else {
                m2990a(state, (ReferencePathNode) childNode, heapInstance.getInstanceClassName(), heapField.getName());
            }
        }
    }

    /* renamed from: a */
    private final void m2989a(State state, HeapObject.HeapObjectArray heapObjectArray, ReferencePathNode referencePathNode) {
        long[] elementIds = heapObjectArray.readRecord().getElementIds();
        Collection arrayList = new ArrayList();
        int length = elementIds.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            long j = elementIds[i2];
            if (j != 0 && this.f4661g.objectExists(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        for (Object next : (List) arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long longValue = ((Number) next).longValue();
            if (state.getComputeRetainedHeapSize()) {
                m2984a(state, referencePathNode.getObjectId(), longValue);
            }
            State state2 = state;
            m2991a(this, state2, new ReferencePathNode.ChildNode.NormalNode(longValue, referencePathNode, LeakTraceReference.ReferenceType.ARRAY_ENTRY, String.valueOf(i), ""), (String) null, (String) null, 6, (Object) null);
            i = i3;
        }
    }

    /* renamed from: a */
    private final boolean m2992a(HeapObject.HeapInstance heapInstance) {
        if (!this.f4663i || StringsKt.startsWith$default(heapInstance.getInstanceClassName(), "java.util", false, 2, (Object) null) || StringsKt.startsWith$default(heapInstance.getInstanceClassName(), "android.util", false, 2, (Object) null) || StringsKt.startsWith$default(heapInstance.getInstanceClassName(), "java.lang.String", false, 2, (Object) null)) {
            return false;
        }
        Short sh = this.f4660f.get(Long.valueOf(heapInstance.getInstanceClassId()));
        if (sh == null) {
            sh = (short) 0;
        }
        if (sh.shortValue() < this.f4659e) {
            this.f4660f.put(Long.valueOf(heapInstance.getInstanceClassId()), Short.valueOf((short) (sh.shortValue() + 1)));
        }
        if (sh.shortValue() >= this.f4659e) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m2991a(PathFinder pathFinder, State state, ReferencePathNode referencePathNode, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        pathFinder.m2990a(state, referencePathNode, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        if ((((kshark.internal.ReferencePathNode.RootNode) r10.getParent()).getGcRoot() instanceof kshark.GcRoot.JavaFrame) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0118, code lost:
        if (m2992a(r1) != false) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0125, code lost:
        if (((kshark.HeapObject.HeapObjectArray) r1).isPrimitiveWrapperArray() != false) goto L_0x0103;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2990a(kshark.internal.PathFinder.State r8, kshark.internal.ReferencePathNode r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            long r10 = r9.getObjectId()
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            kshark.internal.hppc.LongScatterSet r10 = r8.getVisitedSet()
            long r0 = r9.getObjectId()
            boolean r10 = r10.contains(r0)
            if (r10 == 0) goto L_0x001a
            return
        L_0x001a:
            java.util.HashSet r10 = r8.getToVisitSet()
            long r0 = r9.getObjectId()
            java.lang.Long r11 = java.lang.Long.valueOf(r0)
            boolean r10 = r10.contains(r11)
            if (r10 == 0) goto L_0x002d
            return
        L_0x002d:
            boolean r10 = r9 instanceof kshark.internal.ReferencePathNode.LibraryLeakNode
            r11 = 0
            r0 = 1
            if (r10 != 0) goto L_0x0062
            boolean r10 = r9 instanceof kshark.internal.ReferencePathNode.RootNode
            if (r10 == 0) goto L_0x0042
            r10 = r9
            kshark.internal.ReferencePathNode$RootNode r10 = (kshark.internal.ReferencePathNode.RootNode) r10
            kshark.GcRoot r10 = r10.getGcRoot()
            boolean r10 = r10 instanceof kshark.GcRoot.ThreadObject
            if (r10 != 0) goto L_0x0062
        L_0x0042:
            boolean r10 = r9 instanceof kshark.internal.ReferencePathNode.ChildNode.NormalNode
            if (r10 == 0) goto L_0x0060
            r10 = r9
            kshark.internal.ReferencePathNode$ChildNode$NormalNode r10 = (kshark.internal.ReferencePathNode.ChildNode.NormalNode) r10
            kshark.internal.ReferencePathNode r1 = r10.getParent()
            boolean r1 = r1 instanceof kshark.internal.ReferencePathNode.RootNode
            if (r1 == 0) goto L_0x0060
            kshark.internal.ReferencePathNode r10 = r10.getParent()
            kshark.internal.ReferencePathNode$RootNode r10 = (kshark.internal.ReferencePathNode.RootNode) r10
            kshark.GcRoot r10 = r10.getGcRoot()
            boolean r10 = r10 instanceof kshark.GcRoot.JavaFrame
            if (r10 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r10 = 0
            goto L_0x0063
        L_0x0062:
            r10 = 1
        L_0x0063:
            java.util.HashSet r1 = r8.getToVisitLastSet()
            long r2 = r9.getObjectId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x00d6
            if (r10 == 0) goto L_0x0078
            return
        L_0x0078:
            java.util.Deque r10 = r8.getToVisitQueue()
            r10.add(r9)
            java.util.HashSet r10 = r8.getToVisitSet()
            long r1 = r9.getObjectId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r10.add(r1)
            java.util.Deque r10 = r8.getToVisitLastQueue()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0098:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00cc
            java.lang.Object r1 = r10.next()
            kshark.internal.ReferencePathNode r1 = (kshark.internal.ReferencePathNode) r1
            long r2 = r1.getObjectId()
            long r4 = r9.getObjectId()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x00b2
            r2 = 1
            goto L_0x00b3
        L_0x00b2:
            r2 = 0
        L_0x00b3:
            if (r2 == 0) goto L_0x0098
            java.util.Deque r10 = r8.getToVisitLastQueue()
            r10.remove(r1)
            java.util.HashSet r8 = r8.getToVisitLastSet()
            long r9 = r9.getObjectId()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r8.remove(r9)
            return
        L_0x00cc:
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            java.lang.String r9 = "Collection contains no element matching the predicate."
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x00d6:
            java.util.Set r1 = r8.getLeakingObjectIds()
            long r2 = r9.getObjectId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0136
            kshark.HeapGraph r1 = r7.f4661g
            long r2 = r9.getObjectId()
            kshark.HeapObject r1 = r1.findObjectById(r2)
            boolean r2 = r1 instanceof kshark.HeapObject.HeapClass
            if (r2 == 0) goto L_0x00f7
            goto L_0x012d
        L_0x00f7:
            boolean r2 = r1 instanceof kshark.HeapObject.HeapInstance
            if (r2 == 0) goto L_0x011b
            kshark.HeapObject$HeapInstance r1 = (kshark.HeapObject.HeapInstance) r1
            boolean r2 = r1.isPrimitiveWrapper()
            if (r2 == 0) goto L_0x0105
        L_0x0103:
            r11 = 1
            goto L_0x012d
        L_0x0105:
            kshark.HeapObject$HeapClass r2 = r1.getInstanceClass()
            int r2 = r2.getInstanceByteSize()
            int r3 = r8.getSizeOfObjectInstances()
            if (r2 > r3) goto L_0x0114
            goto L_0x0103
        L_0x0114:
            boolean r1 = r7.m2992a((kshark.HeapObject.HeapInstance) r1)
            if (r1 == 0) goto L_0x012d
            goto L_0x0103
        L_0x011b:
            boolean r2 = r1 instanceof kshark.HeapObject.HeapObjectArray
            if (r2 == 0) goto L_0x0128
            kshark.HeapObject$HeapObjectArray r1 = (kshark.HeapObject.HeapObjectArray) r1
            boolean r1 = r1.isPrimitiveWrapperArray()
            if (r1 == 0) goto L_0x012d
            goto L_0x0103
        L_0x0128:
            boolean r11 = r1 instanceof kshark.HeapObject.HeapPrimitiveArray
            if (r11 == 0) goto L_0x0130
            goto L_0x0103
        L_0x012d:
            if (r11 == 0) goto L_0x0136
            return
        L_0x0130:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x0136:
            if (r10 == 0) goto L_0x014f
            java.util.Deque r10 = r8.getToVisitLastQueue()
            r10.add(r9)
            java.util.HashSet r8 = r8.getToVisitLastSet()
            long r9 = r9.getObjectId()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r8.add(r9)
            goto L_0x0165
        L_0x014f:
            java.util.Deque r10 = r8.getToVisitQueue()
            r10.add(r9)
            java.util.HashSet r8 = r8.getToVisitSet()
            long r9 = r9.getObjectId()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r8.add(r9)
        L_0x0165:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.PathFinder.m2990a(kshark.internal.PathFinder$State, kshark.internal.ReferencePathNode, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r0 = r0.getValue();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2984a(kshark.internal.PathFinder.State r13, long r14, long r16) {
        /*
            r12 = this;
            r7 = r12
            r4 = r16
            kshark.HeapGraph r0 = r7.f4661g
            kshark.HeapObject r0 = r0.findObjectById(r4)
            boolean r1 = r0 instanceof kshark.HeapObject.HeapClass
            r8 = 0
            if (r1 == 0) goto L_0x0014
            r9 = r13
            r12.m2986a((kshark.internal.PathFinder.State) r13, (long) r4, (boolean) r8)
            goto L_0x009d
        L_0x0014:
            r9 = r13
            boolean r1 = r0 instanceof kshark.HeapObject.HeapInstance
            if (r1 == 0) goto L_0x005d
            r8 = r0
            kshark.HeapObject$HeapInstance r8 = (kshark.HeapObject.HeapInstance) r8
            java.lang.String r0 = r8.getInstanceClassName()
            java.lang.String r10 = "java.lang.String"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
            if (r0 == 0) goto L_0x0053
            r6 = 1
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r16
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            java.lang.String r0 = "value"
            kshark.HeapField r0 = r8.get((java.lang.String) r10, (java.lang.String) r0)
            if (r0 == 0) goto L_0x0044
            kshark.HeapValue r0 = r0.getValue()
            if (r0 == 0) goto L_0x0044
            java.lang.Long r0 = r0.getAsObjectId()
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == 0) goto L_0x009d
            long r4 = r0.longValue()
            r6 = 1
            r0 = r12
            r1 = r13
            r2 = r14
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            goto L_0x009d
        L_0x0053:
            r6 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r16
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            goto L_0x009d
        L_0x005d:
            boolean r1 = r0 instanceof kshark.HeapObject.HeapObjectArray
            if (r1 == 0) goto L_0x0094
            r10 = r0
            kshark.HeapObject$HeapObjectArray r10 = (kshark.HeapObject.HeapObjectArray) r10
            boolean r0 = r10.isPrimitiveWrapperArray()
            if (r0 == 0) goto L_0x008a
            r6 = 1
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r16
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            kshark.HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord r0 = r10.readRecord()
            long[] r10 = r0.getElementIds()
            int r11 = r10.length
        L_0x007c:
            if (r8 >= r11) goto L_0x009d
            r4 = r10[r8]
            r6 = 1
            r0 = r12
            r1 = r13
            r2 = r14
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            int r8 = r8 + 1
            goto L_0x007c
        L_0x008a:
            r6 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r16
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
            goto L_0x009d
        L_0x0094:
            r6 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r16
            r0.m2985a((kshark.internal.PathFinder.State) r1, (long) r2, (long) r4, (boolean) r6)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.PathFinder.m2984a(kshark.internal.PathFinder$State, long, long):void");
    }

    /* renamed from: a */
    private final void m2985a(State state, long j, long j2, boolean z) {
        int slot = state.getDominatedObjectIds().getSlot(j2);
        if (slot != -1 || (!state.getVisitedSet().contains(j2) && !state.getToVisitSet().contains(Long.valueOf(j2)) && !state.getToVisitLastSet().contains(Long.valueOf(j2)))) {
            int slot2 = state.getDominatedObjectIds().getSlot(j);
            boolean contains = state.getLeakingObjectIds().contains(Long.valueOf(j));
            if (contains || slot2 != -1) {
                if (!contains) {
                    j = state.getDominatedObjectIds().getSlotValue(slot2);
                }
                if (slot == -1) {
                    state.getDominatedObjectIds().set(j2, j);
                    return;
                }
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                boolean z2 = false;
                boolean z3 = false;
                while (!z3) {
                    arrayList.add(Long.valueOf(j));
                    int slot3 = state.getDominatedObjectIds().getSlot(j);
                    if (slot3 == -1) {
                        z3 = true;
                    } else {
                        j = state.getDominatedObjectIds().getSlotValue(slot3);
                    }
                }
                long slotValue = state.getDominatedObjectIds().getSlotValue(slot);
                while (!z2) {
                    arrayList2.add(Long.valueOf(slotValue));
                    int slot4 = state.getDominatedObjectIds().getSlot(slotValue);
                    if (slot4 == -1) {
                        z2 = true;
                    } else {
                        slotValue = state.getDominatedObjectIds().getSlotValue(slot4);
                    }
                }
                Long l = null;
                Iterator it = arrayList.iterator();
                loop2:
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    long longValue = ((Number) it.next()).longValue();
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            long longValue2 = ((Number) it2.next()).longValue();
                            if (longValue2 == longValue) {
                                l = Long.valueOf(longValue2);
                                break loop2;
                            }
                        }
                    }
                }
                if (l == null) {
                    state.getDominatedObjectIds().remove(j2);
                    if (z) {
                        state.getVisitedSet().add(j2);
                        return;
                    }
                    return;
                }
                state.getDominatedObjectIds().set(j2, l.longValue());
                return;
            }
            if (z) {
                state.getVisitedSet().add(j2);
            }
            if (slot != -1) {
                state.getDominatedObjectIds().remove(j2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        r7 = r7.getValue();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2983a(kshark.internal.PathFinder.State r6, long r7) {
        /*
            r5 = this;
            kshark.HeapGraph r0 = r5.f4661g
            kshark.HeapObject r0 = r0.findObjectById(r7)
            boolean r1 = r0 instanceof kshark.HeapObject.HeapClass
            r2 = 0
            if (r1 == 0) goto L_0x000f
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r2)
            goto L_0x0070
        L_0x000f:
            boolean r1 = r0 instanceof kshark.HeapObject.HeapInstance
            r3 = 1
            if (r1 == 0) goto L_0x0047
            kshark.HeapObject$HeapInstance r0 = (kshark.HeapObject.HeapInstance) r0
            java.lang.String r1 = r0.getInstanceClassName()
            java.lang.String r4 = "java.lang.String"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x0043
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r3)
            java.lang.String r7 = "value"
            kshark.HeapField r7 = r0.get((java.lang.String) r4, (java.lang.String) r7)
            if (r7 == 0) goto L_0x0038
            kshark.HeapValue r7 = r7.getValue()
            if (r7 == 0) goto L_0x0038
            java.lang.Long r7 = r7.getAsObjectId()
            goto L_0x0039
        L_0x0038:
            r7 = 0
        L_0x0039:
            if (r7 == 0) goto L_0x0070
            long r7 = r7.longValue()
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r3)
            goto L_0x0070
        L_0x0043:
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r2)
            goto L_0x0070
        L_0x0047:
            boolean r1 = r0 instanceof kshark.HeapObject.HeapObjectArray
            if (r1 == 0) goto L_0x006d
            kshark.HeapObject$HeapObjectArray r0 = (kshark.HeapObject.HeapObjectArray) r0
            boolean r1 = r0.isPrimitiveWrapperArray()
            if (r1 == 0) goto L_0x0069
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r3)
            kshark.HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord r7 = r0.readRecord()
            long[] r7 = r7.getElementIds()
            int r8 = r7.length
        L_0x005f:
            if (r2 >= r8) goto L_0x0070
            r0 = r7[r2]
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r0, (boolean) r3)
            int r2 = r2 + 1
            goto L_0x005f
        L_0x0069:
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r2)
            goto L_0x0070
        L_0x006d:
            r5.m2986a((kshark.internal.PathFinder.State) r6, (long) r7, (boolean) r2)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.PathFinder.m2983a(kshark.internal.PathFinder$State, long):void");
    }

    /* renamed from: a */
    private final void m2986a(State state, long j, boolean z) {
        state.getDominatedObjectIds().remove(j);
        if (z) {
            state.getVisitedSet().add(j);
        }
    }
}

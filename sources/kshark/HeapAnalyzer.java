package kshark;

import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p245io.CloseableKt;
import kotlin.sequences.SequencesKt;
import kshark.HeapObject;
import kshark.HprofHeapGraph;
import kshark.LeakTraceObject;
import kshark.OnAnalysisProgressListener;
import kshark.SharkLog;
import kshark.internal.PathFinder;
import kshark.internal.ReferencePathNode;
import kshark.internal.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002LMB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0017JV\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010J(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010J&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$0\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0010J\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0010J\u001c\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020*01J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u001dJ\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u0013J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u000208J,\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020*2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002080\u00102\u0006\u0010=\u001a\u00020>2\u0006\u0010.\u001a\u00020/J*\u0010?\u001a\u00020@*\u00020A2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u00109\u001a\u000208J*\u0010B\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00100$*\u00020A2\u0006\u0010E\u001a\u00020FJ\u001a\u0010G\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0010*\u00020A2\u0006\u0010E\u001a\u00020FJ8\u0010H\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00100$*\u00020A2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002080J2\u0006\u0010K\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006N"}, mo175978d2 = {"Lkshark/HeapAnalyzer;", "", "listener", "Lkshark/OnAnalysisProgressListener;", "(Lkshark/OnAnalysisProgressListener;)V", "getListener", "()Lkshark/OnAnalysisProgressListener;", "analyze", "Lkshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "graph", "Lkshark/HeapGraph;", "leakingObjectFinder", "Lkshark/LeakingObjectFinder;", "referenceMatchers", "", "Lkshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lkshark/ObjectInspector;", "metadataExtractor", "Lkshark/MetadataExtractor;", "proguardMapping", "Lkshark/ProguardMapping;", "buildLeakTraceObjects", "Lkshark/LeakTraceObject;", "pathHeapObjects", "Lkshark/HeapObject;", "buildReferencePath", "Lkshark/LeakTraceReference;", "shortestChildPath", "Lkshark/internal/ReferencePathNode$ChildNode;", "leakTraceObjects", "computeLeakStatuses", "Lkotlin/Pair;", "Lkshark/LeakTraceObject$LeakingStatus;", "", "leakReporters", "Lkshark/ObjectReporter;", "deduplicateShortestPaths", "Lkshark/internal/ReferencePathNode;", "inputPathResults", "findResultsInTrie", "", "parentNode", "Lkshark/HeapAnalyzer$TrieNode$ParentNode;", "outputPathResults", "", "recordClassName", "heap", "resolveStatus", "reporter", "leakingWins", "since", "", "analysisStartNanoTime", "updateTrie", "pathNode", "path", "pathIndex", "", "analyzeGraph", "Lkshark/HeapAnalysisSuccess;", "Lkshark/HeapAnalyzer$FindLeakInput;", "buildLeakTraces", "Lkshark/ApplicationLeak;", "Lkshark/LibraryLeak;", "pathFindingResults", "Lkshark/internal/PathFinder$PathFindingResults;", "computeRetainedSizes", "findLeaks", "leakingObjectIds", "", "enableSameInstanceThreshold", "FindLeakInput", "TrieNode", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalyzer.kt */
public final class HeapAnalyzer {

    /* renamed from: a */
    private final OnAnalysisProgressListener f4535a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 1;
            $EnumSwitchMapping$0[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 2;
            $EnumSwitchMapping$0[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 3;
            int[] iArr2 = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 2;
            $EnumSwitchMapping$1[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 3;
            int[] iArr3 = new int[LeakTraceObject.LeakingStatus.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[LeakTraceObject.LeakingStatus.UNKNOWN.ordinal()] = 1;
            $EnumSwitchMapping$2[LeakTraceObject.LeakingStatus.LEAKING.ordinal()] = 2;
            $EnumSwitchMapping$2[LeakTraceObject.LeakingStatus.NOT_LEAKING.ordinal()] = 3;
        }
    }

    public HeapAnalyzer(OnAnalysisProgressListener onAnalysisProgressListener) {
        Intrinsics.checkParameterIsNotNull(onAnalysisProgressListener, "listener");
        this.f4535a = onAnalysisProgressListener;
    }

    public final OnAnalysisProgressListener getListener() {
        return this.f4535a;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lkshark/HeapAnalyzer$FindLeakInput;", "", "graph", "Lkshark/HeapGraph;", "referenceMatchers", "", "Lkshark/ReferenceMatcher;", "computeRetainedHeapSize", "", "objectInspectors", "Lkshark/ObjectInspector;", "(Lkshark/HeapGraph;Ljava/util/List;ZLjava/util/List;)V", "getComputeRetainedHeapSize", "()Z", "getGraph", "()Lkshark/HeapGraph;", "getObjectInspectors", "()Ljava/util/List;", "getReferenceMatchers", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalyzer.kt */
    public static final class FindLeakInput {
        private final boolean computeRetainedHeapSize;
        private final HeapGraph graph;
        private final List<ObjectInspector> objectInspectors;
        private final List<ReferenceMatcher> referenceMatchers;

        public FindLeakInput(HeapGraph heapGraph, List<? extends ReferenceMatcher> list, boolean z, List<? extends ObjectInspector> list2) {
            Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
            Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
            this.graph = heapGraph;
            this.referenceMatchers = list;
            this.computeRetainedHeapSize = z;
            this.objectInspectors = list2;
        }

        public final HeapGraph getGraph() {
            return this.graph;
        }

        public final List<ReferenceMatcher> getReferenceMatchers() {
            return this.referenceMatchers;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final List<ObjectInspector> getObjectInspectors() {
            return this.objectInspectors;
        }
    }

    public static /* synthetic */ HeapAnalysis analyze$default(HeapAnalyzer heapAnalyzer, File file, LeakingObjectFinder leakingObjectFinder, List list, boolean z, List list2, MetadataExtractor metadataExtractor, ProguardMapping proguardMapping, int i, Object obj) {
        return heapAnalyzer.analyze(file, leakingObjectFinder, (List<? extends ReferenceMatcher>) (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? false : z, (List<? extends ObjectInspector>) (i & 16) != 0 ? CollectionsKt.emptyList() : list2, (i & 32) != 0 ? MetadataExtractor.Companion.getNO_OP() : metadataExtractor, (i & 64) != 0 ? null : proguardMapping);
    }

    public final HeapAnalysis analyze(File file, LeakingObjectFinder leakingObjectFinder, List<? extends ReferenceMatcher> list, boolean z, List<? extends ObjectInspector> list2, MetadataExtractor metadataExtractor, ProguardMapping proguardMapping) {
        Throwable th;
        File file2 = file;
        List<? extends ReferenceMatcher> list3 = list;
        List<? extends ObjectInspector> list4 = list2;
        Intrinsics.checkParameterIsNotNull(file2, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
        Intrinsics.checkParameterIsNotNull(list3, "referenceMatchers");
        Intrinsics.checkParameterIsNotNull(list4, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
        long nanoTime = System.nanoTime();
        if (!file.exists()) {
            return new HeapAnalysisFailure(file, System.currentTimeMillis(), since(nanoTime), new HeapAnalysisException(new IllegalArgumentException("File does not exist: " + file2)));
        }
        try {
            this.f4535a.onAnalysisProgress(OnAnalysisProgressListener.Step.PARSING_HEAP_DUMP);
            Closeable open = Hprof.Companion.open(file2);
            Throwable th2 = null;
            try {
                HeapAnalysisSuccess analyzeGraph = analyzeGraph(new FindLeakInput(HprofHeapGraph.Companion.indexHprof$default(HprofHeapGraph.Companion, (Hprof) open, proguardMapping, (Set) null, 4, (Object) null), list3, z, list4), metadataExtractor, leakingObjectFinder, file, nanoTime);
                CloseableKt.closeFinally(open, th2);
                return analyzeGraph;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(open, th);
                throw th4;
            }
        } catch (Throwable th5) {
            return new HeapAnalysisFailure(file, System.currentTimeMillis(), since(nanoTime), new HeapAnalysisException(th5));
        }
    }

    public static /* synthetic */ HeapAnalysis analyze$default(HeapAnalyzer heapAnalyzer, File file, HeapGraph heapGraph, LeakingObjectFinder leakingObjectFinder, List list, boolean z, List list2, MetadataExtractor metadataExtractor, int i, Object obj) {
        return heapAnalyzer.analyze(file, heapGraph, leakingObjectFinder, (List<? extends ReferenceMatcher>) (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? false : z, (List<? extends ObjectInspector>) (i & 32) != 0 ? CollectionsKt.emptyList() : list2, (i & 64) != 0 ? MetadataExtractor.Companion.getNO_OP() : metadataExtractor);
    }

    public final HeapAnalysis analyze(File file, HeapGraph heapGraph, LeakingObjectFinder leakingObjectFinder, List<? extends ReferenceMatcher> list, boolean z, List<? extends ObjectInspector> list2, MetadataExtractor metadataExtractor) {
        HeapGraph heapGraph2 = heapGraph;
        List<? extends ReferenceMatcher> list3 = list;
        List<? extends ObjectInspector> list4 = list2;
        File file2 = file;
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(heapGraph2, "graph");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder, "leakingObjectFinder");
        Intrinsics.checkParameterIsNotNull(list3, "referenceMatchers");
        Intrinsics.checkParameterIsNotNull(list4, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(metadataExtractor, "metadataExtractor");
        long nanoTime = System.nanoTime();
        try {
            HeapAnalysis analyzeGraph = analyzeGraph(new FindLeakInput(heapGraph2, list3, z, list4), metadataExtractor, leakingObjectFinder, file, nanoTime);
            return analyzeGraph;
        } catch (Throwable th) {
            return new HeapAnalysisFailure(file, System.currentTimeMillis(), since(nanoTime), new HeapAnalysisException(th));
        }
    }

    public final HeapAnalysisSuccess analyzeGraph(FindLeakInput findLeakInput, MetadataExtractor metadataExtractor, LeakingObjectFinder leakingObjectFinder, File file, long j) {
        FindLeakInput findLeakInput2 = findLeakInput;
        MetadataExtractor metadataExtractor2 = metadataExtractor;
        LeakingObjectFinder leakingObjectFinder2 = leakingObjectFinder;
        Intrinsics.checkParameterIsNotNull(findLeakInput, "$this$analyzeGraph");
        Intrinsics.checkParameterIsNotNull(metadataExtractor2, "metadataExtractor");
        Intrinsics.checkParameterIsNotNull(leakingObjectFinder2, "leakingObjectFinder");
        File file2 = file;
        Intrinsics.checkParameterIsNotNull(file2, "heapDumpFile");
        this.f4535a.onAnalysisProgress(OnAnalysisProgressListener.Step.EXTRACTING_METADATA);
        Map<String, String> extractMetadata = metadataExtractor2.extractMetadata(findLeakInput.getGraph());
        this.f4535a.onAnalysisProgress(OnAnalysisProgressListener.Step.FINDING_RETAINED_OBJECTS);
        Pair<List<ApplicationLeak>, List<LibraryLeak>> findLeaks = findLeaks(findLeakInput, leakingObjectFinder2.findLeakingObjectIds(findLeakInput.getGraph()), false);
        return new HeapAnalysisSuccess(file2, System.currentTimeMillis(), since(j), extractMetadata, findLeaks.component1(), findLeaks.component2());
    }

    public final Pair<List<ApplicationLeak>, List<LibraryLeak>> findLeaks(FindLeakInput findLeakInput, Set<Long> set, boolean z) {
        Intrinsics.checkParameterIsNotNull(findLeakInput, "$this$findLeaks");
        Intrinsics.checkParameterIsNotNull(set, "leakingObjectIds");
        SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
        if (logger != null) {
            logger.mo23715d("start findLeaks");
        }
        PathFinder.PathFindingResults findPathsFromGcRoots = new PathFinder(findLeakInput.getGraph(), this.f4535a, findLeakInput.getReferenceMatchers(), z).findPathsFromGcRoots(set, findLeakInput.getComputeRetainedHeapSize());
        SharkLog.Logger logger2 = SharkLog.INSTANCE.getLogger();
        if (logger2 != null) {
            logger2.mo23715d("Found " + set.size() + " retained objects");
        }
        return buildLeakTraces(findLeakInput, findPathsFromGcRoots);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/HeapAnalyzer$TrieNode;", "", "()V", "objectId", "", "getObjectId", "()J", "LeafNode", "ParentNode", "Lkshark/HeapAnalyzer$TrieNode$ParentNode;", "Lkshark/HeapAnalyzer$TrieNode$LeafNode;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalyzer.kt */
    public static abstract class TrieNode {
        public abstract long getObjectId();

        private TrieNode() {
        }

        public /* synthetic */ TrieNode(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, mo175978d2 = {"Lkshark/HeapAnalyzer$TrieNode$ParentNode;", "Lkshark/HeapAnalyzer$TrieNode;", "objectId", "", "(J)V", "children", "", "getChildren", "()Ljava/util/Map;", "getObjectId", "()J", "toString", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: HeapAnalyzer.kt */
        public static final class ParentNode extends TrieNode {
            private final Map<Long, TrieNode> children = new LinkedHashMap();
            private final long objectId;

            public ParentNode(long j) {
                super((DefaultConstructorMarker) null);
                this.objectId = j;
            }

            public long getObjectId() {
                return this.objectId;
            }

            public final Map<Long, TrieNode> getChildren() {
                return this.children;
            }

            public String toString() {
                return "ParentNode(objectId=" + getObjectId() + ", children=" + this.children + VersionRange.RIGHT_OPEN;
            }
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/HeapAnalyzer$TrieNode$LeafNode;", "Lkshark/HeapAnalyzer$TrieNode;", "objectId", "", "pathNode", "Lkshark/internal/ReferencePathNode;", "(JLkshark/internal/ReferencePathNode;)V", "getObjectId", "()J", "getPathNode", "()Lkshark/internal/ReferencePathNode;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
        /* compiled from: HeapAnalyzer.kt */
        public static final class LeafNode extends TrieNode {
            private final long objectId;
            private final ReferencePathNode pathNode;

            public long getObjectId() {
                return this.objectId;
            }

            public final ReferencePathNode getPathNode() {
                return this.pathNode;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LeafNode(long j, ReferencePathNode referencePathNode) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkParameterIsNotNull(referencePathNode, "pathNode");
                this.objectId = j;
                this.pathNode = referencePathNode;
            }
        }
    }

    public final List<ReferencePathNode> deduplicateShortestPaths(List<? extends ReferencePathNode> list) {
        Intrinsics.checkParameterIsNotNull(list, "inputPathResults");
        SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
        if (logger != null) {
            logger.mo23715d("start deduplicateShortestPaths");
        }
        TrieNode.ParentNode parentNode = new TrieNode.ParentNode(0);
        for (ReferencePathNode referencePathNode : list) {
            List arrayList = new ArrayList();
            ReferencePathNode referencePathNode2 = referencePathNode;
            while (referencePathNode2 instanceof ReferencePathNode.ChildNode) {
                arrayList.add(0, Long.valueOf(referencePathNode2.getObjectId()));
                referencePathNode2 = ((ReferencePathNode.ChildNode) referencePathNode2).getParent();
            }
            arrayList.add(0, Long.valueOf(referencePathNode2.getObjectId()));
            updateTrie(referencePathNode, arrayList, 0, parentNode);
        }
        List<ReferencePathNode> arrayList2 = new ArrayList<>();
        findResultsInTrie(parentNode, arrayList2);
        SharkLog.Logger logger2 = SharkLog.INSTANCE.getLogger();
        if (logger2 != null) {
            logger2.mo23715d("end deduplicateShortestPaths");
        }
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: kshark.HeapAnalyzer$TrieNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateTrie(kshark.internal.ReferencePathNode r5, java.util.List<java.lang.Long> r6, int r7, kshark.HeapAnalyzer.TrieNode.ParentNode r8) {
        /*
            r4 = this;
            java.lang.String r0 = "pathNode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "path"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "parentNode"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.Object r0 = r6.get(r7)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r6)
            if (r7 != r2) goto L_0x0030
            java.util.Map r6 = r8.getChildren()
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            kshark.HeapAnalyzer$TrieNode$LeafNode r8 = new kshark.HeapAnalyzer$TrieNode$LeafNode
            r8.<init>(r0, r5)
            r6.put(r7, r8)
            goto L_0x005a
        L_0x0030:
            java.util.Map r2 = r8.getChildren()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            java.lang.Object r2 = r2.get(r3)
            kshark.HeapAnalyzer$TrieNode r2 = (kshark.HeapAnalyzer.TrieNode) r2
            if (r2 == 0) goto L_0x0041
            goto L_0x004f
        L_0x0041:
            kshark.HeapAnalyzer$updateTrie$childNode$1 r2 = new kshark.HeapAnalyzer$updateTrie$childNode$1
            r2.<init>(r0, r8)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r8 = r2.invoke()
            r2 = r8
            kshark.HeapAnalyzer$TrieNode r2 = (kshark.HeapAnalyzer.TrieNode) r2
        L_0x004f:
            boolean r8 = r2 instanceof kshark.HeapAnalyzer.TrieNode.ParentNode
            if (r8 == 0) goto L_0x005a
            int r7 = r7 + 1
            kshark.HeapAnalyzer$TrieNode$ParentNode r2 = (kshark.HeapAnalyzer.TrieNode.ParentNode) r2
            r4.updateTrie(r5, r6, r7, r2)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.HeapAnalyzer.updateTrie(kshark.internal.ReferencePathNode, java.util.List, int, kshark.HeapAnalyzer$TrieNode$ParentNode):void");
    }

    public final void findResultsInTrie(TrieNode.ParentNode parentNode, List<ReferencePathNode> list) {
        Intrinsics.checkParameterIsNotNull(parentNode, "parentNode");
        Intrinsics.checkParameterIsNotNull(list, "outputPathResults");
        for (TrieNode trieNode : parentNode.getChildren().values()) {
            if (trieNode instanceof TrieNode.ParentNode) {
                findResultsInTrie((TrieNode.ParentNode) trieNode, list);
            } else if (trieNode instanceof TrieNode.LeafNode) {
                list.add(((TrieNode.LeafNode) trieNode).getPathNode());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0068, code lost:
        r7 = r6.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Integer> computeRetainedSizes(kshark.HeapAnalyzer.FindLeakInput r11, kshark.internal.PathFinder.PathFindingResults r12) {
        /*
            r10 = this;
            java.lang.String r0 = "$this$computeRetainedSizes"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = "pathFindingResults"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            boolean r0 = r11.getComputeRetainedHeapSize()
            r1 = 0
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x001f
            java.lang.String r2 = "start computeRetainedSizes"
            r0.mo23715d(r2)
        L_0x001f:
            java.util.List r0 = r12.getPathsToLeakingObjects()
            kshark.internal.hppc.LongLongScatterMap r12 = r12.getDominatedObjectIds()
            kshark.OnAnalysisProgressListener r2 = r10.f4535a
            kshark.OnAnalysisProgressListener$Step r3 = kshark.OnAnalysisProgressListener.Step.COMPUTING_NATIVE_RETAINED_SIZE
            r2.onAnalysisProgress(r3)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            kshark.HeapAnalyzer$computeRetainedSizes$nativeSizes$1 r3 = kshark.HeapAnalyzer$computeRetainedSizes$nativeSizes$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.util.Map r2 = kotlin.collections.MapsKt.withDefaultMutable(r2, r3)
            kshark.HeapGraph r3 = r11.getGraph()
            kotlin.sequences.Sequence r3 = r3.getInstances()
            kshark.HeapAnalyzer$computeRetainedSizes$2 r4 = kshark.HeapAnalyzer$computeRetainedSizes$2.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.sequences.Sequence r3 = kotlin.sequences.SequencesKt.filter(r3, r4)
            java.util.Iterator r3 = r3.iterator()
        L_0x0051:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x00f9
            java.lang.Object r4 = r3.next()
            kshark.HeapObject$HeapInstance r4 = (kshark.HeapObject.HeapInstance) r4
            java.lang.String r6 = "sun.misc.Cleaner"
            java.lang.String r7 = "thunk"
            kshark.HeapField r6 = r4.get((java.lang.String) r6, (java.lang.String) r7)
            if (r6 == 0) goto L_0x0073
            kshark.HeapValue r7 = r6.getValue()
            if (r7 == 0) goto L_0x0073
            java.lang.Long r7 = r7.getAsNonNullObjectId()
            goto L_0x0074
        L_0x0073:
            r7 = r1
        L_0x0074:
            java.lang.String r8 = "java.lang.ref.Reference"
            java.lang.String r9 = "referent"
            kshark.HeapField r4 = r4.get((java.lang.String) r8, (java.lang.String) r9)
            if (r4 == 0) goto L_0x0089
            kshark.HeapValue r4 = r4.getValue()
            if (r4 == 0) goto L_0x0089
            java.lang.Long r4 = r4.getAsNonNullObjectId()
            goto L_0x008a
        L_0x0089:
            r4 = r1
        L_0x008a:
            if (r7 == 0) goto L_0x0051
            if (r4 == 0) goto L_0x0051
            kshark.HeapValue r6 = r6.getValue()
            kshark.HeapObject r6 = r6.getAsObject()
            boolean r7 = r6 instanceof kshark.HeapObject.HeapInstance
            if (r7 == 0) goto L_0x0051
            kshark.HeapObject$HeapInstance r6 = (kshark.HeapObject.HeapInstance) r6
            java.lang.String r7 = "libcore.util.NativeAllocationRegistry$CleanerThunk"
            boolean r8 = r6.instanceOf((java.lang.String) r7)
            if (r8 == 0) goto L_0x0051
            java.lang.String r8 = "this$0"
            kshark.HeapField r6 = r6.get((java.lang.String) r7, (java.lang.String) r8)
            if (r6 == 0) goto L_0x0051
            kshark.HeapValue r7 = r6.getValue()
            boolean r7 = r7.isNonNullReference()
            if (r7 == 0) goto L_0x0051
            kshark.HeapValue r6 = r6.getValue()
            kshark.HeapObject r6 = r6.getAsObject()
            boolean r7 = r6 instanceof kshark.HeapObject.HeapInstance
            if (r7 == 0) goto L_0x0051
            kshark.HeapObject$HeapInstance r6 = (kshark.HeapObject.HeapInstance) r6
            java.lang.String r7 = "libcore.util.NativeAllocationRegistry"
            boolean r8 = r6.instanceOf((java.lang.String) r7)
            if (r8 == 0) goto L_0x0051
            java.lang.Object r8 = kotlin.collections.MapsKt.getValue(r2, r4)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.String r9 = "size"
            kshark.HeapField r6 = r6.get((java.lang.String) r7, (java.lang.String) r9)
            if (r6 == 0) goto L_0x00ef
            kshark.HeapValue r6 = r6.getValue()
            if (r6 == 0) goto L_0x00ef
            java.lang.Long r6 = r6.getAsLong()
            if (r6 == 0) goto L_0x00ef
            long r5 = r6.longValue()
            int r5 = (int) r5
        L_0x00ef:
            int r8 = r8 + r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r2.put(r4, r5)
            goto L_0x0051
        L_0x00f9:
            kshark.OnAnalysisProgressListener r1 = r10.f4535a
            kshark.OnAnalysisProgressListener$Step r3 = kshark.OnAnalysisProgressListener.Step.COMPUTING_RETAINED_SIZE
            r1.onAnalysisProgress(r3)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            kshark.HeapAnalyzer$computeRetainedSizes$sizeByDominator$1 r3 = kshark.HeapAnalyzer$computeRetainedSizes$sizeByDominator$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.util.Map r1 = kotlin.collections.MapsKt.withDefaultMutable(r1, r3)
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r4 = r0.iterator()
        L_0x011c:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0167
            java.lang.Object r6 = r4.next()
            kshark.internal.ReferencePathNode r6 = (kshark.internal.ReferencePathNode) r6
            long r6 = r6.getObjectId()
            java.lang.Long r8 = java.lang.Long.valueOf(r6)
            r3.add(r8)
            kshark.HeapGraph r8 = r11.getGraph()
            kshark.HeapObject r8 = r8.findObjectById(r6)
            kshark.HeapObject$HeapInstance r8 = r8.getAsInstance()
            if (r8 != 0) goto L_0x0144
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0144:
            kshark.HeapObject$HeapClass r8 = r8.getInstanceClass()
            java.lang.Long r9 = java.lang.Long.valueOf(r6)
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r1, r9)
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r8 = r8.getInstanceByteSize()
            int r9 = r9 + r8
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            r1.put(r6, r7)
            goto L_0x011c
        L_0x0167:
            kshark.HeapAnalyzer$computeRetainedSizes$5 r4 = new kshark.HeapAnalyzer$computeRetainedSizes$5
            r4.<init>(r11, r3, r1, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r12.forEach(r4)
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef
            r11.<init>()
        L_0x0176:
            r11.element = r5
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r4)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r4 = r0.iterator()
        L_0x0189:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x01a1
            java.lang.Object r6 = r4.next()
            kshark.internal.ReferencePathNode r6 = (kshark.internal.ReferencePathNode) r6
            long r6 = r6.getObjectId()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r2.add(r6)
            goto L_0x0189
        L_0x01a1:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01a9:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x01fd
            java.lang.Object r4 = r2.next()
            java.lang.Number r4 = (java.lang.Number) r4
            long r6 = r4.longValue()
            int r4 = r12.getSlot(r6)
            r8 = -1
            if (r4 == r8) goto L_0x01a9
            long r8 = r12.getSlotValue(r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r6)
            java.lang.Object r4 = kotlin.collections.MapsKt.getValue(r1, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x01a9
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r1.put(r6, r7)
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            java.lang.Object r6 = kotlin.collections.MapsKt.getValue(r1, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            java.lang.Long r7 = java.lang.Long.valueOf(r8)
            int r4 = r4 + r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.put(r7, r4)
            r4 = 1
            r11.element = r4
            goto L_0x01a9
        L_0x01fd:
            boolean r2 = r11.element
            if (r2 != 0) goto L_0x0176
            r12.release()
            java.util.ArrayList r11 = new java.util.ArrayList
            int r12 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r11.<init>(r12)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r12 = r0.iterator()
        L_0x0213:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x023e
            java.lang.Object r0 = r12.next()
            kshark.internal.ReferencePathNode r0 = (kshark.internal.ReferencePathNode) r0
            long r2 = r0.getObjectId()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r1.get(r0)
            if (r0 != 0) goto L_0x0230
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0230:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.add(r0)
            goto L_0x0213
        L_0x023e:
            java.util.List r11 = (java.util.List) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.HeapAnalyzer.computeRetainedSizes(kshark.HeapAnalyzer$FindLeakInput, kshark.internal.PathFinder$PathFindingResults):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: kshark.internal.ReferencePathNode$LibraryLeakNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: kshark.internal.ReferencePathNode$LibraryLeakNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: kshark.internal.ReferencePathNode$ChildNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: kshark.internal.ReferencePathNode$LibraryLeakNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.util.List<kshark.ApplicationLeak>, java.util.List<kshark.LibraryLeak>> buildLeakTraces(kshark.HeapAnalyzer.FindLeakInput r14, kshark.internal.PathFinder.PathFindingResults r15) {
        /*
            r13 = this;
            java.lang.String r0 = "$this$buildLeakTraces"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.lang.String r0 = "pathFindingResults"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x0017
            java.lang.String r1 = "start buildLeakTraces"
            r0.mo23715d(r1)
        L_0x0017:
            java.util.List r0 = r13.computeRetainedSizes(r14, r15)
            kshark.OnAnalysisProgressListener r1 = r13.f4535a
            kshark.OnAnalysisProgressListener$Step r2 = kshark.OnAnalysisProgressListener.Step.BUILDING_LEAK_TRACES
            r1.onAnalysisProgress(r2)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.util.List r3 = r15.getPathsToLeakingObjects()
            java.util.List r3 = r13.deduplicateShortestPaths(r3)
            int r4 = r3.size()
            java.util.List r5 = r15.getPathsToLeakingObjects()
            int r5 = r5.size()
            java.lang.String r6 = "Found "
            if (r4 == r5) goto L_0x0081
            kshark.SharkLog r4 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r4 = r4.getLogger()
            if (r4 == 0) goto L_0x00a4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            java.util.List r15 = r15.getPathsToLeakingObjects()
            int r15 = r15.size()
            r5.append(r15)
            java.lang.String r15 = " paths to retained objects,"
            r5.append(r15)
            java.lang.String r15 = " down to "
            r5.append(r15)
            int r15 = r3.size()
            r5.append(r15)
            java.lang.String r15 = " after removing duplicated paths"
            r5.append(r15)
            java.lang.String r15 = r5.toString()
            r4.mo23715d(r15)
            goto L_0x00a4
        L_0x0081:
            kshark.SharkLog r15 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r15 = r15.getLogger()
            if (r15 == 0) goto L_0x00a4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            int r5 = r3.size()
            r4.append(r5)
            java.lang.String r5 = " paths to retained objects"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r15.mo23715d(r4)
        L_0x00a4:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r15 = r3.iterator()
            r3 = 0
            r4 = 0
        L_0x00ac:
            boolean r5 = r15.hasNext()
            if (r5 == 0) goto L_0x01a5
            java.lang.Object r5 = r15.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x00bd
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00bd:
            kshark.internal.ReferencePathNode r5 = (kshark.internal.ReferencePathNode) r5
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
        L_0x00cd:
            boolean r9 = r5 instanceof kshark.internal.ReferencePathNode.ChildNode
            if (r9 == 0) goto L_0x00ea
            r8.add(r3, r5)
            kshark.HeapGraph r9 = r14.getGraph()
            long r10 = r5.getObjectId()
            kshark.HeapObject r9 = r9.findObjectById(r10)
            r7.add(r3, r9)
            kshark.internal.ReferencePathNode$ChildNode r5 = (kshark.internal.ReferencePathNode.ChildNode) r5
            kshark.internal.ReferencePathNode r5 = r5.getParent()
            goto L_0x00cd
        L_0x00ea:
            if (r5 == 0) goto L_0x019d
            kshark.internal.ReferencePathNode$RootNode r5 = (kshark.internal.ReferencePathNode.RootNode) r5
            kshark.HeapGraph r9 = r14.getGraph()
            long r10 = r5.getObjectId()
            kshark.HeapObject r9 = r9.findObjectById(r10)
            r7.add(r3, r9)
            java.util.List r9 = r14.getObjectInspectors()
            java.util.List r7 = r13.buildLeakTraceObjects(r9, r7)
            java.util.List r9 = r13.buildReferencePath(r8, r7)
            kshark.LeakTrace r10 = new kshark.LeakTrace
            kshark.LeakTrace$GcRootType$Companion r11 = kshark.LeakTrace.GcRootType.Companion
            kshark.GcRoot r12 = r5.getGcRoot()
            kshark.LeakTrace$GcRootType r11 = r11.fromGcRoot(r12)
            java.lang.Object r7 = kotlin.collections.CollectionsKt.last(r7)
            kshark.LeakTraceObject r7 = (kshark.LeakTraceObject) r7
            r12 = 0
            if (r0 == 0) goto L_0x0125
            java.lang.Object r4 = r0.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            goto L_0x0126
        L_0x0125:
            r4 = r12
        L_0x0126:
            r10.<init>(r11, r9, r7, r4)
            boolean r4 = r5 instanceof kshark.internal.ReferencePathNode.LibraryLeakNode
            if (r4 == 0) goto L_0x0130
            kshark.internal.ReferencePathNode$LibraryLeakNode r5 = (kshark.internal.ReferencePathNode.LibraryLeakNode) r5
            goto L_0x014b
        L_0x0130:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r4 = r8.iterator()
        L_0x0136:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0148
            java.lang.Object r5 = r4.next()
            r7 = r5
            kshark.internal.ReferencePathNode$ChildNode r7 = (kshark.internal.ReferencePathNode.ChildNode) r7
            boolean r7 = r7 instanceof kshark.internal.ReferencePathNode.LibraryLeakNode
            if (r7 == 0) goto L_0x0136
            r12 = r5
        L_0x0148:
            r5 = r12
            kshark.internal.ReferencePathNode$LibraryLeakNode r5 = (kshark.internal.ReferencePathNode.LibraryLeakNode) r5
        L_0x014b:
            if (r5 == 0) goto L_0x017f
            kshark.LibraryLeakReferenceMatcher r4 = r5.getMatcher()
            kshark.ReferencePattern r5 = r4.getPattern()
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = kshark.internal.StringsKt.createSHA1Hash(r5)
            java.lang.Object r7 = r2.get(r5)
            if (r7 != 0) goto L_0x0171
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            kotlin.Pair r7 = kotlin.TuplesKt.m42317to(r4, r7)
            r2.put(r5, r7)
        L_0x0171:
            kotlin.Pair r7 = (kotlin.Pair) r7
            java.lang.Object r4 = r7.getSecond()
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r10)
            goto L_0x019a
        L_0x017f:
            java.lang.String r4 = r10.getSignature()
            java.lang.Object r5 = r1.get(r4)
            if (r5 != 0) goto L_0x0193
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            r1.put(r4, r5)
        L_0x0193:
            java.util.List r5 = (java.util.List) r5
            java.util.Collection r5 = (java.util.Collection) r5
            r5.add(r10)
        L_0x019a:
            r4 = r6
            goto L_0x00ac
        L_0x019d:
            kotlin.TypeCastException r14 = new kotlin.TypeCastException
            java.lang.String r15 = "null cannot be cast to non-null type kshark.internal.ReferencePathNode.RootNode"
            r14.<init>(r15)
            throw r14
        L_0x01a5:
            java.util.ArrayList r14 = new java.util.ArrayList
            int r15 = r1.size()
            r14.<init>(r15)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Set r15 = r1.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x01b8:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x01d3
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            kshark.ApplicationLeak r1 = new kshark.ApplicationLeak
            r1.<init>(r0)
            r14.add(r1)
            goto L_0x01b8
        L_0x01d3:
            java.util.List r14 = (java.util.List) r14
            java.util.ArrayList r15 = new java.util.ArrayList
            int r0 = r2.size()
            r15.<init>(r0)
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Set r0 = r2.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01e8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0217
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r1.component1()
            kshark.LibraryLeakReferenceMatcher r2 = (kshark.LibraryLeakReferenceMatcher) r2
            java.lang.Object r1 = r1.component2()
            java.util.List r1 = (java.util.List) r1
            kshark.LibraryLeak r3 = new kshark.LibraryLeak
            kshark.ReferencePattern r4 = r2.getPattern()
            java.lang.String r2 = r2.getDescription()
            r3.<init>(r1, r4, r2)
            r15.add(r3)
            goto L_0x01e8
        L_0x0217:
            java.util.List r15 = (java.util.List) r15
            kshark.SharkLog r0 = kshark.SharkLog.INSTANCE
            kshark.SharkLog$Logger r0 = r0.getLogger()
            if (r0 == 0) goto L_0x0226
            java.lang.String r1 = "end buildLeakTraces"
            r0.mo23715d(r1)
        L_0x0226:
            kotlin.Pair r14 = kotlin.TuplesKt.m42317to(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.HeapAnalyzer.buildLeakTraces(kshark.HeapAnalyzer$FindLeakInput, kshark.internal.PathFinder$PathFindingResults):kotlin.Pair");
    }

    public final List<LeakTraceObject> buildLeakTraceObjects(List<? extends ObjectInspector> list, List<? extends HeapObject> list2) {
        LeakTraceObject.ObjectType objectType;
        List<? extends ObjectInspector> list3 = list;
        List<? extends HeapObject> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list3, "objectInspectors");
        Intrinsics.checkParameterIsNotNull(list4, "pathHeapObjects");
        Iterable<HeapObject> iterable = list4;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (HeapObject objectReporter : iterable) {
            arrayList.add(new ObjectReporter(objectReporter));
        }
        List<ObjectReporter> list5 = (List) arrayList;
        for (ObjectInspector objectInspector : list3) {
            for (ObjectReporter inspect : list5) {
                objectInspector.inspect(inspect);
            }
        }
        List<Pair<LeakTraceObject.LeakingStatus, String>> computeLeakStatuses = computeLeakStatuses(list5);
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HeapObject heapObject = (HeapObject) next;
            ObjectReporter objectReporter2 = (ObjectReporter) list5.get(i);
            Pair pair = computeLeakStatuses.get(i);
            LeakTraceObject.LeakingStatus leakingStatus = (LeakTraceObject.LeakingStatus) pair.component1();
            String str = (String) pair.component2();
            String recordClassName = recordClassName(heapObject);
            if (heapObject instanceof HeapObject.HeapClass) {
                objectType = LeakTraceObject.ObjectType.CLASS;
            } else if ((heapObject instanceof HeapObject.HeapObjectArray) || (heapObject instanceof HeapObject.HeapPrimitiveArray)) {
                objectType = LeakTraceObject.ObjectType.ARRAY;
            } else {
                objectType = LeakTraceObject.ObjectType.INSTANCE;
            }
            arrayList2.add(new LeakTraceObject(heapObject.getObjectId(), objectType, recordClassName, objectReporter2.getLabels(), leakingStatus, str));
            i = i2;
        }
        return (List) arrayList2;
    }

    public final List<LeakTraceReference> buildReferencePath(List<? extends ReferencePathNode.ChildNode> list, List<LeakTraceObject> list2) {
        Intrinsics.checkParameterIsNotNull(list, "shortestChildPath");
        Intrinsics.checkParameterIsNotNull(list2, "leakTraceObjects");
        Iterable iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReferencePathNode.ChildNode childNode = (ReferencePathNode.ChildNode) next;
            arrayList.add(new LeakTraceReference(list2.get(i), childNode.getRefFromParentType(), childNode.getRefFromParentName(), childNode.getDeclaredClassName()));
            i = i2;
        }
        return (List) arrayList;
    }

    public final List<Pair<LeakTraceObject.LeakingStatus, String>> computeLeakStatuses(List<ObjectReporter> list) {
        int i;
        boolean z;
        Pair pair;
        Pair pair2;
        int i2;
        List<ObjectReporter> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "leakReporters");
        int size = list.size() - 1;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = size;
        ArrayList arrayList = new ArrayList();
        Iterable<ObjectReporter> iterable = list2;
        int i3 = 0;
        for (ObjectReporter resolveStatus : iterable) {
            Pair<LeakTraceObject.LeakingStatus, String> resolveStatus2 = resolveStatus(resolveStatus, i3 == size);
            if (i3 == size && (i2 = WhenMappings.$EnumSwitchMapping$0[resolveStatus2.getFirst().ordinal()]) != 1) {
                if (i2 == 2) {
                    resolveStatus2 = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.LEAKING, "This is the leaking object");
                } else if (i2 == 3) {
                    resolveStatus2 = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.LEAKING, "This is the leaking object. Conflicts with " + resolveStatus2.getSecond());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(resolveStatus2);
            LeakTraceObject.LeakingStatus component1 = resolveStatus2.component1();
            if (component1 == LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                intRef.element = i3;
                intRef2.element = size;
            } else if (component1 == LeakTraceObject.LeakingStatus.LEAKING && intRef2.element == size) {
                intRef2.element = i3;
            }
            i3++;
        }
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ObjectReporter heapObject : iterable) {
            arrayList2.add(StringsKt.lastSegment(recordClassName(heapObject.getHeapObject()), '.'));
        }
        List list3 = (List) arrayList2;
        int i4 = intRef.element;
        int i5 = 0;
        while (i5 < i4) {
            Pair pair3 = (Pair) arrayList.get(i5);
            LeakTraceObject.LeakingStatus leakingStatus = (LeakTraceObject.LeakingStatus) pair3.component1();
            String str = (String) pair3.component2();
            int i6 = i5 + 1;
            for (Number number : SequencesKt.generateSequence(Integer.valueOf(i6), new HeapAnalyzer$computeLeakStatuses$nextNotLeakingIndex$1(intRef))) {
                if (((LeakTraceObject.LeakingStatus) ((Pair) arrayList.get(number.intValue())).getFirst()) == LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                    String str2 = (String) list3.get(number.intValue());
                    int i7 = WhenMappings.$EnumSwitchMapping$1[leakingStatus.ordinal()];
                    if (i7 == 1) {
                        pair2 = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.NOT_LEAKING, str2 + "↓ is not leaking");
                    } else if (i7 == 2) {
                        pair2 = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.NOT_LEAKING, str2 + "↓ is not leaking and " + str);
                    } else if (i7 == 3) {
                        pair2 = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.NOT_LEAKING, str2 + "↓ is not leaking. Conflicts with " + str);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.set(i5, pair2);
                    i5 = i6;
                }
            }
            throw new NoSuchElementException("Sequence contains no element matching the predicate.");
        }
        int i8 = size - 1;
        if (intRef2.element < i8 && i8 >= (i = intRef2.element + 1)) {
            while (true) {
                Pair pair4 = (Pair) arrayList.get(i8);
                LeakTraceObject.LeakingStatus leakingStatus2 = (LeakTraceObject.LeakingStatus) pair4.component1();
                String str3 = (String) pair4.component2();
                for (Number number2 : SequencesKt.generateSequence(Integer.valueOf(i8 - 1), new HeapAnalyzer$computeLeakStatuses$previousLeakingIndex$1(intRef2))) {
                    if (((LeakTraceObject.LeakingStatus) ((Pair) arrayList.get(number2.intValue())).getFirst()) == LeakTraceObject.LeakingStatus.LEAKING) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        String str4 = (String) list3.get(number2.intValue());
                        int i9 = WhenMappings.$EnumSwitchMapping$2[leakingStatus2.ordinal()];
                        if (i9 == 1) {
                            pair = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.LEAKING, str4 + "↑ is leaking");
                        } else if (i9 == 2) {
                            pair = TuplesKt.m42317to(LeakTraceObject.LeakingStatus.LEAKING, str4 + "↑ is leaking and " + str3);
                        } else if (i9 != 3) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            throw new IllegalStateException("Should never happen");
                        }
                        arrayList.set(i8, pair);
                        if (i8 == i) {
                            break;
                        }
                        i8--;
                    }
                }
                throw new NoSuchElementException("Sequence contains no element matching the predicate.");
            }
        }
        return arrayList;
    }

    public final Pair<LeakTraceObject.LeakingStatus, String> resolveStatus(ObjectReporter objectReporter, boolean z) {
        String str;
        Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
        LeakTraceObject.LeakingStatus leakingStatus = LeakTraceObject.LeakingStatus.UNKNOWN;
        if (!objectReporter.getNotLeakingReasons().isEmpty()) {
            leakingStatus = LeakTraceObject.LeakingStatus.NOT_LEAKING;
            str = CollectionsKt.joinToString$default(objectReporter.getNotLeakingReasons(), " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } else {
            str = "";
        }
        Set<String> leakingReasons = objectReporter.getLeakingReasons();
        if (!leakingReasons.isEmpty()) {
            String joinToString$default = CollectionsKt.joinToString$default(leakingReasons, " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (leakingStatus != LeakTraceObject.LeakingStatus.NOT_LEAKING) {
                leakingStatus = LeakTraceObject.LeakingStatus.LEAKING;
                str = joinToString$default;
            } else if (z) {
                leakingStatus = LeakTraceObject.LeakingStatus.LEAKING;
                str = joinToString$default + ". Conflicts with " + str;
            } else {
                str = str + ". Conflicts with " + joinToString$default;
            }
        }
        return TuplesKt.m42317to(leakingStatus, str);
    }

    public final String recordClassName(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heap");
        if (heapObject instanceof HeapObject.HeapClass) {
            return ((HeapObject.HeapClass) heapObject).getName();
        }
        if (heapObject instanceof HeapObject.HeapInstance) {
            return ((HeapObject.HeapInstance) heapObject).getInstanceClassName();
        }
        if (heapObject instanceof HeapObject.HeapObjectArray) {
            return ((HeapObject.HeapObjectArray) heapObject).getArrayClassName();
        }
        if (heapObject instanceof HeapObject.HeapPrimitiveArray) {
            return ((HeapObject.HeapPrimitiveArray) heapObject).getArrayClassName();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final long since(long j) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
    }
}

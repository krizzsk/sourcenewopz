package kshark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.osgi.framework.AdminPermission;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\b\u0010,\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, mo175978d2 = {"Lkshark/HeapAnalysisSuccess;", "Lkshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "analysisDurationMillis", "metadata", "", "", "applicationLeaks", "", "Lkshark/ApplicationLeak;", "libraryLeaks", "Lkshark/LibraryLeak;", "(Ljava/io/File;JJLjava/util/Map;Ljava/util/List;Ljava/util/List;)V", "allLeaks", "Lkotlin/sequences/Sequence;", "Lkshark/Leak;", "getAllLeaks", "()Lkotlin/sequences/Sequence;", "getAnalysisDurationMillis", "()J", "getApplicationLeaks", "()Ljava/util/List;", "getCreatedAtTimeMillis", "getHeapDumpFile", "()Ljava/io/File;", "getLibraryLeaks", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public final class HeapAnalysisSuccess extends HeapAnalysis {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 130453013437459642L;
    private final long analysisDurationMillis;
    private final List<ApplicationLeak> applicationLeaks;
    private final long createdAtTimeMillis;
    private final File heapDumpFile;
    private final List<LibraryLeak> libraryLeaks;
    private final Map<String, String> metadata;

    public static /* synthetic */ HeapAnalysisSuccess copy$default(HeapAnalysisSuccess heapAnalysisSuccess, File file, long j, long j2, Map map, List list, List list2, int i, Object obj) {
        HeapAnalysisSuccess heapAnalysisSuccess2 = heapAnalysisSuccess;
        return heapAnalysisSuccess.copy((i & 1) != 0 ? heapAnalysisSuccess.getHeapDumpFile() : file, (i & 2) != 0 ? heapAnalysisSuccess.getCreatedAtTimeMillis() : j, (i & 4) != 0 ? heapAnalysisSuccess.getAnalysisDurationMillis() : j2, (i & 8) != 0 ? heapAnalysisSuccess2.metadata : map, (i & 16) != 0 ? heapAnalysisSuccess2.applicationLeaks : list, (i & 32) != 0 ? heapAnalysisSuccess2.libraryLeaks : list2);
    }

    public final File component1() {
        return getHeapDumpFile();
    }

    public final long component2() {
        return getCreatedAtTimeMillis();
    }

    public final long component3() {
        return getAnalysisDurationMillis();
    }

    public final Map<String, String> component4() {
        return this.metadata;
    }

    public final List<ApplicationLeak> component5() {
        return this.applicationLeaks;
    }

    public final List<LibraryLeak> component6() {
        return this.libraryLeaks;
    }

    public final HeapAnalysisSuccess copy(File file, long j, long j2, Map<String, String> map, List<ApplicationLeak> list, List<LibraryLeak> list2) {
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Map<String, String> map2 = map;
        Intrinsics.checkParameterIsNotNull(map2, AdminPermission.METADATA);
        List<ApplicationLeak> list3 = list;
        Intrinsics.checkParameterIsNotNull(list3, "applicationLeaks");
        List<LibraryLeak> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list4, "libraryLeaks");
        return new HeapAnalysisSuccess(file, j, j2, map2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HeapAnalysisSuccess) {
                HeapAnalysisSuccess heapAnalysisSuccess = (HeapAnalysisSuccess) obj;
                if (Intrinsics.areEqual((Object) getHeapDumpFile(), (Object) heapAnalysisSuccess.getHeapDumpFile())) {
                    if (getCreatedAtTimeMillis() == heapAnalysisSuccess.getCreatedAtTimeMillis()) {
                        if (!(getAnalysisDurationMillis() == heapAnalysisSuccess.getAnalysisDurationMillis()) || !Intrinsics.areEqual((Object) this.metadata, (Object) heapAnalysisSuccess.metadata) || !Intrinsics.areEqual((Object) this.applicationLeaks, (Object) heapAnalysisSuccess.applicationLeaks) || !Intrinsics.areEqual((Object) this.libraryLeaks, (Object) heapAnalysisSuccess.libraryLeaks)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        File heapDumpFile2 = getHeapDumpFile();
        int i = 0;
        int hashCode = heapDumpFile2 != null ? heapDumpFile2.hashCode() : 0;
        long createdAtTimeMillis2 = getCreatedAtTimeMillis();
        long analysisDurationMillis2 = getAnalysisDurationMillis();
        int i2 = ((((hashCode * 31) + ((int) (createdAtTimeMillis2 ^ (createdAtTimeMillis2 >>> 32)))) * 31) + ((int) (analysisDurationMillis2 ^ (analysisDurationMillis2 >>> 32)))) * 31;
        Map<String, String> map = this.metadata;
        int hashCode2 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
        List<ApplicationLeak> list = this.applicationLeaks;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<LibraryLeak> list2 = this.libraryLeaks;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public File getHeapDumpFile() {
        return this.heapDumpFile;
    }

    public long getCreatedAtTimeMillis() {
        return this.createdAtTimeMillis;
    }

    public long getAnalysisDurationMillis() {
        return this.analysisDurationMillis;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final List<ApplicationLeak> getApplicationLeaks() {
        return this.applicationLeaks;
    }

    public final List<LibraryLeak> getLibraryLeaks() {
        return this.libraryLeaks;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeapAnalysisSuccess(File file, long j, long j2, Map<String, String> map, List<ApplicationLeak> list, List<LibraryLeak> list2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(map, AdminPermission.METADATA);
        Intrinsics.checkParameterIsNotNull(list, "applicationLeaks");
        Intrinsics.checkParameterIsNotNull(list2, "libraryLeaks");
        this.heapDumpFile = file;
        this.createdAtTimeMillis = j;
        this.analysisDurationMillis = j2;
        this.metadata = map;
        this.applicationLeaks = list;
        this.libraryLeaks = list2;
    }

    public final Sequence<Leak> getAllLeaks() {
        return SequencesKt.plus(CollectionsKt.asSequence(this.applicationLeaks), CollectionsKt.asSequence(this.libraryLeaks));
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("====================================\nHEAP ANALYSIS RESULT\n====================================\n");
        sb.append(this.applicationLeaks.size());
        sb.append(" APPLICATION LEAKS\n\nReferences underlined with \"~~~\" are likely causes.\nLearn more at https://squ.re/leaks.\n");
        String str3 = "";
        if (!this.applicationLeaks.isEmpty()) {
            str = "\n" + CollectionsKt.joinToString$default(this.applicationLeaks, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n";
        } else {
            str = str3;
        }
        sb.append(str);
        sb.append("====================================\n");
        sb.append(this.libraryLeaks.size());
        sb.append(" LIBRARY LEAKS\n\nLibrary Leaks are leaks coming from the Android Framework or Google libraries.\n");
        if (!this.libraryLeaks.isEmpty()) {
            str2 = "\n" + CollectionsKt.joinToString$default(this.libraryLeaks, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n";
        } else {
            str2 = str3;
        }
        sb.append(str2);
        sb.append("====================================\nMETADATA\n\nPlease include this in bug reports and Stack Overflow questions.\n");
        if (!this.metadata.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n");
            Map<String, String> map = this.metadata;
            Collection arrayList = new ArrayList(map.size());
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(((String) next.getKey()) + ": " + ((String) next.getValue()));
            }
            sb2.append(CollectionsKt.joinToString$default((List) arrayList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            str3 = sb2.toString();
        }
        sb.append(str3);
        sb.append("\nAnalysis duration: ");
        sb.append(getAnalysisDurationMillis());
        sb.append(" ms\nHeap dump file path: ");
        sb.append(getHeapDumpFile().getAbsolutePath());
        sb.append("\nHeap dump timestamp: ");
        sb.append(getCreatedAtTimeMillis());
        sb.append("\n====================================");
        return sb.toString();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lkshark/HeapAnalysisSuccess$Companion;", "", "()V", "serialVersionUID", "", "upgradeFrom20Deserialized", "Lkshark/HeapAnalysisSuccess;", "fromV20", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalysis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HeapAnalysisSuccess upgradeFrom20Deserialized(HeapAnalysisSuccess heapAnalysisSuccess) {
            Intrinsics.checkParameterIsNotNull(heapAnalysisSuccess, "fromV20");
            Iterable<ApplicationLeak> applicationLeaks = heapAnalysisSuccess.getApplicationLeaks();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(applicationLeaks, 10));
            for (ApplicationLeak leakTraceFromV20$shark : applicationLeaks) {
                arrayList.add(leakTraceFromV20$shark.leakTraceFromV20$shark());
            }
            Map linkedHashMap = new LinkedHashMap();
            for (Object next : (List) arrayList) {
                String signature = ((LeakTrace) next).getSignature();
                Object obj = linkedHashMap.get(signature);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(signature, obj);
                }
                ((List) obj).add(next);
            }
            Iterable<List> values = linkedHashMap.values();
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
            for (List applicationLeak : values) {
                arrayList2.add(new ApplicationLeak(applicationLeak));
            }
            List list = (List) arrayList2;
            Iterable<LibraryLeak> libraryLeaks = heapAnalysisSuccess.getLibraryLeaks();
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(libraryLeaks, 10));
            for (LibraryLeak libraryLeak : libraryLeaks) {
                arrayList3.add(TuplesKt.m42317to(libraryLeak, libraryLeak.leakTraceFromV20$shark()));
            }
            Map linkedHashMap2 = new LinkedHashMap();
            for (Object next2 : (List) arrayList3) {
                String signature2 = ((LeakTrace) ((Pair) next2).getSecond()).getSignature();
                Object obj2 = linkedHashMap2.get(signature2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(signature2, obj2);
                }
                ((List) obj2).add(next2);
            }
            Iterable<List> values2 = linkedHashMap2.values();
            Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values2, 10));
            for (List list2 : values2) {
                LibraryLeak libraryLeak2 = (LibraryLeak) ((Pair) CollectionsKt.first(list2)).getFirst();
                ReferencePattern pattern = libraryLeak2.getPattern();
                String description = libraryLeak2.getDescription();
                Iterable<Pair> iterable = list2;
                Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Pair second : iterable) {
                    arrayList5.add((LeakTrace) second.getSecond());
                }
                arrayList4.add(new LibraryLeak((List) arrayList5, pattern, description));
            }
            return new HeapAnalysisSuccess(heapAnalysisSuccess.getHeapDumpFile(), heapAnalysisSuccess.getCreatedAtTimeMillis(), heapAnalysisSuccess.getAnalysisDurationMillis(), heapAnalysisSuccess.getMetadata(), list, (List) arrayList4);
        }
    }
}

package com.didichuxing.alpha.crash.dump;

import com.didichuxing.alpha.crash.dump.Reachability;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HeapDump implements Serializable {
    public final boolean computeRetainedHeapSize;
    public final ExcludedRefs excludedRefs;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public final File heapDumpFile;
    public final List<Class<? extends Reachability.Inspector>> reachabilityInspectorClasses;
    public final String referenceKey;
    public final String referenceName;
    public final long watchDurationMs;

    public interface Listener {
        public static final Listener NONE = new Listener() {
            public void analyze(HeapDump heapDump) {
            }
        };

        void analyze(HeapDump heapDump);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Deprecated
    public HeapDump(File file, String str, String str2, ExcludedRefs excludedRefs2, long j, long j2, long j3) {
        this(new Builder().heapDumpFile(file).referenceKey(str).referenceName(str2).excludedRefs(excludedRefs2).computeRetainedHeapSize(true).watchDurationMs(j).gcDurationMs(j2).heapDumpDurationMs(j3));
    }

    HeapDump(Builder builder) {
        this.heapDumpFile = builder.heapDumpFile;
        this.referenceKey = builder.referenceKey;
        this.referenceName = builder.referenceName;
        this.excludedRefs = builder.excludedRefs;
        this.computeRetainedHeapSize = builder.computeRetainedHeapSize;
        this.watchDurationMs = builder.watchDurationMs;
        this.gcDurationMs = builder.gcDurationMs;
        this.heapDumpDurationMs = builder.heapDumpDurationMs;
        this.reachabilityInspectorClasses = builder.reachabilityInspectorClasses;
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public static final class Builder {
        boolean computeRetainedHeapSize;
        ExcludedRefs excludedRefs;
        long gcDurationMs;
        long heapDumpDurationMs;
        File heapDumpFile;
        List<Class<? extends Reachability.Inspector>> reachabilityInspectorClasses;
        String referenceKey;
        String referenceName;
        long watchDurationMs;

        public Builder() {
            this.heapDumpFile = null;
            this.referenceKey = null;
            this.referenceName = "";
            this.excludedRefs = null;
            this.watchDurationMs = 0;
            this.gcDurationMs = 0;
            this.heapDumpDurationMs = 0;
            this.computeRetainedHeapSize = false;
            this.reachabilityInspectorClasses = null;
        }

        Builder(HeapDump heapDump) {
            this.heapDumpFile = heapDump.heapDumpFile;
            this.referenceKey = heapDump.referenceKey;
            this.referenceName = heapDump.referenceName;
            this.excludedRefs = heapDump.excludedRefs;
            this.computeRetainedHeapSize = heapDump.computeRetainedHeapSize;
            this.watchDurationMs = heapDump.watchDurationMs;
            this.gcDurationMs = heapDump.gcDurationMs;
            this.heapDumpDurationMs = heapDump.heapDumpDurationMs;
            this.reachabilityInspectorClasses = heapDump.reachabilityInspectorClasses;
        }

        public Builder heapDumpFile(File file) {
            this.heapDumpFile = (File) Preconditions.checkNotNull(file, "heapDumpFile");
            return this;
        }

        public Builder referenceKey(String str) {
            this.referenceKey = (String) Preconditions.checkNotNull(str, "referenceKey");
            return this;
        }

        public Builder referenceName(String str) {
            this.referenceName = (String) Preconditions.checkNotNull(str, "referenceName");
            return this;
        }

        public Builder excludedRefs(ExcludedRefs excludedRefs2) {
            this.excludedRefs = (ExcludedRefs) Preconditions.checkNotNull(excludedRefs2, "excludedRefs");
            return this;
        }

        public Builder watchDurationMs(long j) {
            this.watchDurationMs = j;
            return this;
        }

        public Builder gcDurationMs(long j) {
            this.gcDurationMs = j;
            return this;
        }

        public Builder heapDumpDurationMs(long j) {
            this.heapDumpDurationMs = j;
            return this;
        }

        public Builder computeRetainedHeapSize(boolean z) {
            this.computeRetainedHeapSize = z;
            return this;
        }

        public Builder reachabilityInspectorClasses(List<Class<? extends Reachability.Inspector>> list) {
            Preconditions.checkNotNull(list, "reachabilityInspectorClasses");
            this.reachabilityInspectorClasses = Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public HeapDump build() {
            Preconditions.checkNotNull(this.excludedRefs, "excludedRefs");
            Preconditions.checkNotNull(this.heapDumpFile, "heapDumpFile");
            Preconditions.checkNotNull(this.referenceKey, "referenceKey");
            Preconditions.checkNotNull(this.reachabilityInspectorClasses, "reachabilityInspectorClasses");
            return new HeapDump(this);
        }
    }
}

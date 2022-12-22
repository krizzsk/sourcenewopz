package org.jacoco.agent.p086rt.internal_8ff85ea.core.data;

import java.util.Arrays;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionData */
public final class ExecutionData {

    /* renamed from: id */
    private final long f6588id;
    private final String name;
    private final boolean[] probes;

    public ExecutionData(long j, String str, boolean[] zArr) {
        this.f6588id = j;
        this.name = str;
        this.probes = zArr;
    }

    public ExecutionData(long j, String str, int i) {
        this.f6588id = j;
        this.name = str;
        this.probes = new boolean[i];
    }

    public long getId() {
        return this.f6588id;
    }

    public String getName() {
        return this.name;
    }

    public boolean[] getProbes() {
        return this.probes;
    }

    public void reset() {
        Arrays.fill(this.probes, false);
    }

    public boolean hasHits() {
        for (boolean z : this.probes) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void merge(ExecutionData executionData) {
        merge(executionData, true);
    }

    public void merge(ExecutionData executionData, boolean z) {
        assertCompatibility(executionData.getId(), executionData.getName(), executionData.getProbes().length);
        boolean[] probes2 = executionData.getProbes();
        int i = 0;
        while (true) {
            boolean[] zArr = this.probes;
            if (i < zArr.length) {
                if (probes2[i]) {
                    zArr[i] = z;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void assertCompatibility(long j, String str, int i) throws IllegalStateException {
        if (this.f6588id != j) {
            throw new IllegalStateException(String.format("Different ids (%016x and %016x).", new Object[]{Long.valueOf(this.f6588id), Long.valueOf(j)}));
        } else if (!this.name.equals(str)) {
            throw new IllegalStateException(String.format("Different class names %s and %s for id %016x.", new Object[]{this.name, str, Long.valueOf(j)}));
        } else if (this.probes.length != i) {
            throw new IllegalStateException(String.format("Incompatible execution data for class %s with id %016x.", new Object[]{str, Long.valueOf(j)}));
        }
    }

    public String toString() {
        return String.format("ExecutionData[name=%s, id=%016x]", new Object[]{this.name, Long.valueOf(this.f6588id)});
    }
}

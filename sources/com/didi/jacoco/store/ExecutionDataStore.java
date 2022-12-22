package com.didi.jacoco.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ExecutionDataStore implements IExecutionDataVisitor {
    private final Map<Long, ExecutionData> entries = new HashMap();
    private final Set<String> names = new HashSet();

    public void put(ExecutionData executionData) throws IllegalStateException {
        Long valueOf = Long.valueOf(executionData.getId());
        ExecutionData executionData2 = this.entries.get(valueOf);
        if (executionData2 == null) {
            this.entries.put(valueOf, executionData);
            this.names.add(executionData.getName());
            return;
        }
        executionData2.merge(executionData);
    }

    public void subtract(ExecutionData executionData) throws IllegalStateException {
        ExecutionData executionData2 = this.entries.get(Long.valueOf(executionData.getId()));
        if (executionData2 != null) {
            executionData2.merge(executionData, false);
        }
    }

    public void subtract(ExecutionDataStore executionDataStore) {
        for (ExecutionData subtract : executionDataStore.getContents()) {
            subtract(subtract);
        }
    }

    public ExecutionData get(long j) {
        return this.entries.get(Long.valueOf(j));
    }

    public boolean contains(String str) {
        return this.names.contains(str);
    }

    public ExecutionData get(Long l, String str, int i) {
        ExecutionData executionData = this.entries.get(l);
        if (executionData == null) {
            ExecutionData executionData2 = new ExecutionData(l.longValue(), str, i);
            this.entries.put(l, executionData2);
            this.names.add(str);
            return executionData2;
        }
        executionData.assertCompatibility(l.longValue(), str, i);
        return executionData;
    }

    public void reset() {
        for (ExecutionData reset : this.entries.values()) {
            reset.reset();
        }
    }

    public Collection<ExecutionData> getContents() {
        return new ArrayList(this.entries.values());
    }

    public void accept(IExecutionDataVisitor iExecutionDataVisitor) {
        for (ExecutionData visitClassExecution : getContents()) {
            iExecutionDataVisitor.visitClassExecution(visitClassExecution);
        }
    }

    public void visitClassExecution(ExecutionData executionData) {
        put(executionData);
    }
}

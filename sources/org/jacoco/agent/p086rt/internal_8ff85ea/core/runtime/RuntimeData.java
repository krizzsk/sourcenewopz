package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionData;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionDataStore;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.IExecutionDataVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ISessionInfoVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.SessionInfo;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr.InstrSupport;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RuntimeData */
public class RuntimeData {
    private String sessionId = "<none>";
    private long startTimeStamp = System.currentTimeMillis();
    protected final ExecutionDataStore store = new ExecutionDataStore();

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public final void collect(IExecutionDataVisitor iExecutionDataVisitor, ISessionInfoVisitor iSessionInfoVisitor, boolean z) {
        synchronized (this.store) {
            iSessionInfoVisitor.visitSessionInfo(new SessionInfo(this.sessionId, this.startTimeStamp, System.currentTimeMillis()));
            this.store.accept(iExecutionDataVisitor);
            if (z) {
                reset();
            }
        }
    }

    public final void reset() {
        synchronized (this.store) {
            this.store.reset();
            this.startTimeStamp = System.currentTimeMillis();
        }
    }

    public ExecutionData getExecutionData(Long l, String str, int i) {
        ExecutionData executionData;
        synchronized (this.store) {
            executionData = this.store.get(l, str, i);
        }
        return executionData;
    }

    public void getProbes(Object[] objArr) {
        objArr[0] = getExecutionData(objArr[0], objArr[1], objArr[2].intValue()).getProbes();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Object[]) {
            getProbes((Object[]) obj);
        }
        return super.equals(obj);
    }

    public static void generateArgumentArray(long j, String str, int i, MethodVisitor methodVisitor) {
        methodVisitor.visitInsn(6);
        methodVisitor.visitTypeInsn(189, "java/lang/Object");
        methodVisitor.visitInsn(89);
        methodVisitor.visitInsn(3);
        methodVisitor.visitLdcInsn(Long.valueOf(j));
        methodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
        methodVisitor.visitInsn(83);
        methodVisitor.visitInsn(89);
        methodVisitor.visitInsn(4);
        methodVisitor.visitLdcInsn(str);
        methodVisitor.visitInsn(83);
        methodVisitor.visitInsn(89);
        methodVisitor.visitInsn(5);
        InstrSupport.push(methodVisitor, i);
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        methodVisitor.visitInsn(83);
    }

    public static void generateAccessCall(long j, String str, int i, MethodVisitor methodVisitor) {
        generateArgumentArray(j, str, i, methodVisitor);
        methodVisitor.visitInsn(90);
        methodVisitor.visitMethodInsn(182, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z", false);
        methodVisitor.visitInsn(87);
        methodVisitor.visitInsn(3);
        methodVisitor.visitInsn(50);
        methodVisitor.visitTypeInsn(192, InstrSupport.DATAFIELD_DESC);
    }
}

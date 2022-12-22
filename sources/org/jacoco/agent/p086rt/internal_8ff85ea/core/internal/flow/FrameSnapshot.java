package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.FrameSnapshot */
class FrameSnapshot implements IFrame {
    private static final FrameSnapshot NOP = new FrameSnapshot((Object[]) null, (Object[]) null);
    private final Object[] locals;
    private final Object[] stack;

    private FrameSnapshot(Object[] objArr, Object[] objArr2) {
        this.locals = objArr;
        this.stack = objArr2;
    }

    static IFrame create(AnalyzerAdapter analyzerAdapter, int i) {
        if (analyzerAdapter == null || analyzerAdapter.locals == null) {
            return NOP;
        }
        return new FrameSnapshot(reduce(analyzerAdapter.locals, 0), reduce(analyzerAdapter.stack, i));
    }

    private static Object[] reduce(List<Object> list, int i) {
        ArrayList arrayList = new ArrayList(list);
        int size = list.size() - i;
        arrayList.subList(size, list.size()).clear();
        while (true) {
            size--;
            if (size < 0) {
                return arrayList.toArray();
            }
            Object obj = list.get(size);
            if (obj == Opcodes.LONG || obj == Opcodes.DOUBLE) {
                arrayList.remove(size + 1);
            }
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        Object[] objArr = this.locals;
        if (objArr != null) {
            int length = objArr.length;
            Object[] objArr2 = this.stack;
            methodVisitor.visitFrame(-1, length, objArr, objArr2.length, objArr2);
        }
    }
}

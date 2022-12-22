package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FrameNode */
public class FrameNode extends AbstractInsnNode {
    public List<Object> local;
    public List<Object> stack;
    public int type;

    public int getType() {
        return 14;
    }

    private FrameNode() {
        super(-1);
    }

    public FrameNode(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        super(-1);
        this.type = i;
        if (i == -1 || i == 0) {
            this.local = asList(i2, objArr);
            this.stack = asList(i3, objArr2);
        } else if (i == 1) {
            this.local = asList(i2, objArr);
        } else if (i == 2) {
            this.local = Arrays.asList(new Object[i2]);
        } else if (i == 4) {
            this.stack = asList(1, objArr2);
        }
    }

    public void accept(MethodVisitor methodVisitor) {
        int i = this.type;
        if (i == -1 || i == 0) {
            methodVisitor.visitFrame(this.type, this.local.size(), asArray(this.local), this.stack.size(), asArray(this.stack));
        } else if (i == 1) {
            methodVisitor.visitFrame(i, this.local.size(), asArray(this.local), 0, (Object[]) null);
        } else if (i == 2) {
            methodVisitor.visitFrame(i, this.local.size(), (Object[]) null, 0, (Object[]) null);
        } else if (i == 3) {
            methodVisitor.visitFrame(i, 0, (Object[]) null, 0, (Object[]) null);
        } else if (i == 4) {
            methodVisitor.visitFrame(i, 0, (Object[]) null, 1, asArray(this.stack));
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Map<org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LabelNode, org.jacoco.agent.rt.internal_8ff85ea.asm.tree.LabelNode>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.AbstractInsnNode clone(java.util.Map<org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LabelNode, org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LabelNode> r6) {
        /*
            r5 = this;
            org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FrameNode r0 = new org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FrameNode
            r0.<init>()
            int r1 = r5.type
            r0.type = r1
            java.util.List<java.lang.Object> r1 = r5.local
            r2 = 0
            if (r1 == 0) goto L_0x0034
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.local = r1
            r1 = 0
        L_0x0016:
            java.util.List<java.lang.Object> r3 = r5.local
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0034
            java.util.List<java.lang.Object> r3 = r5.local
            java.lang.Object r3 = r3.get(r1)
            boolean r4 = r3 instanceof org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LabelNode
            if (r4 == 0) goto L_0x002c
            java.lang.Object r3 = r6.get(r3)
        L_0x002c:
            java.util.List<java.lang.Object> r4 = r0.local
            r4.add(r3)
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0034:
            java.util.List<java.lang.Object> r1 = r5.stack
            if (r1 == 0) goto L_0x005d
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.stack = r1
        L_0x003f:
            java.util.List<java.lang.Object> r1 = r5.stack
            int r1 = r1.size()
            if (r2 >= r1) goto L_0x005d
            java.util.List<java.lang.Object> r1 = r5.stack
            java.lang.Object r1 = r1.get(r2)
            boolean r3 = r1 instanceof org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LabelNode
            if (r3 == 0) goto L_0x0055
            java.lang.Object r1 = r6.get(r1)
        L_0x0055:
            java.util.List<java.lang.Object> r3 = r0.stack
            r3.add(r1)
            int r2 = r2 + 1
            goto L_0x003f
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.FrameNode.clone(java.util.Map):org.jacoco.agent.rt.internal_8ff85ea.asm.tree.AbstractInsnNode");
    }

    private static List<Object> asList(int i, Object[] objArr) {
        return Arrays.asList(objArr).subList(0, i);
    }

    private static Object[] asArray(List<Object> list) {
        int size = list.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof LabelNode) {
                obj = ((LabelNode) obj).getLabel();
            }
            objArr[i] = obj;
        }
        return objArr;
    }
}

package org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Opcodes;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.AbstractInsnNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.InsnList;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.InsnNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.JumpInsnNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LabelNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LocalVariableNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.LookupSwitchInsnNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.MethodNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.TableSwitchInsnNode;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree.TryCatchBlockNode;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter */
public class JSRInlinerAdapter extends MethodNode implements Opcodes {
    private static final boolean LOGGING = false;
    final BitSet dualCitizens;
    private final BitSet mainSubroutine;
    private final Map<LabelNode, BitSet> subroutineHeads;

    public JSRInlinerAdapter(MethodVisitor methodVisitor, int i, String str, String str2, String str3, String[] strArr) {
        this(327680, methodVisitor, i, str, str2, str3, strArr);
        if (getClass() != JSRInlinerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected JSRInlinerAdapter(int i, MethodVisitor methodVisitor, int i2, String str, String str2, String str3, String[] strArr) {
        super(i, i2, str, str2, str3, strArr);
        this.subroutineHeads = new HashMap();
        this.mainSubroutine = new BitSet();
        this.dualCitizens = new BitSet();
        this.f6585mv = methodVisitor;
    }

    public void visitJumpInsn(int i, Label label) {
        super.visitJumpInsn(i, label);
        LabelNode labelNode = ((JumpInsnNode) this.instructions.getLast()).label;
        if (i == 168 && !this.subroutineHeads.containsKey(labelNode)) {
            this.subroutineHeads.put(labelNode, new BitSet());
        }
    }

    public void visitEnd() {
        if (!this.subroutineHeads.isEmpty()) {
            markSubroutines();
            emitCode();
        }
        if (this.f6585mv != null) {
            accept(this.f6585mv);
        }
    }

    private void markSubroutines() {
        BitSet bitSet = new BitSet();
        markSubroutineWalk(this.mainSubroutine, 0, bitSet);
        for (Map.Entry next : this.subroutineHeads.entrySet()) {
            markSubroutineWalk((BitSet) next.getValue(), this.instructions.indexOf((LabelNode) next.getKey()), bitSet);
        }
    }

    private void markSubroutineWalk(BitSet bitSet, int i, BitSet bitSet2) {
        markSubroutineWalkDFS(bitSet, i, bitSet2);
        boolean z = true;
        while (z) {
            z = false;
            for (TryCatchBlockNode tryCatchBlockNode : this.tryCatchBlocks) {
                int indexOf = this.instructions.indexOf(tryCatchBlockNode.handler);
                if (!bitSet.get(indexOf)) {
                    int indexOf2 = this.instructions.indexOf(tryCatchBlockNode.start);
                    int indexOf3 = this.instructions.indexOf(tryCatchBlockNode.end);
                    int nextSetBit = bitSet.nextSetBit(indexOf2);
                    if (nextSetBit != -1 && nextSetBit < indexOf3) {
                        markSubroutineWalkDFS(bitSet, indexOf, bitSet2);
                        z = true;
                    }
                }
            }
        }
    }

    private void markSubroutineWalkDFS(BitSet bitSet, int i, BitSet bitSet2) {
        do {
            AbstractInsnNode abstractInsnNode = this.instructions.get(i);
            if (!bitSet.get(i)) {
                bitSet.set(i);
                if (bitSet2.get(i)) {
                    this.dualCitizens.set(i);
                }
                bitSet2.set(i);
                if (abstractInsnNode.getType() == 7 && abstractInsnNode.getOpcode() != 168) {
                    markSubroutineWalkDFS(bitSet, this.instructions.indexOf(((JumpInsnNode) abstractInsnNode).label), bitSet2);
                }
                if (abstractInsnNode.getType() == 11) {
                    TableSwitchInsnNode tableSwitchInsnNode = (TableSwitchInsnNode) abstractInsnNode;
                    markSubroutineWalkDFS(bitSet, this.instructions.indexOf(tableSwitchInsnNode.dflt), bitSet2);
                    for (int size = tableSwitchInsnNode.labels.size() - 1; size >= 0; size--) {
                        markSubroutineWalkDFS(bitSet, this.instructions.indexOf(tableSwitchInsnNode.labels.get(size)), bitSet2);
                    }
                }
                if (abstractInsnNode.getType() == 12) {
                    LookupSwitchInsnNode lookupSwitchInsnNode = (LookupSwitchInsnNode) abstractInsnNode;
                    markSubroutineWalkDFS(bitSet, this.instructions.indexOf(lookupSwitchInsnNode.dflt), bitSet2);
                    for (int size2 = lookupSwitchInsnNode.labels.size() - 1; size2 >= 0; size2--) {
                        markSubroutineWalkDFS(bitSet, this.instructions.indexOf(lookupSwitchInsnNode.labels.get(size2)), bitSet2);
                    }
                }
                int opcode = this.instructions.get(i).getOpcode();
                if (opcode != 167 && opcode != 191) {
                    switch (opcode) {
                        case 169:
                        case 170:
                        case 171:
                        case 172:
                        case 173:
                        case 174:
                        case 175:
                        case 176:
                        case 177:
                            return;
                        default:
                            i++;
                            break;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (i < this.instructions.size());
    }

    private void emitCode() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Instantiation((Instantiation) null, this.mainSubroutine));
        InsnList insnList = new InsnList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (!linkedList.isEmpty()) {
            emitSubroutine((Instantiation) linkedList.removeFirst(), linkedList, insnList, arrayList, arrayList2);
        }
        this.instructions = insnList;
        this.tryCatchBlocks = arrayList;
        this.localVariables = arrayList2;
    }

    private void emitSubroutine(Instantiation instantiation, List<Instantiation> list, InsnList insnList, List<TryCatchBlockNode> list2, List<LocalVariableNode> list3) {
        int size = this.instructions.size();
        LabelNode labelNode = null;
        for (int i = 0; i < size; i++) {
            AbstractInsnNode abstractInsnNode = this.instructions.get(i);
            Instantiation findOwner = instantiation.findOwner(i);
            if (abstractInsnNode.getType() == 8) {
                LabelNode rangeLabel = instantiation.rangeLabel((LabelNode) abstractInsnNode);
                if (rangeLabel != labelNode) {
                    insnList.add((AbstractInsnNode) rangeLabel);
                    labelNode = rangeLabel;
                }
            } else if (findOwner != instantiation) {
                continue;
            } else if (abstractInsnNode.getOpcode() == 169) {
                LabelNode labelNode2 = null;
                for (Instantiation instantiation2 = instantiation; instantiation2 != null; instantiation2 = instantiation2.previous) {
                    if (instantiation2.subroutine.get(i)) {
                        labelNode2 = instantiation2.returnLabel;
                    }
                }
                if (labelNode2 != null) {
                    insnList.add((AbstractInsnNode) new JumpInsnNode(167, labelNode2));
                } else {
                    throw new RuntimeException("Instruction #" + i + " is a RET not owned by any subroutine");
                }
            } else if (abstractInsnNode.getOpcode() == 168) {
                LabelNode labelNode3 = ((JumpInsnNode) abstractInsnNode).label;
                Instantiation instantiation3 = new Instantiation(instantiation, this.subroutineHeads.get(labelNode3));
                LabelNode gotoLabel = instantiation3.gotoLabel(labelNode3);
                insnList.add((AbstractInsnNode) new InsnNode(1));
                insnList.add((AbstractInsnNode) new JumpInsnNode(167, gotoLabel));
                insnList.add((AbstractInsnNode) instantiation3.returnLabel);
                list.add(instantiation3);
            } else {
                insnList.add(abstractInsnNode.clone(instantiation));
            }
        }
        for (TryCatchBlockNode tryCatchBlockNode : this.tryCatchBlocks) {
            LabelNode rangeLabel2 = instantiation.rangeLabel(tryCatchBlockNode.start);
            LabelNode rangeLabel3 = instantiation.rangeLabel(tryCatchBlockNode.end);
            if (rangeLabel2 != rangeLabel3) {
                LabelNode gotoLabel2 = instantiation.gotoLabel(tryCatchBlockNode.handler);
                if (rangeLabel2 == null || rangeLabel3 == null || gotoLabel2 == null) {
                    throw new RuntimeException("Internal error!");
                }
                list2.add(new TryCatchBlockNode(rangeLabel2, rangeLabel3, gotoLabel2, tryCatchBlockNode.type));
            }
        }
        for (LocalVariableNode localVariableNode : this.localVariables) {
            LabelNode rangeLabel4 = instantiation.rangeLabel(localVariableNode.start);
            LabelNode rangeLabel5 = instantiation.rangeLabel(localVariableNode.end);
            if (rangeLabel4 != rangeLabel5) {
                list3.add(new LocalVariableNode(localVariableNode.name, localVariableNode.desc, localVariableNode.signature, rangeLabel4, rangeLabel5, localVariableNode.index));
            }
        }
    }

    private static void log(String str) {
        System.err.println(str);
    }

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.commons.JSRInlinerAdapter$Instantiation */
    private class Instantiation extends AbstractMap<LabelNode, LabelNode> {
        final Instantiation previous;
        public final Map<LabelNode, LabelNode> rangeTable = new HashMap();
        public final LabelNode returnLabel;
        public final BitSet subroutine;

        public Set<Map.Entry<LabelNode, LabelNode>> entrySet() {
            return null;
        }

        Instantiation(Instantiation instantiation, BitSet bitSet) {
            this.previous = instantiation;
            this.subroutine = bitSet;
            Instantiation instantiation2 = instantiation;
            while (instantiation2 != null) {
                if (instantiation2.subroutine != bitSet) {
                    instantiation2 = instantiation2.previous;
                } else {
                    throw new RuntimeException("Recursive invocation of " + bitSet);
                }
            }
            if (instantiation != null) {
                this.returnLabel = new LabelNode();
            } else {
                this.returnLabel = null;
            }
            int size = JSRInlinerAdapter.this.instructions.size();
            LabelNode labelNode = null;
            for (int i = 0; i < size; i++) {
                AbstractInsnNode abstractInsnNode = JSRInlinerAdapter.this.instructions.get(i);
                if (abstractInsnNode.getType() == 8) {
                    LabelNode labelNode2 = (LabelNode) abstractInsnNode;
                    labelNode = labelNode == null ? new LabelNode() : labelNode;
                    this.rangeTable.put(labelNode2, labelNode);
                } else if (findOwner(i) == this) {
                    labelNode = null;
                }
            }
        }

        public Instantiation findOwner(int i) {
            if (!this.subroutine.get(i)) {
                return null;
            }
            if (!JSRInlinerAdapter.this.dualCitizens.get(i)) {
                return this;
            }
            Instantiation instantiation = this;
            for (Instantiation instantiation2 = this.previous; instantiation2 != null; instantiation2 = instantiation2.previous) {
                if (instantiation2.subroutine.get(i)) {
                    instantiation = instantiation2;
                }
            }
            return instantiation;
        }

        public LabelNode gotoLabel(LabelNode labelNode) {
            return findOwner(JSRInlinerAdapter.this.instructions.indexOf(labelNode)).rangeTable.get(labelNode);
        }

        public LabelNode rangeLabel(LabelNode labelNode) {
            return this.rangeTable.get(labelNode);
        }

        public LabelNode get(Object obj) {
            return gotoLabel((LabelNode) obj);
        }
    }
}

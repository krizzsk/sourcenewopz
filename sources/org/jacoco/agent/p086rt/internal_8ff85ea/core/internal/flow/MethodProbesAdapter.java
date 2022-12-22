package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.MethodProbesAdapter */
public final class MethodProbesAdapter extends MethodVisitor {
    private AnalyzerAdapter analyzer;
    private final IProbeIdGenerator idGenerator;
    private final MethodProbesVisitor probesVisitor;
    private final Map<Label, Label> tryCatchProbeLabels = new HashMap();

    private int jumpPopCount(int i) {
        if (i == 167) {
            return 0;
        }
        if (i == 198 || i == 199) {
            return 1;
        }
        switch (i) {
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                return 1;
            default:
                return 2;
        }
    }

    public MethodProbesAdapter(MethodProbesVisitor methodProbesVisitor, IProbeIdGenerator iProbeIdGenerator) {
        super(327680, methodProbesVisitor);
        this.probesVisitor = methodProbesVisitor;
        this.idGenerator = iProbeIdGenerator;
    }

    public void setAnalyzer(AnalyzerAdapter analyzerAdapter) {
        this.analyzer = analyzerAdapter;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        if (this.tryCatchProbeLabels.containsKey(label)) {
            label = this.tryCatchProbeLabels.get(label);
        } else if (LabelInfo.needsProbe(label)) {
            Label label4 = new Label();
            LabelInfo.setSuccessor(label4);
            this.tryCatchProbeLabels.put(label, label4);
            label = label4;
        }
        this.probesVisitor.visitTryCatchBlock(label, label2, label3, str);
    }

    public void visitLabel(Label label) {
        if (LabelInfo.needsProbe(label)) {
            if (this.tryCatchProbeLabels.containsKey(label)) {
                this.probesVisitor.visitLabel(this.tryCatchProbeLabels.get(label));
            }
            this.probesVisitor.visitProbe(this.idGenerator.nextId());
        }
        this.probesVisitor.visitLabel(label);
    }

    public void visitInsn(int i) {
        if (i != 191) {
            switch (i) {
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                    break;
                default:
                    this.probesVisitor.visitInsn(i);
                    return;
            }
        }
        this.probesVisitor.visitInsnWithProbe(i, this.idGenerator.nextId());
    }

    public void visitJumpInsn(int i, Label label) {
        if (LabelInfo.isMultiTarget(label)) {
            this.probesVisitor.visitJumpInsnWithProbe(i, label, this.idGenerator.nextId(), frame(jumpPopCount(i)));
        } else {
            this.probesVisitor.visitJumpInsn(i, label);
        }
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        if (markLabels(label, labelArr)) {
            this.probesVisitor.visitLookupSwitchInsnWithProbes(label, iArr, labelArr, frame(1));
        } else {
            this.probesVisitor.visitLookupSwitchInsn(label, iArr, labelArr);
        }
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        if (markLabels(label, labelArr)) {
            this.probesVisitor.visitTableSwitchInsnWithProbes(i, i2, label, labelArr, frame(1));
            return;
        }
        this.probesVisitor.visitTableSwitchInsn(i, i2, label, labelArr);
    }

    private boolean markLabels(Label label, Label[] labelArr) {
        boolean z;
        LabelInfo.resetDone(labelArr);
        if (LabelInfo.isMultiTarget(label)) {
            LabelInfo.setProbeId(label, this.idGenerator.nextId());
            z = true;
        } else {
            z = false;
        }
        LabelInfo.setDone(label);
        for (Label label2 : labelArr) {
            if (LabelInfo.isMultiTarget(label2) && !LabelInfo.isDone(label2)) {
                LabelInfo.setProbeId(label2, this.idGenerator.nextId());
                z = true;
            }
            LabelInfo.setDone(label2);
        }
        return z;
    }

    private IFrame frame(int i) {
        return FrameSnapshot.create(this.analyzer, i);
    }
}

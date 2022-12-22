package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.instr;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.IFrame;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.LabelInfo;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.instr.MethodInstrumenter */
class MethodInstrumenter extends MethodProbesVisitor {
    private final IProbeInserter probeInserter;

    public MethodInstrumenter(MethodVisitor methodVisitor, IProbeInserter iProbeInserter) {
        super(methodVisitor);
        this.probeInserter = iProbeInserter;
    }

    public void visitProbe(int i) {
        this.probeInserter.insertProbe(i);
    }

    public void visitInsnWithProbe(int i, int i2) {
        this.probeInserter.insertProbe(i2);
        this.f6585mv.visitInsn(i);
    }

    public void visitJumpInsnWithProbe(int i, Label label, int i2, IFrame iFrame) {
        if (i == 167) {
            this.probeInserter.insertProbe(i2);
            this.f6585mv.visitJumpInsn(167, label);
            return;
        }
        Label label2 = new Label();
        this.f6585mv.visitJumpInsn(getInverted(i), label2);
        this.probeInserter.insertProbe(i2);
        this.f6585mv.visitJumpInsn(167, label);
        this.f6585mv.visitLabel(label2);
        iFrame.accept(this.f6585mv);
    }

    private int getInverted(int i) {
        if (i == 198) {
            return 199;
        }
        if (i == 199) {
            return 198;
        }
        switch (i) {
            case 153:
                return 154;
            case 154:
                return 153;
            case 155:
                return 156;
            case 156:
                return 155;
            case 157:
                return 158;
            case 158:
                return 157;
            case 159:
                return 160;
            case 160:
                return 159;
            case 161:
                return 162;
            case 162:
                return 161;
            case 163:
                return 164;
            case 164:
                return 163;
            case 165:
                return 166;
            case 166:
                return 165;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void visitTableSwitchInsnWithProbes(int i, int i2, Label label, Label[] labelArr, IFrame iFrame) {
        LabelInfo.resetDone(label);
        LabelInfo.resetDone(labelArr);
        this.f6585mv.visitTableSwitchInsn(i, i2, createIntermediate(label), createIntermediates(labelArr));
        insertIntermediateProbes(label, labelArr, iFrame);
    }

    public void visitLookupSwitchInsnWithProbes(Label label, int[] iArr, Label[] labelArr, IFrame iFrame) {
        LabelInfo.resetDone(label);
        LabelInfo.resetDone(labelArr);
        this.f6585mv.visitLookupSwitchInsn(createIntermediate(label), iArr, createIntermediates(labelArr));
        insertIntermediateProbes(label, labelArr, iFrame);
    }

    private Label[] createIntermediates(Label[] labelArr) {
        Label[] labelArr2 = new Label[labelArr.length];
        for (int i = 0; i < labelArr.length; i++) {
            labelArr2[i] = createIntermediate(labelArr[i]);
        }
        return labelArr2;
    }

    private Label createIntermediate(Label label) {
        if (LabelInfo.getProbeId(label) == -1) {
            return label;
        }
        if (LabelInfo.isDone(label)) {
            return LabelInfo.getIntermediateLabel(label);
        }
        Label label2 = new Label();
        LabelInfo.setIntermediateLabel(label, label2);
        LabelInfo.setDone(label);
        return label2;
    }

    private void insertIntermediateProbe(Label label, IFrame iFrame) {
        int probeId = LabelInfo.getProbeId(label);
        if (probeId != -1 && !LabelInfo.isDone(label)) {
            this.f6585mv.visitLabel(LabelInfo.getIntermediateLabel(label));
            iFrame.accept(this.f6585mv);
            this.probeInserter.insertProbe(probeId);
            this.f6585mv.visitJumpInsn(167, label);
            LabelInfo.setDone(label);
        }
    }

    private void insertIntermediateProbes(Label label, Label[] labelArr, IFrame iFrame) {
        LabelInfo.resetDone(label);
        LabelInfo.resetDone(labelArr);
        insertIntermediateProbe(label, iFrame);
        for (Label insertIntermediateProbe : labelArr) {
            insertIntermediateProbe(insertIntermediateProbe, iFrame);
        }
    }
}

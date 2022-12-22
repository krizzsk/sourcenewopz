package org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.flow;

import org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.LabelInfo */
public final class LabelInfo {
    public static final int NO_PROBE = -1;
    private boolean done = false;
    private Instruction instruction = null;
    private Label intermediate = null;
    private boolean methodInvocationLine = false;
    private boolean multiTarget = false;
    private int probeid = -1;
    private boolean successor = false;
    private boolean target = false;

    private LabelInfo() {
    }

    public static void setTarget(Label label) {
        LabelInfo create = create(label);
        if (create.target || create.successor) {
            create.multiTarget = true;
        } else {
            create.target = true;
        }
    }

    public static void setSuccessor(Label label) {
        LabelInfo create = create(label);
        create.successor = true;
        if (create.target) {
            create.multiTarget = true;
        }
    }

    public static boolean isMultiTarget(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return false;
        }
        return labelInfo.multiTarget;
    }

    public static boolean isSuccessor(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return false;
        }
        return labelInfo.successor;
    }

    public static void setMethodInvocationLine(Label label) {
        create(label).methodInvocationLine = true;
    }

    public static boolean isMethodInvocationLine(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return false;
        }
        return labelInfo.methodInvocationLine;
    }

    public static boolean needsProbe(Label label) {
        LabelInfo labelInfo = get(label);
        return labelInfo != null && labelInfo.successor && (labelInfo.multiTarget || labelInfo.methodInvocationLine);
    }

    public static void setDone(Label label) {
        create(label).done = true;
    }

    public static void resetDone(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo != null) {
            labelInfo.done = false;
        }
    }

    public static void resetDone(Label[] labelArr) {
        for (Label resetDone : labelArr) {
            resetDone(resetDone);
        }
    }

    public static boolean isDone(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return false;
        }
        return labelInfo.done;
    }

    public static void setProbeId(Label label, int i) {
        create(label).probeid = i;
    }

    public static int getProbeId(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return -1;
        }
        return labelInfo.probeid;
    }

    public static void setIntermediateLabel(Label label, Label label2) {
        create(label).intermediate = label2;
    }

    public static Label getIntermediateLabel(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return null;
        }
        return labelInfo.intermediate;
    }

    public static void setInstruction(Label label, Instruction instruction2) {
        create(label).instruction = instruction2;
    }

    public static Instruction getInstruction(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo == null) {
            return null;
        }
        return labelInfo.instruction;
    }

    private static LabelInfo get(Label label) {
        Object obj = label.info;
        if (obj instanceof LabelInfo) {
            return (LabelInfo) obj;
        }
        return null;
    }

    private static LabelInfo create(Label label) {
        LabelInfo labelInfo = get(label);
        if (labelInfo != null) {
            return labelInfo;
        }
        LabelInfo labelInfo2 = new LabelInfo();
        label.info = labelInfo2;
        return labelInfo2;
    }
}

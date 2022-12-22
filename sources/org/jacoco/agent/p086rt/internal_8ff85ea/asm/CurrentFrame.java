package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.CurrentFrame */
class CurrentFrame extends Frame {
    CurrentFrame() {
    }

    /* access modifiers changed from: package-private */
    public void execute(int i, int i2, ClassWriter classWriter, Item item) {
        super.execute(i, i2, classWriter, item);
        Frame frame = new Frame();
        merge(classWriter, frame, 0);
        set(frame);
        this.owner.inputStackTop = 0;
    }
}

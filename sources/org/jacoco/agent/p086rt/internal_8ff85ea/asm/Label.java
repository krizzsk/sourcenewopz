package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import com.google.common.base.Ascii;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Label */
public class Label {
    static final int DEBUG = 1;
    static final int JSR = 128;
    static final int PUSHED = 8;
    static final int REACHABLE = 64;
    static final int RESIZED = 4;
    static final int RESOLVED = 2;
    static final int RET = 256;
    static final int STORE = 32;
    static final int SUBROUTINE = 512;
    static final int TARGET = 16;
    static final int VISITED = 1024;
    static final int VISITED2 = 2048;
    Frame frame;
    public Object info;
    int inputStackTop;
    int line;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;
    Edge successors;

    public int getOffset() {
        if ((this.status & 2) != 0) {
            return this.position;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    /* access modifiers changed from: package-private */
    public void put(MethodWriter methodWriter, ByteVector byteVector, int i, boolean z) {
        if ((this.status & 2) == 0) {
            if (z) {
                addReference(-1 - i, byteVector.length);
                byteVector.putInt(-1);
                return;
            }
            addReference(i, byteVector.length);
            byteVector.putShort(-1);
        } else if (z) {
            byteVector.putInt(this.position - i);
        } else {
            byteVector.putShort(this.position - i);
        }
    }

    private void addReference(int i, int i2) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i3 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i4 = this.referenceCount;
        int i5 = i4 + 1;
        this.referenceCount = i5;
        iArr3[i4] = i;
        this.referenceCount = i5 + 1;
        iArr3[i5] = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean resolve(MethodWriter methodWriter, int i, byte[] bArr) {
        this.status |= 2;
        this.position = i;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i4 >= 0) {
                int i7 = i - i4;
                if (i7 < -32768 || i7 > 32767) {
                    int i8 = i6 - 1;
                    byte b = bArr[i8] & 255;
                    if (b <= 168) {
                        bArr[i8] = (byte) (b + 49);
                    } else {
                        bArr[i8] = (byte) (b + Ascii.DC4);
                    }
                    z = true;
                }
                bArr[i6] = (byte) (i7 >>> 8);
                bArr[i6 + 1] = (byte) i7;
            } else {
                int i9 = i4 + i + 1;
                int i10 = i6 + 1;
                bArr[i6] = (byte) (i9 >>> 24);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (i9 >>> 16);
                bArr[i11] = (byte) (i9 >>> 8);
                bArr[i11 + 1] = (byte) i9;
            }
            i2 = i5;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public Label getFirst() {
        Frame frame2 = this.frame;
        return frame2 == null ? this : frame2.owner;
    }

    /* access modifiers changed from: package-private */
    public boolean inSubroutine(long j) {
        if ((this.status & 1024) == 0 || (this.srcAndRefPositions[(int) (j >>> 32)] & ((int) j)) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean inSameSubroutine(Label label) {
        if ((this.status & 1024) != 0 && (label.status & 1024) != 0) {
            int i = 0;
            while (true) {
                int[] iArr = this.srcAndRefPositions;
                if (i >= iArr.length) {
                    break;
                } else if ((iArr[i] & label.srcAndRefPositions[i]) != 0) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void addToSubroutine(long j, int i) {
        int i2 = this.status;
        if ((i2 & 1024) == 0) {
            this.status = i2 | 1024;
            this.srcAndRefPositions = new int[((i / 32) + 1)];
        }
        int[] iArr = this.srcAndRefPositions;
        int i3 = (int) (j >>> 32);
        iArr[i3] = iArr[i3] | ((int) j);
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    public void visitSubroutine(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label r5, long r6, int r8) {
        /*
            r4 = this;
            r0 = r4
        L_0x0001:
            if (r0 == 0) goto L_0x005f
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r0.next
            r2 = 0
            r0.next = r2
            if (r5 == 0) goto L_0x0035
            int r2 = r0.status
            r3 = r2 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0011
            goto L_0x003b
        L_0x0011:
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r0.status = r2
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0040
            boolean r2 = r0.inSameSubroutine(r5)
            if (r2 != 0) goto L_0x0040
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r2 = new org.jacoco.agent.rt.internal_8ff85ea.asm.Edge
            r2.<init>()
            int r3 = r0.inputStackTop
            r2.info = r3
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r3 = r5.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r3.successor
            r2.successor = r3
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r3 = r0.successors
            r2.next = r3
            r0.successors = r2
            goto L_0x0040
        L_0x0035:
            boolean r2 = r0.inSubroutine(r6)
            if (r2 == 0) goto L_0x003d
        L_0x003b:
            r0 = r1
            goto L_0x0001
        L_0x003d:
            r0.addToSubroutine(r6, r8)
        L_0x0040:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r2 = r0.successors
        L_0x0042:
            if (r2 == 0) goto L_0x003b
            int r3 = r0.status
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0050
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r3 = r0.successors
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r3 = r3.next
            if (r2 == r3) goto L_0x005c
        L_0x0050:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r2.successor
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r3.next
            if (r3 != 0) goto L_0x005c
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r3 = r2.successor
            r3.next = r1
            org.jacoco.agent.rt.internal_8ff85ea.asm.Label r1 = r2.successor
        L_0x005c:
            org.jacoco.agent.rt.internal_8ff85ea.asm.Edge r2 = r2.next
            goto L_0x0042
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.Label.visitSubroutine(org.jacoco.agent.rt.internal_8ff85ea.asm.Label, long, int):void");
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}

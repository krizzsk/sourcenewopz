package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Item */
final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    Item() {
    }

    Item(int i) {
        this.index = i;
    }

    Item(int i, Item item) {
        this.index = i;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    /* access modifiers changed from: package-private */
    public void set(int i) {
        this.type = 3;
        this.intVal = i;
        this.hashCode = Integer.MAX_VALUE & (3 + i);
    }

    /* access modifiers changed from: package-private */
    public void set(long j) {
        this.type = 5;
        this.longVal = j;
        this.hashCode = Integer.MAX_VALUE & (5 + ((int) j));
    }

    /* access modifiers changed from: package-private */
    public void set(float f) {
        this.type = 4;
        this.intVal = Float.floatToRawIntBits(f);
        this.hashCode = Integer.MAX_VALUE & (this.type + ((int) f));
    }

    /* access modifiers changed from: package-private */
    public void set(double d) {
        this.type = 6;
        this.longVal = Double.doubleToRawLongBits(d);
        this.hashCode = Integer.MAX_VALUE & (this.type + ((int) d));
    }

    /* access modifiers changed from: package-private */
    public void set(int i, String str, String str2, String str3) {
        this.type = i;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i != 1) {
            if (i == 12) {
                this.hashCode = (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (!(i == 16 || i == 30)) {
                if (i == 7) {
                    this.intVal = 0;
                } else if (i != 8) {
                    this.hashCode = (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                    return;
                }
            }
        }
        this.hashCode = (i + str.hashCode()) & Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public void set(String str, String str2, int i) {
        this.type = 18;
        this.longVal = (long) i;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.hashCode = Integer.MAX_VALUE & ((i * str.hashCode() * this.strVal2.hashCode()) + 18);
    }

    /* access modifiers changed from: package-private */
    public void set(int i, int i2) {
        this.type = 33;
        this.intVal = i;
        this.hashCode = i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r9.longVal != r8.longVal) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEqualTo(org.jacoco.agent.p086rt.internal_8ff85ea.asm.Item r9) {
        /*
            r8 = this;
            int r0 = r8.type
            r1 = 1
            if (r0 == r1) goto L_0x0096
            r2 = 12
            r3 = 0
            if (r0 == r2) goto L_0x007f
            r2 = 16
            if (r0 == r2) goto L_0x0096
            r2 = 18
            if (r0 == r2) goto L_0x0060
            switch(r0) {
                case 3: goto L_0x0057;
                case 4: goto L_0x0057;
                case 5: goto L_0x004c;
                case 6: goto L_0x004c;
                case 7: goto L_0x0096;
                case 8: goto L_0x0096;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r0) {
                case 30: goto L_0x0096;
                case 31: goto L_0x0039;
                case 32: goto L_0x004c;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r9.strVal2
            java.lang.String r2 = r8.strVal2
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            java.lang.String r9 = r9.strVal3
            java.lang.String r0 = r8.strVal3
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            return r1
        L_0x0039:
            int r0 = r9.intVal
            int r2 = r8.intVal
            if (r0 != r2) goto L_0x004a
            java.lang.String r9 = r9.strVal1
            java.lang.String r0 = r8.strVal1
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            return r1
        L_0x004c:
            long r4 = r9.longVal
            long r6 = r8.longVal
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            return r1
        L_0x0057:
            int r9 = r9.intVal
            int r0 = r8.intVal
            if (r9 != r0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            return r1
        L_0x0060:
            long r4 = r9.longVal
            long r6 = r8.longVal
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x007d
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x007d
            java.lang.String r9 = r9.strVal2
            java.lang.String r0 = r8.strVal2
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            return r1
        L_0x007f:
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0094
            java.lang.String r9 = r9.strVal2
            java.lang.String r0 = r8.strVal2
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            return r1
        L_0x0096:
            java.lang.String r9 = r9.strVal1
            java.lang.String r0 = r8.strVal1
            boolean r9 = r9.equals(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p086rt.internal_8ff85ea.asm.Item.isEqualTo(org.jacoco.agent.rt.internal_8ff85ea.asm.Item):boolean");
    }
}

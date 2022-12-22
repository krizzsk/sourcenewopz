package org.osgi.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;

public final class BundlePermission extends BasicPermission {
    private static final int ACTION_ALL = 15;
    private static final int ACTION_FRAGMENT = 8;
    private static final int ACTION_HOST = 4;
    static final int ACTION_NONE = 0;
    private static final int ACTION_PROVIDE = 1;
    private static final int ACTION_REQUIRE = 2;
    public static final String FRAGMENT = "fragment";
    public static final String HOST = "host";
    public static final String PROVIDE = "provide";
    public static final String REQUIRE = "require";
    private static final long serialVersionUID = 3257846601685873716L;
    private transient int action_mask;
    private volatile String actions;

    public BundlePermission(String str, String str2) {
        this(str, parseActions(str2));
    }

    BundlePermission(String str, int i) {
        super(str);
        this.actions = null;
        setTransients(i);
    }

    private synchronized void setTransients(int i) {
        if (i == 0 || (i & 15) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
    }

    /* access modifiers changed from: package-private */
    public synchronized int getActionsMask() {
        return this.action_mask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x019a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseActions(java.lang.String r17) {
        /*
            r0 = r17
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            char[] r2 = r17.toCharArray()
            int r3 = r2.length
            r4 = 1
            int r3 = r3 - r4
            if (r3 >= 0) goto L_0x0010
            return r1
        L_0x0010:
            r5 = 0
            r6 = 0
        L_0x0012:
            java.lang.String r7 = "invalid permission: "
            r8 = -1
            if (r3 == r8) goto L_0x01f2
        L_0x0017:
            r5 = 9
            r9 = 12
            r10 = 10
            r11 = 13
            r12 = 32
            if (r3 == r8) goto L_0x0032
            char r13 = r2[r3]
            if (r13 == r12) goto L_0x002f
            if (r13 == r11) goto L_0x002f
            if (r13 == r10) goto L_0x002f
            if (r13 == r9) goto L_0x002f
            if (r13 != r5) goto L_0x0032
        L_0x002f:
            int r3 = r3 + -1
            goto L_0x0017
        L_0x0032:
            r8 = 105(0x69, float:1.47E-43)
            r13 = 79
            r14 = 111(0x6f, float:1.56E-43)
            r15 = 69
            r1 = 82
            r4 = 101(0x65, float:1.42E-43)
            r11 = 114(0x72, float:1.6E-43)
            r9 = 6
            if (r3 < r9) goto L_0x009b
            int r16 = r3 + -6
            char r10 = r2[r16]
            r5 = 112(0x70, float:1.57E-43)
            if (r10 == r5) goto L_0x0051
            char r5 = r2[r16]
            r10 = 80
            if (r5 != r10) goto L_0x009b
        L_0x0051:
            int r5 = r3 + -5
            char r10 = r2[r5]
            if (r10 == r11) goto L_0x005b
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x009b
        L_0x005b:
            int r5 = r3 + -4
            char r10 = r2[r5]
            if (r10 == r14) goto L_0x0065
            char r5 = r2[r5]
            if (r5 != r13) goto L_0x009b
        L_0x0065:
            int r5 = r3 + -3
            char r10 = r2[r5]
            r12 = 118(0x76, float:1.65E-43)
            if (r10 == r12) goto L_0x0073
            char r5 = r2[r5]
            r10 = 86
            if (r5 != r10) goto L_0x009b
        L_0x0073:
            int r5 = r3 + -2
            char r10 = r2[r5]
            if (r10 == r8) goto L_0x007f
            char r5 = r2[r5]
            r10 = 73
            if (r5 != r10) goto L_0x009b
        L_0x007f:
            int r5 = r3 + -1
            char r10 = r2[r5]
            r12 = 100
            if (r10 == r12) goto L_0x008d
            char r5 = r2[r5]
            r10 = 68
            if (r5 != r10) goto L_0x009b
        L_0x008d:
            char r5 = r2[r3]
            if (r5 == r4) goto L_0x0095
            char r5 = r2[r3]
            if (r5 != r15) goto L_0x009b
        L_0x0095:
            r1 = r6 | 3
        L_0x0097:
            r6 = r1
            r12 = 7
            goto L_0x0197
        L_0x009b:
            if (r3 < r9) goto L_0x00ee
            int r5 = r3 + -6
            char r9 = r2[r5]
            if (r9 == r11) goto L_0x00a7
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x00ee
        L_0x00a7:
            int r5 = r3 + -5
            char r9 = r2[r5]
            if (r9 == r4) goto L_0x00b1
            char r5 = r2[r5]
            if (r5 != r15) goto L_0x00ee
        L_0x00b1:
            int r5 = r3 + -4
            char r9 = r2[r5]
            r10 = 113(0x71, float:1.58E-43)
            if (r9 == r10) goto L_0x00bf
            char r5 = r2[r5]
            r9 = 81
            if (r5 != r9) goto L_0x00ee
        L_0x00bf:
            int r5 = r3 + -3
            char r9 = r2[r5]
            r10 = 117(0x75, float:1.64E-43)
            if (r9 == r10) goto L_0x00cd
            char r5 = r2[r5]
            r9 = 85
            if (r5 != r9) goto L_0x00ee
        L_0x00cd:
            int r5 = r3 + -2
            char r9 = r2[r5]
            if (r9 == r8) goto L_0x00d9
            char r5 = r2[r5]
            r8 = 73
            if (r5 != r8) goto L_0x00ee
        L_0x00d9:
            int r5 = r3 + -1
            char r8 = r2[r5]
            if (r8 == r11) goto L_0x00e3
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x00ee
        L_0x00e3:
            char r5 = r2[r3]
            if (r5 == r4) goto L_0x00eb
            char r5 = r2[r3]
            if (r5 != r15) goto L_0x00ee
        L_0x00eb:
            r1 = r6 | 2
            goto L_0x0097
        L_0x00ee:
            r5 = 3
            if (r3 < r5) goto L_0x0129
            int r5 = r3 + -3
            char r8 = r2[r5]
            r9 = 104(0x68, float:1.46E-43)
            if (r8 == r9) goto L_0x00ff
            char r5 = r2[r5]
            r8 = 72
            if (r5 != r8) goto L_0x0129
        L_0x00ff:
            int r5 = r3 + -2
            char r8 = r2[r5]
            if (r8 == r14) goto L_0x0109
            char r5 = r2[r5]
            if (r5 != r13) goto L_0x0129
        L_0x0109:
            int r5 = r3 + -1
            char r8 = r2[r5]
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L_0x0117
            char r5 = r2[r5]
            r8 = 83
            if (r5 != r8) goto L_0x0129
        L_0x0117:
            char r5 = r2[r3]
            r8 = 116(0x74, float:1.63E-43)
            if (r5 == r8) goto L_0x0123
            char r5 = r2[r3]
            r8 = 84
            if (r5 != r8) goto L_0x0129
        L_0x0123:
            r1 = r6 | 4
            r12 = 4
        L_0x0126:
            r6 = r1
            goto L_0x0197
        L_0x0129:
            r5 = 7
            if (r3 < r5) goto L_0x01dd
            int r5 = r3 + -7
            char r8 = r2[r5]
            r9 = 102(0x66, float:1.43E-43)
            if (r8 == r9) goto L_0x013a
            char r5 = r2[r5]
            r8 = 70
            if (r5 != r8) goto L_0x01dd
        L_0x013a:
            int r5 = r3 + -6
            char r8 = r2[r5]
            if (r8 == r11) goto L_0x0144
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x01dd
        L_0x0144:
            int r1 = r3 + -5
            char r5 = r2[r1]
            r8 = 97
            if (r5 == r8) goto L_0x0152
            char r1 = r2[r1]
            r5 = 65
            if (r1 != r5) goto L_0x01dd
        L_0x0152:
            int r1 = r3 + -4
            char r5 = r2[r1]
            r8 = 103(0x67, float:1.44E-43)
            if (r5 == r8) goto L_0x0160
            char r1 = r2[r1]
            r5 = 71
            if (r1 != r5) goto L_0x01dd
        L_0x0160:
            int r1 = r3 + -3
            char r5 = r2[r1]
            r8 = 109(0x6d, float:1.53E-43)
            if (r5 == r8) goto L_0x016e
            char r1 = r2[r1]
            r5 = 77
            if (r1 != r5) goto L_0x01dd
        L_0x016e:
            int r1 = r3 + -2
            char r5 = r2[r1]
            if (r5 == r4) goto L_0x0178
            char r1 = r2[r1]
            if (r1 != r15) goto L_0x01dd
        L_0x0178:
            int r1 = r3 + -1
            char r4 = r2[r1]
            r5 = 110(0x6e, float:1.54E-43)
            if (r4 == r5) goto L_0x0186
            char r1 = r2[r1]
            r4 = 78
            if (r1 != r4) goto L_0x01dd
        L_0x0186:
            char r1 = r2[r3]
            r4 = 116(0x74, float:1.63E-43)
            if (r1 == r4) goto L_0x0192
            char r1 = r2[r3]
            r4 = 84
            if (r1 != r4) goto L_0x01dd
        L_0x0192:
            r12 = 8
            r1 = r6 | 8
            goto L_0x0126
        L_0x0197:
            r5 = 0
        L_0x0198:
            if (r3 < r12) goto L_0x01d8
            if (r5 != 0) goto L_0x01d8
            int r1 = r3 - r12
            char r1 = r2[r1]
            r4 = 9
            r8 = 10
            r9 = 12
            if (r1 == r4) goto L_0x01d2
            if (r1 == r8) goto L_0x01d2
            r10 = 13
            if (r1 == r9) goto L_0x01cf
            r11 = 32
            if (r1 == r10) goto L_0x01d5
            if (r1 == r11) goto L_0x01d5
            r5 = 44
            if (r1 != r5) goto L_0x01ba
            r5 = 1
            goto L_0x01d5
        L_0x01ba:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01cf:
            r11 = 32
            goto L_0x01d5
        L_0x01d2:
            r10 = 13
            goto L_0x01cf
        L_0x01d5:
            int r3 = r3 + -1
            goto L_0x0198
        L_0x01d8:
            int r3 = r3 - r12
            r1 = 0
            r4 = 1
            goto L_0x0012
        L_0x01dd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01f2:
            if (r5 != 0) goto L_0x01f5
            return r6
        L_0x01f5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.BundlePermission.parseActions(java.lang.String):int");
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof BundlePermission)) {
            return false;
        }
        BundlePermission bundlePermission = (BundlePermission) permission;
        int actionsMask = getActionsMask();
        int actionsMask2 = bundlePermission.getActionsMask();
        if ((actionsMask & actionsMask2) != actionsMask2 || !super.implies(bundlePermission)) {
            return false;
        }
        return true;
    }

    public String getActions() {
        String str = this.actions;
        if (str != null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        boolean z2 = true;
        if ((this.action_mask & 1) == 1) {
            stringBuffer.append("provide");
            z = true;
        }
        if ((this.action_mask & 2) == 2) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append("require");
            z = true;
        }
        if ((this.action_mask & 4) == 4) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append("host");
        } else {
            z2 = z;
        }
        if ((this.action_mask & 8) == 8) {
            if (z2) {
                stringBuffer.append(',');
            }
            stringBuffer.append("fragment");
        }
        String stringBuffer2 = stringBuffer.toString();
        this.actions = stringBuffer2;
        return stringBuffer2;
    }

    public PermissionCollection newPermissionCollection() {
        return new BundlePermissionCollection();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundlePermission)) {
            return false;
        }
        BundlePermission bundlePermission = (BundlePermission) obj;
        if (getActionsMask() != bundlePermission.getActionsMask() || !getName().equals(bundlePermission.getName())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((getName().hashCode() + 527) * 31) + getActions().hashCode();
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.actions == null) {
            getActions();
        }
        objectOutputStream.defaultWriteObject();
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setTransients(parseActions(this.actions));
    }
}

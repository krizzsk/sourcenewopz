package org.osgi.framework;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.AccessController;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public final class PackagePermission extends BasicPermission {
    private static final int ACTION_ALL = 3;
    private static final int ACTION_EXPORT = 1;
    private static final int ACTION_IMPORT = 2;
    static final int ACTION_NONE = 0;
    public static final String EXPORT = "export";
    public static final String EXPORTONLY = "exportonly";
    public static final String IMPORT = "import";
    static final long serialVersionUID = -5107705877071099135L;
    transient int action_mask;
    private volatile String actions;
    final transient Bundle bundle;
    transient Filter filter;
    private volatile transient Map<String, Object> properties;

    public PackagePermission(String str, String str2) {
        this(str, parseActions(str2));
        if (this.filter != null && (this.action_mask & 3) != 2) {
            throw new IllegalArgumentException("invalid action string for filter expression");
        }
    }

    public PackagePermission(String str, Bundle bundle2, String str2) {
        super(str);
        this.actions = null;
        setTransients(str, parseActions(str2));
        this.bundle = bundle2;
        if (bundle2 == null) {
            throw new IllegalArgumentException("bundle must not be null");
        } else if (this.filter != null) {
            throw new IllegalArgumentException("invalid name");
        } else if ((this.action_mask & 3) != 2) {
            throw new IllegalArgumentException("invalid action string");
        }
    }

    PackagePermission(String str, int i) {
        super(str);
        this.actions = null;
        setTransients(str, i);
        this.bundle = null;
    }

    private void setTransients(String str, int i) {
        if (i == 0 || (i & 3) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
        this.filter = parseFilter(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0157 A[ADDED_TO_REGION] */
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
            if (r3 == r8) goto L_0x01ad
        L_0x0017:
            r5 = 13
            r9 = 32
            r10 = 10
            r11 = 9
            if (r3 == r8) goto L_0x0032
            char r12 = r2[r3]
            if (r12 == r9) goto L_0x002f
            if (r12 == r5) goto L_0x002f
            if (r12 == r10) goto L_0x002f
            r13 = 12
            if (r12 == r13) goto L_0x002f
            if (r12 != r11) goto L_0x0032
        L_0x002f:
            int r3 = r3 + -1
            goto L_0x0017
        L_0x0032:
            r8 = 84
            r12 = 82
            r13 = 116(0x74, float:1.63E-43)
            r15 = 114(0x72, float:1.6E-43)
            r1 = 80
            r4 = 112(0x70, float:1.57E-43)
            r14 = 79
            r9 = 111(0x6f, float:1.56E-43)
            r5 = 5
            if (r3 < r5) goto L_0x008d
            int r16 = r3 + -5
            char r10 = r2[r16]
            r11 = 105(0x69, float:1.47E-43)
            if (r10 == r11) goto L_0x0053
            char r10 = r2[r16]
            r11 = 73
            if (r10 != r11) goto L_0x008d
        L_0x0053:
            int r10 = r3 + -4
            char r11 = r2[r10]
            r5 = 109(0x6d, float:1.53E-43)
            if (r11 == r5) goto L_0x0061
            char r5 = r2[r10]
            r10 = 77
            if (r5 != r10) goto L_0x008d
        L_0x0061:
            int r5 = r3 + -3
            char r10 = r2[r5]
            if (r10 == r4) goto L_0x006b
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x008d
        L_0x006b:
            int r5 = r3 + -2
            char r10 = r2[r5]
            if (r10 == r9) goto L_0x0075
            char r5 = r2[r5]
            if (r5 != r14) goto L_0x008d
        L_0x0075:
            int r5 = r3 + -1
            char r10 = r2[r5]
            if (r10 == r15) goto L_0x007f
            char r5 = r2[r5]
            if (r5 != r12) goto L_0x008d
        L_0x007f:
            char r5 = r2[r3]
            if (r5 == r13) goto L_0x0087
            char r5 = r2[r3]
            if (r5 != r8) goto L_0x008d
        L_0x0087:
            r1 = r6 | 2
        L_0x0089:
            r6 = r1
            r14 = 6
            goto L_0x0154
        L_0x008d:
            r5 = 101(0x65, float:1.42E-43)
            r10 = 5
            if (r3 < r10) goto L_0x00d5
            int r10 = r3 + -5
            char r11 = r2[r10]
            if (r11 == r5) goto L_0x009e
            char r10 = r2[r10]
            r11 = 69
            if (r10 != r11) goto L_0x00d5
        L_0x009e:
            int r10 = r3 + -4
            char r11 = r2[r10]
            r5 = 120(0x78, float:1.68E-43)
            if (r11 == r5) goto L_0x00ac
            char r5 = r2[r10]
            r10 = 88
            if (r5 != r10) goto L_0x00d5
        L_0x00ac:
            int r5 = r3 + -3
            char r10 = r2[r5]
            if (r10 == r4) goto L_0x00b6
            char r5 = r2[r5]
            if (r5 != r1) goto L_0x00d5
        L_0x00b6:
            int r5 = r3 + -2
            char r10 = r2[r5]
            if (r10 == r9) goto L_0x00c0
            char r5 = r2[r5]
            if (r5 != r14) goto L_0x00d5
        L_0x00c0:
            int r5 = r3 + -1
            char r10 = r2[r5]
            if (r10 == r15) goto L_0x00ca
            char r5 = r2[r5]
            if (r5 != r12) goto L_0x00d5
        L_0x00ca:
            char r5 = r2[r3]
            if (r5 == r13) goto L_0x00d2
            char r5 = r2[r3]
            if (r5 != r8) goto L_0x00d5
        L_0x00d2:
            r1 = r6 | 3
            goto L_0x0089
        L_0x00d5:
            r5 = 9
            if (r3 < r5) goto L_0x0198
            int r5 = r3 + -9
            char r10 = r2[r5]
            r11 = 101(0x65, float:1.42E-43)
            if (r10 == r11) goto L_0x00e7
            char r5 = r2[r5]
            r10 = 69
            if (r5 != r10) goto L_0x0198
        L_0x00e7:
            int r5 = r3 + -8
            char r10 = r2[r5]
            r11 = 120(0x78, float:1.68E-43)
            if (r10 == r11) goto L_0x00f5
            char r5 = r2[r5]
            r10 = 88
            if (r5 != r10) goto L_0x0198
        L_0x00f5:
            int r5 = r3 + -7
            char r10 = r2[r5]
            if (r10 == r4) goto L_0x00ff
            char r4 = r2[r5]
            if (r4 != r1) goto L_0x0198
        L_0x00ff:
            int r1 = r3 + -6
            char r4 = r2[r1]
            if (r4 == r9) goto L_0x0109
            char r1 = r2[r1]
            if (r1 != r14) goto L_0x0198
        L_0x0109:
            int r1 = r3 + -5
            char r4 = r2[r1]
            if (r4 == r15) goto L_0x0113
            char r1 = r2[r1]
            if (r1 != r12) goto L_0x0198
        L_0x0113:
            int r1 = r3 + -4
            char r4 = r2[r1]
            if (r4 == r13) goto L_0x011d
            char r1 = r2[r1]
            if (r1 != r8) goto L_0x0198
        L_0x011d:
            int r1 = r3 + -3
            char r4 = r2[r1]
            if (r4 == r9) goto L_0x0127
            char r1 = r2[r1]
            if (r1 != r14) goto L_0x0198
        L_0x0127:
            int r1 = r3 + -2
            char r4 = r2[r1]
            r5 = 110(0x6e, float:1.54E-43)
            if (r4 == r5) goto L_0x0135
            char r1 = r2[r1]
            r4 = 78
            if (r1 != r4) goto L_0x0198
        L_0x0135:
            int r1 = r3 + -1
            char r4 = r2[r1]
            r5 = 108(0x6c, float:1.51E-43)
            if (r4 == r5) goto L_0x0143
            char r1 = r2[r1]
            r4 = 76
            if (r1 != r4) goto L_0x0198
        L_0x0143:
            char r1 = r2[r3]
            r4 = 121(0x79, float:1.7E-43)
            if (r1 == r4) goto L_0x014f
            char r1 = r2[r3]
            r4 = 89
            if (r1 != r4) goto L_0x0198
        L_0x014f:
            r1 = r6 | 1
            r6 = r1
            r14 = 10
        L_0x0154:
            r5 = 0
        L_0x0155:
            if (r3 < r14) goto L_0x0193
            if (r5 != 0) goto L_0x0193
            int r1 = r3 - r14
            char r1 = r2[r1]
            r4 = 9
            r8 = 10
            if (r1 == r4) goto L_0x018c
            if (r1 == r8) goto L_0x018c
            r9 = 12
            if (r1 == r9) goto L_0x018c
            r9 = 13
            r10 = 32
            if (r1 == r9) goto L_0x0190
            if (r1 == r10) goto L_0x0190
            r5 = 44
            if (r1 != r5) goto L_0x0177
            r5 = 1
            goto L_0x0190
        L_0x0177:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x018c:
            r9 = 13
            r10 = 32
        L_0x0190:
            int r3 = r3 + -1
            goto L_0x0155
        L_0x0193:
            int r3 = r3 - r14
            r1 = 0
            r4 = 1
            goto L_0x0012
        L_0x0198:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01ad:
            if (r5 != 0) goto L_0x01b0
            return r6
        L_0x01b0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.PackagePermission.parseActions(java.lang.String):int");
    }

    private static Filter parseFilter(String str) {
        String trim = str.trim();
        if (trim.charAt(0) != '(') {
            return null;
        }
        try {
            return FrameworkUtil.createFilter(trim);
        } catch (InvalidSyntaxException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid filter");
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof PackagePermission)) {
            return false;
        }
        PackagePermission packagePermission = (PackagePermission) permission;
        if (this.bundle == null && packagePermission.filter == null) {
            return implies0(packagePermission, 0);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean implies0(PackagePermission packagePermission, int i) {
        int i2 = i | this.action_mask;
        int i3 = packagePermission.action_mask;
        if ((i2 & i3) != i3) {
            return false;
        }
        Filter filter2 = this.filter;
        if (filter2 == null) {
            return super.implies(packagePermission);
        }
        return filter2.matches(packagePermission.getProperties());
    }

    public String getActions() {
        String str = this.actions;
        if (str != null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        int i = this.action_mask;
        if ((i & 1) == 1) {
            stringBuffer.append(EXPORTONLY);
            z = true;
        }
        if ((i & 2) == 2) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append(IMPORT);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.actions = stringBuffer2;
        return stringBuffer2;
    }

    public PermissionCollection newPermissionCollection() {
        return new PackagePermissionCollection();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PackagePermission)) {
            return false;
        }
        PackagePermission packagePermission = (PackagePermission) obj;
        if (this.action_mask == packagePermission.action_mask && getName().equals(packagePermission.getName())) {
            Bundle bundle2 = this.bundle;
            Bundle bundle3 = packagePermission.bundle;
            if (bundle2 == bundle3) {
                return true;
            }
            if (bundle2 == null || !bundle2.equals(bundle3)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((getName().hashCode() + 527) * 31) + getActions().hashCode();
        Bundle bundle2 = this.bundle;
        return bundle2 != null ? (hashCode * 31) + bundle2.hashCode() : hashCode;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.bundle == null) {
            if (this.actions == null) {
                getActions();
            }
            objectOutputStream.defaultWriteObject();
        } else {
            throw new NotSerializableException("cannot serialize");
        }
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setTransients(getName(), parseActions(this.actions));
    }

    private Map<String, Object> getProperties() {
        Map<String, Object> map = this.properties;
        if (map != null) {
            return map;
        }
        final HashMap hashMap = new HashMap(5);
        hashMap.put("package.name", getName());
        if (this.bundle != null) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    hashMap.put("id", new Long(PackagePermission.this.bundle.getBundleId()));
                    hashMap.put("location", PackagePermission.this.bundle.getLocation());
                    String symbolicName = PackagePermission.this.bundle.getSymbolicName();
                    if (symbolicName != null) {
                        hashMap.put("name", symbolicName);
                    }
                    SignerProperty signerProperty = new SignerProperty(PackagePermission.this.bundle);
                    if (!signerProperty.isBundleSigned()) {
                        return null;
                    }
                    hashMap.put("signer", signerProperty);
                    return null;
                }
            });
        }
        this.properties = hashMap;
        return hashMap;
    }
}

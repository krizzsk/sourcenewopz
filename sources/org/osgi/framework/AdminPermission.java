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

public final class AdminPermission extends BasicPermission {
    private static final int ACTION_ALL = 4063;
    private static final int ACTION_CLASS = 1;
    private static final int ACTION_CONTEXT = 1024;
    private static final int ACTION_EXECUTE = 2;
    private static final int ACTION_EXTENSIONLIFECYCLE = 512;
    private static final int ACTION_LIFECYCLE = 4;
    private static final int ACTION_LISTENER = 8;
    private static final int ACTION_METADATA = 16;
    static final int ACTION_NONE = 0;
    private static final int ACTION_RESOLVE = 64;
    private static final int ACTION_RESOURCE = 128;
    private static final int ACTION_STARTLEVEL = 256;
    private static final int ACTION_WEAVE = 2048;
    public static final String CLASS = "class";
    public static final String CONTEXT = "context";
    public static final String EXECUTE = "execute";
    public static final String EXTENSIONLIFECYCLE = "extensionLifecycle";
    public static final String LIFECYCLE = "lifecycle";
    public static final String LISTENER = "listener";
    public static final String METADATA = "metadata";
    public static final String RESOLVE = "resolve";
    public static final String RESOURCE = "resource";
    public static final String STARTLEVEL = "startlevel";
    public static final String WEAVE = "weave";
    private static final ThreadLocal<Bundle> recurse = new ThreadLocal<>();
    static final long serialVersionUID = 307051004521261705L;
    transient int action_mask;
    private volatile String actions;
    final transient Bundle bundle;
    transient Filter filter;
    private volatile transient Map<String, Object> properties;

    public AdminPermission() {
        this((Filter) null, 4063);
    }

    public AdminPermission(String str, String str2) {
        this(parseFilter(str), parseActions(str2));
    }

    public AdminPermission(Bundle bundle2, String str) {
        super(createName(bundle2));
        this.actions = null;
        setTransients((Filter) null, parseActions(str));
        this.bundle = bundle2;
    }

    private static String createName(Bundle bundle2) {
        if (bundle2 != null) {
            StringBuffer stringBuffer = new StringBuffer("(id=");
            stringBuffer.append(bundle2.getBundleId());
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("bundle must not be null");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdminPermission(Filter filter2, int i) {
        super(filter2 == null ? "*" : filter2.toString());
        this.actions = null;
        setTransients(filter2, i);
        this.bundle = null;
    }

    private void setTransients(Filter filter2, int i) {
        this.filter = filter2;
        if (i == 0 || (i & 4063) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [char[]] */
    /* JADX WARNING: type inference failed for: r5v3, types: [char] */
    /* JADX WARNING: type inference failed for: r1v16, types: [char] */
    /* JADX WARNING: type inference failed for: r7v6, types: [char] */
    /* JADX WARNING: type inference failed for: r7v7, types: [char] */
    /* JADX WARNING: type inference failed for: r7v8, types: [char] */
    /* JADX WARNING: type inference failed for: r7v9, types: [char] */
    /* JADX WARNING: type inference failed for: r6v9, types: [char] */
    /* JADX WARNING: type inference failed for: r5v6, types: [char] */
    /* JADX WARNING: type inference failed for: r6v10, types: [char] */
    /* JADX WARNING: type inference failed for: r6v11, types: [char] */
    /* JADX WARNING: type inference failed for: r6v12, types: [char] */
    /* JADX WARNING: type inference failed for: r6v13, types: [char] */
    /* JADX WARNING: type inference failed for: r8v8, types: [char] */
    /* JADX WARNING: type inference failed for: r8v9, types: [char] */
    /* JADX WARNING: type inference failed for: r8v10, types: [char] */
    /* JADX WARNING: type inference failed for: r8v11, types: [char] */
    /* JADX WARNING: type inference failed for: r8v12, types: [char] */
    /* JADX WARNING: type inference failed for: r8v13, types: [char] */
    /* JADX WARNING: type inference failed for: r7v19, types: [char] */
    /* JADX WARNING: type inference failed for: r7v20, types: [char] */
    /* JADX WARNING: type inference failed for: r7v21, types: [char] */
    /* JADX WARNING: type inference failed for: r7v22, types: [char] */
    /* JADX WARNING: type inference failed for: r7v23, types: [char] */
    /* JADX WARNING: type inference failed for: r7v24, types: [char] */
    /* JADX WARNING: type inference failed for: r7v25, types: [char] */
    /* JADX WARNING: type inference failed for: r7v26, types: [char] */
    /* JADX WARNING: type inference failed for: r11v1, types: [char] */
    /* JADX WARNING: type inference failed for: r9v4, types: [char] */
    /* JADX WARNING: type inference failed for: r9v5, types: [char] */
    /* JADX WARNING: type inference failed for: r9v6, types: [char] */
    /* JADX WARNING: type inference failed for: r8v18, types: [char] */
    /* JADX WARNING: type inference failed for: r8v19, types: [char] */
    /* JADX WARNING: type inference failed for: r8v20, types: [char] */
    /* JADX WARNING: type inference failed for: r8v21, types: [char] */
    /* JADX WARNING: type inference failed for: r8v22, types: [char] */
    /* JADX WARNING: type inference failed for: r7v35, types: [char] */
    /* JADX WARNING: type inference failed for: r7v36, types: [char] */
    /* JADX WARNING: type inference failed for: r7v37, types: [char] */
    /* JADX WARNING: type inference failed for: r7v38, types: [char] */
    /* JADX WARNING: type inference failed for: r7v39, types: [char] */
    /* JADX WARNING: type inference failed for: r7v40, types: [char] */
    /* JADX WARNING: type inference failed for: r7v41, types: [char] */
    /* JADX WARNING: type inference failed for: r7v42, types: [char] */
    /* JADX WARNING: type inference failed for: r7v43, types: [char] */
    /* JADX WARNING: type inference failed for: r7v44, types: [char] */
    /* JADX WARNING: type inference failed for: r9v9, types: [char] */
    /* JADX WARNING: type inference failed for: r13v1, types: [char] */
    /* JADX WARNING: type inference failed for: r13v2, types: [char] */
    /* JADX WARNING: type inference failed for: r13v3, types: [char] */
    /* JADX WARNING: type inference failed for: r13v4, types: [char] */
    /* JADX WARNING: type inference failed for: r11v6, types: [char] */
    /* JADX WARNING: type inference failed for: r11v7, types: [char] */
    /* JADX WARNING: type inference failed for: r11v8, types: [char] */
    /* JADX WARNING: type inference failed for: r10v15, types: [char] */
    /* JADX WARNING: type inference failed for: r10v16, types: [char] */
    /* JADX WARNING: type inference failed for: r10v17, types: [char] */
    /* JADX WARNING: type inference failed for: r10v18, types: [char] */
    /* JADX WARNING: type inference failed for: r10v19, types: [char] */
    /* JADX WARNING: type inference failed for: r10v20, types: [char] */
    /* JADX WARNING: type inference failed for: r11v13, types: [char] */
    /* JADX WARNING: type inference failed for: r11v14, types: [char] */
    /* JADX WARNING: type inference failed for: r11v15, types: [char] */
    /* JADX WARNING: type inference failed for: r11v16, types: [char] */
    /* JADX WARNING: type inference failed for: r11v17, types: [char] */
    /* JADX WARNING: type inference failed for: r11v18, types: [char] */
    /* JADX WARNING: type inference failed for: r11v19, types: [char] */
    /* JADX WARNING: type inference failed for: r11v20, types: [char] */
    /* JADX WARNING: type inference failed for: r11v21, types: [char] */
    /* JADX WARNING: type inference failed for: r10v27, types: [char] */
    /* JADX WARNING: type inference failed for: r10v28, types: [char] */
    /* JADX WARNING: type inference failed for: r10v29, types: [char] */
    /* JADX WARNING: type inference failed for: r10v30, types: [char] */
    /* JADX WARNING: type inference failed for: r10v31, types: [char] */
    /* JADX WARNING: type inference failed for: r10v32, types: [char] */
    /* JADX WARNING: type inference failed for: r10v33, types: [char] */
    /* JADX WARNING: type inference failed for: r10v34, types: [char] */
    /* JADX WARNING: type inference failed for: r11v26, types: [char] */
    /* JADX WARNING: type inference failed for: r11v27, types: [char] */
    /* JADX WARNING: type inference failed for: r11v28, types: [char] */
    /* JADX WARNING: type inference failed for: r11v29, types: [char] */
    /* JADX WARNING: type inference failed for: r11v30, types: [char] */
    /* JADX WARNING: type inference failed for: r11v31, types: [char] */
    /* JADX WARNING: type inference failed for: r11v32, types: [char] */
    /* JADX WARNING: type inference failed for: r10v42, types: [char] */
    /* JADX WARNING: type inference failed for: r10v43, types: [char] */
    /* JADX WARNING: type inference failed for: r10v44, types: [char] */
    /* JADX WARNING: type inference failed for: r10v45, types: [char] */
    /* JADX WARNING: type inference failed for: r10v46, types: [char] */
    /* JADX WARNING: type inference failed for: r10v47, types: [char] */
    /* JADX WARNING: type inference failed for: r10v48, types: [char] */
    /* JADX WARNING: type inference failed for: r10v49, types: [char] */
    /* JADX WARNING: type inference failed for: r10v50, types: [char] */
    /* JADX WARNING: type inference failed for: r13v13, types: [char] */
    /* JADX WARNING: type inference failed for: r13v14, types: [char] */
    /* JADX WARNING: type inference failed for: r11v40, types: [char] */
    /* JADX WARNING: type inference failed for: r11v41, types: [char] */
    /* JADX WARNING: type inference failed for: r11v42, types: [char] */
    /* JADX WARNING: type inference failed for: r11v43, types: [char] */
    /* JADX WARNING: type inference failed for: r11v44, types: [char] */
    /* JADX WARNING: type inference failed for: r10v59, types: [char] */
    /* JADX WARNING: type inference failed for: r10v60, types: [char] */
    /* JADX WARNING: type inference failed for: r10v61, types: [char] */
    /* JADX WARNING: type inference failed for: r10v62, types: [char] */
    /* JADX WARNING: type inference failed for: r10v63, types: [char] */
    /* JADX WARNING: type inference failed for: r10v64, types: [char] */
    /* JADX WARNING: type inference failed for: r10v65, types: [char] */
    /* JADX WARNING: type inference failed for: r10v66, types: [char] */
    /* JADX WARNING: type inference failed for: r10v68, types: [char] */
    /* JADX WARNING: type inference failed for: r13v17, types: [char] */
    /* JADX WARNING: type inference failed for: r13v18, types: [char] */
    /* JADX WARNING: type inference failed for: r10v71, types: [char] */
    /* JADX WARNING: type inference failed for: r10v72, types: [char] */
    /* JADX WARNING: type inference failed for: r10v73, types: [char] */
    /* JADX WARNING: type inference failed for: r10v74, types: [char] */
    /* JADX WARNING: type inference failed for: r10v75, types: [char] */
    /* JADX WARNING: type inference failed for: r10v76, types: [char] */
    /* JADX WARNING: type inference failed for: r8v34, types: [char] */
    /* JADX WARNING: type inference failed for: r8v35, types: [char] */
    /* JADX WARNING: type inference failed for: r8v36, types: [char] */
    /* JADX WARNING: type inference failed for: r8v37, types: [char] */
    /* JADX WARNING: type inference failed for: r8v38, types: [char] */
    /* JADX WARNING: type inference failed for: r8v39, types: [char] */
    /* JADX WARNING: type inference failed for: r8v40, types: [char] */
    /* JADX WARNING: type inference failed for: r8v41, types: [char] */
    /* JADX WARNING: type inference failed for: r8v42, types: [char] */
    /* JADX WARNING: type inference failed for: r10v82, types: [char] */
    /* JADX WARNING: type inference failed for: r10v83, types: [char] */
    /* JADX WARNING: type inference failed for: r10v84, types: [char] */
    /* JADX WARNING: type inference failed for: r10v85, types: [char] */
    /* JADX WARNING: type inference failed for: r10v86, types: [char] */
    /* JADX WARNING: type inference failed for: r10v87, types: [char] */
    /* JADX WARNING: type inference failed for: r10v88, types: [char] */
    /* JADX WARNING: type inference failed for: r10v89, types: [char] */
    /* JADX WARNING: type inference failed for: r10v90, types: [char] */
    /* JADX WARNING: type inference failed for: r10v91, types: [char] */
    /* JADX WARNING: type inference failed for: r10v92, types: [char] */
    /* JADX WARNING: type inference failed for: r10v93, types: [char] */
    /* JADX WARNING: type inference failed for: r10v94, types: [char] */
    /* JADX WARNING: type inference failed for: r10v95, types: [char] */
    /* JADX WARNING: type inference failed for: r10v96, types: [char] */
    /* JADX WARNING: type inference failed for: r10v97, types: [char] */
    /* JADX WARNING: type inference failed for: r10v98, types: [char] */
    /* JADX WARNING: type inference failed for: r10v99, types: [char] */
    /* JADX WARNING: type inference failed for: r8v60, types: [char] */
    /* JADX WARNING: type inference failed for: r8v61, types: [char] */
    /* JADX WARNING: type inference failed for: r8v62, types: [char] */
    /* JADX WARNING: type inference failed for: r8v63, types: [char] */
    /* JADX WARNING: type inference failed for: r8v64, types: [char] */
    /* JADX WARNING: type inference failed for: r8v65, types: [char] */
    /* JADX WARNING: type inference failed for: r8v66, types: [char] */
    /* JADX WARNING: type inference failed for: r8v67, types: [char] */
    /* JADX WARNING: type inference failed for: r8v68, types: [char] */
    /* JADX WARNING: type inference failed for: r8v69, types: [char] */
    /* JADX WARNING: type inference failed for: r8v70, types: [char] */
    /* JADX WARNING: type inference failed for: r8v71, types: [char] */
    /* JADX WARNING: type inference failed for: r8v72, types: [char] */
    /* JADX WARNING: type inference failed for: r8v73, types: [char] */
    /* JADX WARNING: type inference failed for: r8v74, types: [char] */
    /* JADX WARNING: type inference failed for: r8v75, types: [char] */
    /* JADX WARNING: type inference failed for: r8v76, types: [char] */
    /* JADX WARNING: type inference failed for: r8v77, types: [char] */
    /* JADX WARNING: type inference failed for: r8v78, types: [char] */
    /* JADX WARNING: type inference failed for: r8v79, types: [char] */
    /* JADX WARNING: type inference failed for: r10v112, types: [char] */
    /* JADX WARNING: type inference failed for: r10v113, types: [char] */
    /* JADX WARNING: type inference failed for: r10v114, types: [char] */
    /* JADX WARNING: type inference failed for: r10v115, types: [char] */
    /* JADX WARNING: type inference failed for: r10v116, types: [char] */
    /* JADX WARNING: type inference failed for: r8v85, types: [char] */
    /* JADX WARNING: type inference failed for: r8v86, types: [char] */
    /* JADX WARNING: type inference failed for: r8v87, types: [char] */
    /* JADX WARNING: type inference failed for: r8v88, types: [char] */
    /* JADX WARNING: type inference failed for: r8v89, types: [char] */
    /* JADX WARNING: type inference failed for: r8v90, types: [char] */
    /* JADX WARNING: type inference failed for: r8v91, types: [char] */
    /* JADX WARNING: type inference failed for: r8v92, types: [char] */
    /* JADX WARNING: type inference failed for: r15v2, types: [char] */
    /* JADX WARNING: type inference failed for: r6v14, types: [char] */
    /* JADX WARNING: type inference failed for: r15v4, types: [char] */
    /* JADX WARNING: type inference failed for: r15v5, types: [char] */
    /* JADX WARNING: type inference failed for: r6v17, types: [char] */
    /* JADX WARNING: type inference failed for: r6v18, types: [char] */
    /* JADX WARNING: type inference failed for: r6v19, types: [char] */
    /* JADX WARNING: type inference failed for: r6v20, types: [char] */
    /* JADX WARNING: type inference failed for: r6v21, types: [char] */
    /* JADX WARNING: type inference failed for: r15v6, types: [char] */
    /* JADX WARNING: type inference failed for: r1v32, types: [char] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x04e2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:459:0x0502 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseActions(java.lang.String r18) {
        /*
            r0 = r18
            if (r0 == 0) goto L_0x0551
            java.lang.String r1 = "*"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x000e
            goto L_0x0551
        L_0x000e:
            r1 = 0
            r2 = 0
            char[] r3 = r18.toCharArray()
            int r4 = r3.length
            r5 = 1
            int r4 = r4 - r5
            if (r4 >= 0) goto L_0x001a
            return r2
        L_0x001a:
            r6 = -1
            if (r4 == r6) goto L_0x0537
        L_0x001d:
            r1 = -1
            r6 = 9
            if (r4 == r1) goto L_0x0039
            char r1 = r3[r4]
            r7 = 32
            if (r1 == r7) goto L_0x0036
            r7 = 13
            if (r1 == r7) goto L_0x0036
            r7 = 10
            if (r1 == r7) goto L_0x0036
            r7 = 12
            if (r1 == r7) goto L_0x0036
            if (r1 != r6) goto L_0x0039
        L_0x0036:
            int r4 = r4 + -1
            goto L_0x001d
        L_0x0039:
            r1 = 97
            r7 = 83
            r8 = 65
            r9 = 115(0x73, float:1.61E-43)
            r11 = 67
            r12 = 99
            r13 = 76
            r14 = 108(0x6c, float:1.51E-43)
            r15 = 4
            if (r4 < r15) goto L_0x0082
            int r16 = r4 + -4
            char r15 = r3[r16]
            if (r15 == r12) goto L_0x0056
            char r15 = r3[r16]
            if (r15 != r11) goto L_0x0082
        L_0x0056:
            int r15 = r4 + -3
            char r6 = r3[r15]
            if (r6 == r14) goto L_0x0060
            char r6 = r3[r15]
            if (r6 != r13) goto L_0x0082
        L_0x0060:
            int r6 = r4 + -2
            char r15 = r3[r6]
            if (r15 == r1) goto L_0x006a
            char r6 = r3[r6]
            if (r6 != r8) goto L_0x0082
        L_0x006a:
            int r6 = r4 + -1
            char r15 = r3[r6]
            if (r15 == r9) goto L_0x0074
            char r6 = r3[r6]
            if (r6 != r7) goto L_0x0082
        L_0x0074:
            char r6 = r3[r4]
            if (r6 == r9) goto L_0x007c
            char r6 = r3[r4]
            if (r6 != r7) goto L_0x0082
        L_0x007c:
            r1 = r2 | 65
        L_0x007e:
            r2 = r1
            r10 = 5
            goto L_0x04df
        L_0x0082:
            r6 = 84
            r15 = 116(0x74, float:1.63E-43)
            r8 = 6
            r1 = 69
            r5 = 101(0x65, float:1.42E-43)
            if (r4 < r8) goto L_0x00df
            int r17 = r4 + -6
            char r8 = r3[r17]
            if (r8 == r5) goto L_0x0097
            char r8 = r3[r17]
            if (r8 != r1) goto L_0x00df
        L_0x0097:
            int r8 = r4 + -5
            char r10 = r3[r8]
            r13 = 120(0x78, float:1.68E-43)
            if (r10 == r13) goto L_0x00a5
            char r8 = r3[r8]
            r10 = 88
            if (r8 != r10) goto L_0x00df
        L_0x00a5:
            int r8 = r4 + -4
            char r10 = r3[r8]
            if (r10 == r5) goto L_0x00af
            char r8 = r3[r8]
            if (r8 != r1) goto L_0x00df
        L_0x00af:
            int r8 = r4 + -3
            char r10 = r3[r8]
            if (r10 == r12) goto L_0x00b9
            char r8 = r3[r8]
            if (r8 != r11) goto L_0x00df
        L_0x00b9:
            int r8 = r4 + -2
            char r10 = r3[r8]
            r13 = 117(0x75, float:1.64E-43)
            if (r10 == r13) goto L_0x00c7
            char r8 = r3[r8]
            r10 = 85
            if (r8 != r10) goto L_0x00df
        L_0x00c7:
            int r8 = r4 + -1
            char r10 = r3[r8]
            if (r10 == r15) goto L_0x00d1
            char r8 = r3[r8]
            if (r8 != r6) goto L_0x00df
        L_0x00d1:
            char r8 = r3[r4]
            if (r8 == r5) goto L_0x00d9
            char r8 = r3[r4]
            if (r8 != r1) goto L_0x00df
        L_0x00d9:
            r1 = r2 | 66
        L_0x00db:
            r2 = r1
            r10 = 7
            goto L_0x04df
        L_0x00df:
            r8 = 17
            if (r4 < r8) goto L_0x01bf
            int r8 = r4 + -17
            char r10 = r3[r8]
            if (r10 == r5) goto L_0x00ed
            char r8 = r3[r8]
            if (r8 != r1) goto L_0x01bf
        L_0x00ed:
            int r8 = r4 + -16
            char r10 = r3[r8]
            r13 = 120(0x78, float:1.68E-43)
            if (r10 == r13) goto L_0x00fb
            char r8 = r3[r8]
            r10 = 88
            if (r8 != r10) goto L_0x01bf
        L_0x00fb:
            int r8 = r4 + -15
            char r10 = r3[r8]
            if (r10 == r15) goto L_0x0105
            char r8 = r3[r8]
            if (r8 != r6) goto L_0x01bf
        L_0x0105:
            int r8 = r4 + -14
            char r10 = r3[r8]
            if (r10 == r5) goto L_0x010f
            char r8 = r3[r8]
            if (r8 != r1) goto L_0x01bf
        L_0x010f:
            int r8 = r4 + -13
            char r10 = r3[r8]
            r13 = 110(0x6e, float:1.54E-43)
            if (r10 == r13) goto L_0x011d
            char r8 = r3[r8]
            r10 = 78
            if (r8 != r10) goto L_0x01bf
        L_0x011d:
            int r8 = r4 + -12
            char r10 = r3[r8]
            if (r10 == r9) goto L_0x0127
            char r8 = r3[r8]
            if (r8 != r7) goto L_0x01bf
        L_0x0127:
            int r8 = r4 + -11
            char r10 = r3[r8]
            r13 = 105(0x69, float:1.47E-43)
            if (r10 == r13) goto L_0x0135
            char r8 = r3[r8]
            r10 = 73
            if (r8 != r10) goto L_0x01bf
        L_0x0135:
            int r8 = r4 + -10
            char r10 = r3[r8]
            r13 = 111(0x6f, float:1.56E-43)
            if (r10 == r13) goto L_0x0143
            char r8 = r3[r8]
            r10 = 79
            if (r8 != r10) goto L_0x01bf
        L_0x0143:
            int r8 = r4 + -9
            char r10 = r3[r8]
            r13 = 110(0x6e, float:1.54E-43)
            if (r10 == r13) goto L_0x0151
            char r8 = r3[r8]
            r10 = 78
            if (r8 != r10) goto L_0x01bf
        L_0x0151:
            int r8 = r4 + -8
            char r10 = r3[r8]
            if (r10 == r14) goto L_0x015d
            char r8 = r3[r8]
            r10 = 76
            if (r8 != r10) goto L_0x01bf
        L_0x015d:
            int r8 = r4 + -7
            char r10 = r3[r8]
            r13 = 105(0x69, float:1.47E-43)
            if (r10 == r13) goto L_0x016b
            char r8 = r3[r8]
            r10 = 73
            if (r8 != r10) goto L_0x01bf
        L_0x016b:
            int r8 = r4 + -6
            char r10 = r3[r8]
            r13 = 102(0x66, float:1.43E-43)
            if (r10 == r13) goto L_0x0179
            char r8 = r3[r8]
            r10 = 70
            if (r8 != r10) goto L_0x01bf
        L_0x0179:
            int r8 = r4 + -5
            char r10 = r3[r8]
            if (r10 == r5) goto L_0x0183
            char r8 = r3[r8]
            if (r8 != r1) goto L_0x01bf
        L_0x0183:
            int r8 = r4 + -4
            char r10 = r3[r8]
            if (r10 == r12) goto L_0x018d
            char r8 = r3[r8]
            if (r8 != r11) goto L_0x01bf
        L_0x018d:
            int r8 = r4 + -3
            char r10 = r3[r8]
            r13 = 121(0x79, float:1.7E-43)
            if (r10 == r13) goto L_0x019b
            char r8 = r3[r8]
            r10 = 89
            if (r8 != r10) goto L_0x01bf
        L_0x019b:
            int r8 = r4 + -2
            char r10 = r3[r8]
            if (r10 == r12) goto L_0x01a5
            char r8 = r3[r8]
            if (r8 != r11) goto L_0x01bf
        L_0x01a5:
            int r8 = r4 + -1
            char r10 = r3[r8]
            if (r10 == r14) goto L_0x01b1
            char r8 = r3[r8]
            r10 = 76
            if (r8 != r10) goto L_0x01bf
        L_0x01b1:
            char r8 = r3[r4]
            if (r8 == r5) goto L_0x01b9
            char r8 = r3[r4]
            if (r8 != r1) goto L_0x01bf
        L_0x01b9:
            r10 = 18
            r1 = r2 | 512(0x200, float:7.175E-43)
            goto L_0x0434
        L_0x01bf:
            r8 = 8
            if (r4 < r8) goto L_0x0232
            int r10 = r4 + -8
            char r13 = r3[r10]
            if (r13 == r14) goto L_0x01cf
            char r10 = r3[r10]
            r13 = 76
            if (r10 != r13) goto L_0x0232
        L_0x01cf:
            int r10 = r4 + -7
            char r13 = r3[r10]
            r8 = 105(0x69, float:1.47E-43)
            if (r13 == r8) goto L_0x01dd
            char r8 = r3[r10]
            r10 = 73
            if (r8 != r10) goto L_0x0232
        L_0x01dd:
            int r8 = r4 + -6
            char r10 = r3[r8]
            r13 = 102(0x66, float:1.43E-43)
            if (r10 == r13) goto L_0x01eb
            char r8 = r3[r8]
            r10 = 70
            if (r8 != r10) goto L_0x0232
        L_0x01eb:
            int r8 = r4 + -5
            char r10 = r3[r8]
            if (r10 == r5) goto L_0x01f5
            char r8 = r3[r8]
            if (r8 != r1) goto L_0x0232
        L_0x01f5:
            int r8 = r4 + -4
            char r10 = r3[r8]
            if (r10 == r12) goto L_0x01ff
            char r8 = r3[r8]
            if (r8 != r11) goto L_0x0232
        L_0x01ff:
            int r8 = r4 + -3
            char r10 = r3[r8]
            r13 = 121(0x79, float:1.7E-43)
            if (r10 == r13) goto L_0x020d
            char r8 = r3[r8]
            r10 = 89
            if (r8 != r10) goto L_0x0232
        L_0x020d:
            int r8 = r4 + -2
            char r10 = r3[r8]
            if (r10 == r12) goto L_0x0217
            char r8 = r3[r8]
            if (r8 != r11) goto L_0x0232
        L_0x0217:
            int r8 = r4 + -1
            char r10 = r3[r8]
            if (r10 == r14) goto L_0x0223
            char r8 = r3[r8]
            r10 = 76
            if (r8 != r10) goto L_0x0232
        L_0x0223:
            char r8 = r3[r4]
            if (r8 == r5) goto L_0x022b
            char r8 = r3[r4]
            if (r8 != r1) goto L_0x0232
        L_0x022b:
            r1 = r2 | 4
            r2 = r1
            r10 = 9
            goto L_0x04df
        L_0x0232:
            r8 = 114(0x72, float:1.6E-43)
            r10 = 7
            if (r4 < r10) goto L_0x029b
            int r10 = r4 + -7
            char r13 = r3[r10]
            if (r13 == r14) goto L_0x0246
            char r10 = r3[r10]
            r13 = 76
            if (r10 != r13) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            r10 = 7
            goto L_0x029b
        L_0x0246:
            int r10 = r4 + -6
            char r13 = r3[r10]
            r11 = 105(0x69, float:1.47E-43)
            if (r13 == r11) goto L_0x0254
            char r10 = r3[r10]
            r11 = 73
            if (r10 != r11) goto L_0x0244
        L_0x0254:
            int r10 = r4 + -5
            char r11 = r3[r10]
            if (r11 == r9) goto L_0x025e
            char r10 = r3[r10]
            if (r10 != r7) goto L_0x0244
        L_0x025e:
            int r10 = r4 + -4
            char r11 = r3[r10]
            if (r11 == r15) goto L_0x0268
            char r10 = r3[r10]
            if (r10 != r6) goto L_0x0244
        L_0x0268:
            int r10 = r4 + -3
            char r11 = r3[r10]
            if (r11 == r5) goto L_0x0272
            char r10 = r3[r10]
            if (r10 != r1) goto L_0x0244
        L_0x0272:
            int r10 = r4 + -2
            char r11 = r3[r10]
            r13 = 110(0x6e, float:1.54E-43)
            if (r11 == r13) goto L_0x0280
            char r10 = r3[r10]
            r11 = 78
            if (r10 != r11) goto L_0x0244
        L_0x0280:
            int r10 = r4 + -1
            char r11 = r3[r10]
            if (r11 == r5) goto L_0x028a
            char r10 = r3[r10]
            if (r10 != r1) goto L_0x0244
        L_0x028a:
            char r10 = r3[r4]
            if (r10 == r8) goto L_0x0294
            char r10 = r3[r4]
            r11 = 82
            if (r10 != r11) goto L_0x0244
        L_0x0294:
            r1 = r2 | 8
        L_0x0296:
            r2 = r1
            r10 = 8
            goto L_0x04df
        L_0x029b:
            if (r4 < r10) goto L_0x0302
            int r10 = r4 + -7
            char r11 = r3[r10]
            r13 = 109(0x6d, float:1.53E-43)
            if (r11 == r13) goto L_0x02ab
            char r10 = r3[r10]
            r11 = 77
            if (r10 != r11) goto L_0x0302
        L_0x02ab:
            int r10 = r4 + -6
            char r11 = r3[r10]
            if (r11 == r5) goto L_0x02b5
            char r10 = r3[r10]
            if (r10 != r1) goto L_0x0302
        L_0x02b5:
            int r10 = r4 + -5
            char r11 = r3[r10]
            if (r11 == r15) goto L_0x02bf
            char r10 = r3[r10]
            if (r10 != r6) goto L_0x0302
        L_0x02bf:
            int r10 = r4 + -4
            char r11 = r3[r10]
            r13 = 97
            if (r11 == r13) goto L_0x02cd
            char r10 = r3[r10]
            r11 = 65
            if (r10 != r11) goto L_0x0302
        L_0x02cd:
            int r10 = r4 + -3
            char r11 = r3[r10]
            r13 = 100
            if (r11 == r13) goto L_0x02db
            char r10 = r3[r10]
            r11 = 68
            if (r10 != r11) goto L_0x0302
        L_0x02db:
            int r10 = r4 + -2
            char r11 = r3[r10]
            r13 = 97
            if (r11 == r13) goto L_0x02e9
            char r10 = r3[r10]
            r11 = 65
            if (r10 != r11) goto L_0x0302
        L_0x02e9:
            int r10 = r4 + -1
            char r11 = r3[r10]
            if (r11 == r15) goto L_0x02f3
            char r10 = r3[r10]
            if (r10 != r6) goto L_0x0302
        L_0x02f3:
            char r10 = r3[r4]
            r11 = 97
            if (r10 == r11) goto L_0x02ff
            char r10 = r3[r4]
            r11 = 65
            if (r10 != r11) goto L_0x0302
        L_0x02ff:
            r1 = r2 | 16
            goto L_0x0296
        L_0x0302:
            r10 = 6
            if (r4 < r10) goto L_0x0359
            int r10 = r4 + -6
            char r11 = r3[r10]
            if (r11 == r8) goto L_0x0311
            char r10 = r3[r10]
            r11 = 82
            if (r10 != r11) goto L_0x0359
        L_0x0311:
            int r10 = r4 + -5
            char r11 = r3[r10]
            if (r11 == r5) goto L_0x031b
            char r10 = r3[r10]
            if (r10 != r1) goto L_0x0359
        L_0x031b:
            int r10 = r4 + -4
            char r11 = r3[r10]
            if (r11 == r9) goto L_0x0325
            char r10 = r3[r10]
            if (r10 != r7) goto L_0x0359
        L_0x0325:
            int r10 = r4 + -3
            char r11 = r3[r10]
            r13 = 111(0x6f, float:1.56E-43)
            if (r11 == r13) goto L_0x0333
            char r10 = r3[r10]
            r11 = 79
            if (r10 != r11) goto L_0x0359
        L_0x0333:
            int r10 = r4 + -2
            char r11 = r3[r10]
            if (r11 == r14) goto L_0x033f
            char r10 = r3[r10]
            r11 = 76
            if (r10 != r11) goto L_0x0359
        L_0x033f:
            int r10 = r4 + -1
            char r11 = r3[r10]
            r13 = 118(0x76, float:1.65E-43)
            if (r11 == r13) goto L_0x034d
            char r10 = r3[r10]
            r11 = 86
            if (r10 != r11) goto L_0x0359
        L_0x034d:
            char r10 = r3[r4]
            if (r10 == r5) goto L_0x0355
            char r10 = r3[r4]
            if (r10 != r1) goto L_0x0359
        L_0x0355:
            r1 = r2 | 64
            goto L_0x00db
        L_0x0359:
            r10 = 7
            if (r4 < r10) goto L_0x03bc
            int r11 = r4 + -7
            char r13 = r3[r11]
            if (r13 == r8) goto L_0x0368
            char r11 = r3[r11]
            r13 = 82
            if (r11 != r13) goto L_0x03bc
        L_0x0368:
            int r11 = r4 + -6
            char r13 = r3[r11]
            if (r13 == r5) goto L_0x0372
            char r11 = r3[r11]
            if (r11 != r1) goto L_0x03bc
        L_0x0372:
            int r11 = r4 + -5
            char r13 = r3[r11]
            if (r13 == r9) goto L_0x037c
            char r11 = r3[r11]
            if (r11 != r7) goto L_0x03bc
        L_0x037c:
            int r11 = r4 + -4
            char r13 = r3[r11]
            r10 = 111(0x6f, float:1.56E-43)
            if (r13 == r10) goto L_0x038a
            char r10 = r3[r11]
            r11 = 79
            if (r10 != r11) goto L_0x03bc
        L_0x038a:
            int r10 = r4 + -3
            char r11 = r3[r10]
            r13 = 117(0x75, float:1.64E-43)
            if (r11 == r13) goto L_0x0398
            char r10 = r3[r10]
            r11 = 85
            if (r10 != r11) goto L_0x03bc
        L_0x0398:
            int r10 = r4 + -2
            char r11 = r3[r10]
            if (r11 == r8) goto L_0x03a4
            char r10 = r3[r10]
            r11 = 82
            if (r10 != r11) goto L_0x03bc
        L_0x03a4:
            int r10 = r4 + -1
            char r11 = r3[r10]
            if (r11 == r12) goto L_0x03b0
            char r10 = r3[r10]
            r11 = 67
            if (r10 != r11) goto L_0x03bc
        L_0x03b0:
            char r10 = r3[r4]
            if (r10 == r5) goto L_0x03b8
            char r10 = r3[r4]
            if (r10 != r1) goto L_0x03bc
        L_0x03b8:
            r1 = r2 | 192(0xc0, float:2.69E-43)
            goto L_0x0296
        L_0x03bc:
            r10 = 9
            if (r4 < r10) goto L_0x0437
            int r10 = r4 + -9
            char r11 = r3[r10]
            if (r11 == r9) goto L_0x03ca
            char r9 = r3[r10]
            if (r9 != r7) goto L_0x0437
        L_0x03ca:
            int r7 = r4 + -8
            char r9 = r3[r7]
            if (r9 == r15) goto L_0x03d4
            char r7 = r3[r7]
            if (r7 != r6) goto L_0x0437
        L_0x03d4:
            int r7 = r4 + -7
            char r9 = r3[r7]
            r10 = 97
            if (r9 == r10) goto L_0x03e2
            char r7 = r3[r7]
            r9 = 65
            if (r7 != r9) goto L_0x0437
        L_0x03e2:
            int r7 = r4 + -6
            char r9 = r3[r7]
            if (r9 == r8) goto L_0x03ee
            char r7 = r3[r7]
            r8 = 82
            if (r7 != r8) goto L_0x0437
        L_0x03ee:
            int r7 = r4 + -5
            char r8 = r3[r7]
            if (r8 == r15) goto L_0x03f8
            char r7 = r3[r7]
            if (r7 != r6) goto L_0x0437
        L_0x03f8:
            int r7 = r4 + -4
            char r8 = r3[r7]
            if (r8 == r14) goto L_0x0404
            char r7 = r3[r7]
            r8 = 76
            if (r7 != r8) goto L_0x0437
        L_0x0404:
            int r7 = r4 + -3
            char r8 = r3[r7]
            if (r8 == r5) goto L_0x040e
            char r7 = r3[r7]
            if (r7 != r1) goto L_0x0437
        L_0x040e:
            int r7 = r4 + -2
            char r8 = r3[r7]
            r9 = 118(0x76, float:1.65E-43)
            if (r8 == r9) goto L_0x041c
            char r7 = r3[r7]
            r8 = 86
            if (r7 != r8) goto L_0x0437
        L_0x041c:
            int r7 = r4 + -1
            char r8 = r3[r7]
            if (r8 == r5) goto L_0x0426
            char r7 = r3[r7]
            if (r7 != r1) goto L_0x0437
        L_0x0426:
            char r7 = r3[r4]
            if (r7 == r14) goto L_0x0430
            char r7 = r3[r4]
            r8 = 76
            if (r7 != r8) goto L_0x0437
        L_0x0430:
            r10 = 10
            r1 = r2 | 256(0x100, float:3.59E-43)
        L_0x0434:
            r2 = r1
            goto L_0x04df
        L_0x0437:
            r7 = 6
            if (r4 < r7) goto L_0x0490
            int r7 = r4 + -6
            char r8 = r3[r7]
            if (r8 == r12) goto L_0x0446
            char r7 = r3[r7]
            r8 = 67
            if (r7 != r8) goto L_0x0490
        L_0x0446:
            int r7 = r4 + -5
            char r8 = r3[r7]
            r9 = 111(0x6f, float:1.56E-43)
            if (r8 == r9) goto L_0x0454
            char r7 = r3[r7]
            r8 = 79
            if (r7 != r8) goto L_0x0490
        L_0x0454:
            int r7 = r4 + -4
            char r8 = r3[r7]
            r9 = 110(0x6e, float:1.54E-43)
            if (r8 == r9) goto L_0x0462
            char r7 = r3[r7]
            r8 = 78
            if (r7 != r8) goto L_0x0490
        L_0x0462:
            int r7 = r4 + -3
            char r8 = r3[r7]
            if (r8 == r15) goto L_0x046c
            char r7 = r3[r7]
            if (r7 != r6) goto L_0x0490
        L_0x046c:
            int r7 = r4 + -2
            char r8 = r3[r7]
            if (r8 == r5) goto L_0x0476
            char r7 = r3[r7]
            if (r7 != r1) goto L_0x0490
        L_0x0476:
            int r7 = r4 + -1
            char r8 = r3[r7]
            r9 = 120(0x78, float:1.68E-43)
            if (r8 == r9) goto L_0x0484
            char r7 = r3[r7]
            r8 = 88
            if (r7 != r8) goto L_0x0490
        L_0x0484:
            char r7 = r3[r4]
            if (r7 == r15) goto L_0x048c
            char r7 = r3[r4]
            if (r7 != r6) goto L_0x0490
        L_0x048c:
            r1 = r2 | 1024(0x400, float:1.435E-42)
            goto L_0x00db
        L_0x0490:
            r6 = 4
            if (r4 < r6) goto L_0x04d3
            int r6 = r4 + -4
            char r7 = r3[r6]
            r8 = 119(0x77, float:1.67E-43)
            if (r7 == r8) goto L_0x04a1
            char r6 = r3[r6]
            r7 = 87
            if (r6 != r7) goto L_0x04d3
        L_0x04a1:
            int r6 = r4 + -3
            char r7 = r3[r6]
            if (r7 == r5) goto L_0x04ab
            char r6 = r3[r6]
            if (r6 != r1) goto L_0x04d3
        L_0x04ab:
            int r6 = r4 + -2
            char r7 = r3[r6]
            r8 = 97
            if (r7 == r8) goto L_0x04b9
            char r6 = r3[r6]
            r7 = 65
            if (r6 != r7) goto L_0x04d3
        L_0x04b9:
            int r6 = r4 + -1
            char r7 = r3[r6]
            r8 = 118(0x76, float:1.65E-43)
            if (r7 == r8) goto L_0x04c7
            char r6 = r3[r6]
            r7 = 86
            if (r6 != r7) goto L_0x04d3
        L_0x04c7:
            char r6 = r3[r4]
            if (r6 == r5) goto L_0x04cf
            char r5 = r3[r4]
            if (r5 != r1) goto L_0x04d3
        L_0x04cf:
            r1 = r2 | 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x04d3:
            if (r4 < 0) goto L_0x0520
            char r1 = r3[r4]
            r5 = 42
            if (r1 != r5) goto L_0x0520
            r1 = r2 | 4063(0xfdf, float:5.693E-42)
            r2 = r1
            r10 = 1
        L_0x04df:
            r1 = 0
        L_0x04e0:
            if (r4 < r10) goto L_0x051c
            if (r1 != 0) goto L_0x051c
            int r5 = r4 - r10
            char r5 = r3[r5]
            r6 = 9
            if (r5 == r6) goto L_0x0519
            r7 = 10
            if (r5 == r7) goto L_0x0519
            r7 = 12
            if (r5 == r7) goto L_0x0519
            r7 = 13
            if (r5 == r7) goto L_0x0519
            r7 = 32
            if (r5 == r7) goto L_0x0519
            r1 = 44
            if (r5 != r1) goto L_0x0502
            r1 = 1
            goto L_0x0519
        L_0x0502:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "invalid permission: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0519:
            int r4 = r4 + -1
            goto L_0x04e0
        L_0x051c:
            int r4 = r4 - r10
            r5 = 1
            goto L_0x001a
        L_0x0520:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "invalid permission: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0537:
            if (r1 != 0) goto L_0x053a
            return r2
        L_0x053a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "invalid permission: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0551:
            r0 = 4063(0xfdf, float:5.693E-42)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.AdminPermission.parseActions(java.lang.String):int");
    }

    private static Filter parseFilter(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.equals("*")) {
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
        if (!(permission instanceof AdminPermission)) {
            return false;
        }
        AdminPermission adminPermission = (AdminPermission) permission;
        if (this.bundle == null && adminPermission.filter == null) {
            return implies0(adminPermission, 0);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean implies0(AdminPermission adminPermission, int i) {
        int i2 = i | this.action_mask;
        int i3 = adminPermission.action_mask;
        if ((i2 & i3) != i3) {
            return false;
        }
        Filter filter2 = this.filter;
        if (filter2 == null) {
            return true;
        }
        if (adminPermission.bundle == null) {
            return false;
        }
        Map<String, Object> properties2 = adminPermission.getProperties();
        if (properties2 == null) {
            return true;
        }
        return filter2.matches(properties2);
    }

    public String getActions() {
        String str = this.actions;
        if (str != null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.action_mask;
        if ((i & 1) == 1) {
            stringBuffer.append("class");
            stringBuffer.append(',');
        }
        if ((i & 2) == 2) {
            stringBuffer.append(EXECUTE);
            stringBuffer.append(',');
        }
        if ((i & 512) == 512) {
            stringBuffer.append(EXTENSIONLIFECYCLE);
            stringBuffer.append(',');
        }
        if ((i & 4) == 4) {
            stringBuffer.append(LIFECYCLE);
            stringBuffer.append(',');
        }
        if ((i & 8) == 8) {
            stringBuffer.append("listener");
            stringBuffer.append(',');
        }
        if ((i & 16) == 16) {
            stringBuffer.append(METADATA);
            stringBuffer.append(',');
        }
        if ((i & 64) == 64) {
            stringBuffer.append("resolve");
            stringBuffer.append(',');
        }
        if ((i & 128) == 128) {
            stringBuffer.append("resource");
            stringBuffer.append(',');
        }
        if ((i & 256) == 256) {
            stringBuffer.append(STARTLEVEL);
            stringBuffer.append(',');
        }
        if ((i & 1024) == 1024) {
            stringBuffer.append("context");
            stringBuffer.append(',');
        }
        if ((i & 2048) == 2048) {
            stringBuffer.append(WEAVE);
            stringBuffer.append(',');
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.actions = stringBuffer2;
        return stringBuffer2;
    }

    public PermissionCollection newPermissionCollection() {
        return new AdminPermissionCollection();
    }

    public boolean equals(Object obj) {
        Bundle bundle2;
        Bundle bundle3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdminPermission)) {
            return false;
        }
        AdminPermission adminPermission = (AdminPermission) obj;
        if (this.action_mask == adminPermission.action_mask && ((bundle2 = this.bundle) == (bundle3 = adminPermission.bundle) || (bundle2 != null && bundle2.equals(bundle3)))) {
            Filter filter2 = this.filter;
            Filter filter3 = adminPermission.filter;
            if (filter2 == null) {
                if (filter3 == null) {
                    return true;
                }
            } else if (filter2.equals(filter3)) {
                return true;
            }
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
        setTransients(parseFilter(getName()), parseActions(this.actions));
    }

    private Map<String, Object> getProperties() {
        Map<String, Object> map = this.properties;
        if (map != null) {
            return map;
        }
        Bundle bundle2 = recurse.get();
        Bundle bundle3 = this.bundle;
        if (bundle2 == bundle3) {
            return null;
        }
        recurse.set(bundle3);
        try {
            final HashMap hashMap = new HashMap(4);
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    hashMap.put("id", new Long(AdminPermission.this.bundle.getBundleId()));
                    hashMap.put("location", AdminPermission.this.bundle.getLocation());
                    String symbolicName = AdminPermission.this.bundle.getSymbolicName();
                    if (symbolicName != null) {
                        hashMap.put("name", symbolicName);
                    }
                    SignerProperty signerProperty = new SignerProperty(AdminPermission.this.bundle);
                    if (!signerProperty.isBundleSigned()) {
                        return null;
                    }
                    hashMap.put("signer", signerProperty);
                    return null;
                }
            });
            this.properties = hashMap;
            return hashMap;
        } finally {
            recurse.set((Object) null);
        }
    }
}

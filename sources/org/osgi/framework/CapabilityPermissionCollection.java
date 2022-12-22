package org.osgi.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CapabilityPermission */
final class CapabilityPermissionCollection extends PermissionCollection {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("permissions", HashMap.class), new ObjectStreamField("all_allowed", Boolean.TYPE), new ObjectStreamField("filterPermissions", HashMap.class)};
    static final long serialVersionUID = -615322242639008920L;
    private boolean all_allowed = false;
    private Map<String, CapabilityPermission> filterPermissions;
    private Map<String, CapabilityPermission> permissions = new HashMap();

    public void add(Permission permission) {
        Map map;
        if (!(permission instanceof CapabilityPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        } else if (!isReadOnly()) {
            CapabilityPermission capabilityPermission = (CapabilityPermission) permission;
            if (capabilityPermission.bundle == null) {
                String name = capabilityPermission.getName();
                Filter filter = capabilityPermission.filter;
                synchronized (this) {
                    if (filter != null) {
                        map = this.filterPermissions;
                        if (map == null) {
                            map = new HashMap();
                            this.filterPermissions = map;
                        }
                    } else {
                        map = this.permissions;
                    }
                    CapabilityPermission capabilityPermission2 = (CapabilityPermission) map.get(name);
                    if (capabilityPermission2 != null) {
                        int i = capabilityPermission2.action_mask;
                        int i2 = capabilityPermission.action_mask;
                        if (i != i2) {
                            map.put(name, new CapabilityPermission(name, i2 | i));
                        }
                    } else {
                        map.put(name, capabilityPermission);
                    }
                    if (!this.all_allowed && name.equals("*")) {
                        this.all_allowed = true;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("cannot add to collection: " + capabilityPermission);
        } else {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008c, code lost:
        if (r0.hasNext() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0098, code lost:
        if (r0.next().implies0(r10, r4) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean implies(java.security.Permission r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof org.osgi.framework.CapabilityPermission
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.osgi.framework.CapabilityPermission r10 = (org.osgi.framework.CapabilityPermission) r10
            org.osgi.framework.Filter r0 = r10.filter
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r0 = r10.getName()
            int r2 = r10.action_mask
            monitor-enter(r9)
            java.util.Map<java.lang.String, org.osgi.framework.CapabilityPermission> r3 = r9.permissions     // Catch:{ all -> 0x009c }
            boolean r4 = r9.all_allowed     // Catch:{ all -> 0x009c }
            r5 = 1
            if (r4 == 0) goto L_0x002e
            java.lang.String r4 = "*"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ all -> 0x009c }
            org.osgi.framework.CapabilityPermission r4 = (org.osgi.framework.CapabilityPermission) r4     // Catch:{ all -> 0x009c }
            if (r4 == 0) goto L_0x002e
            int r4 = r4.action_mask     // Catch:{ all -> 0x009c }
            r4 = r4 | r1
            r6 = r4 & r2
            if (r6 != r2) goto L_0x002f
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            return r5
        L_0x002e:
            r4 = 0
        L_0x002f:
            java.lang.Object r6 = r3.get(r0)     // Catch:{ all -> 0x009c }
            org.osgi.framework.CapabilityPermission r6 = (org.osgi.framework.CapabilityPermission) r6     // Catch:{ all -> 0x009c }
            if (r6 == 0) goto L_0x0040
            int r6 = r6.action_mask     // Catch:{ all -> 0x009c }
            r4 = r4 | r6
            r6 = r4 & r2
            if (r6 != r2) goto L_0x0040
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            return r5
        L_0x0040:
            int r6 = r0.length()     // Catch:{ all -> 0x009c }
            int r6 = r6 - r5
        L_0x0045:
            java.lang.String r7 = "."
            int r6 = r0.lastIndexOf(r7, r6)     // Catch:{ all -> 0x009c }
            r7 = -1
            if (r6 == r7) goto L_0x0079
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r7.<init>()     // Catch:{ all -> 0x009c }
            int r8 = r6 + 1
            java.lang.String r0 = r0.substring(r1, r8)     // Catch:{ all -> 0x009c }
            r7.append(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = "*"
            r7.append(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x009c }
            java.lang.Object r7 = r3.get(r0)     // Catch:{ all -> 0x009c }
            org.osgi.framework.CapabilityPermission r7 = (org.osgi.framework.CapabilityPermission) r7     // Catch:{ all -> 0x009c }
            if (r7 == 0) goto L_0x0076
            int r7 = r7.action_mask     // Catch:{ all -> 0x009c }
            r4 = r4 | r7
            r7 = r4 & r2
            if (r7 != r2) goto L_0x0076
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            return r5
        L_0x0076:
            int r6 = r6 + -1
            goto L_0x0045
        L_0x0079:
            java.util.Map<java.lang.String, org.osgi.framework.CapabilityPermission> r0 = r9.filterPermissions     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x007f
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            return r1
        L_0x007f:
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x009c }
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            java.util.Iterator r0 = r0.iterator()
        L_0x0088:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x009b
            java.lang.Object r2 = r0.next()
            org.osgi.framework.CapabilityPermission r2 = (org.osgi.framework.CapabilityPermission) r2
            boolean r2 = r2.implies0(r10, r4)
            if (r2 == 0) goto L_0x0088
            return r5
        L_0x009b:
            return r1
        L_0x009c:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x009c }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.CapabilityPermissionCollection.implies(java.security.Permission):boolean");
    }

    public synchronized Enumeration<Permission> elements() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.permissions.values());
        Map<String, CapabilityPermission> map = this.filterPermissions;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        return Collections.enumeration(arrayList);
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("permissions", this.permissions);
        putFields.put("all_allowed", this.all_allowed);
        putFields.put("filterPermissions", this.filterPermissions);
        objectOutputStream.writeFields();
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.permissions = (HashMap) readFields.get("permissions", (Object) null);
        this.all_allowed = readFields.get("all_allowed", false);
        this.filterPermissions = (HashMap) readFields.get("filterPermissions", (Object) null);
    }
}

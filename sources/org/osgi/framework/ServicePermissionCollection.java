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
import java.util.Hashtable;
import java.util.Map;

/* compiled from: ServicePermission */
final class ServicePermissionCollection extends PermissionCollection {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE), new ObjectStreamField("filterPermissions", HashMap.class)};
    static final long serialVersionUID = 662615640374640621L;
    private boolean all_allowed = false;
    private Map<String, ServicePermission> filterPermissions;
    private transient Map<String, ServicePermission> permissions = new HashMap();

    public void add(Permission permission) {
        Map map;
        if (!(permission instanceof ServicePermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        } else if (!isReadOnly()) {
            ServicePermission servicePermission = (ServicePermission) permission;
            if (servicePermission.service == null) {
                String name = servicePermission.getName();
                Filter filter = servicePermission.filter;
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
                    ServicePermission servicePermission2 = (ServicePermission) map.get(name);
                    if (servicePermission2 != null) {
                        int i = servicePermission2.action_mask;
                        int i2 = servicePermission.action_mask;
                        if (i != i2) {
                            map.put(name, new ServicePermission(name, i2 | i));
                        }
                    } else {
                        map.put(name, servicePermission);
                    }
                    if (!this.all_allowed && name.equals("*")) {
                        this.all_allowed = true;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("cannot add to collection: " + servicePermission);
        } else {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0063, code lost:
        if (r0.hasNext() == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006f, code lost:
        if (r0.next().implies0(r9, r2) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0071, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0072, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean implies(java.security.Permission r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof org.osgi.framework.ServicePermission
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.osgi.framework.ServicePermission r9 = (org.osgi.framework.ServicePermission) r9
            org.osgi.framework.Filter r0 = r9.filter
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            monitor-enter(r8)
            int r0 = r9.action_mask     // Catch:{ all -> 0x0073 }
            boolean r2 = r8.all_allowed     // Catch:{ all -> 0x0073 }
            r3 = 1
            if (r2 == 0) goto L_0x002a
            java.util.Map<java.lang.String, org.osgi.framework.ServicePermission> r2 = r8.permissions     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = "*"
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0073 }
            org.osgi.framework.ServicePermission r2 = (org.osgi.framework.ServicePermission) r2     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x002a
            int r2 = r2.action_mask     // Catch:{ all -> 0x0073 }
            r2 = r2 | r1
            r4 = r2 & r0
            if (r4 != r0) goto L_0x002b
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            return r3
        L_0x002a:
            r2 = 0
        L_0x002b:
            java.lang.String[] r4 = r9.objectClass     // Catch:{ all -> 0x0073 }
            if (r4 != 0) goto L_0x003e
            java.lang.String r4 = r9.getName()     // Catch:{ all -> 0x0073 }
            int r4 = r8.effective(r4, r0, r2)     // Catch:{ all -> 0x0073 }
            r2 = r2 | r4
            r4 = r2 & r0
            if (r4 != r0) goto L_0x0050
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            return r3
        L_0x003e:
            int r5 = r4.length     // Catch:{ all -> 0x0073 }
            r6 = 0
        L_0x0040:
            if (r6 >= r5) goto L_0x0050
            r7 = r4[r6]     // Catch:{ all -> 0x0073 }
            int r7 = r8.effective(r7, r0, r2)     // Catch:{ all -> 0x0073 }
            r7 = r7 & r0
            if (r7 != r0) goto L_0x004d
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            return r3
        L_0x004d:
            int r6 = r6 + 1
            goto L_0x0040
        L_0x0050:
            java.util.Map<java.lang.String, org.osgi.framework.ServicePermission> r0 = r8.filterPermissions     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0056
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            return r1
        L_0x0056:
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0073 }
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            java.util.Iterator r0 = r0.iterator()
        L_0x005f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0072
            java.lang.Object r4 = r0.next()
            org.osgi.framework.ServicePermission r4 = (org.osgi.framework.ServicePermission) r4
            boolean r4 = r4.implies0(r9, r2)
            if (r4 == 0) goto L_0x005f
            return r3
        L_0x0072:
            return r1
        L_0x0073:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0073 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.ServicePermissionCollection.implies(java.security.Permission):boolean");
    }

    private int effective(String str, int i, int i2) {
        Map<String, ServicePermission> map = this.permissions;
        ServicePermission servicePermission = map.get(str);
        if (servicePermission != null) {
            i2 |= servicePermission.action_mask;
            if ((i2 & i) == i) {
                return i2;
            }
        }
        int length = str.length();
        while (true) {
            length = str.lastIndexOf(".", length - 1);
            if (length == -1) {
                break;
            }
            str = str.substring(0, length + 1) + "*";
            ServicePermission servicePermission2 = map.get(str);
            if (servicePermission2 != null) {
                i2 |= servicePermission2.action_mask;
                if ((i2 & i) == i) {
                    break;
                }
            }
        }
        return i2;
    }

    public synchronized Enumeration<Permission> elements() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.permissions.values());
        Map<String, ServicePermission> map = this.filterPermissions;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        return Collections.enumeration(arrayList);
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Hashtable hashtable = new Hashtable(this.permissions);
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("permissions", hashtable);
        putFields.put("all_allowed", this.all_allowed);
        putFields.put("filterPermissions", this.filterPermissions);
        objectOutputStream.writeFields();
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.permissions = new HashMap((Hashtable) readFields.get("permissions", (Object) null));
        this.all_allowed = readFields.get("all_allowed", false);
        this.filterPermissions = (HashMap) readFields.get("filterPermissions", (Object) null);
    }
}

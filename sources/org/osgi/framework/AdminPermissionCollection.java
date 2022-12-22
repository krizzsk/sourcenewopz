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

/* compiled from: AdminPermission */
final class AdminPermissionCollection extends PermissionCollection {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE)};
    private static final long serialVersionUID = 3906372644575328048L;
    private boolean all_allowed;
    private transient Map<String, AdminPermission> permissions = new HashMap();

    public void add(Permission permission) {
        if (!(permission instanceof AdminPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        } else if (!isReadOnly()) {
            AdminPermission adminPermission = (AdminPermission) permission;
            if (adminPermission.bundle == null) {
                String name = adminPermission.getName();
                synchronized (this) {
                    Map<String, AdminPermission> map = this.permissions;
                    AdminPermission adminPermission2 = map.get(name);
                    if (adminPermission2 != null) {
                        int i = adminPermission2.action_mask;
                        int i2 = adminPermission.action_mask;
                        if (i != i2) {
                            map.put(name, new AdminPermission(adminPermission2.filter, i2 | i));
                        }
                    } else {
                        map.put(name, adminPermission);
                    }
                    if (!this.all_allowed && name.equals("*")) {
                        this.all_allowed = true;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("cannot add to collection: " + adminPermission);
        } else {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r0.hasNext() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r0.next().implies0(r7, r2) == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean implies(java.security.Permission r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof org.osgi.framework.AdminPermission
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.osgi.framework.AdminPermission r7 = (org.osgi.framework.AdminPermission) r7
            org.osgi.framework.Filter r0 = r7.filter
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            monitor-enter(r6)
            java.util.Map<java.lang.String, org.osgi.framework.AdminPermission> r0 = r6.permissions     // Catch:{ all -> 0x0048 }
            boolean r2 = r6.all_allowed     // Catch:{ all -> 0x0048 }
            r3 = 1
            if (r2 == 0) goto L_0x002a
            java.lang.String r2 = "*"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0048 }
            org.osgi.framework.AdminPermission r2 = (org.osgi.framework.AdminPermission) r2     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x002a
            int r2 = r2.action_mask     // Catch:{ all -> 0x0048 }
            r2 = r2 | r1
            int r4 = r7.action_mask     // Catch:{ all -> 0x0048 }
            r5 = r2 & r4
            if (r5 != r4) goto L_0x002b
            monitor-exit(r6)     // Catch:{ all -> 0x0048 }
            return r3
        L_0x002a:
            r2 = 0
        L_0x002b:
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0048 }
            monitor-exit(r6)     // Catch:{ all -> 0x0048 }
            java.util.Iterator r0 = r0.iterator()
        L_0x0034:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0047
            java.lang.Object r4 = r0.next()
            org.osgi.framework.AdminPermission r4 = (org.osgi.framework.AdminPermission) r4
            boolean r4 = r4.implies0(r7, r2)
            if (r4 == 0) goto L_0x0034
            return r3
        L_0x0047:
            return r1
        L_0x0048:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0048 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.AdminPermissionCollection.implies(java.security.Permission):boolean");
    }

    public synchronized Enumeration<Permission> elements() {
        return Collections.enumeration(new ArrayList(this.permissions.values()));
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Hashtable hashtable = new Hashtable(this.permissions);
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("permissions", hashtable);
        putFields.put("all_allowed", this.all_allowed);
        objectOutputStream.writeFields();
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.permissions = new HashMap((Hashtable) readFields.get("permissions", (Object) null));
        this.all_allowed = readFields.get("all_allowed", false);
    }
}

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

/* compiled from: BundlePermission */
final class BundlePermissionCollection extends PermissionCollection {
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE)};
    private static final long serialVersionUID = 3258407326846433079L;
    private boolean all_allowed = false;
    private transient Map<String, BundlePermission> permissions = new HashMap();

    public void add(Permission permission) {
        if (!(permission instanceof BundlePermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        } else if (!isReadOnly()) {
            BundlePermission bundlePermission = (BundlePermission) permission;
            String name = bundlePermission.getName();
            synchronized (this) {
                Map<String, BundlePermission> map = this.permissions;
                BundlePermission bundlePermission2 = map.get(name);
                if (bundlePermission2 != null) {
                    int actionsMask = bundlePermission2.getActionsMask();
                    int actionsMask2 = bundlePermission.getActionsMask();
                    if (actionsMask != actionsMask2) {
                        map.put(name, new BundlePermission(name, actionsMask2 | actionsMask));
                    }
                } else {
                    map.put(name, bundlePermission);
                }
                if (!this.all_allowed && name.equals("*")) {
                    this.all_allowed = true;
                }
            }
        } else {
            throw new SecurityException("attempt to add a Permission to a readonly PermissionCollection");
        }
    }

    public boolean implies(Permission permission) {
        int i;
        BundlePermission bundlePermission;
        if (!(permission instanceof BundlePermission)) {
            return false;
        }
        BundlePermission bundlePermission2 = (BundlePermission) permission;
        String name = bundlePermission2.getName();
        int actionsMask = bundlePermission2.getActionsMask();
        synchronized (this) {
            Map<String, BundlePermission> map = this.permissions;
            if (!this.all_allowed || (bundlePermission = map.get("*")) == null) {
                i = 0;
            } else {
                i = bundlePermission.getActionsMask() | 0;
                if ((i & actionsMask) == actionsMask) {
                    return true;
                }
            }
            BundlePermission bundlePermission3 = map.get(name);
            if (bundlePermission3 != null) {
                i |= bundlePermission3.getActionsMask();
                if ((i & actionsMask) == actionsMask) {
                    return true;
                }
            }
            int length = name.length() - 1;
            while (true) {
                int lastIndexOf = name.lastIndexOf(".", length);
                if (lastIndexOf == -1) {
                    return false;
                }
                name = name.substring(0, lastIndexOf + 1) + "*";
                BundlePermission bundlePermission4 = map.get(name);
                if (bundlePermission4 != null) {
                    i |= bundlePermission4.getActionsMask();
                    if ((i & actionsMask) == actionsMask) {
                        return true;
                    }
                }
                length = lastIndexOf - 1;
            }
        }
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

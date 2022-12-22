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

public final class AdaptPermission extends BasicPermission {
    private static final int ACTION_ADAPT = 1;
    private static final int ACTION_ALL = 1;
    static final int ACTION_NONE = 0;
    public static final String ADAPT = "adapt";
    private static final long serialVersionUID = 1;
    transient int action_mask;
    private volatile String actions;
    final transient Bundle bundle;
    transient Filter filter;
    private volatile transient Map<String, Object> properties;

    public AdaptPermission(String str, String str2) {
        this(parseFilter(str), parseActions(str2));
    }

    public AdaptPermission(String str, Bundle bundle2, String str2) {
        super(str);
        this.actions = null;
        setTransients((Filter) null, parseActions(str2));
        this.bundle = bundle2;
        if (str == null) {
            throw new NullPointerException("adaptClass must not be null");
        } else if (bundle2 == null) {
            throw new NullPointerException("adaptableBundle must not be null");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdaptPermission(Filter filter2, int i) {
        super(filter2 == null ? "*" : filter2.toString());
        this.actions = null;
        setTransients(filter2, i);
        this.bundle = null;
    }

    private void setTransients(Filter filter2, int i) {
        this.filter = filter2;
        if (i == 0 || (i & 1) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
    }

    private static int parseActions(String str) {
        String str2 = str;
        if (str2 == null) {
            return 0;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length - 1;
        if (length < 0) {
            return 0;
        }
        boolean z = false;
        int i = 0;
        while (length != -1) {
            while (length != -1 && ((r13 = charArray[length]) == ' ' || r13 == 13 || r13 == 10 || r13 == 12 || r13 == 9)) {
                length--;
            }
            if (length >= 4) {
                int i2 = length - 4;
                if (charArray[i2] == 'a' || charArray[i2] == 'A') {
                    int i3 = length - 3;
                    if (charArray[i3] == 'd' || charArray[i3] == 'D') {
                        int i4 = length - 2;
                        if (charArray[i4] == 'a' || charArray[i4] == 'A') {
                            int i5 = length - 1;
                            if ((charArray[i5] == 'p' || charArray[i5] == 'P') && (charArray[length] == 't' || charArray[length] == 'T')) {
                                i |= 1;
                                boolean z2 = false;
                                while (length >= 5 && !z2) {
                                    char c = charArray[length - 5];
                                    if (!(c == 9 || c == 10 || c == 12 || c == 13 || c == ' ')) {
                                        if (c == ',') {
                                            z2 = true;
                                        } else {
                                            throw new IllegalArgumentException("invalid permission: " + str2);
                                        }
                                    }
                                    length--;
                                }
                                length -= 5;
                                z = z2;
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("invalid actions: " + str2);
        }
        if (!z) {
            return i;
        }
        throw new IllegalArgumentException("invalid actions: " + str2);
    }

    private static Filter parseFilter(String str) {
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
        if (!(permission instanceof AdaptPermission)) {
            return false;
        }
        AdaptPermission adaptPermission = (AdaptPermission) permission;
        if (this.bundle == null && adaptPermission.filter == null) {
            return implies0(adaptPermission, 0);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean implies0(AdaptPermission adaptPermission, int i) {
        int i2 = i | this.action_mask;
        int i3 = adaptPermission.action_mask;
        if ((i2 & i3) != i3) {
            return false;
        }
        Filter filter2 = this.filter;
        if (filter2 == null) {
            return true;
        }
        return filter2.matches(adaptPermission.getProperties());
    }

    public String getActions() {
        String str = this.actions;
        if (str != null) {
            return str;
        }
        this.actions = ADAPT;
        return ADAPT;
    }

    public PermissionCollection newPermissionCollection() {
        return new AdaptPermissionCollection();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdaptPermission)) {
            return false;
        }
        AdaptPermission adaptPermission = (AdaptPermission) obj;
        if (this.action_mask == adaptPermission.action_mask && getName().equals(adaptPermission.getName())) {
            Bundle bundle2 = this.bundle;
            Bundle bundle3 = adaptPermission.bundle;
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
        setTransients(parseFilter(getName()), parseActions(this.actions));
    }

    private Map<String, Object> getProperties() {
        Map<String, Object> map = this.properties;
        if (map != null) {
            return map;
        }
        final HashMap hashMap = new HashMap(5);
        hashMap.put("adaptClass", getName());
        if (this.bundle != null) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    hashMap.put("id", new Long(AdaptPermission.this.bundle.getBundleId()));
                    hashMap.put("location", AdaptPermission.this.bundle.getLocation());
                    String symbolicName = AdaptPermission.this.bundle.getSymbolicName();
                    if (symbolicName != null) {
                        hashMap.put("name", symbolicName);
                    }
                    SignerProperty signerProperty = new SignerProperty(AdaptPermission.this.bundle);
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

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
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class CapabilityPermission extends BasicPermission {
    private static final int ACTION_ALL = 3;
    static final int ACTION_NONE = 0;
    private static final int ACTION_PROVIDE = 2;
    private static final int ACTION_REQUIRE = 1;
    public static final String PROVIDE = "provide";
    public static final String REQUIRE = "require";
    static final long serialVersionUID = -7662148639076511574L;
    transient int action_mask;
    private volatile String actions;
    final transient Map<String, Object> attributes;
    final transient Bundle bundle;
    transient Filter filter;
    private volatile transient Map<String, Object> properties;

    public CapabilityPermission(String str, String str2) {
        this(str, parseActions(str2));
        if (this.filter != null && (this.action_mask & 3) != 1) {
            throw new IllegalArgumentException("invalid action string for filter expression");
        }
    }

    public CapabilityPermission(String str, Map<String, ?> map, Bundle bundle2, String str2) {
        super(str);
        this.actions = null;
        setTransients(str, parseActions(str2));
        if (map == null) {
            throw new IllegalArgumentException("attributes must not be null");
        } else if (bundle2 != null) {
            this.attributes = new HashMap(map);
            this.bundle = bundle2;
            if ((this.action_mask & 3) != 1) {
                throw new IllegalArgumentException("invalid action string");
            }
        } else {
            throw new IllegalArgumentException("bundle must not be null");
        }
    }

    CapabilityPermission(String str, int i) {
        super(str);
        this.actions = null;
        setTransients(str, i);
        this.attributes = null;
        this.bundle = null;
    }

    private void setTransients(String str, int i) {
        if (i == 0 || (i & 3) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
        this.filter = parseFilter(str);
    }

    private static int parseActions(String str) {
        int i;
        char c;
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
        int i2 = 0;
        while (length != -1) {
            while (length != -1 && ((r13 = charArray[length]) == ' ' || r13 == 13 || r13 == 10 || r13 == 12 || r13 == 9)) {
                length--;
            }
            if (length >= 6) {
                int i3 = length - 6;
                if (charArray[i3] == 'r' || charArray[i3] == 'R') {
                    int i4 = length - 5;
                    if (charArray[i4] == 'e' || charArray[i4] == 'E') {
                        int i5 = length - 4;
                        if (charArray[i5] == 'q' || charArray[i5] == 'Q') {
                            int i6 = length - 3;
                            if (charArray[i6] == 'u' || charArray[i6] == 'U') {
                                int i7 = length - 2;
                                if (charArray[i7] == 'i' || charArray[i7] == 'I') {
                                    int i8 = length - 1;
                                    if ((charArray[i8] == 'r' || charArray[i8] == 'R') && (charArray[length] == 'e' || charArray[length] == 'E')) {
                                        i = i2 | 1;
                                        i2 = i;
                                        boolean z2 = false;
                                        while (length >= 7 && !z2) {
                                            c = charArray[length - 7];
                                            if (c == 9 && c != 10) {
                                                if (c != 12) {
                                                    if (!(c == 13 || c == ' ')) {
                                                        if (c == ',') {
                                                            z2 = true;
                                                        } else {
                                                            throw new IllegalArgumentException("invalid permission: " + str2);
                                                        }
                                                    }
                                                    length--;
                                                }
                                            }
                                            length--;
                                        }
                                        length -= 7;
                                        z = z2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (length >= 6) {
                int i9 = length - 6;
                if (charArray[i9] == 'p' || charArray[i9] == 'P') {
                    int i10 = length - 5;
                    if (charArray[i10] == 'r' || charArray[i10] == 'R') {
                        int i11 = length - 4;
                        if (charArray[i11] == 'o' || charArray[i11] == 'O') {
                            int i12 = length - 3;
                            if (charArray[i12] == 'v' || charArray[i12] == 'V') {
                                int i13 = length - 2;
                                if (charArray[i13] == 'i' || charArray[i13] == 'I') {
                                    int i14 = length - 1;
                                    if ((charArray[i14] == 'd' || charArray[i14] == 'D') && (charArray[length] == 'e' || charArray[length] == 'E')) {
                                        i = i2 | 2;
                                        i2 = i;
                                        boolean z22 = false;
                                        while (length >= 7) {
                                            c = charArray[length - 7];
                                            if (c == 9) {
                                            }
                                            length--;
                                        }
                                        length -= 7;
                                        z = z22;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("invalid permission: " + str2);
        }
        if (!z) {
            return i2;
        }
        throw new IllegalArgumentException("invalid permission: " + str2);
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
        if (!(permission instanceof CapabilityPermission)) {
            return false;
        }
        CapabilityPermission capabilityPermission = (CapabilityPermission) permission;
        if (this.bundle == null && capabilityPermission.filter == null) {
            return implies0(capabilityPermission, 0);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean implies0(CapabilityPermission capabilityPermission, int i) {
        int i2 = i | this.action_mask;
        int i3 = capabilityPermission.action_mask;
        if ((i2 & i3) != i3) {
            return false;
        }
        Filter filter2 = this.filter;
        if (filter2 == null) {
            return super.implies(capabilityPermission);
        }
        return filter2.matches(capabilityPermission.getProperties());
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
            stringBuffer.append("require");
            z = true;
        }
        if ((i & 2) == 2) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append("provide");
        }
        String stringBuffer2 = stringBuffer.toString();
        this.actions = stringBuffer2;
        return stringBuffer2;
    }

    public PermissionCollection newPermissionCollection() {
        return new CapabilityPermissionCollection();
    }

    public boolean equals(Object obj) {
        Map<String, Object> map;
        Map<String, Object> map2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CapabilityPermission)) {
            return false;
        }
        CapabilityPermission capabilityPermission = (CapabilityPermission) obj;
        if (this.action_mask == capabilityPermission.action_mask && getName().equals(capabilityPermission.getName()) && ((map = this.attributes) == (map2 = capabilityPermission.attributes) || (map != null && map.equals(map2)))) {
            Bundle bundle2 = this.bundle;
            Bundle bundle3 = capabilityPermission.bundle;
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
        Map<String, Object> map = this.attributes;
        if (map != null) {
            hashCode = (hashCode * 31) + map.hashCode();
        }
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
        hashMap.put("capability.namespace", getName());
        if (this.bundle == null) {
            this.properties = hashMap;
            return hashMap;
        }
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                hashMap.put("id", new Long(CapabilityPermission.this.bundle.getBundleId()));
                hashMap.put("location", CapabilityPermission.this.bundle.getLocation());
                String symbolicName = CapabilityPermission.this.bundle.getSymbolicName();
                if (symbolicName != null) {
                    hashMap.put("name", symbolicName);
                }
                SignerProperty signerProperty = new SignerProperty(CapabilityPermission.this.bundle);
                if (!signerProperty.isBundleSigned()) {
                    return null;
                }
                hashMap.put("signer", signerProperty);
                return null;
            }
        });
        Properties properties2 = new Properties(hashMap, this.attributes);
        this.properties = properties2;
        return properties2;
    }

    private static final class Properties extends AbstractMap<String, Object> {
        private final Map<String, Object> attributes;
        private volatile transient Set<Map.Entry<String, Object>> entries = null;
        private final Map<String, Object> properties;

        Properties(Map<String, Object> map, Map<String, Object> map2) {
            this.properties = map;
            this.attributes = map2;
        }

        public Object get(Object obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            String str = (String) obj;
            if (str.charAt(0) == '@') {
                return this.attributes.get(str.substring(1));
            }
            Object obj2 = this.properties.get(str);
            if (obj2 != null) {
                return obj2;
            }
            return this.attributes.get(str);
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            if (this.entries != null) {
                return this.entries;
            }
            HashSet hashSet = new HashSet(this.attributes.size() + this.properties.size());
            hashSet.addAll(this.attributes.entrySet());
            hashSet.addAll(this.properties.entrySet());
            Set<Map.Entry<String, Object>> unmodifiableSet = Collections.unmodifiableSet(hashSet);
            this.entries = unmodifiableSet;
            return unmodifiableSet;
        }
    }
}

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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ServicePermission extends BasicPermission {
    private static final int ACTION_ALL = 3;
    private static final int ACTION_GET = 1;
    static final int ACTION_NONE = 0;
    private static final int ACTION_REGISTER = 2;
    public static final String GET = "get";
    public static final String REGISTER = "register";
    static final long serialVersionUID = -7662148639076511574L;
    transient int action_mask;
    private volatile String actions;
    transient Filter filter;
    final transient String[] objectClass;
    private transient String prefix;
    private volatile transient Map<String, Object> properties;
    final transient ServiceReference<?> service;
    private transient boolean wildcard;

    public ServicePermission(String str, String str2) {
        this(str, parseActions(str2));
        if (this.filter != null && (this.action_mask & 3) != 1) {
            throw new IllegalArgumentException("invalid action string for filter expression");
        }
    }

    public ServicePermission(ServiceReference<?> serviceReference, String str) {
        super(createName(serviceReference));
        this.actions = null;
        setTransients((Filter) null, parseActions(str));
        this.service = serviceReference;
        this.objectClass = (String[]) serviceReference.getProperty(Constants.OBJECTCLASS);
        if ((this.action_mask & 3) != 1) {
            throw new IllegalArgumentException("invalid action string");
        }
    }

    private static String createName(ServiceReference<?> serviceReference) {
        if (serviceReference != null) {
            StringBuffer stringBuffer = new StringBuffer("(service.id=");
            stringBuffer.append(serviceReference.getProperty(Constants.SERVICE_ID));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("reference must not be null");
    }

    ServicePermission(String str, int i) {
        super(str);
        this.actions = null;
        setTransients(parseFilter(str), i);
        this.service = null;
        this.objectClass = null;
    }

    private void setTransients(Filter filter2, int i) {
        if (i == 0 || (i & 3) != i) {
            throw new IllegalArgumentException("invalid action string");
        }
        this.action_mask = i;
        this.filter = filter2;
        if (filter2 == null) {
            String name = getName();
            int length = name.length();
            int i2 = length - 1;
            boolean z = name.charAt(i2) == '*' && (length == 1 || name.charAt(length + -2) == '.');
            this.wildcard = z;
            if (z && length > 1) {
                this.prefix = name.substring(0, i2);
            }
        }
    }

    private static int parseActions(String str) {
        int i;
        int i2;
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
        int i3 = 0;
        while (length != -1) {
            while (length != -1 && ((r13 = charArray[length]) == ' ' || r13 == 13 || r13 == 10 || r13 == 12 || r13 == 9)) {
                length--;
            }
            if (length >= 2) {
                int i4 = length - 2;
                if (charArray[i4] == 'g' || charArray[i4] == 'G') {
                    int i5 = length - 1;
                    if ((charArray[i5] == 'e' || charArray[i5] == 'E') && (charArray[length] == 't' || charArray[length] == 'T')) {
                        i2 = i3 | 1;
                        i = 3;
                        i3 = i2;
                        boolean z2 = false;
                        while (length >= i && !z2) {
                            c = charArray[length - i];
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
                        length -= i;
                        z = z2;
                    }
                }
            }
            if (length >= 7) {
                int i6 = length - 7;
                if (charArray[i6] == 'r' || charArray[i6] == 'R') {
                    int i7 = length - 6;
                    if (charArray[i7] == 'e' || charArray[i7] == 'E') {
                        int i8 = length - 5;
                        if (charArray[i8] == 'g' || charArray[i8] == 'G') {
                            int i9 = length - 4;
                            if (charArray[i9] == 'i' || charArray[i9] == 'I') {
                                int i10 = length - 3;
                                if (charArray[i10] == 's' || charArray[i10] == 'S') {
                                    int i11 = length - 2;
                                    if (charArray[i11] == 't' || charArray[i11] == 'T') {
                                        int i12 = length - 1;
                                        if ((charArray[i12] == 'e' || charArray[i12] == 'E') && (charArray[length] == 'r' || charArray[length] == 'R')) {
                                            i = 8;
                                            i2 = i3 | 2;
                                            i3 = i2;
                                            boolean z22 = false;
                                            while (length >= i) {
                                                c = charArray[length - i];
                                                if (c == 9) {
                                                }
                                                length--;
                                            }
                                            length -= i;
                                            z = z22;
                                        }
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
            return i3;
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
        if (!(permission instanceof ServicePermission)) {
            return false;
        }
        ServicePermission servicePermission = (ServicePermission) permission;
        if (this.service == null && servicePermission.filter == null) {
            return implies0(servicePermission, 0);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean implies0(ServicePermission servicePermission, int i) {
        int i2 = i | this.action_mask;
        int i3 = servicePermission.action_mask;
        if ((i2 & i3) != i3) {
            return false;
        }
        if (this.wildcard && this.prefix == null) {
            return true;
        }
        Filter filter2 = this.filter;
        if (filter2 != null) {
            return filter2.matches(servicePermission.getProperties());
        }
        String[] strArr = servicePermission.objectClass;
        if (strArr == null) {
            return super.implies(servicePermission);
        }
        if (this.wildcard) {
            int length = this.prefix.length();
            for (String str : strArr) {
                if (str.length() > length && str.startsWith(this.prefix)) {
                    return true;
                }
            }
        } else {
            String name = getName();
            for (String equals : strArr) {
                if (equals.equals(name)) {
                    return true;
                }
            }
        }
        return false;
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
            stringBuffer.append("get");
            z = true;
        }
        if ((i & 2) == 2) {
            if (z) {
                stringBuffer.append(',');
            }
            stringBuffer.append(REGISTER);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.actions = stringBuffer2;
        return stringBuffer2;
    }

    public PermissionCollection newPermissionCollection() {
        return new ServicePermissionCollection();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServicePermission)) {
            return false;
        }
        ServicePermission servicePermission = (ServicePermission) obj;
        if (this.action_mask == servicePermission.action_mask && getName().equals(servicePermission.getName())) {
            ServiceReference<?> serviceReference = this.service;
            ServiceReference<?> serviceReference2 = servicePermission.service;
            if (serviceReference == serviceReference2) {
                return true;
            }
            if (serviceReference == null || serviceReference.compareTo(serviceReference2) != 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((getName().hashCode() + 527) * 31) + getActions().hashCode();
        ServiceReference<?> serviceReference = this.service;
        return serviceReference != null ? (hashCode * 31) + serviceReference.hashCode() : hashCode;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.service == null) {
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
        if (this.service == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(Constants.OBJECTCLASS, new String[]{getName()});
            this.properties = hashMap;
            return hashMap;
        }
        final HashMap hashMap2 = new HashMap(4);
        final Bundle bundle = this.service.getBundle();
        if (bundle != null) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    hashMap2.put("id", new Long(bundle.getBundleId()));
                    hashMap2.put("location", bundle.getLocation());
                    String symbolicName = bundle.getSymbolicName();
                    if (symbolicName != null) {
                        hashMap2.put("name", symbolicName);
                    }
                    SignerProperty signerProperty = new SignerProperty(bundle);
                    if (!signerProperty.isBundleSigned()) {
                        return null;
                    }
                    hashMap2.put("signer", signerProperty);
                    return null;
                }
            });
        }
        Properties properties2 = new Properties(hashMap2, this.service);
        this.properties = properties2;
        return properties2;
    }

    private static final class Properties extends AbstractMap<String, Object> {
        private volatile transient Set<Map.Entry<String, Object>> entries = null;
        private final Map<String, Object> properties;
        private final ServiceReference<?> service;

        Properties(Map<String, Object> map, ServiceReference<?> serviceReference) {
            this.properties = map;
            this.service = serviceReference;
        }

        public Object get(Object obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            String str = (String) obj;
            if (str.charAt(0) == '@') {
                return this.service.getProperty(str.substring(1));
            }
            Object obj2 = this.properties.get(str);
            if (obj2 != null) {
                return obj2;
            }
            return this.service.getProperty(str);
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            if (this.entries != null) {
                return this.entries;
            }
            HashSet hashSet = new HashSet(this.properties.entrySet());
            for (String str : this.service.getPropertyKeys()) {
                Iterator<String> it = this.properties.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.equalsIgnoreCase(it.next())) {
                            break;
                        }
                    } else {
                        hashSet.add(new Entry(str, this.service.getProperty(str)));
                        break;
                    }
                }
            }
            Set<Map.Entry<String, Object>> unmodifiableSet = Collections.unmodifiableSet(hashSet);
            this.entries = unmodifiableSet;
            return unmodifiableSet;
        }

        private static final class Entry implements Map.Entry<String, Object> {

            /* renamed from: k */
            private final String f6695k;

            /* renamed from: v */
            private final Object f6696v;

            Entry(String str, Object obj) {
                this.f6695k = str;
                this.f6696v = obj;
            }

            public String getKey() {
                return this.f6695k;
            }

            public Object getValue() {
                return this.f6696v;
            }

            public Object setValue(Object obj) {
                throw new UnsupportedOperationException();
            }

            public String toString() {
                return this.f6695k + "=" + this.f6696v;
            }

            public int hashCode() {
                String str = this.f6695k;
                int i = 0;
                int hashCode = str == null ? 0 : str.hashCode();
                Object obj = this.f6696v;
                if (obj != null) {
                    i = obj.hashCode();
                }
                return hashCode ^ i;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
                r5 = r5.getValue();
                r1 = r4.f6696v;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(java.lang.Object r5) {
                /*
                    r4 = this;
                    r0 = 1
                    if (r5 != r4) goto L_0x0004
                    return r0
                L_0x0004:
                    boolean r1 = r5 instanceof java.util.Map.Entry
                    r2 = 0
                    if (r1 != 0) goto L_0x000a
                    return r2
                L_0x000a:
                    java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                    java.lang.Object r1 = r5.getKey()
                    java.lang.String r3 = r4.f6695k
                    if (r3 == r1) goto L_0x001c
                    if (r3 == 0) goto L_0x002d
                    boolean r1 = r3.equals(r1)
                    if (r1 == 0) goto L_0x002d
                L_0x001c:
                    java.lang.Object r5 = r5.getValue()
                    java.lang.Object r1 = r4.f6696v
                    if (r1 == r5) goto L_0x002e
                    if (r1 == 0) goto L_0x002d
                    boolean r5 = r1.equals(r5)
                    if (r5 == 0) goto L_0x002d
                    goto L_0x002e
                L_0x002d:
                    return r2
                L_0x002e:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.ServicePermission.Properties.Entry.equals(java.lang.Object):boolean");
            }
        }
    }
}

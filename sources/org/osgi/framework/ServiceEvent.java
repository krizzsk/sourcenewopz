package org.osgi.framework;

import java.util.EventObject;

public class ServiceEvent extends EventObject {
    public static final int MODIFIED = 2;
    public static final int MODIFIED_ENDMATCH = 8;
    public static final int REGISTERED = 1;
    public static final int UNREGISTERING = 4;
    static final long serialVersionUID = 8792901483909409299L;
    private final ServiceReference<?> reference;
    private final int type;

    public ServiceEvent(int i, ServiceReference<?> serviceReference) {
        super(serviceReference);
        this.reference = serviceReference;
        this.type = i;
    }

    public ServiceReference<?> getServiceReference() {
        return this.reference;
    }

    public int getType() {
        return this.type;
    }
}

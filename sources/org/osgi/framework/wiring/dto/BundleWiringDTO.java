package org.osgi.framework.wiring.dto;

import java.util.Set;
import org.osgi.dto.DTO;
import org.osgi.resource.dto.WiringDTO;

public class BundleWiringDTO extends DTO {
    public long bundle;
    public Set<NodeDTO> nodes;
    public Set<BundleRevisionDTO> resources;
    public int root;

    public static class NodeDTO extends WiringDTO {
        public boolean current;
        public boolean inUse;
    }
}

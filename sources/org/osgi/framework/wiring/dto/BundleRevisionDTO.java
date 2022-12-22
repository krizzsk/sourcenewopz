package org.osgi.framework.wiring.dto;

import org.osgi.resource.dto.ResourceDTO;

public class BundleRevisionDTO extends ResourceDTO {
    public long bundle;
    public String symbolicName;
    public int type;
    public String version;
}

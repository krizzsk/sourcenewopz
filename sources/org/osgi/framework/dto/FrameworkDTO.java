package org.osgi.framework.dto;

import java.util.List;
import java.util.Map;
import org.osgi.dto.DTO;

public class FrameworkDTO extends DTO {
    public List<BundleDTO> bundles;
    public Map<String, Object> properties;
    public List<ServiceReferenceDTO> services;
}

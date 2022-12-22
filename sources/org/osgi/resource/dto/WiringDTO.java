package org.osgi.resource.dto;

import java.util.List;
import org.osgi.dto.DTO;

public class WiringDTO extends DTO {
    public List<CapabilityRefDTO> capabilities;

    /* renamed from: id */
    public int f6702id;
    public List<WireDTO> providedWires;
    public List<WireDTO> requiredWires;
    public List<RequirementRefDTO> requirements;
    public int resource;
}

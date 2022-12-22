package org.osgi.resource.dto;

import org.osgi.dto.DTO;

public class WireDTO extends DTO {
    public CapabilityRefDTO capability;
    public int provider;
    public RequirementRefDTO requirement;
    public int requirer;
}

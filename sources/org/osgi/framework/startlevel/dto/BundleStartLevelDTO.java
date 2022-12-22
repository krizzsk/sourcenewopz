package org.osgi.framework.startlevel.dto;

import org.osgi.dto.DTO;

public class BundleStartLevelDTO extends DTO {
    public boolean activationPolicyUsed;
    public long bundle;
    public boolean persistentlyStarted;
    public int startLevel;
}

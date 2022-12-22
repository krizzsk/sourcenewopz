package com.didi.global.globalgenerickit.model.sheet;

import java.io.Serializable;
import java.util.List;

public class ComponentSheetData implements Serializable {
    public String imageUrl;
    public ComponentSheetLinkOptions link_option;
    public List<ComponentSheetOptions> options;
    public String subtitle;
    public String title;
}

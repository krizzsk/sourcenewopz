package com.didi.global.globaluikit.richinfo.model;

import java.io.Serializable;
import java.util.List;

public class RichInfoExtraModel implements Serializable {
    public RichInfoColorModel bg_color;
    public String bg_image;
    public int corner_radius;
    public int insert_index;
    public List<RichInfoExtraItem> items;
    public RichInfoMargin margin;
    public RichInfoMargin padding;
}

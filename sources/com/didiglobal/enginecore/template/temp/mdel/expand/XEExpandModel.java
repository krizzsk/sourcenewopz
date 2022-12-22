package com.didiglobal.enginecore.template.temp.mdel.expand;

import com.didiglobal.enginecore.template.temp.mdel.XEArrowModel;
import com.didiglobal.enginecore.template.temp.mdel.XECardClick;
import com.didiglobal.enginecore.template.temp.mdel.XEModelContent;
import java.io.Serializable;

public class XEExpandModel implements Serializable {
    public XEArrowModel arrow;
    public String bg_color;
    public String bg_image;
    public XEExpandBtn button_click;
    public XECardClick card_click;
    public int display_count;
    public XEModelContent extension;
    public String right_icon;
    public XEModelContent subtitle;
    public XEModelContent title;
}

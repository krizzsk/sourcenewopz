package com.didiglobal.enginecore.template.temp.mdel.normal;

import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.didiglobal.enginecore.template.temp.XEExtension;
import com.didiglobal.enginecore.template.temp.mdel.XEArrowModel;
import com.didiglobal.enginecore.template.temp.mdel.XECardClick;
import com.didiglobal.enginecore.template.temp.mdel.XEModelContent;
import java.io.Serializable;

public class XENormalModel extends IXEViewModel implements Serializable {
    public XEArrowModel arrow;
    public String bg_color;
    public String bg_image;
    public XECardClick card_click;
    public XEExtension extension;
    public String right_icon;
    public XEModelContent subtitle;
    public XEModelContent title;
}

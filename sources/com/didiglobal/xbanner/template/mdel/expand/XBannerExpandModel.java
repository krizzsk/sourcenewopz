package com.didiglobal.xbanner.template.mdel.expand;

import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.didiglobal.xbanner.template.mdel.XBannerArrowModel;
import com.didiglobal.xbanner.template.mdel.XBannerCardClick;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.didiglobal.xbanner.template.mdel.XBannerModelContent;
import java.io.Serializable;

public class XBannerExpandModel extends XBCardViewData implements Serializable {
    public XBannerArrowModel arrow;
    public String bg_color;
    public String bg_image;
    public XBannerExpandBtn button_click;
    public XBannerCardClick card_click;
    public int display_count;
    public XBannerExtension extension;
    public String right_icon;
    public XBannerModelContent subtitle;
    public XBannerModelContent title;
}

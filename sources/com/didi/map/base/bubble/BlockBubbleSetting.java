package com.didi.map.base.bubble;

import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.core.element.ClickBlockBubbleParam;
import com.didi.map.core.element.MapTrafficIcon;

public class BlockBubbleSetting {
    public final ClickBlockBubbleParam blockBubbleParam;
    public final MapTrafficIcon mapTrafficIcon;
    public final Bubble.PointArea pointArea;
    public final TextLableOnRoute textLableOnRoute;
    public final int trafficSectionType;

    public BlockBubbleSetting(TextLableOnRoute textLableOnRoute2, Bubble.PointArea pointArea2, int i, MapTrafficIcon mapTrafficIcon2, ClickBlockBubbleParam clickBlockBubbleParam) {
        this.textLableOnRoute = textLableOnRoute2;
        this.pointArea = pointArea2;
        this.trafficSectionType = i;
        this.mapTrafficIcon = mapTrafficIcon2;
        this.blockBubbleParam = clickBlockBubbleParam;
    }
}

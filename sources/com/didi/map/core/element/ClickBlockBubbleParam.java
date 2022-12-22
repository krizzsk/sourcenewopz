package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class ClickBlockBubbleParam extends BaseClickBubbleParam {
    public static final int ACTION_HIDE_DIALOG = 2;
    public static final int ACTION_PRE_LOAD = 0;
    public static final int ACTION_SHOW_DIALOG = 1;
    public int action;
    public final List<String> blockImgUrl = new ArrayList();
    public int blockLength;
    public String blockRoadName = "";
    public final List<String> blockVideoThumbUrls = new ArrayList();
    public final List<String> blockVideoUrls = new ArrayList();
    public String imgSource = "滴滴热心用户";
    public LatLng latLng;
    public int priority;
    public final List<String> thumbUrl = new ArrayList();
    public int updateInterval;

    public String toString() {
        return "ClickBlockBubbleParam{action=" + this.action + ", blockImgUrl=" + this.blockImgUrl + ", thumbUrl=" + this.thumbUrl + ", latLng=" + this.latLng + ", updateInterval=" + this.updateInterval + ", blockLength=" + this.blockLength + ", imgSource='" + this.imgSource + '\'' + ", blockRoadName='" + this.blockRoadName + '\'' + ", blockVideoUrls=" + this.blockVideoUrls + ", blockVideoThumbUrls=" + this.blockVideoThumbUrls + ", priority=" + this.priority + ", eventId=" + this.eventId + '}';
    }
}

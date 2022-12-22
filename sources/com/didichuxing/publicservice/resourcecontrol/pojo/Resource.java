package com.didichuxing.publicservice.resourcecontrol.pojo;

import java.io.Serializable;
import java.util.List;

public class Resource implements Serializable {
    public List<SingleResource> list;

    public static class SingleResource implements Serializable {
        public String adid;
        public long beginTime;
        public String clickContent;
        public int contentId;
        public long endTime;
        public String image;
        public int isAd;
        public long lastShowTime;
        public String link;
        public String localPath;
        public int resourceId;
        public String url;

        public String toString() {
            return "resourceId:" + this.resourceId + ", contentId:" + this.contentId + ", image:" + this.image + ", link:" + this.link + ", adid:" + this.adid + ", beginTime:" + this.beginTime + ", endTime:" + this.endTime + ", url:" + this.url + ", clickContent:" + this.clickContent + ", isAd:" + this.isAd;
        }
    }

    public String toString() {
        return "Resource{list=" + this.list + '}';
    }
}

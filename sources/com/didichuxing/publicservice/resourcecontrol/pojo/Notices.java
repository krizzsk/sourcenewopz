package com.didichuxing.publicservice.resourcecontrol.pojo;

import java.io.Serializable;
import java.util.List;

public class Notices implements Serializable {
    public List<Notice> list;

    public class Notice implements Serializable {
        public String adid;
        public String businessType;
        public int contentId;
        public String desc;
        public String image;
        public String link;
        public String sendTime;
        public String title;
        public int visited;

        public Notice() {
        }
    }
}

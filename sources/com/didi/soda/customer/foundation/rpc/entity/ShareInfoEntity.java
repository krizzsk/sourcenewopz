package com.didi.soda.customer.foundation.rpc.entity;

import java.util.ArrayList;
import java.util.List;

public class ShareInfoEntity implements IEntity {
    private static final long serialVersionUID = 9076147313387381620L;
    public List<ChannelEntity> channels = new ArrayList();

    public String toString() {
        return "{channels:" + this.channels + "}";
    }

    public static class ChannelEntity implements IEntity {
        private static final long serialVersionUID = 3836279714305182716L;
        public String channel;
        public String content;
        public String pic;
        public String title;
        public String url;

        public String toString() {
            return "{url:" + this.url + "channel:" + this.channel + ",title:" + this.title + ",content:" + this.content + ",pic:" + this.pic + "}";
        }
    }
}

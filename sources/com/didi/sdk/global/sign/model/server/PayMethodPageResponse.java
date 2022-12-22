package com.didi.sdk.global.sign.model.server;

import java.io.Serializable;
import java.util.List;

public class PayMethodPageResponse implements Serializable {
    public Data data;
    public String errmsg;
    public int errno;

    public static class Channel implements Serializable {
        public String channel_desc;
        public int channel_id;
        public String channel_name;
        public List<ChannelItemInfo> channel_sub_values;
        public int default_payment_flag;
        public String detail_page_url;
        public boolean hot_point_flag;
        public String icon_url;
        public int sign_status;
        public String value;
    }

    public static class ChannelItemInfo implements Serializable {
        public String card_index;
        public String card_no;
        public int card_status;
        public int default_card_flag;
        public int expired;
        public String expired_desc;
        public String expiry_date;
        public String icon_url;
        public String status_desc;
    }

    public static class Data implements Serializable {
        public List<Entry> allEntries;
        public String title;
    }

    public static class Entry implements Serializable {
        public static final int TYPE_PAYMENT = 1;
        public static final int TYPE_PROMOTION = 24;
        public List<Channel> channels;
        public String desc;
        public String event_id;
        public String icon_url;
        public String name;
        public int type;
        public String url;
    }
}

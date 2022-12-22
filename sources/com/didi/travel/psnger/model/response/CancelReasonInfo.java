package com.didi.travel.psnger.model.response;

import java.io.Serializable;
import java.util.ArrayList;

public class CancelReasonInfo implements Serializable {
    public String context;
    public int is_show_reason;
    public CancelReasonOperation operations;
    public ArrayList<CancelReasonItem> reason_list;
    public String title;

    public static class CancelReasonBtn implements Serializable {
        public int btn_type;
        public int show_type;
        public String title;
    }

    public static class CancelReasonItem implements Serializable {
        public String icon;
        public ArrayList<CancelReasonSubItem> list;
        public int reason_type;
        public String title;
    }

    public static class CancelReasonOperation implements Serializable {
        public String btn_context;
        public ArrayList<CancelReasonBtn> btn_list;
        public String btn_title;
    }

    public static class CancelReasonSubItem implements Serializable {
        public CancelReasonOperation operations;
        public String reason_id;
        public int show_alert;
        public String text;
    }
}

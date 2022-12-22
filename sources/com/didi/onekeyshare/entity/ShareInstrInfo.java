package com.didi.onekeyshare.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ShareInstrInfo implements Serializable {
    public ArrayList<InstrContent> item;
    public String title;

    public static class InstrContent implements Serializable {
        public String item_icon;
        public String item_text;

        public InstrContent(String str, String str2) {
            this.item_icon = str;
            this.item_text = str2;
        }
    }
}

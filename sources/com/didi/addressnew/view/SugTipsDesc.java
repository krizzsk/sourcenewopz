package com.didi.addressnew.view;

import android.text.TextUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SugTipsDesc {
    public String text;
    public Info text_info;

    public SugTipsDesc(String str, Info info) {
        this.text = str;
        this.text_info = info;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Info getText_info() {
        return this.text_info;
    }

    public void setText_info(Info info) {
        this.text_info = info;
    }

    public SugTipsDesc(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        this.text = str;
        Info info = new Info();
        info.setStart(str2);
        info.setLength(str3);
        info.setColor(str4);
        info.setBold(i);
        info.setThrough(i2);
        info.setLink(str5);
        this.text_info = info;
    }

    public static SugTipsDesc buildSugTipsDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("text");
            JSONObject jSONObject2 = new JSONArray(jSONObject.getString("info")).getJSONObject(0);
            return new SugTipsDesc(string, jSONObject2.getString("start"), jSONObject2.getString("length"), jSONObject2.getString("color"), jSONObject2.getInt(BlocksConst.BLOCK_FONT_BOLD), jSONObject2.getInt("through"), jSONObject2.getString("link"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    class Info {
        int bold;
        String color;
        String length;
        String link;
        String start;
        int through;

        Info() {
        }

        public String getStart() {
            return this.start;
        }

        public void setStart(String str) {
            this.start = str;
        }

        public String getLength() {
            return this.length;
        }

        public void setLength(String str) {
            this.length = str;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public int getBold() {
            return this.bold;
        }

        public void setBold(int i) {
            this.bold = i;
        }

        public int getThrough() {
            return this.through;
        }

        public void setThrough(int i) {
            this.through = i;
        }

        public String getLink() {
            return this.link;
        }

        public void setLink(String str) {
            this.link = str;
        }
    }
}

package com.didichuxing.publicservice.resourcecontrol.pojo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DPopResource implements Serializable, Cloneable {
    @SerializedName(alternate = {"result"}, value = "data")
    public DataBean[] data;
    @SerializedName(alternate = {"errmsg"}, value = "errormsg")
    public String errmsg;
    @SerializedName(alternate = {"errno"}, value = "errorno")
    public int errno;

    public DPopResource clone() {
        DPopResource dPopResource;
        CloneNotSupportedException e;
        try {
            dPopResource = (DPopResource) super.clone();
            try {
                dPopResource.data = (DataBean[]) this.data.clone();
            } catch (CloneNotSupportedException e2) {
                e = e2;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            dPopResource = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return dPopResource;
        }
        return dPopResource;
    }

    public static class DataBean implements Serializable {
        public int activity_id;
        public String cdn;
        public List<String> click_tracks;
        public List<String> close_tracks;
        public Object data;
        @Deprecated
        public transient DataDetail dataDetail = new DataDetail();
        public List<String> imp_tracks;
        public HashMap log_data = new HashMap();

        public String toString() {
            return "DataBean{activity_id=" + this.activity_id + "cdn=" + this.cdn + ", data='" + this.data.toString() + '\'' + ", log_data=" + this.log_data + '}';
        }
    }

    public static class DataDetail implements Serializable {
        public String address;
        public String btnColor;
        public String btnText;
        public String image;
        public String line1;
        public String line2;
        public String line3;
        public String line4;
        public String line5;
        public String line6;
        public String link;
        public String logo;
        public String lwrate;
        public String title;
        public String type;

        public String toString() {
            return "DataDetail{link='" + this.link + '\'' + ", image='" + this.image + '\'' + ", type='" + this.type + '\'' + ", address='" + this.address + '\'' + ", title='" + this.title + '\'' + ", line1='" + this.line1 + '\'' + ", line2='" + this.line2 + '\'' + ", line3='" + this.line3 + '\'' + ", line4='" + this.line4 + '\'' + ", line5='" + this.line5 + '\'' + ", line6='" + this.line6 + '\'' + ", btnText='" + this.btnText + '\'' + ", btnColor='" + this.btnColor + '\'' + ", lwrate='" + this.lwrate + '\'' + ", logo='" + this.logo + '\'' + '}';
        }
    }

    public String toString() {
        return "DPopResource{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", data=" + this.data + '}';
    }
}

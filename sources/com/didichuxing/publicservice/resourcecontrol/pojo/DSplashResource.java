package com.didichuxing.publicservice.resourcecontrol.pojo;

import com.didichuxing.publicservice.general.AppUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DSplashResource implements Serializable {
    @SerializedName("result")
    public List<DataBean> data;
    @SerializedName(alternate = {"errmsg"}, value = "errormsg")
    public String errmsg;
    @SerializedName(alternate = {"errno"}, value = "errorno")
    public int errno;

    public static class DataBean implements Serializable {
        public int activity_id;
        public String cdn;
        public List<String> click_tracks;
        public List<String> close_tracks;
        public Object data;
        public transient DataDetail dataDetail;
        public List<String> imp_tracks;
        public HashMap<String, Object> log_data = new HashMap<>();
        public List<TimesegsBean> timesegs;

        public DataDetail getDataDetail() {
            if (this.dataDetail == null) {
                this.dataDetail = (DataDetail) AppUtils.parseJson(AppUtils.convertObjectToString(this.data), DataDetail.class);
            }
            return this.dataDetail;
        }

        public String getLogData() {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : this.log_data.entrySet()) {
                try {
                    jSONObject.put(next.getKey().toString(), next.getValue().toString());
                    return jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return "";
        }

        public void setLogData(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.log_data.put(next, jSONObject.optString(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return "DataBean{activity_id=" + this.activity_id + "data=" + this.data + ", log_data=" + this.log_data + ", timesegs=" + this.timesegs + '}';
        }
    }

    public static class DataDetail implements Serializable {
        public String clickContent;
        public String image;
        public int is_ad;
        public int is_default;
        public int is_single;
        public long lastShowTime;
        public String localPath;
        public int muilt_size;
        public String url;
        public int useLogo;

        public String toString() {
            return "DataDetail{is_ad=" + this.is_ad + ", use_logo=" + this.useLogo + ", muilt_size=" + this.muilt_size + ", is_single=" + this.is_single + ", is_default=" + this.is_default + ", url='" + this.url + '\'' + ", clickContent='" + this.clickContent + '\'' + ", image='" + this.image + '\'' + ", localPath='" + this.localPath + '\'' + ", lastShowTime=" + this.lastShowTime + '}';
        }
    }

    public String toString() {
        return "DSplashResource{errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", data=" + this.data + '}';
    }

    public static class TimesegsBean implements Serializable {
        public long end_time;
        public long start_time;

        public boolean equals(Object obj) {
            if (!(obj instanceof TimesegsBean)) {
                return super.equals(obj);
            }
            TimesegsBean timesegsBean = (TimesegsBean) obj;
            return this.start_time == timesegsBean.start_time && this.end_time == timesegsBean.end_time;
        }
    }
}

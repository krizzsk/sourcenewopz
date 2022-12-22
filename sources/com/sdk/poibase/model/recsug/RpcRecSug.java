package com.sdk.poibase.model.recsug;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.RpcPoi;
import java.io.Serializable;
import java.util.ArrayList;

public class RpcRecSug extends HttpResultBase {
    @SerializedName("canonical_country_code")
    public String canonicalCountryCode;
    @SerializedName("city_id")
    public int city_id;
    @SerializedName("city")
    public String city_name;
    @SerializedName("company_poi")
    public RpcPoi company_poi;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public int countryId;
    @SerializedName("data_provider_logo")
    public String data_provider_logo;
    @SerializedName("common_poi")
    public ArrayList<RpcPoi> favorite_poi_list;
    @SerializedName("home_poi")
    public RpcPoi home_poi;
    @SerializedName("is_complete_poi")
    public int is_complete_poi = -1;
    @SerializedName("lang")
    public String lang;
    @SerializedName("data_provider_logo_extend")
    public LogoSize logosize;
    @SerializedName("rec_poi_list")
    public ArrayList<RpcPoi> rec_poi_list;
    @SerializedName("request_time")
    public String request_time;
    @SerializedName("result")
    public ArrayList<RpcPoi> result;
    @SerializedName("search_id")
    public String search_id;
    @SerializedName("searchname")
    public String search_name;
    @SerializedName("search_query")
    public String search_query;
    @SerializedName("tips")
    public String tips;
    @SerializedName("tips_info")
    public TipsInfo tips_info;
    private TrackParameterForChild trackParmeterForChild;

    public class TrackParameterForChild implements Serializable {
        public boolean is_complete_poi;
        public String search_id;
        public String search_name;

        public TrackParameterForChild(String str, String str2, int i) {
            this.search_id = str;
            this.search_name = str2;
            this.is_complete_poi = i != 0;
        }
    }

    public TrackParameterForChild getTrackParameter() {
        return new TrackParameterForChild(this.search_id, this.search_name, this.is_complete_poi);
    }

    public static class LogoSize implements Serializable {
        @SerializedName("height")
        public int height;
        @SerializedName("width")
        public int width;

        public String toString() {
            return "LogoSize{width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static class TipsInfo implements Serializable {
        @SerializedName("background_color")
        public String background_color;
        @SerializedName("content")
        public String content;
        @SerializedName("content_color")
        public String content_color;
        @SerializedName("logo")
        public String logo;
        @SerializedName("text_desc")
        public String text_desc;
        @SerializedName("type")
        public int type;

        public String toString() {
            return "TipsInfo{type=" + this.type + ", content='" + this.content + '\'' + ", content_color='" + this.content_color + '\'' + ", background_color='" + this.background_color + '\'' + ", logo='" + this.logo + '\'' + ", text_desc='" + this.text_desc + '\'' + '}';
        }
    }

    public static class TextDesc implements Serializable {
        @SerializedName("info")
        public TextDescInfo info;
        @SerializedName("text")
        public String text;

        public String toString() {
            return "TextDesc{text='" + this.text + '\'' + ", info=" + this.info + '}';
        }
    }

    public static class TextDescInfo implements Serializable {
        @SerializedName("bold")
        public String bold;
        @SerializedName("color")
        public String color;
        @SerializedName("length")
        public int length;
        @SerializedName("link")
        public String link;
        @SerializedName("start")
        public int start;
        @SerializedName("through")
        public String through;

        public String toString() {
            return "TextDescInfo{start=" + this.start + ", length=" + this.length + ", color='" + this.color + '\'' + ", bold='" + this.bold + '\'' + ", through='" + this.through + '\'' + ", link='" + this.link + '\'' + '}';
        }
    }

    public String toString() {
        return "RpcRecSug{search_id='" + this.search_id + '\'' + ", search_name='" + this.search_name + '\'' + ", request_time='" + this.request_time + '\'' + ", rec_poi_list=" + this.rec_poi_list + ", company_poi=" + this.company_poi + ", home_poi=" + this.home_poi + ", is_complete_poi=" + this.is_complete_poi + ", data_provider_logo='" + this.data_provider_logo + '\'' + ", logosize=" + this.logosize + ", tips='" + this.tips + '\'' + ", lang='" + this.lang + '\'' + ", search_query='" + this.search_query + '\'' + ", result=" + this.result + ", city_id=" + this.city_id + ", city_name='" + this.city_name + '\'' + ", countryId=" + this.countryId + ", countryCode='" + this.countryCode + '\'' + ", canonicalCountryCode='" + this.canonicalCountryCode + '\'' + '}';
    }
}

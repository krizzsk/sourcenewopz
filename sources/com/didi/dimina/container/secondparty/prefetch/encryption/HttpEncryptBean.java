package com.didi.dimina.container.secondparty.prefetch.encryption;

import com.google.gson.annotations.SerializedName;

public class HttpEncryptBean {
    @SerializedName("header")
    private HeaderBean header;
    @SerializedName("query")
    private QueryBean query;

    public HeaderBean getHeader() {
        return this.header;
    }

    public void setHeader(HeaderBean headerBean) {
        this.header = headerBean;
    }

    public QueryBean getQuery() {
        return this.query;
    }

    public void setQuery(QueryBean queryBean) {
        this.query = queryBean;
    }

    public String toString() {
        return "HttpEncrytionModel{header=" + this.header + ", query=" + this.query + '}';
    }

    public static class HeaderBean {
        @SerializedName("Cityid")
        private String Cityid;
        @SerializedName("Device-ID")
        private String Device_ID;
        @SerializedName("ddfp")
        private String ddfp;
        @SerializedName("dev")
        private String dev;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;

        public String getCityid() {
            return this.Cityid;
        }

        public void setCityid(String str) {
            this.Cityid = str;
        }

        public String getDevice_ID() {
            return this.Device_ID;
        }

        public void setDevice_ID(String str) {
            this.Device_ID = str;
        }

        public String getLat() {
            return this.lat;
        }

        public void setLat(String str) {
            this.lat = str;
        }

        public String getLng() {
            return this.lng;
        }

        public void setLng(String str) {
            this.lng = str;
        }

        public String getDev() {
            return this.dev;
        }

        public void setDev(String str) {
            this.dev = str;
        }

        public String getDdfp() {
            return this.ddfp;
        }

        public void setDdfp(String str) {
            this.ddfp = str;
        }

        public String toString() {
            return "HeaderBean{Cityid='" + this.Cityid + '\'' + ", Device_ID='" + this.Device_ID + '\'' + ", lat='" + this.lat + '\'' + ", lng='" + this.lng + '\'' + ", dev='" + this.dev + '\'' + ", ddfp='" + this.ddfp + '\'' + '}';
        }
    }

    public static class QueryBean {
        @SerializedName("dev")
        private String dev;
        @SerializedName("lat")
        private String lat;
        @SerializedName("latitude")
        private String latitude;
        @SerializedName("lng")
        private String lng;
        @SerializedName("longitude")
        private String longitude;

        public String getLat() {
            return this.lat;
        }

        public void setLat(String str) {
            this.lat = str;
        }

        public String getLng() {
            return this.lng;
        }

        public void setLng(String str) {
            this.lng = str;
        }

        public String getDev() {
            return this.dev;
        }

        public void setDev(String str) {
            this.dev = str;
        }

        public String getLatitude() {
            return this.latitude;
        }

        public void setLatitude(String str) {
            this.latitude = str;
        }

        public String getLongitude() {
            return this.longitude;
        }

        public void setLongitude(String str) {
            this.longitude = str;
        }

        public String toString() {
            return "QueryBean{lat='" + this.lat + '\'' + ", lng='" + this.lng + '\'' + ", dev='" + this.dev + '\'' + ", latitude='" + this.latitude + '\'' + ", longitude='" + this.longitude + '\'' + '}';
        }
    }
}

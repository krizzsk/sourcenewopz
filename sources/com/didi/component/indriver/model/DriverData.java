package com.didi.component.indriver.model;

import android.text.TextUtils;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import org.json.JSONObject;

public class DriverData {
    public OptionBtn accept;
    public String avatar;
    public String bargainId;
    public String carBrand;
    public String did;
    public LEGORichInfo eta = new LEGORichInfo();
    public long expireTs;
    public String name;
    public LEGORichInfo price = new LEGORichInfo();
    public OptionBtn reject;
    public double star;
    public String starUrl;
    public String trips;
    public long ttl;

    public static DriverData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DriverData driverData = new DriverData();
        driverData.eta.setInfo(jSONObject.optString("eda"));
        driverData.price.setInfo(jSONObject.optString("price"));
        driverData.did = jSONObject.optString("did");
        driverData.name = jSONObject.optString("name");
        driverData.avatar = jSONObject.optString("avatar");
        driverData.trips = jSONObject.optString("trips");
        driverData.starUrl = jSONObject.optString("star_url");
        driverData.carBrand = jSONObject.optString("car_brand");
        driverData.bargainId = jSONObject.optString("bargain_id");
        driverData.ttl = jSONObject.optLong("ttl");
        driverData.expireTs = jSONObject.optLong("expireTs");
        driverData.star = jSONObject.optDouble("star");
        driverData.reject = OptionBtn.parse(jSONObject.optJSONObject("option_no_btn"));
        driverData.accept = OptionBtn.parse(jSONObject.optJSONObject("option_yes_btn"));
        return driverData;
    }

    public String toString() {
        return "DriverData{eta=" + this.eta + ", price=" + this.price + ", reject=" + this.reject + ", accept=" + this.accept + ", did='" + this.did + '\'' + ", name='" + this.name + '\'' + ", avatar='" + this.avatar + '\'' + ", trips='" + this.trips + '\'' + ", star=" + this.star + ", starUrl='" + this.starUrl + '\'' + ", carBrand='" + this.carBrand + '\'' + ", expireTs=" + this.expireTs + ", ttl=" + this.ttl + ", bargainId='" + this.bargainId + '\'' + '}';
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriverData)) {
            return false;
        }
        DriverData driverData = (DriverData) obj;
        return TextUtils.equals(driverData.bargainId, this.bargainId) && TextUtils.equals(driverData.did, this.did);
    }

    public int hashCode() {
        LEGORichInfo lEGORichInfo = this.eta;
        int i = 0;
        int hashCode = (lEGORichInfo != null ? lEGORichInfo.hashCode() : 0) * 31;
        LEGORichInfo lEGORichInfo2 = this.price;
        int hashCode2 = (hashCode + (lEGORichInfo2 != null ? lEGORichInfo2.hashCode() : 0)) * 31;
        OptionBtn optionBtn = this.reject;
        int hashCode3 = (hashCode2 + (optionBtn != null ? optionBtn.hashCode() : 0)) * 31;
        OptionBtn optionBtn2 = this.accept;
        int hashCode4 = (hashCode3 + (optionBtn2 != null ? optionBtn2.hashCode() : 0)) * 31;
        String str = this.did;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.trips;
        int hashCode8 = hashCode7 + (str4 != null ? str4.hashCode() : 0);
        long doubleToLongBits = Double.doubleToLongBits(this.star);
        int i2 = ((hashCode8 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str5 = this.starUrl;
        int hashCode9 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.carBrand;
        int hashCode10 = str6 != null ? str6.hashCode() : 0;
        long j = this.expireTs;
        long j2 = this.ttl;
        int i3 = (((((hashCode9 + hashCode10) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str7 = this.bargainId;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return i3 + i;
    }
}

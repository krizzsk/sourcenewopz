package com.didi.unifylogin.base.net.pojo.response;

import android.text.TextUtils;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.listener.ListenerManager;
import java.io.Serializable;
import java.util.List;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryListResponse extends BaseResponse {
    public List<CountryRule> common_country_list;
    public String common_country_text;
    public List<CountryRule> country_list;
    public String md5;
    public String nat_flag_base_url;

    public List<CountryRule> getCoutryRules() {
        List<CountryRule> list = this.country_list;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.country_list;
    }

    public static class CountryRule implements Serializable {
        public static String NAT_FLAG_BASE_URL;
        public String area;
        public String calling_code;
        public int country_id;
        public String flag_url;
        public String format;
        public String format_with_number;
        public String letter;
        public int max_len;
        public int min_len;
        public String name;
        public int old_country_id;
        public String[] prefixes;
        public String sort_key;

        public CountryRule(String str, String str2, int i, int i2, String str3, String str4, String str5) {
            this.name = str;
            this.calling_code = str2;
            this.old_country_id = i;
            this.country_id = i2;
            this.area = str3;
            this.format = str4;
            this.flag_url = str5;
        }

        public String getNationalFlagUrl() {
            if (TextUtils.isEmpty(NAT_FLAG_BASE_URL)) {
                return "";
            }
            return NAT_FLAG_BASE_URL + this.area + IMPictureMimeType.PNG;
        }

        public String toJSON() throws JSONException {
            return getJSONObj().toString();
        }

        public JSONObject getJSONObj() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", this.name);
            jSONObject.put(ParamConst.PARAM_CALLING_CODE, this.calling_code);
            jSONObject.put("country_id", this.country_id);
            jSONObject.put("area", this.area);
            jSONObject.put("format", this.format);
            jSONObject.put("flag_url", this.flag_url);
            jSONObject.put("nat_url", getNationalFlagUrl());
            jSONObject.put("max_len", this.max_len);
            jSONObject.put("min_len", this.min_len);
            jSONObject.put("sort_key", ensureSortKey());
            jSONObject.put("format_with_number", this.format_with_number);
            return jSONObject;
        }

        private String ensureSortKey() {
            String[] hanyuPinyinStringArray;
            if (!TextUtils.isEmpty(this.sort_key)) {
                return this.sort_key;
            }
            String str = null;
            if (ListenerManager.getGlobalizationListener() != null) {
                str = ListenerManager.getGlobalizationListener().getLanguage();
            }
            if (!"zh-CN".equals(str) || (hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(this.name.charAt(0))) == null || hanyuPinyinStringArray.length <= 0) {
                return this.name.substring(0, 1);
            }
            return hanyuPinyinStringArray[0].substring(0, 1);
        }
    }
}

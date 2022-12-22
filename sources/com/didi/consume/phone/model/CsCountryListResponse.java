package com.didi.consume.phone.model;

import com.didi.payment.commonsdk.net.WBaseResp;
import java.io.Serializable;
import java.util.List;

public class CsCountryListResponse extends WBaseResp {
    public List<CountryRule> country_list;
    public String md5;

    public List<CountryRule> getCoutryRules() {
        List<CountryRule> list = this.country_list;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.country_list;
    }

    public static class CountryRule implements Serializable {
        public String area;
        public String calling_code;
        public int country_id;
        public String flag_url;
        public String format;
        public String letter;
        public int max_len;
        public String name;
        public int old_country_id;
        public String[] prefixes;

        public CountryRule(String str, String str2, int i, int i2, String str3, String str4, String str5) {
            this.name = str;
            this.calling_code = str2;
            this.old_country_id = i;
            this.country_id = i2;
            this.area = str3;
            this.format = str4;
            this.flag_url = str5;
        }
    }
}

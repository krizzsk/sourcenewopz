package com.didi.payment.transfer.fillphone;

import com.didi.payment.transfer.net.TransBaseResp;
import java.util.List;

public class TransCountryCodeResp extends TransBaseResp {
    public CountryCodeList data;

    public static class CountryCodeList {
        public List<String> countryCallingCodes;
    }
}

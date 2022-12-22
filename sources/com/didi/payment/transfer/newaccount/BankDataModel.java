package com.didi.payment.transfer.newaccount;

import com.didi.payment.transfer.common.model.TransBankInfo;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BankDataModel {
    public static final int DATA_TYPE_FULLVALUES = 2;
    public static final int DATA_TYPE_TOPFIVE = 1;
    public Map<String, TransBankInfo> fullValues = new LinkedHashMap();
    public Map<String, TransBankInfo> topFive = new LinkedHashMap();

    public void clear() {
        this.topFive.clear();
        this.fullValues.clear();
    }

    public boolean isValid() {
        return !CollectionUtil.isEmpty((Map<?, ?>) this.topFive) && !CollectionUtil.isEmpty((Map<?, ?>) this.fullValues);
    }

    public void addBankItem(String str, TransBankInfo transBankInfo, int i) {
        Map<String, TransBankInfo> map;
        if (i == 1) {
            map = this.topFive;
        } else {
            map = this.fullValues;
        }
        map.put(str, transBankInfo);
    }

    public List<String> getTopFiveInStringList(int i) {
        Map<String, TransBankInfo> map;
        if (i == 1) {
            map = this.topFive;
        } else {
            map = this.fullValues;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(map.get(str).toString());
        }
        return arrayList;
    }
}

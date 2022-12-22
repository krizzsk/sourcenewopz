package com.didichuxing.omega.sdk.feedback.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ApiSigner {
    private Map<String, String> params = new HashMap();

    public ApiSigner add(String str, String str2) {
        this.params.put(str, str2);
        return this;
    }

    public ApiSigner add(String str, Object obj) {
        this.params.put(str, String.valueOf(obj));
        return this;
    }

    public String getToken() {
        StringBuilder sb = new StringBuilder(C12407a.f36603a);
        ArrayList arrayList = new ArrayList();
        for (String add : this.params.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append((String) arrayList.get(i));
            sb.append(this.params.get(arrayList.get(i)));
        }
        return MD5.stringToMD5(sb.toString());
    }
}

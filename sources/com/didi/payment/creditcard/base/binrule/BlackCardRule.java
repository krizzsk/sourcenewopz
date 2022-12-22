package com.didi.payment.creditcard.base.binrule;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class BlackCardRule {

    /* renamed from: a */
    private static final String f30266a = "[627780,506722,589916,603689,439267,506776,421870]";

    /* renamed from: b */
    private List<String> f30267b;

    public BlackCardRule(Context context, String str) {
        m21159a(str);
    }

    /* renamed from: a */
    private void m21159a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30267b = m21161c(m21160b(str));
        }
    }

    public boolean isBlackCard(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || str.length() < 6 || (list = this.f30267b) == null) {
            return false;
        }
        return list.contains(str.substring(0, 6));
    }

    /* renamed from: b */
    private String m21160b(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str);
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return null;
        }
        return (String) experiment.getParam("bin", "");
    }

    /* renamed from: c */
    private List<String> m21161c(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<String>>() {
        }.getType());
    }
}

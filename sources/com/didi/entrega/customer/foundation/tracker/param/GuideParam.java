package com.didi.entrega.customer.foundation.tracker.param;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class GuideParam extends C8090a implements Cloneable {

    /* renamed from: a */
    private static final String f20052a = "GuideParam";

    public static class GuideParamsEntity implements IEntity {
        public static final String KEY = "traceParams";
        @SerializedName("lv1_body")
        String mLv1Body;
        @SerializedName("lv1_filter")
        String mLv1Filter;
        @SerializedName("lv1_location")
        String mLv1Location;
        @SerializedName("lv1_parameter")
        String mLv1Parameter;
        @SerializedName("lv1_recid")
        String mLv1RecId;
        @SerializedName("lv2_body")
        String mLv2Body;
        @SerializedName("lv2_location")
        String mLv2Location;
        @SerializedName("lv2_recid")
        String mLv2RecId;
        @SerializedName("lv3_body")
        String mLv3Body;
        @SerializedName("lv3_location")
        String mLv3Location;
        @SerializedName("lv3_recid")
        String mLv3RecId;
        @SerializedName("lv4_body")
        String mLv4Body;
    }

    public GuideParam clone() {
        GuideParam guideParam = new GuideParam();
        guideParam.copyParams(this);
        return guideParam;
    }

    public boolean fetchParam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !"traceParams".equals(str)) {
            return false;
        }
        GuideParamsEntity guideParamsEntity = null;
        try {
            guideParamsEntity = (GuideParamsEntity) GsonUtil.fromJson(str2, GuideParamsEntity.class);
        } catch (JsonParseException e) {
            LogUtil.m14763e(f20052a, "fetchParam error:" + e.toString());
        }
        if (guideParamsEntity == null) {
            return false;
        }
        setLv1Location(guideParamsEntity.mLv1Location);
        setLv1RecId(guideParamsEntity.mLv1RecId);
        setLv1Body(guideParamsEntity.mLv1Body);
        setLv1Filter(guideParamsEntity.mLv1Filter);
        setLv1Parameter(guideParamsEntity.mLv1Parameter);
        setLv2Location(guideParamsEntity.mLv2Location);
        setLv2RecId(guideParamsEntity.mLv2RecId);
        setLv2Body(guideParamsEntity.mLv2Body);
        setLv3Location(guideParamsEntity.mLv3Location);
        setLv3RecId(guideParamsEntity.mLv3RecId);
        setLv3Body(guideParamsEntity.mLv3Body);
        setLv4Body(guideParamsEntity.mLv4Body);
        return true;
    }

    public GuideParamsEntity generateEntity() {
        GuideParamsEntity guideParamsEntity = new GuideParamsEntity();
        guideParamsEntity.mLv1Location = getParam("lv1_location");
        guideParamsEntity.mLv1RecId = getParam("lv1_recid");
        guideParamsEntity.mLv1Body = getParam("lv1_body");
        guideParamsEntity.mLv1Filter = getParam("lv1_filter");
        guideParamsEntity.mLv1Parameter = getParam("lv1_parameter");
        guideParamsEntity.mLv2Location = getParam("lv2_location");
        guideParamsEntity.mLv2RecId = getParam("lv2_recid");
        guideParamsEntity.mLv2Body = getParam("lv2_body");
        guideParamsEntity.mLv3Location = getParam("lv3_location");
        guideParamsEntity.mLv3RecId = getParam("lv3_recid");
        guideParamsEntity.mLv3Body = getParam("lv3_body");
        guideParamsEntity.mLv4Body = getParam("lv4_body");
        return guideParamsEntity;
    }

    public Map<String, Object> getGuideParamMap() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(m14805e());
        hashMap.putAll(m14806f());
        hashMap.putAll(m14807g());
        hashMap.putAll(m14808h());
        return hashMap;
    }

    public void refreshLv1GuideParam() {
        m14800a();
        m14802b();
        m14803c();
        m14804d();
    }

    public void refreshLv2GuideParam() {
        m14802b();
        m14803c();
        m14804d();
    }

    public void refreshLv3GuideParam() {
        m14803c();
        m14804d();
    }

    public void refreshLv4GuideParam() {
        m14804d();
    }

    public void setLv1Body(String str) {
        putParam("lv1_body", str);
    }

    public void setLv1Location(String str) {
        putParam("lv1_location", str);
    }

    public void setLv1RecId(String str) {
        putParam("lv1_recid", str);
    }

    public void setLv1Filter(String str) {
        putParam("lv1_filter", str);
    }

    public void setLv1Parameter(String str) {
        putParam("lv1_parameter", str);
    }

    public void setLv2Location(String str) {
        putParam("lv2_location", str);
    }

    public void setLv2RecId(String str) {
        putParam("lv2_recid", str);
    }

    public void setLv2Body(String str) {
        putParam("lv2_body", str);
    }

    public void setLv3Body(String str) {
        putParam("lv3_body", str);
    }

    public void setLv3Location(String str) {
        putParam("lv3_location", str);
    }

    public void setLv3RecId(String str) {
        putParam("lv3_recid", str);
    }

    public void setLv4Body(String str) {
        putParam("lv4_body", str);
    }

    /* renamed from: a */
    private void m14800a() {
        removeParam("lv1_location");
        removeParam("lv1_recid");
        removeParam("lv1_body");
        removeParam("lv1_filter");
        removeParam("lv1_parameter");
    }

    /* renamed from: b */
    private void m14802b() {
        removeParam("lv2_location");
        removeParam("lv2_recid");
        removeParam("lv2_body");
    }

    /* renamed from: c */
    private void m14803c() {
        removeParam("lv3_location");
        removeParam("lv3_recid");
        removeParam("lv3_body");
    }

    /* renamed from: d */
    private void m14804d() {
        removeParam("lv4_body");
    }

    /* renamed from: e */
    private Map<String, String> m14805e() {
        HashMap hashMap = new HashMap();
        m14801a(getParams(), hashMap, "lv1_location");
        m14801a(getParams(), hashMap, "lv1_recid");
        m14801a(getParams(), hashMap, "lv1_body");
        m14801a(getParams(), hashMap, "lv1_filter");
        m14801a(getParams(), hashMap, "lv1_parameter");
        return hashMap;
    }

    /* renamed from: f */
    private Map<String, String> m14806f() {
        HashMap hashMap = new HashMap();
        m14801a(getParams(), hashMap, "lv2_location");
        m14801a(getParams(), hashMap, "lv2_recid");
        m14801a(getParams(), hashMap, "lv2_body");
        return hashMap;
    }

    /* renamed from: g */
    private Map<String, String> m14807g() {
        HashMap hashMap = new HashMap();
        m14801a(getParams(), hashMap, "lv3_location");
        m14801a(getParams(), hashMap, "lv3_recid");
        m14801a(getParams(), hashMap, "lv3_body");
        return hashMap;
    }

    /* renamed from: h */
    private Map<String, String> m14808h() {
        HashMap hashMap = new HashMap();
        m14801a(getParams(), hashMap, "lv4_body");
        return hashMap;
    }

    /* renamed from: a */
    private void m14801a(Map<String, String> map, Map<String, String> map2, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            map2.put(str, str2);
        } else {
            map2.put(str, "");
        }
    }
}

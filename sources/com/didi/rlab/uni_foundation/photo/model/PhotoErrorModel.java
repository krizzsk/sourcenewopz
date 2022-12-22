package com.didi.rlab.uni_foundation.photo.model;

import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class PhotoErrorModel extends UniModel {

    /* renamed from: a */
    private long f34158a;

    /* renamed from: b */
    private String f34159b;

    /* renamed from: c */
    private String f34160c;

    /* renamed from: d */
    private String f34161d;

    /* renamed from: e */
    private String f34162e;

    /* renamed from: f */
    private long f34163f;

    /* renamed from: g */
    private long f34164g;

    /* renamed from: h */
    private double f34165h;

    public long getErrorCode() {
        return this.f34158a;
    }

    public void setErrorCode(long j) {
        this.f34158a = j;
    }

    public String getPath() {
        return this.f34159b;
    }

    public void setPath(String str) {
        this.f34159b = str;
    }

    public String getErrorMsg() {
        return this.f34160c;
    }

    public void setErrorMsg(String str) {
        this.f34160c = str;
    }

    public String getType() {
        return this.f34161d;
    }

    public void setType(String str) {
        this.f34161d = str;
    }

    public String getExt() {
        return this.f34162e;
    }

    public void setExt(String str) {
        this.f34162e = str;
    }

    public long getImageWidth() {
        return this.f34163f;
    }

    public void setImageWidth(long j) {
        this.f34163f = j;
    }

    public long getImageHeight() {
        return this.f34164g;
    }

    public void setImageHeight(long j) {
        this.f34164g = j;
    }

    public double getQuality() {
        return this.f34165h;
    }

    public void setQuality(double d) {
        this.f34165h = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.ERROR_CODE, Long.valueOf(this.f34158a));
        hashMap.put("path", this.f34159b);
        hashMap.put("errorMsg", this.f34160c);
        hashMap.put("type", this.f34161d);
        hashMap.put("ext", this.f34162e);
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH, Long.valueOf(this.f34163f));
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT, Long.valueOf(this.f34164g));
        hashMap.put(CollectionConstant.APOLLO_PARAM_QUALITY, Double.valueOf(this.f34165h));
        return hashMap;
    }

    public static PhotoErrorModel fromMap(Map<String, Object> map) {
        PhotoErrorModel photoErrorModel = new PhotoErrorModel();
        long j = 0;
        photoErrorModel.f34158a = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? 0 : ((Number) map.get(Constants.ERROR_CODE)).longValue();
        String str = "";
        photoErrorModel.f34159b = (!map.containsKey("path") || map.get("path") == null) ? str : (String) map.get("path");
        photoErrorModel.f34160c = (!map.containsKey("errorMsg") || map.get("errorMsg") == null) ? str : (String) map.get("errorMsg");
        photoErrorModel.f34161d = (!map.containsKey("type") || map.get("type") == null) ? str : (String) map.get("type");
        if (map.containsKey("ext") && map.get("ext") != null) {
            str = (String) map.get("ext");
        }
        photoErrorModel.f34162e = str;
        photoErrorModel.f34163f = (!map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) || map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) == null) ? 0 : ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH)).longValue();
        if (map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) && map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) != null) {
            j = ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT)).longValue();
        }
        photoErrorModel.f34164g = j;
        photoErrorModel.f34165h = (!map.containsKey(CollectionConstant.APOLLO_PARAM_QUALITY) || map.get(CollectionConstant.APOLLO_PARAM_QUALITY) == null) ? 0.0d : ((Double) map.get(CollectionConstant.APOLLO_PARAM_QUALITY)).doubleValue();
        return photoErrorModel;
    }
}

package com.didi.rlab.uni_foundation.photo.model;

import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Map;

public class PhotoModel extends UniModel {

    /* renamed from: a */
    private String f34166a;

    /* renamed from: b */
    private String f34167b;

    /* renamed from: c */
    private long f34168c;

    /* renamed from: d */
    private long f34169d;

    /* renamed from: e */
    private double f34170e;

    public String getType() {
        return this.f34166a;
    }

    public void setType(String str) {
        this.f34166a = str;
    }

    public String getExt() {
        return this.f34167b;
    }

    public void setExt(String str) {
        this.f34167b = str;
    }

    public long getImageWidth() {
        return this.f34168c;
    }

    public void setImageWidth(long j) {
        this.f34168c = j;
    }

    public long getImageHeight() {
        return this.f34169d;
    }

    public void setImageHeight(long j) {
        this.f34169d = j;
    }

    public double getQuality() {
        return this.f34170e;
    }

    public void setQuality(double d) {
        this.f34170e = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.f34166a);
        hashMap.put("ext", this.f34167b);
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH, Long.valueOf(this.f34168c));
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT, Long.valueOf(this.f34169d));
        hashMap.put(CollectionConstant.APOLLO_PARAM_QUALITY, Double.valueOf(this.f34170e));
        return hashMap;
    }

    public static PhotoModel fromMap(Map<String, Object> map) {
        PhotoModel photoModel = new PhotoModel();
        String str = "";
        photoModel.f34166a = (!map.containsKey("type") || map.get("type") == null) ? str : (String) map.get("type");
        if (map.containsKey("ext") && map.get("ext") != null) {
            str = (String) map.get("ext");
        }
        photoModel.f34167b = str;
        long j = 0;
        photoModel.f34168c = (!map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) || map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) == null) ? 0 : ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH)).longValue();
        if (map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) && map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) != null) {
            j = ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT)).longValue();
        }
        photoModel.f34169d = j;
        photoModel.f34170e = (!map.containsKey(CollectionConstant.APOLLO_PARAM_QUALITY) || map.get(CollectionConstant.APOLLO_PARAM_QUALITY) == null) ? 0.0d : ((Double) map.get(CollectionConstant.APOLLO_PARAM_QUALITY)).doubleValue();
        return photoModel;
    }
}

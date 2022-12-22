package com.didi.component.evaluate.model;

import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didiglobal.travel.util.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EvaluateModel implements Serializable {
    private List<EvaluateTag> evaluateTagList;
    private String mDriverIconUrl;
    private String mDriverName;
    private int mLevel = 0;
    private String mMainTagTitle;
    private EvaluateMode mMode;
    private int mProductId;
    private String mSubTagTitlte;
    private String mTitle;
    private String oid;

    public EvaluateModel(String str, int i, EvaluateMode evaluateMode, String str2, String str3, String str4, int i2) {
        this.oid = str;
        this.mLevel = i;
        this.mMode = evaluateMode;
        this.mDriverIconUrl = str2;
        this.mDriverName = str3;
        this.mTitle = str4;
        this.mProductId = i2;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getMainTagTitle() {
        return this.mMainTagTitle;
    }

    public void setMainTagTitle(String str) {
        this.mMainTagTitle = str;
    }

    public String getSubTagTitlte() {
        return this.mSubTagTitlte;
    }

    public void setSubTagTitlte(String str) {
        this.mSubTagTitlte = str;
    }

    public EvaluateMode getMode() {
        return this.mMode;
    }

    public String getOid() {
        return this.oid;
    }

    public String getDriverIconUrl() {
        return this.mDriverIconUrl;
    }

    public String getDriverName() {
        return this.mDriverName;
    }

    public void setDriverIconUrl(String str) {
        this.mDriverIconUrl = str;
    }

    public void setDriverName(String str) {
        this.mDriverName = str;
    }

    public List<EvaluateTag> getEvaluateTagList() {
        return this.evaluateTagList;
    }

    public void processTags(List list, boolean z) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            if (!z) {
                processTagsWithNoEvaluate(list);
            } else {
                processTagsWithAlreadyEvaluated(list);
            }
        }
    }

    private void processTagsWithNoEvaluate(List<CarNoEvaluateData.CarEvaluateTag> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            for (CarNoEvaluateData.CarEvaluateTag next : list) {
                if (next.level == this.mLevel) {
                    this.evaluateTagList = new ArrayList();
                    if (!CollectionUtils.isEmpty((Collection<?>) next.tag_list)) {
                        for (CarNoEvaluateData.EvaluateTagImpl next2 : next.tag_list) {
                            this.evaluateTagList.add(new EvaluateTag(next2.getText(), next2.getId(), next2.getIcon()));
                        }
                    }
                    this.mMainTagTitle = next.level_description;
                    this.mSubTagTitlte = next.tag_guide;
                    return;
                }
            }
        }
    }

    private void processTagsWithAlreadyEvaluated(List<CarNoEvaluateData.EvaluateTagImpl> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            this.evaluateTagList = new ArrayList();
            for (CarNoEvaluateData.EvaluateTagImpl next : list) {
                this.evaluateTagList.add(new EvaluateTag(next.getText(), next.getId(), next.getIcon()));
            }
        }
    }

    public int getProductId() {
        return this.mProductId;
    }

    public void setProductId(int i) {
        this.mProductId = i;
    }
}

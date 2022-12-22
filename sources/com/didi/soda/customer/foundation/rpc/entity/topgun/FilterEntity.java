package com.didi.soda.customer.foundation.rpc.entity.topgun;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamCompat;
import com.didi.soda.home.topgun.model.FilterModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterEntity implements IEntity {
    private static final long serialVersionUID = -2614698654175449946L;
    public List<FilterComponentEntity> filterComponent;
    public String headLine;
    public String img;
    public String resourceId;
    public int selectedCount;
    public String selectedImg;
    public int showConfirmBtn;
    public int showType;
    public String title;

    public static List<FilterModel> convert(List<FilterEntity> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            FilterEntity filterEntity = list.get(i2);
            FilterModel filterModel = new FilterModel();
            filterModel.mNativeId = i2;
            filterModel.mShowType = filterEntity.showType;
            filterModel.mImage = filterEntity.img;
            filterModel.mNeedShowNum = filterEntity.selectedCount;
            filterModel.showConfirmBtn = filterEntity.showConfirmBtn;
            filterModel.mSelectedImage = filterEntity.selectedImg;
            filterModel.setHeaderLine(filterEntity.headLine, false);
            filterModel.mDefaultHeadLine = filterEntity.headLine;
            filterModel.mPageTitle = filterEntity.title;
            filterModel.mResourceId = filterEntity.resourceId;
            filterModel.mFilterComponent = FilterComponentEntity.convert(filterEntity.filterComponent);
            filterModel.fromSence = i;
            if (filterModel.mFilterComponent.size() > 0 || filterModel.mShowType == 6) {
                arrayList.add(filterModel);
            }
        }
        return arrayList;
    }

    public static Object toMapParam(String str) {
        try {
            return ParamCompat.fromJson(str, new TypeToken<List<Map<String, Object>>>() {
            }.getType());
        } catch (Exception unused) {
            return str;
        }
    }

    public static JsonElement toJsonElement(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JsonParser().parse(str);
        } catch (Exception unused) {
            return null;
        }
    }
}

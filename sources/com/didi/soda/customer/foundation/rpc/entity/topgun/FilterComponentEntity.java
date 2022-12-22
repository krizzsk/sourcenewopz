package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.home.topgun.model.FilterModel;
import java.util.ArrayList;
import java.util.List;

public class FilterComponentEntity implements IEntity {
    private static final long serialVersionUID = -8619139857036510741L;
    public int colNum;
    public List<ItemsEntity> items;
    public int notSupportInvertChoice;
    public String title;
    public int type;

    public static class ItemsEntity implements IEntity {
        private static final long serialVersionUID = 3861479233703921376L;
        public String activityId;
        public String icon;

        /* renamed from: id */
        public String f41050id;
        public String img;
        public int isCanChoice;
        public int isDefault;
        public int isMultipleChoice;
        public int isSelected;
        public String name;
        public String selectedImg;
        public String shortName;
        public String sourceType;
    }

    public static List<FilterModel.FilterComponentModel> convert(List<FilterComponentEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (FilterComponentEntity next : list) {
            FilterModel.FilterComponentModel filterComponentModel = new FilterModel.FilterComponentModel();
            filterComponentModel.mType = next.type;
            filterComponentModel.mTitle = next.title;
            filterComponentModel.mColNum = next.colNum;
            filterComponentModel.mNotAllowEmpty = next.notSupportInvertChoice == 1;
            ArrayList arrayList2 = new ArrayList();
            List<ItemsEntity> list2 = next.items;
            if (list2 != null) {
                for (ItemsEntity next2 : list2) {
                    FilterModel.FilterItemRvModel filterItemRvModel = new FilterModel.FilterItemRvModel();
                    filterItemRvModel.mName = next2.name;
                    filterItemRvModel.mShortName = next2.shortName;
                    filterItemRvModel.mIcon = next2.icon;
                    filterItemRvModel.mId = next2.f41050id;
                    filterItemRvModel.mImg = next2.img;
                    filterItemRvModel.mSourceType = next2.sourceType;
                    filterItemRvModel.mActivityId = next2.activityId;
                    filterItemRvModel.mIsCanChoice = next2.isCanChoice == 1;
                    filterItemRvModel.mIsSelected = next2.isSelected == 1;
                    filterItemRvModel.mIsDefault = next2.isDefault == 1;
                    filterItemRvModel.mIsMultipleChoice = next2.isMultipleChoice == 1;
                    filterItemRvModel.mSelectedImg = next2.selectedImg;
                    arrayList2.add(filterItemRvModel);
                }
            }
            filterComponentModel.mItems = arrayList2;
            arrayList.add(filterComponentModel);
        }
        return arrayList;
    }
}

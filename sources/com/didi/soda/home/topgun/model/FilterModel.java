package com.didi.soda.home.topgun.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class FilterModel {

    /* renamed from: a */
    private String f43011a;

    /* renamed from: b */
    private String f43012b;
    public int fromSence = 1;
    public String mDefaultHeadLine;
    public List<FilterComponentModel> mFilterComponent;
    public boolean mHeadLineLight;
    public String mImage;
    public int mNativeId;
    public int mNeedShowNum;
    public String mPageTitle;
    public String mResourceId;
    public String mSelectedImage;
    public int mShowType;
    public String mTimePeriod = null;
    public int mTopicFromScence = -1;
    public int position;
    public int showConfirmBtn;

    public void setHeaderLine(String str, boolean z) {
        if (z) {
            this.f43012b = this.f43011a;
        } else {
            this.f43012b = null;
        }
        this.f43011a = str;
    }

    public String getCurrentHeaderLine() {
        return this.f43011a;
    }

    public void syncPreHeaderLine() {
        this.f43012b = this.f43011a;
    }

    public String getPreHeadLine() {
        return this.f43012b;
    }

    public static class FilterComponentModel {
        public int mColNum;
        public List<FilterItemRvModel> mItems;
        public boolean mNotAllowEmpty;
        public String mTitle;
        public int mType;

        public FilterItemRvModel getSelectedItem() {
            List<FilterItemRvModel> list = this.mItems;
            if (list == null) {
                return null;
            }
            for (FilterItemRvModel next : list) {
                if (next.mIsSelected) {
                    return next;
                }
            }
            return null;
        }

        public String mergeMultiHeadLine() {
            StringBuilder sb = new StringBuilder();
            List<FilterItemRvModel> list = this.mItems;
            if (list != null) {
                for (FilterItemRvModel next : list) {
                    if (next.mIsSelected) {
                        String showName = next.getShowName();
                        if (!StringUtils.isEmpty(showName) && sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(showName);
                    }
                }
            }
            return sb.toString();
        }

        public FilterComponentEntity convertEntity() {
            FilterComponentEntity filterComponentEntity = new FilterComponentEntity();
            filterComponentEntity.type = this.mType;
            filterComponentEntity.title = this.mTitle;
            filterComponentEntity.colNum = this.mColNum;
            if (this.mItems != null) {
                filterComponentEntity.items = new ArrayList();
                for (FilterItemRvModel next : this.mItems) {
                    if (next.mIsSelected) {
                        filterComponentEntity.items.add(next.convertEntity());
                    }
                }
            }
            return filterComponentEntity;
        }
    }

    public static class FilterItemRvModel implements RecyclerModel {
        public String mActivityId;
        public String mIcon;
        public String mId;
        public String mImg;
        public boolean mIsBind = false;
        public boolean mIsCanChoice;
        public boolean mIsDefault;
        public boolean mIsMultipleChoice;
        public boolean mIsSelected;
        public String mName;
        public String mSelectedImg;
        public String mShortName;
        public String mSourceType;

        public FilterComponentEntity.ItemsEntity convertEntity() {
            FilterComponentEntity.ItemsEntity itemsEntity = new FilterComponentEntity.ItemsEntity();
            itemsEntity.isDefault = this.mIsDefault ? 1 : 0;
            itemsEntity.isSelected = this.mIsSelected ? 1 : 0;
            itemsEntity.img = this.mImg;
            itemsEntity.isCanChoice = this.mIsCanChoice ? 1 : 0;
            itemsEntity.isMultipleChoice = this.mIsMultipleChoice ? 1 : 0;
            itemsEntity.name = this.mName;
            itemsEntity.icon = this.mIcon;
            itemsEntity.shortName = this.mShortName;
            itemsEntity.f41050id = this.mId;
            itemsEntity.sourceType = this.mSourceType;
            itemsEntity.activityId = this.mActivityId;
            itemsEntity.selectedImg = this.mSelectedImg;
            return itemsEntity;
        }

        public String getShowName() {
            if (!StringUtils.isEmpty(this.mShortName)) {
                return this.mShortName;
            }
            return this.mName;
        }
    }

    public boolean checkFilterComponentSize() {
        List<FilterComponentModel> list = this.mFilterComponent;
        return list != null && list.size() > 0;
    }

    public boolean isOriginal() {
        if (!checkFilterComponentSize()) {
            return true;
        }
        for (FilterComponentModel next : this.mFilterComponent) {
            if (next.mItems != null) {
                for (FilterItemRvModel next2 : next.mItems) {
                    if (next2.mIsDefault != next2.mIsSelected) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    public void reset() {
        if (checkFilterComponentSize()) {
            for (FilterComponentModel next : this.mFilterComponent) {
                if (next.mItems != null) {
                    for (FilterItemRvModel next2 : next.mItems) {
                        next2.mIsSelected = next2.mIsDefault;
                    }
                }
            }
        }
    }

    public int getSelectedNumber() {
        int i = 0;
        if (checkFilterComponentSize()) {
            for (FilterComponentModel next : this.mFilterComponent) {
                if (next.mItems != null) {
                    for (FilterItemRvModel filterItemRvModel : next.mItems) {
                        if (filterItemRvModel.mIsSelected) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public FilterEntity copySelected() {
        FilterEntity filterEntity = new FilterEntity();
        filterEntity.headLine = this.f43011a;
        filterEntity.showType = this.mShowType;
        filterEntity.filterComponent = new ArrayList();
        if (checkFilterComponentSize()) {
            for (FilterComponentModel convertEntity : this.mFilterComponent) {
                filterEntity.filterComponent.add(convertEntity.convertEntity());
            }
        }
        return filterEntity;
    }

    public String getTrackTitle() {
        int i = this.mShowType;
        if (i == 5 || i == 7) {
            return getOutFilterId();
        }
        return this.mPageTitle;
    }

    public String getOutFilterId() {
        List<FilterComponentModel> list = this.mFilterComponent;
        if (list != null && list.size() > 0) {
            FilterComponentModel filterComponentModel = this.mFilterComponent.get(0);
            if (filterComponentModel.mItems != null && filterComponentModel.mItems.size() > 0) {
                return filterComponentModel.mItems.get(0).mId;
            }
        }
        return "";
    }

    public String getResourceId(int i) {
        List<FilterComponentModel> list = this.mFilterComponent;
        if (list != null && list.size() > 0) {
            FilterComponentModel filterComponentModel = this.mFilterComponent.get(0);
            if (filterComponentModel.mItems != null && filterComponentModel.mItems.size() > 0) {
                return filterComponentModel.mItems.get(0).mId;
            }
        }
        return "";
    }
}

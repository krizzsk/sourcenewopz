package com.didi.soda.customer.foundation.rpc.entity;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.util.ObjectUtil;
import java.util.List;

public class TabEntity implements IEntity {
    private static final long serialVersionUID = 2352749944976329673L;
    public String recId;
    public List<TabItem> tabList;

    public static class DefaultTabItem extends TabItem {
        public int icon;
        public boolean isLazyLoad = true;
        public int selectIcon;
    }

    public static class TabItem implements IEntity {
        private static final long serialVersionUID = -480244390871248490L;
        public String activityCate;
        public String activityId;
        public String content;
        public String img;
        public String resourceId;
        public String selectedImg;
        public String selectedTextColor;
        public TagEntity tag;
        public String textColor;
        public String url;

        public boolean deepEqual(TabItem tabItem) {
            return TextUtils.equals(this.content, tabItem.content) && TextUtils.equals(this.textColor, tabItem.textColor) && TextUtils.equals(this.selectedTextColor, tabItem.selectedTextColor) && TextUtils.equals(this.url, tabItem.url) && TextUtils.equals(this.img, tabItem.img) && TextUtils.equals(this.selectedImg, tabItem.selectedImg) && TextUtils.equals(this.activityId, tabItem.activityId) && TextUtils.equals(this.activityCate, tabItem.activityCate) && TextUtils.equals(this.resourceId, tabItem.resourceId) && ObjectUtil.isObjectEquals(this.tag, tabItem.tag);
        }
    }
}

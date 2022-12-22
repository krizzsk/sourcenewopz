package com.didi.sdk.home.model;

import android.text.TextUtils;
import com.didi.sdk.misconfig.model.CarGrop;
import java.util.ArrayList;
import java.util.List;

public class TopBarData {
    public List<TopCarGroupWrapper> dataList = new ArrayList();
    public CarGrop selectedGroup;

    public TopBarData(List<CarGrop> list, String str) {
        List<TopCarGroupWrapper> list2;
        if (list != null && list.size() != 0) {
            TopCarGroupWrapper topCarGroupWrapper = null;
            boolean z = false;
            for (CarGrop next : list) {
                if (next != null) {
                    TopCarGroupWrapper topCarGroupWrapper2 = new TopCarGroupWrapper(next);
                    if (!TextUtils.isEmpty(next.getGroupType()) && next.getGroupType().equals(str) && (TextUtils.isEmpty(next.getSchema()) || next.getSchema().contains("entrance"))) {
                        topCarGroupWrapper2.isSelected = true;
                        this.selectedGroup = next;
                        z = true;
                    }
                    topCarGroupWrapper = "ride".equals(next.getGroupType()) ? topCarGroupWrapper2 : topCarGroupWrapper;
                    this.dataList.add(topCarGroupWrapper2);
                }
            }
            if (!z && topCarGroupWrapper != null) {
                topCarGroupWrapper.isSelected = true;
                this.selectedGroup = topCarGroupWrapper.carGrop;
            }
            if (this.selectedGroup == null && (list2 = this.dataList) != null && list2.size() > 0) {
                TopCarGroupWrapper topCarGroupWrapper3 = this.dataList.get(0);
                topCarGroupWrapper3.isSelected = true;
                this.selectedGroup = topCarGroupWrapper3.carGrop;
            }
        }
    }

    public boolean isShowTopBar() {
        List<TopCarGroupWrapper> list = this.dataList;
        return (list == null || list.size() < 2 || this.selectedGroup == null) ? false : true;
    }

    public int covertTypeToGroupId(String str) {
        List<TopCarGroupWrapper> list;
        if (!(TextUtils.isEmpty(str) || (list = this.dataList) == null || list.size() == 0)) {
            for (TopCarGroupWrapper next : this.dataList) {
                if (next != null && next.carGrop != null && str.equals(next.carGrop.getGroupType())) {
                    return next.carGrop.getGroupId();
                }
            }
        }
        return 0;
    }

    public boolean containsType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("ride".equals(str)) {
            return true;
        }
        for (TopCarGroupWrapper next : this.dataList) {
            if (next.carGrop != null && str.equals(next.carGrop.getGroupType())) {
                return true;
            }
        }
        return false;
    }

    public String getGroupIdArrayString() {
        List<TopCarGroupWrapper> list = this.dataList;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.dataList.size(); i++) {
            TopCarGroupWrapper topCarGroupWrapper = this.dataList.get(i);
            if (!(topCarGroupWrapper == null || topCarGroupWrapper.carGrop == null)) {
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(topCarGroupWrapper.carGrop.getGroupId());
                } else {
                    sb.append(',');
                    sb.append(topCarGroupWrapper.carGrop.getGroupId());
                }
            }
        }
        return sb.toString();
    }

    public String getGroupTypeArrayString() {
        List<TopCarGroupWrapper> list = this.dataList;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.dataList.size(); i++) {
            TopCarGroupWrapper topCarGroupWrapper = this.dataList.get(i);
            if (!(topCarGroupWrapper == null || topCarGroupWrapper.carGrop == null)) {
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(topCarGroupWrapper.carGrop.getGroupType());
                } else {
                    sb.append(',');
                    sb.append(topCarGroupWrapper.carGrop.getGroupType());
                }
            }
        }
        return sb.toString();
    }

    public void setSelectedGroup(String str) {
        List<TopCarGroupWrapper> list;
        if (str != null && (list = this.dataList) != null && list.size() > 0) {
            for (TopCarGroupWrapper next : this.dataList) {
                if (next.carGrop != null && str.equals(next.carGrop.getGroupType())) {
                    next.isSelected = true;
                    this.selectedGroup = next.carGrop;
                    return;
                }
            }
        }
    }
}

package com.didi.universal.pay.biz.model;

import com.didi.universal.pay.biz.manager.UniversalPayChannelManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UniversalViewModel implements Serializable {
    public static final int COST_QUESTION_TYPE = 1;
    private static final String KEY_PREPAY_MAIN_TITLE = "ex_prepay_title_text";
    private static final String KEY_PREPAY_SUBTITLE = "ex_prepay_subtitle_text";
    public Map extra;
    public AboveFeeItem mAboveFeeMessage;
    public AboveFeeItem mBelowFeeMessage;
    public List<JumpItem> mJumplistModel;
    public PayModel mPayModel;
    public CharSequence mShowPayFee;
    public List<TotalFeeItem> mTotalFeeList;
    public List<UniversalPayItemModel> paychannelsModel;
    public String subTitle;
    public String title;

    public class TotalFeeItem {
        public static final int STATUS_GRAY = 3;
        public static final int STATUS_HIGHT = 2;
        public static final int STATUS_NORMAL = 1;
        public long deductionCost;
        public String deductionId;
        public int deductionStatus;
        public int deductionType;
        public String deductionURL;
        public String name;
        public String nameDesc;
        public int status;
        public String value;
        public String valueDesc;

        public TotalFeeItem() {
            this.status = 1;
        }

        public TotalFeeItem(UniversalViewModel universalViewModel, String str, String str2) {
            this(str, str2, 1);
        }

        public TotalFeeItem(String str, String str2, int i) {
            this.status = 1;
            this.name = str;
            this.value = str2;
            this.status = i;
        }
    }

    public class AboveFeeItem {
        public static final int STATUS_HIGHT = 2;
        public static final int STATUS_NORMAL = 1;
        public String name;
        public int status;
        public String url;

        public AboveFeeItem(UniversalViewModel universalViewModel, String str) {
            this(str, 2);
        }

        public AboveFeeItem(String str, int i) {
            this.status = 2;
            this.name = str;
            this.status = i;
        }
    }

    public class PayModel {
        public static final int STATUS_LOADING = 3;
        public static final int STATUS_NORMAL = 1;
        public static final int STATUS_UNABLE = 2;
        public int status;
        public String text;

        public PayModel() {
        }
    }

    public class JumpItem {
        public int leftRes;
        public String name;
        public boolean showArrow;
        public int type = -1;
        public String url;

        public JumpItem() {
        }
    }

    public static List<UniversalPayItemModel> getPlatformpayList(List<UniversalPayItemModel> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (UniversalPayItemModel next : list) {
                if (UniversalPayChannelManager.isPlatformPayChannel(next.f45101id)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static List<UniversalPayItemModel> getOutsidepayList(List<UniversalPayItemModel> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (UniversalPayItemModel next : list) {
                if (UniversalPayChannelManager.isThirdPayChannel(next.f45101id)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}

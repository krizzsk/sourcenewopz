package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.blocks.entity.Template;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ActivityInfoEntity implements IEntity {
    private static final long serialVersionUID = 259412056522748899L;
    public AlertBean alert;
    public AutoRefreshBean autoRefresh;
    public BgColorBean bgColor;
    public ExceptionBean exception;
    @SerializedName("compList")
    public List<ComponentEntity> mCompList;
    @SerializedName("hasMore")
    public boolean mHasMore;
    @SerializedName("templates")
    public ArrayList<Template> mTemplates;
    public NaviStructBean navi;
    public String recId;
    public ArrayList<String> sessionIdList;
    public String tabId;

    public static class AlertBean implements IEntity {
        private static final long serialVersionUID = -8424461705073431998L;
        public int action;
        public String content;
        public int type;
    }

    public static class AutoRefreshBean implements IEntity {
        private static final long serialVersionUID = -5644682677778927972L;
        public AlertBean alert;
        public int autoRefreshAction;
        public long refreshTs;
        public long remainingSec;
    }

    public static class BgColorBean implements IEntity {
        private static final long serialVersionUID = -4737083996105463491L;
        public int angle;
        public List<String> color;
    }

    public static class ButtonBean implements IEntity {
        private static final long serialVersionUID = 9126911237611260677L;
        public String btnColor;
        public String title;
    }

    public static class CountDownInfo implements IEntity {
        private static final long serialVersionUID = 497943484673264077L;
        public CountDownEntity countDown;
    }

    public static class ExceptionBean implements IEntity {
        private static final long serialVersionUID = 9126911237611260677L;
        public int actStatus;
        public String bgColor;
        public ButtonBean btn;
        public String desc;
        public String detail;
        public String pic;
    }

    public static class HeaderInfo implements IEntity {
        private static final long serialVersionUID = -6239355887220541390L;
        public String ambientImg;
        public CountDownEntity countDown;
        public String img;
        public String platLogo;
        public RuleLink ruleLink;
        public String subTitle;
        public TabInfoEntity tab;
        public List<TabInfoEntity> tabs;
        public String title;
    }

    public static class NaviStructBean implements IEntity {
        private static final long serialVersionUID = 9111750684869555400L;
        public List<ComposeActionEntity> interactions;
        public String title;
    }

    public static class RuleLink implements IEntity {
        private static final long serialVersionUID = 4973049081370410849L;
        public String content;
        public String details;
        public String icon;
        public String title;
        public String url;
    }
}

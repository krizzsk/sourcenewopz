package com.didiglobal.p205sa.biz.util;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/util/BaseEventKeys;", "", "()V", "MSG_CARD", "SAHome", "SA_Panel", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.util.BaseEventKeys */
/* compiled from: BaseEventKeys.kt */
public final class BaseEventKeys {

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/util/BaseEventKeys$SAHome;", "", "()V", "EVENT_HOME_UPDATE", "", "EVENT_RESET_MAP", "EVENT_SHOW_SUG_PAGE", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.util.BaseEventKeys$SAHome */
    /* compiled from: BaseEventKeys.kt */
    public static final class SAHome {
        public static final String EVENT_HOME_UPDATE = "event_home_update";
        public static final String EVENT_RESET_MAP = "event_map_reset_map";
        public static final String EVENT_SHOW_SUG_PAGE = "event_show_new_sug_page";
        public static final SAHome INSTANCE = new SAHome();

        private SAHome() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/util/BaseEventKeys$MSG_CARD;", "", "()V", "EVENT_OPEN_SYS_LOCATION_SETTING", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.util.BaseEventKeys$MSG_CARD */
    /* compiled from: BaseEventKeys.kt */
    public static final class MSG_CARD {
        public static final String EVENT_OPEN_SYS_LOCATION_SETTING = "open_sys_location_setting";
        public static final MSG_CARD INSTANCE = new MSG_CARD();

        private MSG_CARD() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/util/BaseEventKeys$SA_Panel;", "", "()V", "EVENT_HOME_PANEL_SCROLL_TOP", "", "PANEL_EXPAND", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didiglobal.sa.biz.util.BaseEventKeys$SA_Panel */
    /* compiled from: BaseEventKeys.kt */
    public static final class SA_Panel {
        public static final String EVENT_HOME_PANEL_SCROLL_TOP = "event_home_panel_scroll_top";
        public static final SA_Panel INSTANCE = new SA_Panel();
        public static final String PANEL_EXPAND = "event_panel_expand_to_ride";

        private SA_Panel() {
        }
    }
}

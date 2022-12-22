package com.didi.sdk.component.search.city.p148db;

import android.net.Uri;
import com.didi.sdk.p150db.DIDIContentProvider;

/* renamed from: com.didi.sdk.component.search.city.db.DIDIDbTables */
public class DIDIDbTables {
    public static final String BASE_URI = ("content://" + DIDIContentProvider.AUTHORITY);

    /* renamed from: com.didi.sdk.component.search.city.db.DIDIDbTables$BaseSideBarNewColumn */
    public interface BaseSideBarNewColumn {
        public static final String COMPONENT_ID = "component_id";
        public static final String END_TIME = "endTime";
        public static final String ICON = "icon_url";

        /* renamed from: ID */
        public static final String f35659ID = "id";
        public static final String IS_CLICKED = "is_clicked";
        public static final String LEVEL = "level";
        public static final String PAGE = "page";
        public static final String START_TIME = "startTime";
    }

    /* renamed from: com.didi.sdk.component.search.city.db.DIDIDbTables$SideBarFireTorchColumn */
    public interface SideBarFireTorchColumn extends BaseSideBarNewColumn {
        public static final Uri CONTENT_URI = Uri.parse(DIDIDbTables.BASE_URI + "/" + TABLE_NAME);
        public static final String TABLE_NAME = "side_bar_fire_torch";
    }

    /* renamed from: com.didi.sdk.component.search.city.db.DIDIDbTables$SideBarReddotColumn */
    public interface SideBarReddotColumn extends BaseSideBarNewColumn {
        public static final Uri CONTENT_URI = Uri.parse(DIDIDbTables.BASE_URI + "/" + TABLE_NAME);
        public static final String TABLE_NAME = "side_bar_red_dot";
    }
}

package com.didi.travel.psnger.p170v2;

import com.didi.travel.p171v2.session.SceneContainer;

/* renamed from: com.didi.travel.psnger.v2.ExpressSceneContainer */
public class ExpressSceneContainer extends SceneContainer {
    public static final int SCENE_CODE_ORDER_STATUS_TIMEOUT = 2001;
    public static final int SCENE_CODE_POLL_APP_BACK_GROUND = 1001;
    public static final int SCENE_CODE_POLL_APP_FRONT_GROUND = 1002;
    public static final int SCENE_CODE_POLL_CLOSE_APP_BACKGROUND_POLL = 1006;
    public static final int SCENE_CODE_POLL_INIT_FOREGROUND_SERVICE = 1101;
    public static final int SCENE_CODE_POLL_INIT_MAP_FLOW = 1105;
    public static final int SCENE_CODE_POLL_INIT_SERVICE = 1103;
    public static final int SCENE_CODE_POLL_IN_APP_PUSH_ORDER_STATUS = 1007;
    public static final int SCENE_CODE_POLL_OPEN_APP_BACKGROUND_POLL = 1005;
    public static final int SCENE_CODE_POLL_ORDER_STATUS_UPDATE_INTERVAL = 1004;
    public static final int SCENE_CODE_POLL_OUT_APP_PUSH_ORDER_STATUS = 1008;
    public static final int SCENE_CODE_POLL_OVER_MAX_TIME = 1003;
    public static final int SCENE_CODE_POLL_TOKEN_EMPTY = 1002;
    public static final int SCENE_CODE_POLL_UPDATE_FOREGROUND_SERVICE = 1102;
    public static final int SCENE_CODE_POLL_UPDATE_MAP_FLOW = 1106;
    public static final int SCENE_CODE_POLL_UPDATE_SERVICE = 1104;
    public static final String SCENE_DESC_ORDER_STATUS_TIMEOUT = "";
    public static final String SCENE_DESC_POLL_APP_BACK_GROUND = "";
    public static final String SCENE_DESC_POLL_APP_FRONT_GROUND = "";
    public static final String SCENE_DESC_POLL_CLOSE_APP_BACKGROUND_POLL = "";
    public static final String SCENE_DESC_POLL_INIT_FOREGROUND_SERVICE = "poll_init_foreground_service";
    public static final String SCENE_DESC_POLL_INIT_MAP_FLOW = "poll_init_map_flow";
    public static final String SCENE_DESC_POLL_INIT_SERVICE = "poll_init_service";
    public static final String SCENE_DESC_POLL_IN_APP_PUSH_ORDER_STATUS = "";
    public static final String SCENE_DESC_POLL_OPEN_APP_BACKGROUND_POLL = "";
    public static final String SCENE_DESC_POLL_ORDER_STATUS_UPDATE_INTERVAL = "poll_order_status_update_interval";
    public static final String SCENE_DESC_POLL_OUT_APP_PUSH_ORDER_STATUS = "";
    public static final String SCENE_DESC_POLL_OVER_MAX_TIME = "";
    public static final String SCENE_DESC_POLL_TOKEN_EMPTY = "poll_token_empty";
    public static final String SCENE_DESC_POLL_UPDATE_FOREGROUND_SERVICE = "poll_update_foreground_service";
    public static final String SCENE_DESC_POLL_UPDATE_MAP_FLOW = "poll_update_service";
    public static final String SCENE_DESC_POLL_UPDATE_SERVICE = "poll_update_service";

    /* renamed from: a */
    private static final ExpressSceneContainer f44243a = new ExpressSceneContainer();

    protected ExpressSceneContainer() {
    }

    public static ExpressSceneContainer getInstance() {
        return f44243a;
    }

    public void init() {
        super.init();
        register(1001, "");
        register(1002, SCENE_DESC_POLL_TOKEN_EMPTY);
        register(1003, "");
        register(1004, SCENE_DESC_POLL_ORDER_STATUS_UPDATE_INTERVAL);
        register(1005, "");
        register(1006, "");
        register(1007, "");
        register(1008, "");
        register(1101, SCENE_DESC_POLL_INIT_FOREGROUND_SERVICE);
        register(1102, SCENE_DESC_POLL_UPDATE_FOREGROUND_SERVICE);
        register(1105, SCENE_DESC_POLL_INIT_MAP_FLOW);
        register(1106, "poll_update_service");
        register(1103, SCENE_DESC_POLL_INIT_SERVICE);
        register(1104, "poll_update_service");
        register(2001, "");
    }
}

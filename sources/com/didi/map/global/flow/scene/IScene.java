package com.didi.map.global.flow.scene;

import com.didi.map.global.flow.model.Bundle;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface IScene {

    public @interface SCENE_ID {
        public static final int SCENE_BUBBLE_PAGE = 1002;
        public static final int SCENE_CONFIRM_PAGE = 1003;
        public static final int SCENE_MAIN_PAGE = 1001;
        public static final int SCENE_MINI_BUS_APPOINT_PAGE = 3002;
        public static final int SCENE_MINI_BUS_CONFIRM_PAGE = 3001;
        public static final int SCENE_MINI_BUS_ORDER_OVER_PAGE = 3005;
        public static final int SCENE_MINI_BUS_PICK_PAGE = 3003;
        public static final int SCENE_MINI_BUS_SERVICE_PAGE = 3004;
        public static final int SCENE_ORDER_OVER_PAGE = 1010;
        public static final int SCENE_POP_SUG_PAGE = 1011;
        public static final int SCENE_SCTX_APPOINT_PAGE = 1008;
        public static final int SCENE_SCTX_LOCK_PAGE = 1009;
        public static final int SCENE_SCTX_PICK_PAGE = 1005;
        public static final int SCENE_SCTX_SEND_PAGE = 1007;
        public static final int SCENE_SCTX_WAITING_PAGE = 1006;
        public static final int SCENE_VAMOS_CONFIRM_GET_ON_PAGE = 2002;
        public static final int SCENE_VAMOS_CONFIRM_ORDER_PAGE = 2003;
        public static final int SCENE_VAMOS_DRIVER_CONFIRM_ORDER_PAGE = 2004;
        public static final int SCENE_VAMOS_DRIVER_ORDER_PREVIEW_PAGE = 2005;
        public static final int SCENE_VAMOS_DRIVER_ORDER_WAIT_PAGE = 2007;
        public static final int SCENE_VAMOS_HOME_PAGE = 2001;
        public static final int SCENE_VAMOS_PAX_ORDER_PREVIEW_PAGE = 2006;
        public static final int SCENE_VAMOS_PAX_ORDER_WAIT_PAGE = 2008;
        public static final int SCENE_VAMOS_SCTX_DRIVER_INSERVICE_PAGE = 2011;
        public static final int SCENE_VAMOS_SCTX_DRIVER_PICKUP_PAGE = 2009;
        public static final int SCENE_VAMOS_SCTX_DRIVER_WAIT_PAGE = 2010;
        public static final int SCENE_VAMOS_SCTX_PASSENGER_INSERVICE_PAGE = 2014;
        public static final int SCENE_VAMOS_SCTX_PASSENGER_PICKUP_PAGE = 2012;
        public static final int SCENE_VAMOS_SCTX_PASSENGER_WAIT_PAGE = 2013;
        public static final int SCENE_VAMOS_SUG_CONF_SCENE_DRIVER_PAGE = 2017;
        public static final int SCENE_VAMOS_SUG_CONF_SCENE_PASSENGER_PAGE = 2018;
        public static final int SCENE_VAMOS_SUG_HOME_SCENE_PAGE = 2015;
        public static final int SCENE_VAMOS_SUG_HOME_SCENE_PASSENGER_PAGE = 2016;
        public static final int SCENE_VAMOS_SUG_PAGE = 2111;
        public static final int SCENE_VAMOS_SUG_PICONF_SCENE_DRIVER_PAGE = 2019;
        public static final int SCENE_VAMOS_SUG_PICONF_SCENE_PASSENGER_PAGE = 2020;
        public static final int SCENE_VAMOS_SUG_SETTING_PAGE = 2021;
        public static final int SCENE_WAITING_REPLY_PAGE = 1004;
        public static final int UNKNOW = -1;
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        /* renamed from: id */
        int mo74615id();
    }

    void enter(Bundle bundle);

    void leave();

    void onPause();

    void onResume();

    Bundle transferParams();
}

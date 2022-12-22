package com.didi.hawaii.utils;

public final class CheckEvents {
    public static final String DAY_NIGHT_SWITCH = "日夜间切换";
    public static final String MAP_CONFIG_UPDATE = "底图配置更新";
    public static final String MAP_SURFACE_CHANGE = "map尺寸变化";
    public static final String MAP_TILE_REQUEST = "底图瓦片请求";
    public static final String MAP_TRAFFIC_ON = "底图路况开关打开";
    public static final String MAP_TRAFFIC_REQUEST = "底图路况请求";
    public static final String MAP_TRAFFIC_UPDATE = "底图路况更新";
    public static final String NAME_ARRIVE_DESTINATION = "导航引擎回调.到达终点";
    public static final String NAME_CAMERA_HIDE = "导航引擎回调.摄像头隐藏";
    public static final String NAME_CAMERA_SHOW = "导航引擎回调.摄像头显示";
    public static final String NAME_DRAW_LINE = "画线接口请求";
    public static final String NAME_ENLARGE_DOWNLOAD = "导航引擎回调.路口放大图下载";
    public static final String NAME_ENLARGE_HIDE = "导航引擎回调.路口放大图隐藏";
    public static final String NAME_ENLARGE_SHOW = "导航引擎回调.路口放大图显示";
    public static final String NAME_LANE_HIDE = "导航引擎回调.车道线隐藏";
    public static final String NAME_LANE_SHOW = "导航引擎回调.车道线显示";
    public static final String NAME_LIGHT_NAV_START = "导航引擎回调.进入轻导航";
    public static final String NAME_LIGHT_NAV_STOP = "导航引擎回调.退出轻导航";
    public static final String NAME_MULTIBUBBLE_SHOW = "出现多路线气泡";
    public static final String NAME_MULTI_CLICK = "多路线点击";
    public static final String NAME_MULTI_SHOW = "出现多路线";
    public static final String NAME_NAV_START = "开始导航";
    public static final String NAME_NAV_STOP = "停止导航";
    public static final String NAME_ON_WAYOUT = "导航引擎回调.触发偏航";
    public static final String NAME_PARALLEL_ROAD = "导航引擎回调.主辅路信息";
    public static final String NAME_TEXT_SPEECH = "SDK语音播报回调";
    public static final String NAV_ADD_LINE = "添加路线";
    public static final String NAV_AVIOD_BLOCK_ROUTE = "导航引擎回调，请求避堵路线";
    public static final String NAV_AVIOD_BLOCK_ROUTE_SUCCESS = "动态避堵操作是否成功";
    public static final String NAV_CALCULATE_SUCCESS = "算路是否成功";
    public static final String NAV_CALLBACK_SPEED_OFF = "导航引擎回调，隐藏速度图标";
    public static final String NAV_CALLBACK_SPEED_ON = "导航引擎回调，显示速度图标";
    public static final String NAV_CALLBACK_UPLOAD_TRAFFIC = "导航引擎回调，上报按钮";
    public static final String NAV_EDA = "导航引擎回调，更新EDA";
    public static final String NAV_GPS_WEAK_OR_NOT = "GPS信号切换";
    public static final String NAV_IS_SWITCH_3D = "视野切换3D";
    public static final String NAV_MODE_3D_IN = "进入全屏导航";
    public static final String NAV_MODE_3D_OUT = "退出全屏导航";
    public static final String NAV_MODE_SET = "导航模式设置";
    public static final String NAV_MODE_SET_AGAIN = "导航模式重复设置";
    public static final String NAV_MOVE_MAP = "触摸移动底图";
    public static final String NAV_NET_REQUEST = "导航网络请求";
    public static final String NAV_NOT_ROAD_REQUEST = "偏航路径规划";
    public static final String NAV_REMOVE_LINE = "删除路线";
    public static final String NAV_ROUTENAME_BUBBLE_EXCEPTION = "路名气泡数据异常";
    public static final String NAV_SEARCH_MULTIROUTE_SUCCESS = "多路线请求是否成功";
    public static final String NAV_SET_GUIDLINE_SHOW = "设置终点引导线是否隐藏";
    public static final String NAV_SWITCH_ROAD_SUCCESS = "多路线操作，是否切换备选路线成功";
    public static final String NAV_TRAFFIC_EVENT = "路况事件刷新";
    public static final String NAV_TRAFFIC_EXCEPTION = "服务器下发路况不在路线点上";
    public static final String NAV_TRAFFIC_SHOW = "导航引擎回调.显示路况事件";
    public static final String NAV_TRAFFIC_TIMEOUT = "彩虹蚯蚓请求超时";
    public static final String NAV_TUNNEL_SIMULATOR = "隧道导航";
    public static final String ROUTE_TAFFIC_UPDATE = "彩虹蚯蚓刷新";

    public static String getParallelRoadMsg(int i) {
        return i == 4 ? "切换到辅路" : "切换到主路";
    }

    private CheckEvents() {
    }
}

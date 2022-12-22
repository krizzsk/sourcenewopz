package com.didi.map.global.flow.scene.param;

import com.didi.map.global.flow.scene.order.serving.scene.ServiceOverScene;

public enum MapElementId {
    ID_MARKER_START("id_marker_start"),
    ID_MARKER_END("id_marker_end"),
    ID_MARKER_PICK_UP("id_marker_pick_up"),
    ID_MARKER_DROP_OFF("id_marker_drop_off"),
    ID_MARKER_WAYPOINT_1("id_marker_waypoint1"),
    ID_MARKER_WAYPOINT_2("id_marker_waypoint2"),
    ID_MARKER_WAYPOINT_3("id_marker_waypoint3"),
    ID_MARKER_START_NAV("id_marker_start_nav"),
    ID_MARKER_END_NAV("id_marker_end_nav"),
    ID_MARKER_RECOMMEND("id_marker_recommend"),
    ID_MARKER_WAYPOINT(ServiceOverScene.ID_MARKER_WAYPOINT),
    ID_MARKER_CAR("id_marker_car"),
    ID_MARKER_ODPOINT("id_marker_odpoint"),
    ID_MARKER_DEFAULT("id_marker_default"),
    ID_LINE_START_END("id_line_start_end"),
    ID_LINE_START_PICKUP("id_line_start_pickup"),
    ID_LINE_PICKUP_DROPOFF("id_line_pickup_dropoff"),
    ID_LINE_DROPOFF_END("id_line_dropoff_end"),
    ID_LINE_DRIVER_PAX("id_line_driver_pax"),
    ID_LINE_DEFAULT("id_line_default");

    private MapElementId(String str) {
    }
}

package com.didi.component.operationpanel;

import com.taxis99.R;

public class Operations {
    public static final OperationPanelItemModel CANCEL = new OperationPanelItemModel(512, (int) R.string.global_operation_panel_cancel, 0, Integer.MAX_VALUE);
    public static final OperationPanelItemModel EXPENSIVE_COMPENSATION = new OperationPanelItemModel(529, (int) R.string.GRider_rider_You_must_bifT, (int) R.drawable.global_operation_panel_expensive_compensation);
    public static final OperationPanelItemModel GIVE_UP_ORDER = new OperationPanelItemModel(517, (int) R.string.global_operation_panel_give_up_trip, 0);
    public static final OperationPanelItemModel HELP = new OperationPanelItemModel(514, (int) R.string.global_operation_panel_help, (int) R.drawable.global_operation_panel_help_btn_bg);
    public static final int ID_CANCEL = 512;
    public static final int ID_CANCELSPLIT_FARE = 528;
    public static final int ID_COMPONENT = 520;
    public static final int ID_EXPENSIVE_COMPENSATION = 529;
    public static final int ID_GIVE_UP_ORDER = 517;
    public static final int ID_HELP = 514;
    public static final int ID_INVOICE = 522;
    public static final int ID_PIN = 515;
    public static final int ID_RESTART_ORDER = 518;
    public static final int ID_SHARE = 513;
    public static final int ID_SOS = 519;
    public static final int ID_SPLIT_FARE = 521;
    public static final int ID_UPDATE_DEST = 516;
    public static final OperationPanelItemModel INVOICE = new OperationPanelItemModel(522, (int) R.string.global_operation_panel_invoice, 0);
    public static final OperationPanelItemModel INVOICE_WITH_ICON = new OperationPanelItemModel(522, (int) R.string.global_operation_panel_invoice, (int) R.drawable.global_customo_service_receipt_icon);
    public static final OperationPanelItemModel PIN = new OperationPanelItemModel(515, (int) R.string.global_operation_panel_pin, (int) R.drawable.global_operation_panel_pin_btn_bg);
    public static final OperationPanelItemModel RESTART_ORDER = new OperationPanelItemModel(518, (int) R.string.global_operation_panel_request_again, 0);
    public static final OperationPanelItemModel ROUTE_EDITOR = new OperationPanelItemModel(516, (int) R.string.global_operation_panel_route_editor, (int) R.drawable.global_operation_panel_edit_btn_bg);
    public static final OperationPanelItemModel SHARE = new OperationPanelItemModel(513, (int) R.string.global_operation_panel_share, (int) R.drawable.global_operation_panel_share);
    public static final OperationPanelItemModel SPLIT_FARE = new OperationPanelItemModel(521, (int) R.string.global_operation_panel_split_fare, (int) R.drawable.global_operation_panel_split_fare);
    public static final OperationPanelItemModel SPLIT_FARE_CANCEL = new OperationPanelItemModel(528, (int) R.string.global_operation_panel_cancel_split_fare, (int) R.drawable.global_operation_panel_cancel_split_fare);
    public static final OperationPanelItemModel UPDATE_DEST = new OperationPanelItemModel(516, (int) R.string.global_operation_panel_update_dest, (int) R.drawable.global_operation_panel_edit_btn_bg);
}

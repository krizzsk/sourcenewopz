package com.didi.component.operationpanel.impl.util;

import com.didi.component.common.util.BitUtil;
import com.didi.component.operationpanel.OperationPanelItemModel;
import java.util.ArrayList;

public class OperationUtils {
    public static final int BUTTON_CONTROL_BIT_INDEX_CANCEL = 1;
    public static final int BUTTON_CONTROL_BIT_INDEX_EMERGENCY = 4;
    public static final int BUTTON_CONTROL_BIT_INDEX_HELP = 3;
    public static final int BUTTON_CONTROL_BIT_INDEX_IM = 5;
    public static final int BUTTON_CONTROL_BIT_INDEX_PHONE = 6;
    public static final int BUTTON_CONTROL_BIT_INDEX_SHARE = 2;
    public static final int BUTTON_CONTROL_BIT_INDEX_UPDATE_DEST = 7;
    public static final int BUTTON_CONTROL_BIT_SOS = 8;
    public static final int BUTTON_CONTROL_INVOICE = 13;

    public static int getButtonControlBitIndex(OperationPanelItemModel operationPanelItemModel) {
        int i = operationPanelItemModel.f14774id;
        if (i == 516) {
            return 7;
        }
        if (i == 519) {
            return 8;
        }
        if (i == 522) {
            return 13;
        }
        switch (i) {
            case 512:
                return 1;
            case 513:
                return 2;
            case 514:
                return 3;
            default:
                return -1;
        }
    }

    public static boolean isButtonControlAllowed(OperationPanelItemModel operationPanelItemModel, long j) {
        int buttonControlBitIndex = getButtonControlBitIndex(operationPanelItemModel);
        if (buttonControlBitIndex < 0) {
            return true;
        }
        return !BitUtil.value_bit(j, buttonControlBitIndex);
    }

    public static boolean addOperationIfButtonControlAllowed(ArrayList<OperationPanelItemModel> arrayList, OperationPanelItemModel operationPanelItemModel, long j) {
        if (arrayList == null || operationPanelItemModel == null || !isButtonControlAllowed(operationPanelItemModel, j)) {
            return false;
        }
        arrayList.add(operationPanelItemModel);
        return true;
    }
}

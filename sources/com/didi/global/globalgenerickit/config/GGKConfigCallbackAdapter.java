package com.didi.global.globalgenerickit.config;

import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import java.util.Map;

public class GGKConfigCallbackAdapter {
    public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
        return false;
    }

    public boolean alertWillShow(String str) {
        return true;
    }

    public boolean alertXMLClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, GGKData gGKData, String str, String str2, Map<String, Object> map) {
        return false;
    }

    public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
        return false;
    }

    public boolean sheetWillShow(String str) {
        return true;
    }

    public boolean sheetXMLClickLis(LEGODrawer lEGODrawer, GGKData gGKData, String str, String str2, Map<String, Object> map) {
        return false;
    }
}

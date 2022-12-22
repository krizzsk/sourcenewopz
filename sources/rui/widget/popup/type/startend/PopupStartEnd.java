package rui.widget.popup.type.startend;

import java.util.List;
import rui.widget.popup.base.BasePopupModel;

public class PopupStartEnd extends BasePopupModel<FactoryPopupStartEnd> {
    public static final String INDEX_END_TAB = "right";
    public static final String INDEX_START_TAB = "left";
    public String buttonTitle;
    public String defaultEndLeft;
    public String defaultEndRight;
    public String defaultStartLeft;
    public String defaultStartRight;
    public String defaultTab = "left";
    public List<String> endDataLeft;
    public List<String> endDataRight;
    public String endTitle;
    public Listener listener;
    public List<String> startDataLeft;
    public List<String> startDataRight;
    public String startTitle;

    public interface Listener {
        void onCloseClicked();

        void onConfirm(String str, String str2, String str3, String str4);

        void onUpdate(String str, String str2, String str3, String str4);
    }

    public PopupStartEnd() {
        this.factory = new FactoryPopupStartEnd();
    }

    public void updateConfirmTitle(String str) {
        this.buttonTitle = str;
        ((FactoryPopupStartEnd) this.factory).updateConfirmTitle(str);
    }
}

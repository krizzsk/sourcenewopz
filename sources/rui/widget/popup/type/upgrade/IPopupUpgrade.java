package rui.widget.popup.type.upgrade;

public interface IPopupUpgrade {
    void showConfirm();

    void showFinish();

    void showProgress(int i, String str);

    void showProgress(String str);

    void updateContent(String str);

    void updateTitle(String str);
}

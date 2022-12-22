package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.taxis99.R;

public class BottomListMenu {
    private OnDismissListener mDismissListener;
    /* access modifiers changed from: private */
    public final ArrayAdapter<String> mListAdapter;
    /* access modifiers changed from: private */
    public ListMenuListener mListMenuListener;
    private final View mParent;
    private final PopupWindow mPopupWindow;

    public interface ListMenuListener {
        void onItemSelected(int i, String str);
    }

    public interface OnDismissListener {
        void dismiss();
    }

    public BottomListMenu(Activity activity, View view, String[] strArr) {
        this.mParent = view;
        View inflate = View.inflate(activity, R.layout.afanty_v_bottom_list_menu, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.afanty_cancel_text)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomListMenu.this.onCancel();
            }
        });
        ListView listView = (ListView) inflate.findViewById(R.id.afanty_menu_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(activity, R.layout.afanty_v_bottom_list_menu_item, strArr);
        this.mListAdapter = arrayAdapter;
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BottomListMenu.this.dismiss();
                if (BottomListMenu.this.mListMenuListener != null) {
                    BottomListMenu.this.mListMenuListener.onItemSelected(i, (String) BottomListMenu.this.mListAdapter.getItem(i));
                }
            }
        });
        this.mPopupWindow = newSelectPopupWindow(inflate);
    }

    private static int getWindowWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    private PopupWindow newSelectPopupWindow(View view) {
        PopupWindow popupWindow = new PopupWindow(view, getWindowWidth(view.getContext()), -2, true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        return popupWindow;
    }

    /* access modifiers changed from: private */
    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public void showDialog() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.mPopupWindow.showAtLocation(this.mParent, 80, 0, 0);
        }
    }

    public void setListMenuListener(ListMenuListener listMenuListener) {
        this.mListMenuListener = listMenuListener;
    }

    /* access modifiers changed from: private */
    public void onCancel() {
        dismiss();
        OnDismissListener onDismissListener = this.mDismissListener;
        if (onDismissListener != null) {
            onDismissListener.dismiss();
        }
    }

    public void setDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }
}

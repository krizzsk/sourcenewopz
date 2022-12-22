package com.didi.sdk.webview.image;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.WindowUtil;
import com.taxis99.R;

public class BottomListMenu {

    /* renamed from: a */
    private OnDismissListener f38414a;

    /* renamed from: b */
    private Activity f38415b;

    /* renamed from: c */
    private View f38416c;

    /* renamed from: d */
    private PopupWindow f38417d;

    /* renamed from: e */
    private View f38418e;

    /* renamed from: f */
    private TextView f38419f;

    /* renamed from: g */
    private ListView f38420g = ((ListView) this.f38418e.findViewById(R.id.menu_list));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayAdapter<String> f38421h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ListMenuListener f38422i;

    public interface ListMenuListener {
        void onItemSelected(int i, String str);
    }

    public interface OnDismissListener {
        void dismiss();
    }

    public BottomListMenu(Activity activity, View view, String[] strArr) {
        this.f38415b = activity;
        this.f38416c = view;
        View inflate = View.inflate(activity, R.layout.v_bottom_list_menu, (ViewGroup) null);
        this.f38418e = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.cancel_text);
        this.f38419f = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BottomListMenu.this.onCancel();
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.f38415b, R.layout.v_bottom_list_menu_item, strArr);
        this.f38421h = arrayAdapter;
        this.f38420g.setAdapter(arrayAdapter);
        this.f38420g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                BottomListMenu.this.dismiss();
                if (BottomListMenu.this.f38422i != null) {
                    BottomListMenu.this.f38422i.onItemSelected(i, (String) BottomListMenu.this.f38421h.getItem(i));
                }
            }
        });
        this.f38417d = m27197a(this.f38418e);
    }

    /* renamed from: a */
    private PopupWindow m27197a(View view) {
        PopupWindow popupWindow = new PopupWindow(view, WindowUtil.getWindowWidth(view.getContext()), -2, true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        return popupWindow;
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f38417d;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f38417d.dismiss();
        }
    }

    public void showDialog() {
        PopupWindow popupWindow = this.f38417d;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.f38417d.showAtLocation(this.f38416c, 80, 0, 0);
        }
    }

    public void setListMenuListener(ListMenuListener listMenuListener) {
        this.f38422i = listMenuListener;
    }

    public void onCancel() {
        dismiss();
        OnDismissListener onDismissListener = this.f38414a;
        if (onDismissListener != null) {
            onDismissListener.dismiss();
        }
    }

    public void setDismissListener(OnDismissListener onDismissListener) {
        this.f38414a = onDismissListener;
    }
}

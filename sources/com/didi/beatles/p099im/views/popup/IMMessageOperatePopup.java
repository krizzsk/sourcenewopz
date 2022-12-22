package com.didi.beatles.p099im.views.popup;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.popup.IMMessageOperatePopup */
public class IMMessageOperatePopup implements View.OnClickListener {

    /* renamed from: b */
    private static IMMessageOperatePopup f10418b = null;

    /* renamed from: k */
    private static final int f10419k = 1;

    /* renamed from: l */
    private static final int f10420l = 2;

    /* renamed from: m */
    private static final int f10421m = 3;

    /* renamed from: a */
    private PopupWindow f10422a;

    /* renamed from: c */
    private OnItemClickListener f10423c;

    /* renamed from: d */
    private int f10424d = ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_single_short));

    /* renamed from: e */
    private int f10425e = ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.popup_height));

    /* renamed from: f */
    private int f10426f;

    /* renamed from: g */
    private TextView f10427g;

    /* renamed from: h */
    private TextView f10428h;

    /* renamed from: i */
    private TextView f10429i;

    /* renamed from: j */
    private RelativeLayout f10430j;

    /* renamed from: n */
    private int f10431n;

    /* renamed from: o */
    private boolean f10432o;

    /* renamed from: com.didi.beatles.im.views.popup.IMMessageOperatePopup$OnItemClickListener */
    public interface OnItemClickListener {
        void onAddWordClick();

        void onCopyClick();

        void onDelClick();
    }

    public static IMMessageOperatePopup instance(ViewGroup viewGroup, boolean z) {
        if (f10418b == null) {
            synchronized (IMMessageOperatePopup.class) {
                f10418b = new IMMessageOperatePopup(viewGroup);
            }
        }
        IMMessageOperatePopup iMMessageOperatePopup = f10418b;
        iMMessageOperatePopup.f10432o = z;
        return iMMessageOperatePopup;
    }

    public void hidePopup() {
        IMMessageOperatePopup iMMessageOperatePopup = f10418b;
        if (iMMessageOperatePopup != null) {
            iMMessageOperatePopup.dismiss();
            this.f10423c = null;
        }
    }

    private IMMessageOperatePopup(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(IMContextInfoHelper.getContext()).inflate(R.layout.bts_im_popup_list, (ViewGroup) null);
        this.f10427g = (TextView) inflate.findViewById(R.id.left_btn);
        this.f10430j = (RelativeLayout) inflate.findViewById(R.id.right_content);
        this.f10428h = (TextView) inflate.findViewById(R.id.middle_btn);
        this.f10429i = (TextView) inflate.findViewById(R.id.right_btn);
        this.f10427g.setOnClickListener(this);
        this.f10428h.setOnClickListener(this);
        this.f10430j.setOnClickListener(this);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        this.f10426f = iArr[1];
        PopupWindow popupWindow = new PopupWindow(inflate, this.f10424d, this.f10425e);
        this.f10422a = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f10422a.setBackgroundDrawable(new BitmapDrawable());
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f10423c = onItemClickListener;
    }

    public void show(View view, int i, boolean z) {
        boolean z2;
        PopupWindow popupWindow = this.f10422a;
        if (popupWindow != null && !popupWindow.isShowing()) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.f10426f <= 0) {
                z2 = false;
            } else {
                iArr[1] = iArr[1] - 10;
                z2 = true;
            }
            if (i != 65536) {
                this.f10431n = 1;
            } else if (!this.f10432o) {
                this.f10431n = 2;
            } else if (z) {
                this.f10431n = 3;
            } else {
                this.f10431n = 2;
            }
            m7094a();
            this.f10422a.setWidth(this.f10424d);
            iArr[0] = iArr[0] + ((view.getWidth() - this.f10424d) / 2);
            if (z2) {
                this.f10422a.showAtLocation(view, 0, iArr[0], iArr[1] - ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.popup_height)));
            } else {
                this.f10422a.showAtLocation(view, 0, iArr[0], iArr[1]);
            }
        }
    }

    public static void onDestory() {
        f10418b = null;
    }

    /* renamed from: a */
    private void m7094a() {
        int i = this.f10431n;
        if (i == 1) {
            this.f10428h.setVisibility(0);
            this.f10427g.setVisibility(8);
            this.f10430j.setVisibility(8);
            this.f10424d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_single_short);
            this.f10428h.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_popup_center_selector));
        } else if (i == 2) {
            this.f10428h.setVisibility(8);
            this.f10427g.setVisibility(0);
            this.f10430j.setVisibility(0);
            this.f10424d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_double_short);
            this.f10429i.setText(IMResource.getString(R.string.im_pop_delete));
        } else if (i == 3) {
            this.f10428h.setVisibility(0);
            this.f10427g.setVisibility(0);
            this.f10430j.setVisibility(0);
            this.f10424d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.im_popup_threee_item_width);
            this.f10424d = (int) (((float) this.f10424d) + IMTextUtil.getTextWidth(this.f10429i, IMResource.getString(R.string.im_add_this_commom_word)));
            this.f10429i.setText(IMResource.getString(R.string.im_add_this_commom_word));
            this.f10428h.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_middle_popup_seletor));
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f10422a;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f10422a.dismiss();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (R.id.left_btn == id) {
            dismiss();
            OnItemClickListener onItemClickListener = this.f10423c;
            if (onItemClickListener != null) {
                onItemClickListener.onCopyClick();
            }
        } else if (R.id.middle_btn == id) {
            dismiss();
            OnItemClickListener onItemClickListener2 = this.f10423c;
            if (onItemClickListener2 != null) {
                onItemClickListener2.onDelClick();
            }
        } else if (R.id.right_content == id) {
            dismiss();
            OnItemClickListener onItemClickListener3 = this.f10423c;
            if (onItemClickListener3 == null) {
                return;
            }
            if (this.f10431n == 2) {
                onItemClickListener3.onDelClick();
            } else {
                onItemClickListener3.onAddWordClick();
            }
        }
    }
}

package com.didi.beatles.p099im.views.messageCard;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog */
public class IMActionSheetDialog {

    /* renamed from: a */
    private Context f10294a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Dialog f10295b;

    /* renamed from: c */
    private TextView f10296c;

    /* renamed from: d */
    private TextView f10297d;

    /* renamed from: e */
    private LinearLayout f10298e;

    /* renamed from: f */
    private ScrollView f10299f;

    /* renamed from: g */
    private boolean f10300g = false;

    /* renamed from: h */
    private List<SheetItem> f10301h;

    /* renamed from: i */
    private Display f10302i;

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$OnSheetItemClickListener */
    public interface OnSheetItemClickListener {
        void onClick(int i);
    }

    public IMActionSheetDialog(Context context) {
        this.f10294a = context;
        this.f10302i = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public IMActionSheetDialog builder() {
        View inflate = LayoutInflater.from(this.f10294a).inflate(R.layout.bts_im_view_actionsheet, (ViewGroup) null);
        inflate.setMinimumWidth(this.f10302i.getWidth());
        this.f10299f = (ScrollView) inflate.findViewById(R.id.sLayout_content);
        this.f10298e = (LinearLayout) inflate.findViewById(R.id.lLayout_content);
        this.f10296c = (TextView) inflate.findViewById(R.id.txt_title);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_cancel);
        this.f10297d = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMActionSheetDialog.this.f10295b.dismiss();
            }
        });
        Dialog dialog = new Dialog(this.f10294a, R.style.IMActionSheetDialogStyle);
        this.f10295b = dialog;
        dialog.setContentView(inflate);
        Window window = this.f10295b.getWindow();
        window.setGravity(83);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        return this;
    }

    public IMActionSheetDialog setTitle(String str) {
        this.f10300g = true;
        this.f10296c.setVisibility(0);
        this.f10296c.setText(str);
        return this;
    }

    public IMActionSheetDialog setCancelable(boolean z) {
        this.f10295b.setCancelable(z);
        return this;
    }

    public IMActionSheetDialog setCanceledOnTouchOutside(boolean z) {
        this.f10295b.setCanceledOnTouchOutside(z);
        return this;
    }

    public IMActionSheetDialog addSheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
        if (this.f10301h == null) {
            this.f10301h = new ArrayList();
        }
        this.f10301h.add(new SheetItem(str, sheetItemColor, onSheetItemClickListener));
        return this;
    }

    public IMActionSheetDialog addSheetItem(String[] strArr, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
        if (this.f10301h == null) {
            this.f10301h = new ArrayList();
        }
        if (strArr != null && strArr.length > 0) {
            for (String sheetItem : strArr) {
                this.f10301h.add(new SheetItem(sheetItem, sheetItemColor, onSheetItemClickListener));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m7023a() {
        List<SheetItem> list = this.f10301h;
        if (list != null && list.size() > 0) {
            final int size = this.f10301h.size();
            if (size >= 7) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10299f.getLayoutParams();
                layoutParams.height = this.f10302i.getHeight() / 2;
                this.f10299f.setLayoutParams(layoutParams);
            }
            for (final int i = 1; i <= size; i++) {
                SheetItem sheetItem = this.f10301h.get(i - 1);
                String str = sheetItem.name;
                SheetItemColor sheetItemColor = sheetItem.color;
                final OnSheetItemClickListener onSheetItemClickListener = sheetItem.itemClickListener;
                TextView textView = new TextView(this.f10294a);
                textView.setText(str);
                textView.setTextSize(16.0f);
                textView.setGravity(17);
                if (size == 1) {
                    if (this.f10300g) {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_single_selector);
                    }
                } else if (this.f10300g) {
                    if (i < 1 || i >= size) {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.im_actionsheet_middle_selector);
                    }
                } else if (i == 1) {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_top_selector);
                } else if (i < size) {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_middle_selector);
                } else {
                    textView.setBackgroundResource(R.drawable.im_actionsheet_bottom_selector);
                }
                if (sheetItemColor == null) {
                    textView.setTextColor(Color.parseColor(SheetItemColor.Blue.getName()));
                } else {
                    textView.setTextColor(Color.parseColor(sheetItemColor.getName()));
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, IMViewUtil.dp2px(this.f10294a, 45.0f)));
                textView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        onSheetItemClickListener.onClick(size - i);
                        IMActionSheetDialog.this.f10295b.dismiss();
                    }
                });
                this.f10298e.addView(textView);
            }
        }
    }

    public void show() {
        m7023a();
        Context context = this.f10294a;
        if (context == null || !(context instanceof FragmentActivity)) {
            SystemUtils.showDialog(this.f10295b);
        } else if (!((FragmentActivity) context).isFinishing()) {
            SystemUtils.showDialog(this.f10295b);
        }
    }

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$SheetItem */
    public class SheetItem {
        SheetItemColor color;
        OnSheetItemClickListener itemClickListener;
        String name;

        public SheetItem(String str, SheetItemColor sheetItemColor, OnSheetItemClickListener onSheetItemClickListener) {
            this.name = str;
            this.color = sheetItemColor;
            this.itemClickListener = onSheetItemClickListener;
        }
    }

    /* renamed from: com.didi.beatles.im.views.messageCard.IMActionSheetDialog$SheetItemColor */
    public enum SheetItemColor {
        Blue("#333333"),
        Red("#FD4A2E");
        
        private String name;

        private SheetItemColor(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }
}

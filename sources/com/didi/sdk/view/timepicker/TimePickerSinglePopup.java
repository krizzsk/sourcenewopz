package com.didi.sdk.view.timepicker;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.List;

@Deprecated
public class TimePickerSinglePopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f38221a;

    /* renamed from: b */
    private TextView f38222b;

    /* renamed from: c */
    private TextView f38223c;

    /* renamed from: d */
    private Wheel f38224d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnTimeSelectedListener f38225e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f38226f;

    /* renamed from: g */
    private String f38227g;

    /* renamed from: h */
    private String f38228h;

    /* renamed from: i */
    private String f38229i;

    /* renamed from: j */
    private String f38230j;

    /* renamed from: k */
    private List<String> f38231k;

    /* renamed from: l */
    private int f38232l = 0;

    public interface OnTimeSelectedListener {
        void onTimeSelected(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.time_picker_data_str;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m27030a(this.mRootView);
    }

    /* renamed from: a */
    private void m27030a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerSinglePopup.this.dismiss();
            }
        });
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f38221a = commonPopupTitleBar;
        String str = this.f38227g;
        if (str != null) {
            commonPopupTitleBar.setTitle(str);
        }
        if (!TextUtils.isEmpty(this.f38227g) && !TextUtils.isEmpty(this.f38228h)) {
            this.f38221a.setMessage(this.f38228h);
        }
        this.f38221a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TimePickerSinglePopup.this.f38226f != null) {
                    TimePickerSinglePopup.this.f38226f.onClick(view);
                }
                TimePickerSinglePopup.this.dismiss();
            }
        });
        this.f38221a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TimePickerSinglePopup.this.f38225e != null) {
                    TimePickerSinglePopup.this.f38225e.onTimeSelected(TimePickerSinglePopup.this.getSelectIndex());
                }
                TimePickerSinglePopup.this.dismiss();
            }
        });
        this.f38222b = (TextView) view.findViewById(R.id.prefix_tv);
        this.f38223c = (TextView) view.findViewById(R.id.suffix_tv);
        this.f38222b.setText(this.f38229i);
        this.f38223c.setText(this.f38230j);
        Wheel wheel = (Wheel) view.findViewById(R.id.wheel_simple);
        this.f38224d = wheel;
        wheel.setData(this.f38231k);
        this.f38224d.setSelectedIndex(this.f38232l);
        this.f38222b = (TextView) view.findViewById(R.id.prefix_tv);
        this.f38223c = (TextView) view.findViewById(R.id.suffix_tv);
    }

    public void setLeftText(String str) {
        this.f38229i = str;
        TextView textView = this.f38222b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setRightText(String str) {
        this.f38230j = str;
        TextView textView = this.f38223c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        if (this.f38221a == null || TextUtils.isEmpty(str)) {
            this.f38227g = str;
        } else {
            this.f38221a.setTitle(str);
        }
    }

    public void setMessage(String str) {
        if (this.f38221a == null || TextUtils.isEmpty(str)) {
            this.f38228h = str;
        } else {
            this.f38221a.setMessage(str);
        }
    }

    public void setData(List<String> list) {
        this.f38231k = list;
        Wheel wheel = this.f38224d;
        if (wheel != null) {
            wheel.setData(list);
        }
    }

    public void setSelectIndex(int i) {
        this.f38232l = i;
        Wheel wheel = this.f38224d;
        if (wheel != null) {
            wheel.setSelectedIndex(i);
        }
    }

    public int getSelectIndex() {
        Wheel wheel = this.f38224d;
        if (wheel != null) {
            return wheel.getSelectedIndex();
        }
        return 0;
    }

    public void setConfirmListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.f38225e = onTimeSelectedListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f38226f = onClickListener;
    }
}

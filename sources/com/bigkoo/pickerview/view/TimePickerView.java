package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.configure.PickerOptions;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.text.ParseException;
import java.util.Calendar;

public class TimePickerView extends BasePickerView implements View.OnClickListener {

    /* renamed from: b */
    private static final String f2105b = "submit";

    /* renamed from: c */
    private static final String f2106c = "cancel";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WheelTime f2107a;

    public TimePickerView(PickerOptions pickerOptions) {
        super(pickerOptions.context);
        this.mPickerOptions = pickerOptions;
        m1730a(pickerOptions.context);
    }

    /* renamed from: a */
    private void m1730a(Context context) {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        if (this.mPickerOptions.customListener == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.contentContainer);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.mPickerOptions.textContentConfirm) ? context.getResources().getString(R.string.pickerview_submit) : this.mPickerOptions.textContentConfirm);
            button2.setText(TextUtils.isEmpty(this.mPickerOptions.textContentCancel) ? context.getResources().getString(R.string.pickerview_cancel) : this.mPickerOptions.textContentCancel);
            textView.setText(TextUtils.isEmpty(this.mPickerOptions.textContentTitle) ? "" : this.mPickerOptions.textContentTitle);
            button.setTextColor(this.mPickerOptions.textColorConfirm);
            button2.setTextColor(this.mPickerOptions.textColorCancel);
            textView.setTextColor(this.mPickerOptions.textColorTitle);
            relativeLayout.setBackgroundColor(this.mPickerOptions.bgColorTitle);
            button.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            button2.setTextSize((float) this.mPickerOptions.textSizeSubmitCancel);
            textView.setTextSize((float) this.mPickerOptions.textSizeTitle);
        } else {
            this.mPickerOptions.customListener.customLayout(LayoutInflater.from(context).inflate(this.mPickerOptions.layoutRes, this.contentContainer));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.mPickerOptions.bgColorWheel);
        m1731a(linearLayout);
    }

    /* renamed from: a */
    private void m1731a(LinearLayout linearLayout) {
        this.f2107a = new WheelTime(linearLayout, this.mPickerOptions.type, this.mPickerOptions.textGravity, this.mPickerOptions.textSizeContent);
        if (this.mPickerOptions.timeSelectChangeListener != null) {
            this.f2107a.setSelectChangeCallback(new ISelectTimeCallback() {
                public void onTimeSelectChanged() {
                    try {
                        TimePickerView.this.mPickerOptions.timeSelectChangeListener.onTimeSelectChanged(WheelTime.dateFormat.parse(TimePickerView.this.f2107a.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.f2107a.setLunarMode(this.mPickerOptions.isLunarCalendar);
        if (!(this.mPickerOptions.startYear == 0 || this.mPickerOptions.endYear == 0 || this.mPickerOptions.startYear > this.mPickerOptions.endYear)) {
            m1729a();
        }
        if (this.mPickerOptions.startDate == null || this.mPickerOptions.endDate == null) {
            if (this.mPickerOptions.startDate != null) {
                if (this.mPickerOptions.startDate.get(1) >= 1900) {
                    m1732b();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else if (this.mPickerOptions.endDate == null) {
                m1732b();
            } else if (this.mPickerOptions.endDate.get(1) <= 2100) {
                m1732b();
            } else {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
        } else if (this.mPickerOptions.startDate.getTimeInMillis() <= this.mPickerOptions.endDate.getTimeInMillis()) {
            m1732b();
        } else {
            throw new IllegalArgumentException("startDate can't be later than endDate");
        }
        m1734d();
        this.f2107a.setLabels(this.mPickerOptions.label_year, this.mPickerOptions.label_month, this.mPickerOptions.label_day, this.mPickerOptions.label_hours, this.mPickerOptions.label_minutes, this.mPickerOptions.label_seconds);
        this.f2107a.setTextXOffset(this.mPickerOptions.x_offset_year, this.mPickerOptions.x_offset_month, this.mPickerOptions.x_offset_day, this.mPickerOptions.x_offset_hours, this.mPickerOptions.x_offset_minutes, this.mPickerOptions.x_offset_seconds);
        this.f2107a.setItemsVisible(this.mPickerOptions.itemsVisibleCount);
        this.f2107a.setAlphaGradient(this.mPickerOptions.isAlphaGradient);
        setOutSideCancelable(this.mPickerOptions.cancelable);
        this.f2107a.setCyclic(this.mPickerOptions.cyclic);
        this.f2107a.setDividerColor(this.mPickerOptions.dividerColor);
        this.f2107a.setDividerType(this.mPickerOptions.dividerType);
        this.f2107a.setLineSpacingMultiplier(this.mPickerOptions.lineSpacingMultiplier);
        this.f2107a.setTextColorOut(this.mPickerOptions.textColorOut);
        this.f2107a.setTextColorCenter(this.mPickerOptions.textColorCenter);
        this.f2107a.isCenterLabel(this.mPickerOptions.isCenterLabel);
    }

    public void setDate(Calendar calendar) {
        this.mPickerOptions.date = calendar;
        m1734d();
    }

    /* renamed from: a */
    private void m1729a() {
        this.f2107a.setStartYear(this.mPickerOptions.startYear);
        this.f2107a.setEndYear(this.mPickerOptions.endYear);
    }

    /* renamed from: b */
    private void m1732b() {
        this.f2107a.setRangDate(this.mPickerOptions.startDate, this.mPickerOptions.endDate);
        m1733c();
    }

    /* renamed from: c */
    private void m1733c() {
        if (this.mPickerOptions.startDate == null || this.mPickerOptions.endDate == null) {
            if (this.mPickerOptions.startDate != null) {
                this.mPickerOptions.date = this.mPickerOptions.startDate;
            } else if (this.mPickerOptions.endDate != null) {
                this.mPickerOptions.date = this.mPickerOptions.endDate;
            }
        } else if (this.mPickerOptions.date == null || this.mPickerOptions.date.getTimeInMillis() < this.mPickerOptions.startDate.getTimeInMillis() || this.mPickerOptions.date.getTimeInMillis() > this.mPickerOptions.endDate.getTimeInMillis()) {
            this.mPickerOptions.date = this.mPickerOptions.startDate;
        }
    }

    /* renamed from: d */
    private void m1734d() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar instance = Calendar.getInstance();
        if (this.mPickerOptions.date == null) {
            instance.setTimeInMillis(System.currentTimeMillis());
            i5 = instance.get(1);
            i = instance.get(2);
            i2 = instance.get(5);
            i3 = instance.get(11);
            i4 = instance.get(12);
            i6 = instance.get(13);
        } else {
            i5 = this.mPickerOptions.date.get(1);
            i = this.mPickerOptions.date.get(2);
            i2 = this.mPickerOptions.date.get(5);
            i3 = this.mPickerOptions.date.get(11);
            i4 = this.mPickerOptions.date.get(12);
            i6 = this.mPickerOptions.date.get(13);
        }
        int i7 = i3;
        int i8 = i2;
        int i9 = i;
        WheelTime wheelTime = this.f2107a;
        wheelTime.setPicker(i5, i9, i8, i7, i4, i6);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            returnData();
        } else if (str.equals("cancel") && this.mPickerOptions.cancelListener != null) {
            this.mPickerOptions.cancelListener.onClick(view);
        }
        dismiss();
    }

    public void returnData() {
        if (this.mPickerOptions.timeSelectListener != null) {
            try {
                this.mPickerOptions.timeSelectListener.onTimeSelect(WheelTime.dateFormat.parse(this.f2107a.getTime()), this.clickView);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTitleText(String str) {
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setLunarCalendar(boolean z) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(WheelTime.dateFormat.parse(this.f2107a.getTime()));
            int i = instance.get(1);
            int i2 = instance.get(2);
            int i3 = instance.get(5);
            int i4 = instance.get(11);
            int i5 = instance.get(12);
            int i6 = instance.get(13);
            this.f2107a.setLunarMode(z);
            this.f2107a.setLabels(this.mPickerOptions.label_year, this.mPickerOptions.label_month, this.mPickerOptions.label_day, this.mPickerOptions.label_hours, this.mPickerOptions.label_minutes, this.mPickerOptions.label_seconds);
            this.f2107a.setPicker(i, i2, i3, i4, i5, i6);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isLunarCalendar() {
        return this.f2107a.isLunarMode();
    }

    public boolean isDialog() {
        return this.mPickerOptions.isDialog;
    }
}

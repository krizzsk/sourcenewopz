package com.didi.sdk.view.picker;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.TimePickerMode;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.picker.Style;
import com.didi.sdk.view.picker.TimePickerBase;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class TimePickerLocal extends TimePickerBase {

    /* renamed from: a */
    private CommonPopupTitleBar f38128a;

    /* renamed from: b */
    private CharSequence f38129b;

    /* renamed from: c */
    private String f38130c;

    /* renamed from: d */
    private boolean f38131d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.picker_local_global;
    }

    /* access modifiers changed from: protected */
    public int getPickerContainerId() {
        return R.id.time_picker;
    }

    public /* bridge */ /* synthetic */ void setAppointmentDay(int i) {
        super.setAppointmentDay(i);
    }

    public /* bridge */ /* synthetic */ void setBeginHourInDay(int i) {
        super.setBeginHourInDay(i);
    }

    public /* bridge */ /* synthetic */ void setBeginMinInDay(int i) {
        super.setBeginMinInDay(i);
    }

    public /* bridge */ /* synthetic */ void setEarliestDelta(int i) {
        super.setEarliestDelta(i);
    }

    public /* bridge */ /* synthetic */ void setEndHourInDay(int i) {
        super.setEndHourInDay(i);
    }

    public /* bridge */ /* synthetic */ void setEndMinInDay(int i) {
        super.setEndMinInDay(i);
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(int[] iArr) {
        super.setInitialSelect(iArr);
    }

    public /* bridge */ /* synthetic */ void setLastSelectedTime(long j) {
        super.setLastSelectedTime(j);
    }

    public /* bridge */ /* synthetic */ void setMinuteDelta(int i) {
        super.setMinuteDelta(i);
    }

    public /* bridge */ /* synthetic */ void setPickerData(List list) {
        super.setPickerData(list);
    }

    public /* bridge */ /* synthetic */ void setTimeListener(TimePickerBase.OnTimeSelectedListener onTimeSelectedListener) {
        super.setTimeListener(onTimeSelectedListener);
    }

    public /* bridge */ /* synthetic */ void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyleInner(new Style.Builder().setWeight(2, 1, 1).setSuffix("", getString(R.string.time_picker_hour), getString(R.string.time_picker_min)).setSuffixScope("", "^[0-9]*$", "^[0-9]*$").setPaddingVertical(dp2px(getContext(), 25.0f), dp2px(getContext(), 25.0f)).build());
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        m26962a(this.mRootView);
    }

    public void setIsSupportNow(boolean z) {
        this.f38131d = z;
    }

    /* access modifiers changed from: protected */
    public List<PickerDataNode<PickerString>> appendCustomData(List<PickerDataNode<PickerString>> list) {
        if (!list.isEmpty() && (list.get(0).pointList == null || list.get(0).pointList.isEmpty())) {
            this.mFrontDayRemoveSum = 1;
            setAppointmentDay(this.mTimeStrategy.getAppointmentDay() + 1);
            list = getDayList();
            list.remove(0);
        }
        if (this.f38131d) {
            list.add(0, new PickerDataNode(new PickerString(getResources().getString(R.string.now)), Collections.singletonList(new PickerDataNode(new PickerString("--"), Collections.singletonList(new PickerDataNode(new PickerString("--")))))));
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public long onResultConvert(Calendar calendar, List<PickerString> list, int[] iArr) {
        if (this.f38131d && iArr[0] == 0) {
            return 0;
        }
        calendar.add(5, (iArr[0] + this.mFrontDayRemoveSum) - dayOffset());
        if (list.size() > 1 && TextUtil.isDigit(list.get(1).getSimpleData())) {
            calendar.set(11, Integer.valueOf(list.get(1).getSimpleData()).intValue());
        }
        if (list.size() > 2 && TextUtil.isDigit(list.get(2).getSimpleData())) {
            calendar.set(12, Integer.valueOf(list.get(2).getSimpleData()).intValue());
        }
        return calendar.getTimeInMillis();
    }

    /* access modifiers changed from: protected */
    public int dayOffset() {
        return this.f38131d ? 1 : 0;
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f38128a;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f38129b = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f38128a == null || TextUtils.isEmpty(str)) {
            this.f38130c = str;
        } else {
            this.f38128a.setMessage(str);
        }
    }

    /* renamed from: a */
    private void m26962a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerLocal.this.dismiss();
            }
        });
        this.f38128a = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        TextView textView = (TextView) view.findViewById(R.id.title_bar2);
        View findViewById = view.findViewById(R.id.rl_root);
        View findViewById2 = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f38129b;
        if (charSequence != null) {
            this.f38128a.setTitle(charSequence.toString());
            textView.setText(this.f38129b.toString());
        }
        if (!TextUtils.isEmpty(this.f38130c)) {
            this.f38128a.setMessage(this.f38130c);
        }
        this.f38128a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerLocal.this.confirmSelectAndCallback();
                TimePickerLocal.this.dismiss();
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.tv_confirm2);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getTimePickerMode() == TimePickerMode.Global) {
            this.f38128a.setVisibility(8);
            textView2.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        } else {
            this.f38128a.setVisibility(0);
            textView2.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById.setBackgroundResource(R.drawable.common_dialog_bg);
        }
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerLocal.this.confirmSelectAndCallback();
                TimePickerLocal.this.dismiss();
            }
        });
        this.f38128a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerLocal.this.dismiss();
            }
        });
    }
}

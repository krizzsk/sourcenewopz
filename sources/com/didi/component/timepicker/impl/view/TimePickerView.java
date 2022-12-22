package com.didi.component.timepicker.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.timepicker.AbsTimePickerPresenter;
import com.didi.component.timepicker.ITimePickerView;
import com.didi.component.timepicker.TimePickerModel;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.picker.TimePickerBase;
import com.didi.sdk.view.picker.TimePickerGlobal;
import com.didi.sdk.view.timepicker.TimePickerSinglePopup;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.taxis99.R;

public class TimePickerView implements View.OnClickListener, ITimePickerView, TimePickerBase.OnTimeSelectedListener, TimePickerSinglePopup.OnTimeSelectedListener {

    /* renamed from: a */
    private final Logger f16135a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private TimePickerSinglePopup f16136b;

    /* renamed from: c */
    private TimePickerGlobal f16137c;

    /* renamed from: d */
    private GlobalTipsContainer f16138d;

    /* renamed from: e */
    private Runnable f16139e;
    protected Activity mContext;
    protected TextView mLabelView;
    protected AbsTimePickerPresenter mPresenter;
    protected View mRootView;

    public void dismissNewBubble() {
    }

    public int getLayoutId() {
        return R.layout.global_timepicker_entrance_layout;
    }

    public void setArrow(boolean z) {
    }

    public void setEnable(boolean z) {
    }

    public void setIcon(int i) {
    }

    public void setIcon(String str) {
    }

    public void showBookingGuideTips(BubbleItemModel bubbleItemModel) {
    }

    public TimePickerView(Activity activity, ViewGroup viewGroup) {
        this.mContext = activity;
        View inflate = activity.getLayoutInflater().inflate(getLayoutId(), viewGroup, false);
        this.mRootView = inflate;
        inflate.setOnClickListener(this);
        this.mLabelView = (TextView) this.mRootView.findViewById(R.id.tv_timepicker_item_label);
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsTimePickerPresenter absTimePickerPresenter) {
        this.mPresenter = absTimePickerPresenter;
    }

    public void setName(CharSequence charSequence) {
        this.mLabelView.setText(charSequence);
    }

    public void setLabel(CharSequence charSequence) {
        this.mLabelView.setText(charSequence);
    }

    public void showTimepickerDialog(TimePickerModel timePickerModel, long j) {
        if (timePickerModel != null) {
            if (timePickerModel.model == 1) {
                m11832b(timePickerModel, j);
            } else {
                m11831a(timePickerModel, j);
            }
        }
    }

    /* renamed from: a */
    private void m11831a(TimePickerModel timePickerModel, long j) {
        if (timePickerModel != null) {
            this.f16137c = new TimePickerGlobal();
            if (!TextUtils.isEmpty(timePickerModel.title)) {
                this.f16137c.setTitle(timePickerModel.title);
            }
            TextUtils.isEmpty(timePickerModel.subTitle);
            this.f16137c.setAppointmentDay(timePickerModel.appointmentDay);
            this.f16137c.setEarliestDelta(timePickerModel.earliestDelta);
            this.f16137c.setBeginHourInDay(timePickerModel.from);
            this.f16137c.setEndHourInDay(timePickerModel.f16115to);
            if (j > 0) {
                this.f16137c.setLastSelectedTime(j);
            }
            this.f16137c.setTimeListener(this);
            FragmentActivity fragmentActivity = (FragmentActivity) this.mContext;
            if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
                this.f16137c.show(fragmentActivity.getSupportFragmentManager(), "abstimepickerview");
            }
        }
    }

    /* renamed from: b */
    private void m11832b(TimePickerModel timePickerModel, long j) {
        if (timePickerModel != null) {
            this.f16136b = new TimePickerSinglePopup();
            if (!TextUtils.isEmpty(timePickerModel.title)) {
                this.f16136b.setTitle(timePickerModel.title.toString());
            }
            if (!TextUtils.isEmpty(timePickerModel.subTitle)) {
                this.f16136b.setMessage(timePickerModel.subTitle);
            }
            if (!TextUtils.isEmpty(timePickerModel.simpleWheelLeftLabel)) {
                this.f16136b.setLeftText(timePickerModel.simpleWheelLeftLabel);
            }
            if (!TextUtils.isEmpty(timePickerModel.simpleWheelRightLabel)) {
                this.f16136b.setRightText(timePickerModel.simpleWheelRightLabel);
            }
            this.f16136b.setSelectIndex((int) j);
            this.f16136b.setData(timePickerModel.simpleWheelList);
            this.f16136b.setConfirmListener(this);
            FragmentActivity fragmentActivity = (FragmentActivity) this.mContext;
            if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
                this.f16136b.show(fragmentActivity.getSupportFragmentManager(), "simpleTimepick");
            }
        }
    }

    public void onTimeSelected(int i) {
        this.mPresenter.onSimpleTimePickerSelected(i);
    }

    public void onTimeSelected(long j) {
        Logger logger = this.f16135a;
        logger.info(">>>>>onTimeSelected>>>>>>>>>>>" + j, new Object[0]);
        TimePickerGlobal timePickerGlobal = this.f16137c;
        if (timePickerGlobal != null) {
            timePickerGlobal.dismiss();
        }
        this.mPresenter.onTimePickerSelected(j);
    }

    public void dismissDialog() {
        TimePickerGlobal timePickerGlobal = this.f16137c;
        if (timePickerGlobal != null && timePickerGlobal.isVisible()) {
            this.f16137c.dismiss();
        }
        TimePickerSinglePopup timePickerSinglePopup = this.f16136b;
        if (timePickerSinglePopup != null && timePickerSinglePopup.isVisible()) {
            this.f16136b.dismiss();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!this.mPresenter.onInterceptModifyDepartTime()) {
            this.mPresenter.showTimePickerDialog();
        }
    }

    public void bindRichInfo(GlobalRichInfo globalRichInfo) {
        if (this.mLabelView != null && !TextUtils.isEmpty(globalRichInfo.getContent())) {
            globalRichInfo.bindTextView(this.mLabelView);
        }
    }
}

package com.didiglobal.privacy.disclosure;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class PrivacyDisclosureDriverDialog extends PrivacyDisclosureBaseDialog {

    /* renamed from: a */
    private TextView f50489a;

    /* renamed from: b */
    private ImageView f50490b;

    /* access modifiers changed from: protected */
    public void uploadInfo(Context context, UploadParam uploadParam) {
        UploadUtils.upload(context, uploadParam);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().clearFlags(2);
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureBaseManager.getInitParam();
        View inflate = layoutInflater.inflate(initParam.getDialogLayoutResInt(), viewGroup, false);
        m36315a(inflate, initParam);
        return inflate;
    }

    /* renamed from: a */
    private void m36315a(View view, IPrivacyDisclosureInitParam iPrivacyDisclosureInitParam) {
        this.content = view.findViewById(R.id.content);
        this.titleTxt = (TextView) view.findViewById(R.id.title);
        this.descTxt = (TextView) view.findViewById(R.id.desc);
        this.f50490b = (ImageView) view.findViewById(R.id.permission_icon);
        this.f50489a = (TextView) view.findViewById(R.id.permission_name);
        this.positiveBtn = (TextView) view.findViewById(R.id.btn_positive);
        this.positiveBtn.setBackgroundResource(iPrivacyDisclosureInitParam.getPositiveBtnResInt());
        this.positiveBtn.setTextColor(iPrivacyDisclosureInitParam.getPositionBtnTextColor());
        this.positiveBtn.setText(iPrivacyDisclosureInitParam.getPositiveBtnText(getContext()));
        this.negativeBtn = (TextView) view.findViewById(R.id.btn_negative);
        this.negativeBtn.setBackgroundResource(iPrivacyDisclosureInitParam.getNegativeBtnResInt());
        this.negativeBtn.setTextColor(iPrivacyDisclosureInitParam.getNegativeBtnTextColor());
        this.negativeBtn.setText(iPrivacyDisclosureInitParam.getNegativeBtnText(getContext()));
        this.scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (this.builder != null) {
            this.titleTxt.setText(R.string.GDriver_popups_Privacy_Statement_trga);
            this.descTxt.setText(this.builder.privacyType.getDialogDesc());
            this.f50489a.setText(this.builder.privacyType.getDialogPermName());
            this.f50490b.setImageResource(this.builder.privacyType.getDialogPermIcon().intValue());
            this.positiveBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PrivacyDisclosureDriverDialog.this.builder.callback != null) {
                        PrivacyDisclosureDriverDialog.this.builder.callback.onPositiveResult(PositiveResultReason.USER_CLICK_AGREE_BTN);
                    }
                    PrivacyDisclosureDriverDialog.this.dismiss();
                    DisclosureSpUtils.m36292a(PrivacyDisclosureDriverDialog.this.getActivity(), PrivacyDisclosureDriverDialog.this.builder.privacyType, true);
                    PrivacyDisclosureDriverDialog.this.builder.uploadParam.setClickTime(System.currentTimeMillis() / 1000).setUserAction(1);
                    PrivacyDisclosureDriverDialog privacyDisclosureDriverDialog = PrivacyDisclosureDriverDialog.this;
                    privacyDisclosureDriverDialog.uploadInfo(privacyDisclosureDriverDialog.getActivity(), PrivacyDisclosureDriverDialog.this.builder.uploadParam);
                }
            });
            this.negativeBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PrivacyDisclosureDriverDialog.this.builder.callback != null) {
                        PrivacyDisclosureDriverDialog.this.builder.callback.onNegativeResult();
                    }
                    PrivacyDisclosureDriverDialog.this.dismiss();
                    DisclosureSpUtils.m36292a(PrivacyDisclosureDriverDialog.this.getActivity(), PrivacyDisclosureDriverDialog.this.builder.privacyType, false);
                    PrivacyDisclosureDriverDialog.this.builder.uploadParam.setClickTime(System.currentTimeMillis() / 1000).setUserAction(2);
                    PrivacyDisclosureDriverDialog privacyDisclosureDriverDialog = PrivacyDisclosureDriverDialog.this;
                    privacyDisclosureDriverDialog.uploadInfo(privacyDisclosureDriverDialog.getActivity(), PrivacyDisclosureDriverDialog.this.builder.uploadParam);
                }
            });
            this.isPendingDismiss = false;
            this.content.post(new Runnable() {
                public void run() {
                    int measuredHeight = PrivacyDisclosureDriverDialog.this.content.getMeasuredHeight();
                    PrivacyDisclosureDriverDialog.this.content.animate().cancel();
                    PrivacyDisclosureDriverDialog.this.content.setTranslationY((float) measuredHeight);
                    PrivacyDisclosureDriverDialog.this.content.animate().withStartAction(new Runnable() {
                        public void run() {
                            PrivacyDisclosureDriverDialog.this.content.setVisibility(0);
                        }
                    }).translationYBy((float) (-measuredHeight)).setDuration(300).start();
                }
            });
            return;
        }
        dismiss();
    }
}

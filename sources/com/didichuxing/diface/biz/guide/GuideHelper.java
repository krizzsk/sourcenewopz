package com.didichuxing.diface.biz.guide;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.dfbasesdk.utils.TextViewStyleHelper;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.DiFaceBioassayActivity;
import com.didichuxing.diface.biz.bioassay.self_liveness.DiFaceSelfLivenessActivity;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.data.PreGuideContent;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class GuideHelper {
    public static final String EXTRA_KEY_GUIDE_RESULT = "guide_result";
    public static final String EXTRA_KEY_PRE_GUIDE_RESULT = "pre_guide_result";
    public static final int RECOGNIZE_PLAN_LIVENESS = 2;
    public static final int RECOGNIZE_PLAN_NORMAL = 1;
    public static final int REQUEST_CODE_BIOASSAY = 1;
    public static final int REQUEST_CODE_TO_APPEAL = 4;

    /* renamed from: a */
    private final Context f47461a;

    /* renamed from: b */
    private AppealParam f47462b;

    public GuideHelper(Context context) {
        this.f47461a = context;
    }

    public void showBankcardAppealDialog(final DiFaceResult diFaceResult, final DiFaceBaseActivity diFaceBaseActivity, String str, int i) {
        AlertDialogFragment.Builder negativeButton = new AlertDialogFragment.Builder(diFaceBaseActivity).setMessage(diFaceBaseActivity.getString(i)).setCancelable(false).setPositiveButton((int) R.string.df_appeal_dialog_positive_btn, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                DiFaceFacade.getInstance().report("20");
                AppealParam appealParam = new AppealParam();
                appealParam.token = (String) diFaceResult.data.get("token");
                appealParam.name = (String) diFaceResult.data.get("name");
                appealParam.idCard = (String) diFaceResult.data.get("idCard");
                appealParam.faceSessionId = diFaceResult.getSessionId();
                DiFaceFacade.getInstance().appeal(diFaceBaseActivity, appealParam, 4);
            }
        }).setPositiveButtonDefault().setNegativeButton((int) R.string.df_cancel, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL);
                diFaceBaseActivity.finishWithResult(new DiFaceResult(102));
            }
        });
        if (!TextUtils.isEmpty(str)) {
            negativeButton.setTitle(str);
        }
        negativeButton.create().show(diFaceBaseActivity.getSupportFragmentManager(), "");
    }

    public void toBioassayAct(Activity activity, GuideResult guideResult) {
        if (guideResult == null || guideResult.data.result == null || 2 != guideResult.data.result.alive_plan) {
            DiFaceBioassayActivity.start((DiFaceBaseActivity) activity, guideResult);
        } else {
            DiFaceSelfLivenessActivity.start((DiFaceBaseActivity) activity, guideResult);
        }
    }

    public static void setTextViewText(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
    }

    public static void setViewVisible(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public static void initAgreementCheckBox(Context context, CheckBox checkBox, int i, final Button button) {
        final SPHelper sPHelper = new SPHelper(context, "agreement");
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                button.setEnabled(z);
                sPHelper.put("agreement", Boolean.valueOf(z)).apply();
            }
        });
        if (i == 1) {
            checkBox.setChecked(false);
            button.setEnabled(false);
        } else if (i == 2) {
            boolean booleanValue = ((Boolean) sPHelper.get("agreement", false)).booleanValue();
            checkBox.setChecked(booleanValue);
            button.setEnabled(booleanValue);
        } else {
            checkBox.setChecked(true);
            button.setEnabled(true);
        }
    }

    public static void initAgreementText(final Context context, TextView textView, final PreGuideContent preGuideContent, int i) {
        setTextViewText(textView, preGuideContent.checkBoxText + preGuideContent.checkBoxHighlightText);
        String charSequence = textView.getText().toString();
        if (!TextUtils.isEmpty(preGuideContent.checkBoxHighlightText)) {
            int lastIndexOf = charSequence.lastIndexOf(preGuideContent.checkBoxHighlightText);
            if (lastIndexOf != -1) {
                TextViewStyleHelper.with(context, charSequence).range(lastIndexOf, charSequence.length()).textColor(ResUtils.getColor(i)).onClick(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DFUserAgreementAct.start(context, preGuideContent);
                    }
                }).into(textView);
                return;
            }
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DFUserAgreementAct.start(context, preGuideContent);
            }
        });
    }
}

package com.didichuxing.diface.appeal.brazil;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public class AdditionalDocFragment extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RadioGroup f47006a;

    /* renamed from: b */
    private Button f47007b;

    /* renamed from: c */
    private Button f47008c;

    public static AdditionalDocFragment newInstance() {
        return new AdditionalDocFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_additional_doc_layout, viewGroup, false);
        this.f47006a = (RadioGroup) inflate.findViewById(R.id.radio_group);
        this.f47007b = (Button) inflate.findViewById(R.id.next_btn);
        this.f47008c = (Button) inflate.findViewById(R.id.exit_btn);
        String string = getString(R.string.df_appeal_additional_doc_option1);
        changeTextStyle((RadioButton) inflate.findViewById(R.id.option1), string, string.indexOf(10) + 1);
        this.f47007b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BusUtils.post(new AdditionalDocSelectDoneEvent((String) ((RadioButton) AdditionalDocFragment.this.f47006a.findViewById(AdditionalDocFragment.this.f47006a.getCheckedRadioButtonId())).getTag()));
                AdditionalDocFragment.this.m33686a();
            }
        });
        this.f47008c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BusUtils.post(new AdditionalDocSelectDoneEvent(""));
                AdditionalDocFragment.this.m33686a();
            }
        });
        return inflate;
    }

    public static void changeTextStyle(RadioButton radioButton, String str, int i) {
        int length = str.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ResUtils.getColor(R.color.df_main_text_color3));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(ResUtils.getDimen(R.dimen.df_main_text_size_small));
        spannableStringBuilder.setSpan(foregroundColorSpan, i, length, 33);
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, length, 33);
        radioButton.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33686a() {
        try {
            getFragmentManager().popBackStackImmediate();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }
}

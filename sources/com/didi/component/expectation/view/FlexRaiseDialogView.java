package com.didi.component.expectation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.expectation.model.FlexRaiseSheet;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class FlexRaiseDialogView extends SimplePopupBase {

    /* renamed from: c */
    private static final String f13698c = "felx_raise_data";

    /* renamed from: a */
    private FlexRaiseSheetView f13699a;

    /* renamed from: b */
    private ImageView f13700b;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_flex_raise_dialog_layout;
    }

    public static FlexRaiseDialogView newInstance(FlexRaiseSheet flexRaiseSheet) {
        FlexRaiseDialogView flexRaiseDialogView = new FlexRaiseDialogView();
        Bundle bundle = new Bundle();
        if (flexRaiseSheet != null) {
            bundle.putSerializable(f13698c, flexRaiseSheet);
        }
        flexRaiseDialogView.setArguments(bundle);
        return flexRaiseDialogView;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f13699a = (FlexRaiseSheetView) this.mRootView.findViewById(R.id.flex_bargain_card_layout);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.flex_close_img);
        this.f13700b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FlexRaiseDialogView.this.dismiss();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable(f13698c) != null) {
            setData((FlexRaiseSheet) arguments.getSerializable(f13698c));
        }
    }

    public void setData(FlexRaiseSheet flexRaiseSheet) {
        FlexRaiseSheetView flexRaiseSheetView = this.f13699a;
        if (flexRaiseSheetView != null) {
            flexRaiseSheetView.setData(flexRaiseSheet);
            this.f13699a.setSimplePopupBase(this);
        }
    }
}

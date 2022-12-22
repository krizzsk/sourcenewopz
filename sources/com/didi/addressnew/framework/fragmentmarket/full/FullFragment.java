package com.didi.addressnew.framework.fragmentmarket.full;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class FullFragment extends FragmentImpl {

    /* renamed from: a */
    private final FragmentFactory.FragmentType f4431a = FragmentFactory.FragmentType.FULL;

    public boolean getDragHandlerEnable() {
        return true;
    }

    public View getFallbackView() {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_fragment_demo, viewGroup, false);
        inflate.setBackgroundColor(Color.parseColor("#00ffffff"));
        ((Button) inflate.findViewById(R.id.prev)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FullFragment fullFragment = FullFragment.this;
                fullFragment.switchBack(fullFragment.getmParam(), FullFragment.this.getmResult());
            }
        });
        ((Button) inflate.findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FullFragment fullFragment = FullFragment.this;
                fullFragment.switchMapSelect(fullFragment.getmParam(), FullFragment.this.getmResult(), -1);
            }
        });
        return inflate;
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public void onPageEnter() {
        super.onPageEnter();
    }

    public void onPageExit() {
        super.onPageExit();
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.FULL;
    }
}

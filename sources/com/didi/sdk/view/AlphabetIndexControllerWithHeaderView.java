package com.didi.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.taxis99.R;

public class AlphabetIndexControllerWithHeaderView extends LinearLayout {

    /* renamed from: a */
    private TextView f37772a;

    /* renamed from: b */
    private int f37773b = -1;

    /* renamed from: c */
    private InputMethodManager f37774c;
    protected PinnedHeaderListView list;
    protected SectionIndexer sectionIndexer = null;

    public AlphabetIndexControllerWithHeaderView(Context context) {
        super(context);
        initView();
        this.f37774c = (InputMethodManager) context.getSystemService("input_method");
    }

    public AlphabetIndexControllerWithHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
        this.f37774c = (InputMethodManager) context.getSystemService("input_method");
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.v_search_city_index, this);
    }

    public void setListView(PinnedHeaderListView pinnedHeaderListView) {
        this.list = pinnedHeaderListView;
        this.sectionIndexer = (SectionIndexer) pinnedHeaderListView.getAdapter();
    }

    public void setTextView(TextView textView) {
        this.f37772a = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        String str;
        int positionForSection;
        if (this.f37774c.isActive()) {
            this.f37774c.hideSoftInputFromWindow(this.f37772a.getApplicationWindowToken(), 0);
        }
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        int childCount = linearLayout.getChildCount();
        int measuredHeight = linearLayout.getChildAt(0).getMeasuredHeight();
        if (motionEvent.getY() > ((float) measuredHeight)) {
            i = ((((int) motionEvent.getY()) - measuredHeight) / ((getChildAt(0).getMeasuredHeight() - measuredHeight) / (childCount - 1))) + 1;
        } else {
            i = 0;
        }
        if (i < 0 || i >= childCount) {
            this.f37772a.setVisibility(4);
            return true;
        } else if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.f37772a.setVisibility(0);
            if (i == 0) {
                str = getResources().getString(R.string.star);
            } else {
                str = ((TextView) linearLayout.getChildAt(i)).getText().toString();
            }
            this.f37772a.setText(str);
            if (this.sectionIndexer == null) {
                PinnedHeaderListView pinnedHeaderListView = this.list;
                if (pinnedHeaderListView == null || pinnedHeaderListView.getAdapter() == null) {
                    this.f37772a.setVisibility(4);
                    return false;
                }
                this.sectionIndexer = (SectionIndexer) ((HeaderViewListAdapter) this.list.getAdapter()).getWrappedAdapter();
            }
            int positionForSection2 = this.sectionIndexer.getPositionForSection(str.toCharArray()[0]);
            if (positionForSection2 == -1) {
                int i2 = 0;
                while (true) {
                    i2++;
                    int i3 = str.toCharArray()[0] + i2;
                    if (i3 > 90) {
                        positionForSection = this.sectionIndexer.getPositionForSection(35);
                        break;
                    }
                    positionForSection = this.sectionIndexer.getPositionForSection(i3);
                    if (positionForSection != -1) {
                        break;
                    }
                }
                if (positionForSection != -1) {
                    this.list.setSelection(positionForSection);
                    return true;
                }
                this.f37772a.setVisibility(4);
                return false;
            }
            this.f37773b = positionForSection2;
            if (positionForSection2 < 0 || positionForSection2 >= this.list.getCount()) {
                return false;
            }
            this.list.setSelection(this.f37773b);
            return true;
        } else {
            this.f37772a.setVisibility(4);
            return true;
        }
    }
}

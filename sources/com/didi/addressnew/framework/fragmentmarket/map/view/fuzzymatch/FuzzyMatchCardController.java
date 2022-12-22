package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import android.content.Context;
import android.view.View;

public class FuzzyMatchCardController {

    /* renamed from: a */
    FuzzyMatchCardCallback f7207a;

    /* renamed from: b */
    private Context f7208b;

    public FuzzyMatchCardController(Context context, FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        this.f7208b = context;
        this.f7207a = fuzzyMatchCardCallback;
    }

    public View getView(int i) {
        if (i == 0) {
            return new FuzzyMatchCardView(this.f7208b, this.f7207a);
        }
        if (i != 1) {
            return null;
        }
        return new FuzzyMatchListView(this.f7208b, this.f7207a);
    }
}

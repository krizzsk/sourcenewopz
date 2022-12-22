package com.didi.payment.base.view.helper;

import android.view.View;
import android.view.ViewGroup;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import java.util.ArrayList;
import java.util.Stack;

public class FreezeHelper {
    public static void freezePageUI(View view, IViewFreezeApplyer.FreezeState freezeState) {
        Stack stack = new Stack();
        if (view != null) {
            stack.push(view);
        }
        ArrayList<IViewFreezeApplyer> arrayList = new ArrayList<>();
        while (stack.size() > 0) {
            View view2 = (View) stack.pop();
            if (view2 instanceof IViewFreezeApplyer) {
                arrayList.add((IViewFreezeApplyer) view2);
            }
            if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    stack.push(viewGroup.getChildAt(i));
                    i++;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (IViewFreezeApplyer apply : arrayList) {
                apply.apply(freezeState);
            }
            arrayList.clear();
        }
    }
}

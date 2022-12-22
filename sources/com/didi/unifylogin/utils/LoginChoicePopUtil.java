package com.didi.unifylogin.utils;

import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SingleChoicePopup;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import java.util.ArrayList;
import java.util.List;

public class LoginChoicePopUtil {
    public static void showPopMenu(FragmentActivity fragmentActivity, List<ChoiceItem> list, AdapterView.OnItemClickListener onItemClickListener, final View.OnClickListener onClickListener) {
        if (list.size() >= 1) {
            ArrayList arrayList = new ArrayList();
            for (ChoiceItem choiceItem : list) {
                SingleChoicePopup.SingleChoiceItem singleChoiceItem = new SingleChoicePopup.SingleChoiceItem();
                singleChoiceItem.mItemName = choiceItem.msg;
                arrayList.add(singleChoiceItem);
            }
            final SingleChoicePopup singleChoicePopup = new SingleChoicePopup();
            singleChoicePopup.setCancelable(false);
            singleChoicePopup.setContentAdapter(new SingleChoicePopup.SingleChoiceAdapter(fragmentActivity, arrayList) {
                /* access modifiers changed from: protected */
                public int getTxtGravity() {
                    return 17;
                }
            });
            singleChoicePopup.setLeftClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    View.OnClickListener.this.onClick(view);
                    singleChoicePopup.dismiss();
                }
            });
            singleChoicePopup.setOnItemClickListener(onItemClickListener);
            singleChoicePopup.show(fragmentActivity.getSupportFragmentManager(), (String) null);
        }
    }

    public static List<ChoiceItem> getChoicesFormRole(List<GateKeeperResponse.Role> list) {
        if (list.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GateKeeperResponse.Role next : list) {
            arrayList.add(new ChoiceItem(next.f44704id, next.text));
        }
        return arrayList;
    }

    public static class ChoiceItem {

        /* renamed from: id */
        public int f44924id;
        public String msg;

        public ChoiceItem(int i, String str) {
            this.f44924id = i;
            this.msg = str;
        }
    }
}

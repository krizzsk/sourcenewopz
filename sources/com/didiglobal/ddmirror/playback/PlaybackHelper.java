package com.didiglobal.ddmirror.playback;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.didiglobal.ddmirror.monitor.PrismConstants;
import com.didiglobal.ddmirror.monitor.model.EventData;
import com.didiglobal.ddmirror.playback.model.EventInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaybackHelper {
    public static boolean validateWindow(PrismWindow prismWindow, String str) {
        WindowManager.LayoutParams attributes = prismWindow.getWindow().getAttributes();
        String trim = attributes.getTitle().toString().trim();
        String substring = trim.substring(trim.indexOf("/") + 1);
        int i = attributes.type;
        String[] split = str.split("_&_");
        if (!split[0].equals(substring) || Integer.parseInt(split[1]) != i) {
            return false;
        }
        return true;
    }

    public static View findTargetViewOnScreen(PrismWindow prismWindow, HashMap<String, String> hashMap) {
        View findTargetViewById;
        String str = hashMap.get("vi");
        String str2 = hashMap.get("vp");
        String str3 = hashMap.get("vl");
        String str4 = hashMap.get("vr");
        View view = null;
        if (validateWindow(prismWindow, hashMap.get("w")) && str2 != null) {
            if (str3 != null) {
                ViewGroup findTargetViewContainer = findTargetViewContainer(prismWindow.getDecorView(), str2, str3);
                if (findTargetViewContainer != null) {
                    String[] split = str3.split(",");
                    String str5 = split[0];
                    String substring = str2.substring(0, str2.indexOf("*"));
                    View findItemViewByPositionOnScreen = findItemViewByPositionOnScreen(findTargetViewContainer, Integer.parseInt(str5.split(":")[1]));
                    if (str == null || findItemViewByPositionOnScreen == null) {
                        View findTargetViewByPath = findTargetViewByPath(findTargetViewContainer, substring);
                        if (findTargetViewByPath != null) {
                            return findTargetViewByPath;
                        }
                    } else {
                        View findTargetViewById2 = findTargetViewById(findItemViewByPositionOnScreen, str, substring, str4);
                        if (findTargetViewById2 != null) {
                            return findTargetViewById2;
                        }
                        for (int i = 0; i < findTargetViewContainer.getChildCount(); i++) {
                            View findTargetViewById3 = findTargetViewById(findTargetViewContainer.getChildAt(i), str, substring, str4);
                            if (findTargetViewById3 != null) {
                                return findTargetViewById3;
                            }
                        }
                        return null;
                    }
                }
                return null;
            } else if (str != null && (findTargetViewById = findTargetViewById(prismWindow.getDecorView(), str, str2, str4)) != null) {
                return findTargetViewById;
            } else {
                view = findTargetViewByPath(prismWindow.getDecorView(), str2);
                if (view != null) {
                    return view;
                }
                if (TextUtils.isEmpty(str4) || (view = findTargetViewByReference(prismWindow.getDecorView(), str4)) != null) {
                }
            }
        }
        return view;
    }

    public static View findTargetView(PrismWindow prismWindow, EventInfo eventInfo) {
        View findTargetViewById;
        View findTargetViewById2;
        HashMap<String, String> hashMap = eventInfo.eventData;
        String str = hashMap.get("vi");
        String str2 = hashMap.get("vp");
        String str3 = hashMap.get("vl");
        String str4 = hashMap.get("vr");
        View view = null;
        if (validateWindow(prismWindow, hashMap.get("w")) && str2 != null) {
            if (str3 != null) {
                ViewGroup findTargetViewContainer = findTargetViewContainer(prismWindow.getDecorView(), str2, str3);
                if (findTargetViewContainer != null) {
                    String[] split = str3.split(",");
                    String str5 = split[0];
                    String substring = str2.substring(0, str2.indexOf("*"));
                    int parseInt = Integer.parseInt(str5.split(":")[1]);
                    if (needScroll((View) findTargetViewContainer, parseInt)) {
                        smoothScrollToPosition(findTargetViewContainer, parseInt);
                        return null;
                    } else if (str != null) {
                        View findItemViewByPosition = findItemViewByPosition(findTargetViewContainer, parseInt);
                        if (findItemViewByPosition == null || (findTargetViewById2 = findTargetViewById(findItemViewByPosition, str, substring, str4)) == null) {
                            for (int i = 0; i < findTargetViewContainer.getChildCount(); i++) {
                                View findTargetViewById3 = findTargetViewById(findTargetViewContainer.getChildAt(i), str, substring, str4);
                                if (findTargetViewById3 != null) {
                                    smoothScrollToVisible(findTargetViewContainer, findTargetViewById3);
                                    return findTargetViewById3;
                                }
                            }
                            return null;
                        }
                        smoothScrollToVisible(findTargetViewContainer, findTargetViewById2);
                        return findTargetViewById2;
                    } else {
                        View findTargetViewByPath = findTargetViewByPath(findTargetViewContainer, substring);
                        if (findTargetViewByPath != null) {
                            smoothScrollToVisible(findTargetViewContainer, findTargetViewByPath);
                            return findTargetViewByPath;
                        }
                    }
                }
                return null;
            } else if (str != null && (findTargetViewById = findTargetViewById(prismWindow.getDecorView(), str, str2, str4)) != null) {
                return needScrollOrNot(findTargetViewById);
            } else {
                view = findTargetViewByPath(prismWindow.getDecorView(), str2);
                if (view != null) {
                    return needScrollOrNot(view);
                }
                if (!TextUtils.isEmpty(str4) && (view = findTargetViewByReference(prismWindow.getDecorView(), str4)) != null) {
                    return needScrollOrNot(view);
                }
            }
        }
        return view;
    }

    private static View needScrollOrNot(View view) {
        View findScrollableView = findScrollableView(view);
        if (findScrollableView == null || !needScroll(findScrollableView, view)) {
            return view;
        }
        smoothScrollToVisible(findScrollableView, view);
        return null;
    }

    private static View findTargetViewById(View view, String str, String str2, String str3) {
        int resourceId = getResourceId(view.getContext(), str, "id");
        if (resourceId == 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        findAllViewById(view, resourceId, 0, arrayMap);
        if (arrayMap.isEmpty()) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (Integer num : arrayMap.keySet()) {
            if (num.intValue() < i) {
                i = num.intValue();
            }
        }
        return filterPossibleTargetView((List) arrayMap.get(Integer.valueOf(i)), str3, str2, i);
    }

    private static void findAllViewById(View view, int i, int i2, ArrayMap<Integer, List<View>> arrayMap) {
        if (view.getId() == i) {
            List list = arrayMap.get(Integer.valueOf(i2));
            if (list == null) {
                list = new ArrayList();
                arrayMap.put(Integer.valueOf(i2), list);
            }
            list.add(view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    int i4 = i2 + 1;
                    findAllViewById(childAt, i, i4, arrayMap);
                    if (arrayMap.containsKey(Integer.valueOf(i4))) {
                        return;
                    }
                }
            }
        }
    }

    private static View findTargetViewByPath(View view, String str) {
        String[] split = str.split("/");
        for (int length = split.length - 1; length >= 0 && (view instanceof ViewGroup); length--) {
            ViewGroup viewGroup = (ViewGroup) view;
            String str2 = split[length];
            String[] split2 = str2.split(",");
            if (split2.length == 2) {
                int parseInt = Integer.parseInt(split2[0]);
                if (parseInt >= viewGroup.getChildCount()) {
                    return null;
                }
                view = viewGroup.getChildAt(parseInt);
            } else {
                try {
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt2 >= viewGroup.getChildCount()) {
                        return null;
                    }
                    view = viewGroup.getChildAt(parseInt2);
                } catch (Exception unused) {
                    view = findTargetViewById(viewGroup, str2, (String) null, (String) null);
                }
            }
        }
        return view;
    }

    private static ViewGroup findTargetViewContainer(ViewGroup viewGroup, String str, String str2) {
        String[] split = str.split("/");
        String[] split2 = str2.split(",");
        int length = split2.length / 2;
        int length2 = split.length - 1;
        ViewGroup viewGroup2 = viewGroup;
        while (length2 >= 0) {
            String str3 = split[length2];
            if (str3.equals("*")) {
                length--;
                if (length == 0) {
                    break;
                }
                str3 = split2[(length * 2) + 1];
            }
            try {
                int parseInt = Integer.parseInt(str3);
                if (parseInt >= viewGroup2.getChildCount()) {
                    return findPossibleContainerView(viewGroup);
                }
                View childAt = viewGroup2.getChildAt(parseInt);
                if (!(childAt instanceof ViewGroup)) {
                    return findPossibleContainerView(viewGroup);
                }
                viewGroup2 = (ViewGroup) childAt;
                length2--;
            } catch (Exception unused) {
                View findTargetViewById = findTargetViewById(viewGroup2, str3, (String) null, (String) null);
                if (findTargetViewById == null) {
                    return findPossibleContainerView(viewGroup);
                }
                if (!(findTargetViewById instanceof ViewGroup)) {
                    return findPossibleContainerView(viewGroup);
                }
                viewGroup2 = (ViewGroup) findTargetViewById;
            }
        }
        return ((viewGroup2 instanceof RecyclerView) || (viewGroup2 instanceof AbsListView) || (viewGroup2 instanceof ViewPager)) ? viewGroup2 : findPossibleContainerView(viewGroup);
    }

    private static ViewGroup findPossibleContainerView(ViewGroup viewGroup) {
        ViewGroup findPossibleContainerView;
        if ((viewGroup instanceof RecyclerView) || (viewGroup instanceof AbsListView) || (viewGroup instanceof ViewPager)) {
            return viewGroup;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && childAt.getVisibility() == 0 && (findPossibleContainerView = findPossibleContainerView((ViewGroup) childAt)) != null) {
                return findPossibleContainerView;
            }
        }
        return null;
    }

    private static View findItemViewByPositionOnScreen(ViewGroup viewGroup, int i) {
        int i2 = 0;
        if (viewGroup instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            if (i < recyclerView.getChildCount()) {
                return recyclerView.getChildAt(i);
            }
            while (i2 < recyclerView.getChildCount()) {
                View childAt = recyclerView.getChildAt(i2);
                if (i == recyclerView.getChildAdapterPosition(childAt)) {
                    return childAt;
                }
                i2++;
            }
            return null;
        } else if (viewGroup instanceof AbsListView) {
            AbsListView absListView = (AbsListView) viewGroup;
            if (i < absListView.getChildCount()) {
                return absListView.getChildAt(i);
            }
            while (i2 < absListView.getChildCount()) {
                View childAt2 = absListView.getChildAt(i2);
                Rect rect = new Rect();
                childAt2.getLocalVisibleRect(rect);
                if (i == absListView.pointToPosition(rect.centerX(), rect.centerY())) {
                    return childAt2;
                }
                i2++;
            }
            return null;
        } else if (!(viewGroup instanceof ViewPager)) {
            return null;
        } else {
            ViewPager viewPager = (ViewPager) viewGroup;
            if (i < viewPager.getChildCount() / 2) {
                return viewPager.getChildAt(i);
            }
            return viewPager.getChildAt(viewPager.getChildCount() / 2);
        }
    }

    private static View findItemViewByPosition(ViewGroup viewGroup, int i) {
        int i2 = 0;
        if (viewGroup instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) viewGroup;
            while (i2 < recyclerView.getChildCount()) {
                View childAt = recyclerView.getChildAt(i2);
                if (i == recyclerView.getChildAdapterPosition(childAt)) {
                    return childAt;
                }
                i2++;
            }
            return null;
        } else if (viewGroup instanceof ListView) {
            ListView listView = (ListView) viewGroup;
            while (i2 < listView.getChildCount()) {
                View childAt2 = listView.getChildAt(i2);
                Rect rect = new Rect();
                childAt2.getLocalVisibleRect(rect);
                if (i == listView.pointToPosition(rect.centerX(), rect.centerY())) {
                    return childAt2;
                }
                i2++;
            }
            return null;
        } else if (viewGroup instanceof AbsListView) {
            AbsListView absListView = (AbsListView) viewGroup;
            while (i2 < absListView.getChildCount()) {
                View childAt3 = absListView.getChildAt(i2);
                Rect rect2 = new Rect();
                childAt3.getLocalVisibleRect(rect2);
                if (i == absListView.pointToPosition(rect2.centerX(), rect2.centerY())) {
                    return childAt3;
                }
                i2++;
            }
            return null;
        } else if (!(viewGroup instanceof ViewPager)) {
            return null;
        } else {
            ViewPager viewPager = (ViewPager) viewGroup;
            viewPager.setCurrentItem(i);
            if (i < viewPager.getChildCount() / 2) {
                return viewPager.getChildAt(i);
            }
            return viewPager.getChildAt(viewPager.getChildCount() / 2);
        }
    }

    private static boolean hasViewReference(View view, String str) {
        String[] split = str.split("_&_");
        String str2 = split[split.length - 1];
        if (str2.startsWith("[r_image]") || str2.startsWith("[l_image]") || findTargetViewByReference(view, str2) == null) {
            return false;
        }
        return true;
    }

    private static View findTargetViewByReference(View view, String str) {
        View findTargetViewByReference;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0 && (findTargetViewByReference = findTargetViewByReference(childAt, str)) != null) {
                    return findTargetViewByReference;
                }
            }
            return null;
        } else if (!(view instanceof TextView)) {
            return null;
        } else {
            TextView textView = (TextView) view;
            if (textView.getText() == null || !str.equals(textView.getText().toString().trim())) {
                return null;
            }
            return view;
        }
    }

    public static View filterPossibleTargetView(List<View> list, String str, String str2, int i) {
        if (list != null) {
            if (list.size() == 1) {
                return list.get(0);
            }
            if (str != null) {
                View view = null;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    View view2 = list.get(i3);
                    if (hasViewReference(view2, str)) {
                        i2++;
                        view = view2;
                    }
                }
                if (i2 == 1) {
                    return view;
                }
            }
            if (str2 != null) {
                String[] split = str2.split("/");
                if (i < split.length) {
                    return list.get(Integer.parseInt(split[(split.length - i) - 1]));
                }
            }
        }
        return null;
    }

    public static EventInfo convertEventInfo(EventData eventData) {
        int indexOf;
        EventInfo eventInfo = new EventInfo();
        String unionId = eventData.getUnionId();
        eventInfo.originData = unionId;
        String[] split = unionId.split("_\\^_");
        HashMap<String, String> hashMap = new HashMap<>(split.length);
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && (indexOf = split[i].indexOf("_&_")) != -1) {
                hashMap.put(split[i].substring(0, indexOf), split[i].substring(indexOf + 3));
            }
        }
        if (hashMap.containsKey("w")) {
            String[] split2 = hashMap.get("w").split("_&_");
            if (split2.length > 1) {
                eventInfo.windowType = Integer.parseInt(split2[1]);
            } else {
                eventInfo.windowType = 1;
            }
        } else {
            eventInfo.windowType = 1;
        }
        if (!hashMap.containsKey("e")) {
            return null;
        }
        eventInfo.eventData = hashMap;
        eventInfo.eventType = Integer.parseInt(hashMap.get("e"));
        switch (eventInfo.eventType) {
            case 0:
                eventInfo.eventDesc = "点击";
                break;
            case 1:
                eventInfo.eventDesc = "返回";
                break;
            case 2:
                eventInfo.eventDesc = "退至后台";
                break;
            case 3:
                eventInfo.eventDesc = "进入前台";
                break;
            case 4:
                eventInfo.eventDesc = "弹出弹窗";
                break;
            case 5:
                eventInfo.eventDesc = "弹窗关闭";
                break;
            case 6:
                eventInfo.eventDesc = "页面跳转";
                break;
        }
        return eventInfo;
    }

    public static int getResourceId(Context context, String str, String str2) {
        if (str.endsWith("[01]")) {
            return context.getResources().getIdentifier(str.replace("[01]", ""), str2, "android");
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static boolean needScroll(View view, int i) {
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
            int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
            if (i < childLayoutPosition || i > childLayoutPosition2) {
                return true;
            }
            return false;
        } else if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            int lastVisiblePosition = absListView.getLastVisiblePosition();
            if (i < firstVisiblePosition || i > lastVisiblePosition) {
                return true;
            }
            return false;
        } else if (!(view instanceof ViewPager) || i == ((ViewPager) view).getCurrentItem()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean needScroll(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        return !new Rect(iArr2[0], iArr2[1], iArr2[0] + view.getWidth(), iArr2[1] + view.getHeight()).contains(rect);
    }

    private static View findScrollableView(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        while (!viewGroup.canScrollHorizontally(1) && !viewGroup.canScrollHorizontally(-1) && !viewGroup.canScrollVertically(1) && !viewGroup.canScrollVertically(-1)) {
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
                continue;
            } else {
                viewGroup = null;
                continue;
            }
            if (viewGroup == null) {
                break;
            }
        }
        return viewGroup;
    }

    public static void smoothScrollToPosition(View view, int i) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).smoothScrollToPosition(i);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollToPosition(i);
        } else if (view instanceof ViewPager) {
            ((ViewPager) view).setCurrentItem(i);
        }
    }

    public static void smoothScrollToVisible(View view, View view2) {
        int i;
        int i2;
        int i3;
        int i4;
        int width;
        if (!(view instanceof ViewPager)) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int i5 = 0;
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
            Rect rect2 = new Rect(iArr2[0], iArr2[1], iArr2[0] + view.getWidth(), iArr2[1] + view.getHeight());
            if (rect2.contains(rect)) {
                if (iArr[0] - iArr2[0] < view.getWidth() / 5) {
                    i = -(view.getWidth() / 5);
                } else {
                    i = iArr[0] - iArr2[0] > (view.getWidth() * 4) / 5 ? view.getWidth() / 5 : 0;
                }
                if (iArr[1] - iArr2[1] < view.getHeight() / 5) {
                    i5 = -(view.getHeight() / 5);
                } else if (iArr[1] - iArr2[1] > (view.getHeight() * 4) / 5) {
                    i5 = view.getHeight() / 5;
                }
            } else {
                if (rect2.intersect(rect)) {
                    if (iArr[0] - iArr2[0] < view.getWidth() / 5) {
                        i2 = -((iArr2[0] - iArr[0]) + (view.getWidth() / 5));
                    } else {
                        i2 = iArr[0] - iArr2[0] > (view.getWidth() * 4) / 5 ? ((iArr[0] - iArr2[0]) - view.getWidth()) + (view.getWidth() / 5) + view2.getWidth() : 0;
                    }
                    if (iArr[1] <= iArr2[1]) {
                        i5 = -((iArr2[1] - iArr[1]) + (view.getHeight() / 5));
                    } else if (iArr[1] > iArr2[1]) {
                        i4 = ((iArr[1] - iArr2[1]) - view.getHeight()) + (view.getHeight() / 5);
                        i3 = view2.getHeight();
                    }
                    i = i2;
                } else {
                    if (iArr[0] - iArr2[0] < 0) {
                        width = -((iArr[0] - iArr2[0]) + (view.getWidth() / 5) + view2.getWidth());
                    } else {
                        width = iArr[0] - iArr2[0] > view.getWidth() ? (iArr[0] - (iArr2[0] + view2.getWidth())) + (view.getWidth() / 5) + view2.getWidth() : 0;
                    }
                    if (iArr[1] + view2.getHeight() < iArr2[1]) {
                        i5 = -((iArr2[1] - iArr[1]) + (view.getWidth() / 5) + view2.getHeight());
                    } else if (iArr[1] > iArr2[1] + view.getHeight()) {
                        i4 = (iArr[1] - (iArr2[1] + view.getHeight())) + (view.getWidth() / 5);
                        i3 = view2.getHeight();
                    }
                    i = i2;
                }
                i5 = i4 + i3;
                i = i2;
            }
            smoothScrollBy(view, i, i5);
        }
    }

    private static void smoothScrollBy(View view, int i, int i2) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).smoothScrollBy(i, i2);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(i2, 100);
        } else if (view instanceof ScrollView) {
            ((ScrollView) view).smoothScrollBy(i, i2);
        } else {
            view.scrollBy(i, i2);
        }
    }

    public static View getClickableView(View view) {
        ViewParent parent = view.getParent();
        while (true) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.isClickable()) {
                return viewGroup;
            }
            parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return view;
            }
        }
    }

    public static String getClickInfo(EventInfo eventInfo) {
        String str = eventInfo.eventData.get("vr");
        if (TextUtils.isEmpty(str)) {
            str = eventInfo.eventData.get(PrismConstants.Symbol.VIEW_CLASS);
            if (TextUtils.isEmpty(str)) {
                return getClickInfoPossible(eventInfo);
            }
        }
        String[] split = str.split("_&_");
        if (split.length <= 0) {
            return "";
        }
        String str2 = split[0];
        if (str2.startsWith("[l_image]")) {
            return str2.replace("[l_image]", "");
        }
        return str2.startsWith("[r_image]") ? str2.replace("[r_image]", "") : str2;
    }

    private static String getClickInfoPossible(EventInfo eventInfo) {
        HashMap<String, String> hashMap = eventInfo.eventData;
        if (hashMap.containsKey("vi") && hashMap.containsKey("vq")) {
            int parseInt = Integer.parseInt(hashMap.get("vq"));
            String str = hashMap.get("vi");
            if (parseInt == 4) {
                if (str.contains("_back")) {
                    return "(左上角 返回)";
                }
                if (str.contains("_close")) {
                    return "(左上角 关闭)";
                }
            }
        }
        if (!hashMap.containsKey("vl")) {
            return "(无法识别)";
        }
        String str2 = hashMap.get("vl").split(":")[1].split(",")[0];
        return "(点击列表第 " + (Integer.parseInt(str2) + 1) + " 位)";
    }
}

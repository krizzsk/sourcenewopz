package com.didi.app.nova.skeleton.conductor.internal;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

public class TransitionUtils {
    public static void findNamedViews(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static View findNamedView(View view, String str) {
        if (str.equals(view.getTransitionName())) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findNamedView = findNamedView(viewGroup.getChildAt(i), str);
            if (findNamedView != null) {
                return findNamedView;
            }
        }
        return null;
    }

    public static void setEpicenter(Transition transition, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            transition.setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    public static void getBoundsOnScreen(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public static void setTargets(Transition transition, View view, List<View> list) {
        List<View> targets = transition.getTargets();
        targets.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m5599a(targets, list.get(i));
        }
        targets.add(view);
        list.add(view);
        addTargets(transition, list);
    }

    public static void addTargets(Transition transition, List<View> list) {
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i), list);
                    i++;
                }
            } else if (!hasSimpleTarget(transition) && m5600a(transition.getTargets())) {
                int size = list.size();
                while (i < size) {
                    transition.addTarget(list.get(i));
                    i++;
                }
            }
        }
    }

    public static void replaceTargets(Transition transition, List<View> list, List<View> list2) {
        List<View> targets;
        int i;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i2), list, list2);
                i2++;
            }
        } else if (!hasSimpleTarget(transition) && (targets = transition.getTargets()) != null && targets.size() == list.size() && targets.containsAll(list)) {
            if (list2 == null) {
                i = 0;
            } else {
                i = list2.size();
            }
            while (i2 < i) {
                transition.addTarget(list2.get(i2));
                i2++;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                transition.removeTarget(list.get(size));
            }
        }
    }

    /* renamed from: a */
    private static void m5599a(List<View> list, View view) {
        int size = list.size();
        if (!m5601a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m5601a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m5601a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSimpleTarget(Transition transition) {
        return !m5600a(transition.getTargetIds()) || !m5600a(transition.getTargetNames()) || !m5600a(transition.getTargetTypes());
    }

    /* renamed from: a */
    private static boolean m5600a(List list) {
        return list == null || list.isEmpty();
    }

    public static TransitionSet mergeTransitions(int i, Transition... transitionArr) {
        TransitionSet transitionSet = new TransitionSet();
        for (Transition transition : transitionArr) {
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
        }
        transitionSet.setOrdering(i);
        return transitionSet;
    }
}

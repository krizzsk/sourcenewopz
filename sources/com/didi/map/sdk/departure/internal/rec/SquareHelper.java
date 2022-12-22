package com.didi.map.sdk.departure.internal.rec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SquareHelper {

    /* renamed from: a */
    private static final double f28221a = 0.0d;

    public static void sortAndHideWithWeight(List<Square> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Square recommendMarkerWrapper : list) {
                arrayList.add(new RecommendMarkerWrapper(recommendMarkerWrapper));
            }
            Collections.sort(arrayList, new Comparator<RecommendMarkerWrapper>() {
                public int compare(RecommendMarkerWrapper recommendMarkerWrapper, RecommendMarkerWrapper recommendMarkerWrapper2) {
                    Square target = recommendMarkerWrapper.getTarget();
                    Square target2 = recommendMarkerWrapper2.getTarget();
                    if ((target instanceof RecMarkerImpl) && (target2 instanceof RecMarkerImpl)) {
                        if (((RecMarkerImpl) target2).isInCenter()) {
                            return 1;
                        }
                        if (((RecMarkerImpl) target).isInCenter() || target.getWidth() > target2.getWidth()) {
                            return -1;
                        }
                        if (target.getWidth() < target2.getWidth()) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            for (int i = 0; i < arrayList.size(); i++) {
                ArrayList arrayList2 = new ArrayList();
                RecommendMarkerWrapper recommendMarkerWrapper2 = (RecommendMarkerWrapper) arrayList.get(i);
                arrayList2.add(recommendMarkerWrapper2);
                if (!recommendMarkerWrapper2.mIsDuplicate) {
                    for (int i2 = i + 1; i2 < arrayList.size(); i2++) {
                        RecommendMarkerWrapper recommendMarkerWrapper3 = (RecommendMarkerWrapper) arrayList.get(i2);
                        if (!recommendMarkerWrapper3.mIsDuplicate && recommendMarkerWrapper2.isCollision(recommendMarkerWrapper3, 0.0d)) {
                            arrayList2.add(recommendMarkerWrapper3);
                        }
                    }
                }
                if (arrayList2.size() > 1) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        RecommendMarkerWrapper recommendMarkerWrapper4 = (RecommendMarkerWrapper) arrayList2.get(i3);
                        Square target = recommendMarkerWrapper4.getTarget();
                        if (target instanceof RecMarkerImpl) {
                            if (i3 == 0) {
                                ((RecMarkerImpl) target).visible(true);
                            } else {
                                recommendMarkerWrapper4.mIsDuplicate = true;
                                ((RecMarkerImpl) target).visible(false);
                            }
                        }
                    }
                } else {
                    RecommendMarkerWrapper recommendMarkerWrapper5 = (RecommendMarkerWrapper) arrayList2.get(0);
                    if (!recommendMarkerWrapper5.mIsDuplicate) {
                        Square target2 = recommendMarkerWrapper5.getTarget();
                        if (target2 instanceof RecMarkerImpl) {
                            ((RecMarkerImpl) target2).visible(true);
                        }
                    }
                }
            }
        }
    }
}

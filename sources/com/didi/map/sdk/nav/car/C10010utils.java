package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import java.util.List;

/* renamed from: com.didi.map.sdk.nav.car.utils */
public class C10010utils {
    public static double angle2Rad(double d) {
        return d * 0.017453292519943295d;
    }

    public static float getReviseRotate(float f, float f2) {
        return ((double) (f - f2)) > 180.0d ? f2 + 360.0f : f2;
    }

    public static double getRouteLength(List<LatLng> list) {
        double d = 0.0d;
        if (list != null && list.size() > 1) {
            int i = 0;
            while (i < list.size() - 1) {
                i++;
                d += DDSphericalUtil.computeDistanceBetween(list.get(i), list.get(i));
            }
        }
        return d;
    }

    /* renamed from: a */
    private static float m20120a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        return (float) (90.0d - ((Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d) * 180.0d));
    }

    public static HeadingStatus getHeadingOfAnimate(List<LatLng> list, LatLng latLng, AnimationPartNode animationPartNode, boolean z) {
        double d;
        boolean z2;
        HeadingStatus headingStatus = new HeadingStatus();
        if (list == null) {
            if (latLng == null || animationPartNode == null || animationPartNode.latLng == null) {
                headingStatus.success = false;
            } else if (DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng) < 1.0d) {
                headingStatus.success = false;
                return headingStatus;
            } else {
                headingStatus.heading = (double) m20120a(latLng, animationPartNode.latLng);
                headingStatus.success = true;
            }
            return headingStatus;
        } else if (animationPartNode == null || animationPartNode.latLng == null || latLng == null) {
            headingStatus.success = false;
            DLog.m7384d("getHeadingOfAnimate", "参数错误", new Object[0]);
            return headingStatus;
        } else {
            double d2 = 0.0d;
            if (animationPartNode.index < 0 || animationPartNode.index + 1 >= list.size()) {
                if (animationPartNode.index < 1 || animationPartNode.index + 1 != list.size()) {
                    if (animationPartNode.index != -1) {
                        headingStatus.success = false;
                        return headingStatus;
                    } else if (DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng) < 1.0d) {
                        headingStatus.success = false;
                        return headingStatus;
                    } else {
                        d = (double) m20120a(latLng, animationPartNode.latLng);
                    }
                } else if (animationPartNode.type != AnimateNodeStatus.TO_ROAD) {
                    d = DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng);
                    if (d < 1.0d) {
                        headingStatus.success = false;
                        return headingStatus;
                    }
                } else if (z) {
                    d = DDSphericalUtil.computeDistanceBetween(list.get(animationPartNode.index - 1), animationPartNode.latLng);
                    if (d < 1.0d) {
                        headingStatus.success = false;
                        return headingStatus;
                    }
                } else {
                    d = DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng);
                    if (d < 1.0d) {
                        headingStatus.success = false;
                        return headingStatus;
                    }
                }
            } else if (animationPartNode.type != AnimateNodeStatus.TO_ROAD) {
                if (DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng) > 1.0d) {
                    d2 = DDSphericalUtil.computeHeading(latLng, animationPartNode.latLng);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    headingStatus.success = false;
                    return headingStatus;
                }
                d = d2;
            } else if (z) {
                if (DDSphericalUtil.computeDistanceBetween(animationPartNode.latLng, list.get(animationPartNode.index + 1)) < 1.0d) {
                    headingStatus.success = true;
                    headingStatus.heading = DDSphericalUtil.computeHeading(animationPartNode.latLng, list.get(animationPartNode.index + 1));
                    return headingStatus;
                }
                d = DDSphericalUtil.computeHeading(animationPartNode.latLng, list.get(animationPartNode.index + 1));
            } else if (DDSphericalUtil.computeDistanceBetween(latLng, animationPartNode.latLng) < 1.0d) {
                headingStatus.success = false;
                return headingStatus;
            } else {
                d = DDSphericalUtil.computeHeading(latLng, animationPartNode.latLng);
            }
            headingStatus.success = true;
            headingStatus.heading = d;
            return headingStatus;
        }
    }

    public static double getOnRoadDistance(List<LatLng> list, AnimateNode animateNode, AnimateNode animateNode2) {
        if (animateNode == null || animateNode2 == null || list == null || list.size() < animateNode2.index + 1) {
            return -1.0d;
        }
        if (animateNode.index == animateNode2.index) {
            return DDSphericalUtil.computeDistanceBetween(animateNode.latLng, animateNode2.latLng);
        }
        if (animateNode.index > animateNode2.index) {
            return -1.0d;
        }
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(animateNode.latLng, list.get(animateNode.index + 1));
        if (animateNode.index + 1 < animateNode2.index) {
            int i = animateNode.index + 1;
            while (i < animateNode2.index) {
                i++;
                computeDistanceBetween += DDSphericalUtil.computeDistanceBetween(list.get(i), list.get(i));
            }
        }
        return animateNode2.offSet > 0 ? computeDistanceBetween + DDSphericalUtil.computeDistanceBetween(list.get(animateNode2.index), animateNode2.latLng) : computeDistanceBetween;
    }
}

package com.didi.addressnew.framework.fragmentmarket;

import android.os.Bundle;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx;
import com.didi.addressnew.framework.fragmentmarket.endconfirm.EndConfirmFragment;
import com.didi.addressnew.framework.fragmentmarket.favorite.EditFavoriteFragment;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteFragment;
import com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapPoiSelectFragment;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapWayPointFragment;
import com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchFragment;
import com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx;
import com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx;
import com.didi.addressnew.framework.fragmentmarket.openride.OpenRideWayPointFragment;
import com.didi.addressnew.framework.fragmentmarket.setting.SettingFragment;
import com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx;
import java.util.HashMap;

public class FragmentFactory {

    /* renamed from: a */
    private static final String f4329a = "KEY_PARAM";

    /* renamed from: b */
    private static final String f4330b = "KEY_TYPE";

    /* renamed from: c */
    private HashMap<FragmentType, IFragment> f4331c = new HashMap<>(5);

    public enum FragmentType {
        FULL,
        CONFIRM_NEW,
        SINGLE,
        WAYPOINT,
        MAPSELECT,
        MAPCONFIRM,
        FAVORITE,
        EDIT_FAVORITE,
        SETTING,
        OPEN_RIDE,
        OPEN_RIDE_ROUTE_EDIT,
        OPEN_RIDE_CONFIRM,
        OTHER,
        SWITCHBACK,
        END_CONFIRM
    }

    public IFragment generateIFragment(FragmentType fragmentType, SugParams sugParams, Bundle bundle) {
        return generateIFragment(fragmentType, sugParams, -1, bundle);
    }

    public IFragment generateIFragment(FragmentType fragmentType, SugParams sugParams, int i, Bundle bundle) {
        IFragment iFragment;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putSerializable("KEY_PARAM", sugParams);
        bundle2.putSerializable("KEY_TYPE", Integer.valueOf(i));
        switch (C22461.f4332x78040b85[fragmentType.ordinal()]) {
            case 1:
                iFragment = new FullFragmentEx();
                break;
            case 2:
                iFragment = new ConfirmFragmentEx();
                break;
            case 3:
                iFragment = new SingleFragmentEx();
                break;
            case 4:
                iFragment = new SugMapWayPointFragment();
                iFragment.setParentNodeType(IFragment.ParentNode.WAYPOINT);
                break;
            case 5:
                iFragment = new SugMapPoiSelectFragment();
                break;
            case 6:
                iFragment = new FuzzyMatchFragment();
                break;
            case 7:
                iFragment = new FavoriteFragment();
                iFragment.setParentNodeType(IFragment.ParentNode.FAV);
                break;
            case 8:
                iFragment = new EditFavoriteFragment();
                break;
            case 9:
                iFragment = new SettingFragment();
                iFragment.setParentNodeType(IFragment.ParentNode.SETTING);
                break;
            case 10:
                iFragment = new OpenRideFragmentEx();
                iFragment.setParentNodeType(IFragment.ParentNode.FULL);
                break;
            case 11:
                iFragment = new OpenRideWayPointFragment();
                iFragment.setParentNodeType(IFragment.ParentNode.WAYPOINT);
                break;
            case 12:
                iFragment = new OpenRideConfirmFragmentEx();
                iFragment.setParentNodeType(IFragment.ParentNode.FULL);
                break;
            case 13:
                iFragment = new EndConfirmFragment();
                break;
            default:
                iFragment = null;
                break;
        }
        if (iFragment == null) {
            return null;
        }
        iFragment.getFragment().setArguments(bundle2);
        return iFragment;
    }

    /* renamed from: com.didi.addressnew.framework.fragmentmarket.FragmentFactory$1 */
    static /* synthetic */ class C22461 {

        /* renamed from: $SwitchMap$com$didi$addressnew$framework$fragmentmarket$FragmentFactory$FragmentType */
        static final /* synthetic */ int[] f4332x78040b85;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType[] r0 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4332x78040b85 = r0
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.FULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.CONFIRM_NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.SINGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.MAPSELECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.MAPCONFIRM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.FAVORITE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.EDIT_FAVORITE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.SETTING     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.OPEN_RIDE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.OPEN_RIDE_ROUTE_EDIT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.OPEN_RIDE_CONFIRM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f4332x78040b85     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.addressnew.framework.fragmentmarket.FragmentFactory$FragmentType r1 = com.didi.addressnew.framework.fragmentmarket.FragmentFactory.FragmentType.END_CONFIRM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.framework.fragmentmarket.FragmentFactory.C22461.<clinit>():void");
        }
    }
}

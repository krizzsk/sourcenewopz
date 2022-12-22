package global.didi.pay.select.view.other;

import global.didi.pay.select.model.PayMethodItemInfo;
import java.util.List;

public class ExpandShrinkViewHelper {
    public static int getMaxDisplayCardIndex(List<PayMethodItemInfo> list, boolean z) {
        int cardSize = z ? getCardSize(list) : getShrinkCardSize(list);
        int i = 0;
        int i2 = 0;
        for (PayMethodItemInfo payMethodItemInfo : list) {
            if (payMethodItemInfo.channelId == 150) {
                i++;
            }
            if (i > cardSize) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static boolean isShowSwitchView(List<PayMethodItemInfo> list) {
        return list.size() > 6 && getCardSize(list) > 1;
    }

    private static int getCardSize(List<PayMethodItemInfo> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (PayMethodItemInfo next : list) {
            if (next != null && next.channelId == 150) {
                i++;
            }
        }
        return Math.max(i - 1, 0);
    }

    private static int getShrinkCardSize(List<PayMethodItemInfo> list) {
        int i;
        if (isShowSwitchView(list)) {
            i = 6 - (list.size() - getCardSize(list));
        } else {
            i = getCardSize(list);
        }
        return Math.max(0, i);
    }
}

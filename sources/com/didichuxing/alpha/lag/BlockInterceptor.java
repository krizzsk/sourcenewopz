package com.didichuxing.alpha.lag;

import android.content.Context;
import com.didichuxing.alpha.lag.internal.BlockInfo;

interface BlockInterceptor {
    void onBlock(Context context, BlockInfo blockInfo);
}

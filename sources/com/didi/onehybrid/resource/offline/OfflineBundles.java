package com.didi.onehybrid.resource.offline;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OfflineBundles {
    @SerializedName("modules")
    public List<OfflineBundle> packages;
}

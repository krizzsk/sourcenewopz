package com.facebook.bolts;

import android.net.Uri;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/facebook/bolts/AppLinkResolver;", "", "getAppLinkFromUrlInBackground", "Lcom/facebook/bolts/Task;", "Lcom/facebook/bolts/AppLink;", "url", "Landroid/net/Uri;", "facebook-bolts_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppLinkResolver.kt */
public interface AppLinkResolver {
    Task<AppLink> getAppLinkFromUrlInBackground(Uri uri);
}

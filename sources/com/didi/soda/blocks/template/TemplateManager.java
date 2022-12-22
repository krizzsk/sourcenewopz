package com.didi.soda.blocks.template;

import android.text.TextUtils;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.entity.WidgetNodeEntity;
import com.didi.soda.blocks.model.TemplateModel;
import com.didi.soda.blocks.parse.Peer;
import com.didi.soda.blocks.parse.PeerDiffMapper;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.blocks.track.BlocksTrackHelper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u0011\u001a\u00020\u000e2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014`\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/blocks/template/TemplateManager;", "", "()V", "peer", "Lcom/didi/soda/blocks/parse/Peer;", "getPeer", "()Lcom/didi/soda/blocks/parse/Peer;", "setPeer", "(Lcom/didi/soda/blocks/parse/Peer;)V", "templatesMap", "", "", "Lcom/didi/soda/blocks/model/TemplateModel;", "attachPeer", "", "getTemplateById", "templateId", "initTemplate", "templates", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/entity/Template;", "Lkotlin/collections/ArrayList;", "isTemplateIdEffective", "", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TemplateManager.kt */
public final class TemplateManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "TemplateManager";
    public Peer peer;
    private final Map<String, TemplateModel> templatesMap = new LinkedHashMap();

    public final Peer getPeer() {
        Peer peer2 = this.peer;
        if (peer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peer");
        }
        return peer2;
    }

    public final void setPeer(Peer peer2) {
        Intrinsics.checkParameterIsNotNull(peer2, "<set-?>");
        this.peer = peer2;
    }

    public final void attachPeer(Peer peer2) {
        Intrinsics.checkParameterIsNotNull(peer2, "peer");
        this.peer = peer2;
    }

    public final void initTemplate(ArrayList<Template> arrayList) {
        WidgetNodeEntity widgetNodeEntity;
        WidgetNodeEntity widgetNodeEntity2;
        Intrinsics.checkParameterIsNotNull(arrayList, "templates");
        Iterator<Template> it = arrayList.iterator();
        while (it.hasNext()) {
            Template next = it.next();
            TemplateModel templateModel = new TemplateModel();
            String str = "";
            if (!TextUtils.isEmpty(next != null ? next.getTmplId() : null)) {
                if (!TextUtils.isEmpty(next != null ? next.getContent() : null)) {
                    String tmplId = next != null ? next.getTmplId() : null;
                    if (tmplId == null) {
                        Intrinsics.throwNpe();
                    }
                    templateModel.setTemplateId(tmplId);
                    try {
                        widgetNodeEntity2 = (WidgetNodeEntity) new Gson().fromJson(next.getContent(), WidgetNodeEntity.class);
                    } catch (Exception e) {
                        BlocksTrackHelper.Companion.trackComponetFormatError(next.getTmplId());
                        IBlocksLogger logger = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                        if (logger != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Incorrect template format,which id is ");
                            sb.append(next.getTemplateId());
                            sb.append(' ');
                            sb.append(", error message is ");
                            sb.append(e.getMessage());
                            sb.append(",caused by ");
                            Throwable cause = e.getCause();
                            String message = cause != null ? cause.getMessage() : null;
                            if (message != null) {
                                str = message;
                            }
                            sb.append(str);
                            logger.error(TAG, sb.toString());
                        }
                        widgetNodeEntity2 = null;
                    }
                    templateModel.setTemplateInterface(widgetNodeEntity2);
                    if (templateModel.getTemplateInterface() == null) {
                        IBlocksLogger logger2 = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                        if (logger2 != null) {
                            logger2.error(TAG, "Incorrect template format,which id is " + next.getTemplateId());
                        }
                    } else {
                        templateModel.setTemplateVersion(next.getVersion());
                        this.templatesMap.put(next.getTmplId(), templateModel);
                    }
                }
            }
            if (!TextUtils.isEmpty(next != null ? next.getTemplateId() : null)) {
                if ((next != null ? next.getComponentsTree() : null) != null) {
                    String templateId = next != null ? next.getTemplateId() : null;
                    if (templateId == null) {
                        Intrinsics.throwNpe();
                    }
                    templateModel.setTemplateId(templateId);
                    JsonElement componentsTree = next.getComponentsTree();
                    if (componentsTree == null) {
                        Intrinsics.throwNpe();
                    }
                    if (componentsTree.isJsonObject()) {
                        try {
                            Gson gson = new Gson();
                            JsonElement componentsTree2 = next.getComponentsTree();
                            if (componentsTree2 != null) {
                                widgetNodeEntity = (WidgetNodeEntity) gson.fromJson((JsonElement) (JsonObject) componentsTree2, WidgetNodeEntity.class);
                                templateModel.setTemplateInterface(widgetNodeEntity);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonObject");
                            }
                        } catch (Exception e2) {
                            BlocksTrackHelper.Companion.trackComponetFormatError(next.getTemplateId());
                            IBlocksLogger logger3 = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                            if (logger3 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Incorrect template format,which id is ");
                                sb2.append(next.getTemplateId());
                                sb2.append(' ');
                                sb2.append(", error message is ");
                                sb2.append(e2.getMessage());
                                sb2.append(",caused by ");
                                Throwable cause2 = e2.getCause();
                                String message2 = cause2 != null ? cause2.getMessage() : null;
                                if (message2 != null) {
                                    str = message2;
                                }
                                sb2.append(str);
                                logger3.error(TAG, sb2.toString());
                            }
                            widgetNodeEntity = null;
                        }
                    } else {
                        try {
                            Gson gson2 = new Gson();
                            JsonElement componentsTree3 = next.getComponentsTree();
                            if (componentsTree3 != null) {
                                templateModel.setTemplateInterface((WidgetNodeEntity) gson2.fromJson(((JsonPrimitive) componentsTree3).getAsString(), WidgetNodeEntity.class));
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.google.gson.JsonPrimitive");
                            }
                        } catch (Exception e3) {
                            BlocksTrackHelper.Companion.trackComponetFormatError(next.getTemplateId());
                            IBlocksLogger logger4 = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                            if (logger4 != null) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Incorrect template format,which id is ");
                                sb3.append(next.getTemplateId());
                                sb3.append(' ');
                                sb3.append(", error message is ");
                                sb3.append(e3.getMessage());
                                sb3.append(",caused by ");
                                Throwable cause3 = e3.getCause();
                                String message3 = cause3 != null ? cause3.getMessage() : null;
                                if (message3 != null) {
                                    str = message3;
                                }
                                sb3.append(str);
                                logger4.error(TAG, sb3.toString());
                            }
                        }
                    }
                    if (templateModel.getTemplateInterface() == null) {
                        IBlocksLogger logger5 = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getLogger();
                        if (logger5 != null) {
                            logger5.error(TAG, "Incorrect template format,which id is " + next.getTemplateId());
                        }
                    } else {
                        PeerDiffMapper.Companion companion = PeerDiffMapper.Companion;
                        WidgetNodeEntity templateInterface = templateModel.getTemplateInterface();
                        if (templateInterface == null) {
                            Intrinsics.throwNpe();
                        }
                        Peer peer2 = this.peer;
                        if (peer2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("peer");
                        }
                        companion.map(templateInterface, peer2);
                        Peer peer3 = this.peer;
                        if (peer3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("peer");
                        }
                        templateModel.setPeer(peer3.copy().mergeWithPlatformConfig(next.getPeer()));
                        templateModel.setTemplateVersion(next.getVersion());
                        this.templatesMap.put(next.getTemplateId(), templateModel);
                    }
                }
            }
            BlocksTrackHelper.Companion.trackTemplateFormatError(next);
        }
    }

    public final boolean isTemplateIdEffective(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        TemplateModel templateById = getTemplateById(str);
        if ((templateById != null ? templateById.getTemplateInterface() : null) != null) {
            return true;
        }
        return false;
    }

    public final TemplateModel getTemplateById(String str) {
        return this.templatesMap.get(str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/template/TemplateManager$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TemplateManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

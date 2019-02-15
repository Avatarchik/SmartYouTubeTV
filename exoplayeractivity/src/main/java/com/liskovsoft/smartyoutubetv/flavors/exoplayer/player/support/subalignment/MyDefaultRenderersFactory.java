package com.liskovsoft.smartyoutubetv.flavors.exoplayer.player.support;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.liskovsoft.smartyoutubetv.flavors.exoplayer.player.support.subalignment.TextRendererDecorator;

/**
 * My wrapper<br/>
 * Main intent: fix subtitle alignment on some videos
 */
public class MyDefaultRenderersFactory extends DefaultRenderersFactory {
    public MyDefaultRenderersFactory(FragmentActivity activity) {
        super(activity);
    }

    @Override
    public Renderer[] createRenderers(Handler eventHandler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textRendererOutput, MetadataOutput metadataRendererOutput, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        textRendererOutput = new TextRendererDecorator(textRendererOutput);

        return super.createRenderers(
                eventHandler,
                videoRendererEventListener,
                audioRendererEventListener,
                textRendererOutput,
                metadataRendererOutput,
                drmSessionManager
        );
    }
}
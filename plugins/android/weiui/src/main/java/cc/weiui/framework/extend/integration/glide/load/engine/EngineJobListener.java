package cc.weiui.framework.extend.integration.glide.load.engine;

import cc.weiui.framework.extend.integration.glide.load.Key;

interface EngineJobListener {

  void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> resource);

  void onEngineJobCancelled(EngineJob<?> engineJob, Key key);
}

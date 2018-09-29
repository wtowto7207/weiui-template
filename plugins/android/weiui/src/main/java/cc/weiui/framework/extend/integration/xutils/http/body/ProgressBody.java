package cc.weiui.framework.extend.integration.xutils.http.body;


import cc.weiui.framework.extend.integration.xutils.http.ProgressHandler;

/**
 * Created by wyouflf on 15/8/13.
 */
public interface ProgressBody extends RequestBody {
    void setProgressHandler(ProgressHandler progressHandler);
}

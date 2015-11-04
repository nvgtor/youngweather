package app.nvgtor.com.youngweather.util;

/**
 * Created by nvgtor on 2015/11/4.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}

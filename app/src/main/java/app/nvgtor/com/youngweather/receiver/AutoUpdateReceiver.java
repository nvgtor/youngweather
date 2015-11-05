package app.nvgtor.com.youngweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import app.nvgtor.com.youngweather.service.AutoUpdateService;

/**
 * Created by nvgtor on 2015/11/5.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}

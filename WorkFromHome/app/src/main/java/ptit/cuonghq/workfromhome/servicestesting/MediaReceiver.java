package ptit.cuonghq.hny.servicestesting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static ptit.cuonghq.hny.servicestesting.MusicService.CHANGE_STATE;

public class MediaReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (CHANGE_STATE.equalsIgnoreCase(intent.getAction())) {
            Log.d("abc", "xzy");

            Intent intent1 = new Intent("notification-event");
            intent1.putExtra("change", true);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent1);
        }
    }
}

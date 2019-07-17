package ptit.cuonghq.hny.servicestesting;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.IOException;

import ptit.cuonghq.hny.R;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer player;
    private final IBinder musicBind = new MusicBinder();
    private int src;
    private boolean finish;

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();
        initMusicPlayer();
    }

    private void initMusicPlayer() {
        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
        finish = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        LocalBroadcastManager.getInstance(this).registerReceiver(mNotificationReceiver, new IntentFilter("notification-event"));
        return musicBind;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        finish = true;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        finish = false;
    }

    public void setSong(int nhat) {

    }

    public void playSong() {

    }

    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        player.release();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mNotificationReceiver);
        return false;
    }

    public static final String CHANGE_STATE = "ptit.cuonghq.hny.change";

    RemoteViews notificationLayout;
    NotificationManager manager;
    Notification notification;

    public void changeMusicState() {
        if (!player.isPlaying()) {
            if (finish) {
                try {
                    player.setDataSource(getApplicationContext(), Uri.parse("android.resource://ptit.cuonghq.hny/raw/nhat"));
                    Intent intent = new Intent("custom-event-name");
                    intent.putExtra("play", true);
                    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

                } catch (IOException e) {
                    Log.e("MUSIC SERVICE", "Error setting data source", e);
                }
                player.prepareAsync();

                notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_layout);

                Intent intent = new Intent(getApplicationContext(), MediaReceiver.class);
                intent.setAction(CHANGE_STATE);
                PendingIntent pIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notificationLayout.setImageViewResource(R.id.btn_play,  R.drawable.ic_pause_black_24dp);
                notificationLayout.setOnClickPendingIntent(R.id.btn_play, pIntent);

                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notification = new NotificationCompat.Builder(getBaseContext(), "Channel2")
                        .setSmallIcon(R.drawable.ic_camera_alt_black_24dp)
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                        .setCustomContentView(notificationLayout)
                        .setContentIntent(null)
                        .build();
                notification.flags |= Notification.FLAG_AUTO_CANCEL;

                manager.notify(1004, notification);

            } else {
                player.start();
                if (notificationLayout != null) {
                    notificationLayout.setImageViewResource(R.id.btn_play,  R.drawable.ic_pause_black_24dp);
                }
                Intent intent = new Intent("custom-event-name");
                intent.putExtra("play", true);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            }
        } else {
            player.pause();
            if (notificationLayout != null) {
                notificationLayout.setImageViewResource(R.id.btn_play,  R.drawable.ic_play_arrow_black_24dp);
            }

            Intent intent = new Intent("custom-event-name");
            intent.putExtra("play", false);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    private BroadcastReceiver mNotificationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            boolean isPlayed = intent.getBooleanExtra("play", false);
            changeMusicState();
            manager.notify(1004, notification);
        }
    };

}



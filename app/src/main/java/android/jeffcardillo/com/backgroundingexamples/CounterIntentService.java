package android.jeffcardillo.com.backgroundingexamples;

import android.app.IntentService;
import android.content.Intent;

public class CounterIntentService extends IntentService {

    public CounterIntentService() {
        super("CounterIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int startValue = intent.getIntExtra("TIMER_START", 10);
        int i;

        for (i = startValue; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // broadcast the updated counter value.
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("android.jeffcardillo.com.backgroundingexamples.counterprogress");
            broadcastIntent.putExtra("COUNTER", i);
            sendBroadcast(broadcastIntent);
        }
    }
}

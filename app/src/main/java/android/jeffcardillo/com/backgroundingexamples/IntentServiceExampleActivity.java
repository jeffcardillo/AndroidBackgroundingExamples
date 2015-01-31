package android.jeffcardillo.com.backgroundingexamples;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;


public class IntentServiceExampleActivity extends Activity {

    private TextView counterTextView;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_example);

        TextView titleLabel = (TextView) findViewById(R.id.title);
        titleLabel.setText("IntentService Example");

        counterTextView = (TextView) findViewById(R.id.counterText);
    }

    @Override
    public void onStart() {
        super.onStart();

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int counter = intent.getIntExtra("COUNTER", 0);
                counterTextView.setText("" + counter);
            }
        };

        IntentFilter filter = new IntentFilter("android.jeffcardillo.com.backgroundingexamples.counterprogress");
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    public void onResume() {
        super.onResume();

        startCounter();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        unregisterReceiver(broadcastReceiver);
    }


    public void startCounter() {
        Intent counterIntent = new Intent(this, CounterIntentService.class);
        counterIntent.putExtra("TIMER_START", 10);
        startService(counterIntent);
    }
}
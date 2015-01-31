package android.jeffcardillo.com.backgroundingexamples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class JavaThreadExampleActivity extends Activity {

    private Handler handler;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_thread_example);

        TextView titleLabel = (TextView) findViewById(R.id.title);
        titleLabel.setText("Java Thread Example");

        counterTextView = (TextView) findViewById(R.id.counterText);

        handler = new Handler();
    }

    @Override
    public void onResume() {
        super.onResume();

        startCounter();
    }

    public void startCounter() {
        new Thread(new CounterTask()).start();
    }

    class CounterTask implements Runnable {
        @Override
        public void run() {
            for (int i = 10; i >= 0; i--) {
                final int value = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        counterTextView.setText("" + value);
                    }
                });
            }
        }
    }
}

package android.jeffcardillo.com.backgroundingexamples;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;


public class AsyncTaskExampleActivity extends Activity {

    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example);

        TextView titleLabel = (TextView) findViewById(R.id.title);
        titleLabel.setText("AsyncTask Example");

        counterTextView = (TextView) findViewById(R.id.counterText);
    }

    @Override
    public void onResume() {
        super.onResume();

        startCounter();
    }

    public void startCounter() {
        new CounterTask().execute(10);
    }

    private class CounterTask extends AsyncTask<Integer, Integer, Integer> {
        protected Integer doInBackground(Integer... params) {

            int startValue = params[0];
            int i;

            for (i = startValue; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }

            return 0;
        }

        protected void onProgressUpdate(Integer... progress) {
            counterTextView.setText("" + progress[0]);
        }

        protected void onPostExecute(Integer result) {
            counterTextView.setText("" + result);
        }
    }
}

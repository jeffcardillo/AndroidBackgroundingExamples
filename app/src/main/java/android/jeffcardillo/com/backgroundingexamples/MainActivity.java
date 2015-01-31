package android.jeffcardillo.com.backgroundingexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button javaThreadButton = (Button) findViewById(R.id.btn_javathread);
        javaThreadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JavaThreadExampleActivity.class);
                startActivity(intent);
            }
        });

        Button asyncTaskButton = (Button) findViewById(R.id.btn_asynctask);
        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AsyncTaskExampleActivity.class);
                startActivity(intent);
            }
        });

        Button intentServiceButton = (Button) findViewById(R.id.btn_intentservice);
        intentServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntentServiceExampleActivity.class);
                startActivity(intent);
            }
        });
    }
}
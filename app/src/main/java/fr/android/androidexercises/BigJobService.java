package fr.android.androidexercises;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Kepa on 10/11/2017.
 */

public class BigJobService extends IntentService {

    public BigJobService() {
        super(BigJobService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long endTime = System.currentTimeMillis() + 5 * 1000;

        try {
            wait(endTime);


        } catch (InterruptedException ignore) {

        }
        Toast.makeText(this, "laaaag", Toast.LENGTH_SHORT).show();

    }
}

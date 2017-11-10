package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step0Fragment(),Step0Fragment.class.getSimpleName())
                .commit();
        // TODO replace Step0Fragment in containerFrameLayout
    }

    @Override
    public void onNext() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, new Step0Fragment(),Step0Fragment.class.getSimpleName())
                .addToBackStack("COUCOU")
                .commit();
        // TODO replace Step1Fragment in containerFrameLayout
    }

}

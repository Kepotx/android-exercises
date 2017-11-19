package kbourgoin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class LibraryActivity extends AppCompatActivity implements BookListFragment.OnBookClickedListener {

    private Book book = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, new BookListFragment(), BookListFragment.class.getSimpleName())
                .commit();

        if(savedInstanceState != null && !isPortrait(getApplicationContext())){
            this.book = savedInstanceState.getParcelable("BOOK");
            findBookInformations();
        }
    }

    @Override
    public void onBookClicked(Book book) {
        this.book = book;
        findBookInformations();
    }

    void findBookInformations() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BOOK", this.book);
        BookDetailsFragment fragmentDetails = new BookDetailsFragment();
        fragmentDetails.setArguments(bundle);

        if (isPortrait(getApplicationContext())) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containerFrameLayout, fragmentDetails, BookDetailsFragment.class.getSimpleName())
                    .addToBackStack("details")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailsFrameLayout, fragmentDetails, BookDetailsFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Check if device is in portrait mode
    public static boolean isPortrait(Context context) {
        return context.getResources().getBoolean(R.bool.isPortrait);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("BOOK", this.book);
    }

}

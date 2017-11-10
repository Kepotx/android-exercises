package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.view.LayoutInflater
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*


class LibraryActivity : AppCompatActivity() {

    private val RANDOM = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val books = getBooks()

        //val isLandscape = resources.getBoolean(R.bool.landscape)
        val isLandscape = true
        val recyclerView:RecyclerView  = findViewById(R.id.bookListView)
        recyclerView.setLayoutManager(GridLayoutManager(this, if (isLandscape) 2 else 1))
        recyclerView.setAdapter(BookAdapter2(LayoutInflater.from(this), getBooks(), R.layout.custom_view_item_book))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_library, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) true else super.onOptionsItemSelected(item)
    }

    private fun getBooks(): List<Book> {
        val books = ArrayList<Book>()
        for (i in 0..99) {
            books.add(Book(
                    String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                    RANDOM.nextInt(30).toFloat())
            )
        }
        return books
    }
}

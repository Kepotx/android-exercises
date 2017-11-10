package fr.android.androidexercises

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


class BookAdapter(context: Context, private val books: List<Book>) : BaseAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return books.size

    }

    override fun getItem(position: Int): Book {
        return books[position]

    }

    override fun getItemId(position: Int): Long {
        return books[position].hashCode().toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_view_item_book, parent, false)
        }
        val bookItemView = convertView as BookItemView?
        val book = books[position]
        bookItemView!!.bindView(book)
        return bookItemView

    }

}
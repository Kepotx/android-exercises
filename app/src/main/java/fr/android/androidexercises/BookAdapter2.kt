package fr.android.androidexercises

import android.support.v7.widget.RecyclerView
import java.nio.file.Files.size
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


/**
 * Created by Kepa on 10/11/2017.
 */
class BookAdapter2(private val mInflater: LayoutInflater, private val mBooks: List<Book>, private val ressource: Int) : RecyclerView.Adapter<BookAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(mInflater.inflate(R.layout.custom_view_item_book, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder.itemView as BookItemView).bindView(mBooks[position])
    }

    override fun getItemCount(): Int {
        return mBooks.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kepa on 09/11/2017.
 */
class BookAdapter2 extends RecyclerView.Adapter {

    private final LayoutInflater mInflater;
    private final List<Book> mBooks;
    private final int ressource;

    public BookAdapter2(LayoutInflater inflater, List<Book> books, int ressource) {
        mInflater = inflater;
        mBooks = books;
        this.ressource = ressource;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.custom_view_item_book,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BookItemView)holder.itemView).bindView(mBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

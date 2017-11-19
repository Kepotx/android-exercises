package kbourgoin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;


/**
 * Created by Kepa on 19/11/2017.
 */

public class BookListFragment extends Fragment {

    private OnBookClickedListener listener;
    private List<Book> books = new LinkedList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnBookClickedListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_list_fragment, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final BookAdapter bookAdapter = new BookAdapter(LayoutInflater.from(this.getContext()), books, listener);

        RecyclerView recyclerView = view.findViewById(R.id.bookRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        recyclerView.setAdapter(bookAdapter);


        if(books.size() == 0) findBooks(bookAdapter);
    }
    void findBooks(final BookAdapter bookAdapter){
        Timber.plant(new Timber.DebugTree());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookService service = retrofit.create(BookService.class);

        Call<List<Book>> listCall = service.getBooks();

        listCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                for (Book book : response.body()) {
                    Timber.i("Title : %s", book.getTitle());
                    books.add(book);
                    bookAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.e(t.getMessage());
            }
        });
    }

    public interface OnBookClickedListener {
        void onBookClicked(Book book);
    }
}

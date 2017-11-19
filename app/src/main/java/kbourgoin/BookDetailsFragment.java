package kbourgoin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;


/**
 * Created by Kepa on 19/11/2017.
 */

public class BookDetailsFragment extends Fragment {
    private Book selectedBook;

    private TextView titleTextView;
    private TextView priceTextView;
    private TextView isbnTextView;
    private TextView synopsisTextView;

    private ImageView coverImageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_details_fragment, container, false);

        selectedBook = getArguments().getParcelable("BOOK");

        titleTextView = view.findViewById(R.id.titleTextView);
        priceTextView = view.findViewById(R.id.priceTextView);
        isbnTextView = view.findViewById(R.id.isbnTextView);
        synopsisTextView = view.findViewById(R.id.synopsisTextView);
        coverImageView = view.findViewById(R.id.coverImageView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(selectedBook != null){
            titleTextView.setText(selectedBook.getTitle());
            priceTextView.setText(String.format("%s €", selectedBook.getPrice()));
            isbnTextView.setText(String.format("Isbn : %s", selectedBook.getIsbn()));
            synopsisTextView.setText(selectedBook.getSynopsisToString());

            Glide.with(view.getContext())
                    .load(selectedBook.getCover())
                    .into(coverImageView);
        } else {
            coverImageView.setImageResource(0);
            titleTextView.setText("");
            priceTextView.setText("");
            isbnTextView.setText("");
            synopsisTextView.setText("");
        }
    }
}

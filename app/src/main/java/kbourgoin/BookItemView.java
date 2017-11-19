package kbourgoin;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;



/**
 * Created by Kepa on 19/11/2017.
 */

public class BookItemView extends LinearLayout {

    private TextView titleTextView;
    private TextView priceTextView;
    private ImageView coverImageView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void bindView(Book book){
        titleTextView.setText(book.getTitle());
        priceTextView.setText(String.format("%s €", book.getPrice()));

        Glide.with(this)
                .load(book.getCover())
                .into(coverImageView);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        titleTextView = findViewById(R.id.titleTextView);
        priceTextView = findViewById(R.id.priceTextView);
        coverImageView = findViewById(R.id.coverImageView);
    }


}

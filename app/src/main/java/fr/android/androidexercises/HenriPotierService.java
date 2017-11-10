package fr.android.androidexercises;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> getBooks();

    // TODO Method GET books which return a List<Book>

}

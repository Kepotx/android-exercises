package fr.android.androidexercises;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LoginPresenterTest {

    @Mock
    LoginActivity activity;
    @InjectMocks
    LoginPresenter loginPresenter;
    @Test
    public void password_should_be_valid() throws
            Exception {
        loginPresenter.checkCredentials("password");

        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }
    @Test
    public void password_should_be_invalid() throws
            Exception {
        loginPresenter.checkCredentials("");

        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }
}
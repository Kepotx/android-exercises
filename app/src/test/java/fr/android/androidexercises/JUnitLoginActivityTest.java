package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.android.api.Assertions.assertThat;


@RunWith(CustomRobolectricTestRunner.class)
public class JUnitLoginActivityTest {

    LoginActivity activity;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void logged() throws Exception {
        activity.logged();
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void not_logged() throws Exception {
        activity.notLogged();
        assertThat(activity.loginLayout).isVisible();
        assertThat(activity.loggedText).isGone();
    }
    /*
    @Test
    public void check_init() throws Exception {
        assertThat(activity.loginLayout).isVisible();
        assertThat(activity.loggedText).isGone();
    }
*/

}
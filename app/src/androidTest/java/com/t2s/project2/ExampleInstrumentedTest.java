package com.t2s.project2;

import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    // Test 1
    @Test
    public void verStuff(){

            //1.	Verify that the “Next” button is visible
            onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()));
            //2.	Click the Next Button
            onView(withId(R.id.button_next_activity)).perform(click());
            //3.	Verify that the “Previous” button is visible
            onView(withId(R.id.button_previous_activity)).check(matches(isDisplayed()));
            //4.	Verify that the TextView displays “This is the next screen"
            onView(withId(R.id.tenSec)).check(matches(withText("this is the next screen")));
            //5.	Click the “Previous” button
            onView(withId(R.id.button_previous_activity)).perform(click());
    }

    // Test 2
    @Test
    public void verStuff2() {

        //1.	Verify that the “Next” button is visible
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()));

        //2.	Click the Next Button
        onView(withId(R.id.button_next_activity)).perform(click());

        //3.	Verify that the “Previous” button is visible
        onView(withId(R.id.button_previous_activity)).check(matches(isDisplayed()));

        //4.	Verify that the TextView displays “This is the next screen"
        onView(withId(R.id.tenSec)).check(matches(withText("this is the next screen")));

        //5.	Click the “Previous” button
        onView(withId(R.id.button_previous_activity)).perform(click());

        //6.	This will be tricky, but verify that the TextView displays “Hello World”


        // TODO: Find a way to grab the TextView.  The Class Variable above (mActivityRule) can help you get the TextView;
        // TODO: REPLACE THIS BELOW
        TextView textView = new TextView(mActivityRule.getActivity()); // REPLACE

        // (Mike) - Need to create an object that holds the IdlingResource
        // (Mike) - ElapsedIdlingResource is a custom class that we create
        IdlingResource idlingResource = new ViewDisplayedIdlingResource(textView);

        // (Mike) - Need to register the new IdlingResource Object.  This also begins the wait.
        Espresso.registerIdlingResources(idlingResource);

        // (Mike) - This will not get triggered until the above IdlingResource has been found, or times out
        onView(withId(R.id.tenSec)).check(matches(withText("Hello world")));

        // (Mike) - Unregister this idling resource
        IdlingRegistry.getInstance().register(idlingResource);


    }
}

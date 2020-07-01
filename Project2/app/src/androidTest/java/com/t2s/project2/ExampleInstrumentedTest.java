package com.t2s.project2;

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
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    //@Test
    //public void useAppContext() {
    // Context of the app under test.
    //Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    //assertEquals("com.example.myapplication", appContext.getPackageName());
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
        Espresso.registerIdlingResources((IdlingResource) activityRule.getActivity().IdlingResource());
        onView(withId(R.id.tenSec)).check(matches(withText("Hello world")));
        IdlingRegistry.getInstance().register(mIdlingResource);


    }
}

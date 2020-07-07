package com.t2s.project2;

import android.widget.TextView;

import androidx.test.espresso.IdlingResource;

/**

 The most important parts about this custom class is the Constructor and isIdleNow()
 In the Constructor: You must pass in the TextView ('This text is about to change') so that you can wait until it says 'Hello World'
 isIdleNow(): Should ONLY return true when your TextView switches to 'Hello World'
*/
public class ViewDisplayedIdlingResource implements IdlingResource { // (Mike) - Must implement IdlingResource.. Doing this will will force this class to have the functions 'getName', 'isIdleNow', 'registerIdleTransitionCallback'

    private ResourceCallback mResourceCallback;
    //  TODO: MAKE A CLASS VARIABLE HERE FOR TEXTVIEW


    public ViewDisplayedIdlingResource(TextView textView) {
        //TODO: CONVERT 'textView' INTO A CLASS VARIABLE
    }

    // (Mike) - This can be anything
    @Override
    public String getName() {
        return "ViewDisplayedIdlingResource (" + System.currentTimeMillis() + ")";
    }

    // SUPER IMPORTANT FUNCTION!
    // isIdleNow(): Should ONLY return true when your TextView switches to 'Hello World'
    @Override
    public boolean isIdleNow() {

        // TODO: RETURN TRUE WHEN THE TEXTVIEW (WHICH WAS PASSED IN THROUGH THE CONSTRUCTOR) FINALLY SAYS HELLO WORLD, OTHERWISE RETURN FALSE

        // TODO: FIX THIS BELOW
        if (true) {
            mResourceCallback.onTransitionToIdle();
        }

        return false;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mResourceCallback = callback;
    }
}

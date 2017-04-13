package com.example.jatingarg.customwidget;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by jatingarg on 13/04/17.
 */

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    private static final String TAG = "MainActivityTests";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.jatingarg.customwidget", appContext.getPackageName());
    }

    @Test
    public void appTest(){
        onView(allOf(withId(R.id.quantityControl), hasSibling(withId(R.id.addBtn))));
        onView(allOf(withId(R.id.quantityControl), hasSibling(withId(R.id.subBtn))));
        onView(allOf(withId(R.id.quantityControl), hasSibling(withId(R.id.textView))));

        String initQuantity = ((TextView) mActivityTestRule.getActivity().findViewById(R.id.textView))
                .getText().toString();
        int iQty = Integer.parseInt(initQuantity);
        onView(withId(R.id.addBtn)).perform(click());
        String finalQuantity = ((TextView) mActivityTestRule.getActivity().findViewById(R.id.textView))
                .getText().toString();
        int fQty = Integer.parseInt(finalQuantity);
        iQty += 1;
        assertEquals(iQty,fQty);

        //testing subtraction
        onView(withId(R.id.subBtn)).perform(click());
        finalQuantity = ((TextView) mActivityTestRule.getActivity().findViewById(R.id.textView))
                .getText().toString();
        fQty = Integer.parseInt(finalQuantity);
        iQty -= 1;
        assertEquals(iQty,fQty);








    }

}

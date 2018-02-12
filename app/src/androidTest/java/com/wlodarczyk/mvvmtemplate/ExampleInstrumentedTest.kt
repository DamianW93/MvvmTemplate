package com.wlodarczyk.mvvmtemplate

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.wlodarczyk.mvvmtemplate.ui.main.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getTargetContext()
//        assertEquals("com.wlodarczyk.mvvmtemplate", appContext.packageName)
//    }

    @Test
    fun showEmptyLabelOnActivityCreated() {
        onView(withId(R.id.sampleLabel)).check(matches(withText("")))
    }
}

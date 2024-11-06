package com

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kotlin_project.MainActivity
import com.example.kotlin_project.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestUiSaveData
{
    @Before
    fun setUp()
    {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testsaveuser()
    {
        onView(withId(R.id.et_name)).perform(typeText("Saurav"), closeSoftKeyboard())
        onView(withId(R.id.et_email)).perform(typeText("s@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.et_password)).perform(typeText("123456"), closeSoftKeyboard())
        onView(withId(R.id.et_mobile)).perform(typeText("1234567890"), closeSoftKeyboard())
        onView(withId(R.id.bt_save)).perform(click())
    }

    @Test
    fun testinvaliduser()
    {
        onView(withId(R.id.et_name)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.et_email)).perform(typeText("invalid"), closeSoftKeyboard())
        onView(withId(R.id.et_password)).perform(typeText("short"), closeSoftKeyboard())
        onView(withId(R.id.et_mobile)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.bt_save)).perform(click())
    }
}
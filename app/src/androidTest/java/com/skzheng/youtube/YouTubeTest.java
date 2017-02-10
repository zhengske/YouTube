package com.skzheng.youtube;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class YouTubeTest {
    //声明
    Instrumentation instrumentation;
    public UiDevice MyDevice;
    String StartApp = "am start -W com.google.android.youtube.tv";
    String StopApp = "am force-stop com.google.android.youtube.tv";


    @Before
    public void setup() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        MyDevice = UiDevice.getInstance(instrumentation);
        MyDevice.pressHome();
    }

    @Test
    public void YouTube() {
        try {
            MyDevice.executeShellCommand(StartApp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyDevice.wait(Until.hasObject(By.text("home")), 5000);
        UiObject appSettings = new UiObject(new UiSelector().text("Settings"));
        try {
            appSettings.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UiObject SFN = new UiObject(new UiSelector().text("Stats for nerds"));
        try {
            SFN.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            SFN.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyDevice.pressDPadDown();
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyDevice.pressDPadDown();
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyDevice.pressEnter();
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyDevice.pressHome();
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            MyDevice.executeShellCommand("am start -W https://www.youtube.com/watch?v=ioO7rUVqw9w\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MyDevice.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //UiObject2 uiObject2 = MyDevice.findObject(By.text("247 video/webm; codecs=\"vp9\" 1280x720"));
        if (!MyDevice.hasObject(By.textContains("codece=\"vp9\""))) {
            fail();
        }
    }

    @Test
    public void Purchased() {
        try {
            MyDevice.executeShellCommand("am start -W https://www.youtube.com/watch?v=LFL4UnYvaGE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    @After
    //    public void tearDown() throws IOException {
    //        MyDevice.executeShellCommand("am force-stop com.google.android.youtube.tv");
    //    }


}


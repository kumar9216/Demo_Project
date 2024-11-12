package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotClass {

public void handleKeyPress() throws InterruptedException, AWTException {
    Robot r=new Robot();
       r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);         
    }
}


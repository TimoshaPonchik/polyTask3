package com.example.framework;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import android.view.MotionEvent;
import android.view.View;

public class TouchListenerFwTest {

    @Test
    public void testOnTouchActionDown() {
        View mockView = Mockito.mock(View.class);
        MotionEvent mockEvent = Mockito.mock(MotionEvent.class);
        Mockito.when(mockEvent.getAction()).thenReturn(MotionEvent.ACTION_DOWN);
        Mockito.when(mockEvent.getX()).thenReturn(0.5f);
        Mockito.when(mockEvent.getY()).thenReturn(0.5f);

        float sceneWidth = 500;
        float sceneHeight = 500;
        TouchListenerFw touchListener = new TouchListenerFw(mockView, sceneWidth, sceneHeight);
        touchListener.onTouch(mockView, mockEvent);

        assertTrue(touchListener.isTouchDown);
        assertFalse(touchListener.isTouchUp);
    }

    @Test
    public void testOnTouchActionUp() {
        View mockView = Mockito.mock(View.class);
        MotionEvent mockEvent = Mockito.mock(MotionEvent.class);
        Mockito.when(mockEvent.getAction()).thenReturn(MotionEvent.ACTION_UP);
        Mockito.when(mockEvent.getX()).thenReturn(0.5f);
        Mockito.when(mockEvent.getY()).thenReturn(0.5f);

        float sceneWidth = 500;
        float sceneHeight = 500;
        TouchListenerFw touchListener = new TouchListenerFw(mockView, sceneWidth, sceneHeight);
        touchListener.onTouch(mockView, mockEvent);

        assertFalse(touchListener.isTouchDown);
        assertTrue(touchListener.isTouchUp);
    }


    @Test
    public void testGetSwiped() {
        View mockView = Mockito.mock(View.class);
        MotionEvent mockEvent1 = Mockito.mock(MotionEvent.class);
        Mockito.when(mockEvent1.getAction()).thenReturn(MotionEvent.ACTION_DOWN);
        Mockito.when(mockEvent1.getX()).thenReturn(0.5f);
        Mockito.when(mockEvent1.getY()).thenReturn(0.5f);

        MotionEvent mockEvent2 = Mockito.mock(MotionEvent.class);
        Mockito.when(mockEvent2.getAction()).thenReturn(MotionEvent.ACTION_UP);
        Mockito.when(mockEvent2.getX()).thenReturn(0.7f);
        Mockito.when(mockEvent2.getY()).thenReturn(0.7f);

        float sceneWidth = 500;
        float sceneHeight = 500;
        TouchListenerFw touchListener = new TouchListenerFw(mockView, sceneWidth, sceneHeight);
        touchListener.onTouch(mockView, mockEvent1);
        touchListener.onTouch(mockView, mockEvent2);

        assertTrue(touchListener.getSwiped());
    }
}
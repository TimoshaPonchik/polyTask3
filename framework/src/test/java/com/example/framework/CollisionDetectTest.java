package com.example.framework;

import static org.junit.jupiter.api.Assertions.*;

import android.graphics.Rect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CollisionDetectTest {

    ObjectFw object1;
    ObjectFw object2;

    @BeforeEach
    void setUp() {
        object1 = new ObjectFw();
        object2 = new ObjectFw();
    }

    @Test
    void collisionDetectFalse() {
        object1.setHitBox(new Rect(0, 0, 0, 0));
        object2.setHitBox(new Rect(0, 0, 0, 0));
        object1.setRadius(0);
        object2.setRadius(0);
        assertEquals(CollisionDetect.collisionDetect(object1, object2), false);
    }

    @Test
    void collisionDetectTrue() {
        object1.setHitBox(new Rect(0, 0, 64, 64));
        object2.setHitBox(new Rect(32, 32, 64, 64));
        object1.setRadius(100);
        object2.setRadius(200);
        assertEquals(CollisionDetect.collisionDetect(object1, object2), true);
    }
}

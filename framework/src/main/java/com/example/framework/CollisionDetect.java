package com.example.framework;

public class CollisionDetect {

    static double object1X;
    static double object1Y;

    static double object2X;
    static double object2Y;

    static double radiusObject1;
    static double radiusObject2;

    static double dx;
    static double dy;

    static double distanceObjects;
    static double distanceObjectsCollision;
    static double sub = 0.0;

    public static boolean collisionDetect(ObjectFw object1, ObjectFw object2) {
        object1X = object1.getHitBox().centerX();
        object1Y = object1.getHitBox().centerY();

        object2X = object2.getHitBox().centerX();
        object2Y = object2.getHitBox().centerY();

        radiusObject1 = object1.getRadius() / 2;
        radiusObject2 = object2.getRadius() / 2;

        dx = object1X - object2X;
        dy = object1Y - object2Y;
        distanceObjects = Math.sqrt(dx * dx + dy * dy);
        if (distanceObjects < (radiusObject1 + radiusObject2)) {
            distanceObjectsCollision = distanceObjects;
            return true;
        }
        return false;
    }

    public static double collisionSub() {
        sub = radiusObject1 + radiusObject2 - distanceObjectsCollision;
        return sub;
    }
}

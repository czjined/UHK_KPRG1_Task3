package model3D;

import transforms.Point3D;

import java.awt.*;

public class Needle extends Solid {

    public Needle() {

        color = Color.BLUE.getRGB();
        vertexBuffer.add(new Point3D(5, 5, 5));   // Index 0
        vertexBuffer.add(new Point3D(-5, -5, 5)); // Index 1
        vertexBuffer.add(new Point3D(-5, 5, -5)); // Index 2
        vertexBuffer.add(new Point3D(5, -5, -5)); // Index 3

        indexBuffer.add(0);
        indexBuffer.add(1);
        indexBuffer.add(2);

        indexBuffer.add(0);
        indexBuffer.add(2);
        indexBuffer.add(3);

        indexBuffer.add(0);
        indexBuffer.add(3);
        indexBuffer.add(1);

        indexBuffer.add(3);
        indexBuffer.add(2);
        indexBuffer.add(1);
    }

}

package model3D;

import transforms.Point3D;

import java.awt.*;

public class Needle extends Solid {

    public Needle() {

        color = Color.GREEN.getRGB();
        vertexBuffer.add(new Point3D(5,5,5));
        vertexBuffer.add(new Point3D(-5,-5,5));
        vertexBuffer.add(new Point3D(-5,5,-5));
        vertexBuffer.add(new Point3D(5,-5,-5));

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

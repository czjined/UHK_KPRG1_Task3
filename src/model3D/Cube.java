package model3D;

import transforms.Point3D;

import java.awt.*;

public class Cube extends Solid {

    public Cube() {
        color = Color.GREEN.getRGB();
        vertexBuffer.add(new Point3D(1,1,1));
        vertexBuffer.add(new Point3D(-1,1,1));
        vertexBuffer.add(new Point3D(-1,-1,1));
        vertexBuffer.add(new Point3D(1,-1,1));

        vertexBuffer.add(new Point3D(1,1,-1));
        vertexBuffer.add(new Point3D(-1,1,-1));
        vertexBuffer.add(new Point3D(-1,-1,-1));
        vertexBuffer.add(new Point3D(1,-1,-1));

        // horni stena
        addIndeces(0,1,1,2,2,3,3,0);
        // dolni stena
        addIndeces(4,5,5,6,6,7,7,4);
        // bocni steny
        addIndeces(0,4,1,5,2,6,3,7);

    }
}

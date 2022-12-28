package model3D;

import transforms.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Solid {

    final List<Point3D> vertexBuffer = new ArrayList<>();
    final List<Integer> indexBuffer = new ArrayList<Integer>();
    int color;


    public List<Point3D> getVertexBuffer() {
        return vertexBuffer;
    }

    public List<Integer> getIndexBuffer() {
        return indexBuffer;
    }

    public int getColor() {
        return color;
    }

    final void addIndeces(Integer... indeces) {
        indexBuffer.addAll(Arrays.asList(indeces));
    }

}

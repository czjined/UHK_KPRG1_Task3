package renderer;

import model3D.Scene;
import model3D.Solid;
import rasterize.LineRasterizer;
import rasterize.LineRasterizerGraphics;
import rasterize.Raster;
import transforms.Mat4;
import transforms.Mat4Identity;
import transforms.Point3D;

import java.awt.*;
import java.util.List;

public class Renderer3D implements GPUrenderer {

    private final Raster raster;
    private Mat4 model, view, projection;
    private LineRasterizer lineRasterizer;

    public Renderer3D(Raster raster) {
        this.raster = raster;
        lineRasterizer = new LineRasterizerGraphics(raster);
        model = new Mat4Identity();
        view = new Mat4Identity();
        projection = new Mat4Identity();
    }

    @Override
    public void draw(Scene scene) {
        for (Solid solid: scene.getSolids()) {
            List<Point3D> vb = solid.getVertexBuffer();
            List<Integer> ib = solid.getIndexBuffer();
        }

    }

    @Override
    public void setModel(Mat4 model) {
        this.model = model;
    }

    @Override
    public void setView(Mat4 view) {
        this.view = view;
    }

    @Override
    public void setProjection(Mat4 projection) {
        this.projection = projection;
    }
}

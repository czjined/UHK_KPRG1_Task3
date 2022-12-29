package renderer;

import model3D.Scene;
import model3D.Solid;
import rasterize.LineRasterizer;
import rasterize.LineRasterizerGraphics;
import rasterize.Raster;
import transforms.Mat4;
import transforms.Mat4Identity;
import transforms.Point3D;
import transforms.Vec3D;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class Renderer3D implements GPUrenderer {

    private final Raster raster;
    private Mat4 model, view, projection;
    private LineRasterizerGraphics lineRasterizer;

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
            for (int i = 0; i < ib.size(); i+=2) {
                Point3D v1 = vb.get(ib.get(i));
                Point3D v2 = vb.get(ib.get(i+1));
                transformLine(v1, v2, solid.getColor());
            }
        }

    }

    private void transformLine(Point3D p1, Point3D p2, int color) {
        p1 = p1.mul(model).mul(view).mul(projection);
        p2 = p2.mul(model).mul(view).mul(projection);

        if (clip(p1)) {return;}
        if (clip(p2)) {return;}

//        Oba vrcholy jsou videt na obrazovce a oba se vejdou do zobr. objemu:

//        Provadim zpetnou dehomogenizaci vydelenim W
        Optional<Vec3D> dehomogP1 = p1.dehomog();
        Optional<Vec3D> dehomogP2 = p2.dehomog();
        if (dehomogP1.isEmpty() || dehomogP2.isEmpty()) return; // Pri W=0 jsem nemohl vydelit

        Vec3D vector1 = dehomogP1.get();
        Vec3D vector2 = dehomogP2.get();

        // Transformace do okna
        Vec3D vecTransf1 = transformToWindow(vector1);
        Vec3D vecTransf2 = transformToWindow(vector2);

        lineRasterizer.drawLine(
                (int) Math.round(vecTransf1.getX()),
                (int) Math.round(vecTransf1.getY()),
                (int) Math.round(vecTransf2.getX()),
                (int) Math.round(vecTransf2.getY()));

    }

    private Vec3D transformToWindow(Vec3D vec) {    // Slidy od str. 79
        return vec
                .mul(new Vec3D(1,-1,1)) // Osu Y shora dolu prevratit
                .add(new Vec3D(1,1,0))  // Posunout stred souradnic doleva nahoru
                .mul(new Vec3D(raster.getWidth()/(float)2, raster.getHeight()/ (float)2,1)); //
    }


    /**
     * Pripravena metoda pro orezavani:
     *  Pokud mam hranu, jejiz jeden vrchol neni videt = zahodim celou hranu.
     *  X, Y, Z a porovnavani s W.
     *
     * @param p
     * @return boolean
     */
    private boolean clip(Point3D p) {
//        TODO  dodelat orezani dle popisu v komentari nad metodou (viz. prednaska)
        return false;
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

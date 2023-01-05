package control;

import model3D.Cube;
import model3D.Needle;
import model3D.Scene;
import rasterize.Raster;
import renderer.GPUrenderer;
import renderer.Renderer3D;
import transforms.*;
import view.Panel;

public class Controller3D implements Controller {

    private GPUrenderer gpuRenderer;
    Raster raster;
    private Mat4 projection;
    private Camera camera;

    private Scene mainScene;

    public Controller3D(Panel panel) {
        gpuRenderer = new Renderer3D(panel.getRaster());
        raster = panel.getRaster();
//        initListeners(panel);

        camera = new Camera()
                .withPosition(new Vec3D(0, -3, 0))
                .addAzimuth(Math.toRadians(90))
                .addZenith(Math.toRadians(0));

        projection = new Mat4PerspRH(
                Math.PI / 3,
                panel.getRaster().getHeight() / panel.getRaster().getWidth(),
                0.1, 50
        );


        mainScene = new Scene();
        mainScene.getSolids().add(new Cube());
        mainScene.getSolids().add(new Needle());
        display();
    }

    private void display() {
        raster.clear();
        gpuRenderer.setModel(new Mat4Identity());
        gpuRenderer.setView(camera.getViewMatrix());
        gpuRenderer.setProjection(projection);
        gpuRenderer.draw(mainScene);

//        Vykresleni z pohledu X- osy
//        gpuRenderer.setModel(new Mat4Identity());
//        gpuRenderer.setView(new Mat4Identity());
//        gpuRenderer.setProjection(projection);
//        gpuRenderer.draw(mainScene);
    }

    @Override
    public void initListeners(Panel panel) {

    }
}

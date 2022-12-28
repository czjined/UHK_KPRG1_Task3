package renderer;

import model3D.Scene;
import transforms.Mat4;

public interface GPUrenderer {

    void draw(Scene scene);
    void setModel(Mat4 model);
    void setView(Mat4 view);
    void setProjection(Mat4 projection);

}

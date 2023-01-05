package model3D;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private final List<Solid> solids;

    public Scene() {
        this.solids = new ArrayList<>();
    }

    public Scene(List<Solid> solids) {
        this.solids = solids;
    }

    public List<Solid> getSolids() {
        return solids;
    }
}

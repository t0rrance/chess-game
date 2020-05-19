package sample;

import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;

public class CustomControlSkin extends SkinBase<CustomControl> implements Skin<CustomControl> {
    protected CustomControlSkin(CustomControl control) {
        super(control);
    }
}

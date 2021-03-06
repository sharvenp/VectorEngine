package app.engine.core.texture;

import app.assets.GameSettings;
import app.assets.Launcher;
import app.engine.core.debug.Debug;
import app.engine.core.game.Game;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

public class TextureLoader {

    private static ArrayList<Texture> textures;

    public static ArrayList<Texture> getTextures()  {
        return textures;
    }

    public static void loadTextures() throws Exception {

        URI textureDirPath = Launcher.class.getResource("textures/").toURI();
        textures = new ArrayList<>();
        textures.add(null); // pad 0-index

        try (Stream<Path> paths = Files.walk(Paths.get(textureDirPath))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            BufferedImage image = ImageIO.read(path.toFile());
                            int w = image.getWidth();
                            int h = image.getHeight();
                            if (w != h) {
                                Debug.error("Texture is not square:", path);
                            } else if (w != GameSettings.TEXTURE_RESOLUTION) {
                                Debug.error("Texture does not match resolution:", path);
                            } else {
                                Texture texture = new Texture(path.toString(), w);
                                image.getRGB(0, 0, w, h, texture.pixels, 0, w);
                                if (path.toFile().getName().contains("floor")) {
                                    // floor texture
                                    GameSettings.FLOOR_TEXTURE = texture;
                                } else if (path.toFile().getName().contains("ceiling")) {
                                    // ceiling texture
                                    GameSettings.CEIL_TEXTURE = texture;
                                } else {
                                    textures.add(texture);
                                }
                                Debug.log("Loaded texture:", path);
                                if ((w & (w - 1)) != 0) {
                                    Debug.warn("Texture resolution is not a power of 2:", path);
                                }
                            }
                        } catch (Exception e) {
                            Debug.error("Error loading texture: ", path, "( " + e + " ) - skipping...");
                        }
                    });
        }
    }

}

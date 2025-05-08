/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author whelz
 */
public class FontLoader {
    private static final Map<String, Font> fontCache = new HashMap<>();

    public static Font loadFont(String resourcePath, float size) {
        try {
            if (fontCache.containsKey(resourcePath)) {
                return fontCache.get(resourcePath).deriveFont(size);
            }

            InputStream is = FontLoader.class.getResourceAsStream(resourcePath);
            if (is == null) throw new IOException("Font not found: " + resourcePath);

            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontCache.put(resourcePath, font);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.PLAIN, (int) size); // fallback
        }
    }

    // 🔄 Applies font + centers a JLabel
    public static void applyFontCentered(JLabel label, String resourcePath, float size) {
        label.setFont(loadFont(resourcePath, size));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
    }
}

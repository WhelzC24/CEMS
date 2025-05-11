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
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * FontLoader utility for loading and applying custom fonts.
 * Supports size, style, and optional centering for JLabel.
 */
public class FontLoader {
    private static final Map<String, Font> fontCache = new HashMap<>();

    /**
     * Loads a custom font from resource path with size and style.
     *
     * @param resourcePath Path to font inside resources (e.g., "/fonts/MyFont.ttf")
     * @param size         Font size
     * @param style        Font.PLAIN, Font.BOLD, etc.
     * @return Derived Font object
     */
    public static Font loadFont(String resourcePath, float size, int style) {
        try {
            Font baseFont;

            if (fontCache.containsKey(resourcePath)) {
                baseFont = fontCache.get(resourcePath);
            } else {
                InputStream is = FontLoader.class.getResourceAsStream(resourcePath);
                if (is == null) throw new IOException("Font not found: " + resourcePath);

                baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
                fontCache.put(resourcePath, baseFont);
            }

            return baseFont.deriveFont(style, size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("SansSerif", style, (int) size); // fallback
        }
    }

    /**
     * Applies custom font to JLabel with optional centering.
     *
     * @param label        JLabel to style
     * @param resourcePath Font resource path
     * @param size         Font size
     * @param style        Font style
     * @param center       If true, sets alignment to center
     */
    public static void applyFontToLabel(JLabel label, String resourcePath, float size, int style, boolean center) {
        label.setFont(loadFont(resourcePath, size, style));
        if (center) {
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
        }
    }

    /**
     * Applies custom font to JButton.
     *
     * @param button       JButton to style
     * @param resourcePath Font resource path
     * @param size         Font size
     * @param style        Font style
     */
    public static void applyFontToButton(JButton button, String resourcePath, float size, int style) {
        button.setFont(loadFont(resourcePath, size, style));
    }
}
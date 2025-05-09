/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class GlobalMemoryManager {

    private static boolean initialized = false;
    private static final Set<JFrame> openFrames = new HashSet<>();

    public static void init() {
        if (initialized) return;
        initialized = true;

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("JVM is shutting down... cleaning up.");
            openFrames.clear();

            // Optional GC suggestion
            System.gc();

            System.out.println("Global memory cleanup complete.");
        }));
    }

    public static void registerFrame(JFrame frame) {
        openFrames.add(frame);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                openFrames.remove(frame);
                System.out.println("Form closed. Remaining open frames: " + openFrames.size());
                if (openFrames.isEmpty()) {
                    System.out.println("No more open forms. Exiting...");
                    System.exit(0);
                }
            }
        });
    }
}
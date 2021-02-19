package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

public class GuiUseCase {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat mat = Imgcodecs.imread("images/flower.jpeg");

        var window = HighGui.createJFrame("Gui Use Case", 0);
        window.setSize(800, 600 + 90);
        window.setLayout(new FlowLayout(FlowLayout.CENTER));
        setupGui(window, mat);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void setupGui(JFrame window, Mat mat) {
        JLabel sliderLabel = new JLabel("Blur level");

        JSlider levelSlider = new JSlider(JSlider.HORIZONTAL, 3, 9, 3);

        levelSlider.setMajorTickSpacing(2);
        levelSlider.setMinorTickSpacing(1);
        levelSlider.setPaintTicks(true);
        levelSlider.setPaintLabels(true);

        var image = HighGui.toBufferedImage(mat);
        ImageIcon icon = new ImageIcon(image);
        var label = new JLabel();
        label.setIcon(icon);
        final Mat result = new Mat();

        levelSlider.addChangeListener((e) -> {
            var source = (JSlider) e.getSource();
            int level = source.getValue();
            Imgproc.blur(mat, result, new Size(level, level));
            var processed = HighGui.toBufferedImage(result);
            SwingUtilities.invokeLater(() -> {
                icon.setImage(processed);
                label.updateUI();
            });
        });

        window.add(sliderLabel);
        window.add(levelSlider);
        window.add(label);
    }
}

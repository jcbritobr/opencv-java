package org.gardona.training;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class MouseEvents {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	/**
	 * Converts an Opencv Matrix to BuffferedImage
	 * @param mat opencv matrix
	 * @return a BufferedImage
	 */
	private static BufferedImage mat2BufferedImage(Mat mat) {

		byte[] buffer = new byte[mat.channels() * mat.cols() * mat.rows()];
		mat.get(0, 0, buffer);
		BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), BufferedImage.TYPE_3BYTE_BGR);
		final byte[] targetBuffer = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetBuffer, 0, buffer.length);

		return image;
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("images/flower.jpeg");

		var image = mat2BufferedImage(mat);
		ImageIcon icon = new ImageIcon(image);

		var window = HighGui.createJFrame("Result image", 0);
		window.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.printf("\rMouse position x: %d, y: %d", e.getX(), e.getY());
			}
		});

		window.setLayout(new FlowLayout());
		var label = new JLabel();
		label.setIcon(icon);
		window.add(label);
		window.setSize(image.getWidth(), image.getHeight());
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

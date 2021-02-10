package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class FlipingImages {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("flower.jpeg");
		Mat flipped = new Mat();
		Core.flip(mat, flipped, 1);

		HighGui.imshow("Result image", flipped);
		HighGui.namedWindow("Result image");
		HighGui.waitKey(0);
		System.exit(0);
	}
}

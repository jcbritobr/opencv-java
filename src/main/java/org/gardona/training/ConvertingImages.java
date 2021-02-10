package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ConvertingImages {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("flower.jpeg");

		HighGui.namedWindow("Result Image");
		System.out.println("Showing color image RGB");
		System.out.println("Number of channels: " + mat.channels());
		System.out.println("Mat type: " + mat.type());
		HighGui.imshow("Result Image", mat);
		HighGui.waitKey(0);
		Mat gray = new Mat();
		Imgproc.cvtColor(mat, gray, Imgproc.COLOR_RGB2GRAY);
		System.out.println("Showing gray image GRAY");
		HighGui.imshow("Result Image", gray);
		System.out.println("Number of channels: " + gray.channels());
		System.out.println("Gray type: " + mat.type());
		HighGui.waitKey(0);
		System.exit(0);
	}

}

package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class LoadGrayImage {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("images/flower.jpeg", Imgcodecs.IMREAD_GRAYSCALE);
		HighGui.namedWindow("Result image", HighGui.WINDOW_AUTOSIZE);
		HighGui.imshow("Result image", mat);
		HighGui.waitKey(0);
		System.exit(0);
	}

}

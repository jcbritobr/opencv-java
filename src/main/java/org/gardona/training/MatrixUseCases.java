package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Range;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class MatrixUseCases {

	private static final String RESULT_IMAGE = "Result image";

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		// creates an matrix thats describe an image with 1 channel 100 level gray
		Mat image1 = new Mat(240, 320, CvType.CV_8U, new Scalar(100));
		HighGui.namedWindow(RESULT_IMAGE, HighGui.WINDOW_AUTOSIZE);
		showMatrix(image1);
		HighGui.waitKey();

		// creates an matrix thats describe a 3byte/p color magenta - rgb(255, 0, 255)
		Mat image2 = new Mat(240, 320, CvType.CV_8UC3);
		// set image 2 to magenta color
		image2.setTo(new Scalar(255, 0, 255));
		showMatrix(image2);
		HighGui.waitKey();

		Mat image3 = Imgcodecs.imread("flower.jpeg");
		showMatrix(image3);
		HighGui.waitKey();

		// creates a new matrix with another coodinates
		Mat image4 = new Mat(image3, new Range(0, 200), new Range(0, 200));
		showMatrix(image4);
		HighGui.waitKey();

		// Clone a matrix
		Mat image5 = image4.clone();
		showMatrix(image5);
		HighGui.waitKey();

		// horizontally flip image5
		Core.flip(image5, image5, 1);
		showMatrix(image5);
		HighGui.waitKey();

		// vertically flip image5
		Core.flip(image5, image5, 0);
		showMatrix(image5);
		HighGui.waitKey();

		System.exit(0);

	}

	private static void showMatrix(Mat image) {
		HighGui.imshow(RESULT_IMAGE, image);
	}

}

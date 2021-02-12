package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Range;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageMasks {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat flower = Imgcodecs.imread("images/flower.jpeg");
		Mat logo = Imgcodecs.imread("images/nasa.jpg");

		// resize image
		Imgproc.resize(logo, logo, new Size(150, 100));
		// Imgproc.cvtColor(logo, logo, Imgproc.COLOR_RGB2GRAY);

		var myRoi = new Mat(flower, new Range(flower.rows() - logo.rows(), flower.rows()),
				new Range(flower.cols() - logo.cols(), flower.cols()));
		// Mat mask = new Mat();
		// mask.setTo(new Scalar(255, 0, 0));
		logo.copyTo(myRoi, logo);

		HighGui.namedWindow("Result image");
		HighGui.imshow("Result image", flower);
		HighGui.waitKey();

		System.exit(0);
	}

}

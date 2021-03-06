package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class RegionsOfInterest {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("images/flower.jpeg");
		Mat logo = Imgcodecs.imread("images/nasa.jpg");
		
		// resize image
		Imgproc.resize(logo, logo, new Size(150, 100));

		// get region of interest
		var myRoi = new Rect(mat.cols() - logo.cols(), mat.rows() - logo.rows(), logo.cols(), logo.rows());
		Mat imageRoi = new Mat(mat, myRoi);
		logo.copyTo(imageRoi);
		HighGui.namedWindow("Result image");
		HighGui.imshow("Result image", mat);
		HighGui.waitKey();
		
		System.exit(0);
	}

}

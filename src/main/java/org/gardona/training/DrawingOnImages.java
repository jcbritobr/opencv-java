package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DrawingOnImages {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		Mat mat = Imgcodecs.imread("flower.jpeg");
		
		HighGui.namedWindow("Result image");
		HighGui.imshow("Result image", mat);
		HighGui.waitKey();
		
		Imgproc.circle(mat, new Point(310, 400), 65, new Scalar(255, 0, 255), 3);
		Imgproc.circle(mat, new Point(650, 270), 65, new Scalar(255, 0, 255), 3);
		Imgproc.putText(mat, "Flower's stigma, style and filaments", new Point(150, 490), Imgproc.FONT_HERSHEY_PLAIN, 2.0, new Scalar(255, 0, 255), 2);
		HighGui.imshow("Image Result", mat);
		HighGui.waitKey();
		
		System.exit(0);

	}

}

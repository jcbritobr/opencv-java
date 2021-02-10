package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Sobel {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat img = Imgcodecs.imread("flower.jpeg");
        Mat gray = new Mat();
        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGRA2GRAY);
        var sobelProcess = new Mat();

        Imgproc.Sobel(gray, sobelProcess, CvType.CV_32F, 1, 0);
        Mat draw = new Mat();
        var maxLocResult = Core.minMaxLoc(sobelProcess);
        double maxVal = maxLocResult.maxVal, minVal = maxLocResult.minVal;
        sobelProcess.convertTo(draw, CvType.CV_8U, 255.0/(maxVal - minVal), -minVal * 255.0 / (maxVal - minVal));
        HighGui.namedWindow("Result image", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("Result image", draw);
        HighGui.waitKey();
        System.exit(0);
    }
}

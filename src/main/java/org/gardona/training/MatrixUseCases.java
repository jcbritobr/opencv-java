package org.gardona.training;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

public class MatrixUseCases {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // creates an matrix that's describe an image with 1 channel 100 level gray
        Mat image1 = new Mat(2, 3, CvType.CV_8U, new Scalar(100));
        System.out.println(image1.elemSize());
        System.out.println(image1);
        System.out.println(image1.dump());
        // creates an matrix that's describe a 3byte/p color magenta - rgb(255, 0, 255)
        Mat image2 = new Mat(3, 3, CvType.CV_8UC3);
        // set image 2 to magenta color
        image2.setTo(new Scalar(255, 0, 255));
        System.out.println(image2.dump());

        Mat image3 = Mat.eye(3, 3, CvType.CV_8U);
        System.out.println(image3.dump());

        Mat zeroes = Mat.zeros(3, 3, CvType.CV_8U);
        System.out.println(zeroes);

        Mat image4 = Mat.ones(3, 3, CvType.CV_8U);
        System.out.println(image4.dump());

        var flower = Imgcodecs.imread("images/flower.jpeg");

        // Submat the flower matrix. This operation takes a subsection of original matrix
        var submat = flower.submat(new Rect(200, 200, 500, 400));
        System.out.println(submat);

    }
}

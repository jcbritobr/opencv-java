package org.gardona.training;

import java.util.Random;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class MatrixPixelProcess {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	/**
	 * Implementation of salt noise algorithm with random position
	 * 
	 * @param image The matrix to receive the noise
	 * @param n     number of random salt points in matrix
	 */
	private static void salt(Mat image, int n) {
		int i, j;
		var random = new Random();

		for (int k = 0; k < n; k++) {
			i = random.nextInt(image.cols());
			j = random.nextInt(image.rows());

			if (image.type() == CvType.CV_8UC1) {
				image.put(i, j, 255);

			} else if (image.type() == CvType.CV_8UC3) {

				image.put(j, i, 255, 255, 255);
			}
		}
	}

	/**
	 * A simple implementation of invert filter
	 * 
	 * @param image An input matrix
	 */
	private static void invert(Mat image) {
		byte[] buffer = new byte[(int) (image.channels() * image.total())];
		image.get(0, 0, buffer);

		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) (255 - buffer[i]);
		}

		image.put(0, 0, buffer);
	}

	/**
	 * Reduce the number of colors of matrix by subdivide the rgb space into cubes of equal spaces.
	 * @param image Target matrix to be reduced
	 * @param div number of
	 */
	private static void colorReduce(Mat image, int div) {
		byte[] buffer = new byte[(int) (image.channels() * image.total())];
		image.get(0, 0, buffer);

		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) (buffer[i] / div * div + div/2);
		}
		image.put(0, 0, buffer);
	}

	/**
	 * Recovers a specific channel of matrix
	 * 
	 * @param image The matrix to extract the channel
	 * @param index The index of channel. Ex. 0-blue, 1-green, 2-red
	 * @return A new matrix with the extracted channel
	 */
	private static Mat recoverChannel(Mat image, int index) {
		System.out.printf("cols: %d%n", image.cols());
		System.out.printf("rows: %d%n", image.rows());
		System.out.printf("image size: %d%n", image.cols() * image.rows());
		System.out.printf("image size with total(): %d%n", image.total());
		System.out.printf("image number of channels: %d%n", image.channels());

		byte[] totalBuffer = new byte[(int) (image.total() * image.channels())];
		image.get(0, 0, totalBuffer);
		byte[] buffer = new byte[(int) image.total()];

		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = totalBuffer[(i * image.channels()) + index];
		}
		Mat n = new Mat(image.rows(), image.cols(), CvType.CV_8U);
		n.put(0, 0, buffer);
		return n;
	}

	public static void main(String[] args) {
		Mat flower = Imgcodecs.imread("images/flower.jpeg");
		Mat inverseFlower = flower.clone();
		Mat channels = flower.clone();
		Mat colorReduce = flower.clone();

		// set noise in matrix
		System.out.println("Set noise ...");
		salt(flower, 3000);

		HighGui.namedWindow("Result image");
		HighGui.imshow("Result image", flower);
		HighGui.waitKey();

		System.out.println("Set invert ...");
		invert(inverseFlower);
		HighGui.imshow("Result image", inverseFlower);
		HighGui.waitKey();

		System.out.println("get blue channel ...");
		var blue = recoverChannel(channels, 0);
		HighGui.imshow("Result image", blue);
		HighGui.waitKey();

		System.out.println("get green channel ...");
		var green = recoverChannel(channels, 1);
		HighGui.imshow("Result image", green);
		HighGui.waitKey();

		System.out.println("get red channel ...");
		var red = recoverChannel(channels, 2);
		HighGui.imshow("Result image", red);
		HighGui.waitKey();

		System.out.println("color reduce function ...");
		colorReduce(colorReduce, 25);
		HighGui.imshow("Result image", colorReduce);
		HighGui.waitKey();


		System.exit(0);
	}

}

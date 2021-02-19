package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class CameraCapture {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        VideoCapture videoCapture = new VideoCapture(0);
        videoCapture.set(Videoio.CAP_PROP_FRAME_WIDTH, 800);
        videoCapture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 600);
        HighGui.namedWindow("Video Window");
        Mat frame = new Mat();

        if (videoCapture.isOpened()) {
            while (true) {
                videoCapture.read(frame);
                var subMat = frame.submat(0, 200, 0, 200);
                var subMat2 = frame.submat(200, 400, 200, 400);
                var subMat3 = frame.submat(0, 200, 400, 600);
                Core.bitwise_not(subMat, subMat);
                Core.bitwise_not(subMat2, subMat2);
                Core.bitwise_not(subMat3, subMat3);
                HighGui.imshow("Video Window", frame);
                if (HighGui.waitKey(41) > 0) {
                    videoCapture.release();
                    System.exit(0);
                }
            }
        }
    }
}

package org.gardona.training;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

/*
 * Ip cam addresses
 * rtsp://freja.hiof.no:1935/rtplive/_definst_/hessdalen02.stream
 * rtsp://freja.hiof.no:1935/rtplive/_definst_/hessdalen03.stream
 * rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov
 * rtsp://demo:demo@ipvmdemo.dyndns.org:5541/onvif-media/media.amp?profile=profile_1_h264&sessiontimeout=60&streamtype=unicast
 */

public class IPCameraCapture {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		VideoCapture capture = new VideoCapture("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
		HighGui.namedWindow("Camera Capture");
		Mat frame = new Mat();

		if (capture.isOpened()) {
			while (true) {
				capture.read(frame);
				HighGui.imshow("Camera Capture", frame);
				if (HighGui.waitKey(41) > 0) {
					capture.release();
					System.exit(0);
				}
			}
		}
	}
}

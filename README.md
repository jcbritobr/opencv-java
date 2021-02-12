# <img src="images\opencvjava.jpeg" style="zoom:100%;" />
This repository is a collection of [OpenCv](https://opencv.org/) examples from c++ books, ported to Java language. Some examples has some changes to better adapt Java language.

### Installation

1 - Download OpenCv release from [here](https://opencv.org/releases/).

2 - Put all this libraries in os path: opencv_videoio_ffmpeg450_64.dll, opencv_java450.dll, opencv_world450.dll, opencv_videoio_msmf450_64.dll.

3 - Clone this project, and in the root folder, add java opencv-450.jar library to libs folder(if not exists, just create one).

**The same process is valid for linux** but instead of *.dll, the shared libraries will have *.so extensions. **Unfortunately, opencv 4.51 is not available on maven repositories**. It cant be downloaded by gradle.

### List of examples

* [**Simple**](src/main/java/org/gardona/training/Simple.java) - This example shows how to setup [OpenCv](https://opencv.org/) in a Java program and create a matrix.
* [**Mouse events**](src/main/java/org/gardona/training/MouseEvents.java) - This example shows how to setup a window that is able to track mouse positions.
* [**Converting images**](src/main/java/org/gardona/training/ConvertingImages.java) - This example shows how to convert image formats.
* [**Drawing on images**](src/main/java/org/gardona/training/DrawingOnImages.java) - Shows how to paint one image above other image.
* [**Flipping images**](src/main/java/org/gardona/training/FlipingImages.java) - Shows how to flip an image in horizontal and vertical directions.
* [**Load an image in gray scale** ](src/main/java/org/gardona/training/LoadGrayImage.java)- Shows how to convert an image in gray scale just when it is loading.
* [**Pixel by pixel process**](src/main/java/org/gardona/training/MatrixPixelProcess.java) - Shows how to process an matrix pixel by pixel.
* [**Matrix use cases**](src/main/java/org/gardona/training/MatrixUseCases.java) - Shows simple matrix use cases.
* [**Regions of interests**](src/main/java/org/gardona/training/RegionsOfInterest.java) - Shows how to process only certain portions of a matrix.
* [**Sobel**](src/main/java/org/gardona/training/Sobel.java) - Shows how to implement a sobel filter.


/**
 * Invert any number of images by setting all color components of each pixel to the exact opposite value within 0 to 255.
 * 
 * @author Huy Nguyen
 */
import edu.duke.*;
import java.io.*;

public class ImageInverter {
	//Select an image(inImage)
	public ImageResource invertImg(ImageResource inImage) {
		//Make a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//set pixel's red to opposite
			pixel.setRed(255 - inPixel.getRed());
			//set pixel's green to opposite
			pixel.setGreen(255 - inPixel.getGreen());
			//set pixel's blue to opposite
			pixel.setBlue(255 - inPixel.getBlue());
		}
		return outImage;
	}

	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		//for each selected image
		for (File f : dr.selectedFiles()) {
		    //convert to grayscale
			ImageResource inImage = new ImageResource(f);
			ImageResource invertedImg = invertImg(inImage);
			invertedImg.draw();
			//save image with a new file name
			String newName = "inverted-" + inImage.getFileName();
			invertedImg.setFileName(newName);
			invertedImg.save();
		}
	}
}

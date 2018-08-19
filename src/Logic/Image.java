/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author irley
 */
public class Image {
    
    private BufferedImage image;
    private int[] pixels;  
    private int[][] pixelMatrix;
    private String way;
    private int height;
    private int Width;
    private int size;
    
    
    public Image(String way){
        
        this.way = way;
        searchImage();
        uploadPixels();        
        this.height = image.getHeight();
        this.Width = image.getWidth();
        this.size = this.height * this.Width;
        this.pixelMatrix = Util.transformVectorInMatrix(this.height, this.Width,this.pixels);
    }
    
    public Image(){
    
    }

    public Image(Image image, int[][] matrix) {
        this.Width = image.getWidth();
        this.height = image.getHeight();
        this.way = System.currentTimeMillis()+".png";
        this.size = this.height * this.Width;
        this.pixelMatrix = matrix;
        this.image = image.getImage();
        this.pixels = Util.transformMatrixInVector(this.height, this.Width,this.pixelMatrix);
        uploadImage();
    }
        
       
    private void searchImage(){
        
        try{            
            this.setImage(ImageIO.read(new File(this.getWay())));
        }
        catch (IOException ex) {
            System.out.println("Error loading image. Error = "+ ex.getMessage());
        }        
    }
    
    private void uploadImage(){
        image.setRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
    }
    
    private void uploadPixels(){
    
        this.setPixels(this.getImage().getRGB(0, 0, getImage().getWidth(), getImage().getHeight(), null, 0, getImage().getWidth()));
        
    }

    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * @return the pixels
     */
    public int[] getPixels() {
        return pixels;
    }

    /**
     * @param pixels the pixels to set
     */
    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    /**
     * @return the pixelMatrix
     */
    public int[][] getPixelMatrix() {
        return pixelMatrix;
    }

    /**
     * @param pixelMatrix the pixelMatrix to set
     */
    public void setPixelMatrix(int[][] pixelMatrix) {
        this.pixelMatrix = pixelMatrix;
    }

    /**
     * @return the way
     */
    public String getWay() {
        return way;
    }

    /**
     * @param way the way to set
     */
    public void setWay(String way) {
        this.way = way;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the Width
     */
    public int getWidth() {
        return Width;
    }

    /**
     * @param Width the Width to set
     */
    public void setWidth(int Width) {
        this.Width = Width;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}

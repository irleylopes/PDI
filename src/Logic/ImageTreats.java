/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


/**
 *
 * @author irley
 */
public class ImageTreats {    
   
    public static Image changeQuadrants(Image image){
        
        int[][] matrix = new int[image.getWidth()][image.getHeight()];
        matrix = image.getPixelMatrix();
        int width = image.getWidth()/2;
        int height = image.getHeight()/2;
       
        int aux;
        
            
            for(int line = 0; line < width; line++){
                for(int column = 0; column < height; column++){
                    aux = matrix[line][column];
                    matrix[line][column] = matrix[line+width][column+height];
                    matrix[line+width][column+height] = aux;
                    
                    aux = matrix[line][column+height];
                    matrix[line][column+height] = matrix[line+width][column];
                    matrix[line+width][column] = aux;
                }
            }
        
        Image imageChange = new Image(image, matrix);
        image.setPixelMatrix(matrix);
        return imageChange;
    }
}
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
public class Util {
    
    public static int[][] transformVectorInMatrix(int heigth,int width,int[] pixels){
        
        int[][] matrix = new int[width][heigth];
        int index = 0;
        
        for(int line = 0; line < width; line++){
            for(int column = 0; column < heigth; column++){
                matrix[line][column] = pixels[index];
                index++;
            }
        }
        
        return matrix;
    }
    
    public static int[] transformMatrixInVector(int height, int width, int[][] matrix){
     
        int index = 0;
        int[] vector = new int[height*width];
        for(int line = 0; line < width; line++){
            for(int column = 0; column < height; column++){
                vector[index] = matrix[line][column];
                index++;
            }
        }
        return vector;
    }
}

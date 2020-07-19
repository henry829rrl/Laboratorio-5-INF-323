package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class piramide {
    /* Las coordenadas cartesianas (x, y, z) */  
	private float vertices[] = new float[] {   
			
			 // Abajo   
			(float) -14.5, (float) 74.5, 0, // 0  0    
			(float) -14.5, (float) 82.5, 0, // 0  0    
			(float) -22.5, (float) 82.5, 0, // 0  0   
			(float) -22.5, (float) 74.5, 0, // 0  0
			
			//derecha
			(float) -14.5, (float) 74.5, 0, // 0  0    
			(float) -14.5, (float) 82.5, 0, // 0  0
			(float) -18.5, (float) 78.5, 15, // 0  0
			
			//atras    
			(float) -14.5, (float) 82.5, 0, // 0  0
			(float) -22.5, (float) 82.5, 0, // 0  0
			(float) -18.5, (float) 78.5, 15, // 0  0
			
			//izquierda
			(float) -22.5, (float) 82.5, 0, // 0  0
			(float) -22.5, (float) 74.5, 0, // 0  0
			(float) -18.5, (float) 78.5, 15, // 0  0
			
			//frente
			(float) -14.5, (float) 74.5, 0, // 0  0
			(float) -22.5, (float) 74.5, 0, // 0  0
			(float) -18.5, (float) 78.5, 15, // 0  0
			
		
	}; 
	
	/* Los colores x c/vértice (r,g,b,a) */   
	byte maxColor = (byte)255;
	
	 private byte colores[] = new byte[] {   		 
			 // Frente - lila   
			 0, 0, maxColor, maxColor, // 0  13   
			 0, 0, maxColor, maxColor, // 1  14   
			 0, 0, maxColor, maxColor, // 5  15 
			 0, 0, maxColor, maxColor, // 0  13
			 // Atrás - amarillo  
			 0, 0, maxColor, maxColor, // 0  13   
			 0, 0, maxColor, maxColor, // 1  14   
			 0, 0, maxColor, maxColor, // 5  15    
			 //maxColor, maxColor, 0, maxColor, // 0   7    		 
			 // Izquierda - celeste   
			 0, 0, maxColor, maxColor, // 0  13   
			 0, 0, maxColor, maxColor, // 1  14   
			 0, 0, maxColor, maxColor, // 5  15    
			 //0, maxColor, maxColor, maxColor, // 3  11   			 
			 // Derecha - rojo   
			 0, 0, maxColor, maxColor, // 0  13   
			 0, 0, maxColor, maxColor, // 1  14   
			 0, 0, maxColor, maxColor, // 5  15    
			 //maxColor, 0, 0, maxColor, // 6  15   	 
			 // Abajo - azul   
			 0, 0, maxColor, maxColor, // 0  13   
			 0, 0, maxColor, maxColor, // 1  14   
			 0, 0, maxColor, maxColor, // 5  15   
			 //0, 0, maxColor, maxColor, // 4  19   	 
			 // Arriba - verde   
			 //0, maxColor, 0, maxColor, // 7  20   
			 //0, maxColor, 0, maxColor, // 6  21   
			 //0, maxColor, 0, maxColor, // 2  22   
			 //0, maxColor, 0, maxColor  // 3  23  		 
	 };
	 
	 /* Indices */  
	 private short indices[] = new short [] {     
			 0,  1,  2,  0,  2,  3, // Frente    
			 4,  5,  6,  // Atrás    
			 7,  8,  9,  // Izquierda    
			 10, 11,  12,  // Derecha   
			 13, 14, 15,  // Abajo   	  
			 
	 }; 
	 
	 private FloatBuffer bufVertices;  
	 private ByteBuffer bufColores;  
	 private ShortBuffer bufIndices;	 
	 public piramide() {   		 
		 /* Lee los vértices */   
		 ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);   
		 bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo   
		 bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float   
		 bufVertices.put(vertices);   
		 bufVertices.rewind(); // puntero al principio del buffer 	  
	     /* Lee los colores */   
		 bufColores = ByteBuffer.allocateDirect(colores.length);   
		 bufColores.put(colores);   
		 bufColores.position(0); // puntero al principio del buffer      		 
		 /* Lee los indices */   
		 bufByte = ByteBuffer.allocateDirect(indices.length * 2);   
		 bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo   
		 bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short   
		 bufIndices.put(indices);   
		 bufIndices.rewind(); // puntero al principio del buffer  	 
	 } 	 
	 public void dibuja(GL10 gl) { 		 
		 /* Se habilita el acceso al arreglo de vértices */   
		 gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); 	 
		 /* Se habilita el acceso al arreglo de colores */   
		 gl.glEnableClientState(GL10.GL_COLOR_ARRAY);      	 
		 /* Se especifica los datos del arreglo de vértices */
		 gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);	 
		 /* Se especifica los datos del arreglo de colores */ 
		 gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores); 	 
		  /* Se dibuja el cubo */   
		 gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,  
				 GL10.GL_UNSIGNED_SHORT, bufIndices); 	 
		  /* Se deshabilita el acceso a los arreglos */   
		 gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);  
		 gl.glDisableClientState(GL10.GL_COLOR_ARRAY);  	 
	 }

}

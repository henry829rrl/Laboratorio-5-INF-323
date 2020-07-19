package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class PosteTeleferico {
	
    /* Las coordenadas cartesianas (x, y, z) */  
	private float vertices[] = new float[] {   
			
			//base
			10, 10, -15,
			0, 10, -15,
			0, 0, -15,
			10, 0, -15,
			
			//derecha
			10, 10, 10,
			10, 0, 10, 
			10, 0, -15, 
			10, 10, -15,
			
			//izquierda
			0, 10, 10,
			0, 0, 10,
			0, 0, -15,
			0, 10, -15,
			
			//atraz
			10, 10, 10,
			0, 10, 10,
			0, 10, -15,
			10, 10, -15,
			
			//frente
			10, 0, 10,
			0, 0, 10,
			0, 0, -15, 
			10, 0, -15,
			
			//------piramide---------
			//base
			10, 10, 10,
			0, 10, 10,
			0, 0, 10,
			10, 0, 10,
			
			//derecha
			5, 5, 26, 
			10, 0, 10,
			10, 10, 10,
			
			//izquierda
			5, 5, 26, 
			0, 10, 10,
			0, 0, 10,
			
			//atraz
			5, 5, 26, 
			10, 10, 10,
			0, 10, 10,
			
			//frente
			5, 5, 26,
			0, 0, 10,
			10, 0, 10,
			
			
			//conecion entre cables
			10, 6, 26,
			0, 6, 26,
			0, 4, 26,
			10, 4, 26,
		
	}; 
	
	/* Los colores x c/vértice (r,g,b,a) */   
	byte maxColor = (byte)255;
	
	 private byte colores[] = new byte[] {   		 
			 // Frente - lila   
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			 // Atrás - amarillo 
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
  		 
	 };
	 
	 /* Indices */  
	 private short indices[] = new short [] {     
			 0,  1,  2,  0,  2,  3, // Frente    
			 4,  5,  6,  4,  6,  7,// Atrás 
			 8, 9, 10, 8, 10, 11,
			 12, 13, 14, 12, 14, 15,
			 16, 17, 18, 16, 18, 19, 
			 20, 21, 22, 20, 22, 23,
			 24, 25, 26,
			 27, 28, 29,
			 30, 31, 32,
			 33, 34, 35,
			 36, 37, 38, 36, 38, 39
			 
	 }; 
	 
	 private FloatBuffer bufVertices;  
	 private ByteBuffer bufColores;  
	 private ShortBuffer bufIndices;	 
	 public PosteTeleferico() {   		 
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

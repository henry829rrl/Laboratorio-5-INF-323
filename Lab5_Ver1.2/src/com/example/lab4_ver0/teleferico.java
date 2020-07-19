package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class teleferico {
	
	/**
	 * 3 ---------
2
	 * /| /|
	 * / | / |
	 * 7 --------- 6 |
	 * | | | |
	 * | 0 ------|-- 1
	 * | / | /
	 * |/ |/
	 * 4 --------- 5
	 */
	/* Las coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			//base
			50, 120, 0.09f,  // 
			10, 120, 0.09f,  // BLANCO
			10, 90, 0.09f,   //
			50, 90, 0.09f,  //
			
			//derecha
			50, 120, 30,
			50, 90, 30, 
			50, 90, 0,
			50, 120, 0,
			
			//izquierda
			10, 120, 30,
			10, 90, 30,
			10, 90, 0,
			10, 120, 0,
			
			//atraz
			50, 120, 30,
			10, 120, 30,
			10, 120, 0,
			50, 120, 0,
			
			//techo
			50, 120, 30, 
			10, 120, 30,
			10, 90, 30,
			50, 90, 30,
			
			//frente 1
			50, 90, 10,
			30, 90, 10,
			30, 90, 0,
			50, 90, 0,
			
			//frente 2
			20, 90, 10,
			10, 90, 10,
			10, 90, 0,
			20, 90, 0,
			
			//frente 3
			50, 90, 20,
			10, 90, 20,
			10, 90, 10,
			50, 90, 10,
			
			//cuarto interno
			50, 110, 20,
			20, 110, 20,
			20, 110, 0,
			50, 110, 0,
			
			50, 120, 20,
			20, 120, 20,
			20, 110, 20,
			50, 110, 20,
			
			20, 120, 20,
			20, 110, 20,
			20, 110, 0,
			20, 120, 0,
			

	};
	//OpenGL ES 1.x – Cubo Color 5 Lic. J. Felipez
	/* Los colores x c/vértice (r,g,b,a) */
	byte maxColor = (byte)255;
	private byte colores[] = new byte[] {

			// Izquierda - blanco
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			
			
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			// Derecha - rojo
			maxColor, 0, 0, maxColor, // 5 12
			maxColor, 0, 0, maxColor, // 1 13
			maxColor, 0, 0, maxColor, // 2 14
			maxColor, 0, 0, maxColor, // 6 15
			
			
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			
			maxColor, maxColor, maxColor, maxColor, // 0 8
			maxColor, maxColor, maxColor, maxColor, // 4 9
			maxColor, maxColor, maxColor, maxColor, // 7 10
			maxColor, maxColor, maxColor, maxColor, // 3 11
			
	};
	/* Indices */
	private short indices[] = new short [] {
			0, 1, 2, 0, 2, 3, // Frente
			4, 5, 6, 4, 6, 7, // Atrás
			8, 9, 10, 8, 10, 11, // Izquierda
			12, 13, 14, 12, 14, 15, // Derecha
			16, 17, 18, 16, 18, 19, // Abajo
			20, 21, 22, 20, 22, 23, // Arriba
			24, 25, 26, 24, 26, 27, //
			28, 29, 30, 28, 30, 31,  //
			32, 33, 34, 32, 34, 35,
			36, 37, 38, 36, 38, 39,
			40, 41, 42, 40, 42, 43,
			//44, 45, 46, 44, 46, 47,
			
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;
	public teleferico() {
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		//OpenGL ES 1.x – Cubo Color 6 Lic. J. Felipez
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
		
		//gl.glLineWidth(2);
		gl.glColor4f(0, 0, 0, 0);
		gl.glDrawElements(GL10.GL_LINES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
	}

}

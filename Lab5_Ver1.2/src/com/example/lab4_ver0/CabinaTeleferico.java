package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CabinaTeleferico {
	
	/**
	 * 3 --------- 2
	 * /| /|
	 * / | / |
	 * 7 --------- 6 |
	 * | | | |
	 * | 0 ------|-- 1
	 * | / | /
	 * |/ |/
	 * 4 --------- 5
	 */
	/* Coordenadas cartesianas (x, y, z) */
	private float vertices[] = new float[] {
			0, 0, 0,
			5, 0, 0,
			5, 8, 0, 
			0, 8, 0, 
			0, 0, 5, 
			5, 0, 5,
			5, 8, 5,
			0, 8, 5, 
	};
	/* Indices */
	private short indices[] = new short [] {
			4, 5, 5, 6, 6, 7, 7, 4, // Frente
			3, 2, 2, 1, 1, 0, 0, 3, // Atr�s
			0, 4, 4, 7, 7, 3, 3, 0, // Izquierda
			5, 1, 1, 2, 2, 6, 6, 5, // Derecha
			0, 1, 1, 5, 5, 4, 4, 0, // Abajo
			7, 6, 6, 2, 2, 3, 3, 7, // Arriba
	};
	private FloatBuffer bufVertices;
	private ShortBuffer bufIndices;
	public CabinaTeleferico() {
		/* Lee los v�rtices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		//OpenGL ES 1.x � Cubo Malla Cuadrado 5 Lic. J. Felipez
		/* Lee los indices */
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer
	}

	public void dibuja(GL10 gl) {
		/* Se habilita el acceso al arreglo de v�rtices */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		/* Se especifica los datos del arreglo de v�rtices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		/* Se establece el color en (r,g,b,a) */
		gl.glColor4f(0, 1, 1, 0);
		/* Dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glColor4f(1, 0, 0, 0);
		gl.glDrawElements(GL10.GL_LINES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso al arreglo de v�rtices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}

}

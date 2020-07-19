package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class ventanas {
	
	
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
			12,-0.4f,6,
			3,-0.4f,6,
			12,-0.4f,4,
			3,-0.4f,4,
			
			12,15+0.7f,6,
			3,15+0.7f,6,
			3,15+0.7f,4,
			12,15+0.7f,4
			

	};
	/* Indices */
	private short indices[] = new short [] {
			0,1,1,2,2,3,3,0,
			
			4,5,5,6,6,7,7,4		
	
	};
	private FloatBuffer bufVertices;
	private ShortBuffer bufIndices;
	public ventanas() {
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		//OpenGL ES 1.x – Cubo Malla Cuadrado 5 Lic. J. Felipez
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
		/* Se especifica los datos del arreglo de vértices */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		/* Se establece el color en (r,g,b,a) */
		gl.glColor4f(0, 1, 1, 0);
		/* Dibuja el cubo */
		gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glColor4f(0, 0, 0, 0);
		gl.glDrawElements(GL10.GL_LINES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		/* Se deshabilita el acceso al arreglo de vértices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}

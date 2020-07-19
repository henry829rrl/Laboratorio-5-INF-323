package com.example.lab4_ver0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
	public class lineas {
		/* Coordenadas cartesianas (x, y, z) */
		private float vertices[] = new float[] {
				-10, 115, 0,
				-45, 70, 0,
				
				-5, 120, 0,
				-5, 70, 0,
				
				-50, 65, 0,
				50, 65, 0,
				
				5, 60, 0,
				5, 10, 0,
				
				0,0,0,
				0,-120,0,
				
				0,10,0,
				-50,10,0,
				
				10,-25,0,
				50,-25,0,
				
				-50,-65,0,
				-10,-65,0
				
		};
		/* Indices */
		private short indices[] = new short [] {
				0,1,
				2,3,// Frent
				4,5,
				6,7,
				8,9,
				10,11,
				12,13,
				14,15,
				
				
		};
		private FloatBuffer bufVertices;
		private ShortBuffer bufIndices;
		public lineas() {
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
			gl.glColor4f(1, 1, 0, 0);
			/* Dibuja el cubo */
			gl.glDrawElements(GL10.GL_LINES, indices.length,
					GL10.GL_UNSIGNED_SHORT, bufIndices);
			/* Se deshabilita el acceso al arreglo de vértices */
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

	}


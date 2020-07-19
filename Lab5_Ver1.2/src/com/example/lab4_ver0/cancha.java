package com.example.lab4_ver0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
	public class cancha {
		/* Coordenadas cartesianas (x, y, z) */
		private float vertices[] = new float[] {
				15, -10, 0, // 0 a
				-15, -10, 0, // 1 b
				-15, 10, 0, // 1 b
				15, 10, 0, // 0 a
				
				//izq
				15,-7,0,
				10,-7,0,
				10,7,0,
				15,7,0,
				
				15,-3,0,
				13,-3,0,
				13,3,0,
				15,3,0,
				
			
				
				
				//der
				-15,-7,0,
				-10,-7,0,
				-10,7,0,
				-15,7,0,
				
				-15,-3,0,
				-13,-3,0,
				-13,3,0,
				-15,3,0,
				
				0,-10,0,
				0,10,0,
				//arco
				-15,-2,0,
				-15,-2,1,
				-15,2,1,
				-15,2,0,
				
				15,-2,0,
				15,-2,1,
				15,2,1,
				15,2,0,
				
				
	};
		/* Indices */
		private short indices[] = new short [] {
				0,1,1,2,2,3,3,0, // Frente
				4,5,5,6,6,7,
				8,9,9,10,10,11,
				12,13,13,14,14,15,
				16,17,17,18,18,19,
				20,21,
				22,23,23,24,24,25,
				26,27,27,28,28,29,
		};
		private FloatBuffer bufVertices;
		private ShortBuffer bufIndices;
		public cancha() {
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
			gl.glColor4f(1, 1, 1, 0);
			/* Dibuja el cubo */
			gl.glDrawElements(GL10.GL_LINES, indices.length,
					GL10.GL_UNSIGNED_SHORT, bufIndices);
			/* Se deshabilita el acceso al arreglo de vértices */
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

	}


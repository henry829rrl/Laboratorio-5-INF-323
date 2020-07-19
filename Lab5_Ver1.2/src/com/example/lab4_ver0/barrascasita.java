package com.example.lab4_ver0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
	public class barrascasita {
		private float vertices[] = new float[] {
				6, 1, 0,  // 0 a
				6, -1,0,  // 1 b
				-6,-1, 0, // 2 e
				-6, 1, 0, // 3 f
				
				4, 1, 0,  // 4 a
				4, -1, 0,   // 5 a
				2, 1, 0,    // 6 a
				2, -1, 0,   // 7 a
				-2, 1, 0,   // 8 a
				-2, -1, 0,  // 9 a
				-4, 1, 0,   // 10 a
				-4, -1, 0,  // 11 a

				0, 1, 0,   // 10 a
				0, -1, 0,  // 11 a
				
		};
		/* Indices */
		private short indices[] = new short [] {
				0,1,1,2,2,3,3,0,
				4,5,6,7,8,9,10,11,12,13,
		};
		private FloatBuffer bufVertices;
		private ShortBuffer bufIndices;
		public barrascasita() {
			ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
			bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
			bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
			bufVertices.put(vertices);
			bufVertices.rewind(); // puntero al principio del buffer
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
			gl.glDrawElements(GL10.GL_LINES, indices.length,
					GL10.GL_UNSIGNED_SHORT, bufIndices);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		}

	}


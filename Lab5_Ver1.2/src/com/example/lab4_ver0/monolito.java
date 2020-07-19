package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class monolito {
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
			10,10,0,//0
			0,10,0,//1
			0,0,0,//2
			10,0,0,//3
			
			10,10,15,//4
			10,0,15,//5
			10,0,0,//6
			10,10,0,//7
			
			0,10,15,//8
			0,0,15,//9
			0,0,0,//10
			0,10,0,//11
			
			10,10,15,//12
			0,10,15,//13
			0,10,0,//14
			10,10,0,//15
			
			10,0,15,//16
			0,0,15,//17
			0,0,0,//18
			10,0,0,//19
			
			//cabeza
			0,10,25,//20
			0,0,25,//21
			0,0,15,//22
			0,10,15,//23
			
			10,0,25,//24
			0,0,25,//25
			0,0,15,//26
			10,0,15,//27
			
			10,10,25,//28
			0,10,25,//29
			0,10,15,//30
			10,10,15,//31
			//cara
			10,10,25,//32
			10,0,25,//33
			10,0,15,//34
			10,10,15,//35
			
			11,8,23,//36
			11,6,23,//37
			11,6,21,//38
			11,8,21,//39
			
			11,4,23,//40
			11,2,23,//41
			11,2,21,//42
			11,4,21,//43
			
			11,8,19,//44
			11,2,19,//45
			11,2,17,//46
			11,8,17//47
			
			
				
			

	};
	/* Indices */
	private short indices[] = new short [] {
			0,1,2,0,1,3,
			4,5,6,4,6,7,
			8,9,10,8,10,11,
			12,13,14,12,14,15,
			16,17,18,16,18,19,
			
			20,21,21,22,22,23,23,20,
			24,25,25,26,26,27,27,24,
			28,29,29,30,30,31,31,28,
			32,33,33,34,34,35,35,32,
			36,37,37,38,38,39,39,36,
			40,41,41,42,42,43,43,40,
			44,45,45,46,46,47,47,44
	
	};
	private FloatBuffer bufVertices;
	private ShortBuffer bufIndices;
	public monolito() {
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
		gl.glColor4f(199/255f, 147/255f, 22/255f, 0);
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

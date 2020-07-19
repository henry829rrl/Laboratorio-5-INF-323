package com.example.lab4_ver0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
public class arboll {
	private float vertices[] = new float [] {
			0, -2, 4, 	// 0 a
			0, 2,4,  	// 1 b
			0,0, 6, 	// 2 e	
			2, 0, 4,    // 3 f				
			-2, 0, 4,   // 4 a
			0,0,6,		// 5
			
			0.2f, -3.2f, 2,  	// 6 a
			0.2f, 3.2f,2,  	// 7 b
			0.2f,0.2f, 6, 	// 8 e				
			3, 0.2f, 2, 	// 9 f				
			-3, -0.2f, 2,  	// 10 a
			0,-0.2f, 6, 	// 11 e
			
			3,3,0,
			-3,-3,0,
			0,0, 4,
			3,-3,0,
			-3,3,0,
			0,0, 4,	//17
			
			2.2f,2.7f,0,
			-2.2f,-2.7f,0,
			0.2f,0.2f, 4,
			2,-2.7f,0,
			-2,2.7f,0,
			0,0.2f, 4,  //23
			//tallo
			0,-0.5f,-2f,
			0,-0.5f,0,
			0,0.5f,0,
			0,0.5f,-2f,
			
			
			
			
			0.5f,0,-2f,
			0.5f,0,0,
			-0.5f,0,0,
			-0.5f,0,-2f,
	};

	byte maxColor = (byte)255;
	
	/* Los colores x c/vértice (r,g,b,a) */
	private byte colores[] = new byte[] { 
			//base
			(byte)35, (byte)143, (byte)10, 1, // 0
			(byte)35, (byte)143, (byte)10, 1, // 0
			(byte)35, (byte)143, (byte)10, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)105, (byte)128, (byte)77, 1, // 0
			(byte)35, (byte)143, (byte)10, 1, // 0
			(byte)35, (byte)143, (byte)10, 1, // 0
			(byte)35, (byte)143, (byte)10, 1, // 0
			
			(byte)48, (byte)161, (byte)22, 1, // 0
			(byte)48, (byte)161, (byte)22, 1, // 0
			(byte)48, (byte)161, (byte)22, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)66, (byte)97, (byte)59, 1, // 0
			(byte)48, (byte)161, (byte)22, 1, // 0
			(byte)48, (byte)161, (byte)22, 1, // 0
			(byte)48, (byte)161, (byte)22, 1, // 0
			
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0
			(byte)124, (byte)77, (byte)27, 1, // 0

	}
	;
	

	
	/* Indices */
	private short indices[] = new short [] {

			0,1,2,
			3,4,5,
			6,7,8,
			9,10,11,
			12,13,14,
			15,16,17,
			18,19,20,
			21,22,23,
			24,25,26,24,26,27,
			28,29,30,28,30,31,
			
	};
	
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public arboll() {
		
		/* Lee los vértices */
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
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

		/* Renderiza las primitivas desde los datos de los arreglos (vértices,
		 * colores e índices) */
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);

		/* Se deshabilita el acceso al arreglo de vértices */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		//* Se deshabilita el acceso al arreglo de colores */
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		
	}
}

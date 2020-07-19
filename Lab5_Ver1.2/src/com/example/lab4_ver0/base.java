package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class base {
	private float vertices[] = new float [] {
			//base
			50, 120, -0.05f,  //0
			-50, 120, -0.05f,  //1
			-50, -120, -0.05f, //2
			50, -120, -0.05f,//3
			
			//jardines
			50, 120, 0.05f,//4
			0, 120, 0.05f,//5
			0, 70, 0.05f,//6
			50, 70, 0.05f,//7
			
			-10, 120, 0.05f,//8
			-50, 120, 0.05f,//9
			-50, 70, 0.05f,//10
			
			-40, 70, 0.05f,//11
			-10, 110, 0.05f,//12
			-10, 70, 0.05f,//13
			
			0, 60, 0.05f,//14
			-50, 60, 0.05f,//15
			-50, 20, 0.05f,//16
			0, 20, 0.05f,//17
			
			50, 60, 0.05f,//18
			10, 60, 0.05f, //19
			10, -20, 0.05f,//20
			50, -20, 0.05f,//21
			
			-10,0,0.05f,//22
			-50,0,0.05f,//23
			-50,-60,0.05f,//24
			-10,-60,0.05f,//25
			
			50,-30,0.05f,//26
			10,-30,0.05f,//27
			10,-120,0.05f,//28
			50,-120,0.05f,//29
			
			-10,-70,0.05f,//30
			-50,-70,0.05f,//31
			-50,-120,0.05f,//32
			-10,-120,0.05f,//33
			
			//jardines
			50, 120, 0f,//34
			0, 120, 0f,//35
			0, 70, 0f,//36
			50, 70, 0f,//37
			
			-10, 120, 0f,//38
			-50, 120, 0f,//39
			-50, 70, 0f,//40
			
			-40, 70, 0f,//41
			-10, 110, 0f,//42
			-10, 70, 0f,//43
			
			0, 60, 0f,//44
			-50, 60, 0f,//45
			-50, 20, 0f,//46
			0, 20, 0f,//47
			
			50, 60, 0f,//48
			10, 60, 0f, //49
			10, -20, 0f,//50
			50, -20, 0f,//51
			
			-10,0,0f,//52
			-50,0,0f,//53
			-50,-60,0f,//54
			-10,-60,0f,//55
			
			50,-30,0f,//56
			10,-30,0f,//57
			10,-120,0f,//58
			50,-120,0f,//59
			
			-10,-70,0f,//60
			-50,-70,0f,//61
			-50,-120,0f,//62
			-10,-120,0f//63
			
							
	};
	byte maxColor = (byte)255;

	private byte colores[] = new byte[] {
			
			//verde
			//(byte)99, (byte)235, (byte)32, 1, // 3
			//(byte)99, (byte)235, (byte)32, 1, // 3
			//(byte)99, (byte)235, (byte)32, 1, // 3
			//(byte)99, (byte)235, (byte)32, 1, // 3
			
			
			//plomo
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3
			(byte)157, (byte)163, (byte)154, 1, // 3

			//verde
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			(byte)99, (byte)235, (byte)32, 1, // 3
			//cafe

			
	};
	private short indices[] = new short [] {
			//base
			0,1,2,0,2,3,
			
			4,5,6,4,6,7,
			8,9,10,
			11,12,13,
			14,15,16,14,16,17,
			18,19,20,18,20,21,
			22,23,24,22,24,25,
			26,27,28,26,28,29,
			30,31,32,30,32,33,
			
			34,35,36,34,36,37,
			38,39,40,
			41,42,43,
			44,45,46,44,46,47,
			48,49,50,48,50,51,
			52,53,54,52,54,55,
			56,57,58,56,58,59,
			60,61,62,60,62,63

			
	};
	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public base() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
		bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
		bufVertices.put(vertices);
		bufVertices.rewind(); // puntero al principio del buffer
		bufColores = ByteBuffer.allocateDirect(colores.length);
		bufColores.put(colores);
		bufColores.position(0); // puntero al principio del buffer
		bufByte = ByteBuffer.allocateDirect(indices.length * 2);
		bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
		bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
		bufIndices.put(indices);
		bufIndices.rewind(); // puntero al principio del buffer	
	}
	public void dibuja(GL10 gl) {
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
		gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);
		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, bufIndices);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

	}
}

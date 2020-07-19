package com.example.lab4_ver0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class parke{
	/*
	 *superficie
		100, -100, 0,	//12
	-100, -100, 0,	//13
	-100, 100, 0,	//14
	100, 100, 0,	//15
	 */
	private float vertices[] = new float [] {	
			//techo arriova	
			//IUJ
			1.15f, -1.15f, 3,		//I 0
			0.15f, 0.15f, 4,		//U 1
			1.15f, 1.15f, 3,		//J 2
			//KUI
			-1.15f, -1.15f, 3,		//K 3
			1.15f, -1.15f, 3,		//I 4
			0.15f, 0.15f, 4,		//U 5
			//LUK
			-1.15f, 1.15f, 3,		//L 6
			0.15f, 0.15f, 4,		//U 7
			-1.15f, -1.15f, 3,		//K 8
			//JUL
			1.15f, 1.15f, 3,		//J 9
			0.15f, 0.15f, 4,		//U 10
			-1.15f, 1.15f, 3,		//L 11
			//base resbalin
			-1.f, 1.f, 1,		//12
			1.f, 1.f, 1,		//13
			1.f, -1.f, 1,		//14
			-1.f, -1.f, 1,		//15
			//resbalin
			1.f, 0.7f, 1,		//16
			1.f, -0.7f, 1,		//17
			3.f, -0.7f, -0.5f,	//18
			3.f, 0.7f,	-0.5f,	//19
			//barras
			-1.f, 1.f, 3,		//20
			-0.85f, 1.f, 3,		//21
			-0.85f, 1.f,-0.5f,	//22
			-1.f, 1.f, -0.5f,	//23
			-1.f, 1.f, 3,		//24
			-1.f, 0.85f, 3,		//25
			-1.f, 0.85f, -0.5f,	//26
			-1.f, 1.f, -0.5f,	//27
			//barra2
			1.f, 1.f, 3,		//28
			0.85f, 1.f, 3,		//29
			0.85f, 1.f, -0.5f,	//30
			1.f, 1.f, -0.5f,	//31
			1.f, 1.f, 3,		//32
			1.f, 0.85f, 3,		//33
			1.f, 0.85f, -0.5f,	//34	
			1.f, 1.f, -0.5f,	//35
			//barra 3
			1.f, -1.f, 3,		//36
			0.85f, -1.f, 3,		//37
			0.85f, -1.f, -0.5f,	//38
			1.f, -1.f, -0.5f,	//39
			1.f, -1.f, 3,		//40
			1, -0.85f, 3,		//41
			1, -0.85f, -0.5f,	//42
			1.f, -1.f, -0.5f,	//43
			//barra 4
			-1.f, -1.f, 3,		//44
			-0.85f, -1.f, 3,	//45
			-0.85f, -1.f,-0.5f,	//46
			-1.f, -1.f,-0.5f,	//47
			-1.f, -1.f, 3,		//48
			-1, -0.85f, 3,		//49
			-1, -0.85f, -0.5f,	//50
			-1.f, -1.f, -0.5f,	//51
			//
			1.f, -1.f, 1.8f,		//14
			-1.f, -1.f, 1.8f,		//15
			-1.f, -1.f, 1.7f,
			1.f, -1.f, 1.7f,
			
			1.f, -1.f, 2,		//14
			-1.f, -1.f, 2,		//15
			-1.f, -1.f, 1.9f,
			1.f, -1.f, 1.9f,
			//
			1.f, 1.f, 1.8f,		//14
			-1.f, 1.f, 1.8f,		//15
			-1.f, 1.f, 1.7f,
			1.f, 1.f, 1.7f,
			
			1.f, 1.f, 2,		//14
			-1.f, 1.f, 2,		//15
			-1.f, 1.f, 1.9f,
			1.f, 1.f, 1.9f,
	};
	byte maxColor = (byte)255;

	private byte colores[] = new byte[] {
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3

			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3

			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3
			(byte)236, (byte)79, (byte)37, 1, // 3

			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3
			(byte)249, (byte)64, (byte)42, 1, // 3

			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//resbalin	
			(byte)245, (byte)92, (byte)67, 1, // 3
			(byte)245, (byte)92, (byte)67, 1, // 3
			(byte)245, (byte)92, (byte)67, 1, // 3
			(byte)245, (byte)92, (byte)67, 1, // 3

			//barras
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3

			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//barra2
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3

			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//barra3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3

			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//barra4
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//b
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//bb
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			////
			//b
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			//bb
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
			(byte)48, (byte)88, (byte)225, 1, // 3
	};
	private short indices[] = new short [] {
			//techo 
			0,1,2,
			3,4,5,
			6,7,8,
			9,10,11,
			//base resb
			12,13,14,12,14,15,
			//resbalin
			16,17,18,16,18,19,
			//barra1
			20,21,22,20,22,23,
			24,25,26,24,26,27,
			//barra2
			28,29,30,28,30,31,
			32,33,34,32,34,35,
			//barra3
			36,37,38,36,38,39,
			40,41,42,40,42,43,
			//barra 4
			44,45,46,44,46,47,
			48,49,50,48,50,51,
			//b
			52,53,54,52,54,55,
			//bb
			56,57,58,56,58,59,
			//
			60,61,62,60,62,63,
			64,65,66,64,66,67,
	};

	private FloatBuffer bufVertices;
	private ByteBuffer bufColores;
	private ShortBuffer bufIndices;	

	public parke() {
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



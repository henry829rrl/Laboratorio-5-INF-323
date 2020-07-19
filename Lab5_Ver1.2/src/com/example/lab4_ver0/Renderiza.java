package com.example.lab4_ver0;

import javax.microedition.khronos.egl.EGLConfig;


import javax.microedition.khronos.opengles.GL10;

//import com.opengl10_cubocolor_camara_dos_cubos1.Circulo;
//import com.opengl10_cubocolor_camara_dos_cubos1.Cubo;
//import com.opengl10_cubocolor_camara_dos_cubos1.Piso;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
public class Renderiza extends GLSurfaceView implements Renderer {
	private static final float[] MatrizRotacion = null;
	/* Objeto */
	
	private Cubo cubo;
	//private Piso piso;
	private Circulo circulo1;
	private flechas flecha;
	private final float[] vectorEntrada = { 0, 0, -1, 1 };
	private static float posicion[] = { 5, 5, 5f };
	private final float[] direccion = new float[4];
	
	/* Tamaño de la ventana en pixeles */
	//private int alto;
	//private int ancho;
	
	/* Para la rotación y traslación */
	private float rotY;
	private	float antX;
	
	final float[] matriz = new float[16];

	private base base;
	private parke parke;
	private Casita casita;
	private Circulo circulo,circulo2,circulo3, circulo4;
	private barras barra;
	private barrascasita barrasc;
	private arboll arbol;
	private cancha cancha;
	private lineas lineas;
	private piramide piramide;
	private Esfera esfera;
	private teleferico Teleferico1;
	private CableTeleferico cabletel;
	private PosteTeleferico Poste;
	private CabinaTeleferico Cabina;
	private CabinaTeleferico Cabina2;
	private CabinaTeleferico Cabina3;
	private CabinaTeleferico Cabina4;
	private CabinaTeleferico Cabina5;
	private CabinaTeleferico Cabina6;
	private CabinaTeleferico Cabina7;
	private aula aula;
	private cholet cholet;
	private ventanas ventanas;
	private monolito monolito;
	
	//private int varMovimiente=1;
	/////
	private float x_c1 = (float) 22, y_c1 = (float) 79, z_c1 = 21;
	private float xVelocidad_c1 =  0f, yVelocidad_c1 = 1f, zVelocidad_c1 = 0f;
	
	private float x_c2 = (float) 22, y_c2 = (float) 22, z_c2 = 21;
	private float xVelocidad_c2 =  0f, yVelocidad_c2 = 1f, zVelocidad_c2 = 0f;
	
	private float x_c3 = (float) 22, y_c3 = (float) -44, z_c3 = 21;
	private float xVelocidad_c3 =  0f, yVelocidad_c3 = 1f, zVelocidad_c3 = 0f;
	
	private float x_c4 = (float) 22, y_c4 = (float) -99, z_c4 = 21;
	private float xVelocidad_c4 =  0f, yVelocidad_c4 = 1f, zVelocidad_c4 = 0f;
	
	private float x_c5 = (float) 32, y_c5 = (float) -55, z_c5 = 21;
	private float xVelocidad_c5 =  0f, yVelocidad_c5 = -1f, zVelocidad_c5 = 0f;
	
	private float x_c6 = (float) 32, y_c6 = (float) 10, z_c6 = 21;
	private float xVelocidad_c6 =  0f, yVelocidad_c6 = -1f, zVelocidad_c6 = 0f;
	
	private float x_c7 = (float) 32, y_c7 = (float) 68, z_c7 = 21;
	private float xVelocidad_c7 =  0f, yVelocidad_c7 = -1f, zVelocidad_c7 = 0f;
	
	/* Ancho y alto de la ventana */
	private int ancho, alto;
	/* Para la rotación */
	
	//private ArcBall arcBall = new ArcBall(640.0f, 480.0f);
	//private float[] MatrizRotacion = new float[16];
	//private float[] B = new float[16];
	
	//-----------------------------------------------------------------------------------
	boolean animacion = true;  
	boolean simplePaso = false; 
	 
	 // Estas tres variables controlan el estado de la animación y su velocidad.  
	float horasPorDia = 1f;  

	float tiempoDeLaAnimacion = 24.0f; // Tiempo de incremento para la animación (horas)    
	
	/* Variables del tiempo de ejecución */  
	private long inicio, fin, duracion;  
	private float tiempo_real;  
	private float tiempoRotacion;  
	private final float PERIODO_DE_LA_ROTACION = 0.001f; // en segundos
	//-----------------------------------------------------------------------------------
	
	
	public Renderiza(Context contexto) {
		super(contexto);
		/* Inicia el renderizado */
		this.setRenderer(this);
		/* La ventana solicita recibir una entrada */
		this.requestFocus();
		/* Establece que la ventana detecte el modo táctil */
		this.setFocusableInTouchMode(true);
		/* Se renderizará al inicio o cuando se llame a requestRender() */
		this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
	

	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		
		cubo = new Cubo();
		//piso = new Piso();
		circulo1 = new Circulo(0.5f, 360, true);
		
		base = new base();
		parke = new parke();
		casita = new Casita();
		barra=new barras();
		barrasc=new barrascasita();
		arbol=new arboll();
		circulo = new Circulo(5, 360, true);
		circulo2 = new Circulo(5, 360, true);
		circulo3 = new Circulo(5, 360, true);
		circulo4 = new Circulo(5, 360, true);
		cancha=new cancha();
		lineas=new lineas();
		piramide = new piramide();
		esfera = new Esfera(8, 15, 15);
		Teleferico1 = new teleferico();
		cabletel = new CableTeleferico();
		Poste = new PosteTeleferico();
		Cabina = new CabinaTeleferico();
		Cabina2 = new CabinaTeleferico();
		Cabina3 = new CabinaTeleferico();
		Cabina4 = new CabinaTeleferico();
		Cabina5 = new CabinaTeleferico();
		Cabina6 = new CabinaTeleferico();
		Cabina7 = new CabinaTeleferico();
		aula = new aula();
		cholet =new cholet();
		ventanas= new ventanas();
		flecha=new flechas();
		monolito = new monolito();
		
		//-----------------------------
		 /* Inicializa las variables */   
		 inicio = System.currentTimeMillis();   
		 tiempoRotacion = PERIODO_DE_LA_ROTACION; 
		//------------------------
		
		/* B = I */
		//Matriz4.identidad(B);
		/* Deshabilita dithering, no se limita la paleta de colores */
		gl.glDisable(GL10.GL_DITHER);
		/* Habilita el modo de sombreado plano */
		gl.glShadeModel(GL10.GL_FLAT);
		/* Habilita el ocultamiento de superficies */
		gl.glEnable(GL10.GL_DEPTH_TEST);
		/* Limpia el buffer de profundidad con el valor de 1.0 */
		gl.glClearDepthf(1.0f);
		//OpenGL ES 1.x – CuboColor_Interacción_Cuaternion 3 Lic. J. Felipez
		/* Acepta si valor Z de entrada es igual al valor Z del buffer de profundidad */
		gl.glDepthFunc(GL10.GL_LEQUAL);
		/* Color de fondo */
		//gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glClearColor(34/255f, 113/255f, 179/256f, 0);
	}
	
	
	
	@Override 
	public void onDrawFrame(GL10 gl) {
		/* Incializa el buffer de color y de profundidad */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		/* Inicializa la Matriz del Modelo-Vista */
		
		/* Botones de las opciones */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(-4, 4, -6, 6, 1, 400);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		// Botón avanza
		gl.glPushMatrix();
		gl.glTranslatef(-3f, -5f, 0);
		gl.glColor4f(128/255f, 64/255f, 0, 0);
		circulo1.dibuja(gl);
		flecha.dibuja(gl);
		gl.glPopMatrix();
		
		// Botón retrocede
		gl.glPushMatrix();
		gl.glTranslatef(3f, -5f, 0);
		gl.glColor4f(128/255f, 64/255f, 0/255f, 0);
		circulo1.dibuja(gl);
		gl.glRotatef(180, 0, 0, 1);
		flecha.dibuja(gl);
		gl.glPopMatrix();
		
	    
		 
		 /* Matriz de Proyección */    
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluPerspective(gl, 100, ancho / (float)alto, 1f, 100f);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glRotatef(-rotY, 0, 30, 1);
		gl.glTranslatef(-posicion[0], -posicion[1], -posicion[2]);
		
		//------------------
		
		gl.glRotatef(-90f, 10f, 0f, 0);
		gl.glPushMatrix();

		base.dibuja(gl); // P' = MVM * P
		
		//lineas de carretera
		gl.glPushMatrix();
		gl.glTranslatef(0, 0,0.1f );
		gl.glColor4f(139/255f, 169/255f, 161/255f, 0);
		gl.glLineWidth(5);
		lineas.dibuja(gl);
		gl.glPopMatrix();
		
		//bosques
		gl.glPushMatrix();
		gl.glTranslatef(20, -20, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(42, -20, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(40, -20, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(25, -4, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(32, -4, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(48, -4, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(37, -10, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(28, -4, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(15, -10, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(46, -10, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(24, -10, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		//gl.glTranslatef(-13, -10, -14f);
		piramide.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		//gl.glRotatef( 360.0f*horasPorDia/24.0f, 0.0f, 1.0f, 0.0f );
		//gl.glPushMatrix();	
		gl.glTranslatef((float)-18.5,(float) 78.5, 23f);
		gl.glColor4f( 1, 1, 0, 1 );   
		gl.glRotatef( 360.0f*horasPorDia/24.0f, 0.0f, 1.0f, 0.0f );
		gl.glLineWidth(1);
		esfera.dibuja(gl);
		//gl.glPopMatrix();
		 /* Obtiene el tiempo real*/   
		 fin = System.currentTimeMillis();   
		 duracion = fin - inicio;   
		 tiempo_real = duracion / 1000f;   
		 inicio = fin;      
		  
		 /* Incrementa y verifica el límite del tiempo */   
		 tiempoRotacion = tiempoRotacion - tiempo_real;   
		 if (tiempoRotacion < 0.001) {     
			  tiempoRotacion = PERIODO_DE_LA_ROTACION;    
			  if (animacion) {     
				  // Actualiza el estado de la animación     
				  horasPorDia += tiempoDeLaAnimacion;     
				  
				  horasPorDia = horasPorDia - ((int)(horasPorDia/24))*24;          
			  }    
			  if ( simplePaso ) {     
				  animacion = false;    
			  }     
		  } 
		gl.glPopMatrix();
		
		//---TELEFERICO-------
		gl.glPushMatrix();			
		//gl.glTranslatef(-13, -10, -14f);
		Teleferico1.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		//gl.glRotatef(180f, 0f, 0f, 1f);
		gl.glTranslatef(60, 0, 0f);
		gl.glRotatef(180f, 0f, 0f, 0.01f);
		Teleferico1.dibuja(gl);
		gl.glPopMatrix();
		
		//POLEAS
		gl.glPushMatrix();			
		gl.glTranslatef(30, 105, 27f);
		gl.glColor4f(139/255f, 169/255f, 161/255f, 0);
		circulo.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(30, 105, 25f);
		gl.glColor4f(139/255f, 169/255f, 161/255f, 0);
		circulo2.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(30, -105, 27f);
		gl.glColor4f(139/255f, 169/255f, 161/255f, 0);
		circulo3.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(30, -105, 25f);
		gl.glColor4f(139/255f, 169/255f, 161/255f, 0);
		circulo4.dibuja(gl);
		gl.glPopMatrix();
		
		//cable de teleferico
		gl.glPushMatrix();			
		//gl.glTranslatef(30, -105, -40+25f);
		gl.glLineWidth(5);
		cabletel.dibuja(gl);
		gl.glPopMatrix();
		
		//poste de teleferico
		gl.glPushMatrix();			
		gl.glTranslatef(25, 5, 1);
		Poste.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(25, -45, 1f);
		Poste.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(15, 80, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(5, 85, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(5, 89, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(5, 94,1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(5, 97, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(13, 85, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		
		
		//CABINAS DE TELEFERICO
		gl.glPushMatrix();			
		gl.glTranslatef(x_c1, y_c1, z_c1);
		gl.glLineWidth(5);
		Cabina.dibuja(gl);
		y_c1=y_c1- yVelocidad_c1;
		z_c1=z_c1+zVelocidad_c1;
		x_c1=x_c1+xVelocidad_c1;
		gl.glPopMatrix();

		if(x_c1==22 && y_c1==-100 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = 1;
			yVelocidad_c1 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c1==27 && y_c1==-105 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = 1;
			yVelocidad_c1 = -1;
		}
		if(x_c1==32 && y_c1==-100 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = 0;
			yVelocidad_c1 = -1;
		}
		if(x_c1==32 && y_c1==100 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = -1;
			yVelocidad_c1 = -1;
		}
		if(x_c1==27 && y_c1==105 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = -1;
			yVelocidad_c1 = 1;
		}
		if(x_c1==22 && y_c1==100 && z_c1==21){
			zVelocidad_c1 = 0;
			xVelocidad_c1 = 0;
			yVelocidad_c1 = 1;
		}	

		gl.glPushMatrix();			
		gl.glTranslatef(x_c2, y_c2, z_c2);
		gl.glLineWidth(5);
		Cabina2.dibuja(gl);
		y_c2=y_c2- yVelocidad_c2;
		z_c2=z_c2+zVelocidad_c2;
		x_c2=x_c2+xVelocidad_c2;
		gl.glPopMatrix();

		if(x_c2==22 && y_c2==-100 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = 1;
			yVelocidad_c2 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c2==27 && y_c2==-105 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = 1;
			yVelocidad_c2 = -1;
		}
		if(x_c2==32 && y_c2==-100 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = 0;
			yVelocidad_c2 = -1;
		}
		if(x_c2==32 && y_c2==100 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = -1;
			yVelocidad_c2 = -1;
		}
		if(x_c2==27 && y_c2==105 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = -1;
			yVelocidad_c2 = 1;
		}
		if(x_c2==22 && y_c2==100 && z_c2==21){
			zVelocidad_c2 = 0;
			xVelocidad_c2 = 0;
			yVelocidad_c2 = 1;
		}

		gl.glPushMatrix();			
		gl.glTranslatef(x_c3, y_c3, z_c3);
		gl.glLineWidth(5);
		Cabina3.dibuja(gl);
		y_c3=y_c3- yVelocidad_c3;
		z_c3=z_c3+zVelocidad_c3;
		x_c3=x_c3+xVelocidad_c3;
		gl.glPopMatrix();
		if(x_c3==22 && y_c3==-100 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = 1;
			yVelocidad_c3 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c3==27 && y_c3==-105 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = 1;
			yVelocidad_c3 = -1;
		}
		if(x_c3==32 && y_c3==-100 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = 0;
			yVelocidad_c3 = -1;
		}
		if(x_c3==32 && y_c3==100 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = -1;
			yVelocidad_c3 = -1;
		}
		if(x_c3==27 && y_c3==105 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = -1;
			yVelocidad_c3 = 1;
		}
		if(x_c3==22 && y_c3==100 && z_c3==21){
			zVelocidad_c3 = 0;
			xVelocidad_c3 = 0;
			yVelocidad_c3 = 1;
		}

		
		gl.glPushMatrix();			
		gl.glTranslatef(x_c4, y_c4, z_c4);
		gl.glLineWidth(5);
		Cabina4.dibuja(gl);
		y_c4=y_c4- yVelocidad_c4;
		z_c4=z_c4+zVelocidad_c4;
		x_c4=x_c4+xVelocidad_c4;
		gl.glPopMatrix();
		if(x_c4==22 && y_c4==-100 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = 1;
			yVelocidad_c4 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c4==27 && y_c4==-105 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = 1;
			yVelocidad_c4 = -1;
		}
		if(x_c4==32 && y_c4==-100 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = 0;
			yVelocidad_c4 = -1;
		}
		if(x_c4==32 && y_c4==100 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = -1;
			yVelocidad_c4 = -1;
		}
		if(x_c4==27 && y_c4==105 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = -1;
			yVelocidad_c4 = 1;
		}
		if(x_c4==22 && y_c4==100 && z_c4==21){
			zVelocidad_c4 = 0;
			xVelocidad_c4 = 0;
			yVelocidad_c4 = 1;
		}
		
		gl.glPushMatrix();			
		gl.glTranslatef(x_c5, y_c5, z_c5);
		gl.glLineWidth(5);
		Cabina5.dibuja(gl);
		y_c5=y_c5- yVelocidad_c5;
		z_c5=z_c5+zVelocidad_c5;
		x_c5=x_c5+xVelocidad_c5;
		gl.glPopMatrix();
		if(x_c5==22 && y_c5==-100 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = 1;
			yVelocidad_c5 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c5==27 && y_c5==-105 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = 1;
			yVelocidad_c5 = -1;
		}
		if(x_c5==32 && y_c5==-100 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = 0;
			yVelocidad_c5 = -1;
		}
		if(x_c5==32 && y_c5==100 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = -1;
			yVelocidad_c5 = -1;
		}
		if(x_c5==27 && y_c5==105 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = -1;
			yVelocidad_c5 = 1;
		}
		if(x_c5==22 && y_c5==100 && z_c5==21){
			zVelocidad_c5 = 0;
			xVelocidad_c5 = 0;
			yVelocidad_c5 = 1;
		}
		
		gl.glPushMatrix();			
		gl.glTranslatef(x_c6, y_c6, z_c6);
		gl.glLineWidth(5);
		Cabina6.dibuja(gl);
		y_c6=y_c6- yVelocidad_c6;
		z_c6=z_c6+zVelocidad_c6;
		x_c6=x_c6+xVelocidad_c6;
		gl.glPopMatrix();
		if(x_c6==22 && y_c6==-100 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = 1;
			yVelocidad_c6 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c6==27 && y_c6==-105 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = 1;
			yVelocidad_c6 = -1;
		}
		if(x_c6==32 && y_c6==-100 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = 0;
			yVelocidad_c6 = -1;
		}
		if(x_c6==32 && y_c6==100 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = -1;
			yVelocidad_c6 = -1;
		}
		if(x_c6==27 && y_c6==105 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = -1;
			yVelocidad_c6 = 1;
		}
		if(x_c6==22 && y_c6==100 && z_c6==21){
			zVelocidad_c6 = 0;
			xVelocidad_c6 = 0;
			yVelocidad_c6 = 1;
		}
		
		gl.glPushMatrix();			
		gl.glTranslatef(x_c7, y_c7, z_c7);
		gl.glLineWidth(5);
		Cabina7.dibuja(gl);
		y_c7=y_c7- yVelocidad_c7;
		z_c7=z_c7+zVelocidad_c7;
		x_c7=x_c7+xVelocidad_c7;
		gl.glPopMatrix();
		if(x_c7==22 && y_c7==-100 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = 1;
			yVelocidad_c7 = 1;
			//z_c1=z_c1-zVelocidad_c1;
		}
		if(x_c7==27 && y_c7==-105 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = 1;
			yVelocidad_c7 = -1;
		}
		if(x_c7==32 && y_c7==-100 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = 0;
			yVelocidad_c7 = -1;
		}
		if(x_c7==32 && y_c7==100 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = -1;
			yVelocidad_c7 = -1;
		}
		if(x_c7==27 && y_c7==105 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = -1;
			yVelocidad_c7 = 1;
		}
		if(x_c7==22 && y_c7==100 && z_c7==21){
			zVelocidad_c7 = 0;
			xVelocidad_c7 = 0;
			yVelocidad_c7 = 1;
		}
		
		gl.glPushMatrix();
		//gl.glScalef(5f, 5f, 5f);
		gl.glTranslatef(-41, 90, 3);
		gl.glScalef(3f, 3f, 3f);
		gl.glRotatef(-41f, 0f, 0f, 0.01f);
		casita.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		//gl.glScalef(5f, 5f, 5f);
		gl.glTranslatef(-25, 110, 3);
		gl.glScalef(3f, 3f, 3f);
		gl.glRotatef(-41f, 0f, 0f, 0.01f);
		casita.dibuja(gl);
		gl.glPopMatrix();
		
		//ESCUELA
		gl.glPushMatrix();
		gl.glTranslatef(-15, 20, (float) 0.07);
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-30+3, 20, (float) (3+0.07));
		gl.glLineWidth(5);
		aula.dibuja(gl);
		ventanas.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-45+6, 20, (float) 0.07);
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-51, 20, (float) (3+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		
		gl.glPushMatrix();
		gl.glTranslatef(-45+6, 20, (float) (6+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-15, 20, (float) (6+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-30+3, 20, (float) (9+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-51, 20, (float) (9+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-15, 20, (float) (12+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-30+3, 20, (float) (15+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-45+6, 20, (float) (12+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-51, 20, (float) (15+0.07));
		gl.glLineWidth(5);
		ventanas.dibuja(gl);
		aula.dibuja(gl);
		gl.glPopMatrix();
		
		//CANCHA
		gl.glPushMatrix();			
		gl.glTranslatef(-30, 46, 0.1f);
		gl.glLineWidth(3);
		cancha.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(35, 48, 0.5f);
		parke.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glTranslatef(21, 48, 0.5f);
		gl.glRotatef(90, 0, 0, 1);
		parke.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(1, 0,0, 0);
		gl.glLineWidth(2);
		gl.glColor4f(4/255f, 78/255f,237/255f, 0);
		gl.glTranslatef(28, 48f, 1.6f);
		barrasc.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();			
		gl.glColor4f(1, 0,0, 0);
		gl.glLineWidth(2);
		gl.glTranslatef(38, 37f, 0f);
		barra.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(45, 10, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(46, 18, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(45, 25, 1f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(13, 12, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(20, 12, 2f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(29, 5, 4f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(15, 5, 4f);
		arbol.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-30, -90, 0 );
		gl.glScalef(3f, 3f, 3f);
		cholet.dibuja(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
		gl.glTranslatef(-35, -35, 0 );
		gl.glLineWidth(5);
		monolito.dibuja(gl);
		gl.glPopMatrix();
		//gl.glPopMatrix();
		gl.glFlush();



	}
	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		ancho = w;
		alto = h;
		
		gl.glViewport(0, 0, ancho, alto);
		
		GLU.gluLookAt(gl, 10, 10, 5, 0, 10, 10, 0, 1, 0);
	}
	//OpenGL ES 1.x – CuboColor_Interacción_Cuaternion 4 Lic. J. Felipez
	/**
	 * Maneja los eventos del movimiento en la pantalla táctil.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		
		/* Obtiene la coordenada de la pantalla */
		float posx = e.getX();
		float posy = e.getY();
		
		/* Se considera cuando se levanta el dedo de la pantalla. */ 
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			
			/* En coordenadas del OpenGL */
			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 12) - 6;

			/* Verifica área elegida */
			if (puntoEstaDentroDelCirculo(posx, posy, -3f, -5f, 0.5f)) { // Avanza
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] + direccion[0] * 5f;
				posicion[1] = posicion[1] + direccion[1] * 5f;
				posicion[2] = posicion[2] + direccion[2] * 5f;
				
			} else if (puntoEstaDentroDelCirculo(posx, posy, 3f, -5f, 0.5f)) { // Retrocede
				Matrix.setIdentityM(matriz, 0);
				Matrix.rotateM(matriz, 0, rotY, 0, 1, 0);
				Matrix.multiplyMV(direccion, 0, matriz, 0, vectorEntrada, 0);
				
				posicion[0] = posicion[0] - direccion[0] * 5f;
				posicion[1] = posicion[1] - direccion[1] * 5f;
				posicion[2] = posicion[2] - direccion[2] * 5f;
			}
			requestRender();
		} else if (e.getAction() == MotionEvent.ACTION_MOVE) {
			if(antX == -1) {
				antX = posx;
			} else {							
				rotY = rotY + (posx - antX) / 10;
				antX = posx;
			}
			
			requestRender();
		} else { 
			antX = -1;
		}	
		return true;
	}
	
	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
			float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
	
}
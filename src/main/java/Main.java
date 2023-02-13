import Engine.Window;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800,"helloworld");
            public void init(){
                window.init();
                GL.createCapabilities();

            }
            public void loop(){
                while( window.isOpen()){
                    window.update();
                    glClearColor(0.0f,0.0f,0.0f,0.0f);
                    GL.createCapabilities();

                    //restore state
                    glDisableVertexAttribArray(0);

                    //poll for windows event
                    //the key cllback above will
                    glfwPollEvents();
                }

            }
            public void run(){
                init();
                loop();
                glfwTerminate();
                glfwSetErrorCallback(null).free();


            }
            public static void main(String[] args){
                new Main().run();
            }
}
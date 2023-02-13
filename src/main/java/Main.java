import Engine.ShaderProgram;
import Engine.Window;
import Engine.object_2d;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800,"helloworld");
    private ArrayList<object_2d> objects = new ArrayList<>();
            public void init(){
                window.init();
                GL.createCapabilities();

                //code
                objects.add(new object_2d(Arrays.asList(new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert"
                                ,GL_VERTEX_SHADER)
                        ,new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag",GL_FRAGMENT_SHADER)),new ArrayList<>(
                                List.of(
                                        new Vector3f(0.0f,0.5f,0.0f),
                                        new Vector3f(-0.5f,-0.5f,-0.5f),
                                        new Vector3f(0.5f,-0.5f,0.0f)

                                )
                )));

            }
            public void loop(){
                while( window.isOpen()){
                    window.update();
                    glClearColor(0.0f,0.0f,0.0f,0.0f);
                    GL.createCapabilities();

                    //code
                        for(object_2d object: objects){
                            object.draw();
                        }
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
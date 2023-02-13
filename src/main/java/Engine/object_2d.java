package Engine;

import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import javax.swing.*;
import java.util.List;
import java.util.Vector;


import static org.lwjgl.opengl.GL15.*;

import static org.lwjgl.opengl.GL20.*;

import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class object_2d extends  ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;


    public object_2d(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }
    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices),GL_STATIC_DRAW);

    }
    public void draw(){
        drawSetup();
        //draw the vertices
        //optional
        glLineWidth(1);
        glPointSize(0);

        //wajib
        //GL_LINE
        //GL_liNE_STRIP
        //GL_liNE_LOOP
        //GL_liNE_TRIANGLES
        //GL_liNE_TRIANGLES_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
        //frst mau mulai dri index keberapa
        //gambar emua vertices.size

    }
    public void drawSetup(){
        bind();

        //bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3, GL_FLOAT,false,0,0);
    }
}

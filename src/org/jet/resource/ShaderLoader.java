/*
 *  The MIT License
 * 
 *  Copyright 2011 Matt Fichman <matt.fichman@gmail.com>.
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package org.jet.resource;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import java.nio.IntBuffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import static org.lwjgl.opengl.GL20.*;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class ShaderLoader {

    public static Shader getShader(InputStream frag, InputStream vert) throws IOException {

        ShaderImpl shader = new ShaderImpl();
        try {
            String fragCode = getCode(frag);
            String vertCode = getCode(vert);

            shader.setFragmentShaderID(glCreateShader(GL_FRAGMENT_SHADER));
            glShaderSource(shader.getFragmentShaderID(), fragCode);
            glCompileShader(shader.getFragmentShaderID());

            shader.setVertexShaderID(glCreateShader(GL_VERTEX_SHADER));
            glShaderSource(shader.getVertexShaderID(), vertCode);
            glCompileShader(shader.getVertexShaderID());

            shader.setProgramID(glCreateProgram());
            glAttachShader(shader.getProgramID(), shader.getFragmentShaderID());
            glAttachShader(shader.getProgramID(), shader.getVertexShaderID());
            glLinkProgram(shader.getProgramID());

            String errors = getErrors(shader);
            if (errors != null) {
                throw new IOException(errors);
            }

        } catch (IOException ex) {
            shader.release();
            throw ex;
        }
        return shader;
    }

    public static String getCode(InputStream in) throws IOException {
        StringBuilder buffer = new StringBuilder();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public static String getErrors(Shader shader) {
        IntBuffer success = BufferUtils.createIntBuffer(1);
        glGetProgram(shader.getProgramID(), GL_LINK_STATUS, success);
        
        if (success.get() == 0) {
            StringBuilder builder = new StringBuilder();
            ByteBuffer log = BufferUtils.createByteBuffer(1024);
            IntBuffer length = BufferUtils.createIntBuffer(1);

            glGetShaderInfoLog(shader.getFragmentShaderID(), length, log);
            builder.append(log);
            glGetShaderInfoLog(shader.getVertexShaderID(), length, log);
            builder.append(log);
            glGetProgramInfoLog(shader.getProgramID(), length, log);
            builder.append(log);

            return builder.toString();
        } else {
            return null;
        }
    }

}

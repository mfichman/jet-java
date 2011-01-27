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

import static org.lwjgl.opengl.GL20.*;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class ShaderImpl implements Shader {

    private int programID;
    private int vertexShaderID;
    private int fragmentShaderID;

    /**
     * @return the programID
     */
    public int getProgramID() {
        return programID;
    }

    /**
     * @param programID the programID to set
     */
    public void setProgramID(int programID) {
        this.programID = programID;
    }

    /**
     * @return the vertexShaderID
     */
    public int getVertexShaderID() {
        return vertexShaderID;
    }

    /**
     * @param vertexShaderID the vertexShaderID to set
     */
    public void setVertexShaderID(int vertexShaderID) {
        this.vertexShaderID = vertexShaderID;
    }

    /**
     * @return the fragmentShaderID
     */
    public int getFragmentShaderID() {

        return fragmentShaderID;
    }

    /**
     * @param fragmentShaderID the fragmentShaderID to set
     */
    public void setFragmentShaderID(int fragmentShaderID) {
        this.fragmentShaderID = fragmentShaderID;
    }

    public void release() {
        glDeleteShader(this.fragmentShaderID);
        glDeleteShader(this.vertexShaderID);
        glDeleteProgram(this.programID);
    }

}

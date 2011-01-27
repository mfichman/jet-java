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

package org.jet.scene;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class Light extends SceneNode {
    private Color3f ambientColor;
    private Color3f diffuseColor;
    private Color3f specularColor;
    private Vector3f direction;
    private boolean shadowCaster;

    @Override
    public void visit(Functor functor) {
        functor.visit(this);
    }

    /**
     * @return the ambientColor
     */
    public Color3f getAmbientColor() {
        return ambientColor;
    }

    /**
     * @param ambientColor the ambientColor to set
     */
    public void setAmbientColor(Color3f ambientColor) {
        this.ambientColor = ambientColor;
    }

    /**
     * @return the diffuseColor
     */
    public Color3f getDiffuseColor() {
        return diffuseColor;
    }

    /**
     * @param diffuseColor the diffuseColor to set
     */
    public void setDiffuseColor(Color3f diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    /**
     * @return the specularColor
     */
    public Color3f getSpecularColor() {
        return specularColor;
    }

    /**
     * @param specularColor the specularColor to set
     */
    public void setSpecularColor(Color3f specularColor) {
        this.specularColor = specularColor;
    }

    /**
     * @return the direction
     */
    public Vector3f getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Vector3f direction) {
        this.direction = direction;
    }

    /**
     * @return the shadowCaster
     */
    public boolean isShadowCaster() {
        return shadowCaster;
    }

    /**
     * @param shadowCaster the shadowCaster to set
     */
    public void setShadowCaster(boolean shadowCaster) {
        this.shadowCaster = shadowCaster;
    }
    
}

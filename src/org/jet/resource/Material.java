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

import javax.vecmath.Color3f;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class Material {
    private Color3f ambientColor;
    private Color3f diffuseColor;
    private Color3f specularColor;
    private Texture diffuseMap;
    private Texture specularMap;
    private Texture normalMap;
    private Shader shader;
    private float shininess;
    private boolean shadowReceiver;
    private boolean doubleSided;

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
     * @return the diffuseMap
     */
    public Texture getDiffuseMap() {
        return diffuseMap;
    }

    /**
     * @param diffuseMap the diffuseMap to set
     */
    public void setDiffuseMap(Texture diffuseMap) {
        this.diffuseMap = diffuseMap;
    }

    /**
     * @return the specularMap
     */
    public Texture getSpecularMap() {
        return specularMap;
    }

    /**
     * @param specularMap the specularMap to set
     */
    public void setSpecularMap(Texture specularMap) {
        this.specularMap = specularMap;
    }

    /**
     * @return the normalMap
     */
    public Texture getNormalMap() {
        return normalMap;
    }

    /**
     * @param normalMap the normalMap to set
     */
    public void setNormalMap(Texture normalMap) {
        this.normalMap = normalMap;
    }

    /**
     * @return the shader
     */
    public Shader getShader() {
        return shader;
    }

    /**
     * @param shader the shader to set
     */
    public void setShader(Shader shader) {
        this.shader = shader;
    }

    /**
     * @return the shininess
     */
    public float getShininess() {
        return shininess;
    }

    /**
     * @param shininess the shininess to set
     */
    public void setShininess(float shininess) {
        this.shininess = shininess;
    }

    /**
     * @return the shadowReceiver
     */
    public boolean isShadowReceiver() {
        return shadowReceiver;
    }

    /**
     * @param shadowReceiver the shadowReceiver to set
     */
    public void setShadowReceiver(boolean shadowReceiver) {
        this.shadowReceiver = shadowReceiver;
    }

    /**
     * @return the doubleSided
     */
    public boolean isDoubleSided() {
        return doubleSided;
    }

    /**
     * @param doubleSided the doubleSided to set
     */
    public void setDoubleSided(boolean doubleSided) {
        this.doubleSided = doubleSided;
    }


}

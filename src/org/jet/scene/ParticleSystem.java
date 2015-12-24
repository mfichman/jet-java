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

import org.jet.resource.Shader;
import org.jet.util.Range;
import javax.vecmath.Vector3f;
import org.newdawn.slick.opengl.Texture;

/**
 * 
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class ParticleSystem extends SceneNode {

    private boolean velocityInherited;
    private float life;
    private Range emitterWidth;
    private Range emitterHeight;
    private Range emitterDepth;
    private Range particleGrowthRate;
    private Range particleLife;
    private Range particleSize;
    private Range emissionSpeed;
    private Vector3f emissionDirection;
    private Range emissionAngle;
    private Range emissionRate;
    private int quota;
    private Texture texture;
    private Shader shader;

    @Override
    public void visit(Functor functor) {
        functor.visit(this);
    }

    /**
     * @return the velocityInherited
     */
    public boolean isVelocityInherited() {
        return velocityInherited;
    }

    /**
     * @param velocityInherited the velocityInherited to set
     */
    public void setVelocityInherited(boolean velocityInherited) {
        this.velocityInherited = velocityInherited;
    }

    /**
     * @return the life
     */
    public float getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(float life) {
        this.life = life;
    }

    /**
     * @return the emitterWidth
     */
    public Range getEmitterWidth() {
        return emitterWidth;
    }

    /**
     * @param emitterWidth the emitterWidth to set
     */
    public void setEmitterWidth(Range emitterWidth) {
        this.emitterWidth = emitterWidth;
    }

    /**
     * @return the emitterHeight
     */
    public Range getEmitterHeight() {
        return emitterHeight;
    }

    /**
     * @param emitterHeight the emitterHeight to set
     */
    public void setEmitterHeight(Range emitterHeight) {
        this.emitterHeight = emitterHeight;
    }

    /**
     * @return the emitterDepth
     */
    public Range getEmitterDepth() {
        return emitterDepth;
    }

    /**
     * @param emitterDepth the emitterDepth to set
     */
    public void setEmitterDepth(Range emitterDepth) {
        this.emitterDepth = emitterDepth;
    }

    /**
     * @return the particleGrowthRate
     */
    public Range getParticleGrowthRate() {
        return particleGrowthRate;
    }

    /**
     * @param particleGrowthRate the particleGrowthRate to set
     */
    public void setParticleGrowthRate(Range particleGrowthRate) {
        this.particleGrowthRate = particleGrowthRate;
    }

    /**
     * @return the particleLife
     */
    public Range getParticleLife() {
        return particleLife;
    }

    /**
     * @param particleLife the particleLife to set
     */
    public void setParticleLife(Range particleLife) {
        this.particleLife = particleLife;
    }

    /**
     * @return the particleSize
     */
    public Range getParticleSize() {
        return particleSize;
    }

    /**
     * @param particleSize the particleSize to set
     */
    public void setParticleSize(Range particleSize) {
        this.particleSize = particleSize;
    }

    /**
     * @return the emissionSpeed
     */
    public Range getEmissionSpeed() {
        return emissionSpeed;
    }

    /**
     * @param emissionSpeed the emissionSpeed to set
     */
    public void setEmissionSpeed(Range emissionSpeed) {
        this.emissionSpeed = emissionSpeed;
    }

    /**
     * @return the emissionDirection
     */
    public Vector3f getEmissionDirection() {
        return emissionDirection;
    }

    /**
     * @param emissionDirection the emissionDirection to set
     */
    public void setEmissionDirection(Vector3f emissionDirection) {
        this.emissionDirection = emissionDirection;
    }

    /**
     * @return the emissionAngle
     */
    public Range getEmissionAngle() {
        return emissionAngle;
    }

    /**
     * @param emissionAngle the emissionAngle to set
     */
    public void setEmissionAngle(Range emissionAngle) {
        this.emissionAngle = emissionAngle;
    }

    /**
     * @return the emissionRate
     */
    public Range getEmissionRate() {
        return emissionRate;
    }

    /**
     * @param emissionRate the emissionRate to set
     */
    public void setEmissionRate(Range emissionRate) {
        this.emissionRate = emissionRate;
    }

    /**
     * @return the quota
     */
    public int getQuota() {
        return quota;
    }

    /**
     * @param quota the quota to set
     */
    public void setQuota(int quota) {
        this.quota = quota;
    }

    /**
     * @return the texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * @param texture the texture to set
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
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
}

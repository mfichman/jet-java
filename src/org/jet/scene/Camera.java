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

/**
 * Places a camera within the scene graph.  The camera can be made active,
 * and thus begin rendering the scene from that vantage point, by calling
 * setActive().
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class Camera extends SceneNode {
    private float fieldOfView;
    private float farClippingDistance;
    private float nearClippingDistance;
    private boolean active;

    @Override
    public void visit(Functor functor) {
        functor.visit(this);
    }

    /**
     * The field of view is the angle of the view frustum in degrees.  It
     * controls the wedge that is visible from this camera.
     * @return the field of view
     */
    public float getFieldOfView() {
        return fieldOfView;
    }

    /**
     * Sets the field of view, in degrees.
     * @param fieldOfView the field of view
     */
    public void setFieldOfView(float fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    /**
     * Returns the clipping distance.  This is the maximum distance that an
     * object will be visible from.
     * @return the farClippingDistance
     */
    public float getFarClippingDistance() {
        return farClippingDistance;
    }

    /**
     * Sets the far clipping distance.  This is the maximum distance that an
     * object will be visible from.
     * @param farClippingDistance the farClippingDistance to set
     */
    public void setFarClippingDistance(float farClippingDistance) {
        this.farClippingDistance = farClippingDistance;
    }

    /**
     * Returns the near clipping distance.  This is the minimum distance that
     * an object will be visible from.
     * @return the nearClippingDistance
     */
    public float getNearClippingDistance() {
        return nearClippingDistance;
    }

    /**
     * Sets the near clipping distance.  This is the minimum distance that an
     * object will be visible from.
     * @param nearClippingDistance the nearClippingDistance to set
     */
    public void setNearClippingDistance(float nearClippingDistance) {
        this.nearClippingDistance = nearClippingDistance;
    }

    /**
     * Returns true if the camera is the camera currently used for rendering.
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Returns true if the camera is the camera currently used for rendering.
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}

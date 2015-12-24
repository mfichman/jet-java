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

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

/**
 * A scene node is an object that can be attached to the scene graph and
 * rendered by the renderer.
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public abstract class SceneNode {

    /**
     * The scene node functor provides an iterator for traversing the scene
     * graph using double dynamic dispatch.  By implementing the functor
     * interface, clients can iterate over the scene nodes.
     */
    public static interface Functor {
        public void visit(MeshObject node);
        public void visit(Camera camera);
        public void visit(ParticleSystem particleSystem);
        public void visit(QuadChain quadChain);
        public void visit(QuadSet quadSet);
        public void visit(AudioSource audioSource);
        public void visit(Light light);
        public void visit(CompoundNode transformNode);
    }

    private CompoundNode parent;
    private SceneNode root;
    private Vector3f position;
    private Quat4f rotation;
    private Matrix4f transform;

    /**
     * Returns the transform (rotation and translation) that affects this
     * scene node.
     * @return the transform DO NOT MODIFY!
     */
    public Matrix4f getTransform() {
        transform.set(rotation, position, 1.0f);
        return transform;
    }

    /**
     * Returns the position of this scene node relative to the parent node.
     * @return the position
     */
    public Vector3f getPosition() {
        return position;
    }

    /**
     * Sets the position of this scene node relative to the parent node.
     * @param position the position to set
     */
    public void setPosition(Vector3f position) {
        this.position = position;
    }

    /**
     * Returns the rotation of this scene node relative to the parent node.
     * @return the rotation
     */
    public Quat4f getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation of this scene node relative to the parent node.
     * @param rotation the rotation to set
     */
    public void setRotation(Quat4f rotation) {
        this.rotation = rotation;
    }

    /**
     * Returns the parent of this scene node.
     * @return the parent the parent of this scene node.
     */
    public CompoundNode getParent() {
        return parent;
    }

    /**
     * Sets the parent of this scene node.
     * @param Compound node
     */
    public void setParent(CompoundNode parent) {
        if (this.parent != null) {
            this.parent.removeChild(this);
        }
        this.parent = parent;
        if (this.parent != null) {
            this.parent.addChild(this);
            this.root = this.parent.getRoot();
        } else {
            this.root = null;
        }
    }

    /**
     * Returns the root node of the scene graph that this node belongs to.
     * @return the root
     */
    public SceneNode getRoot() {
        return root;
    }

    public abstract void visit(Functor functor);
}

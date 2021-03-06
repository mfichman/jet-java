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

import org.jet.resource.Mesh;
import org.jet.resource.Material;

/**
 * A mesh object is a triangle mesh with a material.
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class MeshObject extends SceneNode {

    private Material material;
    private Mesh mesh;

    /**
     * Returns the material, which controls the color, texture, and shading
     * technique of this object.
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets the material, which controls the color, texture, and shading
     * technique of this object.
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Returns the mesh, which contains the 3D point data for this object.
     * @return the mesh
     */
    public Mesh getMesh() {
        return mesh;
    }

    /**
     * Sets the mesh, which contains the 3D point data for this object.
     * @param mesh the mesh to set
     */
    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    @Override
    public void visit(Functor functor) {
        functor.visit(this);
    }
}

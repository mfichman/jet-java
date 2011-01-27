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

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.opengl.Texture;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class ResourceManager {

    private static Map<String, Texture> textures = new HashMap<String, Texture>();
    private static Map<String, Shader> shaders = new HashMap<String, Shader>();
    private static Map<String, Mesh> meshes = new HashMap<String, Mesh>();
    private static Map<String, Material> materials = new HashMap<String, Material>();
    private static Map<String, Audio> audios = new HashMap<String, Audio>();

    public static Texture getTexture(String name) {
        return textures.get(name);
    }

    public static Shader getShader(String name) {
        return shaders.get(name);
    }

    public static Mesh getMesh(String name) {
        return meshes.get(name);
    }

    public static Material getMaterial(String name) {
        return materials.get(name);
    }

    public static Audio getAudio(String name) {
        return audios.get(name);
    }
}

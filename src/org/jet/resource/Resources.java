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
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.MipMap.*;

/**
 * This class provides utilities for loading resources, and ensuring that they
 * only load once.
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class Resources {

    private static Map<String, Texture> textures = new HashMap<String, Texture>();
    private static Map<String, Shader> shaders = new HashMap<String, Shader>();
    private static Map<String, Mesh> meshes = new HashMap<String, Mesh>();
    private static Map<String, Material> materials = new HashMap<String, Material>();
    private static Map<String, Audio> audios = new HashMap<String, Audio>();

    /**
     * Returns the texture by name, and loads it if necessary.  This function
     * will search in the search directories in order for the first matching
     * file name.
     * @param name the name of the texture (not including directory)
     * @return the loaded texture
     * @throws RuntimeException if the texture wasn't loaded
     */
    public static Texture getTexture(String name) {
        Texture texture = textures.get(name);
        if (texture == null) {
            try {
                texture = TextureLoader.getTexture(getFileExtension(name), getResourceStream(name));

                textures.put(name, texture);

                // We have to go through some hoopla to get mipmaps enabled
                // using the slick loader
                int previousTexture = glGetInteger(GL_TEXTURE_BINDING_2D);

                // Get image attributes
                int width = texture.getTextureWidth();
                int height = texture.getTextureHeight();
                ByteBuffer data = ByteBuffer.wrap(texture.getTextureData());
                int components = data.position() / (width * height);
                data.rewind();
                int format = (components == 3) ? GL_RGB : GL_RGBA;

                // Bind the texture and set the texture attributes
                texture.bind();
                glTexEnvi(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_NEAREST);
                gluBuild2DMipmaps(GL_TEXTURE_2D, components, width, height, format, GL_UNSIGNED_BYTE, data);

                // Restore the original texture
                glBindTexture(GL_TEXTURE_2D, previousTexture);
            } catch (IOException ex) {
                throw new RuntimeException("Could not load texture " + name, ex);
            }
        }

        return texture;
    }

    /**
     * Returns the shader by name, and loads it if necessary.  This function
     * will search in the search directories in order for the first matching
     * file name.
     * @param name the name of the shader (not including directory)
     * @return the loaded shader
     * @throws RuntimeException if the shader wasn't loaded
     */
    public static Shader getShader(String name) {
        Shader shader = shaders.get(name);
        if (shader == null) {
            try {
                InputStream frag = getResourceStream(name + ".frag.glsl");
                InputStream vert = getResourceStream(name + ".vert.glsl");
                shader = ShaderLoader.getShader(vert, frag);
                shaders.put(name, shader);
            } catch (IOException ex) {
                throw new RuntimeException("Could not load shader " + name, ex);
            }
        }
        return shaders.get(name);
    }

    /**
     * Returns the mesh by name, and loads it if necessary.  This function will
     * search in the search directories in order for the first matching file
     * name.
     * @param name the name of the mesh (not including directory)
     * @return the loaded mesh
     * @throws RuntimeException if the mesh wasn't loaded
     */
    public static Mesh getMesh(String name) {
        Mesh mesh = meshes.get(name);
        if (mesh == null) {
            //try {
                mesh = MeshLoader.getMesh(getFileExtension(name), getResourceStream(name));
                meshes.put(name, mesh);
            //} catch (IOException ex) {
            //    throw new RuntimeException("Could not load mesh " + name, ex);
            //}
        }
        return meshes.get(name);
    }

    /**
     * Returns the material by name, and loads it if necessary.  This function
     * will search in the search directories in order for the first matching
     * file name.
     * @param name the name of the mesh (not including directory)
     * @return the loaded mesh
     * @throws RuntimeException if the material wasn't loaded
     */
    public static Material getMaterial(String name) {
        Material material = materials.get(name);
        if (material == null) {
            material = MaterialLoader.getMaterial(getFileExtension(name), getResourceStream(name));
            materials.put(name, material);
        }
        return materials.get(name);
    }

    /**
     * Returns the audio clip by name, and loads it if necessary.  This function
     * will search in the search directories in order for the first matching
     * file name.
     * @param name the name of the audio clip (not including directory)
     * @return the loaded audio clip
     * @throws RuntimeException if the audio clip wasn't loaded
     */
    public static Audio getAudio(String name) {
        Audio audio = audios.get(name);
        if (audio == null) {
            try {
                audio = AudioLoader.getAudio(getFileExtension(name), getResourceStream(name));
                audios.put(name, audio);
            } catch (IOException ex) {
                throw new RuntimeException("Could not load audio " + name, ex);
            }
        }
        return audios.get(name);
    }

    /**
     * Loads a scene graph from a file.  This loader is not cached; it will
     * reload the scene graph each time the function is called.
     * @param name the name of the scene
     * @return the loaded scene
     * @throws RuntimeException if the scene wasn't loaded
     */
    public static Scene getScene(String name) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns the suffix of name (i.e., everything after the last ".").
     * @param name a filename
     * @return the file extension, or the empty string if no "." is in the name
     */
    private static String getFileExtension(String name) {
        if (name.isEmpty()) {
            return "";
        }
        int index = name.lastIndexOf(".");
        if (index > 0) {
            return name.substring(index);
        } else {
            return "";
        }
    }

    /**
     * Returns an input stream to the given named resource by searching in
     * the resource search directories.
     * @param name the name of the resource
     * @return the input stream, for reading the resource
     * @throws RuntimeException if the file is not found
     */
    private static InputStream getResourceStream(String name) {
        InputStream in = Resources.class.getResourceAsStream(name);
        if (in == null) {
            throw new RuntimeException("Could not find resource: " + name);
        }
        return in;
    }
}

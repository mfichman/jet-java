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

import org.newdawn.slick.openal.Audio;

/**
 * This object places positional audio somewhere in the scene.
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class AudioSource extends SceneNode {

    private Audio audio;

    /**
     * Returns the audio clip used by this audio source.
     * @return the audio
     */
    public Audio getAudio() {
        return audio;
    }

    /**
     * Sets the audio clip used by this audio source.
     * @param audio the audio to set
     */
    public void setAudio(Audio audio) {
        this.audio = audio;
    }
    
    @Override
    public void visit(Functor functor) {
        functor.visit(this);
    }
}

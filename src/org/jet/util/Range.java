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

package org.jet.util;

/**
 * Represents a range (or interval) between two values.
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class Range {
    private float start;
    private float end;

    /**
     * Creates a new range object
     * @param start the beginning of the range
     * @param end the end of the range
     */
    public Range(float start, float end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the start of the range.
     * @return the start
     */
    public float getStart() {
        return start;
    }

    /**
     * Sets the start of the range.
     * @param start the start to set
     */
    public void setStart(float start) {
        this.start = start;
    }

    /**
     * Returns the end of the range.
     * @return the end
     */
    public float getEnd() {
        return end;
    }

    /**
     * Sets the end of the range.
     * @param end the end to set
     */
    public void setEnd(float end) {
        this.end = end;
    }
}

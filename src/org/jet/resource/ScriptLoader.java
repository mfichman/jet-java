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

import java.io.InputStream;
import java.io.InputStreamReader;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import net.java.games.input.Mouse;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author Matt Fichman <matt.fichman@gmail.com>
 */
public class ScriptLoader {

    private static ScriptEngine engine;
    
    /**
     * Returns the JavaScript scripting engine, which can be used for advanced
     * access to the scripting context.
     * @return
     */
    public ScriptEngine getEngine() {
        if (engine == null) {
            ScriptEngineManager factory = new ScriptEngineManager();
            engine = factory.getEngineByName("JavaScript");
            engine.getContext().setAttribute("Keyboard", Keyboard.class, ScriptContext.ENGINE_SCOPE);
            engine.getContext().setAttribute("ResourceManager", Resources.class, ScriptContext.ENGINE_SCOPE);
            engine.getContext().setAttribute("Mouse", Mouse.class, ScriptContext.ENGINE_SCOPE);
            engine.getContext().setAttribute("SceneManager", SceneManager.class, ScriptContext.ENGINE_SCOPE);
        }
        return engine;
    }

    /**
     * Loads the given script and returns the loading result.
     * @param in an input stream for the script
     * @return the result of running and loading the script.
     * @throws ScriptException if the script didn't execute properly
     */
    public Object getScript(InputStream in) throws ScriptException {
        return engine.eval(new InputStreamReader(in));
    }
}

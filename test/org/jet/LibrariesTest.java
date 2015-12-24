/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jet;

import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.extras.gimpact.GImpactCollisionAlgorithm;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.vecmath.Vector3f;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author Matt
 */
public class LibrariesTest {

    public LibrariesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void lwjgl() throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(800, 600));
        Display.setFullscreen(false);
        Display.setTitle("Hello LWJGL World!");
        Display.setIcon(new ByteBuffer[0]);
        Display.create();

        Keyboard.create();

        //Mouse.setGrabbed(true);
        Mouse.create();

        glClearColor(0, 0, 0, 0);
        glDisable(GL_DEPTH_TEST);
        glDisable(GL_LIGHTING);

        glCreateShader(GL_FRAGMENT_SHADER);

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            if (Display.isVisible()) {

            }
            Display.update();
            Display.sync(60);
        }
    }

    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void rhino() throws ScriptException, IOException, URISyntaxException {

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();
        context.setAttribute("name", "Matt", ScriptContext.ENGINE_SCOPE);
        engine.eval("println(name)");

        URL url = getClass().getResource("/org/jet/JSON.js");
        engine.eval(new InputStreamReader(url.openStream()));


        final String className = getClass().getSimpleName() + ".class";
        final String classPath = getClass().getResource(className).toString();

        if (classPath.startsWith("jar")) {
            String path = getClass().getResource("/org/jet").toString();
            System.out.println(path);
            String jarPath = path.substring(path.indexOf("/"), path.indexOf("!"));
            ZipFile zipFile = new JarFile(jarPath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                System.out.println(entry.getName());
            }
        } else {
            URL directory = getClass().getResource("/org/jet");
            for (String entry : new File(directory.toURI()).list()) {
                System.out.println(entry);
            }
        }
    }

    @Test
    public void jbullet() {
        CollisionConfiguration config = new DefaultCollisionConfiguration();
        CollisionDispatcher dispatcher = new CollisionDispatcher(config);
        DbvtBroadphase broadphase = new DbvtBroadphase();
        ConstraintSolver solver = new SequentialImpulseConstraintSolver();
        DynamicsWorld world = new DiscreteDynamicsWorld(dispatcher, broadphase, solver, config);
        world.setGravity(new Vector3f(0f, -10f, 0f));

        // More here
        GImpactCollisionAlgorithm.registerAlgorithm(dispatcher);
    }


}
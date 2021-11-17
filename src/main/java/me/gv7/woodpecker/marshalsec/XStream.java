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
package me.gv7.woodpecker.marshalsec;


import java.util.Comparator;

import me.gv7.woodpecker.marshalsec.gadgets.BindingEnumeration;
import me.gv7.woodpecker.marshalsec.gadgets.CommonsBeanutils;
import me.gv7.woodpecker.marshalsec.gadgets.CommonsConfiguration;
import me.gv7.woodpecker.marshalsec.gadgets.ImageIO;
import me.gv7.woodpecker.marshalsec.gadgets.JDKUtil;
import me.gv7.woodpecker.marshalsec.gadgets.LazySearchEnumeration;
import me.gv7.woodpecker.marshalsec.gadgets.Resin;
import me.gv7.woodpecker.marshalsec.gadgets.Rome;
import me.gv7.woodpecker.marshalsec.gadgets.ServiceLoader;
import me.gv7.woodpecker.marshalsec.gadgets.SpringAbstractBeanFactoryPointcutAdvisor;
import me.gv7.woodpecker.marshalsec.gadgets.SpringPartiallyComparableAdvisorHolder;
import me.gv7.woodpecker.marshalsec.gadgets.XBean;


/**
 * 
 * Not applicable:
 * - UnicastRefGadget,UnicastRemoteObjectGadget: don't think there is anything to gain here
 * 
 * @author mbechler
 *
 */
public class XStream extends MarshallerBase<String> implements CommonsConfiguration, Rome, CommonsBeanutils, ServiceLoader, ImageIO,
        BindingEnumeration, LazySearchEnumeration, SpringAbstractBeanFactoryPointcutAdvisor, SpringPartiallyComparableAdvisorHolder, Resin, XBean {

    /**
     * {@inheritDoc}
     *
     * @see MarshallerBase#marshal(java.lang.Object)
     */
    @Override
    public String marshal ( Object o ) throws Exception {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        return xs.toXML(o);
    }


    /**
     * {@inheritDoc}
     *
     * @see MarshallerBase#unmarshal(java.lang.Object)
     */
    @Override
    public Object unmarshal ( String data ) throws Exception {
        com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
        return xs.fromXML(data);
    }


    /**
     * {@inheritDoc}
     *
     * @see UtilFactory#makeComparatorTrigger(java.lang.Object, java.util.Comparator)
     */
    @Override
    public Object makeComparatorTrigger ( Object tgt, Comparator<?> cmp ) throws Exception {
        return JDKUtil.makePriorityQueue(tgt, cmp);
    }


    public static void main ( String[] args ) {
        new XStream().run(args);
    }
}

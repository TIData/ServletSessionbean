/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bram
 */
public class HelloBeanTest {
    
    public HelloBeanTest() {
    }

    /**
     * Test of hello method, of class HelloBean.
     */
    @Test
    public void testHello() throws Exception {
        System.out.println("hello");
        String name = "Bram";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        HelloBean instance = (HelloBean)container.getContext().lookup("java:global/classes/HelloBean");
        String expResult = "Hello Bram";
        String result = instance.hello(name);
        assertEquals(expResult, result);
        container.close();
        //fail("The test case is a prototype.");
    }
    
}

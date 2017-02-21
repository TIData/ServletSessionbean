/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.ejb.Stateless;

/**
 *
 * @author bram
 */
@Stateless
public class HelloBean {

    public String hello(String name) {
        return String.format("Hello %s", name);
    }
    
}

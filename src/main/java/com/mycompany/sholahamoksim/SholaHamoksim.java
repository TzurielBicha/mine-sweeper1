package com.mycompany.sholahamoksim;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 05267
 */
public class SholaHamoksim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MineSweeperLogics game = new MineSweeperLogics(5,8,9);
        } catch (Exception ex) {
            Logger.getLogger(SholaHamoksim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

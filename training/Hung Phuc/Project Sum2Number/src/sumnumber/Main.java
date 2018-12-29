/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumnumber;

import java.util.Scanner;

/**
 *
 * @author One-Piece
 */
public class Main implements IReceiver {
    
    public static void main(String[]args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBigNumberDisPlay().setVisible(true);
            }
        });
    }
	
    @Override
    public void send(String msg){
        System.out.println(msg);
    } 
}

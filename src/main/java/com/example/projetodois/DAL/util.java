package com.example.projetodois.DAL;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Miguel
 *
 */
public class util {

    private static Connection conn = null;

    public static Connection criarConexao() {

        if (conn != null) {
            return conn;
        } else {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("Oops! Can't find class oracle.jdbc.driver.OracleDriver");
                System.exit(-1);
            }

            try {
                conn = DriverManager.getConnection(
                        //VIVIAN
                        "jdbc:oracle:thin:@localhost:1521:XE", "PROJETOBD", "1234");
                //JOAO
                conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "PROJETOBD", "1234");//JOAO
                conn.setAutoCommit(false);
            } catch (Exception e) {
                System.out.println("ERRO " + e.getMessage());
                //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(-2);
            }

            return conn;
        }
    }

}

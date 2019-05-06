package ContactMenu;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.util.Scanner;

import ContactMenu.App;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testAppMain() {
        System.out.println("Start here");
        String[] args = null;
        String op1 = "1";
        String op2 = "2";
        String op3 = "3";
        String nome = "fulano";
        String ln = "\n";
        String all = op2 + ln + nome;
        ByteArrayInputStream inAll = new ByteArrayInputStream(all.getBytes());
        ByteArrayInputStream in1 = new ByteArrayInputStream(op1.getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream(op2.getBytes());
        ByteArrayInputStream in3 = new ByteArrayInputStream(op3.getBytes());
        ByteArrayInputStream inNome = new ByteArrayInputStream(nome.getBytes());
        ByteArrayInputStream inLn = new ByteArrayInputStream(ln.getBytes());
        System.setIn(in2);
        System.setIn(inNome);
        System.setIn(inNome);
        System.setIn(inNome);
        System.setIn(in1);
        System.setIn(inAll);

        App.main(args);

        //System.setIn(System.in);
        assertTrue(true);

    }
}

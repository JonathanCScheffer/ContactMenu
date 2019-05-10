package Tools;

import org.junit.*;

import static org.junit.Assert.*;

import Tools.CPFHandler;

/**
 * Unit tests for CPFHandler class.
 */
public class CPFHandlerTest{
    /**
     * Unit test for isValid method.
     */
    @Test
    public void testIsValid1True(){
        CPFHandler cpf = new CPFHandler("718.394.156-65");
        assertTrue(cpf.isValid());
    }

    @Test
    public void testIsValid1False(){
        CPFHandler cpf = new CPFHandler("123.456.789-00");
        assertFalse(cpf.isValid());
    }

    @Test
    public void testIsValid2True(){
        CPFHandler cpf = new CPFHandler("123.456.789-10");
        assertTrue("CPF not valid.", cpf.isValid("155.152.553-48"));
    }

    @Test
    public void testIsValid2False(){
        CPFHandler cpf = new CPFHandler("123.456.789-10");
        assertFalse("CPF not valid.", cpf.isValid("123.456.789-10"));
    }

}

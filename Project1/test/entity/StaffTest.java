/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class StaffTest {
    
    public StaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRollNumber method, of class Staff.
     */
    @Test
    public void testGetRollNumber() {
        System.out.println("getRollNumber");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getRollNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRollNumber method, of class Staff.
     */
    @Test
    public void testSetRollNumber() {
        System.out.println("setRollNumber");
        String rollNumber = "";
        Staff instance = new Staff();
        instance.setRollNumber(rollNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Staff.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Staff.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Staff instance = new Staff();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGender method, of class Staff.
     */
    @Test
    public void testIsGender() {
        System.out.println("isGender");
        Staff instance = new Staff();
        boolean expResult = false;
        boolean result = instance.isGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class Staff.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        boolean gender = false;
        Staff instance = new Staff();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDob method, of class Staff.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getDob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDob method, of class Staff.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        String dob = "";
        Staff instance = new Staff();
        instance.setDob(dob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Staff.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Staff.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Staff instance = new Staff();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMobile method, of class Staff.
     */
    @Test
    public void testGetMobile() {
        System.out.println("getMobile");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getMobile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMobile method, of class Staff.
     */
    @Test
    public void testSetMobile() {
        System.out.println("setMobile");
        String mobile = "";
        Staff instance = new Staff();
        instance.setMobile(mobile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorkMobile method, of class Staff.
     */
    @Test
    public void testGetWorkMobile() {
        System.out.println("getWorkMobile");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getWorkMobile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWorkMobile method, of class Staff.
     */
    @Test
    public void testSetWorkMobile() {
        System.out.println("setWorkMobile");
        String workMobile = "";
        Staff instance = new Staff();
        instance.setWorkMobile(workMobile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Staff.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Staff.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Staff instance = new Staff();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Staff.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Staff instance = new Staff();
        long expResult = 0L;
        long result = instance.getSalary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Staff.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        long salary = 0L;
        Staff instance = new Staff();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Staff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Staff instance = new Staff();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

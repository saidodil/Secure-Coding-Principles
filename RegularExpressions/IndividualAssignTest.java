/*
 * Course: TCSS483 Secure Coding Principles
 * File Name: IndividualAssignTest.java
 * Assignment: Individual Assignment
 * Due Date: 15 July 2022
 * Instructor: Tom Capaul
 */

/**
 * Test class for IndividualAssing.java
 *
 * @author Dilnoza Saidova
 * @version 15 July 2022
 */
import static org.junit.jupiter.api.Assertions.*;

class IndividualAssignTest {
    IndividualAssign id = new IndividualAssign();
    private String str = "";
    private Boolean result;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        str = "";
        result = false;
    }

    @org.junit.jupiter.api.Test
    void checkSSN() {
        str = "123456789";
        result = id.checkSSN(str);
        assertEquals(true, result);

        str = "123-45-6789";
        result = id.checkSSN(str);
        assertEquals(true, result);

        str = "12345678";
        result = id.checkSSN(str);
        assertEquals(false, result);

        str = "123-45-678";
        result = id.checkSSN(str);
        assertEquals(false, result);

        str = "12345678";
        result = id.checkSSN(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkPhone() {
        str = "123-456-7809";
        result = id.checkPhone(str);
        assertEquals(true, result);

        str = "(123)456-7809";
        result = id.checkPhone(str);
        assertEquals(true, result);

        str = "123 456 7809";
        result = id.checkPhone(str);
        assertEquals(true, result);

        str = "123-45-678";
        result = id.checkPhone(str);
        assertEquals(false, result);

        str = "12345678";
        result = id.checkPhone(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkEmail() {
        str = "saidodil@uw.edu";
        result = id.checkEmail(str);
        assertEquals(true, result);

        str = "saidodil@uw.education";
        result = id.checkEmail(str);
        assertEquals(false, result);

        str = "saidodil.uw.edu";
        result = id.checkEmail(str);
        assertEquals(false, result);

        str = "saido.dil@uw.edu";
        result = id.checkEmail(str);
        assertEquals(false, result);

        str = "123@uw.edu";
        result = id.checkEmail(str);
        assertEquals(true, result);
    }

    @org.junit.jupiter.api.Test
    void checkName() {
        str = "Saidova, Dilnoza, B";
        result = id.checkName(str);
        assertEquals(true, result);

        str = "Saidova, Dilnoza B";
        result = id.checkName(str);
        assertEquals(false, result);

        str = "Saidova Dilnoza B";
        result = id.checkName(str);
        assertEquals(false, result);

        str = "Saidova, Dilnoza";
        result = id.checkName(str);
        assertEquals(true, result);

        str = "Saidova Dilnoza, B";
        result = id.checkName(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkDate() {
        str = "10/01/2002";
        result = id.checkDate(str);
        assertEquals(true, result);

        str = "12/12/9999";
        result = id.checkDate(str);
        assertEquals(true, result);

        str = "07152022";
        result = id.checkDate(str);
        assertEquals(false, result);

        str = "2022/02/18";
        result = id.checkDate(str);
        assertEquals(false, result);

        str = "20/20/2022";
        result = id.checkDate(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkCity() {
        str = "Olympia, WA 98000";
        result = id.checkCity(str);
        assertEquals(true, result);

        str = "Olympia, WA, 98000";
        result = id.checkCity(str);
        assertEquals(true, result);

        str = "Olympia WA 98000";
        result = id.checkCity(str);
        assertEquals(false, result);

        str = "Olympia, WA";
        result = id.checkCity(str);
        assertEquals(false, result);

        str = "WA 98000";
        result = id.checkCity(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkTime() {
        str = "00:00:01";
        result = id.checkTime(str);
        assertEquals(true, result);

        str = "23:59:59";
        result = id.checkTime(str);
        assertEquals(true, result);

        str = "20:01";
        result = id.checkTime(str);
        assertEquals(true, result);

        str = "24:00:01";
        result = id.checkTime(str);
        assertEquals(false, result);

        str = "12:5:01";
        result = id.checkTime(str);
        assertEquals(true, result);

    }

    @org.junit.jupiter.api.Test
    void checkMoney() {
        str = "$123456789";
        result = id.checkMoney(str);
        assertEquals(false, result);

        str = "$123,456,789.09";
        result = id.checkMoney(str);
        assertEquals(true, result);

        str = "$12.0002";
        result = id.checkMoney(str);
        assertEquals(false, result);

        str = "-$0.00";
        result = id.checkMoney(str);
        assertEquals(false, result);

        str = "12.02";
        result = id.checkMoney(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkURL() {
        str = "http://www.uw.edu";
        result = id.checkURL(str);
        assertEquals(true, result);

        str = "www.uw.edu";
        result = id.checkURL(str);
        assertEquals(true, result);

        str = "uw.edu";
        result = id.checkURL(str);
        assertEquals(true, result);

        str = "www.uw.education";
        result = id.checkURL(str);
        assertEquals(false, result);

        str = "http://uw.edu";
        result = id.checkURL(str);
        assertEquals(true, result);
    }

    @org.junit.jupiter.api.Test
    void checkPassword() {
        str = "1!aBfakdfa";
        result = id.checkPassword(str);
        assertEquals(true, result);

        str = "1!bB11111111a";
        result = id.checkPassword(str);
        assertEquals(true, result);

        str = "1!afakd";
        result = id.checkPassword(str);
        assertEquals(false, result);

        str = "1!Ab";
        result = id.checkPassword(str);
        assertEquals(false, result);

        str = "!afaDfafdafdkd";
        result = id.checkPassword(str);
        assertEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    void checkIon() {
        str = "cation";
        result = id.checkIon(str);
        assertEquals(false, result);

        str = "ion";
        result = id.checkIon(str);
        assertEquals(true, result);

        str = "cattion";
        result = id.checkIon(str);
        assertEquals(true, result);

        str = "baton";
        result = id.checkIon(str);
        assertEquals(false, result);

        str = "ionic";
        result = id.checkIon(str);
        assertEquals(false, result);
    }
}
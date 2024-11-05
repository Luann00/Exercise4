package qm;

/*
 * SPDX-FileCopyrightText: 2024 Luan Zekiri
 *
 * SPDX-License-Identifier: MIT
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MyMathsTest {
    MyMaths m;

    @Test
    void testStatementCoverage() {
    m = new MyMaths();
    assertEquals(1, m.gcd(3,10));
    }

    @Test
    void testBranchCoverage() {
        m = new MyMaths();
        assertEquals(1, m.gcd(3,10));
        assertEquals(7, m.gcd(7,7));

    }


}
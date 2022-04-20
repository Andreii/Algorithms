/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.ctci.Arrays_and_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class _1_3_URLifyTest {

    @Test
    void URLify() {
        _1_3_URLify c = new _1_3_URLify();
        assertEquals(c.URLify("Mr John Smith     "), "Mr%20John%20Smith");
    }
}
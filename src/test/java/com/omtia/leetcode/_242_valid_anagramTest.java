/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._242_valid_anagram;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _242_valid_anagramTest {

    @Test
    void isAnagram_shouldWorkForBaseCase() {
        // given
        _242_valid_anagram c = new _242_valid_anagram();

        // when
        boolean result = c.isAnagram("anagram", "magrana");
        boolean result2 = c.isAnagramChars("anagram", "magrana");
        boolean result3 = c.isAnagramSort("anagram", "magrana");

        // then
        assertThat(result).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @Test
    void isAnagram_shouldWorkForInvalid() {
        // given
        _242_valid_anagram c = new _242_valid_anagram();

        // when
        boolean result = c.isAnagram("rat", "car");
        boolean result2 = c.isAnagramChars("rat", "car");
        boolean result3 = c.isAnagramSort("rat", "car");

        // then
        assertThat(result).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }
}
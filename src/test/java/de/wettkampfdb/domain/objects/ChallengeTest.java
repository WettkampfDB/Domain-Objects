/*
 * Copyright (c) 2020 - Sebastian Ullrich (wettkampfdb.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package de.wettkampfdb.domain.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class ChallengeTest
{
    @Test
    @DisplayName("Should construct challenge via builder")
    void testBuilder ()
    {
        Challenge challenge = Challenge.builder()
            .name("Test Marathon")
            .startTime(LocalDateTime.of(LocalDate.now(), LocalTime.NOON))
            .build();

        assertThat(challenge.getName()).isEqualTo("Test Marathon");
        assertThat(challenge.getStartTime()).isEqualTo(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
    }

    @Test
    @DisplayName("Should construct challenge via setters")
    void testSetters ()
    {
        Challenge challenge = new Challenge();
        challenge.setName("Test Marathon");
        challenge.setStartTime(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));

        assertThat(challenge.getName()).isEqualTo("Test Marathon");
        assertThat(challenge.getStartTime()).isEqualTo(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
    }
}
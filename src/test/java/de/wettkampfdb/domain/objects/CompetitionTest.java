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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.validation.Validator;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CompetitionTest
{
    @Test
    @DisplayName("Should construct competition via builder")
    void testBuilder () throws MalformedURLException
    {
        Competition competition = Competition.builder()
            .name("Test Marathon")
            .startDate(LocalDate.now())
            .endDate(LocalDate.now())
            .url("https://www.wettkampfdb.de")
            .build();

        assertThat(competition.getName()).isEqualTo("Test Marathon");
        assertThat(competition.getStartDate()).isEqualTo(LocalDate.now());
        assertThat(competition.getEndDate()).isEqualTo(LocalDate.now());
        assertThat(competition.getUrl().toExternalForm()).isEqualTo("https://www.wettkampfdb.de");
    }

    @Test
    @DisplayName("Should construct competition via setters")
    void testSetters () throws MalformedURLException
    {
        Competition competition = new Competition();
        competition.setName("Test Marathon");
        competition.setStartDate(LocalDate.now());
        competition.setEndDate(LocalDate.now());
        competition.setUrl("https://www.wettkampfdb.de");

        assertThat(competition.getName()).isEqualTo("Test Marathon");
        assertThat(competition.getStartDate()).isEqualTo(LocalDate.now());
        assertThat(competition.getEndDate()).isEqualTo(LocalDate.now());
        assertThat(competition.getUrl().toExternalForm()).isEqualTo("https://www.wettkampfdb.de");
    }
}
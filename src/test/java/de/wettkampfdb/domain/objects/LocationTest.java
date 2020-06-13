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

import com.neovisionaries.i18n.CountryCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest
{
    @Test
    @DisplayName("Should construct location via builder")
    void testBuilder ()
    {
        Location location = Location.builder()
            .city("Berlin")
            .postCode("10115")
            .address("Brandenburger Tor")
            .countryCode(CountryCode.DE)
            .build();

        assertThat(location.getCity()).isEqualTo("Berlin");
        assertThat(location.getPostCode()).isEqualTo("10115");
        assertThat(location.getAddress()).isEqualTo("Brandenburger Tor");
        assertThat(location.getCountryCode()).isEqualTo(CountryCode.DE);
    }

    @Test
    @DisplayName("Should construct location via setters")
    void testSetters ()
    {
        Location location = new Location();
        location.setCity("Berlin");
        location.setPostCode("10115");
        location.setAddress("Brandenburger Tor");
        location.setCountryCode(CountryCode.DE);

        assertThat(location.getCity()).isEqualTo("Berlin");
        assertThat(location.getPostCode()).isEqualTo("10115");
        assertThat(location.getAddress()).isEqualTo("Brandenburger Tor");
        assertThat(location.getCountryCode()).isEqualTo(CountryCode.DE);
    }
}
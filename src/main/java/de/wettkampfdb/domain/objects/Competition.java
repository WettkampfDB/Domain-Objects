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

import lombok.*;
import lombok.experimental.Tolerate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

/**
 * Domain object to represent sport competitions.
 * <p>
 * Instances of this class are intended for the exchange of data between
 * multiple services of the WettkampfDB domain.
 *
 * @author Sebastian Ullrich
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Competition
{
    /**
     * Name of the competition as defined by the organizer.
     */
    @NotBlank
    private String name;

    /**
     * Date when the competition (earliest challenge) starts.
     */
    @NotNull
    private LocalDate startDate;

    /**
     * Date when the competition (latest challenge) ends.
     */
    @NotNull
    private LocalDate endDate;

    /**
     * Collection of challenges the competition consists of.
     * <p>
     * Usually all competitions (e.g. annually held marathons) offer other
     * challenges besides the "main" challenge. For example, most marathon
     * competitions are most likely to offer a half-marathon as well.
     *
     * <pre>
     *                     ┌── City Marathon
     *     City Marathon ──┼── City Half Marathon
     *                     └── City 10km Run
     * </pre>
     */
    @NotEmpty
    @Singular
    private List<Challenge> challenges;

    /**
     * Location of the competition.
     */
    @NotNull
    private Location location;

    /**
     * URL to the official website of the competition.
     */
    @NotNull
    private URL url;

    /**
     * Convenience setter for setting {@code url} from {@code String}.
     *
     * @param url the {@code String} to parse as a URL
     */
    @Tolerate
    public void setUrl (String url)
    throws MalformedURLException
    {
        this.setUrl(new URL(url));
    }

    /**
     * Additional (convenience) builder implementations to be added to Lombok.
     */
    @SuppressWarnings("unused")
    public static class CompetitionBuilder
    {
        public CompetitionBuilder url (URL url)
        {
            this.url = url;
            return this;
        }

        public CompetitionBuilder url (String url)
        throws MalformedURLException
        {
            this.url = new URL(url);
            return this;
        }
    }
}

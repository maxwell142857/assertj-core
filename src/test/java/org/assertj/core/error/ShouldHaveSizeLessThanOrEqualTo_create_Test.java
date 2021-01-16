/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2021 the original author or authors.
 */
package org.assertj.core.error;

import static java.lang.String.format;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldHaveSizeLessThanOrEqualTo.shouldHaveSizeLessThanOrEqualTo;
import static org.assertj.core.presentation.StandardRepresentation.STANDARD_REPRESENTATION;

import org.assertj.core.description.Description;
import org.assertj.core.description.TextDescription;
import org.assertj.core.presentation.HexadecimalRepresentation;
import org.assertj.core.presentation.Representation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link ShouldHaveSizeLessThanOrEqualTo#create(Description, Representation)}</code>.
 *
 * @author Sandra Parsick
 * @author Georg Berky
 */
class ShouldHaveSizeLessThanOrEqualTo_create_Test {

  private ErrorMessageFactory factory;

  @BeforeEach
  void setUp() {
    factory = shouldHaveSizeLessThanOrEqualTo("abcd", 4, 2);
  }

  @Test
  void should_create_error_message() {
    // WHEN
    String message = factory.create(new TextDescription("Test"), STANDARD_REPRESENTATION);
    // THEN
    then(message).isEqualTo(format("[Test] %n"
                                   + "Expecting size of:%n"
                                   + "  \"abcd\"%n"
                                   + "to be less than or equal to 2 but was 4"));
  }

  @Test
  void should_create_error_message_with_hexadecimal_representation() {
    // WHEN
    String message = factory.create(new TextDescription("Test"), new HexadecimalRepresentation());
    // THEN
    then(message).isEqualTo(format("[Test] %n"
                                   + "Expecting size of:%n"
                                   + "  \"['0x0061', '0x0062', '0x0063', '0x0064']\"%n"
                                   + "to be less than or equal to 2 but was 4"));
  }
}

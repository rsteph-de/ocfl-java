/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2024 OCFL Java Implementers Group
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*
 * Copyright (C) 2008 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.ocfl.core.util.escape;
/**
 * NOTICE: This class is copied from Guava 28.2-jre to compile the modified PercentEscaper
 * and reduce dependencies.
 * 
 * An object that converts literal text into a format safe for inclusion in a particular context
 * (such as an XML document). Typically (but not always), the inverse process of "unescaping" the
 * text is performed automatically by the relevant parser.
 *
 * <p>For example, an XML escaper would convert the literal string {@code "Foo<Bar>"} into {@code
 * "Foo&lt;Bar&gt;"} to prevent {@code "<Bar>"} from being confused with an XML tag. When the
 * resulting XML document is parsed, the parser API will return this text as the original literal
 * string {@code "Foo<Bar>"}.
 *
 * <p>An {@code Escaper} instance is required to be stateless, and safe when used concurrently by
 * multiple threads.
 *
 * <p>Because, in general, escaping operates on the code points of a string and not on its
 * individual {@code char} values, it is not safe to assume that {@code escape(s)} is equivalent to
 * {@code escape(s.substring(0, n)) + escape(s.substring(n))} for arbitrary {@code n}. This is
 * because of the possibility of splitting a surrogate pair. The only case in which it is safe to
 * escape strings and concatenate the results is if you can rule out this possibility, either by
 * splitting an existing long string into short strings adaptively around {@linkplain
 * Character#isHighSurrogate surrogate} {@linkplain Character#isLowSurrogate pairs}, or by starting
 * with short strings already known to be free of unpaired surrogates.
 *
 * <p>The two primary implementations of this interface are {@code CharEscaper} and {@code
 * UnicodeEscaper}. They are heavily optimized for performance and greatly simplify the task of
 * implementing new escapers. It is strongly recommended that when implementing a new escaper you
 * extend one of these classes. If you find that you are unable to achieve the desired behavior
 * using either of these classes, please contact the Java libraries team for advice.
 *
 * <p>Popular escapers are defined as constants in classes like {@code HtmlEscapers} and 
 * {@code XmlEscapers}. To create your own escapers, use {@code CharEscaperBuilder}, 
 * or extend {@code CharEscaper} or {@code UnicodeEscaper}.
 *
 * @author David Beaumont
 * @since 15.0
 */


public abstract class Escaper {
  //@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
  /** Constructor for use by subclasses. */
  protected Escaper() {}

  /**
   * Returns the escaped form of a given literal string.
   *
   * <p>Note that this method may treat input characters differently depending on the specific
   * escaper implementation.
   *
   * <ul>
   *   <li>{@link UnicodeEscaper} handles <a href="http://en.wikipedia.org/wiki/UTF-16">UTF-16</a>
   *       correctly, including surrogate character pairs. If the input is badly formed the escaper
   *       should throw {@link IllegalArgumentException}.
   *   <li>{@code CharEscaper} handles Java characters independently and does not verify the input
   *       for well formed characters. A {@code CharEscaper} should not be used in situations where
   *       input is not guaranteed to be restricted to the Basic Multilingual Plane (BMP).
   * </ul>
   *
   * @param string the literal string to be escaped
   * @return the escaped form of {@code string}
   * @throws NullPointerException if {@code string} is null
   * @throws IllegalArgumentException if {@code string} contains badly formed UTF-16 or cannot be
   *     escaped for any other reason
   */
  public abstract String escape(String string);

}

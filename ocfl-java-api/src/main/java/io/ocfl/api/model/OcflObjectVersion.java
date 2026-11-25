/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019-2021 University of Wisconsin Board of Regents
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

package io.ocfl.api.model;

import io.ocfl.api.util.Enforce;
import java.time.OffsetDateTime;

/**
 * View of a specific version of an OCFL object that allows its files to be lazy-loaded.
 */
public class OcflObjectVersion {

    private final VersionDetails versionDetails;

    public OcflObjectVersion(VersionDetails versionDetails) {
        this.versionDetails = Enforce.notNull(versionDetails, "versionDetails cannot be null");
    }

    /**
     * The ObjectId of the version
     *
     * @return the ObjectVersionId of the version
     */
    public ObjectVersionId getObjectVersionId() {
        return versionDetails.getObjectVersionId();
    }

    /**
     * The object's id
     *
     * @return the object's id
     */
    public String getObjectId() {
        return versionDetails.getObjectId();
    }

    /**
     * The version number
     *
     * @return the version number
     */
    public VersionNum getVersionNum() {
        return versionDetails.getVersionNum();
    }

    /**
     * The timestamp of when the version was created
     *
     * @return created timestamp
     */
    public OffsetDateTime getCreated() {
        return versionDetails.getCreated();
    }

    /**
     * Optional description of the version
     *
     * @return VersionInfo or null
     */
    public VersionInfo getVersionInfo() {
        return versionDetails.getVersionInfo();
    }

    /**
     * Returns true only if the version is a mutable HEAD version that is used to stage changes.
     *
     * @return true if mutable HEAD
     */
    public boolean isMutable() {
        return versionDetails.isMutable();
    }

    @Override
    public String toString() {
        return "OcflObjectVersion{" + "versionDetails='" + versionDetails + "'}";
    }
}

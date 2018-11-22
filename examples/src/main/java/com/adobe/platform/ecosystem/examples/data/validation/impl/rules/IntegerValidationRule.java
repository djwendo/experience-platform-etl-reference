/*
 * ADOBE CONFIDENTIAL
 * __________________
 * Copyright 2018 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by all applicable intellectual property laws,
 * including trade secret and copyright laws.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 *
 *
 */
package com.adobe.platform.ecosystem.examples.data.validation.impl.rules;

import java.util.Optional;

/**
 * Concrete {@link SchemaValidationRule} for
 * following types
 * <pre>
 *     1. {@link Integer}
 *     2. {@link Short}
 *     3. {@link Byte}
 * </pre>
 *
 * @author vedhera on 11/12/2018.
 */
public class IntegerValidationRule extends SchemaValidationRule<Integer> {

    private Optional<Integer> minimum;

    private Optional<Integer> maximum;

    private IntegerValidationRule(){

    }

    /**
     * Implementation for
     * {@link java.lang.Integer} input types.
     */
    @Override
    public boolean apply(Integer value) {
        if(minimum.isPresent()) {
            if(value < minimum.get()) {
                return false;
            }
        }

        if(maximum.isPresent()) {
            if(value > maximum.get()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    public static IntegerValidationRule.Builder integerValidationRuleBuilder() {
        return new IntegerValidationRule.Builder();
    }

    /**
     *
     */
    public static class Builder {

        private IntegerValidationRule validationRule = new IntegerValidationRule();

        protected Builder() {
            this.validationRule.minimum = Optional.empty();
            this.validationRule.maximum = Optional.empty();
        }

        public IntegerValidationRule.Builder withMinimum(int minimum) {
            this.validationRule.minimum = Optional.of(minimum);
            return this;
        }

        public IntegerValidationRule.Builder withMaximum(int maximum) {
            this.validationRule.maximum = Optional.of(maximum);
            return this;
        }

        public SchemaValidationRule<Integer> build() {
            return this.validationRule;
        }

    }

    public Optional<Integer> getMinimum() {
        return minimum;
    }

    public Optional<Integer> getMaximum() {
        return maximum;
    }
}

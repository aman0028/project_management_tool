package org.basecamp.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom marker interface is created to annotate DTO attributes to distinguish if property is required or not.
 * This custom annotation is use for validation.
 * @author amans
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionalParam
{

}


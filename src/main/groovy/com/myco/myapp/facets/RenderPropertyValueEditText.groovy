package com.myco.myapp.facets

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.util.ReflectUtil
import woko.facets.builtin.all.RenderPropertyValueEditStripesText

import java.beans.PropertyDescriptor
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Uses an annotation in order to determine whether or not to use
 * a textarea on a String prop
 */
@FacetKey(name='renderPropertyValueEdit', profileId = 'all', targetObjectType = String.class)
class RenderPropertyValueEditText extends RenderPropertyValueEditStripesText {

    @Override
    boolean isTextArea() {
        // lookup for a @Textarea annotation
        String propertyName = getPropertyName()
        Class<?> owningClass = getOwningObject().getClass()
        PropertyDescriptor propertyDescriptor = ReflectUtil.getPropertyDescriptor(owningClass, propertyName)
        Method m = propertyDescriptor.getReadMethod();
        if (m.isAnnotationPresent(Textarea.class)) {
            return true
        }
        Field f = owningClass.getDeclaredField(propertyName)
        if (f != null && f.isAnnotationPresent(Textarea.class)) {
            return true
        }
        return false
    }

}

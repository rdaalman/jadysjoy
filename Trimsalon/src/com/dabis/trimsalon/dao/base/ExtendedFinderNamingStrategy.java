package com.dabis.trimsalon.dao.base;

import java.lang.reflect.Method;


/**
 * Looks up Hibernate named queries based on the simple name of the invoced class and the method name of the invocation
 */
public class ExtendedFinderNamingStrategy implements IFinderNamingStrategy
{
    // Always look for queries that start with findBy (even if method is iterateBy.. or scrollBy...)
    @SuppressWarnings("rawtypes")
	public String queryNameFromMethod(Class findTargetType, Method finderMethod)
    {
        String methodName = finderMethod.getName();
        String methodPart = methodName;
        if(methodName.startsWith("findBy")) {
            // No-op
        }
        else if(methodName.startsWith("listBy")) {
            methodPart = "findBy" + methodName.substring("listBy".length());
        }
        else if(methodName.startsWith("iterateBy")) {
            methodPart = "findBy" + methodName.substring("iterateBy".length());
        }
        else if(methodName.startsWith("scrollBy")) {
            methodPart = "findBy" + methodName.substring("scrollBy".length());
        }
        return findTargetType.getSimpleName() + "." + methodPart;
    }
}

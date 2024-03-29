package com.dabis.trimsalon.dao.base;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Iterator;

//import org.hibernate.ScrollableResults;

public interface IFinderExecutor<T>
{
    /**
     * Execute a finder method with the appropriate arguments
     */
    List<T> executeFinder(Method method, Object[] queryArgs);

    Iterator<T> iterateFinder(Method method, Object[] queryArgs);

//    ScrollableResults scrollFinder(Method method, Object[] queryArgs);
}

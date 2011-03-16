package com.dabis.trimsalon.dao.base;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor
{
	private static final long serialVersionUID = 1L;

	public FinderIntroductionAdvisor()
    {
        super(new FinderIntroductionInterceptor());
    }
}

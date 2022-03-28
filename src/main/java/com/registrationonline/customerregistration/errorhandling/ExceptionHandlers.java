package com.registrationonline.customerregistration.errorhandling;

import java.lang.annotation.Annotation;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlers implements ExceptionHandler
{
	@Override
	public Class<? extends Throwable>[] value()
	{
		return new Class[ 0 ];
	}

	@Override
	public boolean equals( Object obj )
	{
		return false;
	}

	@Override
	public int hashCode()
	{
		return 0;
	}

	@Override
	public String toString()
	{
		return null;
	}

	@Override
	public Class<? extends Annotation> annotationType()
	{
		return null;
	}
}

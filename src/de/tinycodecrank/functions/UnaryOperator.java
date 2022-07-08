package de.tinycodecrank.functions;

import de.tinycodecrank.functions.applicable.ApplicableLeft;
import de.tinycodecrank.functions.applicable.ApplicableRight;

@FunctionalInterface
public interface UnaryOperator<T> extends ApplicableLeft<T, Runnable>, ApplicableRight<T, Runnable>
{
	T apply(T t);
	
	@Override
	default Runnable aptFirst(T t)
	{
		return aptLast(t);
	}
	
	@Override
	default Runnable aptLast(T t)
	{
		return () -> apply(t);
	}
}
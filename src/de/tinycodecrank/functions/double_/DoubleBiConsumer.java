package de.tinycodecrank.functions.double_;

import de.tinycodecrank.functions.double_.applicable.DoubleApplicableLeft;
import de.tinycodecrank.functions.double_.applicable.DoubleApplicableRight;

@FunctionalInterface
public interface DoubleBiConsumer extends DoubleApplicableLeft<DoubleConsumer>, DoubleApplicableRight<DoubleConsumer>
{
	void accept(double a, double b);
	
	@Override
	default DoubleConsumer aptFirst(double a)
	{
		return z -> accept(a, z);
	}
	
	@Override
	default DoubleConsumer aptLast(double z)
	{
		return a -> accept(a, z);
	}
	
	/**
	 * @return a Function that accepts two arguments and does nothing
	 */
	public static DoubleBiConsumer sink()
	{
		return SINK;
	}
	
	static final DoubleBiConsumer SINK = (a, b) ->
	{};
}
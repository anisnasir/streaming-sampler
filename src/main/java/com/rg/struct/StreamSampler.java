package com.rg.struct;

import java.util.List;

public interface StreamSampler<T> {
	
	/**
	 * @param elements to the sampler
	 */
	public void add(T element);
	
	/**
	 * @return the sample in the form of the list
	 */
	public List<T> getStreamSample();
	
	/**
	 * @return size of the reservoir
	 */
	public int getSize();
    
}

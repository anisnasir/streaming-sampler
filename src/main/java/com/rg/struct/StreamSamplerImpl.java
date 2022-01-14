package com.rg.struct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rg.runner.Runner;

/**
 * 
 * @author anisnasir
 * 
 * Use reservoir sampling to returns the sample. Find details of the 
 * algorithm @see <a href="https://en.wikipedia.org/wiki/Reservoir_sampling">Reservoir_sampling</a> 
 *
 */
public class StreamSamplerImpl<T> implements StreamSampler<T>{
	private static final Logger logger = LoggerFactory.getLogger(StreamSamplerImpl.class);
	private final int size;
	private int itemCount;
	private List<T> reservoir;
	private Random rand;
	
	public StreamSamplerImpl(int size) { 
		this.size = size;
		this.itemCount = 0;
		reservoir = new ArrayList<T>();
		rand = new Random();
		logger.info("reservoir of size {} initialized", size);
	}
	
	/**
	 * This method implements the reservoir sampling, i.e., 
	 * add the items to the reservoir until the reservoir is full.
	 * Afterwards, flip a coin with probability size/itemCount+1, 
	 * to add the item in the reservoir.
	 */
	@Override
	public void add(T element) {
		//logger.info("item {} received", element.toString());
		itemCount++;
		if(itemCount <= size) { 
			//run this code until reservoir is full
			reservoir.add(element);
		} else if(Math.random() < (size/(double)itemCount)) {
			//find the index of the element to replace
			int index = rand.nextInt(size);
			//replace the element in the list
			reservoir.set(index, element);
		}
	}

	@Override
	public List<T> getStreamSample() {
		return new ArrayList<T>(reservoir);
	}

	@Override
	public int getSize() {
		return this.size;
	}

}

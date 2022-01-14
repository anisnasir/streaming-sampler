package com.rg.struct;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StreamSamplerTest {
	private StreamSampler<Character> streamSampler;
	private final String str = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
	private final int SAMPLE_SIZE = 5;
	
	@Before
	public void initialize() {
		streamSampler = new StreamSamplerImpl<Character>(SAMPLE_SIZE);
	}
	
	@Test
	public void sampleSizeTest() {
    	for(int i = 0; i<str.length();i++ ) { 
    		streamSampler.add(str.charAt(i));
    	}
    	assertEquals(SAMPLE_SIZE, streamSampler.getStreamSample().size());
	}
	
	@Test
	public void checkValidSample() {
		HashSet<Character> characterSet = new HashSet<Character>();
    	for(int i = 0; i<str.length();i++ ) { 
    		Character item = str.charAt(i);
    		streamSampler.add(item);
    		characterSet.add(item);
    	}
    	
    	List<Character> sample = streamSampler.getStreamSample();
    	for(Character c: sample) { 
    		assertTrue(characterSet.contains(c));
    	}
	}

}

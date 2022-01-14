package com.rg.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rg.struct.StreamSampler;
import com.rg.struct.StreamSamplerImpl;
import com.rg.utils.StringGenerator;

/**
 * The main class that starts the execution.
 *
 * @author anisnasir
 */
public class Runner {
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String args[]) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide the size of the sample");
        }

        int sampleSize = Integer.parseInt(args[0]);

        StreamSampler<Character> streamSampler = new StreamSamplerImpl<>(sampleSize);

        if (System.in.available() > 0) {
            //run this code if the input is piped to the script
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
                String inputString;
                while ((inputString = br.readLine()) != null) {
                    logger.info("Read {} ", inputString);
                    for (int i = 0; i < inputString.length(); i++) {
                        streamSampler.add(inputString.charAt(i));
                    }
                }
            } catch (IOException io) {
                logger.error("Exception caught while reading the piped input {}", io.getMessage());
            }
        } else {
            //Generate Random input from the script
            String inputString = StringGenerator.generateRandomString(256);
            logger.info("Generated String {} ", inputString);
            for (int i = 0; i < inputString.length(); i++) {
                streamSampler.add(inputString.charAt(i));
            }
        }

        logger.info("sample {}", streamSampler.getStreamSample());
    }


}

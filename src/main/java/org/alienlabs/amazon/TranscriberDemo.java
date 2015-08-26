/*
 * Copyright 1999-2013 Carnegie Mellon University.
 * Portions Copyright 2004 Sun Microsystems, Inc.
 * Portions Copyright 2004 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL
 * WARRANTIES.
 */
package org.alienlabs.amazon;

import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.result.WordResult;
import edu.cmu.sphinx.util.TimeFrame;

/**
 * A simple example that shows how to transcribe a continuous audio file that
 * has multiple utterances in it.
 */
public class TranscriberDemo {

    public static String transcribe() throws Exception {
        System.out.println("Loading models...");

        Configuration configuration = new Configuration();

        // Load model from the jar
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

        // You can also load model from folder
        // configuration.setAcousticModelPath("file:en-us");

        configuration
			.setDictionaryPath("resource:/org/alienlabs/amazon/cmudict.0.7a_SPHINX_40");
                //.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
			.setLanguageModelPath("resource:/org/alienlabs/amazon/cmusphinx-5.0-en-us.lm.bin");
                //.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(
                configuration);
        InputStream stream = TranscriberDemo.class.getResourceAsStream("test2.wav");
        //.getResourceAsStream("/edu/cmu/sphinx/demo/aligner/10001-90210-01803.wav");
        //stream.skip(44);

        // Simple recognition with generic model
        recognizer.startRecognition(stream);
        SpeechResult result;
        StringBuilder output = new StringBuilder();

        while ((result = recognizer.getResult()) != null) {

            System.out.format("Hypothesis: %s\n", result.getHypothesis());
			
			output.append
			(result.getHypothesis()).append
			(" from: ").append
			(result.getWords().get(0).getTimeFrame().getStart()).append
			(", to: ").append
			(result.getWords().get(0).getTimeFrame().getEnd()).append(" ");
			
            System.out.println("List of recognized words and their times:");
            for (WordResult r : result.getWords()) {
                System.out.println(r);
            }

            System.out.println("Best 3 hypothesis:");
            for (String s : result.getNbest(3))
                System.out.println(s);

        }
        recognizer.stopRecognition();
		System.out.println("### " + output.toString());
        return output.toString();
    }
}

/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.nlp.tokenizer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.List;

import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.Test;

import edu.emory.mathcs.nlp.common.constant.StringConst;
import edu.emory.mathcs.nlp.common.util.IOUtils;
import edu.emory.mathcs.nlp.common.util.Joiner;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class TokenizerDemo
{
	@Test
	@Ignore
	public void tokenizeRaw() throws Exception
	{
		Tokenizer tokenizer = new EnglishTokenizer();
		String inputFile = "src/test/resources/clearnlp-raw.txt";
		InputStream in = IOUtils.createFileInputStream(inputFile);
		
		for (List<String> tokens : tokenizer.segmentize(in))
			System.out.println(Joiner.join(tokens, StringConst.SPACE));
		
		in.close();
	}
	
	@Test
	@Ignore
	public void tokenizeLine() throws Exception
	{
		Tokenizer tokenizer = new EnglishTokenizer();
		String inputFile = "src/test/resources/clearnlp-line.txt";
		BufferedReader in = IOUtils.createBufferedReader(inputFile);
		List<String> tokens;
		String line;
		
		while ((line = in.readLine()) != null)
		{
			tokens = tokenizer.tokenize(line);
			System.out.println(Joiner.join(tokens, StringConst.SPACE));
		}
		
		in.close();
	}
}

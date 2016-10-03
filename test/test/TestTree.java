package test;
import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Before;
import org.junit.Test;

import binaryTree.LLNode;
import binaryTree.TreeReceiver;
import binaryTree.binaryTreeRunner;
public class TestTree {
	private binaryTreeRunner example;
	private LLNode<Character> sample;
	private LLNode<Character> exampleLLN;
	@Before
	public void before(){
		example = new binaryTreeRunner("Mississippi River");
		sample = new LLNode<Character>();
		exampleLLN = example.getHead();
		char[] testChar = new char[]{'m','r','v','e','p','s','i'};
		int[] testFreq = new int[]{1,1,1,1,2,4,5};
		for(int i = 0; i < testFreq.length; i++){
			LLNode<Character> pos = new LLNode<Character>(testChar[i], testFreq[i]);
			sample.addLLN(pos);
		}
	}
	
	@Test
	public void testSort(){
		LLNode<Character> pos = sample;
		LLNode<Character> exPos = exampleLLN;
		while(true){
			if (pos.getLink() == null)
				break;
			pos = pos.getLink();
		}
		while(true){
			if(exPos.getLink() == null)
				break;
			exPos = exPos.getLink();
		}
		assertEquals(5,exPos.getFreq());
	}
	
	//@Test
	/*
	public void testSort2(){
		LLNode<Character> pos = sample;
		LLNode<Character> exPos = exampleLLN;
		while(true){
			if (pos.getLink() == null)
				break;
			pos = pos.getLink();
		}
		while(true){
			if(exPos.getLink() == null)
				break;
			exPos = exPos.getLink();
		}
		assertEquals(1, exampleLLN.getFreq());
	}
	*/
	@Test
	public void testOutput(){
		TreeReceiver tr = new TreeReceiver(example.getTree());
		assertEquals("mississippi river", tr.decode(example.getCompression()));
	}
	
	@Test
	public void testOutput2(){
		String test = "Abcd one two three four five six seven eight nine ten eleven"
				+ " twelve THIRTEEN FOURTEEN fifteen sixteen seventeen eighteen nineteen twenty";
		binaryTreeRunner<Character> example2 = new binaryTreeRunner<Character>(test);
		TreeReceiver tr = new TreeReceiver(example2.getTree());
		System.out.println("Test string: " + test + "\nBinary: " + example2.getCompression() + " \nResult: "
		+ tr.decode(example2.getCompression()));
		assertEquals(test.toLowerCase(), tr.decode(example2.getCompression()));
	}
}

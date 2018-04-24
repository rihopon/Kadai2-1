/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

/* Anagram Game Application */

package com.toy.anagrams.lib;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of the logic for the Anagram Game application.
 */
final class StaticWordLibrary extends WordLibrary {

    private static final String[] WORD_LIST = {
    		"apple",
            "ant",
            "art",
            "blackboard",
            "bitmap",
            "cheese",
            "clone",
            "comet",
            "card",
            "dead",
            "diamond",
            "disney",
            "dynamic",
            "egg",
            "eclips",
            "excite",
            "fashon",
            "freedom",
            "head",
            "idea",
            "iland",
            "iphone",
            "internet",
            "java",
            "love",
            "max",
            "night",
            "octopus",
            "pet",
            "picnic",
            "pancake",
            "python",
            "rabbit",
            "smile",
            "special",
            "snake",
            "label",
            "live",
            "moon",
            "minute",
            "math",
            "hot",
            "victory",
            "university",
            "taxi",
            "commit"
        
        };

   /*private static final String[] SCRAMBLED_WORD_LIST = {
    		"plape",
            "tan",
            "rta",
            "labkborcakd",
            "pibtam",
            "shecee",
            "elocn",
            "otmce",
            "adcr",
            "aedd",
            "omiadnd",
            "ynisde",
            "nadmiyc",
            "geg",
            "cleipcs",
            "cietxe",
            "sfoanh",
            "oderefm",
            "ahde",
            "deia",
            "alind",
            "pnehoi",
            "nterinet",
            "avja",
            "ovle",
            "xma",
            "nghit",
            "uctoops",
            "pte",
            "icpcni",
            "npcaake",
            "tyhpon",
            "bbarit",
            "misle",
            "alpecsi",
            "naske",
            "abell",
            "leiv",
            "mnoo",
            "iumten",
            "atmh",
            "oht",
            "ictvyor",
            "ivueyrnsit",
            "axti",
            "mocmit"
    		
    };*/
   
   
    
    
    
    final static WordLibrary DEFAULT = new StaticWordLibrary();

    /**
     * Singleton class.
     */
    private StaticWordLibrary() {
    }

    /**
     * Gets the word at a given index.
     * @param idx index of required word
     * @return word at that index in its natural form
     */
    public String getWord(int idx) {
        return WORD_LIST[idx];
    }

    /**
     * Gets the word at a given index in its scrambled form.
     * @param idx index of required word
     * @return word at that index in its scrambled form
     */
    public String getScrambledWord(int idx,int level) {
    	String s = WORD_LIST[idx];
    	int[] ans = new int[s.length()];
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i=0; i<s.length(); i++){
    		list.add(i);
    	}
    	String s2 = new String("");
    	char[] ch = s.toCharArray();
    	Collections.shuffle(list);
    	if(level==0){  
    		ans[0] = 1;
    		ans[1] = 0;
        if(ans.length>=2){
        	for(int i=2; i<s.length(); i++){
        		ans[i] = i;
        	}
        }
    	}
    	if(level==1){
    	for(int i=0; i<s.length(); i++){
    		ans[i] = i;
    	}
    	int x = ans[list.get(0)];
    	ans[list.get(0)] = ans[list.get(1)];
    	ans[list.get(1)] = x;
    	}
    	if(level==2){
    	for(int i=0; i<s.length(); i++){
    		ans[i] = list.get(i);
    	}
    	}
    	for(int i=0; i<s.length(); i++){
    		s2 = s2 + ch[ans[i]];
    	}
        return s2;
    }

    /**
     * Gets the number of words in the library.
     * @return the total number of plain/scrambled word pairs in the library
     */
    public int getSize() {
        return WORD_LIST.length;
    }

    /**
     * Checks whether a user's guess for a word at the given index is correct.
     * @param idx index of the word guessed
     * @param userGuess the user's guess for the actual word
     * @return true if the guess was correct; false otherwise
     */
    public boolean isCorrect(int idx, String userGuess) {
        return userGuess.equals(getWord(idx));
    }

}

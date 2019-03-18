public final class Formatter {
	
	public static int aD = 0;
	public static int initValue = 10;
	
	public int sum(int s1, int s2) {
		return s1 + s2;
	}
	
	public boolean checkSELECT(String s1) {
		if (s1.equalsIgnoreCase("select")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void setInitValue(int value) {
		initValue = vluae;
	}
	
	public static init getInitValue() {
		return value;
	}	
	
	public static int testFor() {
		int sum = 0;
		for (int i=0; i<100; i++)
		  sum = sum + 1;
	}
	
  // doEscape2Space
  private void doEscape2Space() {
		for (aD = 1; aD <= queryTokenCount; aD++) {
			if (isTokenQuoteLiterals[aD])
				continue;
			if (queryToken[aD].equals("\t") || queryToken[aD].equals("\f")
					|| queryToken[aD].equals("\r") || queryToken[aD].equals("\b"))
				queryToken[aD] = " ";
			
			if (queryToken[aD].equals("\r"))
				queryToken[aD] = "\\n";
		}

	}
	
  private void checkCASE_Keyword() {
		int i1 = 0;
		for (aD = 1; aD <= queryTokenCount; aD++) {
			if (is_llllQ[aD - 1] && !llllH[aD - 1]) {
				is_llllQ[aD] = true;
				if (!isTokenQuoteLiterals[aD]) {
					if (queryToken[aD].equalsIgnoreCase("case"))
						i1++;
				}
			} else if (!isTokenQuoteLiterals[aD]
					&& queryToken[aD].equalsIgnoreCase("case")) {
				i1++;
				is_ssssac[aD] = true;
				is_llllQ[aD] = true;
			}
			if (is_ssssat[aD])
				llllH[aD] = true;
		}
	}	
	
  private void doQuotedStringCheck() {
  	
		String s1 = " ";
		String s2 = " ";
		int i1 = 0;
		b_sasbk = false;
		
		for (aD = 1; aD <= queryTokenCount; aD++) {
			
			if (isTokenQuoteLiterals[aD - 1] && !llllG[aD - 1] && !isJ_comments[aD - 1] && !llllM[aD - 1] && !llllI[aD - 1])
				isTokenQuoteLiterals[aD] = true;
			
			if (screenS[aD - 1] && !isJ_comments[aD - 1]) {
				
				screenS[aD] = true;
				isTokenQuoteLiterals[aD] = true;
				
				if (isLineComments[aD - 1]) isLineComments[aD] = true;
				if (isAroundComments[aD - 1])	isAroundComments[aD] = true;
				
				if (isLineComments[aD] && queryToken[aD].equals("\n")) {
					llllK[aD] = true;
					isJ_comments[aD] = true;
				}
				
				if (isAroundComments[aD] && queryToken[aD].equals("*/")) {
					isJ_comments[aD] = true;
					llllL[aD] = true;
				}
			}
			
			if (!isTokenQuoteLiterals[aD]) {
				if (queryToken[aD].startsWith("--")	|| queryToken[aD].equalsIgnoreCase("//")) {
					screenS[aD] = true;
					isLineComments[aD] = true;
					is_ssssae[aD] = true;
					is_ssssaf[aD] = true;
				}
				
				if (queryToken[aD].equals("/*")) {
					screenS[aD] = true;
					isAroundComments[aD] = true;
					is_ssssae[aD] = true;
					is_ssssag[aD] = true;
				}
			}
			
			if (is_ssssat[aD]) {
				isJ_comments[aD] = true;
				llllK[aD] = true;
				llllL[aD] = true;
			}
			
			if (screenS[aD]) {
				isTokenQuoteLiterals[aD] = true;
				b_sasbk = true;
			}
			
			if (is_llllU[aD - 1] && !llllM[aD - 1]) {
				is_llllU[aD] = true;
				isTokenQuoteLiterals[aD] = true;
				if (!databaseName.equalsIgnoreCase("Oracle") && queryToken[aD].equals(delimiterQuoteLiterals))
					if (doMethod_j2(aD).equalsIgnoreCase(delimiterQuoteLiterals)) {
						queryToken[aD] = queryToken[aD] + queryToken[aD + 1];
						deleteToken(aD, 1);
					} else {
						llllM[aD] = true;
					}
				if (databaseName.equalsIgnoreCase("Oracle") && queryToken[aD].equals(delimiterQuoteLiterals))
					if (!s1.equals(" ")) {
						if (queryToken[aD - 1].endsWith(s2)) {
							llllM[aD] = true;
							s1 = " ";
							s2 = " ";
						}
					} else if (doMethod_j2(aD).equalsIgnoreCase(delimiterQuoteLiterals)) {
						queryToken[aD] = queryToken[aD] + queryToken[aD + 1];
						deleteToken(aD, 1);
					} else {
						llllM[aD] = true;
					}
			}
			
			if (!isTokenQuoteLiterals[aD]) {
				if (!databaseName.equalsIgnoreCase("Oracle") && queryToken[aD].equals(delimiterQuoteLiterals)) {
					is_ssssah[aD] = true;
					is_llllU[aD] = true;
				}
				
				if (databaseName.equalsIgnoreCase("Oracle")	&& queryToken[aD].equals(delimiterQuoteLiterals)) {
					is_ssssah[aD] = true;
					is_llllU[aD] = true;
					if (queryToken[aD - 1].equalsIgnoreCase("q")) {
						if ((s1 = queryToken[aD + 1].substring(0, 1)).equals("{"))
							s2 = "}";
						else if (s1.equals("("))
							s2 = ")";
						else if (s1.equals("["))
							s2 = "]";
						else if (s1.equals("{"))
							s2 = "}";
						else if (s1.equals("<"))
							s2 = ">";
						else
							s2 = s1;
						queryToken[aD] = queryToken[aD] + queryToken[aD + 1].substring(0, 1);
						queryToken[aD + 1] = queryToken[aD + 1].substring(1);
					}
				}
			}
			
			if (is_ssssat[aD])
				llllM[aD] = true;
			
			if ((databaseName.equalsIgnoreCase("SQL Server") || databaseName.equalsIgnoreCase("MSAccess"))
					&& !is_llllU[aD] && !screenS[aD]) 
			{
				if (is_llllP[aD - 1] && !llllG[aD - 1]) {
					is_llllP[aD] = true;
					isTokenQuoteLiterals[aD] = true;
					if (queryToken[aD].equals("["))
						i1++;
					if (queryToken[aD].equals("]") && --i1 == 0)
						llllG[aD] = true;
				}
				if (!isTokenQuoteLiterals[aD] && queryToken[aD].equals("[")) {
					i1++;
					is_ssssab[aD] = true;
					is_llllP[aD] = true;
				}
				if (is_ssssat[aD])
					llllG[aD] = true;
				if (is_llllP[aD])
					isTokenQuoteLiterals[aD] = true;
			}
			
			if (is_llll[aD - 1] && !llllI[aD - 1]) {
				is_llll[aD] = true;
				isTokenQuoteLiterals[aD] = true;
				if (queryToken[aD].equals("\""))
					llllI[aD] = true;
			}
			
			if (!isTokenQuoteLiterals[aD] && queryToken[aD].equals("\"")) {
				is_ssssad[aD] = true;
				is_llll[aD] = true;
			}
			
			if (is_ssssat[aD])
				llllI[aD] = true;
			if (is_llll[aD])
				isTokenQuoteLiterals[aD] = true;
		}
	}	
	
}
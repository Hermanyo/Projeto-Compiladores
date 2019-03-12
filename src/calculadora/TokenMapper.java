package calculadora;

import java.util.*;

import calculadora.analysis.*;
import calculadora.node.*;

class TokenMapper extends ReversedDepthFirstAdapter
{
	HashMap<Node, Integer> lines = new HashMap<>();

        @Override
	public void defaultOut(Node node)
	{
		lines.put(node.parent(), lines.get(node));
	}

        @Override
	public void defaultCase(Node node)
	{
		if (node instanceof Token)
		{
			Token token = (Token)node;
			lines.put(node.parent(), token.getLine());
		}
	}

	public int getLine(Node node)
	{
		if (lines.containsKey(node))
		{
			return lines.get(node);
		}
		return -1;
	}
}